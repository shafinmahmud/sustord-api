package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentPersonal extends Student{
 
	private String fathersName;
	private String mothersName;
	private String email;
	private String phoneNo;
	
	
	public StudentPersonal() {
		super();
	}
	
	
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
