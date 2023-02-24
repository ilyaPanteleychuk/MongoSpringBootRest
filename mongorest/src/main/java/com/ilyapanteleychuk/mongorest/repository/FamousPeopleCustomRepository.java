package com.ilyapanteleychuk.mongorest.repository;

import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.PopularPeopleDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Repository
@RequiredArgsConstructor
public class FamousPeopleCustomRepository {
    
    private final FamousPeopleRepository famousPeopleRepository;
    private final MongoTemplate mongoTemplate;
    
    @PostConstruct
    private void createOnStartUp() {
        if (!mongoTemplate.collectionExists(FamousPeopleData.class)) {
            mongoTemplate.createCollection(FamousPeopleData.class);
        } else {
            mongoTemplate.dropCollection(FamousPeopleData.class);
            mongoTemplate.createCollection(FamousPeopleData.class);
        }
    }
    
    public void saveAll(List<FamousPeopleData> famousPersonData) {
        famousPeopleRepository.saveAll(famousPersonData);
    }
    
    public void deleteAll() {
        famousPeopleRepository.deleteAll();
    }
    
    public Page<FamousPeopleData> search(FamousPeopleSearchDto searchDto) {
        if (searchDto.getFrom() == null) {
            searchDto.setFrom(0);
        }
        if (searchDto.getSize() == null) {
            searchDto.setSize(10);
        }
        PageRequest pageRequest = PageRequest.of(searchDto.getFrom(),
                searchDto.getSize());
        Query mongoQuery = new Query().with(pageRequest);
        if (StringUtils.isNotBlank(searchDto.getFirstName())) {
            mongoQuery.addCriteria(where(FamousPeopleData.Fields.firstName)
                    .is(searchDto.getFirstName()));
        }
        if (StringUtils.isNotBlank(searchDto.getLastName())) {
            mongoQuery.addCriteria(where(FamousPeopleData.Fields.lastName)
                    .is(searchDto.getLastName()));
        }
        if (StringUtils.isNotBlank(searchDto.getPatronymic())) {
            mongoQuery.addCriteria(where(FamousPeopleData.Fields.patronymic)
                    .is(searchDto.getPatronymic()));
        }
        List<FamousPeopleData> famousPersonData = mongoTemplate
                .find(mongoQuery, FamousPeopleData.class);
        return PageableExecutionUtils.getPage(
                famousPersonData,
                pageRequest,
                () -> mongoTemplate.count(
                        (Query.of(mongoQuery).limit(-1).skip(-1)), FamousPeopleData.class));
    }
    
    public List<PopularPeopleDto> calculateStatistic() {
        List<PopularPeopleDto> mostPopularPeople = new ArrayList<>();
        MongoCollection<Document> mongoCollection = mongoTemplate
                .getCollection("famous_people");
        AggregateIterable<Document> result = mongoCollection.aggregate(
                Arrays.asList(
                        match(Filters.eq("isPep", true)),
                        group("$firstName",
                                Accumulators.sum("count", 1)),
                        sort(Sorts.descending("count")),
                        limit(10)));
        //map aggregation result to entity
        try (MongoCursor<Document> iterator = result.iterator()) {
            while (iterator.hasNext()) {
                Document document = iterator.next();
                PopularPeopleDto popularPeopleDto = PopularPeopleDto
                        .builder()
                        .firstName((String) document.get("_id"))
                        .amount(document.getInteger("count"))
                        .build();
                mostPopularPeople.add(popularPeopleDto);
            }
        }
        return mostPopularPeople;
    }
    
    @PreDestroy
    private void preDestroy() {
        mongoTemplate.dropCollection(FamousPeopleData.class);
    }
}
