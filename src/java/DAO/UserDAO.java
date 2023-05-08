/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Pojo.Tbuser;
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
public class UserDAO {
    
    public boolean addUser(Tbuser tbuser) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(tbuser);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public void editUser(Tbuser tbuser) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tbuser);
            session.getTransaction().commit();
        } catch(HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
    
    public void deleteUser(Tbuser tbuser) { 
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        try { 
           String name = tbuser.getEmail(); 
           session.beginTransaction(); 
           session.delete(tbuser); 
           session.getTransaction().commit(); 
        } 
        catch (Exception e) { 
           e.printStackTrace(); 
           session.getTransaction().rollback(); 
        } 
        session.close(); 
     }
    
    public List<Tbuser> showUser() {
        Session session = null;
        List<Tbuser> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Tbuser");
            list = (List<Tbuser>) query.list();
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
