import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataMahasiswaApp extends JFrame {
    private JTextField tfNama;
    private JTextArea taAlamat;
    private JRadioButton rbLaki, rbPerempuan;
    private JCheckBox cbAktif;
    private JComboBox<String> cbJurusan;
    private JList<String> listHobi;
    private JSlider sliderSemester;
    private JSpinner spinnerUsia;
    private JTable table;
    private DefaultTableModel tableModel;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public DataMahasiswaApp() {
        setTitle("Aplikasi Data Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menuFile.add(exitItem);

        JMenu menuForm = new JMenu("Form");
        JMenuItem formMahasiswaItem = new JMenuItem("Form Mahasiswa");
        formMahasiswaItem.addActionListener(e -> cardLayout.show(mainPanel, "formPanel"));
        menuForm.add(formMahasiswaItem);

        JMenu menuView = new JMenu("View");
        JMenuItem viewDataItem = new JMenuItem("View Data");
        viewDataItem.addActionListener(e -> cardLayout.show(mainPanel, "viewPanel"));
        menuView.add(viewDataItem);

        menuBar.add(menuFile);
        menuBar.add(menuForm);
        menuBar.add(menuView);
        setJMenuBar(menuBar);

        // Layout utama menggunakan CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createFormPanel(), "formPanel");
        mainPanel.add(createViewPanel(), "viewPanel");

        add(mainPanel, BorderLayout.CENTER);

        // Tampilkan halaman form di awal
        cardLayout.show(mainPanel, "formPanel");
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 5, 5));

        tfNama = new JTextField();
        taAlamat = new JTextArea(3, 20);
        rbLaki = new JRadioButton("Laki-Laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        cbAktif = new JCheckBox("Aktif");

        cbJurusan = new JComboBox<>(new String[]{"Teknik Informatika", "Sistem Informasi", "Manajemen"});
        listHobi = new JList<>(new String[]{"Membaca", "Olahraga", "Menulis", "Musik"});
        sliderSemester = new JSlider(1, 8, 1);
        spinnerUsia = new JSpinner(new SpinnerNumberModel(18, 17, 30, 1));

        formPanel.add(new JLabel("Nama:"));
        formPanel.add(tfNama);
        formPanel.add(new JLabel("Alamat:"));
        formPanel.add(new JScrollPane(taAlamat));
        formPanel.add(new JLabel("Jenis Kelamin:"));
        JPanel genderPanel = new JPanel();
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);
        formPanel.add(genderPanel);
        formPanel.add(new JLabel("Status Mahasiswa:"));
        formPanel.add(cbAktif);
        formPanel.add(new JLabel("Jurusan:"));
        formPanel.add(cbJurusan);
        formPanel.add(new JLabel("Hobi:"));
        formPanel.add(new JScrollPane(listHobi));
        formPanel.add(new JLabel("Semester:"));
        formPanel.add(sliderSemester);
        formPanel.add(new JLabel("Usia:"));
        formPanel.add(spinnerUsia);

        JButton btnAdd = new JButton("Tambah");
        btnAdd.addActionListener(e -> addData());
        formPanel.add(btnAdd);

        return formPanel;
    }

    private JPanel createViewPanel() {
        JPanel viewPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Daftar Mahasiswa", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        viewPanel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Nama", "Alamat", "Jenis Kelamin", "Status", "Jurusan", "Hobi", "Semester", "Usia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JButton btnDelete = new JButton("Hapus");
        btnDelete.addActionListener(e -> deleteData());

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        tablePanel.add(btnDelete, BorderLayout.SOUTH);

        viewPanel.add(tablePanel, BorderLayout.CENTER);

        return viewPanel;
    }

    private void addData() {
        String nama = tfNama.getText();
        String alamat = taAlamat.getText();
        String gender = rbLaki.isSelected() ? "Laki-Laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
        String status = cbAktif.isSelected() ? "Aktif" : "Non-Aktif";
        String jurusan = cbJurusan.getSelectedItem().toString();
        String hobi = String.join(", ", listHobi.getSelectedValuesList());
        int semester = sliderSemester.getValue();
        int usia = (int) spinnerUsia.getValue();

        Object[] rowData = {nama, alamat, gender, status, jurusan, hobi, semester, usia};
        tableModel.addRow(rowData);

        clearForm();
    }

    private void deleteData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    private void clearForm() {
        tfNama.setText("");
        taAlamat.setText("");
        rbLaki.setSelected(false);
        rbPerempuan.setSelected(false);
        cbAktif.setSelected(false);
        cbJurusan.setSelectedIndex(0);
        listHobi.clearSelection();
        sliderSemester.setValue(1);
        spinnerUsia.setValue(18);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataMahasiswaApp app = new DataMahasiswaApp();
            app.setVisible(true);
        });
    }
}
