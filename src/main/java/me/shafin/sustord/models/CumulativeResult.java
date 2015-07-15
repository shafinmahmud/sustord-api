/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class CumulativeResult {
    
    private CreditsSummation soFarRegisteredCreditsSummation;
    private CreditsSummation soFarCompletedCreditsSummation;
    
    private Grade CGPA;

    public CumulativeResult() {
    }

    public CumulativeResult(CreditsSummation soFarRegisteredCreditsSummation, 
            CreditsSummation soFarCompletedCreditsSummation, Grade CGPA) {
        this.soFarRegisteredCreditsSummation = soFarRegisteredCreditsSummation;
        this.soFarCompletedCreditsSummation = soFarCompletedCreditsSummation;
        this.CGPA = CGPA;
    }

    public CreditsSummation getSoFarRegisteredCreditsSummation() {
        return soFarRegisteredCreditsSummation;
    }

    public void setSoFarRegisteredCreditsSummation(CreditsSummation soFarRegisteredCreditsSummation) {
        this.soFarRegisteredCreditsSummation = soFarRegisteredCreditsSummation;
    }

    public CreditsSummation getSoFarCompletedCreditsSummation() {
        return soFarCompletedCreditsSummation;
    }

    public void setSoFarCompletedCreditsSummation(CreditsSummation soFarCompletedCreditsSummation) {
        this.soFarCompletedCreditsSummation = soFarCompletedCreditsSummation;
    }

    public Grade getCGPA() {
        return CGPA;
    }

    public void setCGPA(Grade CGPA) {
        this.CGPA = CGPA;
    }

   
}
