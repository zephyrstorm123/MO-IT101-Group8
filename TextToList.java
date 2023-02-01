package com.mycompany.exercise1.copy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class TextToList {
	

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		List<String> lines = Collections.emptyList(); 
		
		try { 
			lines = Files.readAllLines(Paths.get("C:\\Users\\Michael\\eclipse-workspace\\Exercise\\src\\com\\mycompany\\exercise1\\copy\\Employees.txt"), StandardCharsets.UTF_8); 
		} catch (IOException e) { 
			e.printStackTrace(); 
			} 
		System.out.println("Enter the Employee Number:"
				+ "\n(Enter '0' to \"View All\", '1' to \"Exit\")");
		int i = scan.nextInt();
		
		if (i >= 10001 && i <= 10025) {
		i = i - 10001;
		System.out.println("Result:\r"
				+ "\n============================================="); 
		System.out.println(lines.get(i)
				+ "\n============================================="
				+ "\n");
		main(null);
		} else if (i == 0) {
			System.out.println("Showing All Results:"
					+ "\n=============================================");
			
			for (i = 0; i <= 24; i++) {
			System.out.println(lines.get(i));
			}
			System.out.println("=============================================\n");
			main(null);
		} else if (i == 1) {
			PayrollSystem.mMenu();
		}
		else {
			System.out.println("\nPlease Enter Valid Input.\n");
			main(null);
		}
		
		scan.close();
		}
	

	}	
