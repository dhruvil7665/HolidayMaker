<%-- 
    Document   : adminViewPosts
    Created on : Apr 19, 2020, 1:17:10 PM
    Author     : shahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
        
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    </head>
    <body>
    
        <% if( request.getSession().getAttribute("User")==null){ %>
         <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1> You have been logged out.</h1>
	<a href="${contextPath}/index.jsp"><input type="submit" value="Go to the home page"></a><br/><br>
                  
        <% } else{%> 
        
        
    <c:choose>
    <c:when test = "${Role=='Admin'}">
        
        <%@include file="adminHeader.jsp" %>
 
  
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp" %>
    
    </c:otherwise>
    </c:choose>
        <h1>Posts Dashboard</h1>
    
        <table class="table table-hover ">
  <thead>
      <tr class="table-info">
        
        <th scope="col">Title</th>
        <th scope="col">UserName</th>
        <th scope="col">FullName</th>
            <th scope="col">CountryOfTravel</th>
            <th scope="col">MonthOfVisit</th>
             <th scope="col">Last Updated Date</th>
            <th scope="col">Likes</th>
             <th scope="col">Comments</th>
            <th scope="col">Options</th>
         
           
    </tr>
  </thead>
  <tbody>
     
      
            <c:forEach var="post" items="${postList}">
                    <tr>
                   
                    <th scope="row"><c:out value="${post.getTitle()}" /></th>
                    <td><c:out value="${post.getUser().getUsername()}" /></td>
                    <td><c:out value="${post.getUser().getFirstname()}" />  <c:out value="${post.getUser().getFirstname()}" /></td>
                    
                    <td><c:out value="${post.getCountryOfTravel()}" /></td>
                    
                  
                    <td><c:out value="${post.getMonthOfVisit()}" /></td>
                     <td><c:out value="${post.getDate()}" /></td>
                    <td><c:out value="${post.getLikes().size()}" /></td>
                     <td><c:out value="${post.getComments().size()}" /></td>
                    
                    <td>
                        <form action="adminViewPosts/deletePost/${post.getId()}">
<!--                        <a href="/deletePost/">-->

                            <button type="submit" class="btn btn-danger">
                            Delete 
                        </button> 
                        
                       
                        </form>
                    </td>
                    </tr>
            </c:forEach> 
        </table>
        
        <% } %>
    </body>
</html>
