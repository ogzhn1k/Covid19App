package com.company;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
// Author : Oğuzhan Birk
// Registration Page

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
    private JRadioButton pYesRadioButton;
    private JRadioButton pNoRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());


    public RegisterFrame(){
        dateChooser.setDateFormatString("yyyy-MM-dd");
        calendarP.add(dateChooser);

        ButtonGroup pregGroup = new ButtonGroup();
        ButtonGroup genderGroup = new ButtonGroup();
        pregGroup.add(pYesRadioButton);
        pregGroup.add(pNoRadioButton);
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        add(registerPanel);
        setSize(600,600);
        setTitle("Registration");

        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){

                String gender="Other";
                String pregnancy="Not Pregnant";

                java.util.Date d = dateChooser.getDate();
                java.sql.Date sqldate = new java.sql.Date(d.getTime());


                if(maleRadioButton.isSelected())
                    gender="Male";
                else if(femaleRadioButton.isSelected())
                    gender = "Female";

                if(pYesRadioButton.isSelected())
                    pregnancy = "Pregnant";


                String sqlUser = " INSERT INTO Users "+"VALUES(?,?,?,?,?,?,?)";
                User user = new User(identity_numberTf.getText(),
                                     nameTf.getText(),
                                     surnameTf.getText(),
                                     usernameTf.getText(),
                                     passwordTf.getText(),
                                     gender,
                                     sqldate);
                CrudOperations crudOperations = new CrudOperations();
                crudOperations.insertToDbUser(user,sqlUser);

                String sqlPatient = " INSERT INTO Patients"+" VALUES(?,?,?,?)";
                Patient patient = new Patient(identity_numberTf.getText(),
                                              allergyTa.getText(),
                                              chronicTa.getText(),
                                              pregnancy);

                crudOperations.insertToDbPatient(patient,sqlPatient);
                JOptionPane.showMessageDialog(null,"Registration is Successful");
                dispose();

        }

    }
}
