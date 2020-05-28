/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.dao;

import com.dns.exceptions.UserException;
import com.dns.pojo.Iternary;
import com.dns.pojo.Login;
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
public class PostDao {
    
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

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<Post>();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Post");
            posts = q.list();
            System.out.println("post"+posts);
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return posts;
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

    public int addPost(Post post) throws UserException {
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
            getSession().save(post);
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
    
    public int updatePost(Post post){
        int result = 0;
        try{
            beginTransaction();
//            Query q = getSession().createQuery("from Post where postID= :id");
//            q.setLong("id", post.getId());
//            Post p = (Post) q.uniqueResult();
//       
//            p.setTitle(post.getTitle());
//            p.setCountryOfTravel(post.getCountryOfTravel());
//            p.setTravelledFrom(post.getTravelledFrom());
//            p.setComments(p.getComments());
//            p.setEndDate(post.getEndDate());
//            p.setStartDate(post.getStartDate());
//            p.setImages(post.getImages());
//            p.setLikes(post.getLikes());
//            p.setTravelCheckList(post.getTravelCheckList());
//            p.setIterList(post.getIterList());
//            p.setMonthOfVisit(post.getMonthOfVisit());
           
            getSession().saveOrUpdate(post);
            commit();
            result = 1;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return result;
    }

    public int deletePostById(long id) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Post where postID= :id");
            q.setLong("id", id);
            Post postToDelete = (Post) q.uniqueResult();
//           UserDao userDao = new UserDao();
//           User u = userDao.getUserById(postToDelete.getUser().getId());
//            System.out.println("USER IN POST DAO"+u);
//             System.out.println("user postlist"+u.getPostList()); 
//           u.getPostList().remove(postToDelete);
//            System.out.println("user postlist"+u.getPostList()); 
            getSession().delete(postToDelete);
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
