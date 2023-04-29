package com.mycompany.guipayrollsystem;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.util.List;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class EmployeeMaster extends JFrame{

    private JLabel title, empName, empNumber, dateToLeave, vacationLeave, sickLeave, emergencyLeave;
    private JTextField txtEmpName, txtEmpNumber, txtDateToLeave, txtVacationLeave, txtSickLeave, txtEmergencyLeave;
    private JTable table;
    private JLabel employee1;
    private JButton sampleBtn, enableEdit, getLeaveBtn, applyLeaveBtn;
    private JCalendar calendar;
    private ArrayList employeeLeave;
    private String[] employeeRemainingLeave;
    private String dateStr, empNameStr, empNumberStr, selectedLeaveType;
    private JComboBox<String> dropDownLeave;
    
    //Declaring instance variable to be able to be accessed by the whole class
    private boolean enableEditSet;
    
    public EmployeeMaster() throws FileNotFoundException, IOException, CsvValidationException {
        /*when extending JFrame, no need to initialize another JFrame panel, as it will not display properly. 
            correct way is to use preassumed "this". In short. dont initialize any jframe. 
        */
        empNameStr = "Nicole";
        empNumberStr = "10001";
        
                
        setTitle("Employee Master");
        setSize(610,550);
        setLayout(null);
        setLocationRelativeTo(null);
        
        enableEditSet = false;
        title = new JLabel("EMPLOYEE LEAVE MANAGER");
        title.setBounds(200, 10, 230, 30);
        title.setFont(new Font("Ariel", Font.BOLD, 15));
        add(title);
        
//Labels for the text fields
            //=====================================
        empName = new JLabel("Employee Name");
        empName.setBounds(40, 55, 150, 30);
        add(empName);
            //=====================================
        empNumber = new JLabel("Employee Number");
        empNumber.setBounds(40,85, 150, 30);
        add(empNumber);
            //=====================================
        dateToLeave = new JLabel("Date");
        dateToLeave.setBounds(40, 170, 150, 30);
        add(dateToLeave);
            //=====================================
        vacationLeave = new JLabel("Vacation Leave/s Remaining");
        vacationLeave.setBounds(300, 250, 200, 30);
        add(vacationLeave);
            //=====================================
        sickLeave = new JLabel("Sick Leave/s Remaining");
        sickLeave.setBounds(300, 300, 200, 30);
        add(sickLeave);
            //=====================================
        emergencyLeave = new JLabel("Emergency Leave/s Remaining");
        emergencyLeave.setBounds(300, 350, 200, 30);
        add(emergencyLeave);
            //=====================================
        
//Text fields
            //=====================================
        txtEmpName = new JTextField(30);
        txtEmpName.setEnabled(enableEditSet);
        txtEmpName.setBounds(150, 61, 150, 20);
        txtEmpName.setText(empNameStr);
        add(txtEmpName);
            //=====================================
        txtEmpNumber = new JTextField(30);
        txtEmpNumber.setEnabled(enableEditSet);
        txtEmpNumber.setBounds(150, 90, 150, 20);
        txtEmpNumber.setText(empNumberStr);
        add(txtEmpNumber);
            //=====================================
        txtDateToLeave = new JTextField(30);
        txtDateToLeave.setEnabled(false);
        txtDateToLeave.setBounds(80, 173, 70, 20);
        add(txtDateToLeave);
            //=====================================
        txtVacationLeave = new JTextField(30);
        txtVacationLeave.setEnabled(false);
        txtVacationLeave.setBounds(500, 257, 50, 20);
        add(txtVacationLeave);
            //=====================================
        txtSickLeave = new JTextField(30);
        txtSickLeave.setEnabled(false);
        txtSickLeave.setBounds(500, 307, 50, 20);
        add(txtSickLeave);
            //=====================================
        txtEmergencyLeave = new JTextField(30);
        txtEmergencyLeave.setEnabled(false);
        txtEmergencyLeave.setBounds(500, 357, 50, 20);
        add(txtEmergencyLeave);
            //=====================================
            
//Initialize the dropdown box
        String[] leaveSelect = {"","Vacation Leave", "Sick Leave", "Emergency Leave"};
        dropDownLeave = new JComboBox<>(leaveSelect);   
        dropDownLeave.setBounds(165, 173, 120, 20);
        add(dropDownLeave);
        
                  
//Initialize the JCalendar
        calendar = new JCalendar();
        calendar.setBounds(40, 210, 240, 180);
        add(calendar);
        
        calendar.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("calendar")) {
                    java.util.Date selectedDate = calendar.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);
                    txtDateToLeave.setText(formattedDate);
                    dateStr = formattedDate;
                }
            }
        });
  
        
// JBUTTONS
            //Enable Edit of Details
        enableEdit = new JButton("Edit Details");
        enableEdit.setBounds(40, 115, 100,30);
        add(enableEdit);
        
        
        
            //Get Employees Leave Button
        getLeaveBtn = new JButton("Leave Credits");
        getLeaveBtn.setBounds(380, 400, 150, 40);
        add(getLeaveBtn);
        
        
        applyLeaveBtn = new JButton("Apply");
        applyLeaveBtn.setBounds(170, 400, 100, 40);
        add(applyLeaveBtn);
        
        
//ACTION LISTENERS
        
        dropDownLeave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    selectedLeaveType = (String) dropDownLeave.getSelectedItem();
                    System.out.println("Selected leave type: " + selectedLeaveType);
                }
        });
       
        enableEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                enableEditSet = !enableEditSet;
                //To be able to edit the text inside the textfield
                txtEmpName.setEnabled(enableEditSet);
                txtEmpNumber.setEnabled(enableEditSet);
            }
        });
              
        getLeaveBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               try {
                    employeeRemainingLeave = checkLeaveCredits(empNumberStr);
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CsvValidationException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                }                               
                
                txtVacationLeave.setText(employeeRemainingLeave[2]);
                txtSickLeave.setText(employeeRemainingLeave[3]);
                txtEmergencyLeave.setText(employeeRemainingLeave[4]);
           }
        });
        
        applyLeaveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    recordAppliedLeave(dateStr, empNameStr, empNumberStr, selectedLeaveType);
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CsvException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public String[] checkLeaveCredits(String empNumber) throws FileNotFoundException, IOException, CsvValidationException{
        String path = "C:\\Users\\Tone\\Documents\\NetBeansProjects\\MO-IT101-Group8\\guiPayrollSystem\\src\\main\\java\\com\\mycompany\\guipayrollsystem\\employeeLeaveCredits.csv";
        CSVReader reader = null;
        //Important to declare row as null
        String[] row = null;
        
        try {
            reader = new CSVReader(new FileReader(path));
            employeeLeave = new ArrayList<>();
            String[] values;
            //Skip the header part
            reader.readNext();
            
            while((values = reader.readNext()) != null){
                if(values[0].equals(empNumber)){
                    row = values;
                    break;
                }
            }
        } finally {
             if (reader != null) {
                 
                reader.close();
            }   
        }
        return row;
    }
    
    public void recordAppliedLeave(String date, String empName, String empNumber, String leaveType)throws FileNotFoundException, IOException, CsvException {
        if (date == null || empName == null || empNumber == null || leaveType.equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Inputs");
            return;
        }

         JOptionPane.showMessageDialog(null, "Thank you for valid inputs, Updating Leave Records");

            String path = "C:\\Users\\Tone\\Documents\\NetBeansProjects\\MO-IT101-Group8\\guiPayrollSystem\\src\\main\\java\\com\\mycompany\\guipayrollsystem\\employeeLeaveCredits.csv";
            //Create a temporary csv file path to save the data before replacing it with the original file name 
            String tmpPath = "C:\\Users\\Tone\\Documents\\NetBeansProjects\\MO-IT101-Group8\\guiPayrollSystem\\src\\main\\java\\com\\mycompany\\guipayrollsystem\\employeeLeaveCredits.tmp.csv";
            String leaveRecords = "C:\\Users\\Tone\\Documents\\NetBeansProjects\\MO-IT101-Group8\\guiPayrollSystem\\src\\main\\java\\com\\mycompany\\guipayrollsystem\\employeeLeaveDates.csv";
            
            //CSVReader and Writer are automatically closed by the try block
            try (CSVReader reader = new CSVReader(new FileReader(path));
                 CSVWriter writer = new CSVWriter(new FileWriter(tmpPath))) {
                List<String[]> rows = reader.readAll();
                for (String[] row : rows) {
                    if (row[0].equals(empNumber)) {
                        switch (leaveType) {
                            case "Vacation Leave" -> {
                                int VL = Integer.parseInt(row[2]);
                                VL--;
                                row[2] = Integer.toString(VL);
                            }
                            case "Sick Leave" -> {
                                int SL = Integer.parseInt(row[3]);
                                SL--;
                                row[3] = Integer.toString(SL);
                            }
                            case "Emergency Leave" -> {
                                int EL = Integer.parseInt(row[4]);
                                EL--;
                                row[4] = Integer.toString(EL);
                            }
                            default -> {
                            }
                        }
                    }
                    // write the row to the temporary file
                    writer.writeNext(row);
                }
            }
            
            //Append leaveRecord in employeeLeaveDates
            CSVWriter employeeLeaveDates = new CSVWriter(new FileWriter(leaveRecords, true));
            String[] leaveRecord = {date, empName, leaveType};
            employeeLeaveDates.writeNext(leaveRecord);
            employeeLeaveDates.close();
            

            // replace the original file with the temporary file
            File origFile = new File(path);
            File tmpFile = new File(tmpPath);
            if (origFile.exists()) {
                origFile.delete();
            }
            tmpFile.renameTo(origFile);
    }
    

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeMaster employee = null;
                try {
                    employee = new EmployeeMaster();
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CsvValidationException ex) {
                    Logger.getLogger(EmployeeMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
                employee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                employee.setVisible(true);
            }
             });
        }
    }