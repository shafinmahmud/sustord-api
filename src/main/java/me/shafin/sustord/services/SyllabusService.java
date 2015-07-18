/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.dao.CourseDao;
import me.shafin.sustord.dao.StudentBatchDao;
import me.shafin.sustord.dao.SyllabusDao;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.entities.StudentBatch;
import me.shafin.sustord.entities.Syllabus;
import me.shafin.sustord.helpers.SyllabusHelper;
import me.shafin.sustord.models.CourseCount;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseModel;
import me.shafin.sustord.models.CreditCount;
import me.shafin.sustord.models.CurriCreditsSum;
import me.shafin.sustord.models.DepartmentModel;
import me.shafin.sustord.models.Program;
import me.shafin.sustord.models.SyllabusModel;

/**
 *
 * @author SHAFIN
 */
public class SyllabusService {

    public static SyllabusModel getSemesterSyllabus(String batchTag, int semester, boolean withCourseContent)
            throws SQLException {
        batchTag = batchTag.toUpperCase();
        StudentBatch batch = StudentBatchDao.getStudentBatchObject(batchTag);
        SyllabusModel syllabus = new SyllabusModel();

        syllabus.setAcademicSession(batch.getSession());
        syllabus.setDepartment(getDepartmentOfaBatch(batch));
        syllabus.setProgram(getProgramOfaBatch(batch));
        syllabus.setSemester(semester);
        List<CourseInSyllabus> courseList = getCourseInSyllabusOfSemester(batch, semester, withCourseContent);
        syllabus.setCourses(courseList);
        syllabus.setOfferingCreditSum(getCurriCreditSumForOfferedCourses(courseList));

        return syllabus;
    }

    public static CourseModel getCourse(String courseCode) throws SQLException {
        courseCode = getCourseCodeFormatted(courseCode);
        Course courseEntity = CourseDao.getCourseFromCourseCode(courseCode);
        CourseModel course = new CourseModel();
        course.setCourseCode(courseEntity.getCourseCode());
        course.setCourseTitle(courseEntity.getTitle());
        course.setCredit(courseEntity.getCredit());
        course.setTheoryCourse(SyllabusHelper.isCourseTheory(courseEntity));

        return course;
    }

    public static CourseModel getCourseWithContent(String courseCode) throws SQLException {
        courseCode = getCourseCodeFormatted(courseCode);
        Course courseEntity = CourseDao.getCourseFromCourseCode(courseCode);
        CourseModel course = getCourse(courseCode);
        course.setCourseContent(courseEntity.getContent());
        course.setReferences(courseEntity.getReferences());
        return course;
    }

    public static List<CourseInSyllabus> getCourseInSyllabusOfSemester(StudentBatch batch, int semester,
            boolean withCourseContent) throws SQLException {
        int batchId = batch.getStudentBatchId();
        List<CourseInSyllabus> syllabusCourseList = new ArrayList<>();
        List<Syllabus> courseList = SyllabusDao.getSyllabusObjectsOfSemester(batchId, semester);

        for (Syllabus s : courseList) {
            syllabusCourseList.add(SyllabusHelper.convertSyllabusEntityToCourseInSyllabus(s, withCourseContent));
        }
        return syllabusCourseList;
    }

    public static int getSyllabusIdOfCourse(StudentBatch batch, String courseCode)
            throws NullPointerException, SQLException {
        int batchId = batch.getStudentBatchId();
        int courseId = CourseDao.getCourseFromCourseCode(courseCode).getCourseId();
        return SyllabusDao.getSyllabusFromCourseId(batchId, courseId).getSyllabusId();
    }

    private static String getCourseCodeFormatted(String courseCode) {
        courseCode = courseCode.toUpperCase();
        courseCode = courseCode.trim();
        if (!courseCode.contains(" ")) {
            String temp1 = courseCode.substring(0, 3);
            String temp2 = courseCode.substring(3);
            String temp = temp1 + " " + temp2;
            return temp.trim();
        }
        return courseCode;
    }

    private static DepartmentModel getDepartmentOfaBatch(StudentBatch batch) throws SQLException {
        DepartmentModel department = new DepartmentModel();
        department.setDepartmentCode(batch.getDegreeOfferedIdFk().getDeptIdFk().getDeptCode());
        department.setDepartmentName(batch.getDegreeOfferedIdFk().getDeptIdFk().getDeptName());
        department.setSchoolName(batch.getDegreeOfferedIdFk().getDeptIdFk().getSchoolIdFk().getSchoolName());
        return department;
    }

    private static Program getProgramOfaBatch(StudentBatch batch) {
        Program program = new Program();
        program.setDegreeCategory(batch.getDegreeOfferedIdFk().getDegreeIdFk().getDegreeCategory());
        program.setDegreeType(batch.getDegreeOfferedIdFk().getDegreeIdFk().getDegreeType());
        program.setProgramName();
        return program;
    }

    public static CurriCreditsSum getCurriCreditSumForOfferedCourses(List<CourseInSyllabus> offeredCourses) {

        int theoryCourseCount = 0;
        int labCourseCount = 0;
        
        double theoryCreditCount = 0.00;
        double labCreditCount = 0.00;
        
        double totalTheoryHrsWeek = 0.00;
        double totalLabHoursWeek = 0.00;

        for (CourseInSyllabus c : offeredCourses) {

            if (c.getCourseModel().isTheoryCourse()) {
                theoryCourseCount++;
                theoryCreditCount += c.getCourseModel().getCredit();
                totalTheoryHrsWeek += c.getHoursWeek();
            } else {
                labCourseCount++;
                labCreditCount += c.getCourseModel().getCredit();
                totalLabHoursWeek += c.getHoursWeek();
            }
        }
        
        CreditCount creditCount = new CreditCount(theoryCreditCount, labCreditCount);
        CourseCount courseCount = new CourseCount(theoryCourseCount, labCourseCount);
        return new CurriCreditsSum(courseCount, creditCount, totalTheoryHrsWeek, totalLabHoursWeek);
    }

}
