/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Result;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class ResultDao {
     public List searchResult(Result r) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query q = session.createQuery("from Result where stuId=? and semester=? ");
        q.setParameter(0,r.getStuId());
        q.setParameter(1,r.getSemester());

      
        List<Result> searchResult = q.list();
       
        session.close();
        return searchResult;

    }
}
