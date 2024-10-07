import java.awt.Dimension;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class NasabahBank extends JFrame {
    private boolean checkBoxSelected;
    public NasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //==============Nama

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 15, 100, 10);
        
        JTextField textField = new JTextField();
        textField.setBounds(15, 30, 300, 30);

        this.add(labelInput);
        this.add(textField);

        //========NoHP

        JLabel labelInputHP = new JLabel("Nomor HP : ");
        labelInputHP.setBounds(15, 65, 100, 10);

        JTextField textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 80, 300, 30);

        this.add(labelInputHP);
        this.add(textFieldHP);

        //=============Jenis Kelamin

        JLabel labelInputJK = new JLabel("Jenis Kelamin : ");
        labelInputJK.setBounds(330, 170, 100, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(330, 190, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(330, 210, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        this.add(labelInputJK);
        this.add(radioButton1);
        this.add(radioButton2);

        // Data for the list
        String[] jenisTabungan = {"Reguler", "Investasi", "Darurat", "Pendidikan"};

        // Create a JList with the data
        JLabel labelInputJT = new JLabel("Jenis Tabungan : ");
        labelInputJT.setBounds(15, 120, 100, 10);

        this.add(labelInputJT);

        JList<String> List = new JList<>(jenisTabungan);
        List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        List.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        List.setVisibleRowCount(-1);

        List.setBounds(15, 140, 300, 40);

        this.add(List);
        this.setLocationRelativeTo(null); // Center the frame on screen
        this.setSize(680, 610);
        this.setLayout(null);

        //============================JSlider
        JLabel labelInputJS = new JLabel("Frekuensi transaksi per bulan : ");
        labelInputJS.setBounds(15, 190, 200, 15);

        this.add(labelInputJS);

        JSlider slider = new JSlider(10, 200, 100);
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setValue(50);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);

        slider.setBounds(15, 210, 300, 40);
        this.add(slider);

        //============================Date of Birth Input (JSpinner)
        JLabel dobLabel = new JLabel("Tanggal Lahir :");
        dobLabel.setBounds(330, 15, 120, 15);
        this.add(dobLabel);

        JLabel labelInputTGL = new JLabel("Tanggal :");
        labelInputTGL.setBounds(330, 45, 200, 15);
        this.add(labelInputTGL);
        // Tanggal
        SpinnerNumberModel dayModel = new SpinnerNumberModel(1, 1, 31, 1); // Nilai awal, minimum, maksimum, step
        JSpinner daySpinner = new JSpinner(dayModel);
        daySpinner.setBounds(410, 38, 50, 30);
        this.add(daySpinner);

        JLabel labelInputBLN = new JLabel("Bulan :");
        labelInputBLN.setBounds(330, 85, 200, 15);
        this.add(labelInputBLN);
        // Bulan
        SpinnerNumberModel monthModel = new SpinnerNumberModel(1, 1, 12, 1); // Nilai awal, minimum, maksimum, step
        JSpinner monthSpinner = new JSpinner(monthModel);
        monthSpinner.setBounds(410, 78, 50, 30);
        this.add(monthSpinner);

        JLabel labelInputTHN = new JLabel("Tahun :");
        labelInputTHN.setBounds(330, 125, 200, 15);
        this.add(labelInputTHN);
        // Tahun
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        SpinnerNumberModel yearModel = new SpinnerNumberModel(currentYear, 1900, currentYear, 1); // Nilai awal, min, maks, step
        JSpinner yearSpinner = new JSpinner(yearModel);
        yearSpinner.setBounds(410, 118, 80, 30);
        this.add(yearSpinner);

        //============================Password Field
        JLabel passwordLabel = new JLabel("Masukan password:");
        passwordLabel.setBounds(15, 260, 150, 30);
        this.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 260, 150, 30);
        this.add(passwordField);

        JLabel passwordLabel2 = new JLabel("Verifikasi password:");
        passwordLabel2.setBounds(15, 290, 150, 30);
        this.add(passwordLabel2);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(150, 290, 150, 30);
        this.add(passwordField2);

        //=============CheckBox

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(330, 250, 350, 30);
        this.add(checkBox);

        //==============Button

        JButton button = new JButton("Simpan");
        button.setBounds(335, 280, 100, 35);
        this.add(button);

        //============================Menu
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");

        // Add menu items
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textFieldHP.setText("");
                passwordField.setText("");
                List.clearSelection();
                slider.setValue(50);
                daySpinner.setValue(1);
                monthSpinner.setValue(1);
                yearSpinner.setValue(Calendar.getInstance().get(Calendar.YEAR));
                radioButton1.setSelected(true);
            }
        });
        fileMenu.add(resetMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        // Add the file menu to the menu bar
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        //==================================

        //========Output

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 330, 630, 200);

        this.add(txtOutput);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                checkBoxSelected = e.getStateChange()==1;
            }
        });

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
                String jenisTabungan = List.getSelectedValue(); 
                int nilaiSlider = slider.getValue();


                // Ambil nilai password dari password field
                String password = new String(passwordField.getPassword());
                String passwordVerifikasi = new String(passwordField2.getPassword());

                
                // Cek apakah password kosong atau tidak
                if (password.isEmpty() || passwordVerifikasi.isEmpty()) {
                    txtOutput.append("Password harus diisi!\n");
                } else if (!password.equals(passwordVerifikasi)) {
                    txtOutput.append("Password tidak cocok!\n");
                } else {
                    if (checkBoxSelected) {
                        txtOutput.append("Hello " + nama + "\n");
                        txtOutput.append("Nomor HP: " + noHP + "\n");
                        txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                        txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n"); 
                        txtOutput.append("Frekuensi per bulan: " + nilaiSlider + "\n"); 
                        textField.setText("");
                        textFieldHP.setText("");
                        passwordField.setText("");
                        passwordField2.setText("");
                    } else {
                        txtOutput.append("Anda tidak mencentang kotak persetujuan\n");
                    }
                }
    
                
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NasabahBank h = new NasabahBank();
                h.setVisible(true);
            }
        });
    }
}
