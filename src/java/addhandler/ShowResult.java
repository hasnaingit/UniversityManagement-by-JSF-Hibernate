/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.ResultDao;
import entity.Result;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

@ManagedBean
@SessionScoped
public class ShowResult {
    Result r =new Result();

  List<Result> rlist = new ArrayList<>();

    public Result getR() {
        return r;
    }

    public void setR(Result r) {
        this.r = r;
    }

    public List<Result> getRlist() {
        return rlist;
    }

    public void setRlist(List<Result> rlist) {
        this.rlist = rlist;
    }
    
    
    public String searchResult(){
        rlist= new ResultDao().searchResult(r);
        
        
        
        return "searchResult";
        
    }
    
    
        
        
    }
    
