public class CalculateWitholdingTax {
    public static double WitholdingTax(int basicSalary, double Philhealth, double SSS, double PagIbig) {
        double taxableIncome = basicSalary - (Philhealth + SSS + PagIbig);

        if (taxableIncome <= 20832) {
            return 0;
        } else if (taxableIncome > 20832 && taxableIncome < 33333) {
            return ((taxableIncome - 20833) * 0.2);
        } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
            return (2500 + ((taxableIncome - 33333) * 0.25));
        } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
            return (10833 + ((taxableIncome - 66667) * 0.30));
        } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
            return (40833.33 + ((taxableIncome - 166667) * 0.32));
        } else {
            return (200833.33 + ((taxableIncome - 666667) * 0.35));
        }
    }
}
