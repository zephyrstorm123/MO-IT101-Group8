package com.motorph.payrollsystem;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class PrintnRead {
	
    static double empTI;
    static double empTO;
    static double empHrs;
    static double empRt;
    static double empPy;
    static double[] dayPy = new double[2150];
    static double[] weekPy = new double[430];
    static double[] emp1Hrs;


	    public static void main(String[] args) throws Exception
	    {
	        // declare and initialize the variables

	        FileReader file = new FileReader("Daily Timesheet.txt");
	        Scanner inFile = new Scanner(file);

	        PrintWriter outFile = new PrintWriter("HrsWkd.txt");

	        // Read till end of file
	        int i = 0;
	        while (inFile.hasNext())
	        {

	        	empRt = inFile.nextDouble();
	            empTI = inFile.nextDouble();
	            empTO = inFile.nextDouble();

	            
	            //Hours Worked Calculation
	            empHrs = (empTO - empTI) * 24 - 1;	            
	            empPy = empHrs * empRt;
	            
	            dayPy[i] = empPy;
	            
	            outFile.printf("%5.2f %n",empHrs);
	            i++;
	        }

	        inFile.close();
	        outFile.close();

	        int j = 0, k = 0;
	        
	        while (k < 430) {
	        weekPy[j] = dayPy[k] + dayPy[k + 25] + dayPy[k + 50] + dayPy[k + 75] + dayPy[k + 100];
	        j++;
	        k++;
	        }
	        EmployeeMaster.empMaster();
	        
	}
	
}
