package com.company;
// Author : Oğuzhan Birk
// Vaccine selection screen
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VaccineSelection extends JFrame implements ActionListener {


    private JTable vaccineTable;
    private JPanel mainPanel;
    private JTextField txtSearch;
    private JButton confirmButton;
    DefaultTableModel model;
    private int selected;
    private String patient_id;


    public VaccineSelection(String patient_id){
        this.patient_id = patient_id;

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
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchKey = txtSearch.getText();
                TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
                vaccineTable.setRowSorter(tableRowSorter);
                tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
            }
        });



        vaccineTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(vaccineTable.getSelectedRow()>-1){
                    selected = (int) vaccineTable.getValueAt(vaccineTable.getSelectedRow(),0);
                   // System.out.println(selected);
                    return;
                }
            }
        });



        confirmButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton){

            // TODO: Chronic Control
            System.out.println(selected);
            DocAndHospitalSel docAndHospitalSel = new DocAndHospitalSel(selected,patient_id);

        }

    }
}
