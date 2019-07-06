/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.AdminLoginDao;
import dao.Stu_login;
import entity.Student;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.SessionUtil;

/**
 *
 * @author Hasnain
 */
@ManagedBean
@SessionScoped
public class Stu_log {
    Student st= new Student();

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }
    
    
    public String login() throws IOException{
        
        
        
        st.setUser(st.getUser());
        st.setPassword(st.getPassword());
        
        
        if( new Stu_login().login(st))
        
        
 {
     System.out.println("login Success");
     
         return "s_dashboard? faces-redirect=true";
           
        } else{
            System.out.println("Login failed");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
     
     
        
        
        
        
 }
    
    
  public String logout() {
    HttpSession session = SessionUtil.getSession();
		session.invalidate();
	return "st_login.xhtml?faces-redirect=true";
}
       
    
    
    
    
}
