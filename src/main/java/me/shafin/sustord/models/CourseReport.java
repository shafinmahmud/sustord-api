/*
 */
package me.shafin.sustord.models;

import java.util.List;

/**
 *
 * @author SHAFIN
 */
public class CourseReport{
    
    private CourseInSyllabus courseInSyllabus;
    private List<Report> results;
    private String courseStatus;
    private String passedOn;

    public CourseReport() {
    }

    public CourseReport(CourseInSyllabus courseInSyllabus, List<Report> results, 
            String courseStatus, String passedOn) {
        this.courseInSyllabus = courseInSyllabus;
        this.results = results;
        this.courseStatus = courseStatus;
        this.passedOn = passedOn;
    }

  

    public CourseInSyllabus getCourseInSyllabus() {
        return courseInSyllabus;
    }

    public void setCourseInSyllabus(CourseInSyllabus courseInSyllabus) {
        this.courseInSyllabus = courseInSyllabus;
    }

    public List<Report> getResults() {
        return results;
    }

    public void setResults(List<Report> results) {
        this.results = results;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getPassedOn() {
        return passedOn;
    }

    public void setPassedOn(String passedOn) {
        this.passedOn = passedOn;
    }

     
}
