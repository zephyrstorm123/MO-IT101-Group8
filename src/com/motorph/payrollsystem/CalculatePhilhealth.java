package com.motorph.payrollsystem;

public class CalculatePhilhealth {
    public static double Philhealth(double weeklyPay) {
        if (weeklyPay <= 10000) {
            return 150.00;
        } else if (weeklyPay > 10000 && weeklyPay < 60000) {
            return ((weeklyPay * 0.03) / 2);
        } else {
            return 900.00;
        }
    }
}