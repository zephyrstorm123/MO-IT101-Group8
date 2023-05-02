
import java.util.Scanner;
public class Employee {
public static void main (String []args) {
	
	
String name;
String birthday;
String address;
int employeeNumber;
double phoneNumber;
try (Scanner scan=new Scanner(System.in)) {
	System.out.println("Please enter your employee number>>>");
	employeeNumber = scan.nextInt();
	scan.nextLine();
	System.out.println("Please enter your name>>>");
	name=scan.nextLine();
	
	System.out.println("Please enter your birthday>>>");
	birthday=scan.nextLine();
	
	System.out.println("Please enter your address>>>");
	address=scan.nextLine();
	
	System.out.println("Please enter your phone number>>>");
	phoneNumber=scan.nextDouble();
	scan.close();
}
System.out.println("employee number: "+employeeNumber);
System.out.println("name: "+name);
System.out.println("birthday: "+birthday);
System.out.println("address: "+address);
System.out.println("phone number: "+phoneNumber);

}
}
