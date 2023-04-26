package com.motorph.payrollsystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class PayrollSettings extends JFrame {
	private JTextField txtCurrentPass;
	private JTextField txtNewPass;
	private JTextField txtNewPass2;
	private PrintNReadTxt printRead;
	private JCheckBox chckbxNewCheckBox, chckNewPass, chckAgainPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollSettings frame = new PayrollSettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displaySettings() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public PayrollSettings() {
		printRead = new PrintNReadTxt();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Payroll System Settings");
		setSize(444,268);
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
    	getContentPane().setLayout(null);
    	
    	JButton btnBack = new JButton("Back");
    	btnBack.setBounds(182, 194, 64, 23);
    	btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
    	getContentPane().add(btnBack);
    	
    	
    	
    	JLabel lblSettings = new JLabel("Settings");
    	lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
    	lblSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
    	lblSettings.setBounds(101, 15, 225, 17);
    	getContentPane().add(lblSettings);
    	
    	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    	tabbedPane.setBounds(10, 41, 402, 142);
    	getContentPane().add(tabbedPane);
    	
    	JPanel panel = new JPanel();
    	tabbedPane.addTab("Password", null, panel, null);
    	panel.setLayout(null);
    	
    	chckbxNewCheckBox = new JCheckBox("");
    	chckbxNewCheckBox.setBounds(257, 8, 97, 23);
    	chckNewPass = new JCheckBox("");
    	chckNewPass.setBounds(257, 33, 97, 23);
    	chckAgainPass = new JCheckBox("");
    	chckAgainPass.setBounds(257, 58, 97, 23);
    	BufferedImage imgs, img2;
    	try {
			imgs = ImageIO.read(new File("images/showDisabled.png"));
			img2 = ImageIO.read(new File("images/showEnabled.png"));
		Image scaledImg = imgs.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image scaledImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(scaledImg);
		ImageIcon pImg = new ImageIcon(scaledImg2);
		chckbxNewCheckBox.setIcon(img);
		chckNewPass.setIcon(img);
		chckAgainPass.setIcon(img);
    	chckbxNewCheckBox.setSelectedIcon(pImg);
    	chckNewPass.setSelectedIcon(pImg);
    	chckAgainPass.setSelectedIcon(pImg);
    	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	panel.add(chckbxNewCheckBox);
    	panel.add(chckNewPass);
    	panel.add(chckAgainPass);
    	panel.add(chckbxNewCheckBox);
    	chckbxNewCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    ((JPasswordField) txtCurrentPass).setEchoChar((char) 0);
                    if (chckNewPass.isSelected() == true) {
                    chckNewPass.doClick(); }
                    if (chckAgainPass.isSelected() == true) {
                    	chckAgainPass.doClick(); }
                } else {
                	((JPasswordField) txtCurrentPass).setEchoChar('•');
                }
            }
        });
    	
    	chckNewPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    ((JPasswordField) txtNewPass).setEchoChar((char) 0);
                    if (chckbxNewCheckBox.isSelected() == true) {
                    	chckbxNewCheckBox.doClick(); }
                    if (chckAgainPass.isSelected() == true) {
                    	chckAgainPass.doClick(); }
                } else {
                	((JPasswordField) txtNewPass).setEchoChar('•');
                }
            }
        });
    	
    	chckAgainPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    ((JPasswordField) txtNewPass2).setEchoChar((char) 0);
                    if (chckbxNewCheckBox.isSelected() == true) {
                    	chckbxNewCheckBox.doClick(); }
                    if (chckNewPass.isSelected() == true) {
                    	chckNewPass.doClick(); }
                } else {
                	((JPasswordField) txtNewPass2).setEchoChar('•');
                }
            }
        });
    	
    	chckbxNewCheckBox.setOpaque(false);
    	chckNewPass.setOpaque(false);
    	chckAgainPass.setOpaque(false);
    	chckbxNewCheckBox.setContentAreaFilled(false);
    	chckNewPass.setContentAreaFilled(false);
    	chckAgainPass.setContentAreaFilled(false);
    	chckbxNewCheckBox.setBorderPainted(false);
    	chckNewPass.setBorderPainted(false);
    	chckAgainPass.setBorderPainted(false);
    	
    	JLabel lblNewLabel = new JLabel("Enter Current Password:");
    	lblNewLabel.setBounds(10, 11, 161, 14);
    	panel.add(lblNewLabel);
    	
    	JLabel lblEnterNewPassword = new JLabel("Enter New Password:");
    	lblEnterNewPassword.setBounds(10, 36, 161, 14);
    	panel.add(lblEnterNewPassword);
    	
    	JLabel lblConfirmNewPassword = new JLabel("Confirm New Password:");
    	lblConfirmNewPassword.setBounds(10, 61, 161, 14);
    	panel.add(lblConfirmNewPassword);
    	
    	txtCurrentPass = new JPasswordField();
    	txtCurrentPass.setBounds(158, 9, 146, 20);
    	txtCurrentPass.setOpaque(false);
    	panel.add(txtCurrentPass);
    	txtCurrentPass.setColumns(10);
    	
    	txtNewPass = new JPasswordField();
    	txtNewPass.setColumns(10);
    	txtNewPass.setBounds(158, 34, 146, 20);
    	txtNewPass.setOpaque(false);
    	panel.add(txtNewPass);
    	
    	txtNewPass2 = new JPasswordField();
    	txtNewPass2.setColumns(10);
    	txtNewPass2.setBounds(158, 59, 146, 20);
    	txtNewPass2.setOpaque(false);
    	panel.add(txtNewPass2);
    	
    	JButton btnNewButton = new JButton("Change");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String current = txtCurrentPass.getText();
    			String newP = txtNewPass.getText();
    			String again = txtNewPass2.getText();
    			if (!checkCurrent(current) || current == null) {
    				JOptionPane.showMessageDialog(null, "You entered an incorrect password.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
    				return;}
    			if (!checkLength(newP)) {
    				JOptionPane.showMessageDialog(null, "Password should contain atleast 8 characters.", "Password Too Weak", JOptionPane.INFORMATION_MESSAGE);
    				return;}
    			if (!checkMatch(newP,again)) {
    				JOptionPane.showMessageDialog(null, "Password did not match. Please try again.", "Match Error", JOptionPane.INFORMATION_MESSAGE);
    				return;}
    			saveNewPassword(newP);
    			clearTextBoxes();
    			JOptionPane.showMessageDialog(null, "Password change successful.", "Successful", JOptionPane.INFORMATION_MESSAGE);
    			printRead.printRead();
    		}
    	});
    	btnNewButton.setBounds(124, 90, 86, 23);
    	panel.add(btnNewButton);
	}
	
	public boolean checkCurrent(String current) {
		String saved = PrintNReadTxt.savedPass[Integer.parseInt(UserLogin.user) - 10001];
		if (current.equals(saved)) {
			return true;
		} else { return false; }
	}
	
	public boolean checkLength(String newP) {
		if (newP.length() >= 8) {
			return true;
		} else { return false; }
	}
	
	public boolean checkMatch(String newP, String again) {
		if (newP.equals(again)) {
			return true;
		} else { return false; }
	}
	
	public void saveNewPassword(String newPassword) {
		int empNo = Integer.parseInt(UserLogin.user) - 10001;
		try {
			PrintWriter outFile = new PrintWriter("texts/Log In Credentials.txt");
		
		for (int i = 0 ; i < PrintNReadTxt.savedPass.length; i++) {
			if (i == empNo) {
				outFile.print(PrintNReadTxt.savedEmpNo[i] + " " + newPassword + " ");
			} else {
				outFile.print(PrintNReadTxt.savedEmpNo[i] + " " + PrintNReadTxt.savedPass[i] + " ");
			}
		}
		outFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearTextBoxes() {
		txtCurrentPass.setText("");
		txtNewPass.setText("");
		txtNewPass2.setText("");
	}
}
