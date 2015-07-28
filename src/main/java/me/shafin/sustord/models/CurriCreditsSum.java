
/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CurriCreditsSum {
    private CourseCount courseCount;
    private CreditCount creditCount;
    private double totalTheoryHrsWeek;
    private double totalLabHrsWeek;

    public CurriCreditsSum() {
    }

    
    public CurriCreditsSum(CourseCount courseCount, CreditCount creditCount, 
            double totalTheoryHrsWeek, double totalLabHrsWeek) {
        this.courseCount = courseCount;
        this.creditCount = creditCount;
        this.totalTheoryHrsWeek = totalTheoryHrsWeek;
        this.totalLabHrsWeek = totalLabHrsWeek;
    }

    public CourseCount getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(CourseCount courseCount) {
        this.courseCount = courseCount;
    }

    public CreditCount getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(CreditCount creditCount) {
        this.creditCount = creditCount;
    }

    public double getTotalTheoryHrsWeek() {
        return totalTheoryHrsWeek;
    }

    public void setTotalTheoryHrsWeek(double totalTheoryHrsWeek) {
        this.totalTheoryHrsWeek = totalTheoryHrsWeek;
    }

    public double getTotalLabHrsWeek() {
        return totalLabHrsWeek;
    }

    public void setTotalLabHrsWeek(double totalLabHrsWeek) {
        this.totalLabHrsWeek = totalLabHrsWeek;
    }


}
