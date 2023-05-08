/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pojo.Tbqueue;
import Util.HibernateUtil;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nural
 */
public class QueueDAO {
    
    public void addQueue(Tbqueue tbqueue) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tbqueue);
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
    
    public void editQueue(Tbqueue tbqueue) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tbqueue);
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
//gagal delete dr yt spanyol
//    public void deleteQueue(Tbqueue tbqueue) {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(tbqueue);
//            session.getTransaction().commit();
//        } catch(HibernateException e) {
//            System.out.println(e.getMessage());
//            session.getTransaction().rollback();
//        } finally {
//            if(session != null) {
//                session.close();
//            }
//        }
//    }
  
    public void deleteQueue(Tbqueue tbqueue) { 
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        try { 
           String name = tbqueue.getName(); 
           session.beginTransaction(); 
           session.delete(tbqueue); 
           session.getTransaction().commit(); 
        } 
        catch (Exception e) { 
           e.printStackTrace(); 
           session.getTransaction().rollback(); 
        } 
        session.close(); 
     }
    
    public List<Tbqueue> showQueue() {
        Session session = null;
        List<Tbqueue> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Tbqueue");
            list = (List<Tbqueue>) query.list();
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
