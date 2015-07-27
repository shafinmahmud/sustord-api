/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CourseCount {
    
    private int theory;
    private int lab;
    private int total;

    public CourseCount() {
    }

    public CourseCount(int theory, int lab) {
        this.theory = theory;
        this.lab = lab;
        this.total = theory + lab;
    }

    
    public CourseCount(int theory, int lab, int total) {
        this.theory = theory;
        this.lab = lab;
        this.total = total;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
