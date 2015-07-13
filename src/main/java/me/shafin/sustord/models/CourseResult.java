/*
 */
package me.shafin.sustord.models;

import java.util.List;

/**
 *
 * @author SHAFIN
 */
public class CourseResult extends CourseInSyllabus{
    
    private List<Result> results;
    private int passedOn;

    public CourseResult() {
    }

    public CourseResult(List<Result> results, int passedOn, 
            String offeringDept, String acceptingDept, 
            double hoursWeek, String prerequisite, 
            String courseCode, String courseTitle, 
            double credit, boolean isCourseTheory, 
            String courseContent, String references) {
        super(offeringDept, acceptingDept, hoursWeek,
                prerequisite, courseCode, courseTitle, 
                credit, isCourseTheory, courseContent, references);
        this.results = results;
        this.passedOn = passedOn;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getPassedOn() {
        return passedOn;
    }

    public void setPassedOn(int passedOn) {
        this.passedOn = passedOn;
    }
 
}
