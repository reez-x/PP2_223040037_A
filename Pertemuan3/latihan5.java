import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class latihan5 extends JFrame {
    private boolean checkBoxSelected;

    public latihan5() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel label = new JLabel("Form Biodata");
        JLabel labelInputNama = new JLabel("Nama : ");
        JTextField textFieldNama = new JTextField();

        JLabel labelInputHP = new JLabel("Nomor HP : ");
        JTextField textFieldHP = new JTextField();

        JLabel labelInputJK = new JLabel("Jenis Kelamin : ");
        JPanel panelJenisKelamin = new JPanel();
        panelJenisKelamin.setLayout(new FlowLayout());

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        panelJenisKelamin.add(radioButton1);
        panelJenisKelamin.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        JButton button = new JButton("Simpan");

        this.add(label);
        this.add(new JLabel("")); 
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputHP);
        this.add(textFieldHP);
        this.add(labelInputJK);
        this.add(panelJenisKelamin);
        this.add(new JLabel("")); 
        this.add(checkBox);
        this.add(new JLabel("")); 
        this.add(button);

        this.setSize(400, 300);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                latihan5 h = new latihan5();
                h.setVisible(true);
            }
        });
    }
}
