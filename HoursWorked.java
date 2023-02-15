package com.motorph.payrollsystem;



/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;


public class HoursWorked {
	
	static Scanner scan = new Scanner(System.in);
	
	
			//Week 1: Sept. 5-9 (Friday Cut-off)
		static double[] emp1w1TI = {8,8,8,8,8};
		static double[] emp1w1TO = {17,20,20,23,17};
		static double[] emp2w1TI = {7,7,9,8,8};
		static double[] emp2w1TO = {17,17,17,17,17};
		
			//Week 2: Sept. 12-16
		static double[] emp1w2TI = {8,8,8,9,10};
		static double[] emp1w2TO = {17,18,17,17,17};
			
			//Week 1 Calculation	
		static double emp1HrsMday1 = emp1w1TO[0] - emp1w1TI[0];
		static double emp1HrsTUday1 = emp1w1TO[1] - emp1w1TI[1];
		static double emp1HrsWday1 = emp1w1TO[2] - emp1w1TI[2];
		static double emp1HrsTHday1 = emp1w1TO[3] - emp1w1TI[3];
		static double emp1HrsFday1 = emp1w1TO[4] - emp1w1TI[4];
			
		static double emp1HrsTtl = emp1HrsMday1 + emp1HrsTUday1 + emp1HrsWday1 + emp1HrsTHday1 + emp1HrsFday1;

		static double emp2HrsMday1 = emp2w1TO[0] - emp2w1TI[0];
		static double emp2HrsTUday1 = emp2w1TO[1] - emp2w1TI[1];
		static double emp2HrsWday1 = emp2w1TO[2] - emp2w1TI[2];
		static double emp2HrsTHday1 = emp2w1TO[3] - emp2w1TI[3];
		static double emp2HrsFday1 = emp2w1TO[4] - emp2w1TI[4];
			
		static double emp2HrsTtl1 = emp2HrsMday1 + emp2HrsTUday1 + emp2HrsWday1 + emp2HrsTHday1 + emp2HrsFday1;	
		
		    //Week 1 Overtime Calculation
		static double emp1Mday1OT = emp1HrsMday1 - 9;
		static double emp1TUday1OT = emp1HrsTUday1 - 9;
		static double emp1Wday1OT = emp1HrsWday1 - 9;
		static double emp1THday1OT = emp1HrsTHday1 - 9;
		static double emp1Fday1OT = emp1HrsFday1 - 9;
		
		static double emp1OtTtl1 = emp1Mday1OT + emp1TUday1OT + emp1Wday1OT + emp1THday1OT + emp1Fday1OT;

			//Week 2 Calculation
			
		static double emp1HrsMday2 = emp1w2TO[0] - emp1w2TI[0];
		static double emp1HrsTUday2 = emp1w2TO[1] - emp1w2TI[1];
		static double emp1HrsWday2 = emp1w2TO[2] - emp1w2TI[2];
		static double emp1HrsTHday2 = emp1w2TO[3] - emp1w2TI[3];
		static double emp1HrsFday2 = emp1w2TO[4] - emp1w2TI[4];
			
		static double emp1HrsTtl2 = emp1HrsMday2 + emp1HrsTUday2 + emp1HrsWday2 + emp1HrsTHday2 + emp1HrsFday2;

		static double[] empHrsWkd = new double[2150];
		
		
	//Daily timesheet screen
	public static void main(String[] args) throws Exception {
		System.out.println("Daily Timesheet:");
		
		FileReader file = new FileReader("HrsWkd.txt");
        Scanner inFile = new Scanner(file);


        // Read till end of file
        int i = 0;
        while (inFile.hasNext())
        {

        	empHrsWkd[i] = inFile.nextDouble();

            i++;
        }

        inFile.close();

		
		
		dTime();
	}
	
	//Daily Timesheet menu
	public static void dTime() throws Exception{
			
			System.out.println("1. 1st Week September 2022");
			System.out.println("2. 2nd Week September 2022");
			System.out.println("3. 3rd Week September 2022");
			System.out.println("4. Exit Timesheet");
		
			
		int dTchoice = scan.nextInt();
		
		switch (PayrollSystem.empNo) {
		
		case "10001":
			switch (dTchoice) {
			case 1:
				System.out.println("1st Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 5: " + (empHrsWkd[50]) + " hrs");
				System.out.println("September 6: " + (empHrsWkd[75]) + " hrs");
				System.out.println("September 7: " + (empHrsWkd[100]) + " hrs");
				System.out.println("September 8: " + (empHrsWkd[125]) + " hrs");
				System.out.println("September 9: " + (empHrsWkd[150]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[50] + empHrsWkd[75] + empHrsWkd[100] + empHrsWkd[125] + empHrsWkd[150]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			
				break;
			case 2:
				System.out.println("2nd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 12: " + (empHrsWkd[175]) + " hrs");
				System.out.println("September 13: " + (empHrsWkd[200]) + " hrs");
				System.out.println("September 14: " + (empHrsWkd[225]) + " hrs");
				System.out.println("September 15: " + (empHrsWkd[250]) + " hrs");
				System.out.println("September 16: " + (empHrsWkd[275]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[175] + empHrsWkd[200] + empHrsWkd[225] + empHrsWkd[250] + empHrsWkd[275]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
			case 3:
				System.out.println("3rd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 19: " + (empHrsWkd[300]) + " hrs");
				System.out.println("September 20: " + (empHrsWkd[325]) + " hrs");
				System.out.println("September 21: " + (empHrsWkd[350]) + " hrs");
				System.out.println("September 22: " + (empHrsWkd[375]) + " hrs");
				System.out.println("September 23: " + (empHrsWkd[400]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[300] + empHrsWkd[325] + empHrsWkd[350] + empHrsWkd[375] + empHrsWkd[400]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
				
			case 4:
				PayrollSystem.profMenu();
				break;
			default:
				System.out.println("Wrong Input or Option Currently Unavailable.");
				dTime();
				break;
			}
		case "10002":
			switch (dTchoice) {
			case 1:
				System.out.println("1st Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 5: " + (empHrsWkd[50+1]) + " hrs");
				System.out.println("September 6: " + (empHrsWkd[75+1]) + " hrs");
				System.out.println("September 7: " + (empHrsWkd[100+1]) + " hrs");
				System.out.println("September 8: " + (empHrsWkd[125+1]) + " hrs");
				System.out.println("September 9: " + (empHrsWkd[150+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[50+1] + empHrsWkd[75+1] + empHrsWkd[100+1] + empHrsWkd[125+1] + empHrsWkd[150+1]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			case 2:
				System.out.println("2nd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 12: " + (empHrsWkd[175+1]) + " hrs");
				System.out.println("September 13: " + (empHrsWkd[200+1]) + " hrs");
				System.out.println("September 14: " + (empHrsWkd[225+1]) + " hrs");
				System.out.println("September 15: " + (empHrsWkd[250+1]) + " hrs");
				System.out.println("September 16: " + (empHrsWkd[275+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[175+1] + empHrsWkd[200+1] + empHrsWkd[225+1] + empHrsWkd[250+1] + empHrsWkd[275+1]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
			case 3:
				System.out.println("3rd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 19: " + (empHrsWkd[300+1]) + " hrs");
				System.out.println("September 20: " + (empHrsWkd[325+1]) + " hrs");
				System.out.println("September 21: " + (empHrsWkd[350+1]) + " hrs");
				System.out.println("September 22: " + (empHrsWkd[375+1]) + " hrs");
				System.out.println("September 23: " + (empHrsWkd[400+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[300+1] + empHrsWkd[325+1] + empHrsWkd[350+1] + empHrsWkd[375+1] + empHrsWkd[400+1]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
			case 4:
				PayrollSystem.profMenu();
				break;
			default:
				System.out.println("Wrong Input or Option Currently Unavailable.");
				dTime();
				break;	
			}
			break;
		case "10003":
			switch (dTchoice) {
			case 1:
				System.out.println("1st Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 5: " + (empHrsWkd[50+2]) + " hrs");
				System.out.println("September 6: " + (empHrsWkd[75+2]) + " hrs");
				System.out.println("September 7: " + (empHrsWkd[100+2]) + " hrs");
				System.out.println("September 8: " + (empHrsWkd[125+2]) + " hrs");
				System.out.println("September 9: " + (empHrsWkd[150+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[50+2] + empHrsWkd[75+2] + empHrsWkd[100+2] + empHrsWkd[125+2] + empHrsWkd[150+2]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			case 2:
				System.out.println("2nd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 12: " + (empHrsWkd[175+2]) + " hrs");
				System.out.println("September 13: " + (empHrsWkd[200+2]) + " hrs");
				System.out.println("September 14: " + (empHrsWkd[225+2]) + " hrs");
				System.out.println("September 15: " + (empHrsWkd[250+2]) + " hrs");
				System.out.println("September 16: " + (empHrsWkd[275+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[175+2] + empHrsWkd[200+2] + empHrsWkd[225+2] + empHrsWkd[250+2] + empHrsWkd[275+2]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
			case 3:
				System.out.println("3rd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 19: " + (empHrsWkd[300+2]) + " hrs");
				System.out.println("September 20: " + (empHrsWkd[325+2]) + " hrs");
				System.out.println("September 21: " + (empHrsWkd[350+2]) + " hrs");
				System.out.println("September 22: " + (empHrsWkd[375+2]) + " hrs");
				System.out.println("September 23: " + (empHrsWkd[400+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (empHrsWkd[300+2] + empHrsWkd[325+2] + empHrsWkd[350+2] + empHrsWkd[375+2] + empHrsWkd[400+2]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
				break;
			case 4:
				PayrollSystem.profMenu();
				break;
			default:
				System.out.println("Wrong Input or Option Currently Unavailable.");
				dTime();
				break;	
			}
			break;
		}
	}
	
}
	