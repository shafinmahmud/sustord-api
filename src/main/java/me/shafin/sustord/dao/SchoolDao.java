/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import me.shafin.sustord.entities.School;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */

public class SchoolDao {

    public static School createSchool(School school) throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            int newSchoolId = (int) session.save(school);
            session.getTransaction().commit();
            return getSchool(newSchoolId);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static School getSchool(int schoolId) throws SQLException, NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            return (School) session.get(School.class, schoolId);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static School updateSchool(School school) throws HibernateException, SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.update(school);
            session.getTransaction().commit();
            return getSchool(school.getSchoolId());
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static boolean deleteSchool(School school) throws HibernateException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.delete(school);
            session.getTransaction().commit();           
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }
}
