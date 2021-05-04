package com.company;

import java.sql.*;
import java.util.ArrayList;

public class CrudOperations {

    DbConnection dbConnection = new DbConnection();

    public void insertToDbUser(User user,String sql){


        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement statementUser = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statementUser.setString(1,user.getIdentity_number());
            statementUser.setString(2,user.getName());
            statementUser.setString(3,user.getSurname());
            statementUser.setString(4,user.getUsername());
            statementUser.setString(5,user.getPassword());
            statementUser.setObject(6,user.getGender());
            statementUser.setDate(7, user.getDateOfBirth());
            int s = statementUser.executeUpdate();
            statementUser.close();
            connection.close();

        }catch (SQLException exception){
            dbConnection.showErrorMessage(exception);
        }


    }

    public void insertToDbPatient(Patient patient,String sql){

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement statementPatient = connection.prepareStatement(sql);
            statementPatient.clearParameters();
            statementPatient.setString(1,patient.getIdentity_number());
            statementPatient.setString(2,patient.getAllergy_info());
            statementPatient.setString(3,patient.getChronic_info());
            statementPatient.setString(4,patient.getPregnancy());

            int s = statementPatient.executeUpdate();
            statementPatient.close();
            connection.close();

        }catch (SQLException exception){
            dbConnection.showErrorMessage(exception);
        }

    }

    public ArrayList<Vaccine> getVaccines() {

        ArrayList<Vaccine> vaccines = null;
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from vaccine");
            vaccines = new ArrayList<Vaccine>();

            while (resultset.next()) {
                vaccines.add(new Vaccine(resultset.getInt("vaccine_id"),
                        resultset.getString("vaccine_name"),
                        resultset.getString("vaccine_country"),
                        resultset.getString("vaccine_tech")
                ));
            }

            statement.close();
            connection.close();



        } catch (SQLException exception) {
            dbConnection.showErrorMessage(exception);
        }

        return vaccines;

    }

    public ArrayList<Hospital> getHospitals(){

        ArrayList<Hospital> hospitals = null;
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from hospitals");
            hospitals = new ArrayList<Hospital>();

            while (resultset.next()) {
                hospitals.add(new Hospital(resultset.getInt("hospital_id"),
                                          resultset.getString("hospital_name")
                ));
            }

            statement.close();
            connection.close();



        } catch (SQLException exception) {
            dbConnection.showErrorMessage(exception);
        }

        return hospitals;

    }

    public ArrayList<Doctor> getDoctors(){

        ArrayList<Doctor> doctors = null;
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from doctors");
            doctors = new ArrayList<Doctor>();

            while (resultset.next()) {
                doctors.add(new Doctor(resultset.getString("identity_number"),
                        resultset.getInt("hospital_id")
                ));
            }

            statement.close();
            connection.close();


        } catch (SQLException exception) {
            dbConnection.showErrorMessage(exception);
        }

        return doctors;

    }
}






