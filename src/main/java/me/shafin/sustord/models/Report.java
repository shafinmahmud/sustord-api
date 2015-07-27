/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class Report {
    
    private String registrationStatus;
    private int attendedSemester;
    private int attendedYear;
    private Grade grade;

    public Report() {
    }

    public Report(String registrationStatus, int attendedSemester, int attendedYear, Grade grade) {
        this.registrationStatus = registrationStatus;
        this.attendedSemester = attendedSemester;
        this.attendedYear = attendedYear;
        this.grade = grade;
    }

    
    public int getAttendedSemester() {
        return attendedSemester;
    }

    public void setAttendedSemester(int attendedSemester) {
        this.attendedSemester = attendedSemester;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getAttendedYear() {
        return attendedYear;
    }

    public void setAttendedYear(int attendedYear) {
        this.attendedYear = attendedYear;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
    
    
}
