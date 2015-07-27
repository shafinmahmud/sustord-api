/*
 */
package me.shafin.sustord.helpers;

import java.sql.SQLException;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.models.BatchInformation;
import me.shafin.sustord.models.Student;
import me.shafin.sustord.services.AcademicInfoService;
import me.shafin.sustord.services.PersonalInfoService;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class BasicInfoHelper {
    
    public static Student getStudent(StudentInfo studentInfo) throws HibernateException, SQLException{
        //setting Student
        String registrationNo = studentInfo.getRegistrationNo();
        String name = new PersonalInfoService(registrationNo).getStudentName();
        Student student = new Student(registrationNo, name);
        return student;
    }
    
    public static BatchInformation getBatchInformation(StudentInfo studentInfo) 
            throws HibernateException, SQLException{
        
        BatchInformation batchInformation = new BatchInformation();

        //setting Academic Information
        AcademicInfoService academicService = new AcademicInfoService(studentInfo.getRegistrationNo());
        batchInformation.setDepartment(academicService.getDepartment());//setting department       
        batchInformation.setProgram(academicService.getProgram());//setting program     
        batchInformation.setAcademicSession(academicService.getStudentAcademicSession());//setting academicSession  
        batchInformation.setTotalAcademicSemester(academicService.getTotalAcadmicSemester());
        batchInformation.setMaxAllowedSemester(academicService.getMaxAcademicSemester());
        
        return batchInformation;
    }
}
