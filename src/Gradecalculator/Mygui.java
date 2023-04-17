package Gradecalculator;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Mygui {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblbday;
	private JLabel lblname;
	private JLabel lblmobile;
	private JLabel lblNewLabel_5;
	private JLabel lbladd;
	private JLabel sss;
	private JLabel phil;
	private JLabel tin;
	private JLabel pagibig;
	private JLabel status;
	private JLabel position;
	private JLabel salaryclass;
	private JLabel basicsalary;
	private JLabel rice;
	private JLabel pallowance;
	private JLabel clothing;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mygui window = new Mygui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mygui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.BOLD, 11));
		frame.getContentPane().setForeground(new Color(244, 164, 96));
		frame.setBounds(100, 100, 507, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.setBounds(271, 68, 96, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblname.setText("Crisostomo,Jose");
				lblbday.setText("February 14, 1988");
				lbladd.setText("17/85 Stracke Via");
				lblmobile.setText("918-621-603");
				sss.setText("49-1632020-8");
				phil.setText("38-218945314-5");
				tin.setText("317-674-022-000");
				pagibig.setText("4410-9336-9646");
				status.setText("Regular");
				position.setText("HR Manager");
				salaryclass.setText("Rank and File");
				basicsalary.setText("PHP 62,670.00");
				rice.setText("PHP 1,500.00");
				pallowance.setText("PHP 1,000.00");
				clothing.setText("PHP 1,000.00");
				
				
					
			}
		
			}
		);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Employee No.");
		lblNewLabel.setBounds(58, 77, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(163, 71, 86, 20);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("EmployeeInformation");
		lblNewLabel_1.setBounds(201, 24, 130, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(28, 152, 77, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Birthday:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(28, 186, 77, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(28, 218, 77, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblbday = new JLabel("");
		lblbday.setForeground(new Color(128, 128, 128));
		lblbday.setBackground(new Color(192, 192, 192));
		lblbday.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblbday.setBounds(160, 182, 189, 18);
		frame.getContentPane().add(lblbday);
		
		lblname = new JLabel((String) null);
		lblname.setForeground(new Color(128, 128, 128));
		lblname.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblname.setBackground(SystemColor.activeCaptionBorder);
		lblname.setBounds(160, 152, 189, 18);
		frame.getContentPane().add(lblname);
		
		
		
		lblmobile = new JLabel("");
		lblmobile.setForeground(new Color(128, 128, 128));
		lblmobile.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblmobile.setBounds(160, 241, 189, 18);
		frame.getContentPane().add(lblmobile);
		
		lblNewLabel_5 = new JLabel("SSS no:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(28, 274, 77, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		sss = new JLabel("");
		sss.setForeground(new Color(128, 128, 128));
		sss.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sss.setBounds(160, 270, 189, 18);
		frame.getContentPane().add(sss);
		
		JLabel lblNewLabel_6 = new JLabel("PhilHealth no:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(28, 299, 77, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
	    phil = new JLabel("");
	    phil.setForeground(new Color(128, 128, 128));
		phil.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		phil.setBounds(160, 299, 189, 18);
		frame.getContentPane().add(phil);
		
		JLabel lblNewLabel_6_1 = new JLabel("TIN no:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_1.setBounds(28, 326, 77, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		 tin = new JLabel("");
		 tin.setForeground(new Color(128, 128, 128));
		tin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tin.setBounds(160, 324, 189, 18);
		frame.getContentPane().add(tin);
		
		JLabel lblNewLabel_6_2 = new JLabel("Pag-ibig no:");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2.setBounds(28, 354, 77, 14);
		frame.getContentPane().add(lblNewLabel_6_2);
		
		 pagibig = new JLabel("");
		 pagibig.setForeground(new Color(128, 128, 128));
		pagibig.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pagibig.setBounds(160, 350, 189, 18);
		frame.getContentPane().add(pagibig);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Employee Status:");
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1.setBounds(28, 429, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1);
		
		status = new JLabel("");
		status.setForeground(new Color(128, 128, 128));
		status.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		status.setBounds(160, 425, 189, 18);
		frame.getContentPane().add(status);
		
		JLabel lblNewLabel_7 = new JLabel("Employee Salary");
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(28, 393, 130, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6_2_1_1 = new JLabel("Employee Position:");
		lblNewLabel_6_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1.setBounds(28, 458, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1);
		
		position = new JLabel("");
		position.setForeground(new Color(128, 128, 128));
		position.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		position.setBounds(160, 454, 189, 18);
		frame.getContentPane().add(position);
		
		JLabel lblNewLabel_6_2_1_1_1 = new JLabel("Salary Class:");
		lblNewLabel_6_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1_1.setBounds(28, 483, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1_1);
		
		salaryclass = new JLabel("");
		salaryclass.setForeground(new Color(128, 128, 128));
		salaryclass.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		salaryclass.setBounds(160, 479, 189, 18);
		frame.getContentPane().add(salaryclass);
		
		JLabel lblNewLabel_6_2_1_1_1_1 = new JLabel("Basic Salary :");
		lblNewLabel_6_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1_1_1.setBounds(28, 508, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1_1_1);
		
		basicsalary = new JLabel("");
		basicsalary.setBackground(new Color(192, 192, 192));
		basicsalary.setForeground(new Color(128, 128, 128));
		basicsalary.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		basicsalary.setBounds(160, 504, 189, 18);
		frame.getContentPane().add(basicsalary);
		
		JLabel lblNewLabel_6_2_1_1_1_1_1 = new JLabel("Rice Subsidy :");
		lblNewLabel_6_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1_1_1_1.setBounds(28, 533, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1_1_1_1);
		
		rice = new JLabel("");
		rice.setForeground(new Color(128, 128, 128));
		rice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rice.setBounds(160, 529, 189, 18);
		frame.getContentPane().add(rice);
		
		JLabel lblNewLabel_6_2_1_1_1_1_1_1 = new JLabel("Phone Allowance :");
		lblNewLabel_6_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1_1_1_1_1.setBounds(28, 558, 110, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1_1_1_1_1);
		
		pallowance = new JLabel("");
		pallowance.setForeground(new Color(128, 128, 128));
		pallowance.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pallowance.setBounds(160, 554, 189, 18);
		frame.getContentPane().add(pallowance);
		
		JLabel lblNewLabel_6_2_1_1_1_1_1_1_1 = new JLabel("Clothing Allowance :");
		lblNewLabel_6_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_2_1_1_1_1_1_1_1.setBounds(28, 583, 121, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1_1_1_1_1_1);
		
		clothing = new JLabel("");
		clothing.setForeground(new Color(128, 128, 128));
		clothing.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		clothing.setBounds(160, 579, 189, 18);
		frame.getContentPane().add(clothing);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile no:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(28, 245, 96, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		 basicsalary = new JLabel("");
		basicsalary.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		basicsalary.setBounds(160, 504, 189, 18);
		frame.getContentPane().add(basicsalary);
		
		lbladd = new JLabel("");
		lbladd.setForeground(new Color(128, 128, 128));
		lbladd.setBackground(new Color(192, 192, 192));
		lbladd.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbladd.setBounds(160, 211, 189, 18);
		frame.getContentPane().add(lbladd);
	}
}
