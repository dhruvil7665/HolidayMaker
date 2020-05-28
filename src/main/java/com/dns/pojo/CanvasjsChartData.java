/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.pojo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author shahd
 */
@Configuration
@ComponentScan(basePackages="com.dns")

public class CanvasjsChartData {
 
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
        static List<Map<Object,Object>> dataPoints2 = new ArrayList<Map<Object,Object>>();
        static List<Map<Object,Object>> dataPoints3 = new ArrayList<Map<Object,Object>>();
        static List<Map<Object,Object>> dataPoints4 = new ArrayList<Map<Object,Object>>();
	
	static {
		map = new HashMap<Object,Object>(); map.put("name", "Chicago"); map.put("y", 21);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("name", "Dallas"); map.put("y", 14);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("name", "Los Angeles"); map.put("y", 14);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("name", "New York"); map.put("y", 29);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("name", "Seattle"); map.put("y", 22);dataPoints1.add(map);
		
		list.add(dataPoints1);
                
//                map = new HashMap<Object,Object>(); map.put("name", "Mesmerizing Amsterdam"); map.put("y", 21);dataPoints2.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Himalayas"); map.put("y", 23);dataPoints2.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Mumbai Madness"); map.put("y", 9);dataPoints2.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Californication"); map.put("y", 20);dataPoints2.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Lost in the Desert"); map.put("y", 27);dataPoints2.add(map);
//		
//		list.add(dataPoints2);
//                
//                map = new HashMap<Object,Object>(); map.put("name", "Chicago"); map.put("y", 21);dataPoints3.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Dallas"); map.put("y", 14);dataPoints3.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Los Angeles"); map.put("y", 14);dataPoints3.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "New York"); map.put("y", 29);dataPoints3.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Seattle"); map.put("y", 22);dataPoints3.add(map);
//		
//		list.add(dataPoints3);
//                
//                map = new HashMap<Object,Object>(); map.put("name", "Chicago"); map.put("y", 21);dataPoints4.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Dallas"); map.put("y", 14);dataPoints4.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Los Angeles"); map.put("y", 14);dataPoints4.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "New York"); map.put("y", 29);dataPoints4.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Seattle"); map.put("y", 22);dataPoints4.add(map);
//		
//		list.add(dataPoints4);
	}
 
	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
      
//	static {
//		map = new HashMap<Object,Object>(); map.put("name", "Dhruvil"); map.put("y", 31);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Yash"); map.put("y", 23);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Kruti"); map.put("y", 22);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Akshat"); map.put("y", 9);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("name", "Dimpi"); map.put("y", 15);dataPoints1.add(map);
//		
//		list.add(dataPoints1);
//	}
// 
//	public static List<List<Map<Object, Object>>> getCanvasjsDataList2() {
//		return list;
//	}
}  

