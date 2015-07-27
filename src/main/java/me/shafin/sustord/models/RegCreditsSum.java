/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class RegCreditsSum {

    private CourseCount allCourseCount;
    private CourseCount regularCourseCount;
    private CourseCount irregularCourseCount;

    private CreditCount allCreditCount;
    private CreditCount regularCreditCount;
    private CreditCount irregularCreditCount;

    public RegCreditsSum() {
    }

    public RegCreditsSum(CourseCount regularCourseCount, CourseCount irreCourseCount,
            CreditCount regularCourseCredit, CreditCount irregularCourseCredit) {

        this.regularCourseCount = regularCourseCount;
        this.irregularCourseCount = irreCourseCount;
        this.allCourseCount = new CourseCount(regularCourseCount.getTheory() + irregularCourseCount.getTheory(),
                regularCourseCount.getLab() + irregularCourseCount.getLab());

        this.regularCreditCount = regularCourseCredit;
        this.irregularCreditCount = irregularCourseCredit;
        this.allCreditCount = new CreditCount(regularCourseCredit.getTheory() + irregularCourseCredit.getTheory(),
                regularCourseCredit.getLab() + irregularCourseCredit.getLab());
    }

    public RegCreditsSum(CourseCount allCourseCount, CourseCount regularCourseCount,
            CourseCount irregularCourseCount, CreditCount allCourseCredits,
            CreditCount regularCourseCredit, CreditCount irregularCourseCredit) {
        this.allCourseCount = allCourseCount;
        this.regularCourseCount = regularCourseCount;
        this.irregularCourseCount = irregularCourseCount;
        this.allCreditCount = allCourseCredits;
        this.regularCreditCount = regularCourseCredit;
        this.irregularCreditCount = irregularCourseCredit;
    }

    public CreditCount getAllCreditCount() {
        this.allCreditCount = new CreditCount(regularCreditCount.getTheory() + irregularCreditCount.getTheory(),
                regularCreditCount.getLab() + irregularCreditCount.getLab());
        return allCreditCount;
    }

    public void setAllCreditCount(CreditCount allCreditCount) {
        this.allCreditCount = allCreditCount;
    }

    public CreditCount getRegularCreditCount() {
        return regularCreditCount;
    }

    public void setRegularCreditCount(CreditCount regularCreditCount) {
        this.regularCreditCount = regularCreditCount;
    }

    public CreditCount getIrregularCreditCount() {
        return irregularCreditCount;
    }

    public void setIrregularCreditCount(CreditCount irregularCreditCount) {
        this.irregularCreditCount = irregularCreditCount;
    }

    public CourseCount getAllCourseCount() {
        this.allCourseCount =  new CourseCount(regularCourseCount.getTheory() + irregularCourseCount.getTheory(),
                regularCourseCount.getLab() + irregularCourseCount.getLab());
        return allCourseCount;
    }

    public void setAllCourseCount(CourseCount allCourseCount) {
        this.allCourseCount = allCourseCount;
    }

    public CourseCount getRegularCourseCount() {
        return regularCourseCount;
    }

    public void setRegularCourseCount(CourseCount regularCourseCount) {
        this.regularCourseCount = regularCourseCount;
    }

    public CourseCount getIrregularCourseCount() {
        return irregularCourseCount;
    }

    public void setIrregularCourseCount(CourseCount irregularCourseCount) {
        this.irregularCourseCount = irregularCourseCount;
    }

}
