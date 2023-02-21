package com.motorph.payrollsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class EmployeeMaster {
	

	
	public static void empMaster () throws Exception {
		
		try (Scanner scan = new Scanner(System.in)) {
			List<String> lines = Collections.emptyList(); 
			
			try { 
				lines = Files.readAllLines(Paths.get("Employees.txt"), StandardCharsets.UTF_8); 
			} catch (IOException e) { 
				e.printStackTrace(); 
				} 
			System.out.println("Enter the Employee Number (10001-10025):"
					+ "\n(Enter '1' to \"View All\", '0' to \"Exit\")");
			
			if (scan.hasNextInt()) {
			int i = scan.nextInt();
			
			if (i >= 10001 && i <= 10025) {
			i = i - 10001;
			System.out.println("Result:\r"
					+ "\n============================================="); 
			System.out.printf("%s %5.2f %n",lines.get(i),PrintnRead.weekPy[i]);
			System.out.println("=============================================\n");
			empMaster();
			} else if (i == 1) {
				System.out.println("Showing All Results:"
						+ "\n=============================================");
				
				for (i = 0; i <= 24; i++) {
				System.out.printf("%s %5.2f %n",lines.get(i),PrintnRead.weekPy[i]);
				}
				System.out.println("=============================================\n");
				empMaster();
			} else if (i == 0) {
				PayrollSystem.mMenu();
			}
			else {
				System.out.println("\nPlease Enter Valid Input.\n");
				empMaster();
			}
			} else {
				System.out.println("\nYou Entered a Character/s. Please Enter Valid Input.\n");
				empMaster();
			}
			
			
			scan.close();
		}
		
	}
	

	}	
