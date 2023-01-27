public class TimeHolder {
    public static int[] EmployeeHours(int employeeNumber) {
        int[][] time = {
                { 10001, 9, 9, 9, 9, 8, 9, 9, 9 },
                { 10002, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10003, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10004, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10005, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10006, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10007, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10008, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 10009, 8, 9, 10, 11, 12, 13, 14, 15 },
        };

        for (int i = 0; i < time.length; i++) {
            if (employeeNumber == time[i][0]) {
                return (time[i]);
            }
        }

        return null;

    }
}
