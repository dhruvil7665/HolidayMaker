<%-- 
    Document   : addNewPost
    Created on : Apr 14, 2020, 3:17:54 PM
    Author     : shahd
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      
        
        
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
          <link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">
        
    </head>
    <body>
         <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        
        
          <% if( request.getSession().getAttribute("User")==null){ %>
          
          <%@include file="logout.jsp" %>
          
        <% } else{ %> 
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
    
    
    
    
    
  
        
        <form style="width:50%; margin-left:120px; margin-top:50px; " id="regForm" action="addProcess" method="post">
            <div class="form-group" ">
            <label>Enter your Country of Travel</label>
            <input class="form-control" required="required" pattern="[a-zA-Z]+" title="Country Name can only be in Letters" type="text" name="destCountry" id="destCountry"/>
               </div>  
            <div class="form-group" ">
            <label>How many days you traveled</label>
            <input  class="form-control" type="text" name="totalDays" id="totalsDays" pattern="^[0-9]+$" minlength="1" maxlength="3" title="Enter Correct Value for Days" required="required"/>
            </div>
            <button class="btn btn-primary" type="submit" name="submit">Confirm</button>
            
            
        </form>
            
                     <% } %>
                     
                     
                     <div style="width: 100%; height: 70px; "></div>
                          
                     
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
    
        
    </body>
</html>
