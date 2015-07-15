/*
 */
package me.shafin.sustord.models;

import java.util.List;

/**
 *
 * @author SHAFIN
 */
public class CourseResult{
    
    private CourseInSyllabus courseInSyllabus;
    private List<Result> results;
    private int passedOn;

    public CourseResult() {
    }

    public CourseResult(CourseInSyllabus courseInSyllabus, 
            List<Result> results, int passedOn) {
        this.courseInSyllabus = courseInSyllabus;
        this.results = results;
        this.passedOn = passedOn;
    }

    public CourseInSyllabus getCourseInSyllabus() {
        return courseInSyllabus;
    }

    public void setCourseInSyllabus(CourseInSyllabus courseInSyllabus) {
        this.courseInSyllabus = courseInSyllabus;
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
