package GUI;

import employeeData.EmployeeRepository;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final String[] FIELD_LABELS = {
            "Employee ID", "Last Name", "First Name", "Birthday (MM/DD/YYYY)", "Address",
            "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status",
            "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy",
            "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
    };
    private final JTextField[] fields = new JTextField[EmployeeRepository.FIELD_COUNT];
    private final EmployeeRecords parent;

    public Home(EmployeeRecords parent) {
        this.parent = parent;
        setTitle("MotorPh - Add Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 700);
        setLocationRelativeTo(parent);

        JPanel form = new JPanel(new GridLayout(FIELD_LABELS.length, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        for (int i = 0; i < FIELD_LABELS.length; i++) {
            form.add(new JLabel(FIELD_LABELS[i] + ":"));
            fields[i] = new JTextField();
            form.add(fields[i]);
        }
        fields[0].setEditable(false);
        assignNextEmployeeId();

        JButton saveButton = new JButton("Save employee");
        saveButton.addActionListener(event -> saveEmployee());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dispose());
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        actions.add(cancelButton);
        actions.add(saveButton);

        add(new JScrollPane(form), BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void assignNextEmployeeId() {
        try {
            int nextId = EmployeeRepository.getInstance().findAll().stream()
                    .mapToInt(employee -> {
                        try {
                            return Integer.parseInt(employee[0].trim());
                        } catch (NumberFormatException e) {
                            return 0;
                        }
                    })
                    .max()
                    .orElse(0) + 1;
            fields[0].setText(Integer.toString(nextId));
        } catch (IOException e) {
            showError("Employee records could not be loaded:\n" + e.getMessage());
        }
    }

    private void saveEmployee() {
        String[] employee = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            employee[i] = fields[i].getText().trim();
            if (employee[i].isEmpty()) {
                JOptionPane.showMessageDialog(this, FIELD_LABELS[i] + " is required.",
                        "Invalid employee details", JOptionPane.WARNING_MESSAGE);
                fields[i].requestFocusInWindow();
                return;
            }
        }
        if (!employee[3].matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Birthday must use MM/DD/YYYY format.",
                    "Invalid employee details", JOptionPane.WARNING_MESSAGE);
            fields[3].requestFocusInWindow();
            return;
        }
        for (int i = 13; i < employee.length; i++) {
            if (!employee[i].matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, FIELD_LABELS[i] + " must be a non-negative number.",
                        "Invalid employee details", JOptionPane.WARNING_MESSAGE);
                fields[i].requestFocusInWindow();
                return;
            }
        }

        try {
            EmployeeRepository.getInstance().add(employee);
            parent.refreshTable();
            dispose();
        } catch (IOException e) {
            showError("Employee could not be saved:\n" + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Application error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        Login.main(args);
    }
}
