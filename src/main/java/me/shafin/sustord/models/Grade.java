/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class Grade {

    private String gradeLetter;
    private double gradePoint;

    public Grade() {
    }

    public Grade(String gradeLetter) {
        this.gradeLetter = gradeLetter;
        this.gradePoint = getEquivalentGradePoint(gradeLetter);
    }

    public Grade(double gradePoint) {
        this.gradePoint = gradePoint;
        this.gradeLetter = getEquivalentGradeLetter(gradePoint);
    }

    
    public Grade(String gradeLetter, double gradePoint) {
        this.gradeLetter = gradeLetter;
        this.gradePoint = gradePoint;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
        this.gradePoint = getEquivalentGradePoint(gradeLetter);
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
        this.gradeLetter = getEquivalentGradeLetter(gradePoint);
    }

    private static double getEquivalentGradePoint(String gradeLetter) {
        
        if(gradeLetter == null){
            return 0.00;
        }
        
        switch (gradeLetter) {
            case "A+":
                return 4.00;
            case "A":
                return 3.75;
            case "A-":
                return 3.50;
            case "B+":
                return 3.25;
            case "B":
                return 3.00;
            case "B-":
                return 2.75;
            case "C+":
                return 2.50;
            case "C":
                return 2.25;
            case "C-":
                return 2.00;
            case "F":
                return 0.00;
            default:
                return 0.00;

        }
    }
        
    
    private static String getEquivalentGradeLetter(double point) {

        if (point == 4) {
            return "A+";
        } else if (point >= 3.75 && point < 4) {
            return "A";
        } else if (point >= 3.5 && point < 3.75) {
            return "A-";
        } else if (point >= 3.25 && point < 3.5) {
            return "B+";
        } else if (point >= 3 && point < 3.25) {
            return "B";
        } else if (point >= 2.75 && point < 3) {
            return "B-";
        } else if (point >= 2.5 && point < 2.75) {
            return "C+";
        } else if (point >= 2.25 && point < 2.5) {
            return "C";
        } else if (point >= 2 && point < 2.25) {
            return "C-";
        } else if (point >= 0 && point < 2) {
            return "F";
        } else {
            return "N/A";
        }
    }
}
