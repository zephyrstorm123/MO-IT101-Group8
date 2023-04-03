
import java.util.Scanner;

public class PayrollSystem {

	
	private Employee employee;
	private HoursWorked hoursWorked;
	private PrintNReadTxt printNRead;
	private Payslip payslip;
	
	Scanner scan = new Scanner(System.in);
	
	public PayrollSystem() { // Constructor
		
		
		employee = new Employee();
		hoursWorked = new HoursWorked();
		printNRead = new PrintNReadTxt();
		payslip = new Payslip();
		
	}
	

	
	public void callMainMenu() {
		UserLogin userLogin = new UserLogin();
		printNRead.printRead();
		userLogin.insertData();
		if (userLogin.loggedIn) {
		mainMenu();
		}
	}
    
    
    public void mainMenu() {
    	 System.out.println("Payroll Application Menu");
         System.out.println();
         System.out.println("1. My Employee Profile");
         System.out.println("2. Employee Master");
         System.out.println("3. Log Out");
         
         String mmo = scan.next();
         
         switch (mmo) {
         case "1":
        	 profileMenu();
        	 break;
         case "2":
        	 System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
             mainMenu();
        	 break;
         case "3":
        	 callMainMenu();
        	 break;
         default:
        	 System.out.println("Wrong Input. Please Try Again.");
        	 mainMenu();
        	 break;
         }
        	 
         
    }
    
    public void profileMenu() {
    	System.out.println("My Profile Menu:");
    	System.out.println();
    	System.out.println("1. Personal Information");
    	System.out.println("2. Salary Information");
    	System.out.println("3. Daily Timesheet");
    	System.out.println("4. Payslip");
    	System.out.println("5. Back");
    	
    	String pmo = scan.next();
    	
    	switch (pmo) {
    	case "1":
    		employee.printPersonalInfo();
    		break;
    	case "2":
    		employee.printSalaryRecords();
    		break;
    	case "3":
    		hoursWorked.displayTimeSheet();
    		break;
    	case "4":
            payslip.displayPayslipMenu();
    		break;
    	case "5":
    		mainMenu();
    		
    		
    	}
    }
}
