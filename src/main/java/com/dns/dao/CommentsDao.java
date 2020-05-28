/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.dao;

import com.dns.exceptions.UserException;
import com.dns.pojo.Comments;
import com.dns.pojo.Post;
import com.dns.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shahd
 */


@Repository
public class CommentsDao {
    
    
    
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

    public List<Comments> getCommentsByUser(User user) {
        List<Comments> comments = new ArrayList<Comments>();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Comments where userID= :id");
            q.setLong("id", user.getId());
            comments = q.list();
           
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return comments;
    }
    
    public Post getPostById(long id){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Post where postID= :id");
            q.setLong("id", id);
            Post post = (Post) q.uniqueResult();
            return post;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return null;
    }
    
     public List<Post> getPostByUser(User user){
         List<Post> posts = new ArrayList<Post>();
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Post where userID= :id");
            q.setLong("id", user.getId());
            posts = q.list();
             commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return posts;
    }
     
      public List<Post> getPostByCountry(String country){
         List<Post> posts = new ArrayList<Post>();
        try{
            beginTransaction();
            Criteria criteria = session.createCriteria(Post.class);
            criteria.add(Restrictions.eq("countryOfTravel",country));
            posts=(ArrayList<Post>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
         
            
             commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return posts;
    }
      
      
      
      
       public int addComment(Comments comment) throws UserException {
        int result = 0;
        try {
//            Post u = new Post();
//            u.setTitle(post.getTitle());
//            u.setCountryOfTravel(post.getCountryOfTravel());
//            u.setTravelledFrom(post.getTravelledFrom());
//            u.setIterList(post.getIterList());
//          for(Iternary i : u.getIterList()){
//              i.setPost(u);
//          }
            beginTransaction();
            getSession().save(comment);
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
}
