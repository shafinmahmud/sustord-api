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
public class SemesterResult {
    
    private Student student;
    
    private Department department;
    private Program program;
    private String academicSession;
    
    private int examSemester;
    private List<CourseResult> courseResults;
    private double totalCreditsTaken;
    private double totalCreditsCompleted;
    
    private Grade semesterGPA;
    private CumulativeResult cumulativeResult;

    public SemesterResult() {
    }

    public SemesterResult(Student student, Department department, 
            Program program, String academicSession, int semester, 
            List<CourseResult> courseResults, double totalCreditsTaken, 
            double totalCreditsCompleted, Grade semesterGPA, 
            CumulativeResult cumulativeResult) {
        this.student = student;
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.examSemester = semester;
        this.courseResults = courseResults;
        this.totalCreditsTaken = totalCreditsTaken;
        this.totalCreditsCompleted = totalCreditsCompleted;
        this.semesterGPA = semesterGPA;
        this.cumulativeResult = cumulativeResult;
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

    public int getExamSemester() {
        return examSemester;
    }

    public void setExamSemester(int examSemester) {
        this.examSemester = examSemester;
    }

    public List<CourseResult> getCourseResults() {
        return courseResults;
    }

    public void setCourseResults(List<CourseResult> courseResults) {
        this.courseResults = courseResults;
    }

    public double getTotalCreditsTaken() {
        return totalCreditsTaken;
    }

    public void setTotalCreditsTaken(double totalCreditsTaken) {
        this.totalCreditsTaken = totalCreditsTaken;
    }

    public double getTotalCreditsCompleted() {
        return totalCreditsCompleted;
    }

    public void setTotalCreditsCompleted(double totalCreditsCompleted) {
        this.totalCreditsCompleted = totalCreditsCompleted;
    }

    public Grade getSemesterGPA() {
        return semesterGPA;
    }

    public void setSemesterGPA(Grade semesterGPA) {
        this.semesterGPA = semesterGPA;
    }

    public CumulativeResult getCumulativeResult() {
        return cumulativeResult;
    }

    public void setCumulativeResult(CumulativeResult cumulativeResult) {
        this.cumulativeResult = cumulativeResult;
    }
    
    
}
