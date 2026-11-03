package CreateAccount;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import employeeData.EmployeeRepository;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateAccount extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmpNum;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JLabel lblBirthday;
	private JTextField txtBirthday;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblPhoneNumber;
	private JTextField txtPhoneNum;
	private JLabel lblSSS;
	private JTextField txtSSSNum;
	private JLabel lblPhilHealth;
	private JTextField txtPHNum;
	private JLabel lblTin;
	private JTextField txtTinNum;
	private JLabel lblPagibigNumber;
	private JTextField txtPagibigNum;
	private JLabel lblStatus;
	private JLabel lblPosition;
	private JTextField txtPosition;
	private JLabel lblImmediateSupervisor;
	private JTextField txtSupervisor;
	private JLabel lblBasicSalary;
	private JTextField txtBasicSalary;
	private JLabel lblRiceSubsidy;
	private JTextField txtRiceSubsidy;
	private JLabel lblPhoneAllowance;
	private JTextField txtPhoneAllowance;
	private JLabel lblClothingAllowance;
	private JTextField txtClothingAllowance;
	private JLabel lblGrossSemimonthlyRate;
	private JTextField txtSemiMonthlyRate;
	private JLabel lblHourlyRate;
	private JTextField txtHourlyRate;
	private JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUI.Login.main(args);
	}

	/**
	 * Create the dialog.
	 */
	public CreateAccount() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 766);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmpNum = new JLabel("Employee Number");
		lblEmpNum.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmpNum.setBounds(40, 59, 114, 14);
		contentPanel.add(lblEmpNum);
		
		txtEmpNum = new JTextField();
		txtEmpNum.setEditable(false);
		txtEmpNum.setBounds(197, 53, 199, 20);
		contentPanel.add(txtEmpNum);
		txtEmpNum.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLastName.setBounds(40, 90, 114, 14);
		contentPanel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(197, 84, 199, 20);
		contentPanel.add(txtLastName);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFirstName.setBounds(40, 121, 114, 14);
		contentPanel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(197, 115, 199, 20);
		contentPanel.add(txtFirstName);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBirthday.setBounds(40, 152, 114, 14);
		contentPanel.add(lblBirthday);
		
		txtBirthday = new JTextField();
		txtBirthday.setForeground(new Color(0, 0, 0));
		txtBirthday.setText("MM/DD/YYYY");
		txtBirthday.setToolTipText("");
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(197, 146, 199, 20);
		contentPanel.add(txtBirthday);
		
		lblAddress = new JLabel("Address");
		lblAddress.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAddress.setBounds(40, 183, 114, 14);
		contentPanel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(197, 177, 199, 20);
		contentPanel.add(txtAddress);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhoneNumber.setBounds(40, 211, 114, 14);
		contentPanel.add(lblPhoneNumber);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(197, 205, 199, 20);
		contentPanel.add(txtPhoneNum);
		
		lblSSS = new JLabel("SSS Number");
		lblSSS.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSSS.setBounds(40, 242, 114, 14);
		contentPanel.add(lblSSS);
		
		txtSSSNum = new JTextField();
		txtSSSNum.setColumns(10);
		txtSSSNum.setBounds(197, 236, 199, 20);
		contentPanel.add(txtSSSNum);
		
		lblPhilHealth = new JLabel("PhilHealth Number");
		lblPhilHealth.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhilHealth.setBounds(40, 273, 114, 14);
		contentPanel.add(lblPhilHealth);
		
		txtPHNum = new JTextField();
		txtPHNum.setColumns(10);
		txtPHNum.setBounds(197, 267, 199, 20);
		contentPanel.add(txtPHNum);
		
		lblTin = new JLabel("TIN Number");
		lblTin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTin.setBounds(40, 304, 114, 14);
		contentPanel.add(lblTin);
		
		txtTinNum = new JTextField();
		txtTinNum.setColumns(10);
		txtTinNum.setBounds(197, 298, 199, 20);
		contentPanel.add(txtTinNum);
		
		lblPagibigNumber = new JLabel("PAG-IBIG Number");
		lblPagibigNumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPagibigNumber.setBounds(40, 335, 114, 14);
		contentPanel.add(lblPagibigNumber);
		
		txtPagibigNum = new JTextField();
		txtPagibigNum.setColumns(10);
		txtPagibigNum.setBounds(197, 329, 199, 20);
		contentPanel.add(txtPagibigNum);
		
		lblStatus = new JLabel("Status");
		lblStatus.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStatus.setBounds(40, 366, 114, 14);
		contentPanel.add(lblStatus);
		
		lblPosition = new JLabel("Position");
		lblPosition.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPosition.setBounds(40, 397, 114, 14);
		contentPanel.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(197, 391, 199, 20);
		contentPanel.add(txtPosition);
		
		lblImmediateSupervisor = new JLabel("Immediate Supervisor");
		lblImmediateSupervisor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImmediateSupervisor.setBounds(40, 428, 147, 14);
		contentPanel.add(lblImmediateSupervisor);
		
		txtSupervisor = new JTextField();
		txtSupervisor.setColumns(10);
		txtSupervisor.setBounds(197, 422, 199, 20);
		contentPanel.add(txtSupervisor);
		
		lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBasicSalary.setBounds(40, 459, 114, 14);
		contentPanel.add(lblBasicSalary);
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setColumns(10);
		txtBasicSalary.setBounds(197, 453, 199, 20);
		contentPanel.add(txtBasicSalary);
		
		lblRiceSubsidy = new JLabel("Rice Subsidy");
		lblRiceSubsidy.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRiceSubsidy.setBounds(40, 490, 114, 14);
		contentPanel.add(lblRiceSubsidy);
		
		txtRiceSubsidy = new JTextField();
		txtRiceSubsidy.setColumns(10);
		txtRiceSubsidy.setBounds(197, 484, 199, 20);
		contentPanel.add(txtRiceSubsidy);
		
		lblPhoneAllowance = new JLabel("Phone Allowance");
		lblPhoneAllowance.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhoneAllowance.setBounds(40, 521, 114, 14);
		contentPanel.add(lblPhoneAllowance);
		
		txtPhoneAllowance = new JTextField();
		txtPhoneAllowance.setColumns(10);
		txtPhoneAllowance.setBounds(197, 515, 199, 20);
		contentPanel.add(txtPhoneAllowance);
		
		lblClothingAllowance = new JLabel("Clothing Allowance");
		lblClothingAllowance.setVerticalAlignment(SwingConstants.BOTTOM);
		lblClothingAllowance.setBounds(40, 552, 114, 14);
		contentPanel.add(lblClothingAllowance);
		
		txtClothingAllowance = new JTextField();
		txtClothingAllowance.setColumns(10);
		txtClothingAllowance.setBounds(197, 546, 199, 20);
		contentPanel.add(txtClothingAllowance);
		
		lblGrossSemimonthlyRate = new JLabel("Gross Semi-monthly Rate");
		lblGrossSemimonthlyRate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGrossSemimonthlyRate.setBounds(40, 583, 147, 14);
		contentPanel.add(lblGrossSemimonthlyRate);
		
		txtSemiMonthlyRate = new JTextField();
		txtSemiMonthlyRate.setColumns(10);
		txtSemiMonthlyRate.setBounds(197, 577, 199, 20);
		contentPanel.add(txtSemiMonthlyRate);
		
		lblHourlyRate = new JLabel("Hourly Rate");
		lblHourlyRate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHourlyRate.setBounds(40, 614, 114, 14);
		contentPanel.add(lblHourlyRate);
		
		txtHourlyRate = new JTextField();
		txtHourlyRate.setColumns(10);
		txtHourlyRate.setBounds(197, 608, 199, 20);
		contentPanel.add(txtHourlyRate);
		
		JLabel lblEnterEmployeeDetails = new JLabel("Enter Employee Details:");
		lblEnterEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterEmployeeDetails.setBounds(40, 11, 255, 37);
		contentPanel.add(lblEnterEmployeeDetails);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Validate fields to make sure there is no empty text fields
		        if (txtEmpNum.getText().trim().isEmpty() ||
		            txtLastName.getText().trim().isEmpty() ||
		            txtFirstName.getText().trim().isEmpty() ||
		            txtBirthday.getText().trim().isEmpty() ||
		            txtAddress.getText().trim().isEmpty() ||
		            txtPhoneNum.getText().trim().isEmpty() ||
		            txtSSSNum.getText().trim().isEmpty() ||
		            txtPHNum.getText().trim().isEmpty() ||
		            txtTinNum.getText().trim().isEmpty() ||
		            txtPagibigNum.getText().trim().isEmpty() ||
		            txtStatus.getText().trim().isEmpty() ||
		            txtPosition.getText().trim().isEmpty() ||
		            txtSupervisor.getText().trim().isEmpty() ||
		            txtBasicSalary.getText().trim().isEmpty() ||
		            txtRiceSubsidy.getText().trim().isEmpty() ||
		            txtPhoneAllowance.getText().trim().isEmpty() ||
		            txtClothingAllowance.getText().trim().isEmpty() ||
		            txtSemiMonthlyRate.getText().trim().isEmpty() ||
		            txtHourlyRate.getText().trim().isEmpty()) {
		            
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }
		        
		        // validate values to make sure it only contains numbers (used regex pattern) 
		        if (!txtEmpNum.getText().trim().matches("\\d+") ||
		                !txtBasicSalary.getText().trim().matches("\\d+(\\.\\d+)?") ||
		                !txtRiceSubsidy.getText().trim().matches("\\d+(\\.\\d+)?") ||
		                !txtPhoneAllowance.getText().trim().matches("\\d+(\\.\\d+)?") ||
		                !txtClothingAllowance.getText().trim().matches("\\d+(\\.\\d+)?") ||
		                !txtSemiMonthlyRate.getText().trim().matches("\\d+(\\.\\d+)?") ||
		                !txtHourlyRate.getText().trim().matches("\\d+(\\.\\d+)?")) {
		                
		                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for numeric fields.", "Error", JOptionPane.ERROR_MESSAGE);
		                return; 
		            }
		        
		        //validation code for birthday 
		        if (!txtBirthday.getText().trim().matches("^(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])/\\d{4}$")) {
		            JOptionPane.showMessageDialog(null, "Please enter birthday in MM/DD/YYYY format.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }

				 String[] newData = new String[]{
			                txtEmpNum.getText().trim(),
			                txtLastName.getText().trim(),
			                txtFirstName.getText().trim(),
			                txtBirthday.getText().trim(),
			                txtAddress.getText().trim(),
			                txtPhoneNum.getText().trim(),
			                txtSSSNum.getText().trim(),
			                txtPHNum.getText().trim(),
			                txtTinNum.getText().trim(),
			                txtPagibigNum.getText().trim(),
			                txtStatus.getText().trim(),
			                txtPosition.getText().trim(),
			                txtSupervisor.getText().trim(),
			                txtBasicSalary.getText().trim(),
			                txtRiceSubsidy.getText().trim(),
			                txtPhoneAllowance.getText().trim(),
			                txtClothingAllowance.getText().trim(),
			                txtSemiMonthlyRate.getText().trim(),
			                txtHourlyRate.getText().trim()
			            };
				 try {
					 EmployeeRepository.getInstance().add(newData);
					 JOptionPane.showMessageDialog(CreateAccount.this, "New employee details added successfully.");
					 dispose();
				 } catch (IOException ex) {
					 JOptionPane.showMessageDialog(CreateAccount.this, "Employee could not be added:\n" + ex.getMessage(),
							 "Application error", JOptionPane.ERROR_MESSAGE);
				 }
		    }
		});
		btnSubmit.setBounds(239, 667, 89, 23);
		contentPanel.add(btnSubmit);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(197, 360, 199, 20);
		contentPanel.add(txtStatus);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmpNum.setText("");
                txtLastName.setText("");
                txtFirstName.setText("");
                txtBirthday.setText("MM/DD/YYYY");
                txtAddress.setText("");
                txtPhoneNum.setText("");
                txtSSSNum.setText("");
                txtPHNum.setText("");
                txtTinNum.setText("");
                txtPagibigNum.setText("");
                txtStatus.setText("");
                txtPosition.setText("");                                                   
                txtSupervisor.setText("");
                txtBasicSalary.setText("");
                txtRiceSubsidy.setText("");
                txtPhoneAllowance.setText("");
                txtClothingAllowance.setText("");
                txtSemiMonthlyRate.setText("");
                txtHourlyRate.setText("");
			}
		});
		btnReset.setBounds(100, 667, 89, 23);
		contentPanel.add(btnReset);
		
    	try {
    		txtEmpNum.setText(Integer.toString(getNextEmpNum()));
    	} catch (IOException e) {
    		JOptionPane.showMessageDialog(this, "The next employee ID could not be determined:\n" + e.getMessage(),
    				"Application error", JOptionPane.ERROR_MESSAGE);
    		btnSubmit.setEnabled(false);
    	}
    }
	
    private int getNextEmpNum() throws IOException {
    	return EmployeeRepository.getInstance().findAll().stream()
    			.mapToInt(employee -> {
    				try {
    					return Integer.parseInt(employee[0].trim());
    				} catch (NumberFormatException e) {
    					return 0;
    				}
    			})
    			.max()
    			.orElse(0) + 1;
    }

	
	
}