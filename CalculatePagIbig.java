public class CalculatePagIbig {
    public static double PagIbig(int basicSalary) {
        double contribution = 0;
        // Check if the basic salary is less than 1500 for the contribution
        if (basicSalary <= 1500) {
            // If basic salary is below 1500, employee contribution is 1% of basic salary
            // and employer will match it with 2% of the basic salary.

            contribution = basicSalary * 0.01;
            return contribution;
        } else {
            contribution = basicSalary * 0.02;
            if (contribution >= 100) {
                return 100;
            } else {
                return contribution;
            }
        }
    }
}
