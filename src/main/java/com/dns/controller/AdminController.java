/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.dao.CommentsDao;
import com.dns.dao.PostDao;
import com.dns.dao.UserDao;
import com.dns.pojo.Comments;
import com.dns.pojo.Post;
import com.dns.pojo.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
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
public class AdminController {
    
    
     
    @RequestMapping(value = "/adminViewUsers", method = RequestMethod.GET)
    public ModelAndView viewUsers(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
    hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
         
    UserDao userDao = new UserDao();
     PostDao postDao = new PostDao();
     CommentsDao commentDao = new CommentsDao();
    
    List<User> userList = userDao.getUsersForAdmin();
   
    
    //Calculate number of comments
    Map<User,Integer> commentCnt = new HashMap<User,Integer>();
    
   for( User user : userList){
   
       List<Comments> cList = commentDao.getCommentsByUser(user);
       
       commentCnt.put(user,cList.size() );
   
   
   }
   
    //Calculate number of likes
    
     Map<User,Integer> likeCnt = new HashMap<User,Integer>();
  
    for(User user : userList){
    
        int likeCount=0;
        
        List<Post> postList = postDao.getPostByUser(user);
        for(Post post : postList){
        
        likeCount=likeCount+post.getLikes().size();
        
        }
        
        likeCnt.put(user, likeCount);
        
    
    
    
    }
     
     
    
    

    ModelAndView mav = new ModelAndView("adminViewUsers");
  
    
    mav.addObject("likeCnt",likeCnt);
    mav.addObject("commentCnt",commentCnt);
    mav.addObject("userList",userList);
    return mav;
   
  }
    
    
    
     @RequestMapping(value="/adminViewUsers/deleteUser/{id}", method=RequestMethod.GET )
    @ResponseBody
    public ModelAndView deleteUserPost(HttpServletRequest hsr, HttpServletResponse hsr1,  @PathVariable("id") long id) throws Exception {
           
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
      
      
        //@RequestParam("id") String id
        System.out.println("ID " + id);
        System.out.println("inside delete");
        
        UserDao userDao = new UserDao();
        int result = userDao.deleteUserById(id);
        System.out.println("result"+result);
        
       
        
         ModelAndView mav = new ModelAndView("redirect:/adminViewUsers");
 
         //MAPS
        
     PostDao postDao = new PostDao();
     CommentsDao commentDao = new CommentsDao();
    
    List<User> userList = userDao.getUsersForAdmin();
   
    
    //Calculate number of comments
    Map<User,Integer> commentCnt = new HashMap<User,Integer>();
    
   for( User user : userList){
   
       List<Comments> cList = commentDao.getCommentsByUser(user);
       
       commentCnt.put(user,cList.size() );
   
   
   }
   
    //Calculate number of likes
    
     Map<User,Integer> likeCnt = new HashMap<User,Integer>();
  
    for(User user : userList){
    
        int likeCount=0;
        
        List<Post> postList = postDao.getPostByUser(user);
        for(Post post : postList){
        
        likeCount=likeCount+post.getLikes().size();
        
        }
        
        likeCnt.put(user, likeCount);
  
    }

         mav.addObject("likeCnt",likeCnt);
    mav.addObject("commentCnt",commentCnt);
    mav.addObject("userList",userList);
    return mav;
       
  }
    
    
    
     
     @RequestMapping(value="/adminViewPosts/deletePost/{id}", method=RequestMethod.GET )
    @ResponseBody
    public ModelAndView deletePost(HttpServletRequest hsr, HttpServletResponse hsr1,  @PathVariable("id") long id) throws Exception {
           
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
      
      
        //@RequestParam("id") String id
      
   
        
       
        
         ModelAndView mav = new ModelAndView("redirect:/adminPosts");
 
         //MAPS
        
     PostDao postDao = new PostDao();
    int result = postDao.deletePostById(id);

   
 List<Post> adminPostList = postDao.getPosts();

    mav.addObject("postList",adminPostList);
    return mav;
       
  }
   
   
    
   @RequestMapping(value = "/adminPosts", method = RequestMethod.GET)
    public ModelAndView viewPosts(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
    hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
         
    UserDao userDao = new UserDao();
     PostDao postDao = new PostDao();
     CommentsDao commentDao = new CommentsDao();
    
     List<Post> adminPostList = postDao.getPosts();
     
     
     
     
    List<User> userList = userDao.getUsersForAdmin();
  
    //Calculate number of comments
    Map<User,Integer> commentCnt = new HashMap<User,Integer>();
   for( User user : userList){
       List<Comments> cList = commentDao.getCommentsByUser(user);
       commentCnt.put(user,cList.size() );
   }
    //Calculate number of likes
    
     Map<User,Integer> likeCnt = new HashMap<User,Integer>();
    for(User user : userList){
        int likeCount=0;
        List<Post> postList = postDao.getPostByUser(user);
        for(Post post : postList){
        likeCount=likeCount+post.getLikes().size();
        }
        likeCnt.put(user, likeCount);
    }
     
     
    
    

    ModelAndView mav = new ModelAndView("adminViewPosts");
  
    
    mav.addObject("likeCnt",likeCnt);
    mav.addObject("commentCnt",commentCnt);
    mav.addObject("userList",userList);
    mav.addObject("postList",adminPostList);
    return mav;
   
  }
    
    
    
     private static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
    }
    
    
}
