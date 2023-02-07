import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkedHours{public static void main(String[] args)throws ParseException{
	double Hrate;
	String d1timein, d1timeout, d2timein, d2timeout, d3timein, d3timeout, d4timein, d4timeout,d5timein,d5timeout;
	
	String name, Birthday = null;
	int EmpNum;
	long diff1,diff2,diff3,diff4,diff5, totalHours;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your employee number>>>");
		EmpNum = scan.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

		
		System.out.println("Please enter your hourly rate:");
		Hrate = scan.nextDouble();
		System.out.println("Enter Time-in for Monday(format hh:mm): ");
		d1timein = scan.next();
		System.out.println("Enter Time-out for Monday(format hh:mm):");
		d1timeout = scan.next();

		System.out.println("Enter Time-in for Tuesday(format hh:mm):");
		d2timein = scan.next();
		System.out.println("Enter Time-out for Tuesday(format hh:mm):");
		d2timeout = scan.next();
		
		System.out.println("Enter Time-in for Wednesday(format hh:mm):");
		d3timein = scan.next();
		System.out.println("Enter Time-out for Wednesday(format hh:mm):");
		d3timeout = scan.next();
		
		
		System.out.println("Enter Time-in for Thursday(format hh:mm):");
		d4timein = scan.next();
		System.out.println("Enter Time-out for Thursday(format hh:mm):");
		d4timeout = scan.next();
		
		System.out.println("Enter Time-in for Friday(format hh:mm):");
		d5timein = scan.next();
		System.out.println("Enter Time-out for Thusday(format hh:mm):");
		d5timeout = scan.next();
		 
		 Date d1in = sdf.parse (d1timein);
			Date d1out = sdf.parse (d1timeout);
		 diff1 = d1out.getTime() - d1in.getTime();
		 Date d2in = sdf.parse (d2timein);
			Date d2out = sdf.parse (d2timeout);
		 diff2 = d2out.getTime() - d2in.getTime();
		 Date d3in = sdf.parse (d3timein);
			Date d3out = sdf.parse (d3timeout);
		 diff3 = d3out.getTime() - d3in.getTime();
		 Date d4in = sdf.parse (d4timein);
			Date d4out = sdf.parse (d4timeout);
		 diff4 = d4out.getTime() - d4in.getTime();
		 Date d5in = sdf.parse (d5timein);
			Date d5out = sdf.parse (d5timeout);
		 diff5 = d5out.getTime() - d5in.getTime();
		 
		 
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
				else if (EmpNum==10004) {
					name = "Anthony  Salcedo";
					Birthday = "September 14, 1993";}
				else if (EmpNum==10005) {
					name = "Alice Romualdez";
					Birthday = "May 14, 1992";}
				else if (EmpNum==10006) {
					name = "Rosie Atienza";}
		 
					else if (EmpNum==10007) {
						name = "Martha Farala";
					Birthday = "January 11, 1942";}
		 
				else {name = "No Employee Found";}
		
	totalHours = diff1+diff2+diff3+diff4+diff5;	
	double grosspay = totalHours/(1000.0*60*60)*Hrate;
	System.out.println("Employee Number: "+ EmpNum);
	System.out.println("Employee Name: "+name);
	System.out.println("Birthday: "+Birthday);
	System.out.println("Hours Worked for a Week: " + totalHours/(1000.0*60*60)+ " hours");
	System.out.println("Gross Weekly Salary: " +grosspay+ " Pesos");
}}


	