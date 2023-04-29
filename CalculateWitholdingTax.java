package com.mycompany.guipayrollsystem;

public class CalculateWitholdingTax {
    public static double WitholdingTax(double basicSalary, double Philhealth, double SSS, double PagIbig) {
        double taxableIncome = basicSalary - (Philhealth + SSS + PagIbig);

        if (taxableIncome * 4 <= 20832) {
            return 0;
        } else if (taxableIncome * 4 > 20832 && taxableIncome * 4 < 33333) {
            return ((taxableIncome * 4 - 20833) * 0.2) / 4;
        } else if (taxableIncome * 4 >= 33333 && taxableIncome * 4 < 66667) {
            return (2500 + ((taxableIncome * 4 - 33333) * 0.25)) / 4;
        } else if (taxableIncome * 4 >= 66667 && taxableIncome * 4 < 166667) {
            return (10833 + ((taxableIncome * 4 - 66667) * 0.30)) / 4;
        } else if (taxableIncome * 4 >= 166667 && taxableIncome * 4 < 666667) {
            return (40833.33 + ((taxableIncome * 4 - 166667) * 0.32)) / 4;
        } else {
            return (200833.33 + ((taxableIncome * 4 - 666667) * 0.35)) / 4;
        }
    }
}
