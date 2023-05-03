package com.motorph.payrollsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class UserLogin extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	public static String user;
	public boolean loggedIn;
	public Font font = new Font("Nexa Book", Font.BOLD, 15);
	
	// Swing components
	private JLabel lblWelcome, lblEmployeeNumber, lblPassword, background;
	private JCheckBox chckbxNewCheckBox;
	private JTextField txtEmployeeNumber;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JPanel panel_1;


	public UserLogin() {
		setTitle("MotorPH Log In");
		setSize(450, 260);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					// Close the application
					System.exit(0);
				}
			}
		});

		setResizable(false);

		// Sets icon image for the application
		ImageIcon icon = new ImageIcon("MOTORPH.png");
		setIconImage(icon.getImage());
		// Sets background image for the application
		ImageIcon bg = new ImageIcon("bg.png");
		background = new JLabel(bg);

		// Create the components
		// Create labels and textfields
		lblWelcome = new JLabel("Welcome to MotorPH Payroll System");
		lblEmployeeNumber = new JLabel("Enter Employee Number: ");
		lblPassword = new JLabel("Enter Password: ");
		txtEmployeeNumber = new JTextField(10);
		txtEmployeeNumber.setOpaque(false);
		btnLogin = new JButton("Log In");
		btnLogin.addActionListener(this);

		// Set the position and size of the components
		lblWelcome.setBounds(90, 30, 300, 20);
		lblEmployeeNumber.setBounds(50, 70, 150, 20);
		txtEmployeeNumber.setBounds(200, 70, 150, 20);
		lblPassword.setBounds(50, 100, 150, 20);

		btnLogin.setBounds(167, 150, 100, 30);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 0));

		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					txtPassword.setEchoChar((char) 0);
				} else {
					txtPassword.setEchoChar('•');
				}
			}
		});
		BufferedImage imgs, img2;
		try {
			imgs = ImageIO.read(new File("images/showDisabled.png"));
			img2 = ImageIO.read(new File("images/showEnabled.png"));
			Image scaledImg = imgs.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			Image scaledImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(scaledImg);
			ImageIcon pImg = new ImageIcon(scaledImg2);
			chckbxNewCheckBox.setIcon(img);
			chckbxNewCheckBox.setSelectedIcon(pImg);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox.setOpaque(false);
			chckbxNewCheckBox.setContentAreaFilled(false);
			chckbxNewCheckBox.setBorderPainted(false);

			chckbxNewCheckBox.setBounds(303, 99, 97, 23);
		} catch (IOException e1) {
			e1.printStackTrace();
		} // read image file

		txtPassword = new JPasswordField(10);
		txtPassword.setOpaque(false);
		txtPassword.setBounds(200, 100, 150, 20);
		// Set font style
		lblWelcome.setFont(font);

		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 215, 215), 1, true));
		panel_1.setBackground(new Color(255, 225, 225));
		panel_1.setBounds(110, 124, 214, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLoginFailed = new JLabel("Login Failed. Please check your");
		lblLoginFailed.setForeground(new Color(255, 0, 0));
		lblLoginFailed.setBounds(18, 0, 191, 20);
		panel_1.add(lblLoginFailed);

		JLabel lblUsernameAndPassword = new JLabel("username and password.");
		lblUsernameAndPassword.setForeground(new Color(255, 0, 0));
		lblUsernameAndPassword.setBounds(31, 16, 178, 20);

		panel_1.setVisible(false);
		panel_1.add(lblUsernameAndPassword);

		panel.add(lblWelcome);
		panel.add(lblEmployeeNumber);
		panel.add(txtEmployeeNumber);
		panel.add(lblPassword);
		panel.add(chckbxNewCheckBox);
		panel.add(txtPassword);
		panel.add(btnLogin);
		panel.add(background);

		add(panel);

		txtEmployeeNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtPassword.requestFocus();
				}
			}
		});

		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});

	}

	public void insertData() {
		user = txtEmployeeNumber.getText();
		String pass = txtPassword.getText();
		loggedIn = verifyLogin(user, pass);
		// Error panel

		if (loggedIn) {
			// Hides the login window
			setVisible(false);
			dispose();
			// Calls onto the main menu window
			PayrollSystem payroll = new PayrollSystem();
			payroll.displayPayrollMenu();
		} else {
			// Show error message
			panel_1.setVisible(true);
			btnLogin.setBounds(167, 165, 100, 30);
			txtEmployeeNumber.setBorder(new LineBorder(new Color(255, 0, 0)));
			txtPassword.setBorder(new LineBorder(new Color(255, 0, 0)));
		}

	}

	public boolean verifyLogin(String empNo, String pass) {
		for (int i = 0; i < PrintNReadTxt.user.length; i++) {
			if (PrintNReadTxt.user[i] != null) {
				if (PrintNReadTxt.user[i].employeeNumber.equals(empNo) && PrintNReadTxt.user[i].password.equals(pass)) {
					return true;
				} else if (empNo.equals("null") && pass.equals("null")) {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		insertData();

	}

	public void setUser(String empNo) {
		UserLogin.user = empNo;
	}

	public String getEmployeeNumber() {
		return user;
	}
}