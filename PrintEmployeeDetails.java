public class PrintEmployeeDetails {
    public void printDetails(EmployeeDetails employee) {
        System.out.println("Employee Number: " + employee.employeeNumber);
        System.out.println("First Name: " + employee.fname);
        System.out.println("Last Name: " + employee.lname);
        System.out.println("Address: " + employee.address);
        System.out.println("Birthday: " + employee.bday);
        System.out.println("Phone Number: " + employee.phoneNumber);
        System.out.println("TIN Number: " + employee.tinNumber);
        System.out.println("SSS Number: " + employee.sssNumber);
        System.out.println("PagIbig Number: " + employee.pagIbigNumber);
        System.out.println("Philhealth Number: " + employee.philHealthNumber);
        System.out.println("Status: " + employee.status);
        System.out.println("Position: " + employee.position);
        System.out.println("Immediate Supervisor: " + employee.immediateSupervisor);
        System.out.println("Basic Salary: " + employee.basicSalary);
        System.out.println("Rice Subsidy: " + employee.riceSubsidy);
        System.out.println("Phone Allowance: " + employee.phoneAllowance);
        System.out.println("Clothing Allowance: " + employee.clothingAllowance);
        System.out.println("Gross Semi-Monthly Rate: " + employee.grossSemiMonthlyRate);
        System.out.println("Hourly Rate: " + employee.hourlyRate);
    }
}
