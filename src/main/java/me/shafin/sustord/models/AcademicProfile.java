/*
 */
package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */
@XmlRootElement
public class AcademicProfile {

    private Student student;
    private BatchInformation batchInformation;
    
    private int currentAcademicSemester;
    private ResultNutShell academicReport;

    public AcademicProfile() {

    }

    public AcademicProfile(Student student, BatchInformation batchInformation, 
            int currentAcademicSemester, ResultNutShell academicReport) {
        this.student = student;
        this.batchInformation = batchInformation;
        this.currentAcademicSemester = currentAcademicSemester;
        this.academicReport = academicReport;
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

    public int getCurrentAcademicSemester() {
        return currentAcademicSemester;
    }

    public void setCurrentAcademicSemester(int currentAcademicSemester) {
        this.currentAcademicSemester = currentAcademicSemester;
    }

    public ResultNutShell getAcademicReport() {
        return academicReport;
    }

    public void setAcademicReport(ResultNutShell academicReport) {
        this.academicReport = academicReport;
    }
    
    
}
