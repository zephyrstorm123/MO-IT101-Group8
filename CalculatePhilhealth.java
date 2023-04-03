public class CalculatePhilhealth {
    public static double Philhealth(int basicSalary) {
        if (basicSalary <= 10000) {
            return 150.00;
        } else if (basicSalary > 10000 && basicSalary < 60000) {
            return ((basicSalary * 0.03) / 2);
        } else {
            return 900.00;
        }
    }
}