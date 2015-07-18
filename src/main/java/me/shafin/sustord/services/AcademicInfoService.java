/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import me.shafin.sustord.models.AcademicProfile;
import me.shafin.sustord.models.DepartmentModel;
import me.shafin.sustord.models.Program;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class AcademicInfoService extends StudentIdentityService {
    
    public AcademicInfoService(String registrationNo) throws HibernateException, NullPointerException, SQLException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }

    /* Academic Information  */
    public String getStudentSchoolName() {
        return studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDeptIdFk().getSchoolIdFk().getSchoolName();
    }
    
    public String getStudentDepartmentName() {
        return studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDeptIdFk().getDeptName();
    }
    
    public DepartmentModel getDepartment() {
        String deptCode = this.studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDeptIdFk().getDeptCode();
        String deptName = this.getStudentDepartmentName();
        String school = this.getStudentSchoolName();
        return new DepartmentModel(deptCode, deptName, school);
    }
    
    public String getStudentDegreeType() {
        String degreeType = studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDegreeIdFk().getDegreeTypeName();
        return degreeType;
    }
    
    public String getStudentDegreeCategory() {
        String degreeCategory = studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDegreeIdFk().getDegreeCategory();
        return degreeCategory;
    }
    
    public String getStudentProgramName() {
        String programName = getStudentDegreeType() + " (" + getStudentDegreeCategory() + ")";
        return programName;
    }
    
    public Program getProgram() {
        return new Program(this.getStudentDegreeType(), this.getStudentDegreeCategory());
    }
    
    public String getStudentAcademicSession() {
        return studentInfo.getStudentBatchIdFk().getSession();
    }
    
    public int getTotalAcadmicSemester() {
        return studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk().getDegreeIdFk().getTotalSemester();
    }
    
    public int getMaxAcademicSemester() {
        return studentInfo.getStudentBatchIdFk().getMaxSemester();
    }
    
    public int getCurrentAcademicSemester() {
        return 7; // need to call another service class to get computed this value;
    }
    
    public int getTotalCourses() {
        return 72; //need to compute the value from syllabus service call
    }
    
    public int getCoursesCompleted() {
        return 56; // need computation
    }
    
    public double getTotalCredits() {
        return 160.0; //attention
    }
    
    public double getCreditsCompleted() {
        return 102.5;//attention
    }
    
    public double getCurrentCgpa() {
        return 3.60;// attention
    }
    
    public AcademicProfile getAllAcademicInfo() {
        AcademicProfile academic = new AcademicProfile(this.studentInfo.getRegistrationNo(),
                this.studentInfo.getPersonalInfo().getName());
        academic.setDepartment(this.getDepartment());
        academic.setProgram(this.getProgram());
        academic.setMaxAcademicSemester(this.getMaxAcademicSemester());
        academic.setTotalAcademicSemester(this.getTotalAcadmicSemester());
        academic.setCurrentAcademicSemester(this.getCurrentAcademicSemester());
        academic.setAcademicSession(this.getStudentAcademicSession());
        academic.setTotalCourses(this.getTotalCourses());
        academic.setCoursesCompleted(this.getCoursesCompleted());
        academic.setTotalCredits(this.getTotalCredits());
        academic.setCreditsCompleted(this.getCreditsCompleted());
        academic.setCurrentCgpa(this.getCurrentCgpa());
        
        return academic;
    }
}
