import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemInput;

    public MainFrame() {
        setTitle("Aplikasi Data Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuItemInput = new JMenuItem("Input Data Mahasiswa");

        menu.add(menuItemInput);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        menuItemInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InputDataFrame().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}

class InputDataFrame extends JFrame {
    private JTextField textFieldNama;
    private JTextArea textAreaAlamat;
    private JRadioButton radioLaki, radioPerempuan;
    private JCheckBox checkBoxAktif;
    private JComboBox<String> comboBoxJurusan;
    private JList<String> listHobi;
    private JTable tableData;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public InputDataFrame() {
        setTitle("Input Data Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        textFieldNama = new JTextField(20);
        textAreaAlamat = new JTextArea(5, 20);
        radioLaki = new JRadioButton("Laki-laki");
        radioPerempuan = new JRadioButton("Perempuan");
        checkBoxAktif = new JCheckBox("Aktif");
        comboBoxJurusan = new JComboBox<>(new String[] {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro"});
        listHobi = new JList<>(new String[] {"Membaca", "Menulis", "Bersepeda"});
        tableModel = new DefaultTableModel(new Object[]{"Nama", "Alamat", "Jenis Kelamin", "Aktif", "Jurusan", "Hobi"}, 0);
        tableData = new JTable(tableModel);
        scrollPane = new JScrollPane(tableData);

        JButton btnSubmit = new JButton("Submit");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioLaki);
        genderGroup.add(radioPerempuan);

        add(new JLabel("Nama:"));
        add(textFieldNama);
        add(new JLabel("Alamat:"));
        add(new JScrollPane(textAreaAlamat));
        add(radioLaki);
        add(radioPerempuan);
        add(checkBoxAktif);
        add(new JLabel("Jurusan:"));
        add(comboBoxJurusan);
        add(new JLabel("Hobi:"));
        add(new JScrollPane(listHobi));
        add(btnSubmit);
        add(scrollPane);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String alamat = textAreaAlamat.getText();
                String jenisKelamin = radioLaki.isSelected() ? "Laki-laki" : "Perempuan";
                boolean aktif = checkBoxAktif.isSelected();
                String jurusan = (String) comboBoxJurusan.getSelectedItem();
                String hobi = listHobi.getSelectedValuesList().toString();

                tableModel.addRow(new Object[]{nama, alamat, jenisKelamin, aktif, jurusan, hobi});
            }
        });
    }
}
