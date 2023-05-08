/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.MessageDAO;
import Model.Pojo.Tbmessage;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author nural
 */
@ManagedBean (name = "messageBean")
@ViewScoped
public class MessageBean {
    
    Tbmessage tbmsg = new Tbmessage();
    private List<Tbmessage> tbmsgs;

    public List<Tbmessage> getTbmsgs() {
        MessageDAO dao = new MessageDAO();
        tbmsgs = dao.showMessage();
        return tbmsgs;
    }

    public void setTbmsgs(List<Tbmessage> tbmsgs) {
        this.tbmsgs = tbmsgs;
    }
    
    public Tbmessage getTbmsg() {
        return tbmsg;
    }

    public void setTbmsg(Tbmessage tbmsg) {
        this.tbmsg = tbmsg;
    }
    
    public void message(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String addMessage() {
        tbmsg.setName(tbmsg.getName());
        tbmsg.setMessage(tbmsg.getMessage());
        boolean status = new MessageDAO().addMessage(tbmsg);
        if (status) {
            message("Message Sent!!");
        } else {
            message("Failed to Send Message!!");
        }
        return null;
    }
    
    
    
    public MessageBean() {
    }
    
}
