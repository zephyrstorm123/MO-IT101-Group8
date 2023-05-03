package com.motorph.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UserAdmin extends JFrame {

	private JTextField txtTemPass;
	private String[] available = new String[25];
	private String[] savedEmpNo = PrintNReadTxt.savedEmpNo;
	private PrintNReadTxt print = new PrintNReadTxt();
	JComboBox comboBoxAvailableEmpNo, comboBoxActiveAccounts, comboBoxSystemRole;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserAdmin frame = new UserAdmin();
//					frame.findAvailableEmployeeNumbers();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void displayUserAdmin() {
		findAvailableEmployeeNumbers();
		findActiveAccounts();
		setVisible(true);
	}
	
	public void findAvailableEmployeeNumbers() {
		print.printRead();
		int index = 0;
		
		// clear the combo box & array
		available = new String[25];
		
		// loop through all employee numbers from 10001 to 10025
		for (int i = 10001; i <= 10025; i++) {
		    String search = String.valueOf(i);
		    
		    // check if the current number is in the savedEmpNo array
		    boolean found = false;
		    for (UserDetails userDetail : PrintNReadTxt.user) {
		        if (userDetail != null) {
		        	if (userDetail.employeeNumber.equals(search)) {
		        		found = true;
		        		break;
		            }
		        }
		    }
		    // if the current number is not in the savedEmpNo array, add it to the available array
		    if (!found) {
		        available[index] = search;
		        index++;
		    }
		} 

		// clear the combo box
		comboBoxAvailableEmpNo.removeAllItems();

		// add the items to the combo box
		for (String empNo : available) {
		    if (empNo != null) {
		        comboBoxAvailableEmpNo.addItem(empNo);
		    }
		}
	}
	
	public void findActiveAccounts() {
		print.printRead();
		// clear the combo box
		comboBoxActiveAccounts.removeAllItems();
		
		// add the items to the combo box
		for (UserDetails userDetail : PrintNReadTxt.user) {
			if (userDetail != null) {
				if (!userDetail.employeeNumber.equals("null")) {
					if (!userDetail.employeeNumber.equals(PrintNReadTxt.employee[0].employeeNumber) && 
						!userDetail.employeeNumber.equals(UserLogin.user)) {
						comboBoxActiveAccounts.addItem(userDetail.employeeNumber);
				}
			}
		}
	}
}
	
	public void createNewAccount() {
		int newEmp = Integer.parseInt((String) comboBoxAvailableEmpNo.getSelectedItem());
		String newPass = txtTemPass.getText();
		int empNo = newEmp - 10001;
		
		if (newPass.equals("")) {
			JOptionPane.showMessageDialog(null, "        Please enter password.", "Input Error", JOptionPane.WARNING_MESSAGE);
			return;
		} else if (newPass.length() < 8) {
			JOptionPane.showMessageDialog(null, "Password should contain atleast 8 characters.", "Input Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (comboBoxSystemRole.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Please enter new account system role.", "Input Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		updateCsv(empNo, newEmp + "", newPass, comboBoxSystemRole.getSelectedItem(), "Active");
		
		JOptionPane.showMessageDialog(null, "Account for employee " + newEmp + " created.", "Create New Successful", JOptionPane.INFORMATION_MESSAGE);
		 
	}
	
	public void deleteAccount() {
		int delEmp = Integer.parseInt((String) comboBoxActiveAccounts.getSelectedItem());
		int delIndex = delEmp - 10001;
		
		int confirm = JOptionPane.showConfirmDialog(null, "Delete " + delEmp + "'s Employee Account?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		
		
		
		updateCsv(delIndex, null, null, null, null);
		
		JOptionPane.showMessageDialog(null, "Account for employee " + delEmp + " deleted.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void updateCsv(int empIndex, String newEmp, String newPass, Object object, String status) {
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("csv/LogInCredentials.csv"));
	     // loop through the user array and write to the CSV file
	        	for (int i = 0; i < PrintNReadTxt.user.length; i++) {
//	        		if (PrintNReadTxt.user[i] != null) {
	        			// if i is equal to new employee number, write the entered details on that index/line
	        			if (i == empIndex) {
	        				writer.write(newEmp + "," +
	        						 newPass + "," +
	        						 object + "," +
	        						 status);
	        				 writer.newLine();
	        			} else if (PrintNReadTxt.user[i] == null) { 
	        				continue;
	        			} else {
	        				// write the original user detail to the CSV file
	        				writer.write(PrintNReadTxt.user[i].employeeNumber + "," +
	        						PrintNReadTxt.user[i].password + "," +
	        						PrintNReadTxt.user[i].systemRole + "," +
	        						PrintNReadTxt.user[i].accountStatus);
	        				 writer.newLine();
	        			}
//	        		}
	        }
	        writer.close();
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public UserAdmin() {
		setTitle("Payroll Account Administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(527, 311);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	setIconImage(icon.getImage());
		
		JLabel lblUserAdministration = new JLabel("User Administration");
		lblUserAdministration.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAdministration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserAdministration.setBounds(143, 23, 225, 17);
		getContentPane().add(lblUserAdministration);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 51, 491, 171);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Create New", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSelectAvailableEmp = new JLabel("Select Available Emp #:");
		lblSelectAvailableEmp.setBounds(10, 26, 161, 14);
		panel.add(lblSelectAvailableEmp);
		
		comboBoxAvailableEmpNo = new JComboBox(available);
		comboBoxAvailableEmpNo.setBounds(188, 22, 197, 22);
		panel.add(comboBoxAvailableEmpNo);
		
		JLabel lblEnterTemporaryPassword = new JLabel("Enter Temporary Password:");
		lblEnterTemporaryPassword.setBounds(10, 56, 161, 14);
		panel.add(lblEnterTemporaryPassword);
		
		txtTemPass = new JTextField();
		txtTemPass.setBounds(188, 53, 197, 20);
		panel.add(txtTemPass);
		txtTemPass.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(166, 132, 80, 23);
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewAccount();
				txtTemPass.setText("");
				comboBoxSystemRole.setSelectedIndex(0);
				findAvailableEmployeeNumbers();
				findActiveAccounts();
			}
		});
		panel.add(btnCreate);
		
		JLabel lblEnterSystemRole = new JLabel("Enter System Role:");
		lblEnterSystemRole.setBounds(10, 86, 161, 14);
		panel.add(lblEnterSystemRole);
		
		comboBoxSystemRole = new JComboBox(new Object[]{});
		comboBoxSystemRole.setModel(new DefaultComboBoxModel(new String[] {"---", "Admin", "User"}));
		comboBoxSystemRole.setBounds(188, 82, 197, 22);
		panel.add(comboBoxSystemRole);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSelectAccountTo = new JLabel("Select Account to Delete:");
		lblSelectAccountTo.setBounds(10, 26, 161, 14);
		panel_1.add(lblSelectAccountTo);
		
		comboBoxActiveAccounts = new JComboBox(new Object[]{});
		comboBoxActiveAccounts.setBounds(188, 22, 197, 22);
		panel_1.add(comboBoxActiveAccounts);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(166, 132, 80, 23);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAccount();
				findAvailableEmployeeNumbers();
				findActiveAccounts();
			}
		});
		panel_1.add(btnDelete);
	}
}
