/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.StudentBatch;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class StudentBatchDao {
    
    public static StudentBatch getStudentBatchObject(String batchTag) throws SQLException, NullPointerException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "from StudentBatch where batchTag = :tag";
            Query query = session.createQuery(hql);
            query.setString("tag", batchTag);

            List<StudentBatch> batchs = (List<StudentBatch>) query.list();

            session.getTransaction().commit();

            if (!batchs.isEmpty()) {
                return batchs.get(0);
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
