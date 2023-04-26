package com.motorph.payrollsystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

public class LeaveApplication extends JFrame {

	String path = "csv/AppliedLeaves.csv",  line = "";
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");
	
	private static final long serialVersionUID = 1L;
	private UserLogin login = new UserLogin();
	private JTable table;
	private JComboBox<Object> comboBoxLeaveType;
	private JDateChooser txtStartDate, txtEndDate;
	private String newLeaveDetails[] = new String[6];
	private LeaveDetails[] leave = new LeaveDetails[50];
	private int SlCount, VlCount, ElCount, leaveCount, count;
	private String employeeNumber;
	private JTextArea txtLeaveDescription;
	private Object[][] data;
	private JButton btnDelete, btnCancel_1;
	private LeaveDetails deletedLeave;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LeaveApplication frame = new LeaveApplication();
//					frame.readCsvFiles();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void applyLeave() {
//		System.out.println(login.getEmployeeNumber());
		readCsvFiles();
		setVisible(true);
	}
	
	public void readCsvFiles() {
		count = 0;
		leaveCount = 0;
		
		int i = 0;
		try {
	        BufferedReader br = new BufferedReader(new FileReader(path));
	        while ((line = br.readLine()) != null) {

	            String[] values = line.split(",");
	            
	         // check if any value is empty or null
	            boolean hasEmptyValue = false;
	            for (String value : values) {
	                if (value == null || value.isEmpty()) {
	                    hasEmptyValue = true;
	                    break;}
	            }
	            	if (hasEmptyValue) {
	                // skip this line
	                continue;
	            }
	            leave[i] = new LeaveDetails(values[0], values[1], values[2], values[3], values[4], values[5]);
	            count++;
	            i++;
	        }
	        br.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}
 
	        for (int k = 0; k < leave.length; k++) {
	        	if (leave[k] != null && leave[k].employeeNumber.equals(login.getEmployeeNumber())) {
	        		leaveCount++;
	        		if (leave[k].leaveType.equals("Sick Leave") && !leave[k].leaveStatus.equals("Cancelled")) {
	        			SlCount++;
	        		} else if (leave[k].leaveType.equals("Vacation Leave") && !leave[k].leaveStatus.equals("Cancelled")) {
	        			VlCount++;
	        		} else if (leave[k].leaveType.equals("Emergency Leave") && !leave[k].leaveStatus.equals("Cancelled")) {
	        			ElCount++;
	        		}
	        	}
	        }
	        System.out.println("Leave Count: " + leaveCount + 
	        			"\n" + "Sick Leaves: " + SlCount +
	        			"\n" + "Vacation Leaves: " + VlCount +
	        			"\n" + "Emergency Leaves: " + ElCount + "\n");
	        //Populate JTable with data
			data = new Object[leaveCount][5];
			
			
			int counter = 0;
			for (int j = leave.length - 1; j >= 0; j--) {
			    if (leave[j] != null && leave[j].employeeNumber.equals(login.getEmployeeNumber())) {
			        data[counter][0] = leave[j].leaveType;
			        data[counter][1] = leave[j].startDate;
			        data[counter][2] = leave[j].endDate;
			        data[counter][3] = leave[j].leaveStatus;
			        data[counter][4] = leave[j].leaveDescription;
			        counter++;
			    }
			}
			table.setModel(new DefaultTableModel(
			    Arrays.copyOfRange(data, 0, counter),
			    new String[] {
			        "Leave Type", "Start Date", "End Date", "Leave Status", "Leave Description"
			    }
			));

			table.getColumnModel().getColumn(4).setPreferredWidth(84);
	        }

	/**
	 * Create the frame.
	 */
	public LeaveApplication() {
		setTitle("MotorPH Employee Leave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,419);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblLeaveApplication = new JLabel("Employee Leave Application");
		lblLeaveApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveApplication.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeaveApplication.setBounds(192, 24, 225, 17);
		getContentPane().add(lblLeaveApplication);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(496, 338, 64, 23);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	dispose();
	        	PayrollSystem menu = new PayrollSystem();
	        	menu.profileMenu();
				
			}
		});
		getContentPane().add(btnBack);
		
		JPanel payrollInformationPanel_1 = new JPanel();
		payrollInformationPanel_1.setLayout(null);
		payrollInformationPanel_1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel_1.setBounds(10, 51, 564, 143);
		getContentPane().add(payrollInformationPanel_1);
		
		JLabel lblAddNewLeave = new JLabel("Add New Leave:");
		lblAddNewLeave.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewLeave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddNewLeave.setBounds(185, 6, 193, 14);
		payrollInformationPanel_1.add(lblAddNewLeave);
		
		JLabel lblLeaveType = new JLabel("Leave Type:");
		lblLeaveType.setBounds(10, 29, 102, 14);
		payrollInformationPanel_1.add(lblLeaveType);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(10, 54, 84, 14);
		payrollInformationPanel_1.add(lblStartDate);
		
		comboBoxLeaveType = new JComboBox<Object>(new Object[]{});
		comboBoxLeaveType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Select Leave Type ", "Sick Leave", "Vacation Leave", "Emergency Leave"}));
		comboBoxLeaveType.setBounds(89, 25, 136, 20);
		payrollInformationPanel_1.add(comboBoxLeaveType);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(10, 79, 84, 14);
		payrollInformationPanel_1.add(lblEndDate);
		
		JLabel lblReasonForLeave = new JLabel("Reason for ");
		lblReasonForLeave.setBounds(235, 29, 90, 14);
		payrollInformationPanel_1.add(lblReasonForLeave);
		
		txtLeaveDescription = new JTextArea();
		txtLeaveDescription.setMargin(new Insets(4, 4, 4, 4));
		txtLeaveDescription.setBorder(new LineBorder(new Color(128, 128, 128)));
		txtLeaveDescription.setLineWrap(true);
		txtLeaveDescription.setWrapStyleWord(true);
		txtLeaveDescription.setBounds(316, 25, 238, 71);
		txtLeaveDescription.setToolTipText("A leave descrption can't contain a coma.");
		txtLeaveDescription.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (e.getKeyChar() == KeyEvent.VK_COMMA) {
		            e.consume(); // consume the key event to prevent the comma from being entered
		        }
		    }
		});
		payrollInformationPanel_1.add(txtLeaveDescription);
		
		JButton btnApplyLeave = new JButton("File Leave");
		btnApplyLeave.setBounds(290, 107, 104, 23);
		
		
		payrollInformationPanel_1.add(btnApplyLeave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(176, 107, 104, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
				
			}
		});
		payrollInformationPanel_1.add(btnCancel);
		
		JLabel lblLeave = new JLabel("Leave:");
		lblLeave.setBounds(235, 47, 90, 14);
		payrollInformationPanel_1.add(lblLeave);
		
		txtStartDate = new JDateChooser();
		txtStartDate.setDateFormatString("MMMM dd yyyy");
		txtStartDate.setBounds(89, 50, 136, 20);
		payrollInformationPanel_1.add(txtStartDate);
		
		txtEndDate = new JDateChooser();
		txtEndDate.setDateFormatString("MMMM dd yyyy");
		txtEndDate.setBounds(89, 76, 136, 20);
		payrollInformationPanel_1.add(txtEndDate);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setBounds(10, 217, 564, 107);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // If a row is selected
		            String leaveStatus = (String) table.getValueAt(selectedRow, 3);
		            if (leaveStatus.equals("Applied")) {
		                btnCancel_1.setEnabled(true);
		            } else {
		                btnCancel_1.setEnabled(false);
		            }
		            btnDelete.setEnabled(true);
		        } else {
		            btnDelete.setEnabled(false);
		        }
		    }
		});

		scrollPane.setViewportView(table);

		JLabel lblFiledLeaves = new JLabel("Filed Leaves:");
		lblFiledLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiledLeaves.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFiledLeaves.setBounds(195, 199, 193, 14);
		getContentPane().add(lblFiledLeaves);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(20, 338, 72, 23);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this leave record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
				// get the selected row index
				int rowIndex = table.getSelectedRow();
				// open the CSV file for writing
				try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path));

				// loop through the leave array and write to the CSV file
				for (LeaveDetails leaveDetail : leave) {
				    // check if leaveDetail is not null
				    if (leaveDetail != null) {
				        // check if this is not the row that was deleted
				        if (!leaveDetail.leaveType.equals(table.getValueAt(rowIndex, 0)) ||
				                !leaveDetail.startDate.equals(table.getValueAt(rowIndex, 1)) ||
				                !leaveDetail.endDate.equals(table.getValueAt(rowIndex, 2)) ||
				                !leaveDetail.leaveStatus.equals(table.getValueAt(rowIndex, 3)) ||
				                !leaveDetail.leaveDescription.equals(table.getValueAt(rowIndex, 4))) {
				            // write the leave detail to the CSV file
				            writer.write(leaveDetail.employeeNumber + "," +
				            			  leaveDetail.leaveType + "," +
				                          leaveDetail.startDate + "," +
				                          leaveDetail.endDate + "," +
				                          leaveDetail.leaveStatus + "," +
				                          leaveDetail.leaveDescription);
				            writer.newLine();
				        }
				    }
				}

				// close the CSV file
				writer.close();
				} catch (FileNotFoundException ex) {
			        ex.printStackTrace();
			    } catch (IOException ex) {
					ex.printStackTrace();
				}
				

				LeavePageRedirector redirector = new LeavePageRedirector();
				redirector.redirect();
				setVisible(false);
				dispose();
				}
			}
		});
		getContentPane().add(btnDelete);
		
		btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setEnabled(false);
		btnCancel_1.setBounds(101, 338, 79, 23);
		btnCancel_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Cancel this leave application?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
				// get the selected row index
				int rowIndex = table.getSelectedRow();
				
				if (rowIndex != -1) {
//				data[rowIndex][3] = "Cancelled";
//	            table.getModel().setValueAt("Cancelled", rowIndex, 3);
				// open the CSV file for writing
				try {
					File tempFile = new File("temp.csv");
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


				// loop through the leave array and write to the CSV file
				for (LeaveDetails leaveDetail : leave) {
				    // check if leaveDetail is not null
				    if (leaveDetail != null) {
				        // check if this is not the row that was edited
				    	if (leaveDetail.leaveType.equals(table.getValueAt(rowIndex, 0)) &&
				                leaveDetail.startDate.equals(table.getValueAt(rowIndex, 1)) &&
				                leaveDetail.endDate.equals(table.getValueAt(rowIndex, 2)) &&
				                leaveDetail.leaveStatus.equals(table.getValueAt(rowIndex, 3)) &&
				                leaveDetail.leaveDescription.equals(table.getValueAt(rowIndex, 4))) {
				                
				                // write the updated cancelled leave detail to the CSV file
				                writer.write(leaveDetail.employeeNumber + "," +
				                    leaveDetail.leaveType + "," +
				                    leaveDetail.startDate + "," +
				                    leaveDetail.endDate + "," +
				                    "Cancelled by Employee" + "," +
				                    leaveDetail.leaveDescription);
				                writer.newLine();
				            } else {
				                // write the original leave detail to the CSV file
				                writer.write(leaveDetail.employeeNumber + "," +
				                    leaveDetail.leaveType + "," +
				                    leaveDetail.startDate + "," +
				                    leaveDetail.endDate + "," +
				                    leaveDetail.leaveStatus + "," +
				                    leaveDetail.leaveDescription);
				                writer.newLine();
				        }
				    }
				}

				// close the CSV file
				writer.close();
				
				File originalFile = new File(path);
				if (originalFile.delete()) {
				    tempFile.renameTo(originalFile);
				} 
				
				} catch (FileNotFoundException ex) {
			        ex.printStackTrace();
			    } catch (IOException ex) {
					ex.printStackTrace();
				}
				} else {
				    // Handle the case where the original file cannot be deleted
				}

				
				LeavePageRedirector redirector = new LeavePageRedirector();
				redirector.redirect();
				setVisible(false);
				dispose();
				}
				
			}
		});
		getContentPane().add(btnCancel_1);
		
		// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	setIconImage(icon.getImage());
    	setResizable(false);
    	// EVENTS
    	btnApplyLeave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLeaveDetails();
			}
		});
    	
	}
	
	public void checkLeaveDetails() {
		
		newLeaveDetails[0] = login.getEmployeeNumber();
		
		if (comboBoxLeaveType.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(LeaveApplication.this, "      Please select leave type.", "Invalid Input", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		} else {
			newLeaveDetails[1] = (String) comboBoxLeaveType.getSelectedItem();
		}
		
		if (comboBoxLeaveType.getSelectedIndex() == 1 && SlCount == 5) {
			JOptionPane.showMessageDialog(LeaveApplication.this, "You have already reached the allowed   \n              maximum sick leaves.", "Leave Maxed Out", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		} else if (comboBoxLeaveType.getSelectedIndex() == 2 && VlCount == 10) {
			JOptionPane.showMessageDialog(LeaveApplication.this, "You have already reached the allowed  \n        maximum vacation leaves.", "Leave Maxed Out", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		} else if (comboBoxLeaveType.getSelectedIndex() == 3 && ElCount == 5) {
			JOptionPane.showMessageDialog(LeaveApplication.this, "You have already reached the allowed  \n        maximum emergency leaves.", "Leave Maxed Out", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		}
		Date selectedStartDate = (Date) txtStartDate.getDate(),
				   selectedEndDate = (Date) txtEndDate.getDate();
			if (selectedStartDate != null && selectedEndDate != null) {
				newLeaveDetails[2] = formatter.format(txtStartDate.getDate());
				newLeaveDetails[3] = formatter.format(txtEndDate.getDate());				
			} else if (selectedStartDate != null) {
				JOptionPane.showMessageDialog(LeaveApplication.this, "Please enter leave end date.", "Date Input Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if (selectedEndDate != null) {
				JOptionPane.showMessageDialog(LeaveApplication.this, "Please enter leave start date.", "Date Input Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(LeaveApplication.this, "Please enter leave start and end dates.", "Date Input Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if (!txtLeaveDescription.getText().trim().isEmpty()) {
			    newLeaveDetails[5] = txtLeaveDescription.getText().trim();
			} else {
				JOptionPane.showMessageDialog(LeaveApplication.this, "Leave description should not be blank.", "Please Enter Reason", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			fileLeave();	
	}
	
	public void fileLeave() {
		newLeaveDetails[4] = "Applied";
		
		JOptionPane.showMessageDialog(LeaveApplication.this, "Leave application successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
		
		// Clear fields after successful application
		updateCsvFiles();
		clearFields();
	}
	
	public void clearFields() {
		comboBoxLeaveType.setSelectedIndex(0);
		txtStartDate.setDate(null);
		txtEndDate.setDate(null);
		txtLeaveDescription.setText(null);
		SlCount = 0;
		VlCount = 0;
		ElCount = 0;
		readCsvFiles();
	}
	
	public void updateCsvFiles() {
		try {
			FileWriter fw = new FileWriter("csv/AppliedLeaves.csv", true);
		    PrintWriter outFile = new PrintWriter(fw);
				outFile.print(newLeaveDetails[0] + ",");
				outFile.print(newLeaveDetails[1] + ",");
				outFile.print(newLeaveDetails[2] + ",");
				outFile.print(newLeaveDetails[3] + ",");
				outFile.print(newLeaveDetails[4] + ",");
				outFile.print(newLeaveDetails[5] + "\n");

			outFile.close();
		} catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
		
	}
	
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = login.getEmployeeNumber();
	}
}
