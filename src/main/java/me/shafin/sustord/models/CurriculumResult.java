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
    private BatchInformation batchInformation;
    
    private int curriculumSemester;
    private List<CourseReport> attendedCourseResults;
    private CurriCreditsSum offeredCreditsSum;
    private CurriCreditsSum completedCreditsSum;

    public CurriculumResult() {
    }

    public CurriculumResult(Student student, BatchInformation batchInformation, 
            int curriculumSemester, List<CourseReport> attendedCourseResults, 
            CurriCreditsSum offeredCreditsSum, CurriCreditsSum completedCreditsSum) {
        this.student = student;
        this.batchInformation = batchInformation;
        this.curriculumSemester = curriculumSemester;
        this.attendedCourseResults = attendedCourseResults;
        this.offeredCreditsSum = offeredCreditsSum;
        this.completedCreditsSum = completedCreditsSum;
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

    public int getCurriculumSemester() {
        return curriculumSemester;
    }

    public void setCurriculumSemester(int curriculumSemester) {
        this.curriculumSemester = curriculumSemester;
    }

    public List<CourseReport> getAttendedCourseResults() {
        return attendedCourseResults;
    }

    public void setAttendedCourseResults(List<CourseReport> attendedCourseResults) {
        this.attendedCourseResults = attendedCourseResults;
    }

    public CurriCreditsSum getOfferedCreditsSum() {
        return offeredCreditsSum;
    }

    public void setOfferedCreditsSum(CurriCreditsSum offeredCreditsSum) {
        this.offeredCreditsSum = offeredCreditsSum;
    }

    public CurriCreditsSum getCompletedCreditsSum() {
        return completedCreditsSum;
    }

    public void setCompletedCreditsSum(CurriCreditsSum completedCreditsSum) {
        this.completedCreditsSum = completedCreditsSum;
    }

    
}
