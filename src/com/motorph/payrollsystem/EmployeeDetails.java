package com.motorph.payrollsystem;

public class EmployeeDetails {
    String employeeNumber;
    String lname;
    String fname;
    String bday;
    String address;
    String phoneNumber;
    String sssNumber;
    String philHealthNumber;
    String tinNumber;
    String pagIbigNumber;
    String status;
    String position;
    String immediateSupervisor;
    String basicSalary;
    String riceSubsidy;
    String phoneAllowance;
    String clothingAllowance;
    String grossSemiMonthlyRate;
    String hourlyRate;

    public EmployeeDetails(String employeeNumber, String lname, String fname, String bday, String address,
            String phoneNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber,
            String status,
            String position, String immediateSupervisor, String basicSalary, String riceSubsidy, String phoneAllowance,
            String clothingAllowance, String grossSemiMonthlyRate, String hourlyRate) {

        this.employeeNumber = employeeNumber;
        this.lname = lname;
        this.fname = fname;
        this.bday = bday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;

    }

}