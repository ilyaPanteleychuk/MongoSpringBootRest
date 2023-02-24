package com.ilyapanteleychuk.mongorest.repository;

import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FamousPeopleRepository extends MongoRepository<FamousPeopleData, String> {

}
