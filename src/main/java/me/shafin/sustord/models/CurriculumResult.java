/*
 */
package me.shafin.sustord.models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */

@XmlRootElement
public class CurriculumResult {
    
    private Student student;
    
    private Department department;
    private Program program;
    private String academicSession;
    
    private int curriculumSemester;
    private List<CourseResult> courseResults;
    private double totalCreditsInCurriculum;
    private double totalCreditsCompleted;

    public CurriculumResult() {
    }

    public CurriculumResult(Student student, Department department, 
            Program program, String academicSession, 
            int semester, List<CourseResult> courseResults, 
            double totalCreditInCurriculum, double totalCreditCompleted) {
        this.student = student;
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.curriculumSemester = semester;
        this.courseResults = courseResults;
        this.totalCreditsInCurriculum = totalCreditInCurriculum;
        this.totalCreditsCompleted = totalCreditCompleted;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public int getCurriculumSemester() {
        return curriculumSemester;
    }

    public void setCurriculumSemester(int curriculumSemester) {
        this.curriculumSemester = curriculumSemester;
    }

    public List<CourseResult> getCourseResults() {
        return courseResults;
    }

    public void setCourseResults(List<CourseResult> courseResults) {
        this.courseResults = courseResults;
    }

    public double getTotalCreditsInCurriculum() {
        return totalCreditsInCurriculum;
    }

    public void setTotalCreditsInCurriculum(double totalCreditsInCurriculum) {
        this.totalCreditsInCurriculum = totalCreditsInCurriculum;
    }

    public double getTotalCreditsCompleted() {
        return totalCreditsCompleted;
    }

    public void setTotalCreditsCompleted(double totalCreditsCompleted) {
        this.totalCreditsCompleted = totalCreditsCompleted;
    } 
    
}
