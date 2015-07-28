/*
 */
package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */

@XmlRootElement
public class CumulativeResult {
    
    private Student student;
    private BatchInformation batchInformation;
    private CurriCreditsSum offeredCourse;
    private ResultNutShell resultSummary;

    public CumulativeResult() {
    }

    public CumulativeResult(Student student, 
            BatchInformation batchInformation, 
            CurriCreditsSum offeredCourse, 
            ResultNutShell resultSummary) {
        this.student = student;
        this.batchInformation = batchInformation;
        this.offeredCourse = offeredCourse;
        this.resultSummary = resultSummary;
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

    public CurriCreditsSum getOfferedCourse() {
        return offeredCourse;
    }

    public void setOfferedCourse(CurriCreditsSum offeredCourse) {
        this.offeredCourse = offeredCourse;
    }

    public ResultNutShell getResultSummary() {
        return resultSummary;
    }

    public void setResultSummary(ResultNutShell resultSummary) {
        this.resultSummary = resultSummary;
    }

    
}
