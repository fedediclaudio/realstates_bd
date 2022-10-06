package com.dbd.realstate.services;

import com.dbd.realstate.RealStateExcepction;
import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import com.dbd.realstate.repositories.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;

@Service
public class RealStatesServiceImpl implements RealStatesService{

    @Autowired
    private RealStateRepository repository;

    @Override
    @Transactional
    public RealState createRealState(RealState realState) throws RealStateExcepction {
        Long id = this.repository.saveRealState(realState);
        return this.repository.findRealStateById(id);
    }

    @Override
    public RealState getRealState(Long id) throws RealStateExcepction {
        return this.repository.getRealStateById(id);
    }

    @Override
    @Transactional
    public RealState updateRealState(RealState realState, Long id) throws RealStateExcepction  {
        RealState realState1 =  this.repository.findRealStateById(realState.getId());
        realState1.setAddress(realState.getAddress());
        realState1.setNumber(realState.getNumber());
        realState1.setName(realState.getName());
        realState1.setEmployees(realState.getEmployees());
        this.repository.updateRealState(realState1);
        return realState1;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) throws RealStateExcepction {
        Long id = this.repository.createEmployee(employee);
        return this.repository.getEmployeeById(employee.getId());
    }

    @Override
    @Transactional
    public Employee employeeWithDni(String dni) throws RealStateExcepction {
        return this.repository.getEmployeeByDni(dni);
    }

    @Override
    public boolean deleteEmployee(Long id) throws RealStateExcepction {
        Employee employee = this.repository.getEmployeeById(id);
        return this.repository.deleteEmployee(employee);
    }

    @Override
    public List<Employee> employeesWithCalificationGreatherThan(float calification) throws RealStateExcepction{
        return this.repository.employeesWithCalificationGreatherThan(calification);
    }
}
