/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CreditCount {
    
    private double theory;
    private double lab;
    private double total;

    public CreditCount() {
    }

    public CreditCount(double theory, double lab) {
        this.theory = theory;
        this.lab = lab;
        this.total = theory + lab;
    }

    
    public CreditCount(double theory, double lab, double total) {
        this.theory = theory;
        this.lab = lab;
        this.total = total;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getLab() {
        return lab;
    }

    public void setLab(double lab) {
        this.lab = lab;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
