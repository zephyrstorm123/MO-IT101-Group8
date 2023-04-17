package Packageforpractice;

public class Student {
	 //attributes
    private String studentNumber;
    private String studentName;
    private float quiz1;
    private float quiz2;
    private float quiz3;
    private float averageGrade;
   
    //getter and setter methods
    //getter methods
    public String getStudentNumber() {
        return studentNumber;
    }
   
    public String getStudentName() {
        return studentName;
    }
   
    public String getQuiz1() {
        return String.valueOf(quiz1);
    }
   
    public String getQuiz2() {
        return String.valueOf(quiz2);
    }
   
    public String getQuiz3() {
        return String.valueOf(quiz3);
    }
   
    public String getAveGrade() {
        return String.valueOf(averageGrade);
    }
   
    //setter methods
    public void setStudentNumber(String studNumber) {
        studentNumber = studNumber;
    }
   
    public void setStudentName(String studName) {
        studentName = studName;
    }
   
    public void setQuiz1(float q1) {
        quiz1 = q1;
    }
   
    public void setQuiz2(float q2) {
        quiz2 = q2;
    }
   
    public void setQuiz3(float q3) {
        quiz3 = q3;
    }
   
    //methods
    public float computeAverage() {
        averageGrade = (quiz1 + quiz2 + quiz3) / 3;
        return averageGrade;
}
}