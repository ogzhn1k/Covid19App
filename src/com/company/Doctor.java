package com.company;

public class Doctor {

    private String identity_number;
    private int hospital_id;

    public Doctor(String identity_number, int hospital_id) {
        this.identity_number = identity_number;
        this.hospital_id = hospital_id;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public int getHospital_id() {
        return hospital_id;
    }
}
