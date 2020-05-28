/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.interceptor;

import java.util.Enumeration;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author shahd
 */
public class Interceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = Logger.getLogger("FilterInterceptor");
    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
         logger.info(" Pre handle ");
                  
            Enumeration<String> parameters = hsr.getParameterNames();
            
            while(parameters.hasMoreElements()){
                String paramN = parameters.nextElement();
                String paramV = hsr.getParameter(paramN);
                String updatedParamValue = cleanXSS(paramV);
                hsr.setAttribute(paramN,updatedParamValue);
            
            }
            return true;
           // RequestWrapper result = new RequestWrapper(hsr);
         
               // String value = hsr.getParameter("key");
                //System.out.println("prehandleeeee:"+value);
//                
//               value = value.replaceAll("eval\\((.*)\\)", "");
//		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
//
//		value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
//		value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
//		value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
//		value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
//                value=value.replaceAll("(\\%27)|\\'","");
//                
//                
//                System.out.println("prehandleeeee:"+value);
                
              //  hsr.setAttribute("key",value);
                
                
             //System.out.println("prehandle: "+result.getParameter(browse));   
            
         
            
    
           
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
        logger.info("in post handler");
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        
    }
    private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		logger.info("InnXSS RequestWrapper ..............." + value);
		//value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		//value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		//value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

		value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
		value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
		value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
		value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
               // value=value.replaceAll("(\\%27)|\\'","");  quotes
                value=value.replaceAll("'\\s*(and|or|xor|OR|&&|\\|\\|)\\s*('|[0-9]|`?[a-z\\._-]+`?\\s*=|[a-z]+\\s*\\()", "");
               // value=value.replaceAll("\\w*", "");
                //value=value.replaceAll("(\\%6F)|o|(\\%4F)(\\%72)|r|(\\%52)", "");
              //  value = value.replace("\' "'","\' "'");
		value = value.replaceAll("<script>", "");
		value = value.replaceAll("</script>", "");
		logger.info("OutnXSS RequestWrapper ........ value ......." + value);
		return value;
                
                
                
               
                
                
                
	}

}
