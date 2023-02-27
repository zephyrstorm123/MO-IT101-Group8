/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payrollmotorph;

/**
 *
 * @author Oem user
 */
import java.util.Scanner;

public class Calculation1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter Employee Username: ");
    String employee = input.nextLine();

    System.out.print("Enter Employee Password: ");
    String password = input.nextLine();

        if (employee.equals("10001") && password.equals("012023")) {
            System.out.print("Enter Employee Name: ");
            String name = input.nextLine();

            System.out.print("Enter Number of Worked Hours: ");
            int hoursWrkd = input.nextInt();

            System.out.print("Enter Hourly_Rate: ");
            int hourlyRate = input.nextInt();

            int grossPay;
            if (hoursWrkd > 40) {
                grossPay = 40 * hourlyRate + (hoursWrkd - 40) * hourlyRate * 2;
                } else {
                grossPay = hoursWrkd * hourlyRate;
                }

                System.out.println("Employee Name: " + name);
                System.out.println("Gross Pay: P" + grossPay);
                } else {
                System.out.println("Access denied. Invalid username or password.");
    }
  }
}






