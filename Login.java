import java.util.Scanner;

public class Login {
    public void Login(EmployeeDetails employeeDetails) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + employeeDetails.fname.trim() + " " + employeeDetails.lname.trim());
        System.out.println("===================================================================");
        System.out.println("What would you like to do?");
        System.out.println("1. Employee Details");
        System.out.println("2. Calculate work Hours");
        int choice = sc.nextInt();

        switch (choice) {
            case (1):
                System.out.println("=============================================");
                System.out.println("Printing Employee Details");
                PrintEmployeeDetails employee = new PrintEmployeeDetails();
                employee.printDetails(employeeDetails);
                break;
            case (2):
                System.out.println("hi");
                int empNumber = Integer.parseInt(employeeDetails.employeeNumber);
                TimeHolder time = new TimeHolder();
                int[] employeeTime = time.TimeHolder(empNumber);

                int totalWorkedHoursOfWorker = 0;

                for (int i = 1; i < employeeTime.length; i++) {
                    totalWorkedHoursOfWorker += employeeTime[i];
                }

                System.out.println(totalWorkedHoursOfWorker);

                break;
            default:
                System.out.println("Nope");
        }

    }
}
