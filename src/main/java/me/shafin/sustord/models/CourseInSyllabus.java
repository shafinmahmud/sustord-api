/*
 */
package me.shafin.sustord.models;

import java.util.List;


/**
 *
 * @author SHAFIN
 */
public class CourseInSyllabus{
    
    private CourseModel courseModel;
    
    private int offeringSemester;
    private DepartmentModel offeringDept;
    private DepartmentModel acceptingDept;
    private double hoursWeek;
    private List<CourseModel> prerequisite;

    public CourseInSyllabus() {
    }

    public CourseInSyllabus(CourseModel courseModel, 
            int offeringSemester, DepartmentModel offeringDept, 
            DepartmentModel acceptingDept, double hoursWeek, 
            List<CourseModel> prerequisite) {
        this.courseModel = courseModel;
        this.offeringSemester = offeringSemester;
        this.offeringDept = offeringDept;
        this.acceptingDept = acceptingDept;
        this.hoursWeek = hoursWeek;
        this.prerequisite = prerequisite;
    }

    

    public CourseModel getCourseModel() {
        return courseModel;
    }

    public void setCourseModel(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    public DepartmentModel getOfferingDept() {
        return offeringDept;
    }

    public void setOfferingDept(DepartmentModel offeringDept) {
        this.offeringDept = offeringDept;
    }

    public DepartmentModel getAcceptingDept() {
        return acceptingDept;
    }

    public void setAcceptingDept(DepartmentModel acceptingDept) {
        this.acceptingDept = acceptingDept;
    }

    public double getHoursWeek() {
        return hoursWeek;
    }

    public void setHoursWeek(double hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public List<CourseModel> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(List<CourseModel> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public int getOfferingSemester() {
        return offeringSemester;
    }

    public void setOfferingSemester(int offeringSemester) {
        this.offeringSemester = offeringSemester;
    }

   
}
