package Model.Pojo;
// Generated Oct 17, 2022 6:11:51 AM by Hibernate Tools 4.3.1



/**
 * Tbmessage generated by hbm2java
 */
public class Tbmessage  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String message;

    public Tbmessage() {
    }

    public Tbmessage(String name, String message) {
       this.name = name;
       this.message = message;
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
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }




}


