/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.payrollmotorph;

/**
 *
 * @author Oem user
 */
import java.util.Scanner;

public class PayrollMotorPh {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to MotorPh");
        System.out.println("                                                     ");
        
        System.out.println("-----------------------------------------------------");
        System.out.println(" >> Please Login << ");
        System.out.println("-----------------------------------------------------");
        
            
             // Login credentials
        String username = "user";
        String password = "pass123";

        // Loop until reached correct login credentials
        while (true) {

            // Prompt user to enter username and password
            System.out.print("Enter username: ");
                String inputEmpname = scanner.nextLine();

            System.out.print("Enter password: ");
                String inputPassword = scanner.nextLine();

            // Check if credentials match
            if (inputEmpname.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login successful");

                // Loop through menu options until user chooses to exit
                while (true) {
                    System.out.println("Tab Menu Options:");
                    System.out.println("(1) Inventory Tab ");
                    System.out.println("(2) Employee's Profile Tab");
                    System.out.println("(3) PaySlip Tab");
                    System.out.println("(4) Exit");

                    System.out.print("Enter Tab option: ");
                        int option = scanner.nextInt();
                        scanner.nextLine(); // consume newline character

                    // Execute selected option
                    switch (option) {
                        case 1:
                            System.out.println("Inventory Tab selected (not yet available)");
                            break;
                        case 2:
                            System.out.println("Employee's Profile Tab selected");
                            break;
                        case 3:
                            System.out.println("PaySlip Tab selected");
                            break;
                        case 4:
                            System.out.println("Exiting program...");
                            System.exit(0);
                        default:
                            System.out.println("Invalid option");
                            break;
                                }
                             }
                         } else {
                            System.out.println("Invalid login credentials");
                        }
                            
                
                System.out.println("-----------------------------------------------------");
                System.out.println(" >> EMPLOYEE'S PROFILE << ");
                System.out.println("-----------------------------------------------------");
        
               
                    System.out.println ("Enter Employee #: ");
                    int [] EmpNums = {10001, 10002, 10003, 10004};
                    int EmpNum = scanner.nextInt();
        
                     
                    String EmpLName = "Employee's Last Name: ";
                    String EmpFName = "Enter Employee First Name: ";
                    String EmpBday = "Birthday: ";
                    String EmpAdd = "Address: ";
                    String EmpPN = "Phone Number: ";
                    String EmpSSS = "SSS #: ";
                    String EmpPhlth = "PhilHealth #: ";
                    String EmpTIN = "TIN #: ";
                    String EmpPbg = "Pag-ibig #: ";
                    String EmpStat = "Status ";
                    String EmpPsn = "Position: ";
                    String EmpIS = "Immediate Supervisor ";
                    String EmpBSal = "Basic Salary: ";
                    String EmpRS = "Rice Subsidy: ";
                    String EmpPhnAl = "Phone Allowance: ";
                    String EmpCAl= "Clothing Allowance: ";
                    String EmpGSR = "Gross Semi-monthly Rate: ";
                    String EmpHR = "Hourly Rate: ";
        
                    System.out.println ("-----------------------------------------------------");
                    System.out.println (">> Details <<");
                    System.out.println ("-----------------------------------------------------");
        
        
                    System.out.println("Employee Number: " + EmpNums [0]);
        
                  
        
                    System.out.println(EmpLName + "Crisostomo");
                    System.out.println(EmpFName + "Jose");
                    System.out.println(EmpBday + "February 14, 1988");
                    System.out.println(EmpAdd + "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands");
                    System.out.println(EmpPN + "918-621-603");
                    System.out.println(EmpSSS + "49-1632020-8");
                    System.out.println(EmpPhlth + "382189453145");
                    System.out.println(EmpTIN + "317-674-022-000");
                    System.out.println(EmpPbg + "441093369646");
                    System.out.println(EmpStat + "Regular");
                    System.out.println(EmpPsn + "HR Manager");
                    System.out.println(EmpIS + "N/A");
                    System.out.println(EmpBSal + "62,670");
                    System.out.println(EmpRS + "1,500");
                    System.out.println(EmpPhnAl + "1,000");
                    System.out.println(EmpCAl + "1,000");
                    System.out.println(EmpGSR + "31,335");
                    System.out.println(EmpHR + "373.04");      
                            
              
        scanner.close();
     
        
        int [] TimeIn = {8,8,8,8};
        int [] TimeOut = {17,17,17,17};
        double basicSalary, RS, PAl, CAl, HR, Week1, weeklyHrs, WeeklyWT, WeeklyPI, WeeklyPH, WeeklySSS, deductions, workedHrs, WeeklyGrossSal, WeeklynetSal;
        basicSalary = 62670;
        
        HR = 373.04;
        RS = 1500;
        PAl = 1000;
        CAl = 1000;
        weeklyHrs = 8;
        Week1 = 5;
        
        WeeklyWT = 4541.88; // computation of Emp10001 for 62,670 | WT: 2500 + 25% = 18,167.50/4 = 4,541.88
        WeeklyPI = 313.35; // PI: 2% of 62,670 = 1,253.40/4 = 313.35
        WeeklyPH = 450.00; // PH: 1800 / 4 = 450
        WeeklySSS = 281.25; // SSS: 1,125 / 4 = 281.25
        
        WeeklyGrossSal = HR * weeklyHrs * Week1;
        deductions = WeeklyWT + WeeklyPI + WeeklyPH + WeeklySSS; 
        WeeklynetSal = WeeklyGrossSal - deductions;
        
        
        System.out.println( "-----------------------------------------------------");
                     
        System.out.println("Employee Weekly Gross: P " + WeeklyGrossSal);
        System.out.println("Deductions: P" + deductions);
        System.out.println("Employee Weekly NetSalary: P "+ WeeklynetSal);
        System.out.println( "=====================================================");
        
        
        
        scanner.close();
     
    }
  }
}
user
        