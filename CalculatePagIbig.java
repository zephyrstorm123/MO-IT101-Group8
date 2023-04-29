package com.mycompany.guipayrollsystem;

public class CalculatePagIbig {
    public static double PagIbig(double weeklyPay) {
        double contribution = 0;
        // Check if the basic salary is less than 1500 for the contribution
        if (weeklyPay <= 1500) {
            // If basic salary is below 1500, employee contribution is 1% of basic salary
            // and employer will match it with 2% of the basic salary.

            contribution = weeklyPay * 0.01;
            return contribution;
        } else {
            contribution = weeklyPay * 0.02;
            if (contribution >= 100) {
                return 100;
            } else {
                return contribution;
            }
        }
    }
}
