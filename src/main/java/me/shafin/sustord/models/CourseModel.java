/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CourseModel {

    private String courseCode;
    private String courseTitle;
    private double credit;
    private boolean isTheoryCourse;
    private String courseContent;
    private String references;

    public CourseModel() {
    }

    
    public CourseModel(String courseCode, String courseTitle, double credit, 
            boolean isCourseTheory, String courseContent, String references) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.isTheoryCourse = isCourseTheory;
        this.courseContent = courseContent;
        this.references = references;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public boolean isTheoryCourse() {
        return isTheoryCourse;
    }

    public void setTheoryCourse(boolean theoryCourse) {
        this.isTheoryCourse = theoryCourse;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
    
    

}
