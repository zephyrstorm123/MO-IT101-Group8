package com.mycompany.exercise1.copy;



/**
 *
 * @author Michael
 */

import java.util.*;

public class PayrollSystem {
	
	
	static String pass;
	static int empNo;
	
	// EMPLOYEE LOG IN DETAILS
	static int emp1No = 10001;
	static String emp1pw = "Admin1234";
	static String emp1un = "Jose";
	static int emp2No = 10002;
	static String emp2pw = "Empl1234";
	static String emp2un = "Christian";
	static int emp3No = 10003;
	static String emp3pw = "Empl1111";
	static String emp3un = "Brad";
	
	
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to MotorPH Payroll System");
		insertData();
	}
	
	public static void insertData() {
		System.out.println("Please Enter Employee Number:");
        empNo = scan.nextInt();
        
        if (empNo != 0) {
        System.out.println("Please Enter Password:");
        pass = scan.next(); 
        loginPage();
        }
        else if (empNo == 0) {
        	System.out.println("App Closed. Thank you for using the app!");
        	System.exit(0);
        }
	}
	
	public static void againPass() {
		System.out.println("Incorrect Password. Please Try Again.");
		pass = scan.next();
		loginPage();
	}
	
	public static void loginPage() {
		if (empNo == emp1No || empNo == emp2No || empNo == emp3No) {
			System.out.println();
			if (pass.equals(emp1pw) && empNo == emp1No || pass.equals(emp2pw) && empNo == emp2No || pass.equals(emp3pw) && empNo == emp3No) {
				System.out.println("===================================================");
	            System.out.println("                LOGIN SUCCESSFUL");
	         	System.out.println("===================================================");
	         	mMenu();
			} else {
				againPass();
			}
			
		} else if (empNo == 0) {
			System.out.println("App Closed. Thank you for using the app!");
			System.exit(0);
		}
		
		else {
			System.out.println("Employee Number Not Found.");
			insertData();
		}
	}
	
	public static void mMenu() {
		switch (empNo) {
		case 10001: 
			System.out.println();
			System.out.println("Welcome, " + emp1un + "!");
			break;
		case 10002:
			System.out.println();
			System.out.println("Welcome, " + emp2un + "!");
			break;
		case 10003:
			System.out.println();
			System.out.println("Welcome, " + emp3un + "!");
			break;
		}
		
		System.out.println();
        System.out.println("Payroll Application Menu");
        System.out.println();
        System.out.println("1. My Employee Profile");
        System.out.println("2. Employee Master");
        System.out.println("3. Timekeeping");
        System.out.println("4. Payroll Register");
        System.out.println("5. System Administration");
        System.out.println("6. Log Out");
        
        int mmo = scan.nextInt();
        
        switch (mmo) {
        case 1:
        	profMenu();
        	break;
        case 2:
        	System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
        	mMenu();
        	break;
        case 6:
        	System.out.println("Enter '0' to Exit Application.");
        	main(null);
        	break;
        default :
        	System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
        	mMenu();
        	break;
        	
        }
	}
	
	public static void profMenu() {
		System.out.println("My Profile Menu:");
    	System.out.println();
    	System.out.println("1. Personal Information");
    	System.out.println("2. Salary Information");
    	System.out.println("3. Daily Timesheet");
    	System.out.println("4. Leave and Overtime");
    	System.out.println("5. Payslip");
    	System.out.println("6. Back");
    	
    	int pmo = scan.nextInt();
    	
    	switch (pmo) {
        case 1:
        	perInfo();
        	break;
        case 2:
        	salRec();
        	break;
        case 3:
        	dTimeLoc();
        	break;
        case 5:
        	Payslip.paySlipMenu();
        	break;
        case 6:
        	mMenu();
        	break;
        default :
        	System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
        	profMenu();
        	break;
    	
    	}

	}
	
	public static void perInfo() {
		
		// EMPLOYEE INFOS
		
		String emp1info = "Employee No.: 10001\r\n"
				+ "Last Name: Crisostomo\r\n"
				+ "First Name: Jose\r\n"
				+ "Birthday: February 14, 1988\r\n"
				+ "Address: 17/85 Stracke Via\r\n"
				+ "Phone Number: 918-621-603\r\n"
				+ "SSS #: 49-1632020-8\r\n"
				+ "PhilHealth #: 38-218945314-5\r\n"
				+ "TIN #: 317-674-022-000\r\n"
				+ "Pag-ibig #: 4410-9336-9646";
		
		String emp2info = "Employee No.: 10002\r\n"
				+ "Last Name: Mata\r\n"
				+ "First Name: Christian\r\n"
				+ "Birthday: October 21, 1987\r\n"
				+ "Address: 90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu\r\n"
				+ "Phone Number: 783-776-744\r\n"
				+ "SSS #: 49-2959312-6\r\n"
				+ "PhilHealth #: 82-418796196-2\r\n"
				+ "TIN #: 103-100-522-000\r\n"
				+ "Pag-ibig #: 2180-0247-3454";
		
		// PRINTS EMPLOYEE INFORMATION
				
		System.out.println("Personal Information:");
		System.out.println();
		System.out.println("===================================================");
		
		switch (empNo) {
		case 10001:
			System.out.println(emp1info);
			break;
		case 10002:
			System.out.println(emp2info);
			break;
		}
		
		System.out.println("===================================================");
		System.out.println();
		System.out.println("1. Back");
		
		int pio = scan.nextInt();
		if (pio == 1) {
			profMenu();
		} else {
			
		}
		
	}
	
	public static void salRec() {
		
		String emp1salRec = "Employee No: 10001\r\n"
				+ "Employee Status: Regular\r\n"
				+ "Employee Position: HR Manager\r\n"
				+ "Salary Class: Rank and File\r\n"
				+ "Basic Salary: PHP 62,670.00\r\n"
				+ "Rice Subsidy: PHP 1,500.00\r\n"
				+ "Phone Allowance: PHP 1,000.00\r\n"
				+ "Clothing Allowance: PHP 1,000.00";
		
		String emp2salRec = "Employee No: 10002\r\n"
				+ "Employee Status: Regular\r\n"
				+ "Employee Position: Account Team Leader\r\n"
				+ "Salary Class: Rank and File\r\n"
				+ "Basic Salary: PHP 42,975.00\r\n"
				+ "Rice Subsidy: PHP 1,500.00\r\n"
				+ "Phone Allowance: PHP 1,000.00\r\n"
				+ "Clothing Allowance: PHP 1,000.00";
		
		System.out.println("Salary Information:");
		System.out.println();
		System.out.println("===================================================");
		
		switch (empNo) {
		case 10001:
			System.out.println(emp1salRec);
			break;
		case 10002:
			System.out.println(emp2salRec);
			break;
		}
		
		System.out.println("===================================================");
		System.out.println();
		System.out.println("1. Back");
		
		int sro = scan.nextInt();
		if (sro == 1) {
			profMenu();
		} else {
			
		}		
	}
	
	public static void dTimeLoc() {
		switch (empNo) {
		
		case 10001:
			HoursWorked.dTime();
			break;
		case 10002:
			HoursWorked.dTime();
			break;
		default:
			System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
			profMenu();
			break;
			
		}
		
	}
	
}
	