package com.motorph.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class EmployeeMaster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	String path = "csv/EmployeeDetails.csv", line = "";
	protected EmployeeDetails[] employee = new EmployeeDetails[25];
	
	private String newFname, newLname, newBday, newAddress, newPhoneNumber, newStatus, newPosition, newSupervisor;
	private int employeeCount;
	private JTable table_1;
	
	private LeaveDetails[] leave = new LeaveDetails[50];
	private int SlCount, VlCount, ElCount, leaveCount, count;
	private Object[][] data;
	private String pathAL = "csv/AppliedLeaves.csv";
	private JButton btnApprove, btnReject;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EmployeeMaster frame = new EmployeeMaster();
//		frame.viewEmployeeMaster();
//		
//	}
	
	public void viewEmployeeMaster() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMaster frame = new EmployeeMaster();
					frame.readCsvFile();
					frame.loadLeaveApplications();
//					frame.updateCsv();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void readCsvFile() {
	//Read from EmployeeDetails.csv
		employeeCount = 0;
	try {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int i = 0;

        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");
            
         // check if any value is empty or null
            boolean hasEmptyValue = false;
            for (String value : values) {
                if (value == null || value.isEmpty()) {
                    hasEmptyValue = true;
                    break;
                }
            }

            	if (hasEmptyValue) {
                // skip this line
                continue;
            }
            employeeCount++;
            employee[i] = new EmployeeDetails(values[0], values[1], values[2], values[3], values[4], values[5],
                    values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13],
                    values[14], values[15], values[16], values[17], values[18]);
            
            i++;
        }
        br.close();
        
        //Populate JTable with data
		Object[][] data = new Object[employeeCount][7];
		
		
		for (int j = 0; j < employeeCount; j++) {
//			System.out.println(j + " / " + employeeCount);
			if (this.employee[j] != null) {
				data[j][0] = employee[j].employeeNumber;
				data[j][1] = employee[j].lname;
				data[j][2] = employee[j].fname;
				data[j][3] = employee[j].sssNumber;
				data[j][4] = employee[j].philHealthNumber;
				data[j][5] = employee[j].tinNumber;
				data[j][6] = employee[j].pagIbigNumber;
			} else {
				
			}
		}
		table.setModel(new DefaultTableModel(
		    data,
		    new String[] {
		        "Employee No.", "Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pagibig No."
		    }
		));

		table.getColumnModel().getColumn(4).setPreferredWidth(84);
        
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
		e.printStackTrace();
	} 
}


	/**
	 * Create the frame.
	 */
	public EmployeeMaster() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(789,423);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	setIconImage(icon.getImage());
		
		JButton btnBack = new JButton("Exit");
		btnBack.setBounds(687, 350, 64, 23);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	dispose();
	        	PayrollSystem menu = new PayrollSystem();
	        	menu.mainMenu();
				
			}
		});
		getContentPane().add(btnBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 61, 753, 278);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Employee Records", null, panel, null);
		panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 39, 728, 166);
				panel.add(scrollPane);
				scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				table = new JTable();
				table.setDefaultEditor(Object.class, null);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				
				JButton btnView = new JButton("View >>");
				btnView.setBounds(20, 216, 82, 23);
				panel.add(btnView);
				btnView.setEnabled(false);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.setBounds(108, 216, 82, 23);
				panel.add(btnDelete);
				btnDelete.setEnabled(false);
				
				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("Employee Leave", null, panel_1, null);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 39, 728, 166);
				panel_1.add(scrollPane_1);
				
				btnApprove = new JButton("Approve");
				btnApprove.setEnabled(false);
				btnApprove.setBounds(20, 216, 82, 23);
				btnApprove.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int selectedRow = table_1.getSelectedRow();
						if (selectedRow == -1) {
							return;
						}
						int confirm = JOptionPane.showConfirmDialog(null, "Approve this leave application?", "Confirm Approval", JOptionPane.YES_NO_OPTION);
						
						if (confirm != JOptionPane.YES_OPTION) {
							return;
						}
						
						leave[(leaveCount - 1) - selectedRow].leaveStatus = "Approved";
						
						// Update CSV
						try (PrintWriter writer = new PrintWriter("csv/AppliedLeaves.csv")) {
							for (int i = 0; i < leaveCount; i++) {
								writer.write(leave[i].employeeNumber + "," + leave[i].leaveType + "," +
											 leave[i].startDate + "," + leave[i].endDate + "," + 
											 leave[i].leaveStatus + "," + leave[i].leaveDescription + "\n");
								
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						loadLeaveApplications();
					}
				});
				panel_1.add(btnApprove);
				
				btnReject = new JButton("Reject");
				btnReject.setEnabled(false);
				btnReject.setBounds(108, 216, 82, 23);
				btnReject.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int selectedRow = table_1.getSelectedRow();
						if (selectedRow == -1) {
							return;
						}
						int confirm = JOptionPane.showConfirmDialog(null, "Reject this leave application?", "Confirm Rejection", JOptionPane.YES_NO_OPTION);
						
						if (confirm != JOptionPane.YES_OPTION) {
							return;
						}
						
						leave[(leaveCount - 1) - selectedRow].leaveStatus = "Rejected";
						
						// Update CSV
						try (PrintWriter writer = new PrintWriter("csv/AppliedLeaves.csv")) {
							for (int i = 0; i < leaveCount; i++) {
								writer.write(leave[i].employeeNumber + "," + leave[i].leaveType + "," +
											 leave[i].startDate + "," + leave[i].endDate + "," + 
											 leave[i].leaveStatus + "," + leave[i].leaveDescription + "\n");
								
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						loadLeaveApplications();
						
					}
				});
				panel_1.add(btnReject);
				
				table_1 = new JTable();
				table_1.setDefaultEditor(Object.class, null);
				table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				    public void valueChanged(ListSelectionEvent event) {
				        int selectedRow = table_1.getSelectedRow();
				        if (selectedRow != -1) { // If a row is selected
				            String leaveStatus = (String) table_1.getValueAt(selectedRow, 4);
				            String employeeNumber = (String) table_1.getValueAt(selectedRow, 0);
				            if (leaveStatus.equals("Applied")) {
				            	if (!UserLogin.user.equals(employeeNumber)) {
				                btnApprove.setEnabled(true);
				                btnReject.setEnabled(true);
				                } else {
				                	btnApprove.setEnabled(false);
					                btnReject.setEnabled(false);
				                }
				            } else {
				                btnApprove.setEnabled(false);
				                btnReject.setEnabled(false);
				            }
				            
				        } else {
				            
				        }
				    }
				});
				scrollPane_1.setViewportView(table_1);		
						
						JLabel lblMotorphEmployeeMaster = new JLabel("MotorPH Employee Master");
						lblMotorphEmployeeMaster.setBounds(294, 33, 184, 17);
						getContentPane().add(lblMotorphEmployeeMaster);
						lblMotorphEmployeeMaster.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				btnDelete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int i = table.getSelectedRow();
						if (i > 0) {
							
							int confirm = JOptionPane.showConfirmDialog(null, "Delete " + employee[i].fname + "'s Employee Record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
	    	        if (confirm == JOptionPane.YES_OPTION) {
	    	            // Save changes to CSV file
							newFname = "";
							newLname = "";
							newBday = "";
							newAddress = "";
							newPhoneNumber = "";
							newStatus = "";
							newPosition = "";
							newSupervisor = "";
							
							employeeCount--;
							updateCsv(i);
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							int[] selectedRows = table.getSelectedRows();
							for (i = selectedRows.length - 1; i >= 0; i--) {
							    model.removeRow(selectedRows[i]);
							}
							readCsvFile();
	    	        }
						} else if (i == 0) {
							System.out.println();
							JOptionPane.showMessageDialog(EmployeeMaster.this, "You don't have permission to delete this employee's records.", "Permission Error", JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(EmployeeMaster.this, "Delete Error");
						}
					}
				});
				
				btnView.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int i = table.getSelectedRow();
						if (i >= 0) {
							EmployeeDetailsViewer view = new EmployeeDetailsViewer();
							view.setSelection(table.getSelectedRow());
							view.viewDetails();
							setVisible(false);
							dispose();
						} else {
							JOptionPane.showMessageDialog(EmployeeMaster.this, "View Error");
						}
					}
				});
				
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				    public void valueChanged(ListSelectionEvent event) {
				        int selectedRow = table.getSelectedRow();
				        if (selectedRow != -1) { // If a row is selected
				        	btnView.setEnabled(true);
				        	btnDelete.setEnabled(true);
				        } else {
				        	btnView.setEnabled(false);
				        	btnDelete.setEnabled(false);
				        }
				    }
				});
	}
	
	public void updateCsv(int employeeNo) {
		employee[employeeNo].fname = newFname;
		employee[employeeNo].lname = newLname;
		employee[employeeNo].bday = newBday;
		employee[employeeNo].address = newAddress;
		employee[employeeNo].phoneNumber = newPhoneNumber;
		employee[employeeNo].status = newStatus;
		employee[employeeNo].position = newPosition;
		employee[employeeNo].immediateSupervisor = newSupervisor;
		
		try {
		PrintWriter outFile = new PrintWriter("csv/EmployeeDetails.csv");
			for (int i = 0; i < employee.length; i++) {
				if (employee[i] != null) {
				outFile.print(employee[i].employeeNumber + ",");
				outFile.print(employee[i].lname + ",");
				outFile.print(employee[i].fname + ",");
				outFile.print(employee[i].bday + ",");
				outFile.print(employee[i].address + ",");
				outFile.print(employee[i].phoneNumber + ",");
				outFile.print(employee[i].sssNumber + ",");
				outFile.print(employee[i].philHealthNumber + ",");
				outFile.print(employee[i].tinNumber + ",");
				outFile.print(employee[i].pagIbigNumber + ",");
				outFile.print(employee[i].status + ",");
				outFile.print(employee[i].position + ",");
				outFile.print(employee[i].immediateSupervisor + ",");
				outFile.print(employee[i].basicSalary + ",");
				outFile.print(employee[i].riceSubsidy + ",");
				outFile.print(employee[i].phoneAllowance + ",");
				outFile.print(employee[i].clothingAllowance + ",");
				outFile.print(employee[i].grossSemiMonthlyRate + ",");
				outFile.print(employee[i].hourlyRate + "\n");
				}
			}
			outFile.close();
		} catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public void setNewDetails(String lname, String fname, String bday, String address, String phoneNumber, String status,
			String position, String immediateSupervisor) {
		this.newLname = lname;
		this.newFname = fname;
		this.newBday = bday;
		this.newAddress = address;
		this.newPhoneNumber = phoneNumber;
		this.newStatus = status;
		this.newPosition = position;
		this.newSupervisor = immediateSupervisor;
	}
	
	public void loadLeaveApplications() {
		count = 0;
		leaveCount = 0;
		
		int i = 0;
		try {
	        BufferedReader br = new BufferedReader(new FileReader(pathAL));
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
	        	if (leave[k] != null) {
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
//	        System.out.println("Leave Count: " + leaveCount + 
//	        			"\n" + "Sick Leaves: " + SlCount +
//	        			"\n" + "Vacation Leaves: " + VlCount +
//	        			"\n" + "Emergency Leaves: " + ElCount + "\n");
	        //Populate JTable with data
			data = new Object[leaveCount][6];
			
			
			int counter = 0;
			for (int j = leave.length - 1; j >= 0; j--) {
			    if (leave[j] != null) {
			    	data[counter][0] = leave[j].employeeNumber;
			        data[counter][1] = leave[j].leaveType;
			        data[counter][2] = leave[j].startDate;
			        data[counter][3] = leave[j].endDate;
			        data[counter][4] = leave[j].leaveStatus;
			        data[counter][5] = leave[j].leaveDescription;
			        counter++;
			    }
			}
			table_1.setModel(new DefaultTableModel(
			    Arrays.copyOfRange(data, 0, counter),
			    new String[] {
			        "Employee No.", "Leave Type", "Start Date", "End Date", "Leave Status", "Leave Description"
			    }
			));

			table_1.getColumnModel().getColumn(4).setPreferredWidth(84);
	        }
}
