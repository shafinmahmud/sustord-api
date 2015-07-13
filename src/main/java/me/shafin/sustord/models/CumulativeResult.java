/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CumulativeResult {
    
    private double totalCreditsTakenSoFar;
    private double totalCreditsCompleteSoFar;
    
    private Grade CGPA;

    public CumulativeResult() {
    }

    public CumulativeResult(double totalCreditsTakenSoFar, double totalCreditsCompleteSoFar, Grade CGPA) {
        this.totalCreditsTakenSoFar = totalCreditsTakenSoFar;
        this.totalCreditsCompleteSoFar = totalCreditsCompleteSoFar;
        this.CGPA = CGPA;
    }

    public double getTotalCreditsTakenSoFar() {
        return totalCreditsTakenSoFar;
    }

    public void setTotalCreditsTakenSoFar(double totalCreditsTakenSoFar) {
        this.totalCreditsTakenSoFar = totalCreditsTakenSoFar;
    }

    public double getTotalCreditsCompleteSoFar() {
        return totalCreditsCompleteSoFar;
    }

    public void setTotalCreditsCompleteSoFar(double totalCreditsCompleteSoFar) {
        this.totalCreditsCompleteSoFar = totalCreditsCompleteSoFar;
    }

    public Grade getCGPA() {
        return CGPA;
    }

    public void setCGPA(Grade CGPA) {
        this.CGPA = CGPA;
    }
    
}
