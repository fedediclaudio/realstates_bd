package com.dbd.realstate.services;

import com.dbd.realstate.RealStateExcepction;
import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import org.bson.types.ObjectId;

import java.util.List;

public interface RealStatesService {

    public RealState createRealState(RealState realState) throws RealStateExcepction;

    public RealState getRealState(ObjectId id) throws RealStateExcepction;

    public RealState updateRealState(RealState realState) throws RealStateExcepction;

    public Employee createEmployee(Employee employee) throws RealStateExcepction;

    public boolean deleteEmployee(ObjectId id) throws RealStateExcepction;

    public Employee employeeWithDni(String dni) throws RealStateExcepction;

    public List<Employee> employeesWithCalificationGreatherThan(float calification) throws RealStateExcepction;
}
