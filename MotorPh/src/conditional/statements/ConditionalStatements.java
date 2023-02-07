package conditional.statements; 
import java.util.Scanner;
public class ConditionalStatements {
    public static void main(String[] args) {
        try (// TODO Auto-generated method stub
        Scanner inp = new Scanner ( System.in)) {
            long empNum;
            String empName;
            String birthday = null;
            double hrate;
            double WeeklyTime;
            
System.out.printf( "Enter Employee Number: ");
empNum = inp.nextLong();
System.out.printf("Enter Hourly rate:  ");
hrate =inp.nextDouble();
System.out.printf("Enter Hours Worked in a Week: ");
WeeklyTime = inp.nextDouble();
if(empNum == 10001) {
empName = "Jose Crisostomo";
birthday = "February 14, 1988";
}
else if (empNum==10002) {
empName = "Christian Mata";
birthday = "October 21, 1987";
}
else if (empNum==10003) {
empName = "Brad  San Jose";
birthday = "March 15, 1996";
}
else {empName = "No Employee Found";
}
System.out.println("-------------------");
System.out.println("---PAYROLL SYSTEM---");
System.out.printf("Employee Number: %d\n", empNum);
System.out.println("Employee Name: "+empName);
System.out.println("Birthday: "+birthday);
System.out.println("Hourly Salary: Php "+hrate);
System.out.println("Hours worked in a week: "+WeeklyTime+" hours");
System.out.println("Gross Wage: Php "+hrate*WeeklyTime);
        }
    }
}