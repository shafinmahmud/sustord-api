package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonalProfile{
 
        private Student student;
	private PersonalInformation personalInformation;

    public PersonalProfile() {
    }

    public PersonalProfile(Student student, PersonalInformation personalInformation) {
        this.student = student;
        this.personalInformation = personalInformation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

}
