/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;


import com.dns.dao.UserDao;
import com.dns.exceptions.UserException;
import com.dns.pojo.Login;
import com.dns.pojo.User;
import com.dns.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
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
public class RegistrationController {
    @Autowired
     UserService userService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
      
      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
      
      
      
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    
    return mav;
  }
  
  @RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) throws EmailException {
  
      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
      
      
      
   try{   
   UserDao userDao = new UserDao();
   
   int result = userDao.getUserByEmail(user.getEmail());
   
   if (result==1){
       System.out.println("inside ifffffffffffffffffffffffff");
       String error="User Already Exists";
   return new ModelAndView("success", "message", error);
   
   }
   
   else{
   
  userDao.addUser(user);
  Email email= new SimpleEmail();
	           email.setHostName("smtp.googlemail.com");
	           email.setSmtpPort(465);
	           email.setAuthentication("holidaymaker2020@gmail.com", "76658145");
	           email.setSSLOnConnect(true);
	           email.setFrom("holidaymaker2020@gmail.com");
	           email.setSubject("Sign Up Successful");
	           email.setMsg("Welcome to the HolidayMaker\n\n Your account has been successfully created.");
	           email.addTo(user.getEmail());
	           email.send();
   String success="SuccessFully Registered!!";
  return new ModelAndView("success", "message", success);
   }
   
  }
   catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
}
   
}
