import java.util.Scanner;

public class Login {
    public void Login(EmployeeDetails employeeDetails) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + employeeDetails.fname.trim() + " " + employeeDetails.lname.trim());

        EmployeeActions();

        int choice = 0;

        PrintEmployeeDetails employee = new PrintEmployeeDetails();

        int empNumber = Integer.parseInt(employeeDetails.employeeNumber);
        int basicSalary = Integer.parseInt(employeeDetails.basicSalary);
        double empHourlyRate = Double.parseDouble(employeeDetails.hourlyRate);
        int riceSubsidy = Integer.parseInt(employeeDetails.riceSubsidy);
        int phoneAllowance = Integer.parseInt(employeeDetails.phoneAllowance);
        int clothingAllowance = Integer.parseInt(employeeDetails.clothingAllowance);

        // Gets the details of employee time
        int[] employeeTime = TimeHolder.EmployeeHours(empNumber);

        // Initialize all the basic outputs of the employee
        int totalWorkedHoursOfWorker = TotalWorkHours.WorkHours(employeeTime);
        int calculatedGrossSalary = CalculatedGrossSalary.CalculateGrossSalary(basicSalary, riceSubsidy, phoneAllowance,
                clothingAllowance);

        while (choice != 5) {
            choice = sc.nextInt();

            switch (choice) {
                case (1):

                    System.out.println("\n");
                    System.out.println("===================================================================");
                    System.out.println("Printing Employee Details" + "\n");

                    employee.printDetails(employeeDetails);

                    EmployeeActions();
                    choice = 0;
                    break;

                case (2):

                    System.out.println("\n");
                    System.out.println("===================================================================");
                    System.out.println("Your total work hours this week is: " + totalWorkedHoursOfWorker + " hours");

                    EmployeeActions();
                    choice = 0;

                    break;
                case (3):

                    System.out.println("\n");
                    System.out.println("===================================================================");
                    System.out.println("You have earned " + calculatedGrossSalary + " this week");
                    System.out.println("Basic Salary: " + basicSalary);
                    System.out.println("Rice Subsidy: " + riceSubsidy);
                    System.out.println("Phone Allowance: " + phoneAllowance);
                    System.out.println("Clothing Allowance: " + clothingAllowance);

                    EmployeeActions();
                    choice = 0;

                    break;
                case (4):
                    System.out.println("\n");
                    System.out.println("===================================================================");
                    double Philhealth = CalculatePhilhealth.Philhealth(basicSalary);
                    double SSS = CalculateSSS.SSS(basicSalary);
                    double PagIbig = CalculatePagIbig.PagIbig(basicSalary);

                    double WitholdingTax = CalculateWitholdingTax.WitholdingTax(basicSalary, Philhealth, SSS, PagIbig);

                    double calculatedNetSalary = calculatedGrossSalary - (Philhealth + SSS + PagIbig + WitholdingTax);

                    System.out.println("Your Philhealth contribution is: P" + Philhealth);
                    System.out.println("Your SSS contribution is: P" + SSS);
                    System.out.println("Your Pag-Ibig contribution is: P" + PagIbig);
                    System.out.println("Your Witholding Tax is: P" + WitholdingTax + "\n");
                    System.out.println("Your Net Salary is: P" + calculatedNetSalary + "\n");

                    EmployeeActions();
                    choice = 0;

                    break;
                case (5):
                    System.exit(0);

                default:
                    System.out.println("Invalid Action, Input a Valid Number");
            }
        }

    }

    public static void EmployeeActions() {
        System.out.println("===================================================================" + "\n");
        System.out.println("1. Employee Details");
        System.out.println("2. Calculate Work Hours");
        System.out.println("3. Calculate Gross Pay");
        System.out.println("4. Calculate Net Pay");
        System.out.println("5. Exit" + "\n");
        System.out.println("===================================================================");
    }

}
