/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
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
public class Stu_login {
    public boolean login(Student st) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Student  where user=:uname and password=:pass");
            query.setString("uname", st.getUser());
            query.setString("pass", st.getPassword());
            List<Student> list = query.list();
            list.toString();
            session.getTransaction().commit();
            session.close();

            if (list.size() > 0) {
                HttpSession hts = SessionUtil.getSession();
                hts.setAttribute("uname", list.get(0).getUser());
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
