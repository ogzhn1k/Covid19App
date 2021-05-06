package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class DocAndHospitalSel extends JFrame implements ActionListener {
    private JTable hospitalTable;
    private JTable doctorTable;
    private JButton confirmB;
    private JPanel datePanel;
    private JPanel mainPanel;
    private JButton hospitalButton;
    private int vaccine_id;
    private int appo_id;
    private String patient_id;
    private String doctor_id;
    private int hospital_id;


    DefaultTableModel model;
    DefaultTableModel model2;
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());

    public DocAndHospitalSel(int vaccine_id,String patient_id){
        this.vaccine_id = vaccine_id;
        this.patient_id = patient_id;
        dateChooser.setDateFormatString("yyyy-MM-dd");

        add(mainPanel);
        datePanel.add(dateChooser);

        CrudOperations crudOperations = new CrudOperations();
        ArrayList<Hospital> hospitals = crudOperations.getHospitals();

        model = (DefaultTableModel) hospitalTable.getModel();
        model.addColumn("Id");
        model.addColumn("Name");

        for (Hospital hospital : hospitals)
            model.addRow(new Object[]{hospital.getHospital_id(),hospital.getHospital_name()});

        hospitalTable.setFillsViewportHeight(true);
        hospitalButton.addActionListener(this);

        //---------------------------------------------------------------------------------------

        ArrayList<Doctor> doctors = crudOperations.getDoctors();
        ArrayList<User> users = crudOperations.getUsers();
        hospitals = crudOperations.getHospitals();

        model2 = (DefaultTableModel) doctorTable.getModel();
        model2.addColumn("Hospital");
        model2.addColumn("Doctor Name");

        //
        for (Doctor doctor : doctors){
            for(User user : users){
                for(Hospital hospital : hospitals){
                    if(user.getIdentity_number().equals(doctor.getIdentity_number()) && doctor.getHospital_id()==hospital.getHospital_id()){
                        model2.addRow(new Object[]{hospital.getHospital_name(),user.getName()+" "+user.getSurname()});
                        doctor_id = doctor.getIdentity_number();
                        hospital_id = hospital.getHospital_id();
                    }

                }
            }
        }

        doctorTable.setFillsViewportHeight(true);

        confirmB.addActionListener(this);
        setSize(1000,400);
        setTitle("Vaccine Selection Screen");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hospitalButton){


        }
        if(e.getSource() == confirmB){

            java.util.Date d = dateChooser.getDate();
            java.sql.Date sqldate = new java.sql.Date(d.getTime());


            String sqlAppo = " INSERT INTO Appointment"+" VALUES(?,?,?,?,?,?,?)";
            CrudOperations crudOperations = new CrudOperations();
            Appointment appointment = new Appointment(1,patient_id,doctor_id,hospital_id,vaccine_id,sqldate,sqldate);

            crudOperations.insertToDbAppo(appointment,sqlAppo);

        }


    }
}
