/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.dao.CommentsDao;
import com.dns.dao.PostDao;
import com.dns.dao.UserDao;

import com.dns.exceptions.UserException;
import com.dns.pojo.Comments;
import com.dns.pojo.Iternary;
import com.dns.pojo.Likes;
import com.dns.pojo.Post;
import com.dns.pojo.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shahd
 */

@Configuration
@ComponentScan(basePackages="com.dns")
@Controller
public class destinationController {
    
     @RequestMapping(value = "/viewDestinations", method = RequestMethod.GET)
    public ModelAndView viewPosts(HttpServletRequest hsr, HttpServletResponse hsr1) {
            hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
                    
HttpSession session = hsr.getSession();
       User userName = (User) session.getAttribute("User");
if (userName==null) {
   ModelAndView mav = new ModelAndView("logout");
   return mav;
}
      
         ModelAndView mav = new ModelAndView("viewDestinations");
         
          List<Post> filterpostList = new ArrayList<Post>();
    
         List<Post> postList = new ArrayList<Post>();
         PostDao postDao = new PostDao();
         postList = postDao.getPosts();
         filterpostList=postDao.getPosts();
         mav.addObject("postList",postList);
         
         mav.addObject("filterpostList",filterpostList);
         
        return mav;
  }
  
    
      @RequestMapping(value = "/viewDestinations", method = RequestMethod.POST)
    public ModelAndView filterPosts(HttpServletRequest hsr, HttpServletResponse hsr1) {
           
         ModelAndView mav = new ModelAndView("viewDestinations");
         
         String country = hsr.getParameter("country");
         List<Post> postList = new ArrayList<Post>();
         List<Post> filterpostList = new ArrayList<Post>();
         PostDao postDao = new PostDao();
         postList = postDao.getPostByCountry(country);
          System.out.println("postList"+postList);
         filterpostList=postDao.getPosts();
         
         mav.addObject("postList",postList);
         mav.addObject("filterpostList",filterpostList);
         mav.addObject("count",country);
         
        return mav;
  }
    
    
    
    
    
            
      @RequestMapping(value = "/viewPostInDetail/{id}", method = RequestMethod.GET)
       @ResponseBody
    public ModelAndView viewDetails(HttpServletRequest hsr, HttpServletResponse hsr1, @PathVariable("id") long id) {
           
         ModelAndView mav = new ModelAndView("viewDetails");
        
            User u = (User) hsr.getSession().getAttribute("User");
         
           PostDao postDao = new PostDao();
           Post post = postDao.getPostById(id);
          UserDao userDao = new UserDao();
          
          Set<Likes> likes = post.getLikes();
          Set<Iternary> iter = post.getIterList();
          List<Iternary> iterList = new ArrayList<Iternary>(iter);
          
          Comparator<Iternary> compareById = new Comparator<Iternary>() {
    @Override
    public int compare(Iternary o1, Iternary o2) {
        return Integer.compare(o1.getDayNo(), o2.getDayNo());
    }
};
          
//       for Java8 Using Lamba   
//          Comparator<Iternary> compareById = (Iternary i1, Iternary i2) -> 
//                                    Integer.compare(i1.getDayNo(), i2.getDayNo());
          
          
          Collections.sort(iterList, compareById);
          
          
          boolean liked = false;
          
          
          for(Likes lik : post.getLikes()){
          
          if(lik.getUserID()==u.getId()&&lik.isIsLike()){
          liked=true;
          
          }
          
          }
          
          
          
          
          
          //code for getting number of likes
              Set<Likes> likeList = post.getLikes();
           
           int likeCount =0;
           
           
           for(Likes like: likeList){
           
           if(like.isIsLike()){
           
               likeCount=likeCount+1;
           
           }
           
           }
          
          mav.addObject("likeCount",likeCount);
          List<User> userList = userDao.getAllUsers();           
           mav.addObject("post",post);
           mav.addObject("userList",userList);
           mav.addObject("liked",liked);
           mav.addObject("iterList",iterList);
      
         
        return mav;
  }
    
    
    
     @RequestMapping(value = "/viewPostInDetail/change/{id}", method = RequestMethod.GET)
       @ResponseBody
    public ModelAndView likeChange(HttpServletRequest hsr, HttpServletResponse hsr1, @PathVariable("id") long id) {
           
         ModelAndView mav = new ModelAndView("viewDetails");
        
            User u = (User) hsr.getSession().getAttribute("User");
        
            boolean liked = false;
            String update = hsr.getParameter("like");
            System.out.println("update"+update);
             PostDao postDao = new PostDao();
           Post post = postDao.getPostById(id);
            
            if(update.equalsIgnoreCase("like")){
                liked=true;
                boolean present=false;
                for(Likes lik : post.getLikes()){
            
                if(u.getId()==lik.getUserID()){
                    //System.out.println("inside uuu");
                     present=true;  
                
                } 
            
            }
                if(present){
                
                    for(Likes lik : post.getLikes()){
                    if(u.getId()==lik.getUserID()){
                     lik.setIsLike(true);
                    postDao.updatePost(post);
                
                 } 
            
                
                }
                }
                else{
                
    
                Likes l = new Likes();
                l.setUserID(u.getId());
                l.setIsLike(true);
                l.setPost(post);
                
                post.getLikes().add(l);
                
                postDao.updatePost(post);
                
            }
            }
            else{
            
            liked = false;
            
            for(Likes lik : post.getLikes()){
            
                if(u.getId()==lik.getUserID()){
                    System.out.println("inside uuu");
                    lik.setIsLike(false);
                    postDao.updatePost(post);
                
                }
            
            
            }
            
            
            }
            
          
          UserDao userDao = new UserDao();
          
          Set<Likes> likeList = post.getLikes();
           
           int likeCount =0;
           
           
           for(Likes like: likeList){
           
           if(like.isIsLike()){
           
               likeCount=likeCount+1;
           
           }
           
           }
          
          mav.addObject("likeCount",likeCount);
          
          List<User> userList = userDao.getAllUsers();           
           mav.addObject("post",post);
           mav.addObject("userList",userList);
           mav.addObject("liked",liked);
      
         
        return mav;
  }
    
 
      @RequestMapping(value = "/viewPostInDetail/{id}", method = RequestMethod.POST)
       @ResponseBody
    public ModelAndView viewDetailsChange(HttpServletRequest hsr, HttpServletResponse hsr1, @PathVariable("id") long id) throws UserException {
           
        
        
        
         ModelAndView mav = new ModelAndView("redirect:/viewPostInDetail/{id}");
        
         
         User u = (User) hsr.getSession().getAttribute("User");
         
         long pid = Long.parseLong(hsr.getParameter("postCom"));
         String commentDesc = hsr.getParameter("commentD");
          
         
          System.out.println("user"+u);
          System.out.println("post"+pid);
           PostDao postDao = new PostDao();
           Post post = postDao.getPostById(pid);
           
           Set<Likes> likeList = post.getLikes();
           
           int likeCount =0;
           
           
           for(Likes like: likeList){
           
           if(like.isIsLike()){
           
               likeCount=likeCount+1;
           
           }
           
           }
           
          
//            CommentsDao commentDao = new CommentsDao();
            
            Comments c = new Comments();
            
            c.setPost(post);
            c.setUserId(u.getId());
            c.setCommentDesc(commentDesc);
          
               post.getComments().add(c);
            
          postDao.updatePost(post);
          UserDao userDao = new UserDao();
          
          List<User> userList = userDao.getAllUsers();
      
          
          mav.addObject("likeCount",likeCount);
           mav.addObject("userList",userList);
          mav.addObject("post",post);
        return mav;
  }
    
    
}
