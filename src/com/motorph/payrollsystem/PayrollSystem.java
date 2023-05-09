package com.motorph.payrollsystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PayrollSystem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnPersonalInfo, btnSalaryInfo, btnDailyTimesheet, btnPayslip, btnApplyLeave, 
	btnEmployeeMaster, btnUserAccounts, btnLogOut, btnSettings;
	JPanel panePersonalInfo, paneSalaryInfo, paneTimesheet, panePayslip, paneUserAccounts;
	JLayeredPane layeredPane_1;
	private JScrollPane scrollPane;
	private JLabel lblUsername, lblNewLabel_2_1;
	private PrintNReadTxt printNRead;
	private Employee employee;
	private EmployeeMaster master;
	private LeaveApplication fileLeave;
	private UserAdmin userAdmin;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */

	
	void switchButtons() {
		btnPersonalInfo.setEnabled(true);
		btnSalaryInfo.setEnabled(true);
		btnDailyTimesheet.setEnabled(true);
		btnPayslip.setEnabled(true);
		btnApplyLeave.setEnabled(true);
		btnEmployeeMaster.setEnabled(true);
		btnUserAccounts.setEnabled(true);
		btnSettings.setEnabled(true);
		
		btnPersonalInfo.setBackground(new Color(0, 140, 184));
		btnSalaryInfo.setBackground(new Color(0, 140, 184));
		btnDailyTimesheet.setBackground(new Color(0, 140, 184));
		btnPayslip.setBackground(new Color(0, 140, 184));
		btnApplyLeave.setBackground(new Color(0, 140, 184));
		btnEmployeeMaster.setBackground(new Color(0, 140, 184));
		btnUserAccounts.setBackground(new Color(0, 140, 184));
		btnSettings.setBackground(new Color(0, 140, 184));
	}
	
	void switchPanes(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	void switchPanes(JScrollPane scroll) {
		layeredPane_1.removeAll();
		layeredPane_1.add(scroll);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	void chooseButton(JButton button) {
		switchButtons();
		button.setEnabled(false);
		button.setBackground(new Color(255, 255, 255));
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public PayrollSystem() {
		printNRead = new PrintNReadTxt();
		master = new EmployeeMaster();
		fileLeave = new LeaveApplication();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(933,429);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("MotorPH Application Menu");
		// Sets icon image for the application
				ImageIcon icon = new ImageIcon("MOTORPH.png");
				setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 39, 131, 602);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 140, 184));
		getContentPane().add(panel_3);
		
		btnPersonalInfo = new JButton("       Personal Info");
		btnPersonalInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseButton(btnPersonalInfo);
				switchPanes(panePersonalInfo);
				employee.displayPersonalInfo();
			}
		});
		btnPersonalInfo.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonalInfo.setForeground(Color.WHITE);
		btnPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonalInfo.setFocusable(false);
		
		btnPersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPersonalInfo.setBackground(btnPersonalInfo.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPersonalInfo.setBackground(btnPersonalInfo.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnPersonalInfo.setBorder(null);
		btnPersonalInfo.setBackground(new Color(0, 140, 184));
		btnPersonalInfo.setBounds(0, 25, 135, 23);
		panel_3.add(btnPersonalInfo);
		
		btnSalaryInfo = new JButton("       Salary Info");
		btnSalaryInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseButton(btnSalaryInfo);
				switchPanes(paneSalaryInfo);
				employee.displaySalaryRecords();
			}
		});
		btnSalaryInfo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalaryInfo.setForeground(Color.WHITE);
		btnSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalaryInfo.setFocusable(false);
		
		btnSalaryInfo.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnSalaryInfo.setBackground(btnSalaryInfo.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnSalaryInfo.setBackground(btnSalaryInfo.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnSalaryInfo.setBorder(null);
		btnSalaryInfo.setBackground(new Color(0, 140, 184));
		btnSalaryInfo.setBounds(0, 49, 135, 23);
		panel_3.add(btnSalaryInfo);
		
		JLabel lblNewLabel_2 = new JLabel("My Profile");
		lblNewLabel_2.setForeground(new Color(181, 204, 212));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 7, 85, 14);
		panel_3.add(lblNewLabel_2);
		
		btnDailyTimesheet = new JButton("       Daily Timesheet");
		btnDailyTimesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseButton(btnDailyTimesheet);
				switchPanes(paneTimesheet);
			}
		});
		btnDailyTimesheet.setHorizontalAlignment(SwingConstants.LEFT);
		btnDailyTimesheet.setForeground(Color.WHITE);
		btnDailyTimesheet.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDailyTimesheet.setFocusable(false);
		
		btnDailyTimesheet.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDailyTimesheet.setBackground(btnDailyTimesheet.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDailyTimesheet.setBackground(btnDailyTimesheet.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnDailyTimesheet.setBorder(null);
		btnDailyTimesheet.setBackground(new Color(0, 140, 184));
		btnDailyTimesheet.setBounds(0, 72, 135, 23);
		panel_3.add(btnDailyTimesheet);
		
		btnPayslip = new JButton("       Payslip");
		btnPayslip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseButton(btnPayslip);
				switchPanes(scrollPane);
			}
		});
		btnPayslip.setHorizontalAlignment(SwingConstants.LEFT);
		btnPayslip.setForeground(Color.WHITE);
		btnPayslip.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPayslip.setFocusable(false);

		btnPayslip.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPayslip.setBackground(btnPayslip.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPayslip.setBackground(btnPayslip.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnPayslip.setBorder(null);
		btnPayslip.setBackground(new Color(0, 140, 184));
		btnPayslip.setBounds(0, 96, 135, 23);
		panel_3.add(btnPayslip);
		btnApplyLeave = new JButton("       Apply Leave");
		btnApplyLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fileLeave.applyLeave();
				setVisible(false);
//				dispose();
				
//				chooseButton(btnApplyLeave);
//				switchPanes(scrollPane_1);
//					fileLeave = new LeaveApplication();
//				    fileLeave.readCsvFiles();
			}
		});
		
		

		btnApplyLeave.setHorizontalAlignment(SwingConstants.LEFT);
		btnApplyLeave.setForeground(Color.WHITE);
		btnApplyLeave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApplyLeave.setFocusable(false);
		
		btnApplyLeave.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnApplyLeave.setBackground(btnApplyLeave.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnApplyLeave.setBackground(btnApplyLeave.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnApplyLeave.setBorder(null);
		btnApplyLeave.setBackground(new Color(0, 140, 184));
		btnApplyLeave.setBounds(0, 119, 135, 23);
		panel_3.add(btnApplyLeave);
		
		lblNewLabel_2_1 = new JLabel("System Admin");
		lblNewLabel_2_1.setForeground(new Color(181, 204, 212));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 146, 111, 14);
		panel_3.add(lblNewLabel_2_1);
		
		btnEmployeeMaster = new JButton("       Employee Master");
		btnEmployeeMaster.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployeeMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				master.viewEmployeeMaster();
				setVisible(false);
//				dispose();
//				chooseButton(btnEmployeeMaster);
//				switchPanes(scrollPane_2);
//				master.readCsvFile();
//				master.loadLeaveApplications();
			}
		});
		btnEmployeeMaster.setForeground(Color.WHITE);
		btnEmployeeMaster.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEmployeeMaster.setFocusable(false);
		
		btnEmployeeMaster.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnEmployeeMaster.setBackground(btnEmployeeMaster.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnEmployeeMaster.setBackground(btnEmployeeMaster.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnEmployeeMaster.setBorder(null);
		btnEmployeeMaster.setBackground(new Color(0, 140, 184));
		btnEmployeeMaster.setBounds(0, 164, 135, 23);
		panel_3.add(btnEmployeeMaster);
		
		btnUserAccounts = new JButton("       User Accounts");
		btnUserAccounts.setHorizontalAlignment(SwingConstants.LEFT);
		btnUserAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chooseButton(btnUserAccounts);
				switchPanes(paneUserAccounts);
				userAdmin.findAvailableEmployeeNumbers();
				userAdmin.findActiveAccounts();
			}
		});
		btnUserAccounts.setForeground(Color.WHITE);
		btnUserAccounts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserAccounts.setFocusable(false);
		
		btnUserAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnUserAccounts.setBackground(btnUserAccounts.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnUserAccounts.setBackground(btnUserAccounts.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnUserAccounts.setBorder(null);
		btnUserAccounts.setBackground(new Color(0, 140, 184));
		btnUserAccounts.setBounds(0, 188, 135, 23);
		panel_3.add(btnUserAccounts);
		
		btnLogOut = new JButton("       Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm Log Out", JOptionPane.YES_NO_OPTION);
    	        if (confirm == JOptionPane.YES_OPTION) {
    	            // Log user out
    	        	setVisible(false);
    	        	dispose();
    				openUserLogin();
    	        }
			}
		});
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setFocusable(false);
		
		btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnLogOut.setBackground(btnLogOut.isEnabled() ? new Color(255, 70, 70) : new Color(255, 70, 70)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnLogOut.setBackground(btnLogOut.isEnabled() ? new Color(255, 128, 128) : new Color(255, 70, 70)); // reset the background color to the default color
		    }
		});
		
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(255, 128, 128));
		btnLogOut.setBounds(0, 297, 135, 23);
		panel_3.add(btnLogOut);
		
		btnSettings = new JButton("       Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayrollSettings settings = new PayrollSettings();
				settings.displaySettings();
			}
		});
		btnSettings.setHorizontalAlignment(SwingConstants.LEFT);
		btnSettings.setForeground(Color.WHITE);
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSettings.setFocusable(false);
		
		btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnSettings.setBackground(btnSettings.isEnabled() ? new Color(0, 84, 111) : new Color(255, 255, 255)); // highlight button when mouse hovers over it
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnSettings.setBackground(btnSettings.isEnabled() ? new Color(0, 140, 184) : new Color(255, 255, 255)); // reset the background color to the default color
		    }
		});
		
		btnSettings.setBorder(null);
		btnSettings.setBackground(new Color(0, 140, 184));
		btnSettings.setBounds(0, 274, 135, 23);
		panel_3.add(btnSettings);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(0, 0, 919, 39);
		panelHeader.setLayout(null);
		panelHeader.setBorder(null);
		panelHeader.setBackground(new Color(49, 54, 56));
		getContentPane().add(panelHeader);
		
		JLabel lblNewLabel = new JLabel("MotorPH");
		lblNewLabel.setForeground(new Color(233, 233, 233));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(48, 12, 102, 14);
		panelHeader.add(lblNewLabel);
		
		lblUsername = new JLabel();
		lblUsername.setText("");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(762, 12, 122, 14);
		panelHeader.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("");
		BufferedImage img;
			try {
				img = ImageIO.read(new File("images/user_icon.png"));
				Image scaledImg = img.getScaledInstance(46, 46, Image.SCALE_SMOOTH);
				ImageIcon imgs = new ImageIcon(scaledImg);
				lblNewLabel_1.setIcon(imgs);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		lblNewLabel_1.setBounds(719, 8, 46, 25);
		panelHeader.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("");
		BufferedImage icn;
		try {
			icn = ImageIO.read(new File("MOTORPH.png"));
			Image scaledIcn = icn.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
			ImageIcon icns = new ImageIcon(scaledIcn);
			lblNewLabel_3.setIcon(icns);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		lblNewLabel_3.setBounds(17, 3, 46, 33);
		panelHeader.add(lblNewLabel_3);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(130, 39, 789, 680);
		getContentPane().add(layeredPane_1);
		
		employee = new Employee();
		
		panePersonalInfo = employee.personalInfoPanel;
		panePersonalInfo.setBounds(90, 0, 647, 351);
		layeredPane_1.add(panePersonalInfo);
		
		paneSalaryInfo = employee.salaryInfoPanel;
		paneSalaryInfo.setBounds(90, 0, 647, 351);
		layeredPane_1.add(paneSalaryInfo);
		
		HoursWorked timesheet = new HoursWorked();
		
		paneTimesheet = timesheet.contentPane;
		paneTimesheet.setBounds(158, 0, 429, 351);
		layeredPane_1.add(paneTimesheet);
		
		userAdmin = new UserAdmin();
		
		paneUserAccounts = (JPanel) userAdmin.getContentPane();
		paneUserAccounts.setBounds(100, 0, 789, 349);
		layeredPane_1.add(paneUserAccounts);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(95, 0, 689, 351);

				
		Payslip payslip = new Payslip();
		panePayslip = payslip.contentPane;
		panePayslip.setPreferredSize(new Dimension(620, 680));
		scrollPane.setViewportView(panePayslip);
		layeredPane_1.add(scrollPane);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
//					PayrollSystem2 frame = new PayrollSystem2();
//					frame.displayPayrollMenu();
					PayrollSystem payroll = new PayrollSystem();
					payroll.openUserLogin();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void openUserLogin() {
		UserLogin login = new UserLogin();
		login.setVisible(true);
		
	}
	
	public void displayPayrollMenu() {
		printNRead.printRead();
		lblUsername.setText(PrintNReadTxt.employee[Integer.parseInt(UserLogin.user) - 10001].fname + " " +
							PrintNReadTxt.employee[Integer.parseInt(UserLogin.user) - 10001].lname);
		setVisible(true);
		btnPersonalInfo.doClick();
		
		if (!PrintNReadTxt.user[Integer.parseInt(UserLogin.user)-10001].systemRole.equals("Admin")) {
			lblNewLabel_2_1.setVisible(false);
			btnEmployeeMaster.setVisible(false);
			btnUserAccounts.setVisible(false);
		}
		
	}
}
