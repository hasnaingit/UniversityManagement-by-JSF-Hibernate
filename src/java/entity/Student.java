package entity;
// Generated Mar 29, 2019 7:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String father;
     private Integer phone;
     private String department;
     private String batch;
     private Date date;
     private String semester;
     private String password;
     private String gender;
     private String user;
     private Double result;
     private String image;

    public Student() {
    }

	
    public Student(String name) {
        this.name = name;
    }
    public Student(String name, String father, Integer phone, String department, String batch, Date date, String semester, String password, String gender, String user, Double result, String image) {
       this.name = name;
       this.father = father;
       this.phone = phone;
       this.department = department;
       this.batch = batch;
       this.date = date;
       this.semester = semester;
       this.password = password;
       this.gender = gender;
       this.user = user;
       this.result = result;
       this.image = image;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getFather() {
        return this.father;
    }
    
    public void setFather(String father) {
        this.father = father;
    }
    public Integer getPhone() {
        return this.phone;
    }
    
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getBatch() {
        return this.batch;
    }
    
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getSemester() {
        return this.semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    public Double getResult() {
        return this.result;
    }
    
    public void setResult(Double result) {
        this.result = result;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }




}


