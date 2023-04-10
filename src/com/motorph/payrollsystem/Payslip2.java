package com.motorph.payrollsystem;

import java.util.Scanner;

public class Payslip2 {
	
	double rice, phone, clothes; // Employee allowances
	double taxablePay; // hoursworked * employee hourly rate
	double nonTaxPay; // Employee weekly allowance total
	double deductionsTtl; // Employee weekly total deductions
	
	public void displayPayslipMenu() {  // Displays payslip menu		
	  Scanner scan = new Scanner(System.in); 

        System.out.println("Please Enter Pay Period");  
        System.out.println();
        System.out.println("1.September 2022 1st Pay Period");
        System.out.println("2.September 2022 2nd Pay Period");
        System.out.println("3.September 2022 3rd Pay Period");

        int payPeriodChoice = scan.nextInt();

        switch (payPeriodChoice) {
            case 1:
            printPayslipInfo();
            break;
            
            case 2:
            System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
            break;

            case 3:
            System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
            break;

            default:
            System.out.println("Wrong Input. Please Try Again.");
            break;
        }
        
	}
	


	private void printPayslipInfo() {

        //Prints out the basicoye payslip info of the employee
        // 1. Basic employee pay

            PrintNReadTxt readTxt = new PrintNReadTxt();
            double[] weeklyPay = readTxt.getWeeklyPay();
            readTxt.printRead();
            System.out.println(weeklyPay[0]);
    }
}