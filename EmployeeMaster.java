package com.mycompany.exercise1.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeMaster {

	  public static void main(String[] args) {  
		  
		  Scanner scan = new Scanner(System.in);
		  
		  System.out.println("----------MOTORPH EMPLOYEE MASTER----------");
		  System.out.println("NO.           EMP NAME           GROSS WAGE");
		  System.out.println("-------------------------------------------");
		  
		    try {
		      File myObj = new File("C:\\Users\\Michael\\eclipse-workspace\\Exercise\\src\\com\\mycompany\\exercise1\\copy\\Employees.txt");
		      Scanner myReader = new Scanner(myObj);  
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
		    
		    System.out.println("\n1. Back");
		    
		    int emo = scan.nextInt();
		    if (emo == 1) {
		    	PayrollSystem.mMenu();
		    }
		    
		    
		    scan.close();
		    
		  } 
	
}
