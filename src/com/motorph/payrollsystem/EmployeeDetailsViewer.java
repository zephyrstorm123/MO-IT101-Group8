package com.motorph.payrollsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class EmployeeDetailsViewer extends EmployeeMaster {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtEmployeeNo;
	private JTextField txtBday;
	private JTextField txtAdress;
	private JTextField txtLname;
	private JTextField txtFname;
	private JTextField txtPhoneNumber;
	private JTextField txtSssNo;
	private JTextField txtTin;
	private JTextField txtPhilHealthNo;
	private JTextField txtPagibigNo;
	private JTextField txtStatus;
	private JTextField txtImmediateSupervisor;
	private JTextField txtPosition;
	
	private int selection;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_18;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	
	protected String[] payPeriod = {"======= Pay Period =======",
	  "1st Week September 2022", "2nd Week September 2022"}; // For JComboBox use
	
	protected double[] allEmpRate, weeklyPay, empHrsWkd;
	private PrintNReadTxt printRead;
	private HoursWorked hours;
	private JTextField textField_13;
	private JButton btnEdit, btnCancel, btnUpdate;
	private JComboBox<Object> comboBoxStatus = new JComboBox<Object>(new Object[]{});;
	
	/**
	 * Launch the application.
	 */
	public  void viewDetails() {
		readCsvFile();
		
 		if (employee[selection].employeeNumber.equals("10001")) {
			btnEdit.setEnabled(false);
			System.out.println(selection);
		} else {
			btnEdit.setEnabled(true);
		}
		// Set Text Commands
		txtEmployeeNo.setText(employee[selection].employeeNumber);
		txtLname.setText(employee[selection].lname);
		txtPhoneNumber.setText(employee[selection].phoneNumber);
		txtBday.setText(employee[selection].bday);
		txtAdress.setText(employee[selection].address);
		txtFname.setText(employee[selection].fname);
		txtSssNo.setText(employee[selection].sssNumber);
		txtPhilHealthNo.setText(employee[selection].philHealthNumber);
		txtTin.setText(employee[selection].tinNumber);
		txtPagibigNo.setText(employee[selection].pagIbigNumber);
//		txtStatus.setText(employee[selection].status);
		
		int i = -1;
		if (employee[selection].status.equals("Regular")) {
			i = 0;
		} else if (employee[selection].status.equals("Probationary")) {
			i = 1;
		}
		
		comboBoxStatus.setSelectedIndex(i);
		txtPosition.setText(employee[selection].position);
		txtImmediateSupervisor.setText(employee[selection].immediateSupervisor);
	}

	/**
	 * Create the frame.
	 */
	public EmployeeDetailsViewer() {
		super();
		printRead = new PrintNReadTxt();
		hours = new HoursWorked();
		printRead.printRead();
		allEmpRate = printRead.getAllEmpRate();
		weeklyPay = printRead.getWeeklyPay();
		empHrsWkd = printRead.getEmpHrsWkd();
		DecimalFormat df = new DecimalFormat("###,###.00");
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(765,445);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	frame.setIconImage(icon.getImage());
		
		JLabel lblMotorphEmployeeMaster = new JLabel("MotorPH Employee Master");
		lblMotorphEmployeeMaster.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotorphEmployeeMaster.setBounds(285, 27, 184, 17);
		frame.getContentPane().add(lblMotorphEmployeeMaster);
		
		JPanel payrollInformationPanel = new JPanel();
		payrollInformationPanel.setLayout(null);
		payrollInformationPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel.setBounds(10, 55, 729, 106);
		frame.getContentPane().add(payrollInformationPanel);
		
		JLabel lblPayrollInformation = new JLabel("EMPLOYEE INFORMATION");
		lblPayrollInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayrollInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPayrollInformation.setBounds(277, 6, 159, 14);
		payrollInformationPanel.add(lblPayrollInformation);
		
		JLabel lblEmployeeName = new JLabel("Employee No.:");
		lblEmployeeName.setBounds(10, 29, 102, 14);
		payrollInformationPanel.add(lblEmployeeName);
		
		JLabel lblPayrollPeriod = new JLabel("Birthday:");
		lblPayrollPeriod.setBounds(10, 54, 84, 14);
		payrollInformationPanel.add(lblPayrollPeriod);
		
		txtEmployeeNo = new JTextField();
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setDisabledTextColor(Color.GRAY);
		txtEmployeeNo.setColumns(10);
		txtEmployeeNo.setBounds(110, 26, 125, 20);
		payrollInformationPanel.add(txtEmployeeNo);
		
		txtBday = new JTextField();
		txtBday.setEnabled(false);
		txtBday.setDisabledTextColor(Color.GRAY);
		txtBday.setColumns(10);
		txtBday.setBounds(110, 51, 125, 20);
		payrollInformationPanel.add(txtBday);
		
		txtAdress = new JTextField();
		txtAdress.setEnabled(false);
		txtAdress.setDisabledTextColor(Color.GRAY);
		txtAdress.setColumns(10);
		txtAdress.setBounds(312, 51, 407, 20);
		payrollInformationPanel.add(txtAdress);
		
		txtLname = new JTextField();
		txtLname.setEnabled(false);
		txtLname.setDisabledTextColor(Color.GRAY);
		txtLname.setColumns(10);
		txtLname.setBounds(312, 26, 158, 20);
		payrollInformationPanel.add(txtLname);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(245, 29, 102, 14);
		payrollInformationPanel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(245, 54, 84, 14);
		payrollInformationPanel.add(lblAddress);
		
		txtFname = new JTextField();
		txtFname.setEnabled(false);
		txtFname.setDisabledTextColor(Color.GRAY);
		txtFname.setColumns(10);
		txtFname.setBounds(545, 26, 174, 20);
		payrollInformationPanel.add(txtFname);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(479, 29, 102, 14);
		payrollInformationPanel.add(lblFirstName);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEnabled(false);
		txtPhoneNumber.setDisabledTextColor(Color.GRAY);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(110, 76, 125, 20);
		payrollInformationPanel.add(txtPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 79, 92, 14);
		payrollInformationPanel.add(lblPhoneNumber);
		
		JPanel payrollInformationPanel_1 = new JPanel();
		payrollInformationPanel_1.setLayout(null);
		payrollInformationPanel_1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel_1.setBounds(10, 168, 371, 79);
		frame.getContentPane().add(payrollInformationPanel_1);
		
		JLabel lblGovernmentIdentification = new JLabel("GOVERNMENT IDENTIFICATION");
		lblGovernmentIdentification.setHorizontalAlignment(SwingConstants.CENTER);
		lblGovernmentIdentification.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGovernmentIdentification.setBounds(89, 6, 193, 14);
		payrollInformationPanel_1.add(lblGovernmentIdentification);
		
		JLabel lblSssNo = new JLabel("SSS No.:");
		lblSssNo.setBounds(10, 29, 102, 14);
		payrollInformationPanel_1.add(lblSssNo);
		
		JLabel lblTin = new JLabel("TIN:");
		lblTin.setBounds(10, 54, 84, 14);
		payrollInformationPanel_1.add(lblTin);
		
		txtSssNo = new JTextField();
		txtSssNo.setEnabled(false);
		txtSssNo.setDisabledTextColor(Color.GRAY);
		txtSssNo.setColumns(10);
		txtSssNo.setBounds(62, 26, 102, 20);
		payrollInformationPanel_1.add(txtSssNo);
		
		txtTin = new JTextField();
		txtTin.setEnabled(false);
		txtTin.setDisabledTextColor(Color.GRAY);
		txtTin.setColumns(10);
		txtTin.setBounds(62, 51, 102, 20);
		payrollInformationPanel_1.add(txtTin);
		
		JLabel lblPhilhealthNo = new JLabel("PhilHealth No.:");
		lblPhilhealthNo.setBounds(169, 29, 102, 14);
		payrollInformationPanel_1.add(lblPhilhealthNo);
		
		JLabel lblPagibigNo = new JLabel("Pagibig No.:");
		lblPagibigNo.setBounds(169, 54, 84, 14);
		payrollInformationPanel_1.add(lblPagibigNo);
		
		txtPhilHealthNo = new JTextField();
		txtPhilHealthNo.setEnabled(false);
		txtPhilHealthNo.setDisabledTextColor(Color.GRAY);
		txtPhilHealthNo.setColumns(10);
		txtPhilHealthNo.setBounds(259, 26, 102, 20);
		payrollInformationPanel_1.add(txtPhilHealthNo);
		
		txtPagibigNo = new JTextField();
		txtPagibigNo.setEnabled(false);
		txtPagibigNo.setDisabledTextColor(Color.GRAY);
		txtPagibigNo.setColumns(10);
		txtPagibigNo.setBounds(259, 51, 102, 20);
		payrollInformationPanel_1.add(txtPagibigNo);
		
		JPanel payrollInformationPanel_1_1 = new JPanel();
		payrollInformationPanel_1_1.setLayout(null);
		payrollInformationPanel_1_1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel_1_1.setBounds(388, 168, 351, 79);
		frame.getContentPane().add(payrollInformationPanel_1_1);
		
		JLabel lblEmployeeStatus = new JLabel("EMPLOYEE STATUS");
		lblEmployeeStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeStatus.setBounds(89, 6, 193, 14);
		payrollInformationPanel_1_1.add(lblEmployeeStatus);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 29, 102, 14);
		payrollInformationPanel_1_1.add(lblStatus);
		
		JLabel lblImmediateSupervisor = new JLabel("Immediate Supervisor:");
		lblImmediateSupervisor.setBounds(43, 54, 134, 14);
		payrollInformationPanel_1_1.add(lblImmediateSupervisor);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setVisible(false);
		txtStatus.setEnabled(false);
		txtStatus.setDisabledTextColor(Color.GRAY);
		txtStatus.setColumns(10);
		txtStatus.setBounds(10, 3, 86, 20);
		payrollInformationPanel_1_1.add(txtStatus);
		
		txtImmediateSupervisor = new JTextField();
		txtImmediateSupervisor.setEnabled(false);
		txtImmediateSupervisor.setDisabledTextColor(Color.GRAY);
		txtImmediateSupervisor.setColumns(10);
		txtImmediateSupervisor.setBounds(187, 51, 127, 20);
		payrollInformationPanel_1_1.add(txtImmediateSupervisor);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(154, 29, 102, 14);
		payrollInformationPanel_1_1.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setEnabled(false);
		txtPosition.setDisabledTextColor(Color.GRAY);
		txtPosition.setColumns(10);
		txtPosition.setBounds(207, 26, 134, 20);
		payrollInformationPanel_1_1.add(txtPosition);
		comboBoxStatus.setEnabled(false);
		
		
		comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxStatus.setModel(new DefaultComboBoxModel<Object>(new String[] {"Regular", "Probationary"}));
		comboBoxStatus.setBounds(56, 27, 88, 20);
		UIManager.put( "ComboBox.disabledForeground", Color.GRAY );
		
		payrollInformationPanel_1_1.add(comboBoxStatus);
		
		JPanel payrollInformationPanel_2 = new JPanel();
		payrollInformationPanel_2.setLayout(null);
		payrollInformationPanel_2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel_2.setBounds(10, 253, 729, 106);
		frame.getContentPane().add(payrollInformationPanel_2);
		
		JLabel lblPayDetails = new JLabel("PAY DETAILS");
		lblPayDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPayDetails.setBounds(277, 6, 159, 14);
		payrollInformationPanel_2.add(lblPayDetails);
		
		JLabel lblPayrollPeriod_2 = new JLabel("Payroll Period:");
		lblPayrollPeriod_2.setBounds(156, 29, 102, 14);
		payrollInformationPanel_2.add(lblPayrollPeriod_2);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setBounds(10, 54, 84, 14);
		payrollInformationPanel_2.add(lblHourlyRate);
		
		textField_14 = new JTextField();
		textField_14.setEnabled(false);
		textField_14.setDisabledTextColor(Color.GRAY);
		textField_14.setColumns(10);
		textField_14.setBounds(110, 51, 125, 20);
		payrollInformationPanel_2.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEnabled(false);
		textField_15.setDisabledTextColor(Color.GRAY);
		textField_15.setColumns(10);
		textField_15.setBounds(379, 51, 92, 20);
		payrollInformationPanel_2.add(textField_15);
		
		JLabel lblBasicPay = new JLabel("Basic Pay:");
		lblBasicPay.setBounds(245, 54, 84, 14);
		payrollInformationPanel_2.add(lblBasicPay);
		
		textField_18 = new JTextField();
		textField_18.setEnabled(false);
		textField_18.setDisabledTextColor(Color.GRAY);
		textField_18.setColumns(10);
		textField_18.setBounds(110, 76, 125, 20);
		payrollInformationPanel_2.add(textField_18);
		
		JLabel lblDeductions = new JLabel("Deductions:");
		lblDeductions.setBounds(10, 79, 92, 14);
		payrollInformationPanel_2.add(lblDeductions);
		
		textField_16 = new JTextField();
		textField_16.setEnabled(false);
		textField_16.setDisabledTextColor(Color.GRAY);
		textField_16.setColumns(10);
		textField_16.setBounds(553, 48, 166, 20);
		payrollInformationPanel_2.add(textField_16);
		
		JLabel lblAllowances = new JLabel("Allowances:");
		lblAllowances.setBounds(479, 51, 102, 14);
		payrollInformationPanel_2.add(lblAllowances);
		
		JLabel lblGrossPay = new JLabel("Gross Pay:");
		lblGrossPay.setBounds(245, 78, 84, 14);
		payrollInformationPanel_2.add(lblGrossPay);
		
		textField_17 = new JTextField();
		textField_17.setEnabled(false);
		textField_17.setDisabledTextColor(Color.GRAY);
		textField_17.setColumns(10);
		textField_17.setBounds(312, 75, 159, 20);
		payrollInformationPanel_2.add(textField_17);
		
		JLabel lblNetPay = new JLabel("Net Pay:");
		lblNetPay.setBounds(479, 75, 102, 14);
		payrollInformationPanel_2.add(lblNetPay);
		
		textField_19 = new JTextField();
		textField_19.setEnabled(false);
		textField_19.setDisabledTextColor(Color.GRAY);
		textField_19.setColumns(10);
		textField_19.setBounds(553, 72, 166, 20);
		payrollInformationPanel_2.add(textField_19);
		
		JComboBox<Object> comboBoxPayPeriod = new JComboBox<Object>(payPeriod);
		comboBoxPayPeriod.setModel(new DefaultComboBoxModel(new String[] {"======= Pay Period =======", "1st Week September 2022", "2nd Week September 2022"}));
		comboBoxPayPeriod.setBounds(256, 23, 208, 20);
		payrollInformationPanel_2.add(comboBoxPayPeriod);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(472, 23, 64, 20);
		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[0])) {
					
					JOptionPane.showMessageDialog(EmployeeDetailsViewer.this, "       Please select pay period.", "Invalid Input", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[1])) {
				textField_14.setText("PHP " + allEmpRate[selection]);
				textField_13.setText(hours.calculateWeeklyHoursWorked(1, selection + 1) + "");
				textField_15.setText("PHP " +  df.format(weeklyPay[selection]));
				
				double sss = CalculateSSS.SSS(weeklyPay[selection]), pagibig = CalculatePagIbig.PagIbig(weeklyPay[selection]), philhealth = CalculatePhilhealth.Philhealth(weeklyPay[selection]),
						withholding = CalculateWitholdingTax.WitholdingTax(weeklyPay[selection],
								   CalculatePhilhealth.Philhealth(weeklyPay[selection]),
								   CalculatePagIbig.PagIbig(weeklyPay[selection]),
								   CalculateSSS.SSS(weeklyPay[selection]));
				
				if (selection < 14) {
					textField_16.setText("PHP 875.00");
					textField_17.setText("PHP " + df.format(weeklyPay[selection] + 875.0));
					textField_19.setText("PHP " + df.format(weeklyPay[selection] + 875.0 - (sss + pagibig + philhealth + withholding)));
				} else {
					textField_16.setText("PHP 0.00");
					textField_17.setText("PHP " + df.format(weeklyPay[selection]));
					textField_19.setText("PHP " + df.format(weeklyPay[selection] + 0.0 - (sss + pagibig + philhealth + withholding)));
				}
				
				// Deductions
				textField_18.setText("PHP " + df.format(sss + pagibig + philhealth + withholding));
				
				} else if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[2])) {
					textField_14.setText("PHP " + allEmpRate[selection]);
					textField_13.setText(hours.calculateWeeklyHoursWorked(2, selection + 1) + "");
					textField_15.setText("PHP " + df.format(weeklyPay[selection+25]));
					
					double sss = CalculateSSS.SSS(weeklyPay[selection + 25]), pagibig = CalculatePagIbig.PagIbig(weeklyPay[selection + 25]), philhealth = CalculatePhilhealth.Philhealth(weeklyPay[selection + 25]),
							withholding = CalculateWitholdingTax.WitholdingTax(weeklyPay[selection + 25],
									   CalculatePhilhealth.Philhealth(weeklyPay[selection + 25]),
									   CalculatePagIbig.PagIbig(weeklyPay[selection + 25]),
									   CalculateSSS.SSS(weeklyPay[selection + 25]));
					
					if (selection < 14) {
						textField_16.setText("PHP 875.00");
						textField_17.setText("PHP " + df.format(weeklyPay[selection + 25] + 875.0));
						textField_19.setText("PHP " + df.format(weeklyPay[selection + 25] + 875.0 - (sss + pagibig + philhealth + withholding)));
					} else {
						textField_16.setText("PHP 0.00");
						textField_17.setText("PHP " + df.format(weeklyPay[selection + 25]));
						textField_19.setText("PHP " + df.format(weeklyPay[selection] + 0.0 - (sss + pagibig + philhealth + withholding)));
					}
					
					// Deductions
					textField_18.setText("PHP " + df.format(sss + pagibig + philhealth + withholding));
				}
				
			}
		});
		payrollInformationPanel_2.add(btnView);
		
		textField_13 = new JTextField();
		textField_13.setEnabled(false);
		textField_13.setDisabledTextColor(Color.GRAY);
		textField_13.setColumns(10);
		textField_13.setBounds(312, 51, 34, 20);
		payrollInformationPanel_2.add(textField_13);
		
		JLabel lblHrs = new JLabel("hrs");
		lblHrs.setBounds(352, 54, 84, 14);
		payrollInformationPanel_2.add(lblHrs);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(661, 370, 64, 23);
		frame.getContentPane().add(btnBack);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(100, 370, 81, 23);
		btnUpdate.setVisible(false);
		
		frame.getContentPane().add(btnUpdate);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(27, 370, 64, 23);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(189, 370, 79, 23);
		btnCancel.setVisible(false);
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEdit.setEnabled(false);
				btnUpdate.setVisible(true);
				btnCancel.setVisible(true);
				txtFname.setEnabled(true);
				txtLname.setEnabled(true);
				txtBday.setEnabled(true);
				txtAdress.setEnabled(true);
				txtPhoneNumber.setEnabled(true);
				comboBoxStatus.setEnabled(true);
				txtPosition.setEnabled(true);
				txtImmediateSupervisor.setEnabled(true);
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 int confirm = JOptionPane.showConfirmDialog(null, "Save changes?", "Confirm Update", JOptionPane.YES_NO_CANCEL_OPTION);
	    	        if (confirm == JOptionPane.YES_OPTION) {
	    	            // Save changes to CSV file
	    	            
				btnEdit.setEnabled(true);
				btnUpdate.setVisible(false);
				btnCancel.setVisible(false);
				txtFname.setEnabled(false);
				txtLname.setEnabled(false);
				txtBday.setEnabled(false);
				txtAdress.setEnabled(false);
				txtPhoneNumber.setEnabled(false);
				comboBoxStatus.setEnabled(false);
				txtPosition.setEnabled(false);
				txtImmediateSupervisor.setEnabled(false);
				setNewDetails(txtLname.getText(), txtFname.getText(), txtBday.getText(), txtAdress.getText(), 
						txtPhoneNumber.getText(), (String) comboBoxStatus.getSelectedItem(), txtPosition.getText(), 
						txtImmediateSupervisor.getText());
				updateCsv(selection);
				
				
	    	        } else if (confirm == JOptionPane.NO_OPTION) {
	    	        	cancelUpdate();
	    	        }
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelUpdate();
			}
		});

		frame.getContentPane().add(btnEdit);
		frame.getContentPane().add(btnCancel);
		
		
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				viewEmployeeMaster();
			}
		});
		
		frame.setVisible(true);
		
		
		
	}
	
	public void setSelection(int selection) {
        this.selection = selection;
    }
	
	public void cancelUpdate() {
		viewDetails();
		btnEdit.setEnabled(true);
		btnUpdate.setVisible(false);
		btnCancel.setVisible(false);
		txtFname.setEnabled(false);
		txtLname.setEnabled(false);
		txtBday.setEnabled(false);
		txtAdress.setEnabled(false);
		txtPhoneNumber.setEnabled(false);
		comboBoxStatus.setEnabled(false);
		txtPosition.setEnabled(false);
		txtImmediateSupervisor.setEnabled(false);
	}
}
