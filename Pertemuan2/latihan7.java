import java.awt.event.*;
import javax.swing.*;

import java.awt.Color;

public class latihan7 extends JFrame {
    private boolean checkBoxSelected;
public latihan7(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //==============Nama

    JLabel labelInput = new JLabel("Nama : ");
    labelInput.setBounds(10, 40, 100, 10);
    
    JTextField textField = new JTextField();
    textField.setBounds(10, 60, 100, 30);

    //========NoHP

    JLabel labelInputHP = new JLabel("Nomor HP : ");
    labelInputHP.setBounds(10, 100, 100, 10);

    JTextField textFieldHP = new JTextField();
    textFieldHP.setBounds(10, 120, 100, 30);

    //=============Jenis Kelamin

    JLabel labelInputJK = new JLabel("Jenis Kelamin : ");
    labelInputJK.setBounds(150, 40, 100, 10);

    JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
    radioButton1.setBounds(150, 60, 350, 30);

    JRadioButton radioButton2 = new JRadioButton("Perempuan");
    radioButton2.setBounds(150, 90, 350, 30);

    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton1);
    bg.add(radioButton2);

    

    //=============CheckBox

    JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
    checkBox.setBounds(15, 160, 350, 30);

    checkBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e){
            checkBoxSelected = e.getStateChange()==1;
        }
    });

    //==============Button

    JButton button = new JButton("Simpan");
    button.setBounds(15, 190, 100, 40);

    JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 250, 350, 100);

    // labelOutput.setOpaque(true);
    // labelOutput.setBackground(Color.WHITE);

    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            String jenisKelamin = "";
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

            String nama = textField.getText();
            String noHP = textFieldHP.getText();

            if(checkBoxSelected){
                txtOutput.append("Hello "+nama+"\n");
                txtOutput.append("Nomor HP "+noHP+"\n");
                txtOutput.append("Jenis Kelamin "+jenisKelamin+"\n");
                textField.setText("");
            } else {
                txtOutput.append("Anda tidak mencentang kotak persetujuan\n");
            }

            
        }
    });

    // button.addActionListener(new ActionListener() {
    //     public void actionPerformed(ActionEvent e){
    //         String jenisMember = "";
    //         if(radioButton1.isSelected()){
    //             jenisMember = radioButton1.getText();
    //         }
    //         if(radioButton2.isSelected()){
    //             jenisMember = radioButton2.getText();
    //         }
    //         if(radioButton3.isSelected()){
    //             jenisMember = radioButton3.getText();
    //         }

    //         String nama = textField.getText();
    //         txtOutput.append("Hello "+nama+"\n");
    //         txtOutput.append("Anda adalah member "+jenisMember+"\n");
    //         textField.setText("");
    //     }
    // });

    // button.addActionListener(new ActionListener() {
    //     public void actionPerformed(ActionEvent e){
    //         String nama = textField.getText();
    //         labelOutput.setText("Hello "+nama);
    //     }
    // });

    // this.add(button);
    this.add(textField);
    this.add(textFieldHP);
    this.add(labelInput);
    this.add(labelInputHP);
    this.add(labelInputJK);
    this.add(txtOutput);

    this.add(radioButton1);
    this.add(radioButton2);
    this.add(checkBox);

    this.add(button);
    
    this.setSize(600, 500);
    this.setLayout(null);
}


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                latihan7 h = new latihan7();
                h.setVisible(true);
            }
        });
    }
}