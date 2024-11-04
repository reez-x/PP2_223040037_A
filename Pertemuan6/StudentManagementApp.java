import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagementApp extends JFrame {
    private JTextField nameField;
    private JTextArea addressArea;
    private JRadioButton maleRadio, femaleRadio;
    private JCheckBox sportsCheckBox, musicCheckBox;
    private JComboBox<String> majorComboBox;
    private JList<String> classList;
    private JSlider ageSlider;
    private JSpinner subjectSpinner;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private ArrayList<Object[]> studentsData = new ArrayList<>();

    public StudentManagementApp() {
        // Set up main frame
        setTitle("Student Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        JMenuItem viewStudentsItem = new JMenuItem("View Students");
        menu.add(addStudentItem);
        menu.add(viewStudentsItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        
        formPanel.add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(addressArea));

        formPanel.add(new JLabel("Gender:"));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formPanel.add(genderPanel);


        formPanel.add(new JLabel("Hobbies:"));
        sportsCheckBox = new JCheckBox("Sports");
        musicCheckBox = new JCheckBox("Music");
        JPanel hobbiesPanel = new JPanel();
        hobbiesPanel.add(sportsCheckBox);
        hobbiesPanel.add(musicCheckBox);
        formPanel.add(hobbiesPanel);

        formPanel.add(new JLabel("Major:"));
        String[] majors = {"Computer Science", "Mathematics", "Physics", "Chemistry"};
        majorComboBox = new JComboBox<>(majors);
        formPanel.add(majorComboBox);

        formPanel.add(new JLabel("Class:"));
        String[] classes = {"Class A", "Class B", "Class C"};
        classList = new JList<>(classes);
        formPanel.add(new JScrollPane(classList));

        formPanel.add(new JLabel("Age:"));
        ageSlider = new JSlider(10, 20);
        formPanel.add(ageSlider);

        formPanel.add(new JLabel("Subjects:"));
        subjectSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        formPanel.add(subjectSpinner);

        panel.add(formPanel, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Address", "Gender", "Hobbies", "Major", "Class", "Age", "Subjects"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        panel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveStudentData();
            }
        });
        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);

        addStudentItem.addActionListener(e -> panel.setVisible(true));
        viewStudentsItem.addActionListener(e -> showAllStudents());
    }

    private void saveStudentData() {
        String name = nameField.getText();
        String address = addressArea.getText();
        String gender = maleRadio.isSelected() ? "Male" : "Female";
        String hobbies = (sportsCheckBox.isSelected() ? "Sports " : "") + (musicCheckBox.isSelected() ? "Music" : "");
        String major = (String) majorComboBox.getSelectedItem();
        String selectedClass = classList.getSelectedValue();
        int age = ageSlider.getValue();
        int subjects = (int) subjectSpinner.getValue();

        Object[] rowData = {name, address, gender, hobbies, major, selectedClass, age, subjects};
        
        studentsData.add(rowData);
        
        clearForm();
    }

    private void showAllStudents() {
        tableModel.setRowCount(0);
        
        for (Object[] student : studentsData) {
            tableModel.addRow(student);
        }
    }

    private void clearForm() {
        nameField.setText("");
        addressArea.setText("");
        maleRadio.setSelected(true);
        sportsCheckBox.setSelected(false);
        musicCheckBox.setSelected(false);
        majorComboBox.setSelectedIndex(0);
        classList.clearSelection();
        ageSlider.setValue(15);
        subjectSpinner.setValue(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementApp app = new StudentManagementApp();
            app.setVisible(true);
        });
    }
}
