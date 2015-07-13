/*
 */
package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */
@XmlRootElement
public class Student {

    private String registrationNo;
    private String name;

    public Student() {

    }

    public Student(String registrationNo, String name) {
        this.registrationNo = registrationNo;
        this.name = name;
    }

    /**
     * @return the registrationNo
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * @param registrationNo the registrationNo to set
     */
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentPojo{" + "registrationNo=" + registrationNo + ", name=" + name + '}';
    }

}
