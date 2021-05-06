package com.company;
// Author : Oğuzhan Birk
// Hospital Entity
public class Hospital {

    private int hospital_id;
    private String hospital_name;

    public Hospital(int hospital_id, String hospital_name) {
        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }
}
