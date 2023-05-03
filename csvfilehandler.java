

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class csvfilehandler {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\Default.LAPTOP-FTFP08QI\\Documents\\file.txt";
		String EmployeeNumber = "10001"; 
		String LastName = "Crisostomo";
		String FirstName="Jose";
		String Birthday = "February 14, 1988";
		String Address = "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands ";
	 
		
		
		saveRecord(EmployeeNumber,LastName,FirstName,Birthday,Address,path);
		
	}
			
				
				
public static void saveRecord(String EmployeeNumber, String LastName, String FirstName,String Birthday,String Address,String path) {
	

try
	 {
FileWriter fw = new FileWriter(path, true);

BufferedWriter br = new BufferedWriter(fw);
PrintWriter pw = new PrintWriter(br);
pw.println(EmployeeNumber+","+LastName+","+FirstName+","+Birthday+","+Address);
pw.flush();
pw.close();

	JOptionPane.showMessageDialog(null, "Record Save");

}
		
catch (Exception E) {
	JOptionPane.showMessageDialog(null, "Error");
}
		 }}