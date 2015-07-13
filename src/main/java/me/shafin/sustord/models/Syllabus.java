/*
 */
package me.shafin.sustord.models;

import java.util.List;

/**
 *
 * @author SHAFIN
 */
public class Syllabus {
    
    private Department department;
    private Program program;
    private String academicSession;
    private int semester;
    private List<CourseInSyllabus> courses;

    public Syllabus() {
    }

    public Syllabus(Department department, Program program, 
            String academicSession, int semester, 
            List<CourseInSyllabus> courses) {
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.semester = semester;
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
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
    
    
}
