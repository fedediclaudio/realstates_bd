package com.dbd.realstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "real_state")
public class RealState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_real_state")
    private Long id;

    @Column(name="name", insertable = true, length = 50, nullable = false,
            table = "real_state", updatable = true, unique = false)
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String cuil;

    @Column(length = 20)
    private String number;

    @Column(length = 100)
    private String address;

    @Column(name = "number_of_employees")
    private int numberOfEmployees;

    @Transient // Evitamos que se mapee ya que no estamos trabajando esta relacion.
    private List<Property> propertyList;

    @OneToMany(mappedBy = "realState", fetch = FetchType.LAZY, cascade = {}, orphanRemoval = false)
    @JsonIgnore
    private List<Employee> employees;

    public RealState() {}

    public RealState(String name, String cuil, String number, String address, int numberOfEmployees) {
        this.name = name;
        this.cuil = cuil;
        this.number = number;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.employees = new ArrayList<Employee>();
        this.propertyList = new ArrayList<Property>();
    }

    public RealState(Long id, String name, String cuil, String number, String address, int numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.cuil = cuil;
        this.number = number;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.employees = new ArrayList<Employee>();
        this.propertyList = new ArrayList<Property>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
