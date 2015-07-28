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
    private BatchInformation batchInformation;
    
    private int examSemester;
    private List<CourseReport> registeredCourseReports;

    private ResultNutShell ResultThisSemester;
    private ResultNutShell ResultUptoThisSemester;

    public SemesterResult() {
    }

    public SemesterResult(Student student, BatchInformation batchInformation, 
            int examSemester, List<CourseReport> registeredCourseReports, 
            ResultNutShell ResultThisSemester, ResultNutShell ResultUptoThisSemester) {
        this.student = student;
        this.batchInformation = batchInformation;
        this.examSemester = examSemester;
        this.registeredCourseReports = registeredCourseReports;
        this.ResultThisSemester = ResultThisSemester;
        this.ResultUptoThisSemester = ResultUptoThisSemester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BatchInformation getBatchInformation() {
        return batchInformation;
    }

    public void setBatchInformation(BatchInformation batchInformation) {
        this.batchInformation = batchInformation;
    }

    public int getExamSemester() {
        return examSemester;
    }

    public void setExamSemester(int examSemester) {
        this.examSemester = examSemester;
    }

    public List<CourseReport> getRegisteredCourseReports() {
        return registeredCourseReports;
    }

    public void setRegisteredCourseReports(List<CourseReport> registeredCourseReports) {
        this.registeredCourseReports = registeredCourseReports;
    }

    public ResultNutShell getResultThisSemester() {
        return ResultThisSemester;
    }

    public void setResultThisSemester(ResultNutShell ResultThisSemester) {
        this.ResultThisSemester = ResultThisSemester;
    }

    public ResultNutShell getResultUptoThisSemester() {
        return ResultUptoThisSemester;
    }

    public void setResultUptoThisSemester(ResultNutShell ResultUptoThisSemester) {
        this.ResultUptoThisSemester = ResultUptoThisSemester;
    }

   
}
