/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Accountant;
import entity.Student;
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
public class Ac_dao {
     public boolean login(Accountant ac) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Accountant  where user_id=:uname and password=:pass");
            query.setString("uname",ac.getUserId());
            query.setString("pass",ac.getPassword());
            List<Accountant> list = query.list();
            list.toString();
            session.getTransaction().commit();
            session.close();

            if (list.size() > 0) {
                HttpSession hts = SessionUtil.getSession();
                hts.setAttribute("uname", list.get(0).getUserId());
                hts.setAttribute("pass", list.get(0).getPassword());
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
