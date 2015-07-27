/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.shafin.sustord.dao.PersonalInfoDao;
import me.shafin.sustord.models.PersonalInformation;
import me.shafin.sustord.models.PersonalProfile;
import me.shafin.sustord.models.Student;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class PersonalInfoService extends StudentIdentityService {

    private static final String NULL_RESPONSE = "";
    private static final String ERROR_RESPONSE = "500 Server Error";

    /* Constructor thats is private and get accesses through static helper method  */
    public PersonalInfoService(String registrationNo) throws HibernateException,
            SQLException, NullPointerException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }

    /* Personal Information  */
    public String getStudentName() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getName();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getFatherName() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getFathersName();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getMotherName() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getMothersName();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getPresentAddress() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getPresentAddress();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getPermanentAddress() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getPermanentAddress();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getPhone() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getContact();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getEmail() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getEmail();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getDob() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getDateOfBirth();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getSex() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getSex();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getReligion() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getReligion();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getNationality() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getNationality();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getMaritalStatus() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getMaritalStatus();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getBloodGroup() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getBloodGroup();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public String getStudentPhotoUrl() {
        try {
            String string = PersonalInfoDao.getPersonalInfoObject(studentInfo.getStudentInfoId()).getPhotoUrl();
            if (string == null) {
                return NULL_RESPONSE;
            } else {
                return string;
            }
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(PersonalInfoService.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_RESPONSE;
        }
    }

    public PersonalProfile getPersonalInfo() {
        Student student = new Student();
        student.setRegistrationNo(this.studentInfo.getRegistrationNo());
        student.setName(this.getStudentName());

        PersonalInformation personal = new PersonalInformation();
        personal.setFathersName(this.getFatherName());
        personal.setMothersName(this.getMotherName());
        personal.setEmail(this.getEmail());
        personal.setPhoneNo(this.getPhone());
        personal.setPresentAddress(this.getPresentAddress());
        personal.setPermanentAddress(this.getPermanentAddress());
        personal.setDob(this.getDob());
        personal.setSex(this.getSex());
        personal.setBloodGroup(this.getBloodGroup());
        personal.setNationality(this.getNationality());
        personal.setReligion(this.getReligion());
        personal.setMaritalStatus(this.getMaritalStatus());
        personal.setPhotoUrl(this.getStudentPhotoUrl());

        return new PersonalProfile(student, personal);
    }

}
