package com.mycompany.exercise1.copy;



/**
 *
 * @author Michael
 */

import java.util.*;

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
	
	public static void main(String[] args) {
		
	}
	
	public static void dTime() {
		
	
			System.out.println("Daily Timesheet:");
			System.out.println("1. 1st Week September 2022");
			System.out.println("2. 2nd Week September 2022");
			System.out.println("3. 3rd Week September 2022");
			System.out.println("4. Exit Timesheet");
		
			
		int dTchoice = scan.nextInt();
		
		switch (PayrollSystem.empNo) {
		
		case 10001:
			switch (dTchoice) {
			case 1:
				System.out.println("1st Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("Monday: " + (emp1w1TO[0] - emp1w1TI[0] - 1) + " hrs");
				System.out.println("Tuesday: " + (emp1w1TO[1] - emp1w1TI[1] - 1) + " hrs");
				System.out.println("Wednesday: " + (emp1w1TO[2] - emp1w1TI[2] - 1) + " hrs");
				System.out.println("Thursday: " + (emp1w1TO[3] - emp1w1TI[3] - 1) + " hrs");
				System.out.println("Friday: " + (emp1w1TO[4] - emp1w1TI[4] - 1) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + emp1HrsTtl + " hrs");
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
				System.out.println("Monday: " + (emp1w2TO[0] - emp1w2TI[0]) + " hrs");
				System.out.println("Tuesday: " + (emp1w2TO[1] - emp1w2TI[1]) + " hrs");
				System.out.println("Wednesday: " + (emp1w2TO[2] - emp1w2TI[2]) + " hrs");
				System.out.println("Thursday: " + (emp1w2TO[3] - emp1w2TI[3]) + " hrs");
				System.out.println("Friday: " + (emp1w2TO[4] - emp1w2TI[4]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + emp1HrsTtl2 + " hrs");
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
		case 10002:
			switch (dTchoice) {
			case 1:
				System.out.println("1st Week September 2022 Daily Timesheet:");
				System.out.println();
				System.out.println("Monday: " + (emp2w1TO[0] - emp2w1TI[0]) + " hrs");
				System.out.println("Tuesday: " + (emp2w1TO[1] - emp2w1TI[1]) + " hrs");
				System.out.println("Wednesday: " + (emp2w1TO[2] - emp2w1TI[2]) + " hrs");
				System.out.println("Thursday: " + (emp2w1TO[3] - emp2w1TI[3]) + " hrs");
				System.out.println("Friday: " + (emp2w1TO[4] - emp2w1TI[4]) + " hrs");
				System.out.println("--------------------------------------------");
				System.out.println("Total Hours Worked: " + emp2HrsTtl1 + " hrs");
				System.out.println();
				System.out.println("1. Back");
			
				int dTimeBack = scan.nextInt();
				if (dTimeBack == 1) {
				dTime();
				}
			case 4:
				PayrollSystem.profMenu();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Input or Option Currently Unavailable.");
				dTime();
				break;	
			}
			break;
		}
	}
	
	public static void dTimesheet() {
		
	}
	
}
	