/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class Program {
    private String degreeType;
    private String degreeCategory;
    private String programName;

    public Program() {
    }

    public Program(String degreeType, String degreeCategory) {
        this.degreeType = degreeType;
        this.degreeCategory = degreeCategory;
        this.programName = degreeType+"("+degreeCategory+")";
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeCategory() {
        return degreeCategory;
    }

    public void setDegreeCategory(String degreeCategory) {
        this.degreeCategory = degreeCategory;
    }

    public String getProgramName() {
        return programName;
    }
     
}
