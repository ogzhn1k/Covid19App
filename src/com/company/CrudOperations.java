package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
            statementUser.setObject(6,user.getGender());//
            statementUser.setDate(7, user.getDateOfBirth());
            int s = statementUser.executeUpdate();
            statementUser.close();
            connection.close();

        }catch (SQLException exception){
            dbConnection.showErrorMessage(exception);
        }


    }

    public void insertToDbPatient(Patient patient,String sql){

        DbConnection dbConnection = new DbConnection();

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement statementPatient = connection.prepareStatement(sql);
            statementPatient.clearParameters();
            statementPatient.setString(1,patient.getIdentity_number());
            statementPatient.setString(2,patient.getAllergy_info());
            statementPatient.setString(3,patient.getChronic_info());
            statementPatient.setString(4,patient.getAllergy_info());

            int s = statementPatient.executeUpdate();
            statementPatient.close();
            connection.close();

        }catch (SQLException exception){
            dbConnection.showErrorMessage(exception);
        }



    }



}
