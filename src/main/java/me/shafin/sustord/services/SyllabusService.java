/*
 */
package me.shafin.sustord.services;

import java.sql.SQLException;
import me.shafin.sustord.dao.CourseDao;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.models.CourseModel;

/**
 *
 * @author SHAFIN
 */
public class SyllabusService {

    public static CourseModel getCourseWithoutDetails(String courseCode) throws SQLException {
        courseCode = getCourseCodeFormatted(courseCode);
        Course courseEntity = CourseDao.getCourseFromCourseCode(courseCode);
        CourseModel course = new CourseModel();
        course.setCourseCode(courseEntity.getCourseCode());
        course.setCourseTitle(courseEntity.getTitle());
        course.setCredit(courseEntity.getCredit());
        if (courseEntity.getTheoryOrLab() != 1) {
            course.setIsCourseTheory(false);
        } else {
            course.setIsCourseTheory(true);
        }
        return course;
    }

    public static CourseModel getSpecificCourseDetails(String courseCode) throws SQLException {
        courseCode = getCourseCodeFormatted(courseCode);
        System.out.println(courseCode);
        Course courseEntity = CourseDao.getCourseFromCourseCode(courseCode);
        CourseModel course = getCourseWithoutDetails(courseCode);
        course.setCourseContent(courseEntity.getContent());
        course.setReferences(courseEntity.getReferences());
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
}
