/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;


import dao.AdminLoginDao;
import entity.Admin;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.SessionUtil;

@ManagedBean
@SessionScoped
public class LoginMb {
    Admin ad= new Admin();

    public Admin getAd() {
        return ad;
    }

    public void setAd(Admin ad) {
        this.ad = ad;
    }
    

  
   
    public String login() throws IOException{
        
        ad.setName(ad.getName());
       
        ad.setPass(ad.getPass());
        
 if(new AdminLoginDao().login(ad)){
     System.out.println("login Success");
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login successful", ""));
         return "adminHome? faces-redirect=true";
           
        } else{
            System.out.println("Login failed");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
     
     
        
        
        
        
 }
     
 public String register(){
     
     ad.setName(ad.getName());
     ad.setGender(ad.getGender());
     ad.setPhone(ad.getPhone());
     ad.setUserId(ad.getUserId());
     ad.setPass(ad.getPass());
     ad.setCode(ad.getCode());
     ad.setAddress(ad.getAddress());
     
     if(new AdminLoginDao().register(ad))
   
 {        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Sucessfull", ""));
     
     System.out.println("Registration Sucessfull");
     }else{
         System.out.println("Failed");
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Failed", ""));
     }
        
        
        return null;
    
    }

 public String logout() {
    HttpSession session = SessionUtil.getSession();
		session.invalidate();
	return "adminLogin.xhtml?faces-redirect=true";
}
    

}

