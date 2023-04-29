/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipayrollsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tone
 */
public class PersonalInfoPanel extends JPanel {
    
        private JLabel lblPersonalInfo, lblEmployeeNo, lblLastName, 
	lblFirstName, lblBirthday, lblAddress, lblPhoneNo, lblSssNo, lblPhic, lblTinNo,
	lblHdmfNo;
	private JTextField txtEmployeeNo, txtLastName, 
	txtFirstName, txtBirthday, txtAddress, txtPhoneNo, txtSssNo, txtPhic, txtTinNo,
	txtHdmfNo;
	
	private JButton btnBack;
	private JPanel personalInfoPanel;

        public PersonalInfoPanel(){
            setLayout(null);

            personalInfoPanel = new JPanel();
            personalInfoPanel.setLayout(null);

                    // Personal Info panel components
            lblPersonalInfo = new JLabel("Personal Information");
            lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblEmployeeNo = new JLabel("Employee No.:");
            lblLastName = new JLabel("Last Name:");
            lblFirstName = new JLabel("First Name");
            lblBirthday = new JLabel("Birthday:");
            lblAddress = new JLabel("Address:");
            lblPhoneNo = new JLabel("Phone No.:");
            lblSssNo= new JLabel("SSS No.:");
            lblPhic = new JLabel("Philhealth No.:");
            lblTinNo = new JLabel("TIN No.:");
            lblHdmfNo = new JLabel("Pag-ibig No.:");

            txtEmployeeNo = new JTextField(20);
            txtEmployeeNo.setEnabled(false);
            txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
            txtEmployeeNo.setText("10001");

            txtLastName = new JTextField(20);
            txtLastName.setEnabled(false);
            txtLastName.setDisabledTextColor(new Color(128, 128, 128));
            txtLastName.setText("Crisostomo");

            txtFirstName = new JTextField(20);
            txtFirstName.setEnabled(false);
            txtFirstName.setDisabledTextColor(new Color(128, 128, 128));
            txtFirstName.setText("Jose");

            txtBirthday = new JTextField(20);
            txtBirthday.setEnabled(false);
            txtBirthday.setDisabledTextColor(new Color(128, 128, 128));
            txtBirthday.setText("February 14, 1988");

            txtAddress = new JTextField(20);
            txtAddress.setEnabled(false);
            txtAddress.setDisabledTextColor(new Color(128, 128, 128));
            txtAddress.setText("17/85 Stracke Via");

            txtPhoneNo = new JTextField(20);
            txtPhoneNo.setEnabled(false);
            txtPhoneNo.setDisabledTextColor(new Color(128, 128, 128));
            txtPhoneNo.setText("918-621-603");

            txtSssNo = new JTextField(20);
            txtSssNo.setEnabled(false);
            txtSssNo.setDisabledTextColor(new Color(128, 128, 128));
            txtSssNo.setText("49-1632020-8");

            txtPhic = new JTextField(20);
            txtPhic.setEnabled(false);
            txtPhic.setDisabledTextColor(new Color(128, 128, 128));
            txtPhic.setText("38-218945314-5");

            txtTinNo = new JTextField(20);
            txtTinNo.setEnabled(false);
            txtTinNo.setDisabledTextColor(new Color(128, 128, 128));
            txtTinNo.setText("317-674-022-000");

            txtHdmfNo = new JTextField(20);
            txtHdmfNo.setEnabled(false);
            txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));
            txtHdmfNo.setText("4410-9336-9646");

            btnBack = new JButton("Back");
            btnBack.setBounds(265, 260, 80, 30);
            btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            PersonalInfoPanel infoPanel = new PersonalInfoPanel();
                            infoPanel.setVisible(false);
                            Employee employee = new Employee();
                            employee.callProfileMenu();				
			}
		});
                    // Set label and text field positions
            lblPersonalInfo.setBounds(250, 10, 250, 40);
            lblEmployeeNo.setBounds(50, 50, 100, 20);
            txtEmployeeNo.setBounds(150, 50, 150, 20);
            lblLastName.setBounds(50, 80, 100, 20);
            txtLastName.setBounds(150, 80, 150, 20);
            lblFirstName.setBounds(50, 110, 100, 20);
            txtFirstName.setBounds(150, 110, 150, 20);
            lblBirthday.setBounds(50, 140, 100, 20);
            txtBirthday.setBounds(150, 140, 150, 20);
            lblAddress.setBounds(50, 170, 100, 20);
            txtAddress.setBounds(150, 170, 150, 20);
            lblPhoneNo.setBounds(50, 200, 100, 20);
            txtPhoneNo.setBounds(150, 200, 150, 20);
            lblSssNo.setBounds(50, 230, 100, 20);
            txtSssNo.setBounds(150, 230, 150, 20);
            lblPhic.setBounds(320, 50, 100, 20);
            txtPhic.setBounds(420, 50, 150, 20);
            lblTinNo.setBounds(320, 80, 100, 20);
            txtTinNo.setBounds(420, 80, 150, 20);
            lblHdmfNo.setBounds(320, 110, 100, 20);
            txtHdmfNo.setBounds(420, 110, 150, 20);

            // Add components to personal info panel

            add(lblPersonalInfo);
            add(lblEmployeeNo);
            add(txtEmployeeNo);
            add(lblLastName);
            add(txtLastName);
            add(lblFirstName);
            add(txtFirstName);
            add(lblBirthday);
            add(txtBirthday);
            add(lblAddress);
            add(txtAddress);
            add(lblPhoneNo);
            add(txtPhoneNo);
            add(lblSssNo);
            add(txtSssNo);
            add(lblPhic);
            add(txtPhic);
            add(lblTinNo);
            add(txtTinNo);
            add(lblHdmfNo);
            add(txtHdmfNo);
            add(btnBack);
            
            
//            personalInfoPanel.add(lblPersonalInfo);
//            personalInfoPanel.add(lblEmployeeNo);
//            personalInfoPanel.add(txtEmployeeNo);
//            personalInfoPanel.add(lblLastName);
//            personalInfoPanel.add(txtLastName);
//            personalInfoPanel.add(lblFirstName);
//            personalInfoPanel.add(txtFirstName);
//            personalInfoPanel.add(lblBirthday);
//            personalInfoPanel.add(txtBirthday);
//            personalInfoPanel.add(lblAddress);
//            personalInfoPanel.add(txtAddress);
//            personalInfoPanel.add(lblPhoneNo);
//            personalInfoPanel.add(txtPhoneNo);
//            personalInfoPanel.add(lblSssNo);
//            personalInfoPanel.add(txtSssNo);
//            personalInfoPanel.add(lblPhic);
//            personalInfoPanel.add(txtPhic);
//            personalInfoPanel.add(lblTinNo);
//            personalInfoPanel.add(txtTinNo);
//            personalInfoPanel.add(lblHdmfNo);
//            personalInfoPanel.add(txtHdmfNo);
//            personalInfoPanel.add(btnBack);
        
    }
}
