

public class UserLogin extends PayrollSystem {
    private String empNo = "10001";
    private String pass = "Admin1234";
    public boolean loggedIn;

    public void insertData() {
        System.out.println();
    	System.out.println("Welcome to MotorPH Payroll System");
        System.out.println("Enter Employee Number: ");
        String empNo = scan.next();
        System.out.println("Enter Password: ");
        String pass = scan.next();
        loggedIn = verifyLogin(empNo, pass);

    }

    public boolean verifyLogin(String empNo, String pass) {
    	return this.empNo.equals(empNo) && this.pass.equals(pass);
    }
}