
package addhandler;

import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

@ManagedBean
@RequestScoped
public class StudentBean {
    private Student st= new Student();
    Session session =HibernateUtil.getSessionFactory().openSession();
    List<Student> slist= new ArrayList<>();
    UIForm tblDisplay= new UIForm();

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public List<Student> getSlist() {
        return slist;
    }

    public void setSlist(List<Student> slist) {
        this.slist = slist;
    }

    public UIForm getTblDisplay() {
        return tblDisplay;
    }

    public void setTblDisplay(UIForm tblDisplay) {
        this.tblDisplay = tblDisplay;
    }

    public StudentBean() {
        tblDisplay.setRendered(false);
    }
    
   public void newStudent(){
       st=new Student();
   } 
    public void addMessage(String title, String message){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,title,message);
   FacesContext.getCurrentInstance().addMessage(null, msg);
   
    }
    
   //save method
    public void save(){
        tblDisplay.setRendered(false);
        Transaction t= session.beginTransaction();
        session.save(st);
        t.commit();
        addMessage("saved","student saved successfully ");
    }
    
    //update method
    public void update(){
        tblDisplay.setRendered(false);
        Transaction t= session.beginTransaction();
        Student s= (Student) session.get(Student.class,st.getId());
        if(s!=null){
            s.setId(st.getId());
            s.setName(st.getName());
            s.setDepartment(st.getDepartment());
            s.setPhone(st.getPhone());
            s.setBatch(st.getBatch());
            s.setGender(st.getGender());
            session.update(s);
            addMessage("update", "Student have been updated");
    }else{
            addMessage("update", "update failed");
        }
        
        t.commit();
    }
    
    //delete 
    public void delete(){
        tblDisplay.setRendered(false);
        Transaction t= session.beginTransaction();
        Student s= (Student) session.get(Student.class, st.getId());
        if(s!=null){
            session.delete(s);
             addMessage("delete", "Student have been deleted");
        }
        else{
            addMessage("delete", "delete failed"); 
        }
        t.commit();
    }
    
    public void find(){
        tblDisplay.setRendered(false);
        Student s= (Student) session.get(Student.class, st.getId());
        if(s!=null){
            st.setId(s.getId());
            st.setName(s.getName());
            st.setDepartment(s.getDepartment());
            st.setPhone(s.getPhone());
            st.setBatch(s.getBatch());
            st.setGender(s.getGender()); 
        }
        else{
            addMessage("search", "student can not find by search");
        }
    }
     
    public void display(){
        tblDisplay.setRendered(true);
        
//        Query q= session.createQuery("from Student");
//        q.toString();
 
    
      slist = (ArrayList<Student>) session.createCriteria(Student.class).list();
    
    
    
    }
    
}
