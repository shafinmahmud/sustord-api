/*
 */
package me.shafin.sustord.models;

import java.util.List;

/**
 *
 * @author SHAFIN
 */
public class SyllabusModel {
    
    private DepartmentModel department;
    private Program program;
    private String academicSession;
    private int semester;
    private List<CourseInSyllabus> courses;
    private CreditsSummation curriculumCreditSummation;

    public SyllabusModel() {
    }

    public SyllabusModel(DepartmentModel department, Program program, 
            String academicSession, int semester, List<CourseInSyllabus> courses, 
            CreditsSummation creditsSummation) {
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.semester = semester;
        this.courses = courses;
        this.curriculumCreditSummation = creditsSummation;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<CourseInSyllabus> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInSyllabus> courses) {
        this.courses = courses;
    }

    public CreditsSummation getCurriculumCreditSummation() {
        return curriculumCreditSummation;
    }

    public void setCurriculumCreditSummation(CreditsSummation curriculumCreditSummation) {
        this.curriculumCreditSummation = curriculumCreditSummation;
    }
    
    
}
