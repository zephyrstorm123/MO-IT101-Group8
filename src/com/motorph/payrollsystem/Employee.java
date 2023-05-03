package com.motorph.payrollsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Employee extends JFrame {
	
	
	private JLabel lblPersonalInfo,lblSalaryInfo, lblEmployeeNo, lblLastName, 
	lblFirstName, lblBirthday, lblAddress, lblPhoneNo, lblSssNo, lblPhic, lblTinNo,
	lblHdmfNo;
	private JTextField txtEmployeeNo, txtLastName, 
	txtFirstName, txtBirthday, txtAddress, txtPhoneNo, txtSssNo, txtPhic, txtTinNo,
	txtHdmfNo;
	// Variables for Salary Info Panel
	private JLabel lblSalEmployeeNo, lblEmployeeStats, lblEmployeePosition, lblSalaryClass,
	lblBasicSalary, lblRiceSubsidy, lblPhoneAllowance, lblClothingAllowance;
	private JTextField txtSalEmployeeNo, txtEmployeeStats, txtEmployeePosition, txtSalaryClass,
	txtBasicSalary, txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance;
	
	JPanel personalInfoPanel, salaryInfoPanel;
	
	private String path = "csv/EmployeeDetails.csv", line = "";
	protected EmployeeDetails[] employee = new EmployeeDetails[25];
	private UserLogin login;
	private static int user, minus = 10001;
	
	public Employee() {
		login = new UserLogin();
		// Swing components
		// Initialize panel for personal information
		personalInfoPanel = new JPanel();
		personalInfoPanel.setLayout(null);
		
		// Personal Info panel components
		lblPersonalInfo = new JLabel("Personal Information");
		lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeNo = new JLabel("Employee No.:");
		lblLastName = new JLabel("Last Name:");
		lblFirstName = new JLabel("First Name");
		lblBirthday = new JLabel("Birthday:");
		lblAddress = new JLabel("Address:");
		lblPhoneNo = new JLabel("Phone No.:");
		lblSssNo= new JLabel("SSS No.:");
		lblPhic = new JLabel("Philhealth No.:");
		lblTinNo = new JLabel("TIN No.:");
		lblHdmfNo = new JLabel("Pag-ibig No.:");
		
		txtEmployeeNo = new JTextField(20);
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeNo.setText(login.user);
		
		txtLastName = new JTextField(20);
		txtLastName.setEnabled(false);
		txtLastName.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtFirstName = new JTextField(20);
		txtFirstName.setEnabled(false);
		txtFirstName.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtBirthday = new JTextField(20);
		txtBirthday.setEnabled(false);
		txtBirthday.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtAddress = new JTextField(20);
		txtAddress.setEnabled(false);
		txtAddress.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtPhoneNo = new JTextField(20);
		txtPhoneNo.setEnabled(false);
		txtPhoneNo.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtSssNo = new JTextField(20);
		txtSssNo.setEnabled(false);
		txtSssNo.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtPhic = new JTextField(20);
		txtPhic.setEnabled(false);
		txtPhic.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtTinNo = new JTextField(20);
		txtTinNo.setEnabled(false);
		txtTinNo.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtHdmfNo = new JTextField(20);
		txtHdmfNo.setEnabled(false);
		txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));
		
	
		
		// Set label and text field positions
		lblPersonalInfo.setBounds(250, 10, 250, 40);
		lblEmployeeNo.setBounds(50, 50, 100, 20);
		txtEmployeeNo.setBounds(150, 50, 150, 20);
		lblLastName.setBounds(50, 80, 100, 20);
		txtLastName.setBounds(150, 80, 150, 20);
		lblFirstName.setBounds(50, 110, 100, 20);
		txtFirstName.setBounds(150, 110, 150, 20);
		lblBirthday.setBounds(50, 140, 100, 20);
		txtBirthday.setBounds(150, 140, 150, 20);
		lblAddress.setBounds(50, 170, 100, 20);
		txtAddress.setBounds(150, 170, 150, 20);
		lblPhoneNo.setBounds(50, 200, 100, 20);
		txtPhoneNo.setBounds(150, 200, 150, 20);
		lblSssNo.setBounds(50, 230, 100, 20);
		txtSssNo.setBounds(150, 230, 150, 20);
		lblPhic.setBounds(320, 50, 100, 20);
		txtPhic.setBounds(420, 50, 150, 20);
		lblTinNo.setBounds(320, 80, 100, 20);
		txtTinNo.setBounds(420, 80, 150, 20);
		lblHdmfNo.setBounds(320, 110, 100, 20);
		txtHdmfNo.setBounds(420, 110, 150, 20);
		
		// Add components to personal info panel
		personalInfoPanel.add(lblPersonalInfo);
		personalInfoPanel.add(lblEmployeeNo);
		personalInfoPanel.add(txtEmployeeNo);
		personalInfoPanel.add(lblLastName);
		personalInfoPanel.add(txtLastName);
		personalInfoPanel.add(lblFirstName);
		personalInfoPanel.add(txtFirstName);
		personalInfoPanel.add(lblBirthday);
		personalInfoPanel.add(txtBirthday);
		personalInfoPanel.add(lblAddress);
		personalInfoPanel.add(txtAddress);
		personalInfoPanel.add(lblPhoneNo);
		personalInfoPanel.add(txtPhoneNo);
		personalInfoPanel.add(lblSssNo);
		personalInfoPanel.add(txtSssNo);
		personalInfoPanel.add(lblPhic);
		personalInfoPanel.add(txtPhic);
		personalInfoPanel.add(lblTinNo);
		personalInfoPanel.add(txtTinNo);
		personalInfoPanel.add(lblHdmfNo);
		personalInfoPanel.add(txtHdmfNo);
		
		// Initialize panel for salary info
		salaryInfoPanel = new JPanel();
		salaryInfoPanel.setLayout(null);
		
		// Salary Info Panel components
		lblSalaryInfo = new JLabel("Salary Information");
		lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalEmployeeNo = new JLabel("Employee No.:");
		lblEmployeeStats = new JLabel("Employee Status:");
		lblEmployeePosition = new JLabel("Employee Position:");
		lblSalaryClass = new JLabel("Salary Class:");
		lblBasicSalary = new JLabel("Basic Salary:");
		lblRiceSubsidy = new JLabel("Rice Subsidy:");
		lblPhoneAllowance = new JLabel("Phone Allowance:");
		lblClothingAllowance = new JLabel("Clothing Subsidy:");
		
		txtSalEmployeeNo = new JTextField(20);
		txtSalEmployeeNo.setEnabled(false);
		txtSalEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtEmployeeStats = new JTextField(20);
		txtEmployeeStats.setEnabled(false);
		txtEmployeeStats.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtEmployeePosition	= new JTextField(20);
		txtEmployeePosition.setEnabled(false);
		txtEmployeePosition.setDisabledTextColor(new Color(128, 128, 128));
		
		 
		txtSalaryClass = new JTextField(20);
		txtSalaryClass.setEnabled(false);
		txtSalaryClass.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtBasicSalary = new JTextField(20);
		txtBasicSalary.setEnabled(false);
		txtBasicSalary.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtRiceSubsidy = new JTextField(20);
		txtRiceSubsidy.setEnabled(false);
		txtRiceSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtPhoneAllowance = new JTextField(20);
		txtPhoneAllowance.setEnabled(false);
		txtPhoneAllowance.setDisabledTextColor(new Color(128, 128, 128));
		
		
		txtClothingAllowance = new JTextField(20);
		txtClothingAllowance.setEnabled(false);
		txtClothingAllowance.setDisabledTextColor(new Color(128, 128, 128));
		
		
		// Set label and text field positions
		lblSalaryInfo.setBounds(250, 10, 150, 40);
		lblSalEmployeeNo.setBounds(20, 60, 100, 20);
		txtSalEmployeeNo.setBounds(150, 60, 150, 20);
		lblEmployeeStats.setBounds(320, 60, 100, 20);
		txtEmployeeStats.setBounds(430, 60, 150, 20);
		lblEmployeePosition.setBounds(20, 100, 120, 20);
		txtEmployeePosition.setBounds(150, 100, 150, 20);
		lblSalaryClass.setBounds(320, 100, 100, 20);
		txtSalaryClass.setBounds(430, 100, 150, 20);
		lblBasicSalary.setBounds(20, 140, 100, 20);
		txtBasicSalary.setBounds(150, 140, 150, 20);
		lblRiceSubsidy.setBounds(320, 140, 100, 20);
		txtRiceSubsidy.setBounds(430, 140, 150, 20);
		lblPhoneAllowance.setBounds(20, 180, 120, 20);
		txtPhoneAllowance.setBounds(150, 180, 150, 20);
		lblClothingAllowance.setBounds(320, 180, 110, 20);
		txtClothingAllowance.setBounds(430, 180, 150, 20);

		// Add components to salary info panel
		salaryInfoPanel.add(lblSalaryInfo);
		salaryInfoPanel.add(lblSalEmployeeNo);
		salaryInfoPanel.add(txtSalEmployeeNo);
		salaryInfoPanel.add(lblEmployeeStats);
		salaryInfoPanel.add(lblEmployeePosition);
		salaryInfoPanel.add(lblSalaryClass);
		salaryInfoPanel.add(lblBasicSalary);
		salaryInfoPanel.add(lblRiceSubsidy);
		salaryInfoPanel.add(lblPhoneAllowance);
		salaryInfoPanel.add(lblClothingAllowance);
		salaryInfoPanel.add(txtEmployeeStats);
		salaryInfoPanel.add(txtEmployeePosition);
		salaryInfoPanel.add(txtSalaryClass);
		salaryInfoPanel.add(txtBasicSalary);
		salaryInfoPanel.add(txtRiceSubsidy);
		salaryInfoPanel.add(txtPhoneAllowance);
		salaryInfoPanel.add(txtClothingAllowance);
		
		
		// Add main panel to the frame
		getContentPane().add(personalInfoPanel);
		
		// Set-up the frame
		setTitle("Employee Info Menu");
		setSize(630,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
    	    public void windowClosing(WindowEvent e) {
    	        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
    	        if (confirm == JOptionPane.YES_OPTION) {
    	            // Close the application
    	            System.exit(0);
    	        }
    	    }
    	});
		setResizable(true);
		    	
		// Sets icon image for the application
		ImageIcon icon = new ImageIcon("MOTORPH.png");
		setIconImage(icon.getImage());
		    	
		personalInfoPanel.setVisible(true);

		
	}
	
	public void readCsvFile() {
		//Read from EmployeeDetails.csv
		if (login.user != null) {
		user = Integer.parseInt(login.user);
		}
		try {
	        BufferedReader br = new BufferedReader(new FileReader(path));
	        int i = 0;

	        while ((line = br.readLine()) != null) {

	            String[] values = line.split(",");
	            
	         // check if any value is empty or null
	            boolean hasEmptyValue = false;
	            for (String value : values) {
	                if (value == null || value.isEmpty()) {
	                    hasEmptyValue = true;
	                    break;
	                }
	            }

	            	if (hasEmptyValue) {
	                // skip this line
	                continue;
	            }
	            employee[i] = new EmployeeDetails(values[0], values[1], values[2], values[3], values[4], values[5],
	                    values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13],
	                    values[14], values[15], values[16], values[17], values[18]);
	            
	            i++;
	        }
	        br.close();
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void displayPersonalInfo() {
		readCsvFile();
		txtLastName.setText(employee[user - minus].lname);
		txtFirstName.setText(employee[user - minus].fname);
		txtBirthday.setText(employee[user - minus].bday);
		txtAddress.setText(employee[user - minus].address);
		txtPhoneNo.setText(employee[user - minus].phoneNumber);
		txtSssNo.setText(employee[user - minus].sssNumber);
		txtPhic.setText(employee[user - minus].philHealthNumber);
		txtTinNo.setText(employee[user - minus].tinNumber);
		txtHdmfNo.setText(employee[user - minus].pagIbigNumber);
//    	setContentPane(personalInfoPanel);
//    	setVisible(true);
//    	// Repaint the frame
//        revalidate();
//        repaint();
		
	}
	
	public void displaySalaryRecords() {
		readCsvFile();
		txtSalEmployeeNo.setText(user + "");
		txtEmployeeStats.setText(employee[user - minus].status);
		txtEmployeePosition.setText(employee[user - minus].position);
		txtSalaryClass.setText(employee[user - minus].basicSalary);
		txtBasicSalary.setText("PHP " + employee[user - minus].basicSalary + ".00");
		txtRiceSubsidy.setText("PHP " + employee[user - minus].riceSubsidy + ".00");
		txtPhoneAllowance.setText("PHP " + employee[user - minus].phoneAllowance + ".00");
		txtClothingAllowance.setText("PHP " + employee[user - minus].clothingAllowance + ".00");
//		setContentPane(salaryInfoPanel);
//    	setVisible(true);
//    	// Repaint the frame
//        revalidate();
//        repaint();
	}
	
		
	
}
