/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.QueueDAO;
import Model.Pojo.Tbqueue;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;
/**
 *
 * @author nural
 */
@ManagedBean(name = "queueBean") 
@ViewScoped
public class QueueBean {
    
    private Tbqueue tbqueue;
    private List<Tbqueue> tbqueues;
    
    public Tbqueue getTbqueue() {
        return tbqueue;
    }

    public void setTbqueue(Tbqueue tbqueue) {
        this.tbqueue = tbqueue;
    }

    public List<Tbqueue> getTbqueues() {
        QueueDAO dao = new QueueDAO();
        tbqueues = dao.showQueue();
        return tbqueues;
    }

    public void setTbqueues(List<Tbqueue> tbqueues) {
        this.tbqueues = tbqueues;
    }
    
    /**
     * Creates a new instance of QueueBean
     */
    public QueueBean() {
        tbqueue = new Tbqueue();
    }
    
    public void changeBook(Tbqueue tbqueue) { 
        this.tbqueue = tbqueue; 
    } 
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addQueue() {
        QueueDAO dao = new QueueDAO();
        dao.addQueue(tbqueue);
        tbqueue = new Tbqueue();
        addMessage("Queue Success!!");
    }
    
    public void editQueue() {
        QueueDAO dao = new QueueDAO();
        dao.editQueue(tbqueue);
        tbqueue = new Tbqueue();
        addMessage("Queue Edited!!");
    }
//gagal delete dr yt spanyol     
//    public void deleteQueue() {
//        QueueDAO dao = new QueueDAO();
//        dao.deleteQueue(tbqueue);
//        tbqueue = new Tbqueue();
//        addMessage("Register Deleted!!");
//    } 
    
    public void deleteQueue(Tbqueue tbqueue) { 
        QueueDAO bookDao = new QueueDAO();
        String Title = tbqueue.getName(); 
       // FacesMessage message3= new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Item",contactName); RequestContext.getCurrentInstance().showMessageInDialog(message3); 
        // 
       
        bookDao.deleteQueue(tbqueue); 
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully"); 

        RequestContext.getCurrentInstance().showMessageInDialog(message); 
    }
    
    public void validateEmail(FacesContext fc, UIComponent c, Object value)throws ValidatorException {
        String email= (String)value;
        Pattern mask = null;
        mask = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher matcher = mask.matcher(email);
        if (!matcher.matches()) {
           FacesMessage message = new FacesMessage();
           message.setDetail("Invalid E-mail");
           message.setSummary("Invalid E-mail");
           throw new ValidatorException(message);
        }
    }
    
    public void validateGender(FacesContext fc, UIComponent c, Object value)throws ValidatorException {
        String gender = (String)value;
        final String regex = "^(?:m|M|male|Male|f|F|female|Female)$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(gender);
        if(!matcher.matches()) {
           FacesMessage message = new FacesMessage();
           message.setDetail("Invalid Gender");
           message.setSummary("Invalid Gender");
           throw new ValidatorException(message);
        }
    }
    
    public void validatePhone(FacesContext fc, UIComponent c, Object value)throws ValidatorException {
        String phone = (String)value;
        final String regex =  "08[0-9]+$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()) {
           FacesMessage message = new FacesMessage();
           message.setDetail("Invalid Phone Number");
           message.setSummary("Invalid Phone Number");
           throw new ValidatorException(message);
        }
    }
}
