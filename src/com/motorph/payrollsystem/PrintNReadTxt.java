package com.motorph.payrollsystem;

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

    public void printRead() {
        try {
            FileReader file = new FileReader("Daily Timesheet.txt");
            Scanner inFile = new Scanner(file);

            PrintWriter outFile = new PrintWriter("HrsWkd.txt");

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

            int j = 0, k = 0;

            while (k < 430) {
                weeklyPay[j] = dayPy[k] + dayPy[k + 25] + dayPy[k + 50] + dayPy[k + 75] + dayPy[k + 100];
                j++;
                k++;
            }

            FileReader file1 = new FileReader("HrsWkd.txt");
            Scanner inFile1 = new Scanner(file1);

            // Read till end of file

            for (int l = 0; inFile1.hasNext(); l++) {
                empHrsWkd[l] = inFile1.nextDouble();
            }
            


            inFile1.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
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
