
package addhandler;

import dao.FeeDao;
import entity.Fee;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class S_fee {
    
    Fee f=  new Fee();

    public Fee getF() {
        return f;
    }

    public void setF(Fee f) {
        this.f = f;
    }
    
    public String setFee(){
        
        f.setStuId(f.getStuId());
        f.setTotalFee(f.getTotalFee());
        f.setSemesterFee(f.getSemesterFee());
        f.setSemesterDue(f.getSemesterDue());
        if(new FeeDao().insertFee(f)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Fee insert successful",""));  
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Fee did not iserted",""));
        }
        
        return null;
    }
}
