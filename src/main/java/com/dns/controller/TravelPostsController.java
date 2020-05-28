/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;


import com.dns.dao.PostDao;
import com.dns.exceptions.UserException;
import com.dns.pojo.Login;
import com.dns.pojo.Post;
import com.dns.pojo.User;
import com.dns.pojo.Iternary;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author shahd
 */

@Configuration
@ComponentScan(basePackages="com.dns")
@Controller
public class TravelPostsController {
    
    
    
     @RequestMapping(value = "/viewUserPosts", method = RequestMethod.GET)
    public ModelAndView viewPosts(HttpServletRequest hsr, HttpServletResponse hsr1) {
           hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        ModelAndView mav = null;
HttpSession session = hsr.getSession();
       User userName = (User) session.getAttribute("User");
if (userName==null) {
  mav = new ModelAndView("logout");
   return mav;
}

else{ 
       
        
         mav = new ModelAndView("viewUserposts");
         User u = (User) session.getAttribute("User");
         List<Post> postList = new ArrayList<Post>();
         PostDao postDao = new PostDao();
       
         String role = u.getRole();
         
         postList = postDao.getPostByUser(u);
         mav.addObject("Role",role);
         mav.addObject("postList",postList);
}
        return mav;
  }
  
    
    
    @RequestMapping(value="/viewUserPosts/deletePost/{id}", method=RequestMethod.POST )
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
        
        PostDao postDao = new PostDao();
        int result = postDao.deletePostById(id);
        System.out.println("result"+result);
        
       
        
         ModelAndView mav = new ModelAndView("redirect:/viewUserPosts");
         User u = (User) session.getAttribute("User");
         List<Post> postList = new ArrayList<Post>();
         String role = u.getRole();
         postList = postDao.getPostByUser(u);
         System.out.println("post"+postList);
         mav.addObject("Role",role);
         mav.addObject("postList",postList);
         
        return mav;
  }
    
     @RequestMapping(value="/viewUserPosts/updatePost/{id}", method=RequestMethod.GET )
    @ResponseBody
    public ModelAndView updateUserPost(HttpServletRequest hsr, HttpServletResponse hsr1,  @PathVariable("id") long id) throws Exception {
           
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
       
        
        PostDao postDao = new PostDao();
        Post post = postDao.getPostById(id);
       
        
        
 ModelAndView mav = new ModelAndView("updateUserpost");
         
       
         
     
         System.out.println("postUser"+post.getUser());
         
         mav.addObject("post",post);
         
        return mav;
  }
    

    
  @RequestMapping(value = "/postProcess", method = RequestMethod.POST)
  public ModelAndView newPost(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("post") Post post,@RequestParam CommonsMultipartFile file) throws UserException {
      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
              
HttpSession session = request.getSession();
       User userName = (User) session.getAttribute("User");
if (userName==null) {
   ModelAndView mav = new ModelAndView("logout");
   return mav;
}
      
    ModelAndView mav = null;
      System.out.println("coutry"+post.getCountryOfTravel());
      System.out.println("travl"+post.getTravelledFrom());
      System.out.println("title"+post.getTitle());
      
      
      int days = (Integer) session.getAttribute("totalDays");
     String images = request.getParameter("images");
     
//     post.setImageList(images);
//      System.out.println("images"+images);
      String path=session.getServletContext().getRealPath("/");  
        String filename=file.getOriginalFilename();  
          
        String storedPath= "C:\\Users\\shahd\\Documents\\Web Tools\\Netbeans\\HolidayMaker_MileStone3\\HolidayMaker\\src\\main\\webapp\\resources\\images";
        
        System.out.println("path"+path);
        System.out.println("filename"+filename);
        
        //later surround in try catch
        try{
        byte barr[]=file.getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(storedPath+"/"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
  }catch(Exception e){System.out.println(e);}  
      
      
      
      
      post.setImageList(filename);
      
      
      for(int i =1 ; i<=days;i++){
          Iternary iter = new Iternary();
          iter.setPost(post);
          iter.setDescription(request.getParameter("Day"+i));
          iter.setDayNo(i);
          System.out.println("day"+request.getParameter("Day"+i));
          
         
          post.getIterList().add(iter);
      }
      
      System.out.println("iterList"+post.getIterList());
      
      PostDao postDao = new PostDao();
     
      post.setUser((User) request.getSession().getAttribute("User"));
      
      String pattern = "MM-dd-yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
      post.setDate(date);
      int result = postDao.addPost(post);
      
      
      if(result==0){
          
          mav= new ModelAndView("error");
          
      }else{
            
     
          
          mav=new ModelAndView("postAdded");
      
      }
      
//    UserDao userDao = new UserDao();
  //  User user = userService.validateUser(login);
    
//       User user = userDao.validateUser(login);
//    if (null != user) {
//    mav = new ModelAndView("welcome");
//    mav.addObject("firstname", user.getFirstname());
//    mav.addObject("Role",user.getRole());
//    } else {
//    mav = new ModelAndView("login");
//    mav.addObject("message", "Username or Password is wrong!!");
//    }
//    return mav;
return mav;
 }
  
  
    
  @RequestMapping(value = "/updateProcess", method = RequestMethod.POST )
  public ModelAndView updatePost(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("post") Post post) throws UserException {
      
      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
              
HttpSession session = request.getSession();
       User userName = (User) session.getAttribute("User");
if (userName==null) {
   ModelAndView mav = new ModelAndView("logout");
   return mav;
}
      
      

      ModelAndView mav = null;
      System.out.println("coutry"+post.getCountryOfTravel());
      System.out.println("travl"+post.getTravelledFrom());
      System.out.println("title"+post.getTitle());
      
      
   
      PostDao postDao = new PostDao();
     
      Post orginalPost = postDao.getPostById(post.getId());
      
      int days = orginalPost.getIterList().size();
      
      
      for(int i =1 ; i<=days;i++){
          Iternary iter = new Iternary();
          iter.setPost(post);
          iter.setId(Long.parseLong(request.getParameter("ID"+i)));
          iter.setDescription(request.getParameter("Day"+i));
          iter.setDayNo(i);
          System.out.println("day"+request.getParameter("Day"+i));
          
         
          post.getIterList().add(iter);
      }
      
      
      
      System.out.println("post"+post.getUser());
      
      post.setUser(userName);
       String pattern = "MM-dd-yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
      post.setDate(date);
     
      int result = postDao.updatePost(post);
      
      
      if(result==0){
          
          mav= new ModelAndView("error");
          
      }else{
            
     
            
  
          mav=new ModelAndView("postAdded");
      
      }
      
//    UserDao userDao = new UserDao();
  //  User user = userService.validateUser(login);
    
//       User user = userDao.validateUser(login);
//    if (null != user) {
//    mav = new ModelAndView("welcome");
//    mav.addObject("firstname", user.getFirstname());
//    mav.addObject("Role",user.getRole());
//    } else {
//    mav = new ModelAndView("login");
//    mav.addObject("message", "Username or Password is wrong!!");
//    }
//    return mav;
return mav;
 }
  
  
  
}
