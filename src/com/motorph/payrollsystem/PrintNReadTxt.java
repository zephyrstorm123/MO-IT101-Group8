package com.motorph.payrollsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintNReadTxt {
    private double[] weeklyPay = new double[430];
    private double[] dayPy = new double[2150];
    private double[] allEmpRt = new double[2150];
    private double[] empHrsWkd = new double[4300];
    private double empDailyHrs;
    static String[] savedEmpNo = new String[3];
    static String[] savedPass = new String[3];
    private String path = "csv/EmployeeDetails.csv", line = "";
	public static EmployeeDetails[] employee = new EmployeeDetails[25];
    public void printRead() {
        try {
            FileReader file = new FileReader("texts/Daily Timesheet.txt");
            Scanner inFile = new Scanner(file);

            PrintWriter outFile = new PrintWriter("texts/HrsWkd.txt");

            // Read till end of file
            int i = 0;
            while (inFile.hasNext()) {
                double empRate = inFile.nextDouble();
                double empTimein = inFile.nextDouble();
                double empTimeout = inFile.nextDouble();

                // Hours Worked Calculation
                empDailyHrs = (empTimeout - empTimein) * 24 - 1;
                double empPy = empDailyHrs * empRate;

                dayPy[i] = empPy;
                allEmpRt[i] = empRate;
                outFile.printf("%5.2f %n", empDailyHrs);
                i++;
            }

            inFile.close();
            outFile.close();

            int constant = 25;
            int l = 0;
            int o = 0;
			int start = 0;
            
            for (int j = 0; j < 20; j++) {
              for (int k = 0; k < 25; k++) {
            	  double sum = 0;
                for (int m = 0; m < 5; m++) {
                  start = 50;
                  start = constant * m + (125 * l) + start + k;
                  if (start < 2150) {
                  sum = sum + dayPy[start];
                  } else {break;}
                }
                if (start < 2150) {
                weeklyPay[o] = sum;
                o++;
                } else {break;}
              }
              l++;
            }


            FileReader file1 = new FileReader("texts/HrsWkd.txt");
            Scanner inFile1 = new Scanner(file1);

            // Read till end of file

            for (int n = 0; inFile1.hasNext(); n++) {
                empHrsWkd[n] = inFile1.nextDouble();
            }
            


            inFile1.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        readCsvFile();
    }
    
    public void readCsvFile() {
		try {
	        BufferedReader br = new BufferedReader(new FileReader(path));
	        int i = 0;

	        while ((line = br.readLine()) != null) {

	            String[] values = line.split(",");
	            
	         // check if any value is empty or null
	            boolean hasEmptyValue = false;
	            for (String value : values) {
	                if (value == null || value.isEmpty()) {
	                    hasEmptyValue = true;
	                    break;
	                }
	            }

	            	if (hasEmptyValue) {
	                // skip this line
	                continue;
	            }
	            employee[i] = new EmployeeDetails(values[0], values[1], values[2], values[3], values[4], values[5],
	                    values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13],
	                    values[14], values[15], values[16], values[17], values[18]);
	            
	            i++;
	        }
	        br.close();
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}
		
		FileReader file2;
		try {
			file2 = new FileReader("texts/Log In Credentials.txt");
		
        Scanner inFile2 = new Scanner(file2);
        
        for (int m = 0; inFile2.hasNext(); m++) {
        	savedEmpNo[m] = inFile2.next();
        	savedPass[m] = inFile2.next();
        }
        
        inFile2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public double[] getEmpHrsWkd() {
    	return empHrsWkd;
    }

    public double[] getWeeklyPay() {
        return weeklyPay;
    }

    public double[] getAllEmpRate() {
        return allEmpRt;
    }
}
