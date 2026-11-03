package adminDashboard;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CreateAccount.CreateAccount;
import GUI.Employee;
import employeeData.EmployeeManager;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.ImageIcon;


public class AdminDashboard {

	private final EmployeeManager employeeManager = new EmployeeManager();
	private JFrame frmAdminDashboard;
	private JTable table;
	private JTextField txtSearch;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUI.Login.main(args);
	}

	/**
	 * Create the application.
	 */
	public AdminDashboard() {
		initialize();
		loadCSVData();
		frmAdminDashboard.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminDashboard = new JFrame();
		frmAdminDashboard.getContentPane().setBackground(new Color(255, 204, 204));
		frmAdminDashboard.setTitle("Admin Dashboard");
		frmAdminDashboard.setBounds(500, 0, 676, 1047);
		frmAdminDashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdminDashboard.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 51, 102)));
		panel.setBounds(10, 337, 637, 590);
		frmAdminDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 617, 566);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setMinWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setMinWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setMinWidth(92);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setMinWidth(89);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setMinWidth(90);
		table.getColumnModel().getColumn(10).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setMinWidth(80);
		table.getColumnModel().getColumn(11).setPreferredWidth(90);
		table.getColumnModel().getColumn(11).setMinWidth(90);
		table.getColumnModel().getColumn(12).setPreferredWidth(140);
		table.getColumnModel().getColumn(12).setMinWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(86);
		table.getColumnModel().getColumn(14).setPreferredWidth(87);
		table.getColumnModel().getColumn(15).setPreferredWidth(97);
		table.getColumnModel().getColumn(16).setPreferredWidth(105);
		table.getColumnModel().getColumn(17).setPreferredWidth(130);
		table.getColumnModel().getColumn(17).setMinWidth(130);
		table.getColumnModel().getColumn(18).setPreferredWidth(67);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 51, 102)));
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(76, 938, 153, 62);
		frmAdminDashboard.getContentPane().add(panel_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount dialog = new CreateAccount();
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent event) {
						loadCSVData();
					}
				});
				dialog.setVisible(true);
			}
		});
		btnCreate.setBounds(10, 11, 130, 38);
		panel_1.add(btnCreate);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					frmAdminDashboard.dispose();
					GUI.Login.main(null);
				}
			}
		});
		btnSignOut.setBounds(550, 11, 89, 23);
		frmAdminDashboard.getContentPane().add(btnSignOut);
		
		JLabel lblNewLabel = new JLabel("MotorPh");
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setBounds(332, 250, 216, 53);
		frmAdminDashboard.getContentPane().add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(520, 304, 127, 20);
		frmAdminDashboard.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		 JButton btnSearch = new JButton("Search");
	        btnSearch.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String empID = txtSearch.getText().trim();

	                Employee employeeDetails = searchEmployeeID(empID);

	                if (employeeDetails != null) {
	                    searchResultsFrame resultsFrame = new searchResultsFrame(employeeDetails);
	                    resultsFrame.addWindowListener(new java.awt.event.WindowAdapter() {
	                    	@Override
	                    	public void windowClosed(java.awt.event.WindowEvent event) {
	                    		loadCSVData();
	                    	}
	                    });
	                    resultsFrame.setVisible(true);
	                    txtSearch.setText("");
	                } else {
	                    JOptionPane.showMessageDialog(null, "No employee found with Employee ID: " + empID);
	                }
	            }
	        });
	        btnSearch.setBounds(422, 303, 89, 23);
	        frmAdminDashboard.getContentPane().add(btnSearch);
	        
	        JLabel lblNewLabel_1 = new JLabel("New label");
	        java.net.URL logo = AdminDashboard.class.getResource("/asfasfsaf-removebg-preview.png");
	        if (logo != null) {
	        	lblNewLabel_1.setIcon(new ImageIcon(logo));
	        }
	        lblNewLabel_1.setBounds(10, -23, 640, 347);
	        frmAdminDashboard.getContentPane().add(lblNewLabel_1);
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setLayout(null);
	        panel_1_1.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 51, 102)));
	        panel_1_1.setBackground(new Color(0, 51, 102));
	        panel_1_1.setBounds(259, 938, 146, 62);
	        frmAdminDashboard.getContentPane().add(panel_1_1);
	        
	        JButton btnDelete = new JButton("Delete");
	        btnDelete.setBounds(10, 11, 123, 38);
	        panel_1_1.add(btnDelete);
	        btnDelete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		DefaultTableModel model = (DefaultTableModel) table.getModel();
	        		int selectedRow = table.getSelectedRow();
	        		
	        		if (selectedRow == -1) {
	        			JOptionPane.showMessageDialog(null, "Select a row to delete", "Error", JOptionPane.OK_CANCEL_OPTION);
	        			return;
	        		} 
	        		
	        		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected employee details?", "Confirm", JOptionPane.YES_NO_OPTION);
	        		if (confirm == JOptionPane.YES_OPTION) {
	        			try {
	        				deleteDataCsv();
	        				JOptionPane.showMessageDialog(frmAdminDashboard, "Employee details deleted.");
	        			} catch (IOException e1) {
	        				JOptionPane.showMessageDialog(frmAdminDashboard,
	        						"Employee details could not be deleted:\n" + e1.getMessage(),
	        						"Application error", JOptionPane.ERROR_MESSAGE);
	        			}
	        		}
	        		
	        		
	        	}
	        });
	        
	        JPanel panel_1_2 = new JPanel();
	        panel_1_2.setLayout(null);
	        panel_1_2.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 51, 102)));
	        panel_1_2.setBackground(new Color(0, 51, 102));
	        panel_1_2.setBounds(436, 938, 153, 62);
	        frmAdminDashboard.getContentPane().add(panel_1_2);
	        
	        JButton btnRefresh = new JButton("Refresh");
	        btnRefresh.setBounds(13, 11, 130, 38);
	        panel_1_2.add(btnRefresh);
	        btnRefresh.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		loadCSVData();
	        	}
	        });

	        JButton btnManageRecords = new JButton("Manage Records");
	        btnManageRecords.setBounds(250, 303, 150, 23);
	        btnManageRecords.addActionListener(e -> {
	        	GUI.EmployeeRecords records = new GUI.EmployeeRecords();
	        	records.addWindowListener(new java.awt.event.WindowAdapter() {
	        		@Override
	        		public void windowClosed(java.awt.event.WindowEvent event) {
	        			loadCSVData();
	        		}
	        	});
	        });
	        frmAdminDashboard.getContentPane().add(btnManageRecords);
	    }

	     //Method to search for an employee by Employee ID.
	     
    private Employee searchEmployeeID(String empID) {
        try {
            return employeeManager.findById(empID).orElse(null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frmAdminDashboard, "Unable to search employee records:\n" + e.getMessage(),
                    "Application error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
	
	private void loadCSVData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            for (Employee employee : employeeManager.findAll()) {
                model.addRow(new Object[] {
                        employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(),
                        employee.getBirthday(), employee.getAddress(), employee.getPhoneNumber(),
                        employee.getSssNumber(), employee.getPhilhealthNumber(), employee.getTin(),
                        employee.getPagibigNumber(), employee.getStatus(), employee.getPosition(),
                        employee.getSupervisor(), employee.getBasicSalary(), employee.getRiceSubsidy(),
                        employee.getPhoneAllowance(), employee.getClothingAllowance(),
                        employee.getGrossSemiMonthlyRate(), employee.getHourlyRate()
                });
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frmAdminDashboard,
                    "Employee records could not be loaded:\n" + e.getMessage(),
                    "Application error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	private void deleteDataCsv() throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			return;
		}
		String employeeId = model.getValueAt(selectedRow, 0).toString();
		if (!employeeManager.delete(employeeId)) {
			throw new IOException("Employee ID " + employeeId + " was not found.");
		}
		loadCSVData();
	}
}
