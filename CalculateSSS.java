public class CalculateSSS {
    public static double SSS(int basicSalary) {
        if (basicSalary < 3250) {
            return 135.00;
        } else if (basicSalary >= 3250 && basicSalary < 24750) {
            int initial = basicSalary - 3250;
            double taxDifference = (initial / 500);
            double taxFraction = (taxDifference % 1);

            double taxAdd = (taxDifference - taxFraction);

            return (((taxAdd + 1) * 22.5)) + 135;
        } else {
            return 1125.00;
        }
    }

}
