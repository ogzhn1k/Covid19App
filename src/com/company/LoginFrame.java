package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginFrame extends JFrame implements ActionListener{

    private JTextField usernameTfield;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel panelLogin;
    private JPasswordField passwordField;
    private JButton exitButton;

    public LoginFrame(){

        add(panelLogin);
        setSize(400,300);
        setTitle("Login Screen");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Connection connection = null;
        DbConnection dbConnection = new DbConnection();
        Statement statement = null; // Sql statements
        ResultSet resultset; // sql den gelen sonucları tutar
        boolean found = false;
        boolean patOrDoc=true;
        String id=null;

        try{

            connection = dbConnection.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from users");
            ArrayList<User> users = new ArrayList<User>();
            while(resultset.next()){
                users.add(new User(resultset.getString("identity_number"),
                                   resultset.getString("name"),
                                   resultset.getString("surname"),
                                   resultset.getString("username"),
                                   resultset.getString("password")));
            }
            statement.close();

                if(e.getSource() == loginButton){
                    for(User user : users){
                        id = user.getIdentity_number();
                        if(user.getUsername().equals(usernameTfield.getText()) && user.getPassword().equals(String.valueOf(passwordField.getPassword()))){
                            //JOptionPane.showMessageDialog(null,"Welcome "+user.getName()+" "+user.getSurname());
                            statement = connection.createStatement();
                            String sql = "select * from doctors where identity_number = '"+user.getIdentity_number()+"'";
                            resultset = statement.executeQuery(sql);
                            if(resultset.next())
                                patOrDoc = false; // Doctor has been found

                            found = true;
                            break;
                        }
                    }
                    if(found==true){

                        if(patOrDoc == true){ // He or she is a patient
                            System.out.println("He or she is a patient");

                            VaccineSelection vaccineSelection = new VaccineSelection(id);

                            // TODO: Vaccine Selection Screen

                        }else{
                            System.out.println("He or she is a doctor");
                            // TODO : Doctor Screen
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }


                }if(e.getSource() == registerButton){
                    found = false;

                    for(User user : users){
                      if(user.getUsername().equals(usernameTfield.getText()) && user.getPassword().equals(String.valueOf(passwordField.getPassword()))){
                         found = true;
                         break;
                      }
                    }

                    if(found == false){

                        RegisterFrame registerFrame = new RegisterFrame();
                        registerFrame.setVisible(true);
                        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        registerFrame.setResizable(false);
                    }

               }
                if(e.getSource() == exitButton)
                    System.exit(0);


        } catch(SQLException exception){
            dbConnection.showErrorMessage(exception);
        }

    }
}
