/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.jenismember;

import dao.JenisMemberDao; 
import java.util.List; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField; 
import model.JenisMember;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author thega
 */
public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList; 
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) { 
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama: "); 
        labelInput.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField(); 
        textFieldNama.setBounds(15, 60, 350, 30);

        JButton simpanButton = new JButton("Simpan"); 
        simpanButton.setBounds(15, 100, 100, 40);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(120, 100, 100, 40);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(225, 100, 100, 40);

        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table); 
        scrollableTable.setBounds(15, 150, 350, 200);

        tableModel = new JenisMemberTableModel(jenisMemberList); 
        table.setModel(tableModel);

        // ActionListener untuk tombol Simpan
        JenisMemberButtonSimpanActionListener actionListener =
            new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        simpanButton.addActionListener(actionListener);

        // ActionListener untuk tombol Update
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String newName = textFieldNama.getText();
                    if (!newName.isEmpty()) {
                        JenisMember selectedJenisMember = jenisMemberList.get(selectedRow);
                        selectedJenisMember.setNama(newName);
                        tableModel.fireTableRowsUpdated(selectedRow, selectedRow);  // Update tabel
                        
                        // Lakukan update ke database
                        jenisMemberDao.update(selectedJenisMember);
                    }
                } else {
                    // Jika tidak ada baris yang dipilih, tampilkan pesan
                    System.out.println("Pilih jenis member yang akan diupdate.");
                }
            }
        });

        // ActionListener untuk tombol Delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Ambil data jenis member yang dipilih
                    JenisMember selectedJenisMember = jenisMemberList.get(selectedRow);

                    // Hapus dari database
                    jenisMemberDao.delete(selectedJenisMember.getId());
                    
                    // Hapus dari list dan update tabel
                    jenisMemberList.remove(selectedRow);
                    tableModel.fireTableRowsDeleted(selectedRow, selectedRow);
                } else {
                    // Jika tidak ada baris yang dipilih, tampilkan pesan
                    System.out.println("Pilih jenis member yang akan dihapus.");
                }
            }
        });

        // Seleksi baris untuk mengisi textFieldNama
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                JenisMember selectedJenisMember = jenisMemberList.get(selectedRow);
                textFieldNama.setText(selectedJenisMember.getNama());
            }
        });

        this.add(simpanButton); 
        this.add(updateButton);
        this.add(deleteButton);  // Menambahkan tombol Delete
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}

