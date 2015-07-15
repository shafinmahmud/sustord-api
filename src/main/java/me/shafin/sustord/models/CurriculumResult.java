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
    
    private DepartmentModel department;
    private Program program;
    private String academicSession;
    
    private int curriculumSemester;
    private List<CourseResult> courseResults;
    private CreditsSummation completedCreditsSummation;

    public CurriculumResult() {
    }

    public CurriculumResult(Student student, DepartmentModel department, 
            Program program, String academicSession, int curriculumSemester, 
            List<CourseResult> courseResults, CreditsSummation completedCreditsSummation) {
        this.student = student;
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.curriculumSemester = curriculumSemester;
        this.courseResults = courseResults;
        this.completedCreditsSummation = completedCreditsSummation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public CreditsSummation getCompletedCreditsSummation() {
        return completedCreditsSummation;
    }

    public void setCompletedCreditsSummation(CreditsSummation completedCreditsSummation) {
        this.completedCreditsSummation = completedCreditsSummation;
    }

}
