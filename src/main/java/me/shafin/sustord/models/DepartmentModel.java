/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class DepartmentModel {
    private String departmentCode;
    private String departmentName;
    private String schoolName;

    public DepartmentModel() {
    }

    
    public DepartmentModel(String departmentCode, String departmentName, String schoolName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.schoolName = schoolName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
    
}
