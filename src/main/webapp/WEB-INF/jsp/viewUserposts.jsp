<%-- 
    Document   : viewUserposts
    Created on : Apr 15, 2020, 12:05:26 AM
    Author     : shahd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<!--        <style>table,th,td{border: 1px solid black} th{text-align:left} th,td{padding: 5px}</style>-->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
    
        
         <% if( request.getSession().getAttribute("User")==null){ %>
         <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1> You have been logged out.</h1>
	<a href="${contextPath}/index.jsp"><input type="submit" value="Go to the home page"></a><br/><br>
                  
        <% } else{%> 
        
        
    <c:choose>
    <c:when test = "${Role=='User'}">
        
        <%@include file="userHeader.jsp" %>
 
  
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp" %>
    
    </c:otherwise>
    </c:choose>
        
    
        <table class="table table-hover ">
  <thead>
      <tr class="table-info">
        
        <th scope="col">Title</th>
            <th scope="col">CountryOfTravel</th>
            <th scope="col">Source Country</th>
            <th scope="col">MonthOfVisit</th>
             <th scope="col">Last Updated Date</th>
            <th scope="col">Likes</th>
             <th scope="col">Comments</th>
            <th scope="col">Delete Post</th>
            <th scope="col">Update Post</th>
           
    </tr>
  </thead>
  <tbody>
     
      
            <c:forEach var="post" items="${postList}">
                    <tr>
                   
                    <th scope="row"><c:out value="${post.getTitle()}" /></th>
                    <td><c:out value="${post.getCountryOfTravel()}" /></td>
                    <td><c:out value="${post.getTravelledFrom()}" /></td>
                  
                    <td><c:out value="${post.getMonthOfVisit()}" /></td>
                     <td><c:out value="${post.getDate()}" /></td>
                    <td><c:out value="${post.getLikes().size()}" /></td>
                     <td><c:out value="${post.getComments().size()}" /></td>
                    
                    <td>
                        <form action="viewUserPosts/deletePost/${post.getId()}" method="POST">
<!--                        <a href="/deletePost/">-->

                            <button type="submit" class="btn btn-danger">
                            Delete 
                        </button> &nbsp;
                        
                       
                        </form>
                    </td>
                             <td>
                        <form action="viewUserPosts/updatePost/${post.getId()}">
                        <button type="submit" class="btn btn-success">
<!--                        <a href="/updatePost/${post.getId()}">-->
                            Update 
<!--                        </a>-->
                        </button>
                        </form>
                    </td>
                    </tr>
            </c:forEach> 
        </table>
        
        <% } %>
    </body>
</html>
