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

    private DepartmentModel department;
    private Program program;
    private String academicSession;

    private int examSemester;
    private List<CourseResult> registeredCourseResults;

    private ResultSum semesterResult;
    private ResultSum cumulativeResult;

    public SemesterResult() {
    }

    public SemesterResult(Student student, DepartmentModel department, 
            Program program, String academicSession, int examSemester, 
            List<CourseResult> registeredCourseResults, 
            ResultSum semesterResult, ResultSum cumulativeResult) {
        this.student = student;
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.examSemester = examSemester;
        this.registeredCourseResults = registeredCourseResults;
        this.semesterResult = semesterResult;
        this.cumulativeResult = cumulativeResult;
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

    public int getExamSemester() {
        return examSemester;
    }

    public void setExamSemester(int examSemester) {
        this.examSemester = examSemester;
    }

    public List<CourseResult> getRegisteredCourseResults() {
        return registeredCourseResults;
    }

    public void setRegisteredCourseResults(List<CourseResult> registeredCourseResults) {
        this.registeredCourseResults = registeredCourseResults;
    }

    public ResultSum getSemesterResult() {
        return semesterResult;
    }

    public void setSemesterResult(ResultSum semesterResult) {
        this.semesterResult = semesterResult;
    }

    public ResultSum getCumulativeResult() {
        return cumulativeResult;
    }

    public void setCumulativeResult(ResultSum cumulativeResult) {
        this.cumulativeResult = cumulativeResult;
    }

    
}
