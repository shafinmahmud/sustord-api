/*
 */
package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */
@XmlRootElement
public class AcademicProfile extends Student {

    private DepartmentModel department;
    private Program program;
    private String academicSession;
    private int totalAcademicSemester;
    private int maxAcademicSemester;
    private int currentAcademicSemester;
    private int totalCourses;
    private int coursesCompleted;
    private double totalCredits;
    private double creditsCompleted;
    private double currentCgpa;

    public AcademicProfile() {

    }

    public AcademicProfile(String registrationNo, String name) {
        super(registrationNo, name);
    }

    public AcademicProfile(DepartmentModel department, Program program, 
            String academicSession, int totalAcademicSemester, 
            int maxAcademicSemester, int currentAcademicSemester, 
            int totalCourses, int coursesCompleted, double totalCredits, 
            double creditsCompleted, double currentCgpa, 
            String registrationNo, String name) {
        super(registrationNo, name);
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.totalAcademicSemester = totalAcademicSemester;
        this.maxAcademicSemester = maxAcademicSemester;
        this.currentAcademicSemester = currentAcademicSemester;
        this.totalCourses = totalCourses;
        this.coursesCompleted = coursesCompleted;
        this.totalCredits = totalCredits;
        this.creditsCompleted = creditsCompleted;
        this.currentCgpa = currentCgpa;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getAcademicSession() {
        return academicSession;
    }

    public void setAcademicSession(String academicSession) {
        this.academicSession = academicSession;
    }

    public int getTotalAcademicSemester() {
        return totalAcademicSemester;
    }

    public void setTotalAcademicSemester(int totalAcademicSemester) {
        this.totalAcademicSemester = totalAcademicSemester;
    }

    public int getMaxAcademicSemester() {
        return maxAcademicSemester;
    }

    public void setMaxAcademicSemester(int maxAcademicSemester) {
        this.maxAcademicSemester = maxAcademicSemester;
    }

    public int getCurrentAcademicSemester() {
        return currentAcademicSemester;
    }

    public void setCurrentAcademicSemester(int currentAcademicSemester) {
        this.currentAcademicSemester = currentAcademicSemester;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

    public int getCoursesCompleted() {
        return coursesCompleted;
    }

    public void setCoursesCompleted(int coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public double getCreditsCompleted() {
        return creditsCompleted;
    }

    public void setCreditsCompleted(double creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
    }

    public double getCurrentCgpa() {
        return currentCgpa;
    }

    public void setCurrentCgpa(double currentCgpa) {
        this.currentCgpa = currentCgpa;
    }

    
}
