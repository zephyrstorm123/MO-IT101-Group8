package LoginSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import Christian.Number2;
import Pay.Payrollsys;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class Login_System {

	private JFrame loginsystem;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.loginsystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginsystem = new JFrame();
		loginsystem.getContentPane().setBackground(new Color(0, 0, 0));
		loginsystem.setBounds(200, 100, 500, 300);
		loginsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginsystem.getContentPane().setLayout(null);
		
		JLabel User = new JLabel("Motor PH");
		User.setForeground(new Color(0, 255, 0));
		User.setFont(new Font("Rockwell", Font.BOLD, 16));
		User.setHorizontalAlignment(SwingConstants.CENTER);
		User.setBounds(180, 11, 189, 23);
		loginsystem.getContentPane().add(User);
		
		JLabel name = new JLabel("Username");
		name.setBackground(new Color(201, 233, 22));
		name.setForeground(new Color(0, 255, 0));
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(76, 61, 70, 14);
		loginsystem.getContentPane().add(name);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBackground(new Color(201, 233, 22));
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(76, 118, 83, 14);
		loginsystem.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(180, 58, 189, 20);
		loginsystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 117, 189, 20);
		loginsystem.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 128, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			textField.setText(null);
			passwordField.setText(null);
			}
		});
		btnNewButton.setBounds(180, 211, 76, 23);
		loginsystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String password = passwordField.getText();
			String username = textField.getText();
			
			if(password.contains("1")&& username.contains("10001")) {
				
				loginsystem.setVisible(false);
				loginsystem.dispose();
				passwordField.setText(null);
				textField.setText(null);
				Payrollsys info = new Payrollsys();
				Payrollsys.main(null);
				
			}
			
			else if(password.contains("2")&& username.contains("10002")) {
				
				loginsystem.setVisible(false);
				loginsystem.dispose();
				passwordField.setText(null);
				textField.setText(null);
				Number2 mata = new Number2();
				Number2.main(null);}
			
			else if(password.contains("3")&& username.contains("10003")) {
				
				loginsystem.setVisible(false);
				loginsystem.dispose();
				passwordField.setText(null);
				textField.setText(null);
				Brad Jose = new Brad();
				Brad.main(null);
}
			else if(password.contains("4")&& username.contains("10004")) {
				
				loginsystem.setVisible(false);
				loginsystem.dispose();
				passwordField.setText(null);
				textField.setText(null);
				Salcedo Anthony = new Salcedo();
				Salcedo.main(null);
}
			
			else if(password.contains("5")&& username.contains("10005")) {
	
	passwordField.setText(null);
	textField.setText(null);
	Romualdez Alice = new Romualdez();
	Romualdez.main(null);
}
			
			else {
				JOptionPane.showMessageDialog(null,"Username or Password is Incorrect","Invalid Login Details", JOptionPane.ERROR_MESSAGE);
			}
			
			}
		});
		btnNewButton_1.setBounds(233, 159, 89, 23);
		loginsystem.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(255, 0, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 loginsystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(loginsystem,"Confirm exit", null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(293, 211, 76, 23);
		loginsystem.getContentPane().add(btnNewButton_2);
		
		
	}
}
