<%-- 
    Document   : adminViewUsers
    Created on : Apr 17, 2020, 6:51:58 AM
    Author     : shahd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
     
        <style>table,th,td{border: 1px solid black} th{text-align:left} th,td{padding: 5px}</style>
        <title>JSP Page</title>
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
        <h1>User Dashboard</h1>
        
        
        
        
         <table class="table table-hover ">
              <thead>
            <tr class="table-info">
              
             <th scope="col">Username</th>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Number Of Posts</th>
            <th scope="col">Comments given</th>
            <th scope="col">Likes received by Users</th>
            <th scope="col">Options</th>
           
           
            </tr>
              </thead>
              
              <tbody>
            <c:forEach var="user" items="${userList}">
                    <tr>
                   
                    <td scope="row"><c:out value="${user.getUsername()}" /></td>
                    <td><c:out value="${user.getFirstname()}" /></td>
                    <td><c:out value="${user.getLastname()}" /></td>
                    <td><c:out value="${user.getEmail()}" /></td>
                    <td><c:out value="${user.getPhone()}" /></td>
                    <td><c:out value="${user.getPostList().size()}" /></td>
                    <td><c:out value="${commentCnt.get(user)}" /></td>
                    <td><c:out value="${likeCnt.get(user)}" /></td>
                    <td>
                        <form action="adminViewUsers/deleteUser/${user.getId()}">
<!--                        <a href="/deletePost/">-->

                            <button type="submit" class="btn btn-danger">
                            Delete 
                        </button> &nbsp;
                        
                       
                        </form>
                    </td>
                           
                    </tr>
            </c:forEach> 
              </tbody>
        </table>
        
        <% } %>
    </body>
</html>

