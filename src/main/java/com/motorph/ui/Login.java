package com.motorph.ui;

import com.motorph.model.Employee;
import com.motorph.service.EmployeeManager;
import com.motorph.ui.admin.AdminDashboard;
import com.motorph.ui.employee.EmployeeDashboard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private final EmployeeManager employeeManager = new EmployeeManager();
    private final JTextField employeeIdField = new JTextField();
    private final JPasswordField birthdayField = new JPasswordField();

    public Login() {
        setTitle("MotorPh - Sign in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Employee ID:", JLabel.RIGHT));
        panel.add(employeeIdField);
        panel.add(new JLabel("Birthday (MM/DD/YYYY):", JLabel.RIGHT));
        panel.add(birthdayField);

        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(event -> authenticateUser());
        panel.add(new JLabel());
        panel.add(loginButton);
        birthdayField.addActionListener(event -> authenticateUser());

        setContentPane(panel);
        pack();
        setSize(430, 190);
        setLocationRelativeTo(null);
    }

    private void authenticateUser() {
        String employeeId = employeeIdField.getText().trim();
        String birthday = new String(birthdayField.getPassword()).trim();

        try {
            Optional<Employee> employee = employeeManager.authenticate(employeeId, birthday);
            if (employee.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Employee ID or birthday is incorrect.",
                        "Sign-in failed", JOptionPane.ERROR_MESSAGE);
                birthdayField.setText("");
                return;
            }

            if (employeeManager.isHrEmployee(employee.get())) {
                new AdminDashboard();
            } else {
                new EmployeeDashboard(employee.get());
            }
            dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Employee data could not be loaded:\n" + e.getMessage(),
                    "Application error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
