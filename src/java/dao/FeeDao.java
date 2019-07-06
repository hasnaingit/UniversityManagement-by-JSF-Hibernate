
package dao;

import entity.Admin;
import entity.Fee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class FeeDao {
    
     public boolean insertFee(Fee f) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(f);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
