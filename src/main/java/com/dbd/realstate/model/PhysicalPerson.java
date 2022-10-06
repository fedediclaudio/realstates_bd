package com.dbd.realstate.model;

import java.util.Date;

public class PhysicalPerson extends Owner{

    private String ciul;

    private Date dateOfBirth;

    public PhysicalPerson() {}

    public PhysicalPerson(String fullname, String number, String email, String nationality, String address, String cuil, Date dateOfBirth) {
        super(fullname, number,email,nationality,address);
        this.ciul = cuil;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCiul() {
        return ciul;
    }

    public void setCiul(String ciul) {
        this.ciul = ciul;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
