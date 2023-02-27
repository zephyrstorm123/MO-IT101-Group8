/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.timesheet;

/**
 *
 * @author Oem user
 */
import java.util.Scanner;

public class TimeSheet {

    public static void main(String[] args) {
        
               
        Scanner input = new Scanner(System.in);
        double HourlyRate = 373.04; // MotorPh Hourly rate
        
        System.out.print("Enter Total WorkedHours: ");
        double workHours = input.nextDouble();
        double pay = HourlyRate * workHours; // calculate weekly pay
        System.out.println("Pay: P " + pay);  // Employee Total Pay      
        
      
    }
}
