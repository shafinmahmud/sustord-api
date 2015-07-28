/*
 */
package me.shafin.sustord.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SHAFIN
 */
public class Test {
    
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            StudentInfoDao dao = context.getBean("StudentInfoDao",StudentInfoDao.class);
            System.out.println(dao.getStudentInfo(1).getRegistrationNo()); 
            
        } catch (HibernateException | SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
