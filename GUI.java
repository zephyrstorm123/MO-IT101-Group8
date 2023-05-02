import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField MS1;
	private JTextField MS2;
	private JTextField MS3;
	private JTextField Total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Label2 = new JLabel("Milestone 2");
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setBounds(35, 116, 118, 17);
		frame.getContentPane().add(Label2);
		
		JLabel lblNewLabel_1 = new JLabel("Milestone 3");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 150, 118, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel Label1 = new JLabel("Milestone 1");
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(35, 89, 118, 17);
		frame.getContentPane().add(Label1);
		
		MS1 = new JTextField();
		MS1.setBounds(163, 88, 160, 19);
		frame.getContentPane().add(MS1);
		MS1.setColumns(10);
		
		MS2 = new JTextField();
		MS2.setColumns(10);
		MS2.setBounds(163, 116, 160, 19);
		frame.getContentPane().add(MS2);
		
		MS3 = new JTextField();
		MS3.setColumns(10);
		MS3.setBounds(163, 149, 160, 19);
		frame.getContentPane().add(MS3);
		
		Total = new JTextField();
		Total.setColumns(10);
		Total.setBounds(163, 179, 109, 19);
		frame.getContentPane().add(Total);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(35, 180, 90, 17);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float Milestone1 =Float.parseFloat(MS1.getText());
				float Milestone2 = Float.parseFloat(MS2.getText());
				float Milestone3 = Float.parseFloat(MS3.getText());
				float tot = Milestone1 + Milestone2 + Milestone3;
				Total.setText(String.valueOf(tot));
				
				if(Float.parseFloat(MS1.getText()) > 25||Float.parseFloat(MS2.getText()) > 25 || Float.parseFloat(MS3.getText()) > 50) {
					MS1.setText("Maximum value for MS1 is 25");
					MS2.setText("Maximum value for MS2 is 25");
					MS3.setText("Maximum value for MS3 is 50");
					Total.setText("There's an error!");
			}
				else if(Float.parseFloat(MS1.getText()) < 0||Float.parseFloat(MS2.getText()) < 0 || Float.parseFloat(MS3.getText()) < 0) {
					
					JOptionPane.showMessageDialog(null,"The value should not be less than 0");
				}
				else {}
			}});
		btnNewButton.setBounds(341, 114, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MS1.setText("");
				MS2.setText("");
				MS3.setText("");
				Total.setText("");
				MS1.requestFocus();
			}
		});
		btnClear.setBounds(341, 178, 85, 21);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(176, 213, 85, 21);
		frame.getContentPane().add(btnExit);
	}
}
