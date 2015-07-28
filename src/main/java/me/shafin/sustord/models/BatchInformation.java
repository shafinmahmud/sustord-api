/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class BatchInformation {
    
    private DepartmentModel department;
    private Program program;
    private String academicSession;
    private int totalAcademicSemester;
    private int maxAllowedSemester;

    public BatchInformation() {
    }

    public BatchInformation(DepartmentModel department, 
            Program program, String academicSession, 
            int totalAcademicSemester, int maxAllowedSemester) {
        this.department = department;
        this.program = program;
        this.academicSession = academicSession;
        this.totalAcademicSemester = totalAcademicSemester;
        this.maxAllowedSemester = maxAllowedSemester;
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

    public int getTotalAcademicSemester() {
        return totalAcademicSemester;
    }

    public void setTotalAcademicSemester(int totalAcademicSemester) {
        this.totalAcademicSemester = totalAcademicSemester;
    }

    public int getMaxAllowedSemester() {
        return maxAllowedSemester;
    }

    public void setMaxAllowedSemester(int maxAllowedSemester) {
        this.maxAllowedSemester = maxAllowedSemester;
    }
    
    
    
}
