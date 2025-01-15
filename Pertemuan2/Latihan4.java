import java.awt.event.*;
import javax.swing.*;

public class Latihan4 extends JFrame {

    public Latihan4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(10, 40, 100, 10);

        JTextField textField = new JTextField();
        textField.setBounds(10, 60, 200, 30);

        JLabel labelInputHP = new JLabel("Nomor HP : ");
        labelInputHP.setBounds(10, 100, 100, 10);

        JTextField textFieldHP = new JTextField();
        textFieldHP.setBounds(10, 120, 200, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 160, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 210, 350, 100);
        txtOutput.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String noHP = textFieldHP.getText();

                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + noHP + "\n");
                txtOutput.append("--------------------------------------------------\n"); // Garis pemisah

                textField.setText("");
                textFieldHP.setText("");
            }
        });

        this.add(textField);
        this.add(textFieldHP);
        this.add(labelInput);
        this.add(labelInputHP);
        this.add(txtOutput);
        this.add(button);

        this.setSize(600, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan4 h = new Latihan4();
                h.setVisible(true);
            }
        });
    }
}
