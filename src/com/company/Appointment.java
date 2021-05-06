package com.company;

import java.util.Date;

public class Appointment {

    private int appo_id;
    private String patient_id;
    private String doctor_id;
    private int hospital_id;
    private int vaccine_id;
    private java.sql.Date first_date;
    private java.sql.Date second_date;

    public Appointment(int appo_id, String patient_id, String doctor_id, int hospital_id, int vaccine_id, java.sql.Date first_date, java.sql.Date second_date) {
        this.appo_id = appo_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.hospital_id = hospital_id;
        this.vaccine_id = vaccine_id;
        this.first_date = first_date;
        this.second_date = second_date;
    }

    public int getAppo_id() {
        return appo_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public int getVaccine_id() {
        return vaccine_id;
    }

    public Date getFirst_date() {
        return first_date;
    }

    public Date getSecond_date() {
        return second_date;
    }
}
