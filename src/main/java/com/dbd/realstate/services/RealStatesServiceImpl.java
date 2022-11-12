package com.dbd.realstate.services;

import com.dbd.realstate.RealStateExcepction;
import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import com.dbd.realstate.repositories.EmployeeRepository;
import com.dbd.realstate.repositories.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RealStatesServiceImpl implements RealStatesService{

    @Autowired
    private RealStateRepository realStateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public RealState createRealState(RealState realState) throws RealStateExcepction {
        //Inicio
        return this.realStateRepository.save(realState);
    }

    @Override
    public RealState getRealState(Long id) throws RealStateExcepction {
        Optional<RealState> realState = this.realStateRepository.findById(id);
        return realState.orElse(null);
    }

    @Override
    @Transactional()
    public RealState updateRealState(RealState realState) throws RealStateExcepction  {
        return this.realStateRepository.save(realState);
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) throws RealStateExcepction {
        return this.employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee employeeWithDni(String dni) throws RealStateExcepction {
        Optional<Employee> employee = this.employeeRepository.findByDni(dni);
        return employee.orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteEmployee(Long id) throws RealStateExcepction {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isPresent()) {
            this.employeeRepository.delete(employee.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> employeesWithCalificationGreatherThan(float calification) throws RealStateExcepction{
        return this.employeeRepository.findByCalificationGreaterThanEqual(calification);
    }
}
