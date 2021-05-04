package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Calendar;

public class DocAndHospitalSel extends JFrame {
    private JTable hospitalTable;
    private JTable doctorTable;
    private JButton confirmB;
    private JPanel datePanel;
    private JPanel mainPanel;
    DefaultTableModel model;
    DefaultTableModel model2;
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());

    public DocAndHospitalSel(){

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

        //---------------------------------------------------------------------------------------

        ArrayList<Doctor> doctors = crudOperations.getDoctors();

        model2 = (DefaultTableModel) doctorTable.getModel();
        model2.addColumn("Id");
        model2.addColumn("Hospital Id");

        for (Doctor doctor : doctors)
            model2.addRow(new Object[]{doctor.getIdentity_number(),doctor.getHospital_id()});

        doctorTable.setFillsViewportHeight(true);




        setSize(1000,400);
        setTitle("Vaccine Selection Screen");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }


}
