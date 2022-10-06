package com.dbd.realstate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee")
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullname;

    @Column(unique = true, nullable = false, updatable = false, length = 8)
    private String dni;

    @Column()
    private float calification;

    @Column(updatable = false, name = "date_of_admission", nullable = true)
    private Date dateOfAdmission;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "id_real_state", nullable = false)
    private RealState realState;

    public Employee(String fullname, String dni, float calification, Date dateOfAdmission, RealState realState) {
        this.fullname = fullname;
        this.dni = dni;
        this.calification = calification;
        this.dateOfAdmission = dateOfAdmission;
        this.realState = realState;
    }

    public Employee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
