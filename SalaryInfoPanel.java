/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipayrollsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tone
 */
public class SalaryInfoPanel extends JPanel {
    
    private JLabel lblSalEmployeeNo, lblEmployeeStats, lblEmployeePosition, lblSalaryClass,
	lblBasicSalary, lblRiceSubsidy, lblPhoneAllowance, lblClothingAllowance, lblSalaryInfo;
    private JTextField txtSalEmployeeNo, txtEmployeeStats, txtEmployeePosition, txtSalaryClass,
	txtBasicSalary, txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance;
    
    private JButton btnSalaryBack;
    private JPanel salaryInfoPanel;
    
    
      public SalaryInfoPanel(){
          setLayout(null);
          
        // Initialize panel for salary info
            salaryInfoPanel = new JPanel();
            salaryInfoPanel.setLayout(null);

        // Salary Info Panel components
            lblSalaryInfo = new JLabel("Salary Information");
            lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblSalEmployeeNo = new JLabel("Employee No.:");
            lblEmployeeStats = new JLabel("Employee Status:");
            lblEmployeePosition = new JLabel("Employee Position:");
            lblSalaryClass = new JLabel("Salary Class:");
            lblBasicSalary = new JLabel("Basic Salary:");
            lblRiceSubsidy = new JLabel("Rice Subsidy:");
            lblPhoneAllowance = new JLabel("Phone Allowance:");
            lblClothingAllowance = new JLabel("Clothing Subsidy:");

            txtSalEmployeeNo = new JTextField(20);
            txtSalEmployeeNo.setEnabled(false);
            txtSalEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
            txtSalEmployeeNo.setText("10001");

            txtEmployeeStats = new JTextField(20);
            txtEmployeeStats.setEnabled(false);
            txtEmployeeStats.setDisabledTextColor(new Color(128, 128, 128));
            txtEmployeeStats.setText("Regular");

            txtEmployeePosition	= new JTextField(20);
            txtEmployeePosition.setEnabled(false);
            txtEmployeePosition.setDisabledTextColor(new Color(128, 128, 128));
            txtEmployeePosition.setText("HR Manager");

            txtSalaryClass = new JTextField(20);
            txtSalaryClass.setEnabled(false);
            txtSalaryClass.setDisabledTextColor(new Color(128, 128, 128));
            txtSalaryClass.setText("Rank and File");

            txtBasicSalary = new JTextField(20);
            txtBasicSalary.setEnabled(false);
            txtBasicSalary.setDisabledTextColor(new Color(128, 128, 128));
            txtBasicSalary.setText("PHP 62, 670.00");

            txtRiceSubsidy = new JTextField(20);
            txtRiceSubsidy.setEnabled(false);
            txtRiceSubsidy.setDisabledTextColor(new Color(128, 128, 128));
            txtRiceSubsidy.setText("PHP 1,500.00");

            txtPhoneAllowance = new JTextField(20);
            txtPhoneAllowance.setEnabled(false);
            txtPhoneAllowance.setDisabledTextColor(new Color(128, 128, 128));
            txtPhoneAllowance.setText("PHP 1,000.00");

            txtClothingAllowance = new JTextField(20);
            txtClothingAllowance.setEnabled(false);
            txtClothingAllowance.setDisabledTextColor(new Color(128, 128, 128));
            txtClothingAllowance.setText("PHP 1,000.00");

            btnSalaryBack = new JButton("Back");
            btnSalaryBack.setBounds(265, 260, 80, 30);
            btnSalaryBack.addActionListener((ActionEvent e) -> {
                Employee employee = new Employee();
                employee.callProfileMenu();
            });

            // Set label and text field positions
            lblSalaryInfo.setBounds(250, 10, 150, 40);
            lblSalEmployeeNo.setBounds(20, 60, 100, 20);
            txtSalEmployeeNo.setBounds(150, 60, 150, 20);
            lblEmployeeStats.setBounds(320, 60, 100, 20);
            txtEmployeeStats.setBounds(430, 60, 150, 20);
            lblEmployeePosition.setBounds(20, 100, 120, 20);
            txtEmployeePosition.setBounds(150, 100, 150, 20);
            lblSalaryClass.setBounds(320, 100, 100, 20);
            txtSalaryClass.setBounds(430, 100, 150, 20);
            lblBasicSalary.setBounds(20, 140, 100, 20);
            txtBasicSalary.setBounds(150, 140, 150, 20);
            lblRiceSubsidy.setBounds(320, 140, 100, 20);
            txtRiceSubsidy.setBounds(430, 140, 150, 20);
            lblPhoneAllowance.setBounds(20, 180, 120, 20);
            txtPhoneAllowance.setBounds(150, 180, 150, 20);
            lblClothingAllowance.setBounds(320, 180, 110, 20);
            txtClothingAllowance.setBounds(430, 180, 150, 20);

            // Add components to salary info panel
                       
            add(lblSalaryInfo);
            add(lblSalEmployeeNo);
            add(txtSalEmployeeNo);
            add(lblEmployeeStats);
            add(lblEmployeePosition);
            add(lblSalaryClass);
            add(lblBasicSalary);
            add(lblRiceSubsidy);
            add(lblPhoneAllowance);
            add(lblClothingAllowance);
            add(txtEmployeeStats);
            add(txtEmployeePosition);
            add(txtSalaryClass);
            add(txtBasicSalary);
            add(txtRiceSubsidy);
            add(txtPhoneAllowance);
            add(txtClothingAllowance);
            add(btnSalaryBack);
        }
}
