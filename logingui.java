import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.opencsv.CSVReader;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class logingui {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logingui window = new logingui();
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
	public logingui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBackground(new Color(0, 128, 0));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(69, 54, 82, 22);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBackground(new Color(0, 128, 0));
		lblPassword.setBounds(69, 102, 82, 22);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(161, 57, 176, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 105, 176, 20);
		frame.getContentPane().add(passwordField);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	String username = textField.getText();
	String password = passwordField.getText(); 
	String file = "C:\\Users\\Default.LAPTOP-FTFP08QI\\Downloads\\filecsv.csv";
		 
		            List<List<String>> records = new ArrayList<List<String>>();
		            try (CSVReader csvReader = new CSVReader(new FileReader(file));) {
		                String[] nextLine = null;
		                while ((nextLine = csvReader.readNext()) != null) {
		                    records.add(Arrays.asList(nextLine));
		                   String name = nextLine[0];
		           String pass = nextLine[1];
		            csvReader.close();
	if(username.equals((name))&& password.equals(pass)){
		
		JOptionPane.showMessageDialog(null,"Login Successful","SUCCESS", JOptionPane.INFORMATION_MESSAGE);}
	
	else {JOptionPane.showMessageDialog(null,"Username or Password is Incorrect","Invalid Login Details", JOptionPane.ERROR_MESSAGE);}
		            }}
	
		catch (Exception e1)   
		{  
		e1.printStackTrace();  
		
		}
			
			}
});
		login.setBounds(202, 136, 89, 23);
		frame.getContentPane().add(login);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(297, 195, 89, 23);
		frame.getContentPane().add(exit);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reset.setBounds(91, 195, 89, 23);
		frame.getContentPane().add(reset);
	}

	
}
