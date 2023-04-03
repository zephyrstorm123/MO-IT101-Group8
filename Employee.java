

public class Employee {

	private String employeeInfo = "Employee No.: 10001\r\n"
			+ "Last Name: Crisostomo\r\n"
			+ "First Name: Jose\r\n"
			+ "Birthday: February 14, 1988\r\n"
			+ "Address: 17/85 Stracke Via\r\n"
			+ "Phone Number: 918-621-603\r\n"
			+ "SSS #: 49-1632020-8\r\n"
			+ "PhilHealth #: 38-218945314-5\r\n"
			+ "TIN #: 317-674-022-000\r\n"
			+ "Pag-ibig #: 4410-9336-9646";
	
	private String employeeSalary = "Employee No: 10001\r\n"
			+ "Employee Status: Regular\r\n"
			+ "Employee Position: HR Manager\r\n"
			+ "Salary Class: Rank and File\r\n"
			+ "Basic Salary: PHP 62,670.00\r\n"
			+ "Rice Subsidy: PHP 1,500.00\r\n"
			+ "Phone Allowance: PHP 1,000.00\r\n"
			+ "Clothing Allowance: PHP 1,000.00";
	
	public void printPersonalInfo() {
		System.out.println("Personal Information:");
		
		for (int i = 0; i < 50; i++) {
				System.out.print("=");}
		
		System.out.println();
		System.out.println(employeeInfo);
		
		for (int i = 0; i < 50; i++) {
			System.out.print("=");}
		
		
	}
	
	public void printSalaryRecords() {
		System.out.println("Salary Information:");
		
		for (int i = 0; i < 50; i++) {
			System.out.print("=");}
		
		System.out.println();
		System.out.println(employeeSalary);
		
		for (int i = 0; i < 50; i++) {
			System.out.print("=");}
	}
		
	
}
