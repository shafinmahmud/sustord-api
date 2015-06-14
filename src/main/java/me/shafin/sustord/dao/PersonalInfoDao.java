
package me.shafin.sustord.dao;

import java.util.List;
import me.shafin.sustord.entities.PersonalInfo;
import me.shafin.sustord.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SHAFIN
 */
public class PersonalInfoDao {
    
    public static PersonalInfo getPersonalInfoObject(int personalInfoId) throws Exception {
        PersonalInfo personalInfo;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            String hql = "from PersonalInfo where personalInfoId = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", personalInfoId);

            List<PersonalInfo> infos = (List<PersonalInfo>) query.list();

            session.getTransaction().commit();

            if (!infos.isEmpty()) {
                personalInfo = infos.get(0);
            }else{
                personalInfo = null;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally{
            session.close();
        }

        return personalInfo;
    }
}
