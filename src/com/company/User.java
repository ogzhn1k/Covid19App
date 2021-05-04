package com.company;

import java.sql.Date;

public class User {

    private String identity_number;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String gender;
    private Date dateOfBirth;

    public User(String identity_number, String name, String surname, String username, String password) {
        this.identity_number = identity_number;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public User(String identity_number,String name, String surname, String username, String password,String gender,Date dateOfBirth) {
        this.identity_number = identity_number;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
