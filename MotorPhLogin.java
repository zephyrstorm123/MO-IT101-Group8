/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorphlogin;

/**
 *
 * @author Oem user
 */
import java.util.Scanner;

public class MotorPhLogin {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Login credentials
        String username = "user";
        String password = "pass123";

        // Loop until reached correct login credentials
        while (true) {

            // Prompt user to enter username and password
            System.out.print("Enter username: ");
            String inputEmpname = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPassword = scanner.nextLine();

            // Check if credentials match
            if (inputEmpname.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login successful");

                // Loop through menu options until user chooses to exit
                while (true) {
                    System.out.println("Tab Menu Options:");
                    System.out.println("(1) Inventory Tab ");
                    System.out.println("(2) Payroll Tab");
                    System.out.println("(3) PaySlip Tab");
                    System.out.println("(4) Exit");

                    System.out.print("Enter Tab option: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // consume newline character

                    // Execute selected option
                    switch (option) {
                        case 1:
                            System.out.println("Inventory Tab selected (not yet available)");
                            break;
                        case 2:
                            System.out.println("Payroll Tab selected");
                            break;
                        case 3:
                            System.out.println("PaySlip Tab selected");
                            break;
                        case 4:
                            System.out.println("Exiting program...");
                            System.exit(0);
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid login credentials");
            }
        }
    }
}