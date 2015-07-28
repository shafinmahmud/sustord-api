/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import me.shafin.sustord.dao.CourseRegistrationDao;
import me.shafin.sustord.helpers.BasicInfoHelper;
import me.shafin.sustord.models.AcademicProfile;
import me.shafin.sustord.models.DepartmentModel;
import me.shafin.sustord.models.Program;
import me.shafin.sustord.models.ResultNutShell;
import me.shafin.sustord.utilities.ModelConstants;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class AcademicInfoService extends StudentIdentityService {
    
    public AcademicInfoService(String registrationNo) throws HibernateException, 
            NullPointerException, SQLException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }

    /* Academic Information  */
    public String getStudentSchoolName() {
        return studentInfo.getStudentBatchIdFk()
                .getDegreeOfferedIdFk().getDeptIdFk()
                .getSchoolIdFk().getSchoolName();
    }
    
    public String getStudentDepartmentName() {
        return studentInfo.getStudentBatchIdFk()
                .getDegreeOfferedIdFk().getDeptIdFk().getDeptName();
    }
    
    public DepartmentModel getDepartment() {
        String deptCode = this.studentInfo.getStudentBatchIdFk()
                                          .getDegreeOfferedIdFk().getDeptIdFk().getDeptCode();
        String deptName = this.getStudentDepartmentName();
        String school = this.getStudentSchoolName();
        return new DepartmentModel(deptCode, deptName, school);
    }
    
    public String getStudentDegreeType() {
        String degreeType = studentInfo.getStudentBatchIdFk().getDegreeOfferedIdFk()
                                                             .getDegreeIdFk().getDegreeTypeName();
        return degreeType;
    }
    
    public String getStudentDegreeCategory() {
        String degreeCategory = studentInfo.getStudentBatchIdFk()
                                           .getDegreeOfferedIdFk().getDegreeIdFk().getDegreeCategory();
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
        return studentInfo.getStudentBatchIdFk()
                .getDegreeOfferedIdFk().getDegreeIdFk().getTotalSemester();
    }
    
    public int getMaxAcademicSemester() {
        return studentInfo.getStudentBatchIdFk().getMaxSemester();
    }
    
    public int getCurrentAcademicSemester() throws SQLException {
        return CourseRegistrationDao.getMaxRegistrationSemester(this.studentInfo);
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
    
    public AcademicProfile getAcademicProfile() throws HibernateException, SQLException {
        AcademicProfile academic = new AcademicProfile();
        
        academic.setStudent(BasicInfoHelper.getStudent(this.studentInfo));
        academic.setBatchInformation(BasicInfoHelper.getBatchInformation(this.studentInfo));
        
        academic.setCurrentAcademicSemester(getCurrentAcademicSemester());
        
        SemesterResultService resultService = new SemesterResultService(this.studentInfo.getRegistrationNo());
        ResultNutShell nutShell = resultService.getResultNutShell(0, ModelConstants.CUMULATIVE);
        academic.setAcademicReport(nutShell);
        
        return academic;
    }
}
