public class TotalWorkHours {
    public static int WorkHours(int[] employeeTime) {
        // calculate Work Hours rendered by the employee

        int totalWorkedHoursOfWorker = 0;

        for (int i = 1; i < employeeTime.length; i++) {
            totalWorkedHoursOfWorker += employeeTime[i];
        }

        return totalWorkedHoursOfWorker;
    }
}
