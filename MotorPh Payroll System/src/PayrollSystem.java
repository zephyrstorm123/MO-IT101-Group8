import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Employee{
	String name, Birthday;
	double EmpNum;
	public void read() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your employee number>>>");
		EmpNum = scan.nextDouble();
				
		if(EmpNum == 10001) {
		name = "Jose Crisostomo";
		Birthday = "February 14, 1988";
		}
		else if (EmpNum==10002) {
		name = "Christian Mata";
		Birthday = "October 21, 1987";
		}
		else if (EmpNum==10003) {
		name = "Brad  San Jose";
		Birthday = "March 15, 1996";
		}
		else {name = "No Employee Found";
		
		}
	}
	public void show() {System.out.printf("Employee Number: %d\n", EmpNum);
	System.out.println("Employee Name: "+name);
	System.out.println("Birthday: "+Birthday);}
}

class EmPay extends Employee {
	double Hrate;
	double Weekly;
	double BasicSal;
	String timein;
	String timeout;
	
	public void read() throws ParseException {
		super.read();
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy hh:mm");
		Date d1 = sdf.parse (timein);
		Date d2 = sdf.parse (timeout);
		System.out.println("Please enter your daily time-in>>>");
		System.out.println("Please enter your daily time-out>>>");
		System.out.println("Please enter your hourly rate>>>");
		System.out.println("Please enter the number of days you worked in a week>>>");
			timein = scan.next();
			timeout = scan.next();
			Hrate = scan.nextDouble();
			 Weekly = scan.nextDouble();
			long diff = d2.getTime() - d1.getTime();
		super.show();
		System.out.println("Hourly Rate: " + diff/(1000.0*60*60)*Hrate+ " Pesos");
		System.out.println("Hours Worked: " + diff/(1000.0*60*60)*Weekly+ "Pesos");
}
class EmpSalary extends EmPay{
	double SSS,PHealth,PagIbig,Witholding,gross,net;
	public void compute() {
	 gross = BasicSal*4;
	 
}
public class PayrollSystem {

	    public static void main(String[] args){
	      
	}
}}}

