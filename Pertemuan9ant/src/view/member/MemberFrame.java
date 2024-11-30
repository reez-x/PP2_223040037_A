/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.member;

import dao.JenisMemberDao; 
import dao.MemberDao;
import java.util.List;
import javax.swing.JButton; 
import javax.swing.JComboBox; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField; 
import model.JenisMember;
import model.Member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author thega
 */
public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox comboJenis;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;
    
    public MemberFrame (MemberDao memberDao, JenisMemberDao jenisMemberDao){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;
        
        this.memberList = this.memberDao.findAll();
        this.jenisMemberList = this.jenisMemberDao.findAll();
        
        JLabel labelInput = new JLabel("Nama:"); 
        labelInput.setBounds(15,40,350,10);

        textFieldNama = new JTextField(); 
        textFieldNama.setBounds (15,60,350,30);
        
        JLabel labelJenis = new JLabel("Jenis Member:"); 
        labelJenis.setBounds (15,100,350,10);
        
        comboJenis = new JComboBox(); 
        comboJenis.setBounds (15,120,150,30);
        
        JButton button = new JButton("Simpan"); 
        button.setBounds (15,160,100,40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane (table); 
        scrollableTable.setBounds (15,220,350,200);
        
        tableModel = new MemberTableModel (memberList); 
        table.setModel(tableModel);
        
        MemberButtonSimpanActionListener actionListener
            = new MemberButtonSimpanActionListener(this, memberDao);
        
        button.addActionListener(actionListener);
        
        
        JButton buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(130, 160, 100, 40);
        
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Ambil Member yang dipilih berdasarkan index pada tabel
                    Member selectedMember = memberList.get(selectedRow);

                    // Menghapus member dari database dan tabel
                    memberDao.delete(selectedMember.getId()); // Mengirimkan objek Member, bukan ID

                    // Hapus member dari list dan update tampilan tabel
                    memberList.remove(selectedRow);
                    tableModel.fireTableRowsDeleted(selectedRow, selectedRow);

                    // Memberikan informasi penghapusan
                    JOptionPane.showMessageDialog(MemberFrame.this, "Member " + selectedMember.getNama() + " telah dihapus.");
                } else {
                    JOptionPane.showMessageDialog(MemberFrame.this, "Pilih member yang ingin dihapus.");
                }
            }
        });

        this.add(buttonDelete);
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    public void populateComboJenis()
    {
        this.jenisMemberList = this.jenisMemberDao.findAll(); 
        comboJenis.removeAllItems();
        for (JenisMember jenisMember: this.jenisMemberList)
        {
            comboJenis.addItem(jenisMember.getNama());
        }
    }
    
    public String getNama()
    {
        return textFieldNama.getText();
    }
    public JenisMember getJenisMember()
    {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }
    
    public void addMember(Member member)
    {
        tableModel.add(member);
        textFieldNama.setText("");
    }
    
    public void showAlert(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }
}