/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author SHAFIN
 */
public class CourseRegistrationDao {

    public static CourseRegistration getCourseRegistrationObject(int courseRegistrationId)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from CourseRegistration where courseRegistrationId = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", courseRegistrationId);

            List<CourseRegistration> courseRegistrations = (List<CourseRegistration>) query.list();

            session.getTransaction().commit();

            if (!courseRegistrations.isEmpty()) {
                return courseRegistrations.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<CourseRegistration> getCourseAttempts(Integer studentInfoId, int syllabusId)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from CourseRegistration where studentInfoIdFk = :id and syllabusIdFk = :syllabusId and approval = 1";
            Query query = session.createQuery(hql);
            query.setInteger("id", studentInfoId);
            query.setInteger("syllabusId", syllabusId);

            List<CourseRegistration> courseRegistrations = (List<CourseRegistration>) query.list();

            session.getTransaction().commit();

            if (!courseRegistrations.isEmpty()) {
                return courseRegistrations;
            } else {
                return null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<CourseRegistration> getRegisteredCourseListOfSemester(Integer studentInfoId, int semester)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from CourseRegistration where studentInfoIdFk = :id and attendSemester = :sem and  approval = 1";
            Query query = session.createQuery(hql);
            query.setInteger("id", studentInfoId);
            query.setInteger("sem", semester);

            List<CourseRegistration> courseRegistrations = (List<CourseRegistration>) query.list();

            session.getTransaction().commit();

            if (!courseRegistrations.isEmpty()) {
                return courseRegistrations;
            } else {
                return null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<CourseRegistration> getRegisteredCourseListUpToSemester(Integer studentInfoId, int semester)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from CourseRegistration where studentInfoIdFk = :id and attendSemester <= :sem and  approval = 1";
            Query query = session.createQuery(hql);
            query.setInteger("id", studentInfoId);
            query.setInteger("sem", semester);

            List<CourseRegistration> courseRegistrations = (List<CourseRegistration>) query.list();

            session.getTransaction().commit();

            if (!courseRegistrations.isEmpty()) {
                return courseRegistrations;
            } else {
                return null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<CourseRegistration> getRegisteredCourseListAll(Integer studentInfoId)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from CourseRegistration where studentInfoIdFk = :id and  approval = 1";
            Query query = session.createQuery(hql);
            query.setInteger("id", studentInfoId);

            List<CourseRegistration> courseRegistrations = (List<CourseRegistration>) query.list();

            session.getTransaction().commit();

            if (!courseRegistrations.isEmpty()) {
                return courseRegistrations;
            } else {
                return null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static int getMaxRegistrationSemester(StudentInfo studentInfoId)
            throws SQLException, NullPointerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            Criteria criteria = session.createCriteria(CourseRegistration.class)
                    .add(Restrictions.eq("studentInfoIdFk",studentInfoId))
                    .setProjection(Projections.max("attendSemester"));
            Integer currentSemester = (Integer) criteria.uniqueResult();
            if (currentSemester != null) {
                return currentSemester;
            } else {
                return 0;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }
}
