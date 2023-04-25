package com.motorph.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeMaster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	String path = "EmployeeDetails.csv", line = "";
	protected EmployeeDetails[] employee = new EmployeeDetails[25];
	
	private String newFname, newLname, newBday, newAddress, newPhoneNumber, newStatus, newPosition, newSupervisor;
	private int employeeCount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EmployeeMaster frame = new EmployeeMaster();
		frame.viewEmployeeMaster();
		
	}
	
	public void viewEmployeeMaster() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMaster frame = new EmployeeMaster();
					frame.readCsvFile();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(789,373);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	setIconImage(icon.getImage());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setBounds(10, 61, 753, 204);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		
		
		
		JLabel lblMotorphEmployeeMaster = new JLabel("MotorPH Employee Master");
		lblMotorphEmployeeMaster.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotorphEmployeeMaster.setBounds(285, 27, 184, 17);
		getContentPane().add(lblMotorphEmployeeMaster);
		
		JButton btnBack = new JButton("Exit");
		btnBack.setBounds(687, 286, 64, 23);
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
		
		JButton btnView = new JButton("View >>");
		btnView.setEnabled(false);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(108, 286, 82, 23);
		
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
		btnView.setBounds(20, 286, 82, 23);
		getContentPane().add(btnView);
		getContentPane().add(btnDelete);
		
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
		PrintWriter outFile = new PrintWriter("EmployeeDetails.csv");
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
}
