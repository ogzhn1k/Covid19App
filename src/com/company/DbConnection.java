package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Author : Oğuzhan Birk
// The class connects java with database by using JDBC driver
public class DbConnection {

    private String username = "postgres";
    private String password = "password";
    private String dbUrl = "jdbc:postgresql://localhost:5432/BIL344-02";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,username,password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error : "+exception.getMessage());
    }

}
