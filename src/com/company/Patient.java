package com.company;

public class Patient {
    private String identity_number;
    private String allergy_info;
    private String chronic_info;
    private String pregnancy;

    public Patient(String identity_number, String allergy_info, String chronic_info, String pregnancy) {
        this.identity_number = identity_number;
        this.allergy_info = allergy_info;
        this.chronic_info = chronic_info;
        this.pregnancy = pregnancy;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public String getAllergy_info() {
        return allergy_info;
    }

    public String getChronic_info() {
        return chronic_info;
    }

    public String getPregnancy() {
        return pregnancy;
    }
}
