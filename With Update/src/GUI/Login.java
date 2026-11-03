package GUI;

import employeeData.EmployeeRepository;
import employeeDashboard.EmployeeDashboard;
import adminDashboard.AdminDashboard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

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
            Optional<String[]> employee = EmployeeRepository.getInstance().findById(employeeId);
            if (employee.isEmpty() || !employee.get()[3].trim().equals(birthday)) {
                JOptionPane.showMessageDialog(this, "Employee ID or birthday is incorrect.",
                        "Sign-in failed", JOptionPane.ERROR_MESSAGE);
                birthdayField.setText("");
                return;
            }

            String position = employee.get()[11].trim().toLowerCase(Locale.ROOT);
            if (position.equals("hr manager") || position.equals("hr team leader")
                    || position.equals("hr rank and file")) {
                new AdminDashboard();
            } else {
                new EmployeeDashboard(employeeId);
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
