<%-- 
    Document   : viewDetails
    Created on : Apr 16, 2020, 11:47:44 PM
    Author     : shahd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
           <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>



        <link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/7c955c137b.js" crossorigin="anonymous"></script>

<!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="reources/css/shop-item.css" rel="stylesheet">

  
  
      
  
        <title>JSP Page</title>
         
      
    </head>
    <body>
         <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
            <c:choose>
    <c:when test = "${Role=='User'}">
        
       <div class="header">
  <a href="index.jsp" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
      <a class="onHover" style="margin-right: 12px;"class="active" href="index.jsp">Home</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/viewDestinations">Explore Destinations</a>
    <a class="onHover" style="margin-right: 12px;" href="${contextPath}/addPosts">Add New Travel Posts</a>
    <a class="onHover" style="margin-right: 22px;" href="${contextPath}/viewUserPosts">View Your Posts</a>
    <a href="#" style="font-family: sans-serif">${sessionScope.User.getFirstname()}</a>
    <a class="active" href="logout">LOGOUT</a>
  </div>
        </div>
 
  
    </c:when>
    <c:otherwise>
         
          <div class="header">
  <a href="#default" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="${contextPath}/index.jsp">Home</a>
    <a href="${contextPath}/index.jsp#contact">Contact</a>
    <a href="${contextPath}/index.jsp#about">About</a>
  </div>
</div>
    
    </c:otherwise>
    </c:choose>
        
       
    
        
         <div class="container">

    <div class="row">

      <!-- /.col-lg-3 -->

      <div class="col-lg-10">

          
        <div class="card mt-4">
            <img class="card-img-top img-fluid" src="${contextPath}/resources/images/${post.getImageList()}" alt="${post.getTitle()}">
            
          <div class="card-body">
            <h3 class="card-title">${post.getTitle()}</h3>
            <h5><span class="glyphicon glyphicon-time"></span> Post by ${post.getUser().getFirstname()} ${post.getUser().getLastname()} on ${post.getDate()} </h5>
            
            <br>
            <br>
            <p class="card-text" style="font-size: large;">County of Travel: ${post.getCountryOfTravel()}</p>
            <p class="card-text" style="font-size: large;">Traveled From: ${post.getTravelledFrom()}</p>
             <p class="card-text" style="font-size: large;">Month of Visit: ${post.getMonthOfVisit()}</p>
         
             
<!--               <p class="card-text" style="font-size: large;">Travel CheckList:</p>
               <textarea class="form-control" disabled rows="3" name="s" required style="background-color: white; overflow: auto">${post.getTravelCheckList()}</textarea>
            -->
        <div>
          <h3>Itinerary</h3>
          <c:forEach var="iter" items="${iterList}">
          
          <details>
              <summary>DAY ${iter.getDayNo()}</summary>
              <textarea class="form-control" disabled rows="7" name="s" required style="background-color: white; overflow: auto">${iter.getDescription()}</textarea>
          
          </details>
           
            <br>
       
          </c:forEach>
        </div>
          
            
           
            
            
          </div>
        </div>
        <!-- /.card -->
        <br> 
        <br>
      <form action="${contextPath}/viewPostInDetail/change/${post.getId()}" method="GET">
  
          
                     <c:if test="${liked}">
                         <input type="hidden" name="like" value="unlike">
                       
                     <button  class="btn btn-light" style="background: none;"type="submit"><i class="fas fa-heart"></i></button>
                         
                         
                     </c:if>    
                     
                     <c:if test="${!liked}">
                         <input type="hidden" name="like" value="like">
                   
                     <button class="btn btn-light"  style="background: none; " type="submit"><i class="far fa-heart"></i></button>
                         
                         
                     </c:if>  </form>
                     <button type="button" class="btn btn-primary">
  Likes <span class="badge badge-light">${likeCount}</span>
      </button>
                     
                <h4>Leave a Comment:</h4>
      <form role="form" action="${contextPath}/viewPostInDetail/${post.getId()}" method="post">
        <div class="form-group">
          <textarea class="form-control" rows="3" name="commentD" required></textarea>
          <input type="hidden" name="postCom" value="${post.getId()}">
         
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>     
          
     
      <div class="card card-outline-secondary my-4" style="overflow: scroll;" >
          <div class="card-header">
            <p><span class="badge">${post.getComments().size()} </span> Comments:</p><br>
          </div>
          <div class="card-body">
              <c:forEach var="comment" items="${post.getComments()}">
                  
            <p><c:out value="${comment.getCommentDesc()}"></c:out></p>
            <c:forEach var="user" items="${userList}">
                  
                
                  <c:if test="${user.getId()==comment.getUserId()}">
                   <small class="text-muted">Posted by <c:out value="${user.getFirstname()}"></c:out></small>  
                  </c:if>
              </c:forEach>
            
            <hr>
              </c:forEach>
    
          </div>
        </div>
        <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>

  </div>
  <!-- /.container -->
  
  
    <!-- Bootstrap core JavaScript -->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        
        
        
        
        
        
        
        
        
        
        
       
      
         
    
        
    </body>
</html>
