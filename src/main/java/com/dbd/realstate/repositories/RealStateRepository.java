package com.dbd.realstate.repositories;

import com.dbd.realstate.model.RealState;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateRepository extends MongoRepository<RealState, ObjectId> {

}

