package com.company;
// Author : Oğuzhan Birk
// Doctor's screen

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DoctorScreen extends JFrame{

    private JPanel mainPanel;
    private JTable appoTable;
    private JRadioButton attendingRadioButton;
    private JRadioButton notAttendingRadioButton;
    private JButton confirmButton;
    private String doc_id;
    DefaultTableModel model;


    public DoctorScreen(String doc_id){
        this.doc_id = doc_id;
        add(mainPanel);

        ButtonGroup attGroup = new ButtonGroup();

        attGroup.add(attendingRadioButton);
        attGroup.add(notAttendingRadioButton);

        CrudOperations crudOperations = new CrudOperations();
        ArrayList<Appointment> appos = crudOperations.getAppo();

        model = (DefaultTableModel) appoTable.getModel();
        model.addColumn("Appointment Id");
        model.addColumn("Patient Id");
        model.addColumn("Vaccine Id");
        model.addColumn("First Date");


        for (Appointment appo : appos)
            model.addRow(new Object[]{appo.getAppo_id(),appo.getPatient_id(),appo.getVaccine_id(),appo.getFirst_date()});


        appoTable.setFillsViewportHeight(true);



        setSize(1000,400);
        setTitle("Doctor Selection Screen");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }







}
