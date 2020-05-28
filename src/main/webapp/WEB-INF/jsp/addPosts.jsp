<%-- 
    Document   : addPosts
    Created on : Apr 13, 2020, 12:20:15 PM
    Author     : shahd
--%>




<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
   <link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
     <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" />



        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="resources/assets/mail/jqBootstrapValidation.js"></script>
        <script src="resources/assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="resources/js/scripts.js"></script>
        
        
    </head>
     
    <body>
        
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        
          
        
        
      
                <div class="header">
  <a href="index.jsp" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
      <a class="onHover" style="margin-right: 12px;"class="active" href="#home">Home</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/viewDestinations">Explore Destinations</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/addPosts">Add New Travel Posts</a>
    <a class="onHover" style="margin-right: 22px;" href="${contextPath}/viewUserPosts">View Your Posts</a>
    <a href="#" style="font-family: sans-serif">${sessionScope.User.getFirstname()}</a>
    <a class="active" href="logout">LOGOUT</a>
  </div>
        
                </div>
       
        
       
        
        <h1>Add your Post here</h1>
        
        
        
        
        
        
        <form:form  style="width:50%; margin-left:120px; margin-top:50px; " id="postForm" modelAttribute="post" action="postProcess"
		method="post"  enctype="multipart/form-data">
                <div class="form-group" ">
                                <form:label path="title">Title for your Post</form:label>
                                <form:input class="form-control" required="required" pattern="[a-zA-Z]+"  path="title" name="title" id="title" title="Title should only contain letters" />
				
			
                        
                </div>  
                                 <div class="form-group" ">
                                <form:label path="travelledFrom">Source Country</form:label>
                                <form:input class="form-control" required="required" pattern="[a-zA-Z]+"  path="travelledFrom" name="travelledFrom" id="travelledFrom" title="Counrty should only contain letters" />
				
			
                        
                </div>  
                                 <div class="form-group" ">
                                <form:label path="countryOfTravel">Destination Country</form:label>
                                <form:input class="form-control" required="required" pattern="[a-zA-Z]+"  path="countryOfTravel" name="countryOfTravel" id="countryOfTravel" title="Country should only contain letters" />
				
			
                        
                </div>  
                </div>  
                                 <div class="form-group" ">
                                <form:label path="monthOfVisit">Month of Your Visit</form:label>
                                <form:input class="form-control" required="required" pattern="[A-Z]+" minlength="3" maxlength="3" path="monthOfVisit" name="monthOfVisit" id="monthOfVisit" title="Month Should be in format : OCT" />
				
			
                        
                </div>                  
                                
                                <h3>Itinerary</h3>       
                                
  <%  
                                int days = (Integer) session.getAttribute("totalDays");
                            
                                for(int i = 1; i<=days;i++){
                                    String day ="Day"+i;
                                    pageContext.setAttribute("day", day);
			
%>
                        
                        <div class="form-group" ">
                       <label><c:out value="${day}">Day ${day}</c:out></label>
                       <textarea class="form-control" required type='text' name="${day}" maxlength="255"></textarea>
</div>
                                <%
                                    }
                                    %>
                                
                                    <div class="form-group">
                                    
                                        <label for="images">Upload Images</label>
                                <input  class="form-control-file" required type='file' name="file" accept="image/*"></input>
                                    </div>
                                    <div>
                <form:button id="postadd" name="postadd" class="btn btn-success">Add Post</form:button>
                                    </div>
                
                
                
	</form:form>
        
        
      
    </body>
</html>
