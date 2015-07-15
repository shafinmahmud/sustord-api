
/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CreditsSummation {
    private double totalCredits;
    private double totalTheoryCredits;
    private double totalLabCredits;
    private double totalTheoryHrsWeek;
    private double totalLabHrsWeek;

    public CreditsSummation() {
    }

    public CreditsSummation(double totalCredits, double totalTheoryCredits, double totalLabCredits) {
        this.totalCredits = totalCredits;
        this.totalTheoryCredits = totalTheoryCredits;
        this.totalLabCredits = totalLabCredits;
    }

    
    public CreditsSummation(double totalCredits, 
            double totalTheoryCredits, double totalLabCredits, 
            double totalTheoryHrsWeek, double totalLabHrsWeek) {
        this.totalCredits = totalCredits;
        this.totalTheoryCredits = totalTheoryCredits;
        this.totalLabCredits = totalLabCredits;
        this.totalTheoryHrsWeek = totalTheoryHrsWeek;
        this.totalLabHrsWeek = totalLabHrsWeek;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public double getTotalTheoryCredits() {
        return totalTheoryCredits;
    }

    public void setTotalTheoryCredits(double totalTheoryCredits) {
        this.totalTheoryCredits = totalTheoryCredits;
    }

    public double getTotalLabCredits() {
        return totalLabCredits;
    }

    public void setTotalLabCredits(double totalLabCredits) {
        this.totalLabCredits = totalLabCredits;
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
