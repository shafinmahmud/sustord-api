/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.dao.CourseRegistrationDao;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.helpers.BasicInfoHelper;
import me.shafin.sustord.helpers.ReportHelper;
import me.shafin.sustord.helpers.SyllabusHelper;
import me.shafin.sustord.models.CourseCount;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseReport;
import me.shafin.sustord.models.CreditCount;
import me.shafin.sustord.models.Grade;
import me.shafin.sustord.models.RegCreditsSum;
import me.shafin.sustord.models.Report;
import me.shafin.sustord.models.ResultNutShell;
import me.shafin.sustord.models.SemesterResult;
import me.shafin.sustord.utilities.ModelConstants;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class SemesterResultService extends StudentIdentityService {

    /* Constructor thats is private and get accesses through static helper method  */
    public SemesterResultService(String registrationNo) throws HibernateException,
            SQLException, NullPointerException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }

    public SemesterResult getSemesterResult(int semester) throws HibernateException,
            SQLException, NullPointerException {
        SemesterResult semesterResult = new SemesterResult();
        //setting StudentInfoHeader
        semesterResult.setStudentBasicInfo(BasicInfoHelper.getStudentIntroHeader(studentInfo));
        semesterResult.setExamSemester(semester); //setting curriculmSemester

        //setting registeredCourseResults <CourseResult>
        semesterResult.setRegisteredCourseReports(getAttendedCourseResultsOfSemester(semester));

        //setting ResultNuttShell currentResult
        semesterResult.setResultThisSemester(getResultNutShell(semester, ModelConstants.THIS_SEMESTER));

        //setting ResultNutShell cumulativeResult
        semesterResult.setResultUptoThisSemester(getResultNutShell(semester, ModelConstants.UPTO_THIS_SEMESTER));
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
                CourseInSyllabus courseInSyllabus = SyllabusHelper
                        .convertSyllabusEntityToCourseInSyllabus(r.getSyllabusIdFk(), false);
                courseResult.setCourseInSyllabus(courseInSyllabus);

                //setting Report
                List<Report> resultForThis = new ArrayList<>();
                List<Report> allResultsOfthisCourse = CurriculumResultService
                        .getResultsOfCourse(studentInfo, r.getSyllabusIdFk()
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
        } else if (resultNutShellType == ModelConstants.UPTO_THIS_SEMESTER) {
            registeredCourses = CourseRegistrationDao
                    .getRegisteredCourseListUpToSemester(studentInfo.getStudentInfoId(), semester);
        } else if (resultNutShellType == ModelConstants.CUMULATIVE) {
            registeredCourses = CourseRegistrationDao
                    .getRegisteredCourseListAll(studentInfo.getStudentInfoId());
        } else {
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

                boolean regularCourse = ReportHelper.isCourseRegistationRegular(r);
                boolean isCourseTheory = SyllabusHelper.isCourseTheory(r.getSyllabusIdFk().getCourseIdFk());
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
            regularCourseGPA = new Grade(regularCourseMultipliedPoint / totalRegularCompletedCredit);
        } else {
            regularCourseGPA = new Grade("N/A");
        }

        return new ResultNutShell(registeredCourse, completedCourse, allCourseGPA, regularCourseGPA);
    }

}
