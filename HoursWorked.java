import java.util.Scanner;

public class HoursWorked {
	
	private PrintNReadTxt printNRead;
	Scanner scan = new Scanner(System.in);
	
	HoursWorked() {
		printNRead = new PrintNReadTxt();
	}
	
	public void displayTimeSheet() {
		printNRead.printRead();
		double[] empHrsWkd = printNRead.getEmpHrsWkd();
		
		System.out.println("Daily Timesheet:");  
		System.out.println("1. 1st Week September 2022");
		System.out.println("2. 2nd Week September 2022");
		System.out.println("3. 3rd Week September 2022");
		System.out.println("4. Exit Timesheet");
        
		int dTchoice = scan.nextInt();
		
		switch (dTchoice) {
		case 1:
			System.out.println("1st Week September 2022 Daily Timesheet:");
			System.out.println();
			
			for (int i = 0; i < 5; i++) {
				System.out.println("September " + (i + 5) + ": " + (empHrsWkd[(i * 25) + 50]) + " hrs");
			}
			
			System.out.println("--------------------------------------------");
			
			System.out.println("Total Hours Worked: " + calculateWeeklyHoursWorked(1) + " hrs");
			System.out.println();
			System.out.println("1. Back");
				
			int dTimeBack = scan.nextInt();
			if (dTimeBack == 1) {
				displayTimeSheet();
			}
			break;
		case 2:
			System.out.println("2nd Week September 2022 Daily Timesheet:");
			System.out.println();
			
			for (int i = 0; i < 5; i++) {
				System.out.println("September " + (i + 12) + ": " + (empHrsWkd[i * 25 + 175]) + " hrs");
			}
			
			System.out.println("--------------------------------------------");
			
			System.out.println("Total Hours Worked: " + calculateWeeklyHoursWorked(2) + " hrs");
			System.out.println();
			System.out.println("1. Back");
				
			dTimeBack = scan.nextInt();
			if (dTimeBack == 1) {
				displayTimeSheet();
			}
			break;
		case 3:
			System.out.println("3rd Week September 2022 Daily Timesheet:");
			System.out.println();
			
			for (int i = 0; i < 5; i++) {
				System.out.println("September " + (i + 19) + ": " + (empHrsWkd[i * 25 + 300]) + " hrs");
			}
			
			System.out.println("--------------------------------------------");
			
			System.out.println("Total Hours Worked: " + calculateWeeklyHoursWorked(3) + " hrs");
			System.out.println();
			System.out.println("1. Back");
				
			dTimeBack = scan.nextInt();
			if (dTimeBack == 1) {
				displayTimeSheet();
			}
			break;
		case 4:
			PayrollSystem payroll = new PayrollSystem();
			payroll.profileMenu();
			break;
		}
	}

    private double calculateWeeklyHoursWorked(int week) {
    	printNRead.printRead();
		double[] empHrsWkd = printNRead.getEmpHrsWkd();
		
        double sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += empHrsWkd[i * 25 + (((week - 1) * 125) + 50)];
			}
        return sum;
    }
}
