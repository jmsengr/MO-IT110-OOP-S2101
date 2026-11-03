package com.motorph.ui.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import com.motorph.model.Employee;
import com.motorph.service.EmployeeManager;
import com.motorph.ui.Login;

public class EmployeeDashboard {

	private final EmployeeManager employeeManager = new EmployeeManager();
	private JFrame frmEmployeeDashboard;
    private JLayeredPane layeredPane;
    private JPanel panelPersonal;
    private JPanel panelWorkInfo;
    private JPanel panelSalary;
    private JPanel panelGoverment;
    private JPanel getContentPane;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtBirthday;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtEmpNum;
    private JTextField txtStatus;
    private JTextField txtSupervisor;
    private JTextField txtPosition;
    private JTextField txtSalary;
    private JTextField txtHourlyRate;
    private JTextField txtRice;
    private JTextField txtPhoneAllow;
    private JTextField txtClothing;
    private JTextField txtSemiRate;
    private JTextField txtSSS;
    private JTextField txtPhilHealth;
    private JTextField txtTIN;
    private JTextField txtPagibig;
	private String employeeID;
	private String lastName;
	private String firstName;
	private String birthday;
	private String address;
	private String phoneNum;
	private String sss;
	private String philHealth;
	private String tin;
	private String pagibig;
	private String status;
	private String position;
	private String supervisor;
	private String basicSalary;
	private String rice;
	private String phoneAllow;
	private String clothing;
	private String semiRate;
	private String hourlyRate;
	private JLabel lblFirstName;
	public JTextField txtEmpID;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login.main(args);
	}
	
	

	/**
	 * Create the application.
	 */
	public EmployeeDashboard() {
		initialize();
	}

	public EmployeeDashboard(String employeeId) {
		initialize();
		setEmployeeDetails(employeeId);
		frmEmployeeDashboard.setVisible(true);
	}

	public EmployeeDashboard(Employee employee) {
		initialize();
		setEmployeeDetails(employee);
		frmEmployeeDashboard.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeDashboard = new JFrame();
		frmEmployeeDashboard.getContentPane().setBackground(new Color(255, 204, 204));
		frmEmployeeDashboard.setBackground(new Color(255, 192, 203));
		frmEmployeeDashboard.setTitle("Employee Dashboard");
		frmEmployeeDashboard.setBounds(500, 100, 858, 892);
		frmEmployeeDashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEmployeeDashboard.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		java.net.URL logo = EmployeeDashboard.class.getResource("/motorph-logo.png");
		if (logo != null) {
			lblNewLabel.setIcon(new ImageIcon(logo));
		}
		lblNewLabel.setBounds(192, -15, 512, 266);
		frmEmployeeDashboard.getContentPane().add(lblNewLabel);
		
		JLabel lblMotorPh = new JLabel("MotorPh");
		lblMotorPh.setForeground(new Color(245, 255, 250));
		lblMotorPh.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMotorPh.setBounds(10, 11, 181, 49);
		frmEmployeeDashboard.getContentPane().add(lblMotorPh);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					frmEmployeeDashboard.dispose();
					Login.main(null);
			  }
			}
		});
		btnSignOut.setBounds(742, 11, 89, 23);
		frmEmployeeDashboard.getContentPane().add(btnSignOut);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(392, 281, 439, 543);
		frmEmployeeDashboard.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelPersonal = new JPanel();
		panelPersonal.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelPersonal, "name_853578381743300");
		panelPersonal.setLayout(null);
		
		JLabel lblPersonalInfo = new JLabel("Personal Information");
		lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInfo.setBounds(10, 11, 226, 41);
		panelPersonal.add(lblPersonalInfo);
		
		JLabel lblLast = new JLabel("Last Name: ");
		lblLast.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLast.setBounds(10, 63, 124, 19);
		panelPersonal.add(lblLast);
		
		JLabel lblFirstName1 = new JLabel("First Name: ");
		lblFirstName1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName1.setBounds(10, 103, 124, 19);
		panelPersonal.add(lblFirstName1);
		
		JLabel lblBirthday1 = new JLabel("Birthday:");
		lblBirthday1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday1.setBounds(10, 148, 124, 19);
		panelPersonal.add(lblBirthday1);
		
		JLabel lblAddress1 = new JLabel("Address:");
		lblAddress1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress1.setBounds(10, 194, 124, 19);
		panelPersonal.add(lblAddress1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNumber.setBounds(10, 268, 124, 19);
		panelPersonal.add(lblPhoneNumber);
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLastName.setBounds(144, 63, 160, 20);
		panelPersonal.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(144, 104, 160, 20);
		panelPersonal.add(txtFirstName);
		
		txtBirthday = new JTextField();
		txtBirthday.setEditable(false);
		txtBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(144, 149, 160, 20);
		panelPersonal.add(txtBirthday);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(144, 194, 159, 63);
		panelPersonal.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(144, 269, 160, 20);
		panelPersonal.add(txtPhone);
		
		JPanel panelWorkInfo = new JPanel();
		panelWorkInfo.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelWorkInfo, "name_853578403337900");
		panelWorkInfo.setLayout(null);
		
		JLabel lblWorkInfo = new JLabel("Work Information");
		lblWorkInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWorkInfo.setBounds(10, 11, 209, 30);
		panelWorkInfo.add(lblWorkInfo);
		
		JLabel lblEmpNum = new JLabel("Employee Number:");
		lblEmpNum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmpNum.setBounds(10, 62, 149, 24);
		panelWorkInfo.add(lblEmpNum);
		
		JLabel lblStatus1 = new JLabel("Status: ");
		lblStatus1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus1.setBounds(10, 97, 116, 24);
		panelWorkInfo.add(lblStatus1);
		
		JLabel lblImmediateSupervisor = new JLabel("Immediate Supervisor:");
		lblImmediateSupervisor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImmediateSupervisor.setBounds(10, 138, 181, 24);
		panelWorkInfo.add(lblImmediateSupervisor);
		
		JLabel lblPosition1 = new JLabel("Position: ");
		lblPosition1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosition1.setBounds(10, 177, 116, 24);
		panelWorkInfo.add(lblPosition1);
		
		txtEmpNum = new JTextField();
		txtEmpNum.setEditable(false);
		txtEmpNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpNum.setBounds(209, 62, 163, 24);
		panelWorkInfo.add(txtEmpNum);
		txtEmpNum.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStatus.setColumns(10);
		txtStatus.setBounds(209, 97, 163, 24);
		panelWorkInfo.add(txtStatus);
		
		txtSupervisor = new JTextField();
		txtSupervisor.setEditable(false);
		txtSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSupervisor.setColumns(10);
		txtSupervisor.setBounds(209, 138, 163, 24);
		panelWorkInfo.add(txtSupervisor);
		
		txtPosition = new JTextField();
		txtPosition.setEditable(false);
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPosition.setColumns(10);
		txtPosition.setBounds(209, 177, 163, 24);
		panelWorkInfo.add(txtPosition);
		
		JLabel lblSubmittedGovernmentId = new JLabel("Submitted Government ID Numbers");
		lblSubmittedGovernmentId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubmittedGovernmentId.setBounds(10, 249, 391, 30);
		panelWorkInfo.add(lblSubmittedGovernmentId);
		
		JLabel lblSssNumber = new JLabel("SSS Number:");
		lblSssNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSssNumber.setBounds(10, 290, 149, 24);
		panelWorkInfo.add(lblSssNumber);
		
		JLabel lblPhilhealthNumber = new JLabel("PhilHealth Number:");
		lblPhilhealthNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhilhealthNumber.setBounds(10, 325, 168, 24);
		panelWorkInfo.add(lblPhilhealthNumber);
		
		JLabel lblTinNumber = new JLabel("TIN Number:");
		lblTinNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTinNumber.setBounds(10, 366, 181, 24);
		panelWorkInfo.add(lblTinNumber);
		
		JLabel lblPagibigNumber = new JLabel("PAG-IBIG Number:");
		lblPagibigNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagibigNumber.setBounds(10, 405, 181, 24);
		panelWorkInfo.add(lblPagibigNumber);
		
		txtSSS = new JTextField();
		txtSSS.setEditable(false);
		txtSSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSSS.setColumns(10);
		txtSSS.setBounds(209, 290, 163, 24);
		panelWorkInfo.add(txtSSS);
		
		txtPhilHealth = new JTextField();
		txtPhilHealth.setEditable(false);
		txtPhilHealth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhilHealth.setColumns(10);
		txtPhilHealth.setBounds(209, 325, 163, 24);
		panelWorkInfo.add(txtPhilHealth);
		
		txtTIN = new JTextField();
		txtTIN.setEditable(false);
		txtTIN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTIN.setColumns(10);
		txtTIN.setBounds(209, 366, 163, 24);
		panelWorkInfo.add(txtTIN);
		
		txtPagibig = new JTextField();
		txtPagibig.setEditable(false);
		txtPagibig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(209, 405, 163, 24);
		panelWorkInfo.add(txtPagibig);
		
		JPanel panelSalary = new JPanel();
		panelSalary.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelSalary, "name_853578423440500");
		panelSalary.setLayout(null);
		
		JLabel lblSalaryInfo = new JLabel("Salary Information");
		lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSalaryInfo.setBounds(10, 11, 216, 30);
		panelSalary.add(lblSalaryInfo);
		
		JLabel lblSalary = new JLabel("Basic Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(10, 63, 196, 19);
		panelSalary.add(lblSalary);
		
		JLabel lblSemiMonthly = new JLabel("Gross Semi-monthly Rate:");
		lblSemiMonthly.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSemiMonthly.setBounds(10, 212, 196, 19);
		panelSalary.add(lblSemiMonthly);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHourlyRate.setBounds(10, 93, 196, 19);
		panelSalary.add(lblHourlyRate);
		
		JLabel lblRice = new JLabel("Rice Subsidy:");
		lblRice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRice.setBounds(10, 123, 196, 19);
		panelSalary.add(lblRice);
		
		JLabel lblPhone = new JLabel("Phone Allowance: ");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(10, 152, 196, 19);
		panelSalary.add(lblPhone);
		
		JLabel lblClothing = new JLabel("Clothing Allowance:");
		lblClothing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClothing.setBounds(10, 182, 196, 19);
		panelSalary.add(lblClothing);
		
		txtSalary = new JTextField();
		txtSalary.setEditable(false);
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalary.setBounds(250, 62, 115, 20);
		panelSalary.add(txtSalary);
		txtSalary.setColumns(10);
		
		txtHourlyRate = new JTextField();
		txtHourlyRate.setEditable(false);
		txtHourlyRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHourlyRate.setColumns(10);
		txtHourlyRate.setBounds(250, 92, 115, 20);
		panelSalary.add(txtHourlyRate);
		
		txtRice = new JTextField();
		txtRice.setEditable(false);
		txtRice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRice.setColumns(10);
		txtRice.setBounds(250, 122, 115, 20);
		panelSalary.add(txtRice);
		
		txtPhoneAllow = new JTextField();
		txtPhoneAllow.setEditable(false);
		txtPhoneAllow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneAllow.setColumns(10);
		txtPhoneAllow.setBounds(250, 151, 115, 20);
		panelSalary.add(txtPhoneAllow);
		
		txtClothing = new JTextField();
		txtClothing.setEditable(false);
		txtClothing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClothing.setColumns(10);
		txtClothing.setBounds(250, 181, 115, 20);
		panelSalary.add(txtClothing);
		
		txtSemiRate = new JTextField();
		txtSemiRate.setEditable(false);
		txtSemiRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSemiRate.setColumns(10);
		txtSemiRate.setBounds(250, 211, 115, 20);
		panelSalary.add(txtSemiRate);
		
		JPanel panelGovernment = new JPanel();
		panelGovernment.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelGovernment, "name_853578445262900");
		panelGovernment.setLayout(null);
		
		JLabel lblGov = new JLabel("Government ID Numbers ");
		lblGov.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGov.setBounds(10, 11, 281, 32);
		panelGovernment.add(lblGov);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelPersonal);
			}
		});
		btnPersonal.setBounds(392, 247, 89, 23);
		frmEmployeeDashboard.getContentPane().add(btnPersonal);
		
		JButton btnWork = new JButton("Work");
		btnWork.setBackground(UIManager.getColor("Button.background"));
		btnWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelWorkInfo);
			}
		});
		btnWork.setBounds(491, 247, 89, 23);
		frmEmployeeDashboard.getContentPane().add(btnWork);
		
		JButton btnSalary = new JButton("Salary");
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSalary);
			}
		});
		btnSalary.setBounds(590, 247, 89, 23);
		frmEmployeeDashboard.getContentPane().add(btnSalary);
		
		JButton btnGov = new JButton("Government ID");
		btnGov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelGovernment);
			}
		});
		btnGov.setBounds(689, 247, 124, 23);
		frmEmployeeDashboard.getContentPane().add(btnGov);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("C:\\Users\\jimca\\Pictures\\asfasfasf.png"));
		lblIcon.setBounds(110, 235, 162, 173);
		frmEmployeeDashboard.getContentPane().add(lblIcon);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(239, 472, 79, 14);
		frmEmployeeDashboard.getContentPane().add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(62, 472, 89, 14);
		frmEmployeeDashboard.getContentPane().add(lblFirstName);
		
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthday.setBounds(151, 523, 89, 14);
		frmEmployeeDashboard.getContentPane().add(lblBirthday);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(151, 590, 66, 14);
		frmEmployeeDashboard.getContentPane().add(lblAddress);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosition.setBounds(151, 664, 89, 14);
		frmEmployeeDashboard.getContentPane().add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(151, 742, 66, 14);
		frmEmployeeDashboard.getContentPane().add(lblStatus);
		
		txtEmpID = new JTextField();
		txtEmpID.setBounds(120, 406, 131, 20);
		frmEmployeeDashboard.getContentPane().add(txtEmpID);
		txtEmpID.setColumns(10);
		
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void switchPanels(JPanel panel) {
		
	    layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
}
	private void setEmployeeDetails (String EmpID) {
		try {
			Employee employee = employeeManager.findById(EmpID)
					.orElseThrow(() -> new IOException("Employee ID " + EmpID + " was not found."));
			setEmployeeDetails(employee);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frmEmployeeDashboard,
					"Employee profile could not be loaded:\n" + e.getMessage(),
					"Application error", JOptionPane.ERROR_MESSAGE);
			frmEmployeeDashboard.dispose();
		}
	}

	private void setEmployeeDetails(Employee employee) {
		txtEmpID.setText(employee.getEmployeeId());
		txtLastName.setText(employee.getLastName());
		txtFirstName.setText(employee.getFirstName());
		txtBirthday.setText(employee.getBirthday());
		txtAddress.setText(employee.getAddress());
		txtPhone.setText(employee.getPhoneNumber());
		txtSSS.setText(employee.getSssNumber());
		txtPhilHealth.setText(employee.getPhilhealthNumber());
		txtTIN.setText(employee.getTin());
		txtPagibig.setText(employee.getPagibigNumber());
		txtStatus.setText(employee.getStatus());
		txtPosition.setText(employee.getPosition());
		txtSupervisor.setText(employee.getSupervisor());
		txtSalary.setText(employee.getBasicSalary());
		txtRice.setText(employee.getRiceSubsidy());
		txtPhoneAllow.setText(employee.getPhoneAllowance());
		txtClothing.setText(employee.getClothingAllowance());
		txtSemiRate.setText(employee.getGrossSemiMonthlyRate());
		txtHourlyRate.setText(employee.getHourlyRate());
	}
}
