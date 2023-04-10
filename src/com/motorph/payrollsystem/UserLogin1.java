package com.motorph.payrollsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

public class UserLogin1 extends JFrame implements ActionListener{
    private String empNo = "10001";
    private String pass = "Admin1234";
    public boolean loggedIn;
    Scanner scan = new Scanner(System.in);
    // Swing components
    private JLabel lblWelcome, lblEmployeeNumber, lblPassword, background;
    private JTextField txtEmployeeNumber, txtPassword;
    private JButton btnLogin;
    public Font font = new Font("Nexa Book", Font.BOLD, 15);
    
    public UserLogin1() {
    	setTitle("MotorPH Log In");
    	setSize(450,250);
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
    	txtEmployeeNumber.setMargin(new Insets(2, 4, 2, 4));
    	txtPassword = new JPasswordField(10);
    	btnLogin = new JButton("Log In");
    	btnLogin.addActionListener(this);
    	
        // Set the position and size of the components
        lblWelcome.setBounds(90, 30, 300, 20);
        lblEmployeeNumber.setBounds(50, 70, 150, 20);
        txtEmployeeNumber.setBounds(200, 70, 150, 20);
        lblPassword.setBounds(50, 100, 150, 20);
        txtPassword.setBounds(200, 100, 150, 20);
        btnLogin.setBounds(167, 165, 100, 30);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 0));
        
        // Set font style
        lblWelcome.setFont(font);
        
        JPanel panel = new JPanel();
    	panel.setSize(300, 300);
    	panel.setLayout(null);
    	
    	JButton btnNewButton = new JButton("👁");
    	btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
    	btnNewButton.setBounds(324, 99, 26, 21);
    	panel.add(btnNewButton);
    	
    	
//    	background.setBounds(0, 0, 450, 250);
//    	panel.setOpaque(true);
    	
    	panel.add(lblWelcome);
    	panel.add(lblEmployeeNumber);
    	panel.add(txtEmployeeNumber);
    	panel.add(lblPassword);
    	panel.add(txtPassword);
    	panel.add(btnLogin);
    	panel.add(background);
    	
    	getContentPane().add(panel);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBorder(new LineBorder(new Color(255, 215, 215), 1, true));
    	panel_1.setBackground(new Color(255, 225, 225));
    	panel_1.setBounds(110, 124, 214, 36);
    	panel.add(panel_1);
    	panel_1.setLayout(null);
    	
    	JLabel lblLoginFailed = new JLabel("Login Failed. Please check your");
    	lblLoginFailed.setForeground(new Color(255, 0, 0));
    	lblLoginFailed.setBounds(23, 0, 191, 20);
    	panel_1.add(lblLoginFailed);
    	
    	JLabel lblUsernameAndPassword = new JLabel("username and password.");
    	lblUsernameAndPassword.setForeground(new Color(255, 0, 0));
    	lblUsernameAndPassword.setBounds(36, 16, 178, 20);
    	panel_1.add(lblUsernameAndPassword);
    	
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
    
    public static void main(String[] args) {
    	UserLogin userLogin = new UserLogin();
		userLogin.setVisible(true);
    }

    public void insertData() {
        String empNo = txtEmployeeNumber.getText();
        String pass = txtPassword.getText();
        loggedIn = verifyLogin(empNo, pass);
        if (loggedIn) {
        	
        	// Hides the login window
        	setVisible(false);
        	dispose();
        	// Calls onto the main menu window
        	PayrollSystem payroll = new PayrollSystem();
    		payroll.mainMenu();
    		
    		} else {
    			// Show error message
    			JOptionPane.showMessageDialog(this, "Invalid employee number or password.", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
    			txtEmployeeNumber.setBorder(new LineBorder(new Color(255, 0, 0)));
    			txtPassword.setBorder(new LineBorder(new Color(255, 0, 0)));
    		}

    }

    public boolean verifyLogin(String empNo, String pass) {
    	return this.empNo.equals(empNo) && this.pass.equals(pass);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		insertData();
		
	}
	
	public String getEmployeeNo() {
		return empNo;
	}
}