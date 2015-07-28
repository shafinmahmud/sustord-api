/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 *
 * @author SHAFIN
 */
@Component
public class StudentInfoDao {

    public StudentInfo getStudentInfo(int studentInfoId) throws HibernateException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            return (StudentInfo) session.get(StudentInfo.class, studentInfoId);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static StudentInfo getStudentInfo(String registrationNo) throws HibernateException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(StudentInfo.class);
            criteria.add(Restrictions.eq("registrationNo", registrationNo));
            StudentInfo studentInfo = (StudentInfo) criteria.uniqueResult();

            session.getTransaction().commit();
            return studentInfo;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static List<StudentInfo> getStudentInfos(int studentBatchId) throws HibernateException, 
            SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(StudentInfo.class);
            criteria.add(Restrictions.eq("studentBatchIdFk", studentBatchId));
            List<StudentInfo> studentInfos = (List<StudentInfo>) criteria.list();

            session.getTransaction().commit();
            return studentInfos;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static boolean setStudentPassword(StudentInfo studentInfo, String password)
            throws HibernateException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            studentInfo.setPassword(password);
            session.saveOrUpdate(studentInfo);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e.getMessage());
        } finally {
            session.close();
        }
    }

}
