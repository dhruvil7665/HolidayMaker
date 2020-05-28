/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shahd
 */
@Configuration
@ComponentScan(basePackages="com.dns")
@Controller
public class EmailController {
    
  @RequestMapping(value = "HolidayMaker/sendEmail", method = RequestMethod.POST)
  public ModelAndView contactEmail(HttpServletRequest request, HttpServletResponse response, @RequestParam String name,@RequestParam String phone,@RequestParam String email,@RequestParam String message) throws EmailException {
      
      response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    
        
      System.out.println("name"+name);
      System.out.println("phone"+phone);
      
      Email emailT= new SimpleEmail();
	           emailT.setHostName("smtp.googlemail.com");
	           emailT.setSmtpPort(465);
	           emailT.setAuthentication("holidaymaker2020@gmail.com", "76658145");
	           emailT.setSSLOnConnect(true);
	           emailT.setFrom(email);
	           emailT.setSubject("Holiday Maker Contact From "+name);
	           emailT.setMsg("Message From "+name+"\n\n "+message);
	           emailT.addTo("holidaymaker2020@gmail.com");
	           emailT.send();
      
    ModelAndView mav = new ModelAndView("error");
   
    
    return mav;
  }
}
