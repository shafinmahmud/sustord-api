/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.shafin.sustord.dao.CourseRegistrationDao;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.helpers.BasicInfoHelper;
import me.shafin.sustord.helpers.ReportHelper;
import me.shafin.sustord.models.CourseCount;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseReport;
import me.shafin.sustord.models.CreditCount;
import me.shafin.sustord.models.CurriCreditsSum;
import me.shafin.sustord.models.CurriculumResult;
import me.shafin.sustord.models.Grade;
import me.shafin.sustord.models.Report;
import me.shafin.sustord.utilities.ModelConstants;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class CurriculumResultService extends StudentIdentityService {

    /* Constructor thats is private and get accesses through static helper method  */
    public CurriculumResultService(String registrationNo) throws HibernateException,
            SQLException, NullPointerException {
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
    }

    public CurriculumResult getCurriculumResult(int semester) throws HibernateException,
            SQLException {
        CurriculumResult curriculumResult = new CurriculumResult();

        //setting Student
        curriculumResult.setStudent(BasicInfoHelper.getStudent(studentInfo));
        //setting BatchInformation
        curriculumResult.setBatchInformation(BasicInfoHelper.getBatchInformation(studentInfo));
        //setting curriculmSemester
        curriculumResult.setCurriculumSemester(semester);

        //setting attendedCourseResults <courseResult>
        List<CourseReport> courseResults = new ArrayList<>();
        List<CourseInSyllabus> syllabusCourses = SyllabusService.getCourseInSyllabusOfSemester(
                studentInfo.getStudentBatchIdFk(), semester, false);
        for (CourseInSyllabus c : syllabusCourses) {
            CourseReport courseResult = new CourseReport();
            courseResult.setCourseInSyllabus(c);
            List<Report> results = getResultsOfCourse(studentInfo, c.getCourseModel().getCourseCode());
            courseResult.setResults(results);
            courseResult.setCourseStatus(ReportHelper.getCourseStatusFromResults(results)); //setting courseStatus
            courseResult.setPassedOn(ReportHelper.getPassingSemesterOfCourse(results));
            courseResults.add(courseResult);
        }
        curriculumResult.setAttendedCourseResults(courseResults);

        //setting offeredCreditSum
        curriculumResult.setOfferedCreditsSum(SyllabusService.getCurriCreditSumForOfferedCourses(syllabusCourses));

        //setting completedCreditSum
        curriculumResult.setCompletedCreditsSum(getCurriCreditSumForCompletedCourses(courseResults));

        return curriculumResult;
    }

    public static List<Report> getResultsOfCourse(StudentInfo studentInfo, String courseCode) throws SQLException {
        int syllabusId = SyllabusService.getSyllabusIdOfCourse(studentInfo.getStudentBatchIdFk(), courseCode);
        List<CourseRegistration> registrations = CourseRegistrationDao
                .getCourseAttempts(studentInfo.getStudentInfoId(), syllabusId);

        if (registrations != null) {

            //sorting courseRegistration on attendedSemester value
            Collections.sort(registrations);

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
                        result.setRegistrationStatus(ModelConstants.PENDING_COURSE);
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

    private static CurriCreditsSum getCurriCreditSumForCompletedCourses(List<CourseReport> courseResults) {

        int theoryCourseCount = 0;
        int labCourseCount = 0;

        double theoryCreditCount = 0.00;
        double labCreditCount = 0.00;

        double totalTheoryHrsWeek = 0.00;
        double totalLabHoursWeek = 0.00;

        for (CourseReport c : courseResults) {
            boolean passFlag = false;
            List<Report> results = c.getResults();
            if (results != null) {
                for (Report r : results) {
                    if (r.getGrade().getGradePoint() > 0.00 && !passFlag) {
                        double credit = c.getCourseInSyllabus().getCourseModel().getCredit();

                        if (c.getCourseInSyllabus().getCourseModel().isTheoryCourse()) {
                            theoryCourseCount++;
                            theoryCreditCount += credit;
                            totalTheoryHrsWeek += c.getCourseInSyllabus().getHoursWeek();

                        } else {
                            labCourseCount++;
                            labCreditCount += credit;
                            totalLabHoursWeek += c.getCourseInSyllabus().getHoursWeek();
                        }
                        passFlag = true;
                    }
                }
            }
        }
        CreditCount creditCount = new CreditCount(theoryCreditCount, labCreditCount);
        CourseCount courseCount = new CourseCount(theoryCourseCount, labCourseCount);
        return new CurriCreditsSum(courseCount, creditCount, totalTheoryHrsWeek, totalLabHoursWeek);
    }
}
