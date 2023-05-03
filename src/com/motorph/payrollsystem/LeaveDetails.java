package com.motorph.payrollsystem;

public class LeaveDetails {
	
	String employeeNumber;
	String leaveType;
	String startDate;
	String endDate;
	String leaveStatus;
	String leaveDescription;
	
	public LeaveDetails(String employeeNumber, String leaveType, String startDate,
			String endDate, String leaveStatus, String leaveDescription) {
		
		this.employeeNumber = employeeNumber;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveStatus = leaveStatus;
		this.leaveDescription = leaveDescription;
		
	}
}
