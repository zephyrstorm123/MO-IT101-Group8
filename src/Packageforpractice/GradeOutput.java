package Packageforpractice;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.SpringLayout;
public class GradeOutput extends JFrame{
	 // Declare private variables for the Swing components
    private JLabel lblStudentName, lblStudentNo, lblQuiz1, lblQuiz2, lblQuiz3, lblAveGrade;
    private JTextField txtStudentName, txtStudentNo, txtQuiz1, txtQuiz2, txtQuiz3, txtAveGrade;
    private JButton closeButton;


    public GradeOutput(Student stud) {
        // Set up the frame
        super("Grade Output");
        setSize(450, 250);


        // Compute Average
        stud.computeAverage();


        // Create the components
        // Create labels
        lblStudentName = new JLabel("Student Name:");
        lblStudentNo = new JLabel("Student No:");
        lblQuiz1 = new JLabel("Quiz 1:");
        lblQuiz2 = new JLabel("Quiz 2:");
        lblQuiz3 = new JLabel("Quiz 3:");
        lblAveGrade = new JLabel("Average Grade:");
       
        // Create Student Name textfield
        txtStudentName = new JTextField(30);
        txtStudentName.setEnabled(false);
        txtStudentName.setText(stud.getStudentName());
       
        // Create Student Number textfield
        txtStudentNo = new JTextField(30);
        txtStudentNo.setEnabled(false);
        txtStudentNo.setText(stud.getStudentNumber());
       
        // Create Quiz 1 textfield
        txtQuiz1 = new JTextField(10);
        txtQuiz1.setEnabled(false);
        txtQuiz1.setText(stud.getQuiz1());
       
        // Create Quiz 2 textfield
        txtQuiz2 = new JTextField(10);
        txtQuiz2.setEnabled(false);
        txtQuiz2.setText(stud.getQuiz2());
       
        // Create Quiz 3 textfield
        txtQuiz3 = new JTextField(10);
        txtQuiz3.setEnabled(false);
        txtQuiz3.setText(stud.getQuiz3());
       
        // Create Average Grade textfield
        txtAveGrade = new JTextField(10);
        txtAveGrade.setEnabled(false);
        txtAveGrade.setText(stud.getAveGrade());
       
        // Create Close button
        closeButton = new JButton("Close");
       
        // Define the panel to hold the components  
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);
       
        // Add the components to the frame
        panel.add(lblStudentName);
        panel.add(txtStudentName);
        panel.add(lblStudentNo);
        panel.add(txtStudentNo);
        panel.add(lblQuiz1);
        panel.add(txtQuiz1);
        panel.add(lblQuiz2);
        panel.add(txtQuiz2);
        panel.add(lblQuiz3);
        panel.add(txtQuiz3);
        panel.add(lblAveGrade);
        panel.add(txtAveGrade);
        panel.add(closeButton);
 
        // Put constraint on components
        // Set label position: left
        layout.putConstraint(SpringLayout.WEST, lblStudentName, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblStudentNo, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblQuiz1, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblQuiz2, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblQuiz3, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblAveGrade, 6, SpringLayout.WEST, panel);
       
        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblStudentName, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, txtStudentName, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lblStudentNo, 10, SpringLayout.SOUTH, lblStudentName);
        layout.putConstraint(SpringLayout.NORTH, txtStudentNo, 6, SpringLayout.SOUTH, txtStudentName);
        layout.putConstraint(SpringLayout.NORTH, lblQuiz1, 10, SpringLayout.SOUTH, lblStudentNo);
        layout.putConstraint(SpringLayout.NORTH, txtQuiz1, 6, SpringLayout.SOUTH, txtStudentNo);
        layout.putConstraint(SpringLayout.NORTH, lblQuiz2, 10, SpringLayout.SOUTH, lblQuiz1);
        layout.putConstraint(SpringLayout.NORTH, txtQuiz2, 6, SpringLayout.SOUTH, txtQuiz1);
        layout.putConstraint(SpringLayout.NORTH, lblQuiz3, 10, SpringLayout.SOUTH, lblQuiz2);
        layout.putConstraint(SpringLayout.NORTH, txtQuiz3, 6, SpringLayout.SOUTH, txtQuiz2);
        layout.putConstraint(SpringLayout.NORTH, lblAveGrade, 10, SpringLayout.SOUTH, lblQuiz3);
        layout.putConstraint(SpringLayout.NORTH, txtAveGrade, 6, SpringLayout.SOUTH, txtQuiz3);
       
        // Set textfield position: right
        layout.putConstraint(SpringLayout.WEST, txtStudentName, 6, SpringLayout.EAST, lblStudentName);
        layout.putConstraint(SpringLayout.WEST, txtStudentNo, 24, SpringLayout.EAST, lblStudentNo);
        layout.putConstraint(SpringLayout.WEST, txtQuiz1, 51, SpringLayout.EAST, lblQuiz1);
        layout.putConstraint(SpringLayout.WEST, txtQuiz2, 51, SpringLayout.EAST, lblQuiz2);
        layout.putConstraint(SpringLayout.WEST, txtQuiz3, 51, SpringLayout.EAST, lblQuiz3);
        layout.putConstraint(SpringLayout.WEST, txtAveGrade, 51, SpringLayout.EAST, lblAveGrade);
       
        // Set button position
        layout.putConstraint(SpringLayout.NORTH, closeButton, 6, SpringLayout.SOUTH, txtAveGrade);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, closeButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);


        //Add panel to frame
        add(panel);


        // Add an ActionListener to the button
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
