package filehandler;
import java.io.*;
import java.util.List;

import com.opencsv.CSVReader;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Default.LAPTOP-FTFP08QI\\file\\user.csv";
List<String[]> line = null;
        // Write data to the file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            String EmployeeNumber = "10001";
			String LastName = "Crisostomo";
			String FirstName = "Jose";
			int Birthday = (02-14-98);
			String Address = "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands";
			 
			writer.write(EmployeeNumber+LastName+FirstName+Birthday+Address);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Read data from the file
        try {
            CSVReader csvreader = new CSVReader(new FileReader(filename));
            while (line != null) {
				
                System.out.println(line);
                line = csvreader.readAll();}    
            csvreader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
       

        // Delete the file
        File file = new File(filename);
        file.delete();
    }
 }
 }
