/*
 */
package me.shafin.sustord.services;

import me.shafin.sustord.dao.StudentInfoDao;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.utilities.ServiceDispatcher;

/**
 *
 * @author SHAFIN
 */
public class StudentIdentityService {
    public final StudentInfo studentInfo;

    /* Constructor thats is private and get accesses through static helper method  */
    public StudentIdentityService(StudentInfo studentInfo) throws Exception {
        this.studentInfo = studentInfo;
    }

    /* Constructor helper for singleton AcademicInfoService  */
    public static StudentInfo forSingletonIdentityService(String registrationNo) throws Exception {
        return ServiceDispatcher.getSingletonStudentInfo(registrationNo);
    }

    /* Constructor helper for prototype AcademicInfoService  */
    public static StudentInfo forProtypeIdentityService(String registrationNo) throws Exception {
        return StudentInfoDao.getStudentInfoObject(registrationNo);
    }
    
}
