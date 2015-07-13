/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class Result {
    
    private int attendedSemester;
    private Grade grade;

    public Result() {
    }

    
    public Result(int attendedSemester, Grade grade) {
        this.attendedSemester = attendedSemester;
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
    
    
}
