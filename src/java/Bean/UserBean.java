/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.UserDAO;
import Model.Pojo.Tbuser;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;
import org.primefaces.context.RequestContext;
/**
 *
 * @author nural
 */
@ManagedBean(name = "userBean") 
@ViewScoped
public class UserBean {
    
    Tbuser tbuser = new Tbuser();
    private List<Tbuser> tbusers;

    public List<Tbuser> getTbusers() {
        UserDAO dao = new UserDAO();
        tbusers = dao.showUser();        
        return tbusers;
    }

    public void setTbusers(List<Tbuser> tbusers) {
        this.tbusers = tbusers;
    }
    
    public Tbuser getTbuser() {
        return tbuser;
    }

    public void setTbuser(Tbuser tbuser) {
        this.tbuser = tbuser;
    }
    
    public void message(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String addUser() {
        tbuser.setEmail(tbuser.getEmail());
        tbuser.setPassword(tbuser.getPassword());
        boolean status = new UserDAO().addUser(tbuser);
        if (status) {
            message("Account Registered Successfully!!");
        } else {
            message("Failed to Register Account!!");
        }
        return null;
    }
    
    public void changeBook(Tbuser tbuser) { 
        this.tbuser = tbuser; 
    } 
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void editUser() {
        UserDAO dao = new UserDAO();
        dao.editUser(tbuser);
        tbuser = new Tbuser();
        addMessage("Account Edited!!");
    }
    
    public void deleteUser(Tbuser tbuser) { 
        UserDAO userDao = new UserDAO();
        String Title = tbuser.getEmail(); 
       // FacesMessage message3= new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Item",contactName); RequestContext.getCurrentInstance().showMessageInDialog(message3); 
        // 
       
        userDao.deleteUser(tbuser); 
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully"); 

        RequestContext.getCurrentInstance().showMessageInDialog(message); 
    }
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
      
}
