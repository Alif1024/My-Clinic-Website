package Model.Pojo;
// Generated Oct 17, 2022 6:11:51 AM by Hibernate Tools 4.3.1



/**
 * Tbqueue generated by hbm2java
 */
public class Tbqueue  implements java.io.Serializable {


     private Integer queueNumber;
     private String name;
     private String gender;
     private String email;
     private String phone;
     private String registrationdate;

   
     private String alamat;

    public Tbqueue() {
    }

    public Tbqueue(String name, String gender, String email, String phone, String alamat) {
       this.name = name;
       this.gender = gender;
       this.email = email;
       this.phone = phone;
       this.alamat = alamat;
    }
   
    public Integer getQueueNumber() {
        return this.queueNumber;
    }
    
    public void setQueueNumber(Integer queueNumber) {
        this.queueNumber = queueNumber;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
     public String getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }
    
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }




}

