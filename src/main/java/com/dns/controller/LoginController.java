/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.dao.UserDao;
import com.dns.pojo.Login;
import com.dns.pojo.User;
import com.dns.service.UserService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author shahd
 */

@Configuration
@ComponentScan(basePackages="com.dns")
@Controller
public class LoginController{
    
     @Autowired
     UserService userService;
//     
//       @Inject
//       UserDao userDao;
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
            
    hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
        
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @Valid @ModelAttribute("login") Login login, BindingResult br){
      
//      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
//response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
//response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
//response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility  
                    


       

HttpSession session = request.getSession();
            
    ModelAndView mav = null;
//    UserDao userDao = new UserDao();

if(br.hasErrors())  
        {  
            
            mav = new ModelAndView("error");
            mav.addObject("errorMessage","Username or password is wrong");
        }  
    

    User user = userService.validateUser(login);
//       User user = userDao.validateUser(login);
    if (null != user) {
    
        
    mav = new ModelAndView("home");
    mav.addObject("firstname", user.getFirstname());
    mav.addObject("Role",user.getRole());
   
    
    session.setAttribute("User", user);
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
    
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
            
        hsr1.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
hsr1.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
hsr1.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
hsr1.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility  
      
    ModelAndView mav = new ModelAndView("logout");
    hsr.getSession().removeAttribute("User");
    hsr.getSession().invalidate();
    
   
    return mav;
  }
  
  
}
