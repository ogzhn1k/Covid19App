package com.company;
// Author : Oğuzhan Birk
// Vaccine entity
public class Vaccine {

    private int vaccine_id;
    private String vaccine_name;
    private String vaccine_country;
    private String vaccine_tech;

    public Vaccine(int vaccine_id, String vaccine_name, String vaccine_country, String vaccine_tech) {
        this.vaccine_id = vaccine_id;
        this.vaccine_name = vaccine_name;
        this.vaccine_country = vaccine_country;
        this.vaccine_tech = vaccine_tech;
    }

    public int getVaccine_id() {
        return vaccine_id;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public String getVaccine_country() {
        return vaccine_country;
    }

    public String getVaccine_tech() {
        return vaccine_tech;
    }
}
