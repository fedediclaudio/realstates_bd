package com.dbd.realstate.repositories;

import com.dbd.realstate.model.RealState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateRepository extends CrudRepository<RealState, Long> {

}

