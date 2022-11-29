package com.dbd.realstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Document
public class Employee {

    @MongoId
    @JsonSerialize(using= ToStringSerializer.class) //Para mostrar en forma de String en la respuesta HTTP
    private ObjectId id;

    @Field(name = "fullname") //Revisar todas las propiedades
    private String fullname;

    @Field
    private String dni;

    @Field
    private float calification;

    @Field
    private Date dateOfAdmission;

    @Field // DBRef para mantener la referencia
    @JsonBackReference
    private RealState realState;

    public Employee(String fullname, String dni, float calification, Date dateOfAdmission, RealState realState) {
        this.fullname = fullname;
        this.dni = dni;
        this.calification = calification;
        this.dateOfAdmission = dateOfAdmission;
        this.realState = realState;
    }

    public Employee() {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getCalification() {
        return calification;
    }

    public void setCalification(float calification) {
        this.calification = calification;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public RealState getRealState() {
        return realState;
    }

    public void setRealState(RealState realState) {
        this.realState = realState;
    }
}
