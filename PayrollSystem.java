package com.motorph.payrollsystem;



/**
 *
 * @author Michael
 */

import java.util.*;

public class PayrollSystem {
	
	
	static String pass;
	static String empNo;
	
	// EMPLOYEE LOG IN DETAILS
	static String emp1No = "10001";
	static String emp1pw = "Admin1234";
	static String emp1un = "Jose";
	static String emp2No = "10002";
	static String emp2pw = "Empl1234";
	static String emp2un = "Christian";
	static String emp3No = "10003";
	static String emp3pw = "Empl1111";
	static String emp3un = "Brad";
	
	static int i;
	static String mmo, pmo;
	static String invInp;
	
	static Scanner scan = new Scanner(System.in);
	
	//Welcome page, will direct to login page
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to MotorPH Payroll System");
		insertData();
	}
	
	//User login page
	public static void insertData() throws Exception {
		
	
		System.out.println("Please Enter Employee Number:");
        empNo = scan.next();
		

        if (!empNo.equals("0")) {
        System.out.println("Please Enter Password:");
        pass = scan.next();
        loginPage();
        }
        else if (empNo.equals("0")) {
        	System.out.println("App Closed. Thank you for using the app!");
        	System.exit(0);
        }
		
	}
	
	//Wrong password message and reinitialize variable for password
	public static void againPass() throws Exception {
		System.out.println("Incorrect Password. Please Try Again.");
		pass = scan.next();
		loginPage();
	}
	
	//Employee number and password verification
	public static void loginPage() throws Exception {
		if (empNo.equals(emp1No) || empNo.equals(emp2No) || empNo.equals(emp3No)) {
			System.out.println();
			if (pass.equals(emp1pw) && empNo.equals(emp1No) || pass.equals(emp2pw) && empNo.equals(emp2No) || pass.equals(emp3pw) && empNo.equals(emp3No)) {
				
				System.out.println("===================================================");
	            System.out.println("                LOGIN SUCCESSFUL");
	         	System.out.println("===================================================");
	         	mMenu();
			} else {
				i++;
				
					if (i <= 3) {
					againPass();
					
					} else {
						System.out.println("!! Too Many Incorrect Attempts. App Locked !!");
						System.exit(0);
					}
				
			}
			
		} else if (empNo.equals("0")) {
			System.out.println("App Closed. Thank you for using the app!");
			System.exit(0);
		}
		
		else {
			System.out.println("Employee Number Not Found.");
			insertData();
		}
	}
	
	//System main menu, thus the mMenu method. Lol
	//Only Option 1, 2, and 6 are functional, for now (TT ^ TT) 
	public static void mMenu() throws Exception {
		switch (empNo) {
		case "10001": 
			System.out.println("\nWelcome, " + emp1un + "!");
			break;
		case "10002":
			System.out.println("\nWelcome, " + emp2un + "!");
			break;
		case "10003":
			System.out.println("\nWelcome, " + emp3un + "!");
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
        
        
        mmo = scan.next();
    
        	
        switch (mmo) {
        case "1":
        	profMenu();
        	break;
        case "2":
        	if (empNo.equals("10001")) {
        	EmployeeMaster.main(null);
        	} else {
        		System.out.println("You do not have access to this option.");
        		mMenu();
        	}
        	break;
        case "6":
        	System.out.println("Enter '0' to Exit Application.");
        	main(null);
        	break;
        default :
        	System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
        	mMenu();
        	break;
        	
        }
	}
	
	//Profile Menu Page, Option 4 not available yet. Plz forgibb (TT TT)
	public static void profMenu() throws Exception {
		System.out.println("My Profile Menu:");
    	System.out.println();
    	System.out.println("1. Personal Information");
    	System.out.println("2. Salary Information");
    	System.out.println("3. Daily Timesheet");
    	System.out.println("4. Leave and Overtime");
    	System.out.println("5. Payslip");
    	System.out.println("6. Back");
    	

        pmo = scan.next();

    	switch (pmo) {
        case "1":
        	perInfo();
        	break;
        case "2":
        	salRec();
        	break;
        case "3":
        	dTimeLoc();
        	break;
        case "5":
        	Payslip.paySlipMenu();
        	break;
        case "6":
        	mMenu();
        	break;
        default :
        	System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
        	profMenu();
        	break;
    	
    	}

	}
	//Method that stores and prints the personal infos
	public static void perInfo() throws Exception {
		
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
		
		String emp3info = "Employee No.: 10003\r\n"
				+ "Last Name: San Jose\r\n"
				+ "First Name: Brad\r\n"
				+ "Birthday: March 15, 1996\r\n"
				+ "Address: 99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi\r\n"
				+ "Phone Number: 797-009-261\r\n"
				+ "SSS #: 40-2400714-1\r\n"
				+ "PhilHealth #: 23-919292693-9\r\n"
				+ "TIN #: 672-474-690-000\r\n"
				+ "Pag-ibig #: 2108-5020-9964";
		
		// PRINTS EMPLOYEE INFORMATION
				
		System.out.println("Personal Information:");
		System.out.println();
		System.out.println("===================================================");
		
		switch (empNo) {
		case "10001":
			System.out.println(emp1info);
			break;
		case "10002":
			System.out.println(emp2info);
			break;
		case "10003":
			System.out.println(emp3info);
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
	
	//Method that stores and prints monthly salary infos & records
	public static void salRec() throws Exception {
		
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
				+ "Phone Allowance: PHP 800.00\r\n"
				+ "Clothing Allowance: PHP 800.00";
		
		String emp3salRec = "Employee No: 10003\r\n"
				+ "Employee Status: Regular\r\n"
				+ "Employee Position: HR Team Leader\r\n"
				+ "Salary Class: Rank and File\r\n"
				+ "Basic Salary: PHP 42,975.00\r\n"
				+ "Rice Subsidy: PHP 1,500.00\r\n"
				+ "Phone Allowance: PHP 800.00\r\n"
				+ "Clothing Allowance: PHP 800.00";
		
		System.out.println("Salary Information:");
		System.out.println();
		System.out.println("===================================================");
		
		switch (empNo) {
		case "10001":
			System.out.println(emp1salRec);
			break;
		case "10002":
			System.out.println(emp2salRec);
			break;
		case "10003":
			System.out.println(emp3salRec);
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
	
	//Checks and redirects to HoursWorked Class
	public static void dTimeLoc() throws Exception{
		switch (empNo) {
		
		case "10001":
			HoursWorked.main(null);
			break;
		case "10002":
			HoursWorked.main(null);
			break;
		case "10003":
			HoursWorked.main(null);
			break;
		default:
			System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
			profMenu();
			break;
			
		}
		
	}
	
}
	