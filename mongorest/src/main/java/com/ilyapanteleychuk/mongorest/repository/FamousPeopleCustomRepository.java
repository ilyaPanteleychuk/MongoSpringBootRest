package com.ilyapanteleychuk.mongorest.repository;

import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.MostPopularPeopleDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeople;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.mongodb.client.model.Aggregates.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Repository
@RequiredArgsConstructor
public class FamousPeopleCustomRepository {
    
    private final FamousPeopleRepository famousPeopleRepository;
    private final MongoTemplate mongoTemplate;
    
    @Value("mongo.collection.name")
    private String COLLECTION_NAME;
    
    @Value("mongo.database.name")
    private String DBNAME;
    
    @PostConstruct
    private void createOnStartUp(){
//        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("testdb");
//            boolean collectionExists = mongoDatabase.listCollectionNames()
//                    .into(new ArrayList<>()).contains("test2");
//            if (!collectionExists) {
//                mongoDatabase.createCollection("test2");
//            }else{
//                mongoDatabase.getCollection("test2").drop();
//                mongoDatabase.createCollection("test2");
//            }
//        }
    }
    
    public Page<FamousPeople> search(FamousPeopleSearchDto searchDto){
        if (searchDto.getFrom() == null){
            searchDto.setFrom(0);
        }
        if (searchDto.getSize() == null){
            searchDto.setSize(10);
        }
        PageRequest pageRequest = PageRequest.of(searchDto.getFrom(),
                searchDto.getSize());
        Query mongoQuery = new Query().with(pageRequest);
        if (StringUtils.isNotBlank(searchDto.getFirstName())){
            mongoQuery.addCriteria(where(FamousPeople.Fields.first_name)
                    .is(searchDto.getFirstName()));
        }
        if (StringUtils.isNotBlank(searchDto.getLastName())){
            mongoQuery.addCriteria(where(FamousPeople.Fields.last_name)
                    .is(searchDto.getLastName()));
        }
        if (StringUtils.isNotBlank(searchDto.getPatronymic())){
            mongoQuery.addCriteria(where(FamousPeople.Fields.patronymic)
                    .is(searchDto.getPatronymic()));
        }
        List<FamousPeople> famousPeople = mongoTemplate
                .find(mongoQuery, FamousPeople.class);
        return PageableExecutionUtils.getPage(
                famousPeople,
                pageRequest,
                () -> mongoTemplate.count(
                        (Query.of(mongoQuery).limit(-1).skip(-1)), FamousPeople.class));
    }
    
    public List<MostPopularPeopleDto> calculateStatistic() {
        List<MostPopularPeopleDto> mostPopularPeople = new ArrayList<>();
        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DBNAME);
            MongoCollection<Document> mongoCollection = mongoDatabase
                    .getCollection(COLLECTION_NAME);
            AggregateIterable<Document> result =  mongoCollection
                    .aggregate(Arrays.asList(
                            match(Filters.eq("isPep", true)),
                            group("$firstName",
                                    Accumulators.sum("count", 1)),
                            sort(Sorts.descending("count")),
                            limit(10)));
            try(MongoCursor<Document> iterator = result.iterator()) {
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    MostPopularPeopleDto mostPopularPeopleDto = MostPopularPeopleDto
                            .builder()
                            .firstName((String) document.get("_id"))
                            .amount(document.getInteger("count"))
                            .build();
                    mostPopularPeople.add(mostPopularPeopleDto);
                }
            }
        }
        return mostPopularPeople;
    }
    
    public void saveAll(List<FamousPeople> famousPeople){
        famousPeopleRepository.saveAll(famousPeople);
    }

//    public
//    @PreDestroy
//    private void preDestroy(){
//        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("testdb");
//            mongoDatabase.getCollection("test2").drop();
//        }
//    }
}
