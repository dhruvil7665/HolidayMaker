<%-- 
    Document   : adminHeader
    Created on : Apr 17, 2020, 5:19:06 AM
    Author     : shahd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
   
        <title>JSP Page</title>
           <link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        
          <div class="header">
  <a href="${contextPath}/index.jsp" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="#home">Home</a>
    <a class="active" href="${contextPath}/viewDashboards">View Dashboards</a>
    <a href="${contextPath}/adminUsers">View Users</a>
    <a href="${contextPath}/adminPosts">View Posts</a>
    <a href="#">${sessionScope.User.getFirstname()}</a>
    <a href="logout">LOGOUT</a>
  </div>
</div>
</body>
</html>
