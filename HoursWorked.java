package com.motorph.payrollsystem;



/**
 *
 * @author Michael
 */

import java.util.*;



public class HoursWorked {
	
	static Scanner scan = new Scanner(System.in);
	
	
			//Week 1: Sept. 5-9 (Friday Cut-off)

		static double[] emp2w1TI = {7,7,9,8,8};
		static double[] emp2w1TO = {17,17,17,17,17};
		
			//Week 2: Sept. 12-16
		static double[] emp1w2TI = {8,8,8,9,10};
		static double[] emp1w2TO = {17,18,17,17,17};
			
		static double emp2HrsMday1 = emp2w1TO[0] - emp2w1TI[0];
		static double emp2HrsTUday1 = emp2w1TO[1] - emp2w1TI[1];
		static double emp2HrsWday1 = emp2w1TO[2] - emp2w1TI[2];
		static double emp2HrsTHday1 = emp2w1TO[3] - emp2w1TI[3];
		static double emp2HrsFday1 = emp2w1TO[4] - emp2w1TI[4];
			
		static double emp2HrsTtl1 = emp2HrsMday1 + emp2HrsTUday1 + emp2HrsWday1 + emp2HrsTHday1 + emp2HrsFday1;	
		
		    //Week 1 Overtime Calculation
		static double emp1Mday1OT = PrintnRead.empHrsWkd[50] - 8;
		static double emp1TUday1OT = PrintnRead.empHrsWkd[75] - 8;
		static double emp1Wday1OT = PrintnRead.empHrsWkd[100] - 8;
		static double emp1THday1OT = PrintnRead.empHrsWkd[125] - 8;
		static double emp1Fday1OT = PrintnRead.empHrsWkd[150] - 8;
		
		static double emp1OtTtl1 = emp1Mday1OT + emp1TUday1OT + emp1Wday1OT + emp1THday1OT + emp1Fday1OT;

			//Week 2 Calculation
			
		static double emp1HrsMday2 = emp1w2TO[0] - emp1w2TI[0];
		static double emp1HrsTUday2 = emp1w2TO[1] - emp1w2TI[1];
		static double emp1HrsWday2 = emp1w2TO[2] - emp1w2TI[2];
		static double emp1HrsTHday2 = emp1w2TO[3] - emp1w2TI[3];
		static double emp1HrsFday2 = emp1w2TO[4] - emp1w2TI[4];
			
		static double emp1HrsTtl2 = emp1HrsMday2 + emp1HrsTUday2 + emp1HrsWday2 + emp1HrsTHday2 + emp1HrsFday2;
	
	
	//Daily Timesheet menu
	public static void dTime() throws Exception{
		
			System.out.println("Daily Timesheet:");  
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
				System.out.println("September 5: " + (PrintnRead.empHrsWkd[50]) + " hrs");
				System.out.println("September 6: " + (PrintnRead.empHrsWkd[75]) + " hrs");
				System.out.println("September 7: " + (PrintnRead.empHrsWkd[100]) + " hrs");
				System.out.println("September 8: " + (PrintnRead.empHrsWkd[125]) + " hrs");
				System.out.println("September 9: " + (PrintnRead.empHrsWkd[150]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[50] + PrintnRead.empHrsWkd[75] + PrintnRead.empHrsWkd[100] + PrintnRead.empHrsWkd[125] + PrintnRead.empHrsWkd[150]) + " hrs");
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
				System.out.println("September 12: " + (PrintnRead.empHrsWkd[175]) + " hrs");
				System.out.println("September 13: " + (PrintnRead.empHrsWkd[200]) + " hrs");
				System.out.println("September 14: " + (PrintnRead.empHrsWkd[225]) + " hrs");
				System.out.println("September 15: " + (PrintnRead.empHrsWkd[250]) + " hrs");
				System.out.println("September 16: " + (PrintnRead.empHrsWkd[275]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[175] + PrintnRead.empHrsWkd[200] + PrintnRead.empHrsWkd[225] + PrintnRead.empHrsWkd[250] + PrintnRead.empHrsWkd[275]) + " hrs");
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
				System.out.println("September 19: " + (PrintnRead.empHrsWkd[300]) + " hrs");
				System.out.println("September 20: " + (PrintnRead.empHrsWkd[325]) + " hrs");
				System.out.println("September 21: " + (PrintnRead.empHrsWkd[350]) + " hrs");
				System.out.println("September 22: " + (PrintnRead.empHrsWkd[375]) + " hrs");
				System.out.println("September 23: " + (PrintnRead.empHrsWkd[400]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[300] + PrintnRead.empHrsWkd[325] + PrintnRead.empHrsWkd[350] + PrintnRead.empHrsWkd[375] + PrintnRead.empHrsWkd[400]) + " hrs");
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
				System.out.println("September 5: " + (PrintnRead.empHrsWkd[50+1]) + " hrs");
				System.out.println("September 6: " + (PrintnRead.empHrsWkd[75+1]) + " hrs");
				System.out.println("September 7: " + (PrintnRead.empHrsWkd[100+1]) + " hrs");
				System.out.println("September 8: " + (PrintnRead.empHrsWkd[125+1]) + " hrs");
				System.out.println("September 9: " + (PrintnRead.empHrsWkd[150+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[50+1] + PrintnRead.empHrsWkd[75+1] + PrintnRead.empHrsWkd[100+1] + PrintnRead.empHrsWkd[125+1] + PrintnRead.empHrsWkd[150+1]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			case 2:
				System.out.println("2nd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 12: " + (PrintnRead.empHrsWkd[175+1]) + " hrs");
				System.out.println("September 13: " + (PrintnRead.empHrsWkd[200+1]) + " hrs");
				System.out.println("September 14: " + (PrintnRead.empHrsWkd[225+1]) + " hrs");
				System.out.println("September 15: " + (PrintnRead.empHrsWkd[250+1]) + " hrs");
				System.out.println("September 16: " + (PrintnRead.empHrsWkd[275+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[175+1] + PrintnRead.empHrsWkd[200+1] + PrintnRead.empHrsWkd[225+1] + PrintnRead.empHrsWkd[250+1] + PrintnRead.empHrsWkd[275+1]) + " hrs");
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
				System.out.println("September 19: " + (PrintnRead.empHrsWkd[300+1]) + " hrs");
				System.out.println("September 20: " + (PrintnRead.empHrsWkd[325+1]) + " hrs");
				System.out.println("September 21: " + (PrintnRead.empHrsWkd[350+1]) + " hrs");
				System.out.println("September 22: " + (PrintnRead.empHrsWkd[375+1]) + " hrs");
				System.out.println("September 23: " + (PrintnRead.empHrsWkd[400+1]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[300+1] + PrintnRead.empHrsWkd[325+1] + PrintnRead.empHrsWkd[350+1] + PrintnRead.empHrsWkd[375+1] + PrintnRead.empHrsWkd[400+1]) + " hrs");
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
				System.out.println("September 5: " + (PrintnRead.empHrsWkd[50+2]) + " hrs");
				System.out.println("September 6: " + (PrintnRead.empHrsWkd[75+2]) + " hrs");
				System.out.println("September 7: " + (PrintnRead.empHrsWkd[100+2]) + " hrs");
				System.out.println("September 8: " + (PrintnRead.empHrsWkd[125+2]) + " hrs");
				System.out.println("September 9: " + (PrintnRead.empHrsWkd[150+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[50+2] + PrintnRead.empHrsWkd[75+2] + PrintnRead.empHrsWkd[100+2] + PrintnRead.empHrsWkd[125+2] + PrintnRead.empHrsWkd[150+2]) + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			case 2:
				System.out.println("2nd Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("September 12: " + (PrintnRead.empHrsWkd[175+2]) + " hrs");
				System.out.println("September 13: " + (PrintnRead.empHrsWkd[200+2]) + " hrs");
				System.out.println("September 14: " + (PrintnRead.empHrsWkd[225+2]) + " hrs");
				System.out.println("September 15: " + (PrintnRead.empHrsWkd[250+2]) + " hrs");
				System.out.println("September 16: " + (PrintnRead.empHrsWkd[275+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[175+2] + PrintnRead.empHrsWkd[200+2] + PrintnRead.empHrsWkd[225+2] + PrintnRead.empHrsWkd[250+2] + PrintnRead.empHrsWkd[275+2]) + " hrs");
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
				System.out.println("September 19: " + (PrintnRead.empHrsWkd[300+2]) + " hrs");
				System.out.println("September 20: " + (PrintnRead.empHrsWkd[325+2]) + " hrs");
				System.out.println("September 21: " + (PrintnRead.empHrsWkd[350+2]) + " hrs");
				System.out.println("September 22: " + (PrintnRead.empHrsWkd[375+2]) + " hrs");
				System.out.println("September 23: " + (PrintnRead.empHrsWkd[400+2]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + (PrintnRead.empHrsWkd[300+2] + PrintnRead.empHrsWkd[325+2] + PrintnRead.empHrsWkd[350+2] + PrintnRead.empHrsWkd[375+2] + PrintnRead.empHrsWkd[400+2]) + " hrs");
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
	