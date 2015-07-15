/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.dao.CourseRegistrationDao;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseResult;
import me.shafin.sustord.models.CreditsSummation;
import me.shafin.sustord.models.CurriculumResult;
import me.shafin.sustord.models.Grade;
import me.shafin.sustord.models.Result;
import me.shafin.sustord.models.SemesterResult;
import me.shafin.sustord.models.Student;
import me.shafin.sustord.utilities.ModelConstants;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class ResultService extends StudentIdentityService {
    
    private static final String NULL_RESPONSE = "null";
    private static final String ERROR_RESPONSE = "500 Server Error";

    /* Constructor thats is private and get accesses through static helper method  */
    public ResultService(String registrationNo) throws HibernateException,
            SQLException, NullPointerException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }
    
    public CurriculumResult getCurriculumResult(int semester) throws HibernateException,
            SQLException {
        CurriculumResult curriculumResult = new CurriculumResult();
        String registrationNo = this.studentInfo.getRegistrationNo();
        
        String name = new PersonalInfoService(registrationNo).getStudentName();
        Student student = new Student(registrationNo, name);
        curriculumResult.setStudent(student);//setting Student

        AcademicInfoService academicInfo = new AcademicInfoService(registrationNo);
        curriculumResult.setDepartment(academicInfo.getDepartment());//setting department       
        curriculumResult.setProgram(academicInfo.getProgram());//setting program     
        curriculumResult.setAcademicSession(academicInfo.getStudentAcademicSession());//setting academicSession     
        curriculumResult.setCurriculumSemester(semester); //setting curriculmSemester

        //setting attendedCourseResults <courseResult>
        List<CourseResult> courseResults = new ArrayList<>();
        List<CourseInSyllabus> syllabusCourses = SyllabusService.getCourseInSyllabusOfSemester(
                studentInfo.getStudentBatchIdFk(), semester, false);
        for (CourseInSyllabus c : syllabusCourses) {
            CourseResult courseResult = new CourseResult();
            courseResult.setCourseInSyllabus(c);
            List<Result> results = getResultsOfCourse(c.getCourseModel().getCourseCode());
            courseResult.setResults(results);
            courseResult.setPassedOn(getPassingSemesterOfCourse(results));
            courseResults.add(courseResult);
        }
        curriculumResult.setAttendedCourseResults(courseResults);
        //setting creditSummation
        curriculumResult.setCompletedCreditsSummation(getCompletedCreditsSummation(courseResults));
        
        return curriculumResult;
    }
    
    public SemesterResult getSemesterResult(int semester) throws HibernateException,
            SQLException, NullPointerException {
        SemesterResult semesterResult = new SemesterResult();
        String registrationNo = this.studentInfo.getRegistrationNo();
        
        String name = new PersonalInfoService(registrationNo).getStudentName();
        Student student = new Student(registrationNo, name);
        semesterResult.setStudent(student);//setting Student

        AcademicInfoService academicInfo = new AcademicInfoService(registrationNo);
        semesterResult.setDepartment(academicInfo.getDepartment());//setting department       
        semesterResult.setProgram(academicInfo.getProgram());//setting program     
        semesterResult.setAcademicSession(academicInfo.getStudentAcademicSession());//setting academicSession     
        semesterResult.setExamSemester(semester); //setting curriculmSemester

        //setting registeredCourseResults <CourseResult>
        semesterResult.setRegisteredCourseResults(getAttendedCourseResultsOfSemester(semester));
        
        return semesterResult;
    }
    
    public List<Result> getResultsOfCourse(String courseCode) throws SQLException {
        int syllabusId = SyllabusService.getSyllabusIdOfCourse(studentInfo.getStudentBatchIdFk(), courseCode);
        List<CourseRegistration> registrations = CourseRegistrationDao.getCourseAttempts(studentInfo.getStudentInfoId(), syllabusId);
        if (registrations != null) {
            List<Result> results = new ArrayList<>();
            for (CourseRegistration r : registrations) {
                Result result = new Result();
                result.setAttendedSemester(r.getAttendSemester());
                result.setAttendedYear(r.getAttendYear());
                if (r.getGrade() != null) {
                    result.setGrade(new Grade(r.getGrade()));
                } else {
                    result.setGrade(new Grade("N/A"));
                }

                //setting registrationStatus
                int offeringSemester = r.getSyllabusIdFk().getSemester();
                if (offeringSemester == r.getAttendSemester()) {
                    result.setRegistrationStatus(ModelConstants.REGULAR);
                } else if (offeringSemester > r.getAttendSemester()) {
                    result.setRegistrationStatus(ModelConstants.ADVANCED);
                } else {
                    result.setRegistrationStatus(ModelConstants.IRREGULAR);
                }
                
                results.add(result);
            }
            return results;
        }
        return null;
    }
    
    public List<CourseResult> getAttendedCourseResultsOfSemester(int semester) throws SQLException {
        List<CourseResult> courseResults = new ArrayList<>();
        List<CourseRegistration> attendedCourses = CourseRegistrationDao
                .getRegisteredCourseListOfSemester(this.studentInfo.getStudentInfoId(), semester);
        
        for (CourseRegistration r : attendedCourses) {
            CourseResult courseResult = new CourseResult();
            //setting CourseInSyllabus
            CourseInSyllabus courseInSyllabus = SyllabusService
                    .convertSyllabusEntityToCourseInSyllabus(r.getSyllabusIdFk(), false);
            courseResult.setCourseInSyllabus(courseInSyllabus);

            //setting Result
            Result result = new Result();
            result.setAttendedSemester(r.getAttendSemester());
            result.setAttendedYear(r.getAttendYear());
            result.setGrade(new Grade(r.getGrade()));
            List<Result> results = new ArrayList<>();
            results.add(result);
            courseResult.setResults(results);
            
            courseResults.add(courseResult);
        }
        return courseResults;
    }
    
    public String getPassingSemesterOfCourse(List<Result> results) {
        if (results != null) {
            for (Result r : results) {
                if (r.getGrade() != null) {
                    if (r.getGrade().getGradePoint() > 0.00) {
                        int sem = r.getAttendedSemester();
                        return Integer.toString(sem);
                    }
                }
            }
        }
        return "";
    }
    
    private static CreditsSummation getCompletedCreditsSummation(List<CourseResult> courseResults) {
        double totalCreditsCompleted = 0.00;
        double totalTheoryCreditsCompleted = 0.00;
        double totalLabCreditsCompleted = 0.00;
        double totalTheoryHrsAttended = 0.00;
        double totalLabHrsAttended = 0.00;
        
        for (CourseResult c : courseResults) {
            boolean passFlag = false;
            List<Result> results = c.getResults();
            for (Result r : results) {
                if (r.getGrade().getGradePoint() > 0.00 && !passFlag) {
                    double credit = c.getCourseInSyllabus().getCourseModel().getCredit();
                    totalCreditsCompleted += credit;
                    if (c.getCourseInSyllabus().getCourseModel().isTheoryCourse()) {
                        totalTheoryCreditsCompleted += credit;
                        totalTheoryHrsAttended += c.getCourseInSyllabus().getHoursWeek();
                        
                    } else {
                        totalLabCreditsCompleted += credit;
                        totalLabHrsAttended += c.getCourseInSyllabus().getHoursWeek();
                    }
                    passFlag = true;
                }
            }
        }
        return new CreditsSummation(totalCreditsCompleted, totalTheoryCreditsCompleted,
                totalLabCreditsCompleted, totalTheoryHrsAttended, totalLabHrsAttended);
    }
    
}
