package com.mycompany.guipayrollsystem;

public class CalculateSSS {
    public static double SSS(double weeklyPay) {
        if (weeklyPay < 3250) {
            return 135.00;
        } else if (weeklyPay >= 3250 && weeklyPay < 24750) {
            double initial = weeklyPay - 3250;
            double taxDifference = (initial / 500);
            double taxFraction = (taxDifference % 1);

            double taxAdd = (taxDifference - taxFraction);

            return (((taxAdd + 1) * 22.5)) + 135;
        } else {
            return 1125.00;
        }
    }

}
