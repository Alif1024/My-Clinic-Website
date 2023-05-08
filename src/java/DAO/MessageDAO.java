/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pojo.Tbmessage;
import Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
/**
 *
 * @author nural
 */
public class MessageDAO {
    public boolean addMessage(Tbmessage tbmsg) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(tbmsg);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public List<Tbmessage> showMessage() {
        Session session = null;
        List<Tbmessage> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Tbmessage");
            list = (List<Tbmessage>) query.list();
        } catch(HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return list;
    }
}
