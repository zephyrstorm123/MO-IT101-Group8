package com.mycompany.exercise1.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeMaster {

	public static void main(String[] args) throws Exception {  
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------MOTORPH EMPLOYEE MASTER-----------\r"
				       + "\n  EMP No.      EMP NAME       EMP GROSS WAGE\r"
					   + "\n----------------------------------------------");
		
		
	    try {
	      File myObj = new File("C:\\Users\\Michael\\eclipse-workspace\\Exercise\\src\\com\\mycompany\\exercise1\\copy\\Employees.txt");
	      Scanner txtReader = new Scanner(myObj);  
	      while (txtReader.hasNextLine()) {
	        String data = txtReader.nextLine();
	        System.out.println(data);
	      }
	      txtReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	    System.out.println("\n1. Back");
	    int emo = scan.nextInt();
	    if (emo == 1) {
	    	PayrollSystem.mMenu();
	    
	    scan.close();
	    }
	  }
	
	
}
