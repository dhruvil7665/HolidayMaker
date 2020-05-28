<%-- 
    Document   : updateUserpost
    Created on : Apr 15, 2020, 4:53:17 PM
    Author     : shahd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.dns.pojo.Iternary"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="resources/assets/mail/jqBootstrapValidation.js"></script>
        <script src="resources/assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="resources/js/scripts.js"></script>
        
     <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" />
<link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
          
        <div class="header">
  <a href="index.jsp" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
      <a class="onHover" style="margin-right: 12px;"class="active" href="${contextPath}/index.jsp">Home</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/viewDestinations">Explore Destinations</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/addPosts">Add New Travel Posts</a>
    <a class="onHover" style="margin-right: 22px;" href="${contextPath}/viewUserPosts">View Your Posts</a>
    <a href="#" style="font-family: sans-serif">${sessionScope.User.getFirstname()}</a>
    <a class="active" href="logout">LOGOUT</a>
  </div>
        
        </div>
        
       
              
        <form:form  style="width:50%; margin-left:120px; margin-top:50px; " id="postUpdate" modelAttribute="post" action="${contextPath}/updateProcess"
		>
                <div class="form-group" ">
                                <form:label path="title">Title for your Post</form:label>
                                <form:input class="form-control" required="required" pattern="[a-zA-Z]+"  path="title" name="title" id="title" title="Title should only contain letters" />
				
			<form:hidden path="id" name="id" id="id" />
                        <form:hidden path="imageList" name="imageList" id="imageList"/>
                        
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
                                 <c:forEach var="iter" items="${post.getIterList()}"> 
                                <div class="form-group" ">
                               
                          <label><c:out value="Day ${iter.getDayNo()}"></c:out></label>
    <input type='hidden' name="ID${iter.getDayNo()}" value="${iter.getId()}" >
    <textarea class="form-control" required="required" name="Day${iter.getDayNo()}" value="${iter.getDescription()}" >${iter.getDescription()}</textarea>
       
       

                                </div>
                   </c:forEach>
                   
                                
                              
				
			
                        
                </div>                

                                
                              
                                    <div>
                <form:button id="postUpdate" name="postUpdate" class="btn btn-success">Update Post</form:button>
                                    </div>
                
                
                
	</form:form> 
              
       
              
      
              
    <div style="height: 200px;">
        
        
    </div>
              
                  <!-- Footer-->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Location</h4>
                        <p class="lead mb-0">1572 Tremont Street<br />Boston, MA 02120</p>
                    </div>
                    <!-- Footer Social Icons-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Around the Web</h4>
                        <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-facebook-f"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-twitter"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-linkedin-in"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-dribbble"></i></a>
                    </div>
                    <!-- Footer About Text-->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">About Holiday Maker</h4>
                        <p class="lead mb-0">A Travel Website Enhancing Travel Experiences of Users worldwide</a>.</p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Copyright Section-->
        <section class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright © HolidayMaker 2020</small></div>
        </section>
    
</html>
