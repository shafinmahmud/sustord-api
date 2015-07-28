/*
 */
package me.shafin.sustord.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.dao.CourseDao;
import me.shafin.sustord.dao.DepartmentDao;
import me.shafin.sustord.dao.PrerequisiteDao;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.entities.Prerequisite;
import me.shafin.sustord.entities.Syllabus;
import me.shafin.sustord.models.CourseInSyllabus;
import me.shafin.sustord.models.CourseModel;
import me.shafin.sustord.models.DepartmentModel;
import me.shafin.sustord.services.SyllabusService;

/**
 *
 * @author SHAFIN
 */
public class SyllabusHelper {

    public static boolean isCourseTheory(Course course) {
        return course.getTheoryOrLab() == 1;
    }

    public static CourseInSyllabus convertSyllabusEntityToCourseInSyllabus(Syllabus s, boolean withCourseContent)
            throws SQLException {
        CourseInSyllabus courseInSyllabus = new CourseInSyllabus();

        //setting courseModel
        int courseId = s.getCourseIdFk().getCourseId();
        CourseModel course = getCourseModelFromCourseId(courseId, withCourseContent);
        courseInSyllabus.setCourseModel(course);

        //setting offeringSemester
        courseInSyllabus.setOfferingSemester(s.getSemester());
        //setting acceptingDept
        DepartmentModel department = getDepartmentFromDeptId(s.getAcceptingDeptIdFk().getDeptId());
        courseInSyllabus.setAcceptingDept(department);

        //setting offeringDept
        department = getDepartmentFromDeptId(s.getOfferingDeptIdFk().getDeptId());
        courseInSyllabus.setOfferingDept(department);

        //setting hoursWeek
        courseInSyllabus.setHoursWeek(s.getHrsWeek());

        //setting prerequisite
        List<CourseModel> prerequisiteCourses = new ArrayList<>();
        List<Prerequisite> prerequisiteList = PrerequisiteDao.getPrerequisiteObjectsList(s.getSyllabusId());
        if (prerequisiteList != null) {
            for (Prerequisite p : prerequisiteList) {
                CourseModel preq = getCourseModelFromCourseId(p.getCourseIdFk().getCourseId(), false);
                prerequisiteCourses.add(preq);
            }
        }
        courseInSyllabus.setPrerequisite(prerequisiteCourses);
        return courseInSyllabus;
    }

    public static CourseModel getCourseModelFromCourseId(int courseId, boolean withCourseContent)
            throws SQLException {

        Course courseEntity = CourseDao.getCourseObject(courseId);
        CourseModel course = new CourseModel();
        course.setCourseCode(courseEntity.getCourseCode());
        course.setCourseTitle(courseEntity.getTitle());
        course.setCredit(courseEntity.getCredit());
        course.setTheoryCourse(SyllabusHelper.isCourseTheory(courseEntity));

        if (withCourseContent) {
            course.setCourseContent(courseEntity.getContent());
            course.setReferences(courseEntity.getReferences());
        }

        return course;
    }

    public static CourseModel getCourseModelFromCourseCode(String courseCode, boolean withCourseContent)
            throws SQLException {

        courseCode = getCourseCodeFormatted(courseCode);
        Course courseEntity = CourseDao.getCourseFromCourseCode(courseCode);
        CourseModel course = new CourseModel();
        course.setCourseCode(courseEntity.getCourseCode());
        course.setCourseTitle(courseEntity.getTitle());
        course.setCredit(courseEntity.getCredit());
        course.setTheoryCourse(SyllabusHelper.isCourseTheory(courseEntity));

        if (withCourseContent) {
            course.setCourseContent(courseEntity.getContent());
            course.setReferences(courseEntity.getReferences());
        }

        return course;
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

    public static DepartmentModel getDepartmentFromDeptId(int deptId) throws SQLException {
        DepartmentModel department = new DepartmentModel();
        department.setDepartmentCode(DepartmentDao.getDepartmentObject(deptId).getDeptCode());
        department.setDepartmentName(DepartmentDao.getDepartmentObject(deptId).getDeptName());
        department.setSchoolName(DepartmentDao.getDepartmentObject(deptId).getSchoolIdFk().getSchoolName());
        return department;
    }
}
