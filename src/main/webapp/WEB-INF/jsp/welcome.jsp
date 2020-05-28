<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value='/resources/header.css' />" rel="stylesheet">
<title>Welcome</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
              
 
    <c:choose>
    <c:when test = "${Role=='User'}">
        
    
   <div class="header">
  <a href="#default" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="#home">Home</a>
    <a class="active" href="${contextPath}/HolidayMaker/viewDestinations">Explore Destinations</a>
    <a class="active" href="${contextPath}/addPosts">Add New Travel Posts</a>
    <a class="active" href="${contextPath}/viewUserPosts">View Your Posts</a>
  </div>
</div>
  
    </c:when>
    <c:otherwise>
                
   <div class="header">
  <a href="#default" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="#home">Home</a>
    <a class="active" href="${contextPath}/HolidayMaker/viewDestinations">Explore Destinations</a>
    <a class="active" href="${contextPath}/login">Login</a>
    <a class="active" href="${contextPath}/register">Register</a>
  </div>
</div>
    
    </c:otherwise>
    </c:choose>
	<table>
		<tr>
			<td>Welcome ${firstname}</td>
                        <td>Role ${Role}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="index.jsp">Home</a></td>
		</tr>
	</table>
                
                
                <h1><a href='addPosts'></a>Add Travel Posts</h1>
               
</body>
</html>