/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.SessionUtil;

/**
 *
 * @author Hasnain
 */
public class AdminLoginDao {
    
     public boolean register(Admin ad) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(ad);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
 
       public boolean login(Admin ad) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Admin  where name=:uname and pass=:pass");
            query.setString("uname", ad.getName());
            query.setString("pass", ad.getPass());
            List<Admin> list = query.list();
            list.toString();
            session.getTransaction().commit();
            session.close();

            if (list.size() > 0) {
                HttpSession hts = SessionUtil.getSession();
                hts.setAttribute("uname", list.get(0).getName());
                hts.setAttribute("pass", list.get(0).getPass());
                return true;
            } else {
                
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
