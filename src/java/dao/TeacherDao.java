
package dao;

import entity.Student;
import entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.SessionUtil;

public class TeacherDao {
   
    public void addteacher(Teacher tr){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(tr);
        
        session.getTransaction().commit();
        session.close();
        
    }
    
//    public List trSearch(Teacher tr){
//      Teacher t=new Teacher();
//      List tlist= new ArrayList();
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session=sf.openSession();
//        session.beginTransaction();
//        Query q= session.createQuery("from Teacher where name=:tname");
//       q.setString("tname", tr.getName());
//        tlist=q.list();
//        session.getTransaction().commit();
//        session.close();
//        return tlist;
//        
//        
//    }
    
    public void deleteTr(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Teacher t=(Teacher) session.load(Teacher.class, new Integer(id));
        session.delete(t);
        session.getTransaction().commit();
        
    }
    
    public List<Teacher> getById(int id){
        Teacher t= new Teacher();
        List <Teacher> tlist= new ArrayList<>();
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Teacher where id=:id");
        q.setInteger("id", id);
        t=(Teacher) q.uniqueResult();
        tlist=q.list();
        return tlist;
    }
    
    public List <Teacher> allTeacher(){
        List tlist= new ArrayList();
        Teacher t= new Teacher();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Teacher");
        
        tlist= q.list();
        tlist.add(t.getId());
        tlist.add(t.getName());
        tlist.add(t.getPhone());
        tlist.add(t.getDepartment());
        session.getTransaction().commit();
        return tlist;
        
        
    }
    
    public void updateTr( Teacher tr){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.update(tr);
        
        session.getTransaction().commit();
        
        
    }
    
    public boolean login(Teacher t) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Teacher  where user_id=:uname and password=:pass");
            query.setString("uname",t.getUserId());
            query.setString("pass",t.getPassword());
            List<Teacher> tlist = query.list();
            tlist.toString();
            session.getTransaction().commit();
            session.close();

            if (tlist.size() > 0) {
                HttpSession hts = SessionUtil.getSession();
                hts.setAttribute("uname",  tlist.get(0).getUserId());
                hts.setAttribute("pass", tlist.get(0).getPassword());
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
