package com.motorph.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class HoursWorked extends JFrame {

	JPanel contentPane;
	private String[] payPeriod = {"======= Pay Period =======",
								  "1st Week September 2022", 
								  "2nd Week September 2022", 
								  "3rd Week September 2022"}; // For JComboBox use
	private JTextField txtMondayDate;
	private JTextField txtTuesdayDate;
	private JTextField txtWednesdayDate;
	private JTextField txtThursdayDate;
	private JTextField txtFridayDate;
	private JTextField txtMondayHrs;
	private JTextField txtWednesdayHrs;
	private JTextField txtThursdayHrs;
	private JTextField txtFridayHrs;
	private JTextField txtTuesdayHrs;
	private JTextField txtTotalHoursWorked;
	
	private PrintNReadTxt printNRead;
	private UserLogin login;
	private static int user;

	/**
	 * Launch the application.
	 */
	public void displayTimeSheet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoursWorked frame = new HoursWorked();
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
	public HoursWorked() {
		printNRead = new PrintNReadTxt();
		printNRead.printRead();
		login = new UserLogin();
		if (login.user != null) {
		user = Integer.parseInt(login.user) - 10001;
		}
		double[] empHrsWkd = printNRead.getEmpHrsWkd();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("MOTORPH.png"));
		setTitle("MotorPH Employee Timesheet");
		
		setResizable(false);
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
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDailyTimesheet = new JLabel("Daily Timesheet");
		lblDailyTimesheet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDailyTimesheet.setBounds(174, 15, 139, 20);
		contentPane.add(lblDailyTimesheet);
		
		JLabel lblEnterPayPeriod = new JLabel("Enter Pay Period:");
		lblEnterPayPeriod.setBounds(59, 52, 115, 14);
		contentPane.add(lblEnterPayPeriod);
		
		JComboBox comboBoxPayPeriod = new JComboBox(payPeriod);
		comboBoxPayPeriod.setBounds(174, 48, 193, 20);
		comboBoxPayPeriod.setFocusable(false);
		
		contentPane.add(comboBoxPayPeriod);
		
		JButton btnSubmit = new JButton("Submit");
//		btnSubmit.setEnabled(false);
//		
//		if (!comboBoxPayPeriod.getSelectedItem().equals(payPeriod[0])) {
//			btnSubmit.setEnabled(true);
//		}
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[0])) {
					
					JOptionPane.showMessageDialog(HoursWorked.this, "       Please select pay period.", "Invalid Input", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[1])) {
				
				
					
				txtMondayDate.setText("September 5");
				txtTuesdayDate.setText("September 6");
				txtWednesdayDate.setText("September 7");
				txtThursdayDate.setText("September 8");
				txtFridayDate.setText("September 9");
				
				String empHrs1 = empHrsWkd[50 + user] + "", empHrs2 = empHrsWkd[75 + user] + "",
					   empHrs3 = empHrsWkd[100 + user] + "", empHrs4 = empHrsWkd[125 + user] + "",
					   empHrs5 = empHrsWkd[150 + user] + "";
				
				txtMondayHrs.setText(empHrs1);
				txtTuesdayHrs.setText(empHrs2);
				txtWednesdayHrs.setText(empHrs3);
				txtThursdayHrs.setText(empHrs4);
				txtFridayHrs.setText(empHrs5);
				
				String empHrsTtl1 = calculateWeeklyHoursWorked(1,1 + user) + "";
				txtTotalHoursWorked.setText(empHrsTtl1);
				
				}
				
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[2])) {
					
					
					
					txtMondayDate.setText("September 12");
					txtTuesdayDate.setText("September 13");
					txtWednesdayDate.setText("September 14");
					txtThursdayDate.setText("September 15");
					txtFridayDate.setText("September 16");
					
					String empHrs6 = empHrsWkd[175 + user] + "", empHrs7 = empHrsWkd[200 + user] + "",
							   empHrs8 = empHrsWkd[225 + user] + "", empHrs9 = empHrsWkd[250 + user] + "",
							   empHrs10 = empHrsWkd[275 + user] + "";
					
					txtMondayHrs.setText(empHrs6);
					txtTuesdayHrs.setText(empHrs7);
					txtWednesdayHrs.setText(empHrs8);
					txtThursdayHrs.setText(empHrs9);
					txtFridayHrs.setText(empHrs10);
					
					String empHrsTtl1 = calculateWeeklyHoursWorked(2,1 + user) + "";
					txtTotalHoursWorked.setText(empHrsTtl1);

					
				}
				
				if (comboBoxPayPeriod.getSelectedItem().equals(payPeriod[3])) {
					
					
					
					txtMondayDate.setText("September 19");
					txtTuesdayDate.setText("September 20");
					txtWednesdayDate.setText("September 21");
					txtThursdayDate.setText("September 22");
					txtFridayDate.setText("September 23");
					
					String empHrs11 = empHrsWkd[300 + user] + "", empHrs12 = empHrsWkd[325 + user] + "",
						   empHrs13 = empHrsWkd[350 + user] + "", empHrs14 = empHrsWkd[375 + user] + "",
						   empHrs15 = empHrsWkd[400 + user] + "";
					
					txtMondayHrs.setText(empHrs11);
					txtTuesdayHrs.setText(empHrs12);
					txtWednesdayHrs.setText(empHrs13);
					txtThursdayHrs.setText(empHrs14);
					txtFridayHrs.setText(empHrs15);
					
					String empHrsTtl1 = calculateWeeklyHoursWorked(3,1 + user) + "";
					txtTotalHoursWorked.setText(empHrsTtl1);
					
				}
			}
		});
		btnSubmit.setBounds(164, 79, 106, 23);
		contentPane.add(btnSubmit);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 128, 414, 165);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblTotalHoursWorked = new JLabel("Total Hours Worked:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblTotalHoursWorked, -10, SpringLayout.SOUTH, panel);
		panel.add(lblTotalHoursWorked);
		
		txtMondayDate = new JTextField();

		txtMondayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtMondayDate.setSelectionColor(new Color(0, 0, 160));
		txtMondayDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtMondayDate, 7, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtMondayDate, 137, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtMondayDate, -161, SpringLayout.EAST, panel);
		panel.add(txtMondayDate);
		txtMondayDate.setColumns(10);
		
		txtTuesdayDate = new JTextField();
		txtTuesdayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtTuesdayDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtTuesdayDate, 3, SpringLayout.SOUTH, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtTuesdayDate, 0, SpringLayout.WEST, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.EAST, txtTuesdayDate, -161, SpringLayout.EAST, panel);
		txtTuesdayDate.setColumns(10);
		panel.add(txtTuesdayDate);
		
		txtWednesdayDate = new JTextField();
		txtWednesdayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtWednesdayDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtWednesdayDate, 3, SpringLayout.SOUTH, txtTuesdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtWednesdayDate, 0, SpringLayout.WEST, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.EAST, txtWednesdayDate, -161, SpringLayout.EAST, panel);
		txtWednesdayDate.setColumns(10);
		panel.add(txtWednesdayDate);
		
		txtThursdayDate = new JTextField();
		txtThursdayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtThursdayDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtThursdayDate, 3, SpringLayout.SOUTH, txtWednesdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtThursdayDate, 0, SpringLayout.WEST, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.EAST, txtThursdayDate, -161, SpringLayout.EAST, panel);
		txtThursdayDate.setColumns(10);
		panel.add(txtThursdayDate);
		
		txtFridayDate = new JTextField();
		txtFridayDate.setDisabledTextColor(new Color(128, 128, 128));
		txtFridayDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtFridayDate, 3, SpringLayout.SOUTH, txtThursdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtFridayDate, 0, SpringLayout.WEST, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.EAST, txtFridayDate, -161, SpringLayout.EAST, panel);
		txtFridayDate.setColumns(10);
		panel.add(txtFridayDate);
		
		JLabel lblMonday = new JLabel("Monday:");
		sl_panel.putConstraint(SpringLayout.WEST, lblMonday, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblTotalHoursWorked, 0, SpringLayout.WEST, lblMonday);
		sl_panel.putConstraint(SpringLayout.NORTH, lblMonday, 10, SpringLayout.NORTH, panel);
		panel.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblTuesday, 9, SpringLayout.SOUTH, lblMonday);
		sl_panel.putConstraint(SpringLayout.WEST, lblTuesday, 10, SpringLayout.WEST, panel);
		panel.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblWednesday, 9, SpringLayout.SOUTH, lblTuesday);
		sl_panel.putConstraint(SpringLayout.WEST, lblWednesday, 10, SpringLayout.WEST, panel);
		panel.add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblThursday, 9, SpringLayout.SOUTH, lblWednesday);
		sl_panel.putConstraint(SpringLayout.WEST, lblThursday, 10, SpringLayout.WEST, panel);
		panel.add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFriday, 9, SpringLayout.SOUTH, lblThursday);
		sl_panel.putConstraint(SpringLayout.WEST, lblFriday, 10, SpringLayout.WEST, panel);
		panel.add(lblFriday);
		
		txtMondayHrs = new JTextField();
		txtMondayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtMondayHrs.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtMondayHrs, 0, SpringLayout.NORTH, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtMondayHrs, -126, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtMondayHrs, -56, SpringLayout.EAST, panel);
		txtMondayHrs.setColumns(10);
		panel.add(txtMondayHrs);
		
		txtWednesdayHrs = new JTextField();
		txtWednesdayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtWednesdayHrs.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtWednesdayHrs, 0, SpringLayout.NORTH, txtWednesdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtWednesdayHrs, 0, SpringLayout.WEST, txtMondayHrs);
		txtWednesdayHrs.setColumns(10);
		panel.add(txtWednesdayHrs);
		
		txtThursdayHrs = new JTextField();
		txtThursdayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtThursdayHrs.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtThursdayHrs, 0, SpringLayout.NORTH, txtThursdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtThursdayHrs, 0, SpringLayout.WEST, txtMondayHrs);
		sl_panel.putConstraint(SpringLayout.EAST, txtThursdayHrs, 0, SpringLayout.EAST, txtMondayHrs);
		txtThursdayHrs.setColumns(10);
		panel.add(txtThursdayHrs);
		
		txtFridayHrs = new JTextField();
		txtFridayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtFridayHrs.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtFridayHrs, 0, SpringLayout.NORTH, txtFridayDate);
		sl_panel.putConstraint(SpringLayout.WEST, txtFridayHrs, 0, SpringLayout.WEST, txtMondayHrs);
		sl_panel.putConstraint(SpringLayout.EAST, txtFridayHrs, 70, SpringLayout.WEST, txtMondayHrs);
		txtFridayHrs.setColumns(10);
		panel.add(txtFridayHrs);
		
		txtTuesdayHrs = new JTextField();
		txtTuesdayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtTuesdayHrs.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, txtTuesdayHrs, 0, SpringLayout.NORTH, txtTuesdayDate);
		txtTuesdayHrs.setColumns(10);
		panel.add(txtTuesdayHrs);
		
		JLabel lblNewLabel_2_1 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 3, SpringLayout.NORTH, txtMondayDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 6, SpringLayout.EAST, txtMondayHrs);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -12, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.WEST, txtTuesdayHrs, -76, SpringLayout.WEST, lblNewLabel_2_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 364, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtTuesdayHrs, -6, SpringLayout.WEST, lblNewLabel_2_1_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 3, SpringLayout.NORTH, txtTuesdayDate);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2, 364, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtWednesdayHrs, -6, SpringLayout.WEST, lblNewLabel_2_1_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 3, SpringLayout.NORTH, txtWednesdayDate);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_3, 3, SpringLayout.NORTH, txtThursdayDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_3, 6, SpringLayout.EAST, txtThursdayHrs);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_4, 3, SpringLayout.NORTH, txtFridayDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_4, 6, SpringLayout.EAST, txtFridayHrs);
		panel.add(lblNewLabel_2_1_4);
		
		txtTotalHoursWorked = new JTextField();
		txtTotalHoursWorked.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalHoursWorked.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, txtTotalHoursWorked, 163, SpringLayout.EAST, lblTotalHoursWorked);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtTotalHoursWorked, 0, SpringLayout.SOUTH, lblTotalHoursWorked);
		txtTotalHoursWorked.setColumns(10);
		panel.add(txtTotalHoursWorked);
		
		JLabel lblNewLabel_2_1_4_1 = new JLabel("hours");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_4_1, -13, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtTotalHoursWorked, -6, SpringLayout.WEST, lblNewLabel_2_1_4_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_4_1, 0, SpringLayout.EAST, lblNewLabel_2_1_1);
		panel.add(lblNewLabel_2_1_4_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(180, 304, 73, 23);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMondayDate.setText("");
				txtTuesdayDate.setText("");
				txtWednesdayDate.setText("");
				txtThursdayDate.setText("");
				txtFridayDate.setText("");
				txtMondayHrs.setText("");
				txtTuesdayHrs.setText("");
				txtWednesdayHrs.setText("");
				txtThursdayHrs.setText("");
				txtFridayHrs.setText("");
				txtTotalHoursWorked.setText("");
				
			}
		});
		contentPane.add(btnReset);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(193, 113, 42, 14);
		contentPane.add(lblDate);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setBounds(315, 113, 87, 14);
		contentPane.add(lblHoursWorked);
		
		setLocationRelativeTo(null);
		

	}
	
	public double calculateWeeklyHoursWorked(int week, int employee) {
    	printNRead.printRead();
		double[] empHrsWkd = printNRead.getEmpHrsWkd();
		
        double sum = 0;
			for (int i = 1; i <= 5; i++) {
				sum += empHrsWkd[i * 25 + (((week - 1) * 125) + 25) + (employee - 1)];
//				System.out.println(i * 25 + (((week - 1) * 125) + 25) + (employee - 1));
			}
        return sum;
    }
}
