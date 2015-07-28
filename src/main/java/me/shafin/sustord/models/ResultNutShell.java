/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class ResultNutShell {
    
    private RegCreditsSum registeredCourse;
    private RegCreditsSum completedCourse;
    private Grade allCourseGPA;
    private Grade regularCourseGPA;

    public ResultNutShell() {
    }

    public ResultNutShell(RegCreditsSum registeredCredits, 
            RegCreditsSum completedCredits, Grade allCourseGPA, 
            Grade regularCourseGPA) {
        this.registeredCourse = registeredCredits;
        this.completedCourse = completedCredits;
        this.allCourseGPA = allCourseGPA;
        this.regularCourseGPA = regularCourseGPA;
    }  

    public RegCreditsSum getRegisteredCourse() {
        return registeredCourse;
    }

    public void setRegisteredCourse(RegCreditsSum registeredCourse) {
        this.registeredCourse = registeredCourse;
    }

    public RegCreditsSum getCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(RegCreditsSum completedCourse) {
        this.completedCourse = completedCourse;
    }

    public Grade getAllCourseGPA() {
        return allCourseGPA;
    }

    public void setAllCourseGPA(Grade allCourseGPA) {
        this.allCourseGPA = allCourseGPA;
    }

    public Grade getRegularCourseGPA() {
        return regularCourseGPA;
    }

    public void setRegularCourseGPA(Grade regularCourseGPA) {
        this.regularCourseGPA = regularCourseGPA;
    }

    
}
