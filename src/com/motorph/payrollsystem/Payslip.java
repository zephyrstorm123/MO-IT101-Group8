package com.motorph.payrollsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Payslip extends JFrame {

	JPanel contentPane;
	protected JTextField txtEmployeeName, txtPayrollPeriod, txtPayDate, txtEmployeeNo, txtTIN, txtPhicNo, txtHdmfNo,
	txtSssNo, txtPosition, txtHourlyRate,txtOvertimeRate, txtBasicPay, txtRiceSubsidy, txtPhoneSubsidy,
	txtClothingAllowance, txtTotalNonTaxable, txtTotalTaxable, txtSss, txtPagibig, txtPhilhealth, txtWithholdingTax,
	txtTotalDeductions, txtNetEarnings, txtGrossEarnings, txtBasicPayHrs;
	
	protected String[] payPeriod = {"======= Pay Period =======",
								  "1st Week September 2022",
								  "2nd Week September 2022",
								  "3rd Week September 2022"}; // For JComboBox use
	private String[] payDate = {"September 10, 2022",
								"September 17, 2022",
								"September 24, 2022"};
	private HoursWorked hrsWkd;
	
	private PrintNReadTxt printRead;
	private UserLogin login;
	protected double[] allEmpRate, weeklyPay;
	protected double rice = 1500.0 / 4, phone = 1000.0 / 4, clothes = 1000.0 / 4;
	private static int user;
	private int p, index;
	DecimalFormat df;
	JScrollPane scrollPane = new JScrollPane();
	JPanel payrollInformationPanel, employeeInformationPanel, employeeEarningsPanel;
	private JButton btnPrint, btnReset;

	
	public void displayPayslip() {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payslip frame = new Payslip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Payslip() {
		hrsWkd = new HoursWorked();
		printRead = new PrintNReadTxt();
		login = new UserLogin();
		printRead.printRead();
		allEmpRate = printRead.getAllEmpRate();
		weeklyPay = printRead.getWeeklyPay();

		if (UserLogin.user != null) {
			user = Integer.parseInt(UserLogin.user) - 10001;
			}
		df = new DecimalFormat("###,###.00");
		
		setResizable(false);
		setTitle("MotorPH Payroll System");
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
		setBounds(100, 100, 567, 680);
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("MOTORPH.png"));
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MotorPH Employee Payslip");
		lblNewLabel.setBounds(183, 15, 184, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterPayPeriod = new JLabel("Enter Pay Period:");
		lblEnterPayPeriod.setBounds(66, 48, 104, 14);
		contentPane.add(lblEnterPayPeriod);
		
		JComboBox<String> comboBoxPayPeriod = new JComboBox(payPeriod);
		comboBoxPayPeriod.setFocusable(false);
		comboBoxPayPeriod.setRequestFocusEnabled(false);
		comboBoxPayPeriod.setBounds(180, 44, 208, 22);
		contentPane.add(comboBoxPayPeriod);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(398, 43, 93, 23);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[0])) {
					
					JOptionPane.showMessageDialog(Payslip.this, "       Please select pay period.", "Invalid Input", JOptionPane.INFORMATION_MESSAGE, null);
					return;
				}
					// show panels once submission is valid
				payrollInformationPanel.setVisible(true);
				employeeInformationPanel.setVisible(true);
				employeeEarningsPanel.setVisible(true);
				btnPrint.setVisible(true);
				btnReset.setVisible(true);
				
					// get the requested pay period and return the info
					p = comboBoxPayPeriod.getSelectedIndex();
					index = (p - 1) * 25;
					displayText();			
			}
		});
		contentPane.add(btnSubmit);
		
		payrollInformationPanel = new JPanel();
		payrollInformationPanel.setVisible(false);
		payrollInformationPanel.setBounds(10, 77, 531, 79);
		payrollInformationPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		contentPane.add(payrollInformationPanel);
		payrollInformationPanel.setLayout(null);
		
		JLabel lblPayrollInformation = new JLabel("PAYROLL INFORMATION");
		lblPayrollInformation.setBounds(199, 6, 132, 14);
		lblPayrollInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		payrollInformationPanel.add(lblPayrollInformation);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 29, 102, 14);
		payrollInformationPanel.add(lblEmployeeName);
		
		JLabel lblPayrollPeriod = new JLabel("Payroll Period:");
		lblPayrollPeriod.setBounds(10, 54, 84, 14);
		payrollInformationPanel.add(lblPayrollPeriod);
		
		
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeName.setEnabled(false);
		txtEmployeeName.setBounds(110, 26, 156, 20);
		payrollInformationPanel.add(txtEmployeeName);
		txtEmployeeName.setColumns(10);
		
		txtPayrollPeriod = new JTextField();
		txtPayrollPeriod.setDisabledTextColor(new Color(128, 128, 128));
		txtPayrollPeriod.setEnabled(false);
		txtPayrollPeriod.setColumns(10);
		txtPayrollPeriod.setBounds(110, 51, 156, 20);
		payrollInformationPanel.add(txtPayrollPeriod);
		
		txtPayDate = new JTextField();
		txtPayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtPayDate.setEnabled(false);
		txtPayDate.setColumns(10);
		txtPayDate.setBounds(376, 51, 144, 20);
		payrollInformationPanel.add(txtPayDate);
		
		txtEmployeeNo = new JTextField();
		txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setColumns(10);
		txtEmployeeNo.setBounds(376, 26, 144, 20);
		payrollInformationPanel.add(txtEmployeeNo);
		
		JLabel lblEmployeeNo = new JLabel("Employee No.:");
		lblEmployeeNo.setBounds(270, 29, 102, 14);
		payrollInformationPanel.add(lblEmployeeNo);
		
		JLabel lblPayDate = new JLabel("Pay Date:");
		lblPayDate.setBounds(270, 54, 84, 14);
		payrollInformationPanel.add(lblPayDate);
		
		employeeInformationPanel = new JPanel();
		employeeInformationPanel.setVisible(false);
		employeeInformationPanel.setBounds(10, 163, 531, 134);
		employeeInformationPanel.setLayout(null);
		employeeInformationPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		contentPane.add(employeeInformationPanel);
		
		JLabel lblEmployeeInformation = new JLabel("EMPLOYEE INFORMATION");
		lblEmployeeInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeInformation.setBounds(193, 6, 144, 14);
		employeeInformationPanel.add(lblEmployeeInformation);
		
		JLabel lblTin = new JLabel("TIN:");
		lblTin.setBounds(10, 29, 102, 14);
		employeeInformationPanel.add(lblTin);
		
		JLabel lblPhicNo = new JLabel("PHIC No.:");
		lblPhicNo.setBounds(10, 54, 84, 14);
		employeeInformationPanel.add(lblPhicNo);
		
		txtTIN = new JTextField();
		txtTIN.setDisabledTextColor(new Color(128, 128, 128));
		txtTIN.setEnabled(false);
		txtTIN.setColumns(10);
		txtTIN.setBounds(116, 26, 144, 20);
		employeeInformationPanel.add(txtTIN);
		
		txtPhicNo = new JTextField();
		txtPhicNo.setDisabledTextColor(new Color(128, 128, 128));
		txtPhicNo.setEnabled(false);
		txtPhicNo.setColumns(10);
		txtPhicNo.setBounds(116, 51, 144, 20);
		employeeInformationPanel.add(txtPhicNo);
		
		txtHdmfNo = new JTextField();
		txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));
		txtHdmfNo.setEnabled(false);
		txtHdmfNo.setColumns(10);
		txtHdmfNo.setBounds(376, 51, 144, 20);
		employeeInformationPanel.add(txtHdmfNo);
		
		txtSssNo = new JTextField();
		txtSssNo.setDisabledTextColor(new Color(128, 128, 128));
		txtSssNo.setEnabled(false);
		txtSssNo.setColumns(10);
		txtSssNo.setBounds(376, 26, 144, 20);
		employeeInformationPanel.add(txtSssNo);
		
		JLabel lblSssNo = new JLabel("SSS No.:");
		lblSssNo.setBounds(270, 29, 102, 14);
		employeeInformationPanel.add(lblSssNo);
		
		JLabel lblHdmfNo = new JLabel("HDMF No.:");
		lblHdmfNo.setBounds(270, 54, 84, 14);
		employeeInformationPanel.add(lblHdmfNo);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 79, 84, 14);
		employeeInformationPanel.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setDisabledTextColor(new Color(128, 128, 128));
		txtPosition.setEnabled(false);
		txtPosition.setColumns(10);
		txtPosition.setBounds(116, 76, 144, 20);
		employeeInformationPanel.add(txtPosition);
		
		txtHourlyRate = new JTextField();
		txtHourlyRate.setDisabledTextColor(new Color(128, 128, 128));
		txtHourlyRate.setEnabled(false);
		txtHourlyRate.setColumns(10);
		txtHourlyRate.setBounds(376, 76, 144, 20);
		employeeInformationPanel.add(txtHourlyRate);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setBounds(270, 79, 84, 14);
		employeeInformationPanel.add(lblHourlyRate);
		
		JLabel lblOvertimeRate = new JLabel("Overtime Rate:");
		lblOvertimeRate.setBounds(10, 103, 84, 14);
		employeeInformationPanel.add(lblOvertimeRate);
		
		txtOvertimeRate = new JTextField();
		txtOvertimeRate.setDisabledTextColor(new Color(128, 128, 128));
		txtOvertimeRate.setEnabled(false);
		txtOvertimeRate.setColumns(10);
		txtOvertimeRate.setBounds(116, 100, 144, 20);
		employeeInformationPanel.add(txtOvertimeRate);
		
		employeeEarningsPanel = new JPanel();
		employeeEarningsPanel.setVisible(false);
		employeeEarningsPanel.setBounds(10, 305, 531, 278);
		employeeEarningsPanel.setLayout(null);
		employeeEarningsPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		contentPane.add(employeeEarningsPanel);
		
		JLabel lblEmployeeEarnings = new JLabel("EMPLOYEE EARNINGS");
		lblEmployeeEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeEarnings.setBounds(204, 6, 122, 14);
		employeeEarningsPanel.add(lblEmployeeEarnings);
		
		JLabel lblTaxableEarnings = new JLabel("Taxable Earnings:");
		lblTaxableEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTaxableEarnings.setBounds(10, 29, 102, 14);
		employeeEarningsPanel.add(lblTaxableEarnings);
		
		JLabel lblBasicPay = new JLabel("Basic Pay - ");
		lblBasicPay.setBounds(10, 55, 69, 14);
		employeeEarningsPanel.add(lblBasicPay);
		
		txtBasicPay = new JTextField();
		txtBasicPay.setDisabledTextColor(new Color(128, 128, 128));
		txtBasicPay.setEnabled(false);
		txtBasicPay.setColumns(10);
		txtBasicPay.setBounds(158, 52, 102, 20);
		employeeEarningsPanel.add(txtBasicPay);
		
		txtRiceSubsidy = new JTextField();
		txtRiceSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		txtRiceSubsidy.setEnabled(false);
		txtRiceSubsidy.setColumns(10);
		txtRiceSubsidy.setBounds(398, 52, 122, 20);
		employeeEarningsPanel.add(txtRiceSubsidy);
		
		JLabel lblNonTaxableEarnings = new JLabel("Non-Taxable Earnings:");
		lblNonTaxableEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNonTaxableEarnings.setBounds(270, 29, 153, 14);
		employeeEarningsPanel.add(lblNonTaxableEarnings);
		
		JLabel lblRiceSubsidy = new JLabel("Rice Subsidy:");
		lblRiceSubsidy.setBounds(270, 55, 84, 14);
		employeeEarningsPanel.add(lblRiceSubsidy);
		
		txtPhoneSubsidy = new JTextField();
		txtPhoneSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		txtPhoneSubsidy.setEnabled(false);
		txtPhoneSubsidy.setColumns(10);
		txtPhoneSubsidy.setBounds(398, 76, 122, 20);
		employeeEarningsPanel.add(txtPhoneSubsidy);
		
		JLabel lblPhoneSubsidy = new JLabel("Phone Subsidy:");
		lblPhoneSubsidy.setBounds(270, 79, 96, 14);
		employeeEarningsPanel.add(lblPhoneSubsidy);
		
		JLabel lblClothingAllowance = new JLabel("Clothing Allowance:");
		lblClothingAllowance.setBounds(270, 103, 118, 14);
		employeeEarningsPanel.add(lblClothingAllowance);
		
		txtClothingAllowance = new JTextField();
		txtClothingAllowance.setDisabledTextColor(new Color(128, 128, 128));
		txtClothingAllowance.setEnabled(false);
		txtClothingAllowance.setColumns(10);
		txtClothingAllowance.setBounds(398, 100, 122, 20);
		employeeEarningsPanel.add(txtClothingAllowance);
		
		JLabel lblTotalNonTaxable = new JLabel("TOTAL NON-TAXABLE:");
		lblTotalNonTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalNonTaxable.setBounds(270, 127, 130, 14);
		employeeEarningsPanel.add(lblTotalNonTaxable);
		
		txtTotalNonTaxable = new JTextField();
		txtTotalNonTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotalNonTaxable.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalNonTaxable.setEnabled(false);
		txtTotalNonTaxable.setColumns(10);
		txtTotalNonTaxable.setBounds(398, 124, 122, 20);
		employeeEarningsPanel.add(txtTotalNonTaxable);
		
		JLabel lblTotalTaxable = new JLabel("TOTAL TAXABLE:");
		lblTotalTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalTaxable.setBounds(10, 127, 102, 14);
		employeeEarningsPanel.add(lblTotalTaxable);
		
		txtTotalTaxable = new JTextField();
		txtTotalTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotalTaxable.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalTaxable.setEnabled(false);
		txtTotalTaxable.setColumns(10);
		txtTotalTaxable.setBounds(158, 124, 102, 20);
		employeeEarningsPanel.add(txtTotalTaxable);
		
		JLabel lblDeductions = new JLabel("Deductions:");
		lblDeductions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeductions.setBounds(10, 180, 102, 14);
		employeeEarningsPanel.add(lblDeductions);
		
		JLabel lblSss = new JLabel("SSS:");
		lblSss.setBounds(10, 204, 102, 14);
		employeeEarningsPanel.add(lblSss);
		
		txtSss = new JTextField();
		txtSss.setDisabledTextColor(new Color(128, 128, 128));
		txtSss.setEnabled(false);
		txtSss.setColumns(10);
		txtSss.setBounds(116, 201, 144, 20);
		employeeEarningsPanel.add(txtSss);
		
		JLabel lblPagibig = new JLabel("Pag-ibig:");
		lblPagibig.setBounds(10, 229, 84, 14);
		employeeEarningsPanel.add(lblPagibig);
		
		txtPagibig = new JTextField();
		txtPagibig.setDisabledTextColor(new Color(128, 128, 128));
		txtPagibig.setEnabled(false);
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(116, 226, 144, 20);
		employeeEarningsPanel.add(txtPagibig);
		
		txtPhilhealth = new JTextField();
		txtPhilhealth.setDisabledTextColor(new Color(128, 128, 128));
		txtPhilhealth.setEnabled(false);
		txtPhilhealth.setColumns(10);
		txtPhilhealth.setBounds(376, 201, 144, 20);
		employeeEarningsPanel.add(txtPhilhealth);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth:");
		lblPhilhealth.setBounds(270, 204, 102, 14);
		employeeEarningsPanel.add(lblPhilhealth);
		
		JLabel lblWithholdingTax = new JLabel("Withholding Tax:");
		lblWithholdingTax.setBounds(270, 229, 96, 14);
		employeeEarningsPanel.add(lblWithholdingTax);
		
		txtWithholdingTax = new JTextField();
		txtWithholdingTax.setDisabledTextColor(new Color(128, 128, 128));
		txtWithholdingTax.setEnabled(false);
		txtWithholdingTax.setColumns(10);
		txtWithholdingTax.setBounds(376, 226, 144, 20);
		employeeEarningsPanel.add(txtWithholdingTax);
		
		JLabel lblTotalDeductions = new JLabel("TOTAL:");
		lblTotalDeductions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalDeductions.setBounds(10, 254, 84, 14);
		employeeEarningsPanel.add(lblTotalDeductions);
		
		txtTotalDeductions = new JTextField();
		txtTotalDeductions.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotalDeductions.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalDeductions.setEnabled(false);
		txtTotalDeductions.setColumns(10);
		txtTotalDeductions.setBounds(116, 251, 144, 20);
		employeeEarningsPanel.add(txtTotalDeductions);
		
		JLabel lblNetEarnings = new JLabel("NET EARNINGS:");
		lblNetEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNetEarnings.setBounds(270, 254, 96, 14);
		employeeEarningsPanel.add(lblNetEarnings);
		
		txtNetEarnings = new JTextField();
		txtNetEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNetEarnings.setDisabledTextColor(new Color(128, 128, 128));
		txtNetEarnings.setEnabled(false);
		txtNetEarnings.setColumns(10);
		txtNetEarnings.setBounds(376, 251, 144, 20);
		employeeEarningsPanel.add(txtNetEarnings);
		
		JLabel lblGrossEarnings = new JLabel("GROSS EARNINGS:");
		lblGrossEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrossEarnings.setBounds(10, 155, 118, 14);
		employeeEarningsPanel.add(lblGrossEarnings);
		
		txtGrossEarnings = new JTextField();
		txtGrossEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrossEarnings.setDisabledTextColor(new Color(128, 128, 128));
		txtGrossEarnings.setEnabled(false);
		txtGrossEarnings.setColumns(10);
		txtGrossEarnings.setBounds(158, 152, 102, 20);
		employeeEarningsPanel.add(txtGrossEarnings);
		
		txtBasicPayHrs = new JTextField();
		txtBasicPayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtBasicPayHrs.setEnabled(false);
		txtBasicPayHrs.setColumns(10);
		txtBasicPayHrs.setBounds(76, 52, 43, 20);
		employeeEarningsPanel.add(txtBasicPayHrs);
		
		JLabel lblHrs = new JLabel("hr(s):");
		lblHrs.setBounds(122, 55, 61, 14);
		employeeEarningsPanel.add(lblHrs);
		
		btnReset = new JButton("Reset");
		btnReset.setVisible(false);
		btnReset.setBounds(280, 594, 73, 23);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEmployeeName.setText("");
				txtPayrollPeriod.setText("");
				txtEmployeeNo.setText("");
				txtPayDate.setText("");
				
				txtTIN.setText("");
				txtPhicNo.setText("");
				txtPosition.setText("");
				txtOvertimeRate.setText("");
				txtSssNo.setText("");
				txtHdmfNo.setText("");
				txtHourlyRate.setText("");
				
				txtBasicPayHrs.setText("");
				txtBasicPay.setText("");
				txtTotalTaxable.setText("");
				
				txtRiceSubsidy.setText("");
				txtPhoneSubsidy.setText("");
				txtClothingAllowance.setText("");
				txtTotalNonTaxable.setText("");
				txtGrossEarnings.setText("");

				txtSss.setText("");
				txtPagibig.setText("");
				txtPhilhealth.setText("");
				txtWithholdingTax.setText("");
				
				txtTotalDeductions.setText("");
				txtNetEarnings.setText("");
				
			}
		});
		contentPane.add(btnReset);
		
		btnPrint = new JButton("Print");
		btnPrint.setVisible(false);
		btnPrint.setBounds(196, 594, 73, 23);
		btnPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!comboBoxPayPeriod.getSelectedItem().equals(payPeriod[0]) && !txtEmployeeName.getText().equals("")) {
					
					// I really didn't want to do it like this TTTT ^ TTTT
					
					try {
					PrintWriter slipWriter = new PrintWriter("texts/Payslip_Out.txt");
					
					slipWriter.println("--------- MotorPH ---------");
					slipWriter.println("PAYROLL INFORMATION");
					slipWriter.println("Employee Name: " + txtEmployeeName.getText());
					slipWriter.println("Payroll Period: " + txtPayrollPeriod.getText());
					slipWriter.println("Pay Date: " + txtPayDate.getText());
					slipWriter.println(" ");
					slipWriter.println("EMPLOYEE INFORMATION");
					slipWriter.println("Employee No.: " + txtEmployeeNo.getText());
				 	slipWriter.println("TIN: " + txtTIN.getText());
				 	slipWriter.println("SSS No.: " + txtSssNo.getText());
				 	slipWriter.println("PHIC No.: " + txtPhicNo.getText());
				 	slipWriter.println("HDMF No.: " + txtHdmfNo.getText());
				 	slipWriter.println("Position: " + txtPosition.getText());
				 	slipWriter.println("Hourly Rate: PHP " + txtHourlyRate.getText());
				 	slipWriter.println("Overtime Rate: PHP " + txtOvertimeRate.getText());
				 	slipWriter.println("\nEARNINGS");
				 	slipWriter.println("Taxable Earnings:");
				 	slipWriter.println("\nBasic Pay - " + txtBasicPayHrs.getText() + " hr(s): PHP " + txtBasicPay.getText());
				 	slipWriter.println("\nTOTAL TAXABLE PAY: PHP " + txtTotalTaxable.getText());
				 		 	
				 	slipWriter.println("\nNon-Taxable Earnings:");
				 	slipWriter.println("Rice Subsidy: PHP " + txtRiceSubsidy.getText());
				 	slipWriter.println("Clothing Allowance: PHP " + txtClothingAllowance.getText());
				 	slipWriter.println("Phone Allowance: PHP " + txtPhoneSubsidy.getText());
				 	slipWriter.println("TOTAL NON-TAXABLE PAY: PHP " + txtTotalNonTaxable.getText());
				 	slipWriter.println("\nGROSS EARNINGS: PHP " + txtGrossEarnings.getText());
				 	
				 	slipWriter.println("\nDEDUCTIONS:");
				 	slipWriter.println("SSS: PHP " + txtSss.getText());
				 	slipWriter.println("PhilHealth: PHP " + txtPhilhealth.getText());
				 	slipWriter.println("Pag-ibig: PHP " + txtPagibig.getText());
				 	slipWriter.println("Withholding Tax: PHP " + txtWithholdingTax.getText());
				 	slipWriter.println("TOTAL DEDUCTIONS: PHP " + txtTotalDeductions.getText());
				 	slipWriter.println("\nNET EARNINGS: PHP " + txtNetEarnings.getText());
        
				    slipWriter.close();
				      } catch (IOException f) {
				        System.out.println("An error occurred.");
				        f.printStackTrace();
				      }	

					JOptionPane.showMessageDialog(Payslip.this, "Printed to Payslip_Out.txt file.", "Success!", JOptionPane.INFORMATION_MESSAGE, null);
					String filePath = "texts" + File.separator + "Payslip_Out.txt";
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filePath);
				} catch (IOException e1) {
					e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(Payslip.this, "  Please select pay period first.", "An error occured.", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});
		contentPane.add(btnPrint);
		
		setLocationRelativeTo(null);	
	}
	
	public void displayText() {
		txtEmployeeName.setText(PrintNReadTxt.employee[user].fname + " " + PrintNReadTxt.employee[user].lname);
		txtPayrollPeriod.setText(payPeriod[p]);
		txtEmployeeNo.setText(login.user + "");
		txtPayDate.setText(payDate[p-1]);
		
		txtTIN.setText(printRead.employee[user].tinNumber);
		txtPhicNo.setText(printRead.employee[user].philHealthNumber);
		txtPosition.setText(printRead.employee[user].position);
		txtOvertimeRate.setText("PHP " + (Math.round((allEmpRate[user] * 1.5) * 100.0) / 100.0) + "");
		txtSssNo.setText(printRead.employee[user].sssNumber);
		txtHdmfNo.setText(printRead.employee[user].pagIbigNumber);
		txtHourlyRate.setText("PHP " + allEmpRate[user] + "");
		
		txtBasicPayHrs.setText(hrsWkd.calculateWeeklyHoursWorked(1 + p,1 + user) + "");
		txtBasicPay.setText("PHP " + df.format(weeklyPay[user + index]));
		txtTotalTaxable.setText("PHP " +  df.format(weeklyPay[user + index]));
		
		txtRiceSubsidy.setText("PHP " +  df.format(rice));
		txtPhoneSubsidy.setText("PHP " + df.format(phone));
		txtClothingAllowance.setText("PHP " + df.format(clothes));
		txtTotalNonTaxable.setText("PHP " + df.format((rice + phone + clothes)));
		txtGrossEarnings.setText("PHP " + df.format(weeklyPay[user + index] + (rice + phone + clothes)));
		
		double sss = CalculateSSS.SSS(weeklyPay[user + index]), pagibig = CalculatePagIbig.PagIbig(weeklyPay[user + index]), philhealth = CalculatePhilhealth.Philhealth(weeklyPay[user + index]),
				withholding = CalculateWitholdingTax.WitholdingTax(weeklyPay[user + index],
						   CalculatePhilhealth.Philhealth(weeklyPay[user + index]),
						   CalculatePagIbig.PagIbig(weeklyPay[user + index]),
						   CalculateSSS.SSS(weeklyPay[user + index]));
		
		
		txtSss.setText("PHP " + df.format(CalculateSSS.SSS(weeklyPay[user + index])));
		txtPagibig.setText("PHP " + df.format(CalculatePagIbig.PagIbig(weeklyPay[user + index])));
		txtPhilhealth.setText("PHP " + df.format(CalculatePhilhealth.Philhealth(weeklyPay[user + index])));
		txtWithholdingTax.setText("PHP " + df.format(CalculateWitholdingTax.WitholdingTax(weeklyPay[user + index],
				  									   CalculatePhilhealth.Philhealth(weeklyPay[user + index]),
													   CalculatePagIbig.PagIbig(weeklyPay[user + index]),
				  									   CalculateSSS.SSS(weeklyPay[user + index]))));
		
		txtTotalDeductions.setText("PHP " + df.format(CalculateSSS.SSS(weeklyPay[user + index]) + CalculatePhilhealth.Philhealth(weeklyPay[user + index]) + 
											 CalculatePagIbig.PagIbig(weeklyPay[user + index]) + CalculateWitholdingTax.WitholdingTax(weeklyPay[user + index],
				  									   CalculatePhilhealth.Philhealth(weeklyPay[user + index]),
													   CalculatePagIbig.PagIbig(weeklyPay[user + index]),
				  									   CalculateSSS.SSS(weeklyPay[user + index]))));
		txtNetEarnings.setText("PHP " + df.format(weeklyPay[user + index] + (rice + phone + clothes) - (sss + pagibig + philhealth + withholding)));
	}
	
	public JPanel getPanel() {
		return contentPane;
	}
}
