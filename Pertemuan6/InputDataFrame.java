import javax.swing.*;
import java.awt.*;

public class InputDataFrame extends JFrame {
    private JTextField textFieldNama;
    private JTextArea textAreaAlamat;
    private JRadioButton radioLaki, radioPerempuan;
    private JCheckBox checkBoxAktif;
    private JComboBox<String> comboBoxJurusan;
    private JList<String> listHobi;
    private JTable tableData;
    private JScrollPane scrollPane;

    public InputDataFrame() {
        setTitle("Input Data Mahasiswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        textFieldNama = new JTextField(20);
        textAreaAlamat = new JTextArea(5, 20);
        radioLaki = new JRadioButton("Laki-laki");
        radioPerempuan = new JRadioButton("Perempuan");
        checkBoxAktif = new JCheckBox("Aktif");
        comboBoxJurusan = new JComboBox<>(new String[] {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro"});
        listHobi = new JList<>(new String[] {"Membaca", "Menulis", "Bersepeda"});
        tableData = new JTable(new Object[][]{}, new String[]{"Nama", "Alamat", "Jenis Kelamin", "Aktif", "Jurusan", "Hobi"});
        scrollPane = new JScrollPane(tableData);

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
        add(scrollPane);
    }
}
