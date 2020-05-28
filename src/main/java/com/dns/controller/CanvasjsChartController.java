/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.controller;

import com.dns.service.CanvasjsChartService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

public class CanvasjsChartController {
 
	@Autowired
	private CanvasjsChartService canvasjsChartService;
 
        @RequestMapping(value="/viewDashboards", method = RequestMethod.GET)
        public ModelAndView dash(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
            ModelAndView mav = new ModelAndView("dashboards");
            List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
            
            //List<List<Map<Object, Object>>> canvasjsDataList2 = canvasjsChartService.getCanvasjsChartData();
            mav.addObject("dataPointsList",canvasjsDataList);
            
            
            return mav;
        
        }
        
        
        
	
}               