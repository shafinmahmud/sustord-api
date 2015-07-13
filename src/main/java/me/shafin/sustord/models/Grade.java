/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class Grade {
    
    private String gradeLetter;
    private double gradePoint;

    public Grade() {
    }

    public Grade(String gradeLetter, double gradePoint) {
        this.gradeLetter = gradeLetter;
        this.gradePoint = gradePoint;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }
    
    
}
