package com.mycompany.exercise1.copy;

import java.util.Scanner;

public class Payslip {
	
	   static Scanner scan = new Scanner(System.in);
	   static int emp1No = 10001, emp2No = 10002;
	   static String[] emp1payD = {"September 10, 2022","September 17, 2022","September 24, 2022"};
	   static String emp1Name = "CRISOSTOMO, JOSE";
	   static String emp1tinNo = "317-674-022-000";
	   static String emp1sssNo = "49-1632020-8";
	   static String emp1phicNo = "38-218945314-5";
	   static String emp1hdmfNo = "4410-9336-9646";
	   static String emp1pos = "HR Manager";
	   static double emp1hourRt = 373.50;
	   static double emp1OtRate = 1.5*emp1hourRt;
	   static int rice = 1500;
  	   static int cloth = 1000;
  	   static int pho = 1000;
	   static double[] hourWk = {HoursWorked.emp1HrsTtl,HoursWorked.emp1HrsTtl2};
	   static double[] hourOt = {HoursWorked.emp1OtTtl1};
	   static int payP;
	   static int payPc;
	   static String[] payPview = {"September 2022 1st Pay Period","September 2022 2nd Pay Period","September 2022 3rd Pay Period"};
	   static double nonTaxPay = ((rice / 4) + (cloth/4) + (pho/4));
	   static double[] basicHr = {(hourWk[0] * emp1hourRt)};
	   static double[] regOt = {(hourOt[0] * emp1OtRate)};
	   static double[] taxablePay = {(basicHr[0] + regOt[0])}; 

	
	public static void main(String[] args) {
		paySlipMenu();
	}
	
	public static void paySlipMenu() {
		
		if (PayrollSystem.empNo == 10001) {
			System.out.println("Please enter pay period:");
			   
			for (int i = 0; i <= 2; i++) {	   
				System.out.println(i + 1 + ". " + payPview[i]);
			}
				   
		   System.out.println("4. Back");
		   
			   payP = scan.nextInt();
			   paySlipInfoEmp1();		   
			   } else {
				   System.out.println("Sorry. User has no access to this yet.");
				   PayrollSystem.profMenu();
			   }
	   
		   }
		
	
	public static void paySlipInfoEmp1() {
		switch (payP) {
   			case 1:
   				System.out.println("----- MotorPH -----");
   				System.out.println("PAYROLL INFORMATION");
   				System.out.println("Employee Name: " + emp1Name);
   				System.out.println("Payroll Period: " + payPview[0]); 
   				System.out.println("Pay Date: " + emp1payD[0]);
   				System.out.println("   "); 
   				System.out.println("EMPLOYEE INFORMATION");
   				System.out.println("Employee No.: " + emp1No);
		   		System.out.println("TIN: " + emp1tinNo);
		   		System.out.println("SSS No.: " + emp1sssNo);
		   		System.out.println("PHIC No.: " + emp1phicNo);
		   		System.out.println("HDMF No.: " + emp1hdmfNo);
		   		System.out.println("Position: " + emp1pos);
		   		System.out.println("Hourly Rate: PHP " + emp1hourRt);
		   		System.out.println("Overtime Rate: PHP " + emp1OtRate);
		   	    System.out.println("\nEARNINGS");
		   	    System.out.println("Taxable Earnings:");
		   	    System.out.println("Basic Pay - " + hourWk[0] + " hr(s): PHP " + basicHr[0]);
		   	    
		   	    if (hourOt[0] != 0) {
		   	    	System.out.println("Regular OT - " + hourOt[0] + " hr(s): PHP " + regOt[0]);
		   	    	System.out.println("TOTAL TAXABLE PAY: PHP " + (basicHr[0] + regOt[0]));
		   	    } else {
		   	    	System.out.println("TOTAL TAXABLE PAY: PHP " + (basicHr));   	
		   	    }
		   	    	
		   	    	
		   	    System.out.println("\nNon-Taxable Earnings:");
		   	    System.out.println("Rice Subsidy: PHP " + (rice / 4));
		   	    System.out.println("Clothing Allowance: PHP " + (cloth / 4)); 
		   	    System.out.println("Phone Allowance: PHP " + (pho / 4)); 
		   	    System.out.println("TOTAL NON-TAXABLE PAY: PHP " + nonTaxPay);
		   	    
		   	    if (hourOt[0] != 0) {
		   	    System.out.println("\nGROSS EARNINGS: PHP " + (basicHr[0] + regOt[0] + nonTaxPay));
		   	    } else {
		   	     System.out.println("\nGROSS EARNINGS: PHP " + (basicHr[0] + nonTaxPay));	
		   	    }
		   	    
	//Deduction and Net Earnings Computation
		   	//SSS
		   	   double sssTot;
		   	   
		   	   if (taxablePay[0] >= 24750) {
		   	     sssTot = 1125.00;
		   	   }
		   	   else if (taxablePay[0] < 24750 && taxablePay[0] >= 24250) {
		   	     sssTot = 1102.50;
		   	   }
		   	   else {
		   	     sssTot = 1080.00;
		   	   }   	    
		   	   
		   	//Philhealth
		   	   double phicTot;
		   	   double phicRt = 0.03;
		   	   
		   	   if ((taxablePay[0] * 4) < 10000) {
		   	     phicTot = 300 / 4;
		   	   }
		   	   else if ((taxablePay[0] * 4) >= 10000.01 && (taxablePay[0] * 4) <= 59999.99) {
		   	     phicTot = ((taxablePay[0] * 4) * phicRt) / 4;
		   	   } else {
		   		   phicTot = 1800 / 4;
		   	   }
		   	   
		   	//Pag-ibig
		   	  double hdmfTot;
		   	  
		   	  if ((taxablePay[0] * 4) > 1000 && (taxablePay[0] * 4) < 1500) {
		   		  hdmfTot = (taxablePay[0] * 4) * 0.01 / 4;
		   	  } else {
		   		  hdmfTot = (taxablePay[0] * 4) * 0.02 / 4;
		   	  }
		   	  
		   	//BIR
		   	  double birTot;
		   	  
		   	  if ((taxablePay[0] * 4) <= 20832) {
		   	    birTot = 0;
		   	  }
		   	  else if ((taxablePay[0] * 4) > 20833 && (taxablePay[0] * 4) < 33333) {
		   	    birTot = (((taxablePay[0] * 4) - 20833) * 0.2) / 4;
		   	  }
		   	  else if ((taxablePay[0] * 4) > 33333 && (taxablePay[0] * 4) < 66667) {
		   	    birTot = ((((taxablePay[0] * 4) - 33333) * 0.25) + 2500) / 4;
		   	  }
		   	  else if ((taxablePay[0] * 4) > 66667 && (taxablePay[0] * 4) < 166667) {
		   	    birTot = ((((taxablePay[0] * 4) - 66667) * 0.3) + 10833) / 4;
		   	  }
		   	  else {
		   	    birTot = 0;
		   	  }  
		   	  
		   	double dedTtl = sssTot + phicTot + hdmfTot + birTot;
		   	
		   	System.out.println("\nDEDUCTIONS:");
		    System.out.println("SSS: PHP " + sssTot);
		    System.out.println("PhilHealth: PHP " + phicTot);
		    System.out.println("Pag-ibig: PHP " + hdmfTot);
		    System.out.println("Withholding Tax: PHP " + birTot);
		    System.out.println("TOTAL DEDUCTIONS: PHP " + (sssTot + phicTot + hdmfTot + birTot));
		    System.out.println("\nNET EARNINGS: PHP " + (((taxablePay[0]) - dedTtl) + nonTaxPay));
		   	    
		   	    System.out.println("\n1. Back");
		   	    payPc = scan.nextInt();
		   	    if (payPc == 1) {
		   	    	paySlipMenu();
		   	    }
		   	    else {
		   	    	
		   	    }
		   	    
		   	    break;
   			case 4:
   				PayrollSystem.profMenu();
   				break;
   			default:
   				System.out.println("Wrong Input or Option Currently Unavailable. Please Try Again.");
   	        	paySlipMenu();
   				break;
		}
	}
}
