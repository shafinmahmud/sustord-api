/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.List;
import me.shafin.sustord.entities.Department;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class DepartmentDao {
    
    public static Department getDepartmentObject(int departmentId) throws SQLException, NullPointerException{
        Department department;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            String hql = "from Department where deptId = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", departmentId);

            List<Department> depts = (List<Department>) query.list();

            session.getTransaction().commit();

            if (!depts.isEmpty()) {
                department = depts.get(0);
            }else{
                department = null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally{
            session.close();
        }

        return department;
    }
}
