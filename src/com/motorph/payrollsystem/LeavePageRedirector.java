package com.motorph.payrollsystem;

public class LeavePageRedirector {
	public void redirect() {
		LeaveApplication leave = new LeaveApplication();
		leave.applyLeave();
	}
}
