package com.dbd.realstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
public class RealState {

    @MongoId
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    @Field
    private String name;

    @Field
    private String cuil;

    @Field
    private String number;

    @Field
    private String address;

    @Field
    private int numberOfEmployees;

    @DBRef // Field para embeber
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<Employee>();

    @BsonIgnore // Ignora esta propiedad, ya que no estan mapeadas las Propiedades en esta muesta
    private List<Property> propertyList;

    @Version
    private int version;

    public RealState() {}

    public RealState(String name, String cuil, String number, String address, int numberOfEmployees) {
        this.name = name;
        this.cuil = cuil;
        this.number = number;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.propertyList = new ArrayList<Property>();
    }

    public RealState(ObjectId id, String name, String cuil, String number, String address, int numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.cuil = cuil;
        this.number = number;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.propertyList = new ArrayList<Property>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public void setVersion(int version) { this.version = version;}

    public int getVersion() { return this.version;}

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
