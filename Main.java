import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "\\E:\\MMDC\\MotorPHProject\\src\\MotoPHemployeesScrubbedtextfile.txt";
        String line;
        int count = 0;

        // Creates an object array for each employee in the path text file
        EmployeeDetails[] employee = new EmployeeDetails[25];
        Scanner inFile = new Scanner(new FileReader(path));

        while (inFile.hasNextLine()) {

            line = inFile.nextLine();
            String[] values = line.split("  ");

            // This logic gate skips the first line of the text file which keeps the header
            // of the files.
            if (count == 0) {
                count++;
                continue;
            }

            employee[count - 1] = new EmployeeDetails(values[0], values[1], values[2], values[3], values[4],
                    values[5],
                    values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13],
                    values[14], values[15], values[16], values[17], values[18]);
            count++;
        }

        // Login In System
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee number");
        int empNumber = sc.nextInt();

        for (int i = 0; i < employee.length; i++) {
            int employeeNumber = Integer.parseInt(employee[i].employeeNumber);
            if (empNumber == employeeNumber) {
                int pwCount = 0;

                StringBuilder reverseLname = new StringBuilder();
                reverseLname.append(employee[i].lname);
                String employeePw = reverseLname.reverse().toString();
                System.out.println(employeePw);

                while (pwCount < 3) {
                    System.out.println("Please Enter Password");
                    String inputPw = sc.next();

                    if (inputPw.equals(employeePw)) {
                        Login login = new Login();
                        login.Login(employee[i]);
                        break;
                    } else {
                        pwCount++;
                        continue;
                    }
                }

                System.out.println("You have exceeded number of tries");
                System.exit(0);
            } else {
                continue;
            }
        }

        System.out.println("Employee Number Not Found");

        sc.close();
    }
}
