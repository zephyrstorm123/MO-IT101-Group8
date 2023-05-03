package com.motorph.payrollsystem;

public class UserDetails {

	String employeeNumber;
	String password;
	String systemRole;
	String accountStatus;
	
	public UserDetails(String employeeNumber, String password, String systemRole, String accountStatus) {
		this.employeeNumber = employeeNumber;
		this.password = password;
		this.systemRole = systemRole;
		this.accountStatus = accountStatus;
	}
	
}
