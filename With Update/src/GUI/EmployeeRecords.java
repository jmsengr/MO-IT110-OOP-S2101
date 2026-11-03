package GUI;

import employeeData.EmployeeRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class EmployeeRecords extends JFrame {

    private static final long serialVersionUID = 1L;

    private final DefaultTableModel tableModel = new DefaultTableModel(
            new String[] {"Employee #", "Last Name", "First Name", "Status", "Position", "Supervisor"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(tableModel);

    public EmployeeRecords() {
        setTitle("MotorPh - Employee Records");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(900, 500));
        setLocationRelativeTo(null);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JButton createButton = new JButton("Add employee");
        createButton.addActionListener(event -> new Home(this));
        JButton editButton = new JButton("View / edit");
        editButton.addActionListener(event -> openSelectedEmployee());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> deleteSelectedEmployee());
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(event -> refreshTable());
        actions.add(createButton);
        actions.add(editButton);
        actions.add(deleteButton);
        actions.add(refreshButton);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);

        add(actions, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        refreshTable();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        try {
            for (String[] employee : EmployeeRepository.getInstance().findAll()) {
                tableModel.addRow(new Object[] {
                        employee[0], employee[1], employee[2], employee[10], employee[11], employee[12]
                });
            }
        } catch (IOException e) {
            showError("Employee records could not be loaded:\n" + e.getMessage());
        }
    }

    private void openSelectedEmployee() {
        String employeeId = selectedEmployeeId();
        if (employeeId != null) {
            new EmployeeProfile(employeeId, this);
        }
    }

    private void deleteSelectedEmployee() {
        String employeeId = selectedEmployeeId();
        if (employeeId == null) {
            return;
        }
        int answer = JOptionPane.showConfirmDialog(this,
                "Delete employee " + employeeId + "?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
        if (answer != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            if (!EmployeeRepository.getInstance().delete(employeeId)) {
                throw new IOException("Employee ID " + employeeId + " was not found.");
            }
            refreshTable();
        } catch (IOException e) {
            showError("Employee could not be deleted:\n" + e.getMessage());
        }
    }

    private String selectedEmployeeId() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select an employee first.",
                    "No employee selected", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        int modelRow = table.convertRowIndexToModel(selectedRow);
        return tableModel.getValueAt(modelRow, 0).toString();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Application error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        Login.main(args);
    }
}
