package com.dbd.realstate.repositories;

import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByDni(String dni);

    List<Employee> findByCalificationGreaterThanEqual(float calification);

    List<Employee> findByDniAndFullname(String dni, String fullname);

    List<Employee> findByDateOfAdmissionBetween(Date start, Date end);

    List<Employee> findByDateOfAdmissionIsNull();

    List<Employee> findByFullnameContaining(String fullname);

    List<Employee> findByCalificationOrderByFullnameDesc(float calification);

    List<Employee> findByRealState(RealState realState);

    List<Employee> findByRealState_name(String name);

    @Query(value = "from Employee where dni = ?1") //HQL
    Optional<Employee> customFindByDni(String dni);

    @Query(value = "select * from employee where dni = ?1", nativeQuery = true) //SQL
    Optional<Employee> custom2FindByDni(String dni);
}
