/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.post_result;
import entity.Result;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class P_result {
    Result r =new Result();

    public Result getR() {
        return r;
    }

    public void setR(Result r) {
        this.r = r;
    }
    
    
    
    public String post_Result(){
        r.setStuId(r.getStuId());
        r.setSub1(r.getSub1());
        r.setSub2(r.getSub2());
        r.setSub3(r.getSub3());
        r.setSub4(r.getSub4());
        r.setGrade(r.getGrade());
        r.setSemester(r.getSemester());
        
      if(new post_result().postResult(r)){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Result published", ""));
     
     System.out.println("Result posted Sucessfully");
     }else{
         System.out.println("Failed");
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Result posting Failed", ""));
     }
         
      
         return null;
      }
        
        
        
     
        
    }
    
    
    
    
   

