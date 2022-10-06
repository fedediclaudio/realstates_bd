package com.dbd.realstate.model;

import java.util.Date;

public class LegalPerson extends Owner{

    private Date dateOfConstitution;

    private String ciut;

    public LegalPerson() {}

    public LegalPerson(String fullname, String number, String email, String nationality, String address, String cuit, Date dateOfConstitution) {
        super(fullname, number,email,nationality,address);
        this.ciut = cuit;
        this.dateOfConstitution = dateOfConstitution;
    }

    public Date getDateOfConstitution() {
        return dateOfConstitution;
    }

    public void setDateOfConstitution(Date dateOfConstitution) {
        this.dateOfConstitution = dateOfConstitution;
    }

    public String getCiut() {
        return ciut;
    }

    public void setCiut(String ciut) {
        this.ciut = ciut;
    }
}
