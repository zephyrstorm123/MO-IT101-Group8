import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Exercise {

	Scanner scan;
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to MotorPH Payroll System");
        System.out.println();
        System.out.println("Please Enter Employee Number");
        int empNo = scan.nextInt();
        String chk = "Please Enter Password";
        String wrgNum = "Employee Number Not Found";
        
        if (empNo == 10001) {
            System.out.println(chk);
            
            scan.hasNext();
            String pass;
            pass = scan.next();
            String chkPass = "                LOGIN SUCCESSFUL";
                    String wrgPass = "Wrong Password. Please Try Again.";
        
           
            if (pass.equals("Admin1234")) {
            	System.out.println("===================================================");
                System.out.println(chkPass);
             	System.out.println("===================================================");
             	
             	System.out.println();
                System.out.println("Payroll Application Menu");
                System.out.println();
                System.out.println("1. My Employee Profile");
                System.out.println("2. Employee Master");
                System.out.println("3. Timekeeping");
                System.out.println("4. Payroll Register");
                System.out.println("5. System Administration");
                System.out.println("6. Back");
                
                scan.hasNext();
                int mm = scan.nextInt();
                
                if (mm == 1) {
                	System.out.println("Welcome, Jose!");
                	System.out.println();
                	System.out.println("My Profile Menu:");
                	System.out.println();
                	System.out.println("1. Personal Information");
                	System.out.println("2. Salary Information");
                	System.out.println("3. Daily Timesheet");
                	System.out.println("4. Leave and Overtime");
                	System.out.println("5. Payslip");
                	System.out.println("6. Back");
                	
                	scan.hasNext();
                	int pm = scan.nextInt();
                	if (pm == 1) {
                		System.out.println("Personal Information:");
                		System.out.println();
                		System.out.println("===================================================");
                		System.out.println("Employee No.: 10001");
                		System.out.println("Last Name: Crisostomo");
                		System.out.println("First Name: Jose");
                		System.out.println("Birthday: February 14, 1988");
                		System.out.println("Address: 17/85 Stracke Via");
                		System.out.println("Phone Number: 918-621-603");
                		System.out.println("SSS #: 49-1632020-8");
                		System.out.println("PhilHealth #: ");
                		System.out.println("TIN #: ");
                		System.out.println("Pag-ibig #: ");
                		System.out.println("===================================================");
                		System.out.println();
                		System.out.println("1. Back");
                	} else if (pm >= 2 && pm <= 5) {
                		System.out.println("!! Currently Unavailable !!");
                	} else {
                		System.out.println("Wrong Input. Please Try Again.");
                	}
                	
                } else if (mm >= 2 && mm <= 5) {
                	System.out.println("!! Menu Currently Unavailable !!");
                } else {
                	System.out.println("Wrong Input. Please Try Again.");
                }
                
            } else {
                System.out.println(wrgPass);
            }
            
        } else if (empNo == 10002) {
        	System.out.println(chk);
        	scan.hasNext();
            String pass;
            pass = scan.next();
            String chkPass = "                LOGIN SUCCESSFUL";
                    String wrgPass = "Wrong Password. Please Try Again.";
        
           
            if (pass.equals("Empl1234")) {
            	System.out.println("===================================================");
                System.out.println(chkPass);
             	System.out.println("===================================================");
             	
             	System.out.println();
                System.out.println("Payroll Application Menu");
                System.out.println();
                System.out.println("1. My Employee Profile");
                System.out.println("2. Employee Master");
                System.out.println("3. Timekeeping");
                System.out.println("4. Payroll Register");
                System.out.println("5. System Administration");
                System.out.println("6. Back");
                
                scan.hasNext();
                int mm = scan.nextInt();
                
                if (mm == 1) {
                	System.out.println("Welcome, Christian!");
                	System.out.println();
                	System.out.println("My Profile Menu:");
                	System.out.println();
                	System.out.println("1. Personal Information");
                	System.out.println("2. Salary Information");
                	System.out.println("3. Daily Timesheet");
                	System.out.println("4. Leave and Overtime");
                	System.out.println("5. Payslip");
                	System.out.println("6. Back");
                	
                	scan.hasNext();
                	int pm = scan.nextInt();
                	if (pm == 1) {
                		System.out.println("Personal Information:");
                		System.out.println();
                		System.out.println("===================================================");
                		System.out.println("Employee No.: 10002");
                		System.out.println("Last Name: Mata");
                		System.out.println("First Name: Christian");
                		System.out.println("Birthday: October 21, 1987");
                		System.out.println("Address: 90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu");
                		System.out.println("Phone Number: 783-776-744");
                		System.out.println("SSS #: 49-2959312-6");
                		System.out.println("PhilHealth #: 824187961962");
                		System.out.println("TIN #: 103-100-522-000");
                		System.out.println("Pag-ibig #: 218002473454");
                		System.out.println("===================================================");
                		System.out.println();
                		System.out.println("1. Back");
                	} else if (pm >= 2 && pm <= 5) {
                		System.out.println("!! Currently Unavailable !!");
                	} else {
                		System.out.println("Wrong Input. Please Try Again.");
                	}
                	
                } else if (mm >= 2 && mm <= 5) {
                	System.out.println("!! Menu Currently Unavailable !!");
                } else {
                	System.out.println("Wrong Input. Please Try Again.");
                }
                
            } else {
                System.out.println(wrgPass);
            }
            
        } else {
            System.out.println(wrgNum);
            
        }
        
        
        
        
        scan.close();
    }
}

