/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.entities.Syllabus;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class SyllabusDao {

    public static Syllabus getSyllabusFromCourseId(int studentBatchId, int courseId) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from Syllabus where studentBatchIdFk = :batchId and courseIdFk = :courseId";
            Query query = session.createQuery(hql);
            query.setInteger("batchId", studentBatchId);
            query.setInteger("courseId", courseId);

            List<Syllabus> syllabusList = (List<Syllabus>) query.list();
            session.getTransaction().commit();

            if (!syllabusList.isEmpty()) {
                return syllabusList.get(0);
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<Syllabus> getSyllabusObjectsOfSemester(int studentBatchIdFk, int semester) throws SQLException,
            NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from Syllabus where studentBatchIdFk = :batchId and semester = :sem";
            Query query = session.createQuery(hql);
            query.setInteger("batchId", studentBatchIdFk);
            query.setInteger("sem", semester);

            List<Syllabus> syllabusList = (List<Syllabus>) query.list();
            session.getTransaction().commit();

            if (!syllabusList.isEmpty()) {
                return syllabusList;
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
    
    public static List<Syllabus> getSyllabusObjectsAll(int studentBatchIdFk) throws SQLException,
            NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from Syllabus where studentBatchIdFk = :batchId and semester > 0";
            Query query = session.createQuery(hql);
            query.setInteger("batchId", studentBatchIdFk);

            List<Syllabus> syllabusList = (List<Syllabus>) query.list();
            session.getTransaction().commit();

            if (!syllabusList.isEmpty()) {
                return syllabusList;
            } else {
                return new ArrayList<>();
            }
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

}
