/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.Stu_login;
import dao.TeacherDao;
import entity.Teacher;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.SessionUtil;

@ManagedBean
@SessionScoped
public class TeacherH {
  Teacher t = new Teacher();

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }
  
    
    
    public String login() throws IOException{
        
        t.setUserId(t.getUserId());
         t.setPassword(t.getPassword());
       
        if (new TeacherDao().login(t))   
 {
     System.out.println("login Success");
     
         return "t_dashboard? faces-redirect=true";
           
        } else{
            System.out.println("Login failed");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
     
     
        
        
        
        
 } 
    
 
     public String logout() {
    HttpSession session = SessionUtil.getSession();
		session.invalidate();
	return "t_log.xhtml?faces-redirect=true";
}
    
    
    
}
