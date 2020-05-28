/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.pojo.Login;
import com.dns.pojo.Post;
import com.dns.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shahd
 */

@Configuration
@ComponentScan(basePackages="com.dns")
@Controller
public class RedirectController {
 
    
    
    @RequestMapping(value = "/addPosts", method = RequestMethod.GET)
    public ModelAndView addPosts(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
    hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
         
    ModelAndView mav = new ModelAndView("addNewPost");
  
    return mav;
   
  }
    
     @RequestMapping(value = "/addProcess", method = RequestMethod.POST)
  public ModelAndView addPrcoess(HttpServletRequest request, HttpServletResponse response) {
 
       response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
      
      
      
      String destCountry = request.getParameter("destCountry");
      int totalDays = Integer.parseInt(request.getParameter("totalDays"));
      
         System.out.println("dest"+destCountry);
         System.out.println("total"+totalDays);
      
      
      HttpSession session = request.getSession();
      session.setAttribute("destCountry",destCountry);
      session.setAttribute("totalDays",totalDays);
      
      
      
    ModelAndView mav = null;
    mav = new ModelAndView("addPosts");
    mav.addObject("post",new Post());
   
    
    
    return mav;
  }
    
    
  
    
}
