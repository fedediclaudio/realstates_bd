package com.dbd.realstate.repositories;

import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    Optional<Employee> findByDni(String dni);

    List<Employee> findByCalificationGreaterThanEqual(float calification);

    List<Employee> findByDniAndFullname(String dni, String fullname);

    List<Employee> findByDateOfAdmissionBetween(Date start, Date end);

    List<Employee> findByDateOfAdmissionIsNull();

    List<Employee> findByFullnameContaining(String fullname);

    List<Employee> findByCalificationOrderByFullnameDesc(float calification);

    List<Employee> findByRealState(RealState realState);

    List<Employee> findByRealState_name(String name);

    @Query(value = "")
    Optional<Employee> customFindByDni(String dni);
}
