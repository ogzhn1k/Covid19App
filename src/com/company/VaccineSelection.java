package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VaccineSelection extends JFrame{


    private JTable vaccineTable;
    private JPanel mainPanel;
    DefaultTableModel model;


    public VaccineSelection(){

        add(mainPanel);

        CrudOperations crudOperations = new CrudOperations();
        ArrayList<Vaccine> vaccines = crudOperations.getVaccines();

        model = (DefaultTableModel) vaccineTable.getModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Country");
        model.addColumn("Technology");


        for (Vaccine vaccine : vaccines)
            model.addRow(new Object[]{vaccine.getVaccine_id(),vaccine.getVaccine_name(),vaccine.getVaccine_country(),vaccine.getVaccine_tech()});


        vaccineTable.setFillsViewportHeight(true);

        setSize(1000,600);
        setTitle("Vaccine Selection Screen");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}
