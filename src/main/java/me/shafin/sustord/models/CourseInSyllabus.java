/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CourseInSyllabus extends CourseModel{    
    private String offeringDept;
    private String acceptingDept;
    private double hoursWeek;
    private String prerequisite;

    public CourseInSyllabus() {
    }

    
    public CourseInSyllabus(String offeringDept, String acceptingDept, 
            double hoursWeek, String prerequisite, String courseCode, 
            String courseTitle, double credit, boolean isCourseTheory, 
            String courseContent, String references) {
        super(courseCode, courseTitle, credit, isCourseTheory, courseContent, references);
        this.offeringDept = offeringDept;
        this.acceptingDept = acceptingDept;
        this.hoursWeek = hoursWeek;
        this.prerequisite = prerequisite;
    }

    public String getOfferingDept() {
        return offeringDept;
    }

    public void setOfferingDept(String offeringDept) {
        this.offeringDept = offeringDept;
    }

    public String getAcceptingDept() {
        return acceptingDept;
    }

    public void setAcceptingDept(String acceptingDept) {
        this.acceptingDept = acceptingDept;
    }

    public double getHoursWeek() {
        return hoursWeek;
    }

    public void setHoursWeek(double hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
    
}
