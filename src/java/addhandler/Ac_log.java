/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.Ac_dao;
import dao.Stu_login;
import entity.Accountant;
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
public class Ac_log {
    Accountant ac = new Accountant();

    public Accountant getAc() {
        return ac;
    }

    public void setAc(Accountant ac) {
        this.ac = ac;
    }

    
    
    public String login() throws IOException{
        
        ac.setUserId(ac.getUserId());
        ac.setPassword(ac.getPassword());
        
        
        if(new Ac_dao().login(ac))              
 {
     System.out.println("login Success");
     
         return "ac_dashboard? faces-redirect=true";
           
        } else{
            System.out.println("Login failed");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    
    public String logout() {
    HttpSession session = SessionUtil.getSession();
		session.invalidate();
	return "ac_log.xhtml?faces-redirect=true";
}
    
    
    
    
    
    
}
