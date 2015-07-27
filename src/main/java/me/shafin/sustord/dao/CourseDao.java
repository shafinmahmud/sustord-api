/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class CourseDao {

    public static Course getCourseObject(int courseId) throws SQLException, NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from Course where courseId = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", courseId);

            List<Course> course = (List<Course>) query.list();

            session.getTransaction().commit();

            if (!course.isEmpty()) {
                return course.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static Course getCourseFromCourseCode(String courseCode) throws SQLException, NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from Course where courseCode = :code";
            Query query = session.createQuery(hql);
            query.setString("code", courseCode);

            List<Course> course = (List<Course>) query.list();

            session.getTransaction().commit();

            if (!course.isEmpty()) {
                return course.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }
}
