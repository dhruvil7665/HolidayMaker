/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.dao;

import com.dns.exceptions.UserException;
import com.dns.pojo.Login;
import com.dns.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author shahd
 */
@Repository
public class UserDao {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    private Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();;
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }


    

public List<User> getUsersForAdmin() {
        List<User> users = new ArrayList<User>();
        try {
            beginTransaction();
              Criteria cr = session.createCriteria(User.class);
              cr.add(Restrictions.like("role", "User"));
               users =(ArrayList<User>) cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
           
            
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return users;
    }


     public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from User");
            users = q.list();
            System.out.println("post"+users);
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return users;
    }
     
     
     public int getUserByEmail(String email){
        int result = 0;
         try{
            beginTransaction();
            Query q = getSession().createQuery("from User where email= :email");
            q.setString("email", email);
            User msg = (User) q.uniqueResult();
             System.out.println("userbyemail"+msg);
            if(msg!=null){
                result=1;
            }
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return result;
    }
    
    
    public User getUserById(long id){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from User where userID= :id");
            q.setLong("id", id);
            User msg = (User) q.uniqueResult();
            return msg;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return null;
    }
    
    public User validateUser(Login login){
       String username = login.getEmail();
       String password = login.getPassword();
       User user = null;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from User where email = :user and password= :pass");
            q.setString("user",username);
            q.setString("pass",password);
            //q.setLong("id", id);
            System.out.println("Quni"+q.uniqueResult());
            if(q.uniqueResult()!=null){
                user=(User)q.uniqueResult();
            }
           commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return user;
    }

    public int addUser(User user) throws UserException {
        int result = 0;
        try {
//            User u = new User();
//            u.setUsername(user.getUsername());
//            u.setPassword(user.getPassword());
//            u.setEmail(user.getEmail());
//            u.setFirstname(user.getFirstname());
//            u.setLastname(user.getLastname());
//            u.setRole("User");
//            u.setAddress(user.getAddress());
//            u.setPhone(user.getPhone());
            user.setRole("User");
            beginTransaction();
            getSession().save(user);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
            throw new UserException("Exception while creating user: " + e.getMessage());
        } finally {
            close();
        }
        return result;
    }
    
//    public int updateMovies(long id, String title, String actor, String actress, String genre, int date){
//        int result = 0;
//        try{
//            beginTransaction();
//            Query q = getSession().createQuery("from Movies where movieID= :id");
//            q.setLong("id", id);
//            User u = (Movies) q.uniqueResult();
//            msg.setTitle(title);
//            msg.setActor(actor);
//            msg.setActress(actress);
//            msg.setGenre(genre);
//            msg.setYear(date);
//            getSession().save(msg);
//            commit();
//            result = 1;
//        } catch(HibernateException ex){
//            ex.printStackTrace();
//            rollbackTransaction();
//        } finally{
//            close();
//        }
//        return result;
//    }

    public int deleteUserById(long id) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from User where userID= :id");
            q.setLong("id", id);
            User userToDelete = (User) q.uniqueResult();
             getSession().delete(userToDelete);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }
}
