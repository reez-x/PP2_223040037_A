/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.GridLayout;
import model.Electronic;
import model.ElectronicMapper;
import view.ElectronicsView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author thega
 */
public class ElectronicsController {
    private ElectronicsView view;
    private ElectronicMapper mapper;
    
    

    public ElectronicsController(ElectronicsView view, ElectronicMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        view.getBtnAdd().addActionListener(e -> addElectronic());
        view.getBtnDelete().addActionListener(e -> deleteElectronic());
        view.getBtnRefresh().addActionListener(e -> loadElectronics());
        
        view.getBtnUpdate().addActionListener(e -> {
    int selectedRow = view.getTable().getSelectedRow();
    if (selectedRow == -1) {

        return;
    }

    int id = (int) view.getTable().getValueAt(selectedRow, 0);
    String currentName = view.getTable().getValueAt(selectedRow, 1).toString();
    String currentBrand = view.getTable().getValueAt(selectedRow, 2).toString();
    double currentPrice = Double.parseDouble(view.getTable().getValueAt(selectedRow, 3).toString());
    int currentStock = Integer.parseInt(view.getTable().getValueAt(selectedRow, 4).toString());

    JDialog dialog = new JDialog(view, "Update Electronic", true);
    dialog.setLayout(new GridLayout(5, 2, 10, 10));
    dialog.setSize(400, 300);

    JTextField tfName = new JTextField(currentName);
    JTextField tfBrand = new JTextField(currentBrand);
    JTextField tfPrice = new JTextField(String.valueOf(currentPrice));
    JTextField tfStock = new JTextField(String.valueOf(currentStock));
    JButton btnUpdateDialog = new JButton("Update");

    dialog.add(new JLabel("Name:"));
    dialog.add(tfName);
    dialog.add(new JLabel("Brand:"));
    dialog.add(tfBrand);
    dialog.add(new JLabel("Price:"));
    dialog.add(tfPrice);
    dialog.add(new JLabel("Stock:"));
    dialog.add(tfStock);
    dialog.add(new JLabel()); // untuk jarak
    dialog.add(btnUpdateDialog);

    btnUpdateDialog.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Electronic e = new Electronic();
            e.setId(id);
            e.setName(tfName.getText());
            e.setBrand(tfBrand.getText());
            e.setPrice(Double.parseDouble(tfPrice.getText()));
            e.setStock(Integer.parseInt(tfStock.getText()));
            
            mapper.updateElectronic(e);
            JOptionPane.showMessageDialog(dialog, "Data berhasil di update");
            dialog.dispose();
            loadElectronics();
        }
    });
        dialog.setLocationRelativeTo(view);
        dialog.setVisible(true);
    });  
        loadElectronics();
    }

    private void loadElectronics() {
        List<Electronic> electronics = mapper.getAllElectronics();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Brand", "Price", "Stock"}, 0);
        for (Electronic e : electronics) {
            model.addRow(new Object[]{e.getId(), e.getName(), e.getBrand(), e.getPrice(), e.getStock()});
        }
        view.getTable().setModel(model);
    }

    private void addElectronic() {
        Electronic e = new Electronic();
        e.setName(view.getTfName().getText());
        e.setBrand(view.getTfBrand().getText());
        e.setPrice(Double.parseDouble(view.getTfPrice().getText()));
        e.setStock(Integer.parseInt(view.getTfStock().getText()));
        mapper.insertElectronic(e);
        loadElectronics();
    }

    private void updateElectronic() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris yang ingin di update");
            return;
        }
        Electronic e = new Electronic();
    }

    private void deleteElectronic() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris yang ingin di hapus");
            return;
        }
        int id = (int) view.getTable().getValueAt(selectedRow, 0);
        mapper.deleteElectronic(id);
        loadElectronics();
    }
}