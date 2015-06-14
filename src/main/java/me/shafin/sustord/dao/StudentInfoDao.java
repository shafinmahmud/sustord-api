/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class StudentInfoDao {

    public static StudentInfo getStudentInfoObject(String registrationNo) throws HibernateException, SQLException {
        StudentInfo studentInfo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            String hql = "from StudentInfo where registrationNo = :reg";
            Query query = session.createQuery(hql);
            query.setParameter("reg", registrationNo);

            List<StudentInfo> infos = (List<StudentInfo>) query.list();

            session.getTransaction().commit();

            if (!infos.isEmpty()) {
                studentInfo = infos.get(0);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e.getMessage());
        } finally {
            session.close();
        }

        return studentInfo;
    }

    public static List<StudentInfo> getStudentInfoObjects(Integer studentBatch) throws HibernateException, SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            String hql = "from StudentInfo where studentBatchIdFk = :batchId";
            Query query = session.createQuery(hql);
            query.setInteger("batchId", studentBatch);

            List<StudentInfo> infos = (List<StudentInfo>) query.list();

            session.getTransaction().commit();

            if (!infos.isEmpty()) {
                return infos;
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e.getMessage());
        } finally {
            session.close();
        }
        return null;
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
