import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = "\\E:\\MMDC\\MotorPHProject\\src\\MotoPHEmployeesScrubbed.csv";
        String line = "";

        EmployeeDetails[] employee = new EmployeeDetails[25];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int i = 0;

            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }

                String[] values = line.split(",");

                employee[i - 1] = new EmployeeDetails(values[0], values[1], values[2], values[3], values[4], values[5],
                        values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13],
                        values[14], values[15], values[16], values[17], values[18]);
                i++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee number");
            int empNumber = sc.nextInt();

            for (int i = 0; i < employee.length; i++) {
                int employeeNumber = Integer.parseInt(employee[i].employeeNumber);
                if (empNumber == employeeNumber) {
                    Login login = new Login();
                    login.Login(employee[i]);
                    break;
                } else {
                    continue;
                }
            }

            sc.close();

        } finally {

        }
    }
}