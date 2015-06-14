/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class StudentAcademic extends Student{
	
	public String departmentName;
    public String academicBatch;
    
    
    public StudentAcademic() {
		super();
	}
    
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getAcademicBatch() {
		return academicBatch;
	}
	public void setAcademicBatch(String academicBatch) {
		this.academicBatch = academicBatch;
	}
	
}
