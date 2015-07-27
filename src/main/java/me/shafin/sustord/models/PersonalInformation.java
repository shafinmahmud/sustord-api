/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class PersonalInformation {

    private String fathersName;
    private String mothersName;
    private String email;
    private String phoneNo;
    private String PresentAddress;
    private String PermanentAddress;
    private String dob;
    private String sex;
    private String religion;
    private String nationality;
    private String maritalStatus;
    private String bloodGroup;
    private String photoUrl;

    public PersonalInformation() {
    }

    public PersonalInformation(String fathersName, String mothersName, 
            String email, String phoneNo, String PresentAddress, 
            String PermanentAddress, String dob, String sex, 
            String religion, String nationality, 
            String maritalStatus, String bloodGroup, 
            String photoUrl) {
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.PresentAddress = PresentAddress;
        this.PermanentAddress = PermanentAddress;
        this.dob = dob;
        this.sex = sex;
        this.religion = religion;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.bloodGroup = bloodGroup;
        this.photoUrl = photoUrl;
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

    public String getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(String PresentAddress) {
        this.PresentAddress = PresentAddress;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String PermanentAddress) {
        this.PermanentAddress = PermanentAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    
}
