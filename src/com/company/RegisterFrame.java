package com.company;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class RegisterFrame extends JFrame implements ActionListener {


    private JTextField identity_numberTf;
    private JTextField nameTf;
    private JTextField surnameTf;
    private JTextField usernameTf;
    private JTextField passwordTf;
    private JTextArea allergyTa;
    private JTextArea chronicTa;
    private JButton registerButton;
    private JPanel registerPanel;
    private JPanel calendarP;
    private JTextField genderTf;
    private JTextField pregnancyTf;
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());


    public RegisterFrame(){
        dateChooser.setDateFormatString("yyyy-MM-dd");
        calendarP.add(dateChooser);

        add(registerPanel);
        setSize(600,600);
        setTitle("Registration");

        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){


                java.util.Date d = dateChooser.getDate();
                java.sql.Date sqldate = new java.sql.Date(d.getTime());
                //(identity_number,name,surname,username,password,gender,date_birth)
                String sqlUser = " INSERT INTO Users "+"VALUES(?,?,?,?,?,?,?)";
                User user = new User(identity_numberTf.getText(),
                                     nameTf.getText(),
                                     surnameTf.getText(),
                                     usernameTf.getText(),
                                     passwordTf.getText(),
                                     genderTf.getText(),
                                      sqldate);
                CrudOperations crudOperations = new CrudOperations();
                crudOperations.insertToDbUser(user,sqlUser);

                String sqlPatient = "INSERT INTO Patients(identity_number,allergy_info,chronic_info,pregnancy) VALUES(?,?,?,?)";
                Patient patient = new Patient(identity_numberTf.getText(),
                                              allergyTa.getText(),
                                              chronicTa.getText(),
                                              pregnancyTf.getText());

                crudOperations.insertToDbPatient(patient,sqlPatient);

        }

    }
}
