package com.motorph.ui;

import com.motorph.data.EmployeeRepository;
import com.motorph.model.Employee;
import com.motorph.service.EmployeeManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class EmployeeProfile extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final String[] FIELD_LABELS = {
            "Employee ID", "Last Name", "First Name", "Birthday", "Address", "Phone",
            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position",
            "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
            "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
    };

    private final String employeeId;
    private final EmployeeRecords parent;
    private final EmployeeManager employeeManager = new EmployeeManager();
    private final JTextField[] fields = new JTextField[EmployeeRepository.FIELD_COUNT];
    private final JButton editButton = new JButton("Edit");
    private final JButton saveButton = new JButton("Save");

    public EmployeeProfile(String employeeId, EmployeeRecords parent) {
        this.employeeId = employeeId;
        this.parent = parent;
        setTitle("MotorPh - Employee Profile");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 700);
        setLocationRelativeTo(parent);

        JPanel form = new JPanel(new GridLayout(FIELD_LABELS.length, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        for (int i = 0; i < FIELD_LABELS.length; i++) {
            form.add(new JLabel(FIELD_LABELS[i] + ":"));
            fields[i] = new JTextField();
            fields[i].setEditable(false);
            form.add(fields[i]);
        }

        editButton.addActionListener(event -> setEditMode(true));
        saveButton.addActionListener(event -> saveProfile());
        JButton cancelButton = new JButton("Close");
        cancelButton.addActionListener(event -> dispose());
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        actions.add(editButton);
        actions.add(saveButton);
        actions.add(cancelButton);
        saveButton.setEnabled(false);

        add(new JScrollPane(form), BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);
        loadEmployeeProfile();
        setVisible(true);
    }

    private void loadEmployeeProfile() {
        try {
            Optional<Employee> employee = employeeManager.findById(employeeId);
            if (employee.isEmpty()) {
                throw new IOException("Employee ID " + employeeId + " was not found.");
            }
            Employee record = employee.get();
            String[] values = {
                    record.getEmployeeId(), record.getLastName(), record.getFirstName(), record.getBirthday(),
                    record.getAddress(), record.getPhoneNumber(), record.getSssNumber(),
                    record.getPhilhealthNumber(), record.getTin(), record.getPagibigNumber(),
                    record.getStatus(), record.getPosition(), record.getSupervisor(), record.getBasicSalary(),
                    record.getRiceSubsidy(), record.getPhoneAllowance(), record.getClothingAllowance(),
                    record.getGrossSemiMonthlyRate(), record.getHourlyRate()
            };
            for (int i = 0; i < fields.length; i++) {
                fields[i].setText(values[i]);
            }
            fields[0].setEditable(false);
        } catch (IOException e) {
            showError("Employee profile could not be loaded:\n" + e.getMessage());
            dispose();
        }
    }

    private void setEditMode(boolean editing) {
        for (int i = 1; i < fields.length; i++) {
            fields[i].setEditable(editing);
        }
        editButton.setEnabled(!editing);
        saveButton.setEnabled(editing);
    }

    private void saveProfile() {
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = fields[i].getText().trim();
            if (values[i].isEmpty()) {
                JOptionPane.showMessageDialog(this, FIELD_LABELS[i] + " is required.",
                        "Invalid employee details", JOptionPane.WARNING_MESSAGE);
                fields[i].requestFocusInWindow();
                return;
            }
        }
        if (!values[3].matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Birthday must use MM/DD/YYYY format.",
                    "Invalid employee details", JOptionPane.WARNING_MESSAGE);
            fields[3].requestFocusInWindow();
            return;
        }

        try {
            employeeManager.update(employeeId, new Employee(
                    values[0], values[1], values[2], values[3], values[4], values[5], values[6],
                    values[7], values[8], values[9], values[10], values[11], values[12], values[13],
                    values[14], values[15], values[16], values[17], values[18]));
            if (parent != null) {
                parent.refreshTable();
            }
            setEditMode(false);
        } catch (IOException e) {
            showError("Employee profile could not be saved:\n" + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Application error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        Login.main(args);
    }
}
