/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.shafin.sustord.dao.CourseRegistrationDao;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.models.CourseCount;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseReport;
import me.shafin.sustord.models.CreditCount;
import me.shafin.sustord.models.CurriCreditsSum;
import me.shafin.sustord.models.CurriculumResult;
import me.shafin.sustord.models.Grade;
import me.shafin.sustord.models.RegCreditsSum;
import me.shafin.sustord.models.Report;
import me.shafin.sustord.models.ResultNutShell;
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
        List<CourseReport> courseResults = new ArrayList<>();
        List<CourseInSyllabus> syllabusCourses = SyllabusService.getCourseInSyllabusOfSemester(
                studentInfo.getStudentBatchIdFk(), semester, false);
        for (CourseInSyllabus c : syllabusCourses) {
            CourseReport courseResult = new CourseReport();
            courseResult.setCourseInSyllabus(c);
            List<Report> results = getResultsOfCourse(c.getCourseModel().getCourseCode());
            courseResult.setResults(results);
            courseResult.setCourseStatus(getCourseStatusFromResults(results)); //setting courseStatus
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
        semesterResult.setRegisteredCourseReports(getAttendedCourseResultsOfSemester(semester));

        //setting ResultNuttShell currentResult
        semesterResult.setResultThisSemester(getResultNutShell(semester, ModelConstants.THIS_SEMESTER));

        //setting ResultNutShell cumulativeResult
        semesterResult.setResultCumulative(getResultNutShell(semester, ModelConstants.UPTO_THIS_SEMESTER));
        return semesterResult;
    }

    public List<CourseReport> getAttendedCourseResultsOfSemester(int semester) throws SQLException {
        List<CourseReport> courseResults = new ArrayList<>();
        List<CourseRegistration> attendedCourses = CourseRegistrationDao
                .getRegisteredCourseListOfSemester(this.studentInfo.getStudentInfoId(), semester);

        if (attendedCourses != null) {
            for (CourseRegistration r : attendedCourses) {
                CourseReport courseResult = new CourseReport();
                //setting CourseInSyllabus
                CourseInSyllabus courseInSyllabus = SyllabusService
                        .convertSyllabusEntityToCourseInSyllabus(r.getSyllabusIdFk(), false);
                courseResult.setCourseInSyllabus(courseInSyllabus);

                //setting Report
                List<Report> resultForThis = new ArrayList<>();
                List<Report> allResultsOfthisCourse = getResultsOfCourse(r.getSyllabusIdFk()
                        .getCourseIdFk().getCourseCode());
                for (Report result : allResultsOfthisCourse) {
                    if (result.getAttendedSemester() == semester) {
                        resultForThis.add(result);
                    }
                }
                courseResult.setResults(resultForThis);
                courseResults.add(courseResult);
            }
        }
        return courseResults;
    }

    public List<Report> getResultsOfCourse(String courseCode) throws SQLException {
        int syllabusId = SyllabusService.getSyllabusIdOfCourse(studentInfo.getStudentBatchIdFk(), courseCode);
        List<CourseRegistration> registrations = CourseRegistrationDao
                .getCourseAttempts(studentInfo.getStudentInfoId(), syllabusId);
        //sorting courseRegistration on attendedSemester value
        Collections.sort(registrations);

        if (registrations != null) {
            List<Report> results = new ArrayList<>();

            boolean regularlyAttended = false;
            for (CourseRegistration r : registrations) {
                Report result = new Report();
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
                    result.setRegistrationStatus(ModelConstants.REGULAR_COURSE);
                    regularlyAttended = true;
                } else if (offeringSemester > r.getAttendSemester()) {
                    result.setRegistrationStatus(ModelConstants.ADVANCED_COURSE);
                    regularlyAttended = true;
                } else {
                    if (!regularlyAttended) {
                        result.setRegistrationStatus(ModelConstants.IRREGULAR_COURSE);
                    } else {
                        result.setRegistrationStatus(ModelConstants.DROPPED_COURSE);
                    }
                }

                results.add(result);
            }
            return results;
        }
        return null;
    }

    public String getCourseStatusFromResults(List<Report> results) {
        String courseStatus;
        boolean passedFlag = false;
        boolean pendingFlag = false;

        if (results != null) {
            for (Report r : results) {
                if (!r.getGrade().getGradeLetter().equals("N/A")) {
                    if (r.getGrade().getGradePoint() > 0.00) {
                        passedFlag = true;
                    }
                } else {
                    pendingFlag = true;
                }
            }

            if (passedFlag) {
                courseStatus = ModelConstants.PASSED;
            } else if (!pendingFlag) {
                courseStatus = ModelConstants.FAILED;
            } else {
                courseStatus = ModelConstants.RESULT_PENDING;
            }
        } else {
            courseStatus = ModelConstants.NOT_ATTENDED;
        }
        return courseStatus;
    }

    public String getPassingSemesterOfCourse(List<Report> results) {
        if (results != null) {
            for (Report r : results) {
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

    private static CurriCreditsSum getCompletedCreditsSummation(List<CourseReport> courseResults) {

        double totalTheoryCreditsCompleted = 0.00;
        double totalLabCreditsCompleted = 0.00;
        double totalTheoryHrsAttended = 0.00;
        double totalLabHrsAttended = 0.00;

        for (CourseReport c : courseResults) {
            boolean passFlag = false;
            List<Report> results = c.getResults();
            for (Report r : results) {
                if (r.getGrade().getGradePoint() > 0.00 && !passFlag) {
                    double credit = c.getCourseInSyllabus().getCourseModel().getCredit();

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
        return new CurriCreditsSum(new CreditCount(totalTheoryCreditsCompleted,
                totalLabCreditsCompleted), totalTheoryHrsAttended, totalLabHrsAttended);
    }

    public ResultNutShell getResultNutShell(int semester, int resultNutShellType) throws SQLException {

        int registeredRegularTheoryCount = 0;
        int registeredRegularLabCount = 0;
        int registeredIrregularTheoryCount = 0;
        int registeredIrregularLabCount = 0;
        
        int completedRegularTheoryCount = 0;
        int completedRegularLabCount = 0;
        int completedIrregularTheoryCount = 0;
        int completedIrregularLabCount = 0;
        
        double registeredRegularTheory = 0.00;
        double registeredRegularLab = 0.00;
        double registeredIrregularTheory = 0.00;
        double registeredIrregularLab = 0.00;

        double completedRegularTheory = 0.00;
        double completedRegularLab = 0.00;
        double completedIrregularTheory = 0.00;
        double completedIrregularLab = 0.00;

        double multipliedPoint = 0.00;
        double regularCourseMultipliedPoint = 0.00;

        //getting registered courses
        List<CourseRegistration> registeredCourses;
        if (resultNutShellType == ModelConstants.THIS_SEMESTER) {
            registeredCourses = CourseRegistrationDao
                    .getRegisteredCourseListOfSemester(studentInfo.getStudentInfoId(), semester);
        } else if(resultNutShellType == ModelConstants.UPTO_THIS_SEMESTER){
            registeredCourses = CourseRegistrationDao
                    .getRegisteredCourseListUpToSemester(studentInfo.getStudentInfoId(), semester);
        } else if(resultNutShellType == ModelConstants.CUMULATIVE){
            registeredCourses = CourseRegistrationDao
                .getRegisteredCourseListAll(studentInfo.getStudentInfoId());
        } else{
            registeredCourses = null;
        }

        //itereing them
        if (registeredCourses != null) {
            List<CourseRegistration> uniqueCourseRegistrations = new ArrayList<>();
            for (CourseRegistration r : registeredCourses) {

                //is the course taken before ? test it.
                boolean courseIsTakenBefore = false;
                for (CourseRegistration takenCourse : uniqueCourseRegistrations) {
                    if (r.getSyllabusIdFk() == takenCourse.getSyllabusIdFk()) {
                        courseIsTakenBefore = true;
                    }
                }
                if (!courseIsTakenBefore) {
                    uniqueCourseRegistrations.add(r);
                }

                boolean regularCourse = isCourseRegistationRegular(r);
                boolean isCourseTheory = SyllabusService.isCourseTheory(r.getSyllabusIdFk().getCourseIdFk());
                double courseCredit = r.getSyllabusIdFk().getCourseIdFk().getCredit();
                double gradePoint = new Grade(r.getGrade()).getGradePoint();

                if (regularCourse) {  //condition for Regular Course
                    if (isCourseTheory) {
                        if (!courseIsTakenBefore) {
                            registeredRegularTheory += courseCredit;
                            registeredRegularTheoryCount++;
                        }
                        if (gradePoint > 0.00) {
                            completedRegularTheory += courseCredit;
                            completedRegularTheoryCount++;
                            
                            multipliedPoint += gradePoint * courseCredit;
                            regularCourseMultipliedPoint += gradePoint * courseCredit;
                        }
                    } else {
                        if (!courseIsTakenBefore) {
                            registeredRegularLab += courseCredit;
                            registeredRegularLabCount++;
                        }
                        if (gradePoint > 0.00) {
                            completedRegularLab += courseCredit;
                            completedRegularLabCount++;
                            
                            multipliedPoint += gradePoint * courseCredit;
                            regularCourseMultipliedPoint += gradePoint * courseCredit;
                        }
                    }
                } else { //condition for Irregular Course
                    if (isCourseTheory) {
                        if (!courseIsTakenBefore) {
                            registeredIrregularTheory += courseCredit;
                            registeredIrregularTheoryCount++;
                        }
                        if (gradePoint > 0.00) {
                            completedIrregularTheory += courseCredit;
                            completedIrregularTheoryCount++;                       
                            multipliedPoint += gradePoint * courseCredit;
                        }
                    } else {
                        if (!courseIsTakenBefore) {
                            registeredIrregularLab += courseCredit;
                            registeredIrregularLabCount++;
                        }
                        if (gradePoint > 0.00) {
                            completedIrregularLab += courseCredit;
                            completedIrregularLabCount++;
                            multipliedPoint += gradePoint * courseCredit;
                        }
                    }
                }

            }
        }
        //building ResultNutShell      
        RegCreditsSum registeredCourse = new RegCreditsSum();
        //setting for registered coures
        registeredCourse.setRegularCreditCount(new CreditCount(registeredRegularTheory, registeredRegularLab));
        registeredCourse.setIrregularCreditCount(new CreditCount(registeredIrregularTheory, registeredIrregularLab));
        
        registeredCourse.setRegularCourseCount(new CourseCount(registeredRegularTheoryCount, registeredRegularLabCount));
        registeredCourse.setIrregularCourseCount(new CourseCount(registeredIrregularTheoryCount, registeredIrregularLabCount));
        
        RegCreditsSum completedCourse = new RegCreditsSum();
        //setting for completed courses    
        completedCourse.setRegularCreditCount(new CreditCount(completedRegularTheory, completedRegularLab));
        completedCourse.setIrregularCreditCount(new CreditCount(completedIrregularTheory, completedIrregularLab));
        
        completedCourse.setRegularCourseCount(new CourseCount(completedRegularTheoryCount, completedRegularLabCount));
        completedCourse.setIrregularCourseCount(new CourseCount(completedIrregularTheoryCount, completedIrregularLabCount));
        

        Grade allCourseGPA;
        double totalCompletedCredit = completedCourse.getAllCreditCount().getTotal();
        if (totalCompletedCredit > 0) {
            allCourseGPA = new Grade(multipliedPoint / totalCompletedCredit);
        } else {
            allCourseGPA = new Grade("N/A");
        }

        Grade regularCourseGPA;
        double totalRegularCompletedCredit = completedCourse.getRegularCreditCount().getTotal();
        if (totalRegularCompletedCredit > 0) {
            regularCourseGPA = new Grade(regularCourseMultipliedPoint / totalCompletedCredit);
        } else {
            regularCourseGPA = new Grade("N/A");
        }

        return new ResultNutShell(registeredCourse, completedCourse, allCourseGPA, regularCourseGPA);
    }


    public static boolean isCourseRegistationRegular(CourseRegistration reg) {
        return reg.getAttendSemester() == reg.getSyllabusIdFk().getSemester();
    }

}
