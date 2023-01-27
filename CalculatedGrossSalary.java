public class CalculatedGrossSalary {
    public static int CalculateGrossSalary(int basicSalary, int riceSubsidy, int phoneAllowance,
            int clothingAllowance) {
        int grossSalary = basicSalary + riceSubsidy + phoneAllowance + clothingAllowance;
        return grossSalary;

    }
}
