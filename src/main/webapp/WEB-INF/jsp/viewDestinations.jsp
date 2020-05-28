<%-- 
    Document   : viewDestinations
    Created on : Apr 15, 2020, 9:45:25 PM
    Author     : shahd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
        <%@include file="userHeader.jsp" %>
    <link rel="stylesheet" href="<c:url value='/resources/css/destination.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/main2.css' />">
    </head>

    <body>
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

     
        
        
            <main>
                  <div style="float:left;">
            <h1>Filter</h1>
            
            
            <form action="${contextPath}/viewDestinations" method="post">
           
                
            <label for="cars">Filter by By Country</label>

            <select id="countryFilter" name="country">
                <c:forEach var="country" items="${filterpostList}">
                    
                    <c:choose>
                        
                        <c:when test="${count.equals(postList.get(0).getCountryOfTravel())}">
                             <option name="country" value="${country.getCountryOfTravel()}" selected>${country.getCountryOfTravel()}</option>
                        </c:when>
                             <c:when test="${!count.equals(postList.get(0).getCountryOfTravel())}">
                             <option name="country" value="${country.getCountryOfTravel()}">${country.getCountryOfTravel()}</option>
                        </c:when>
                    </c:choose>
                    
             
                </c:forEach>
            </select>
            <br>
            <button type="submit" name="submit" class="btn bg-success" style="color: white;">Filter</button>
            </form>
            
            <br>
            
             <form action="${contextPath}/viewDestinations" method="GET">
           
                
           
                 <button type="submit" name="submit" class="btn bg-danger" style="color: white;">Remove Filter</button>
            </form>
            
            
        </div>
                <c:if test="${postList.size()>0}">
                    <div class="grid">
                        <c:forEach var="post" items="${postList}">
                        
                            <article class="card product-item" style="margin-bottom: 40px;">
                                <header class="card__header">
                                    <h1 class="product__title">
                                        <c:out value="${post.getCountryOfTravel()}"></c:out>
                                    </h1>
                                </header>
                                <div class="card__image">
                                    <img src="resources/images/${post.getImageList()}" alt="<c:out value="${post.title}"></c:out>">
                                </div>
                                <div class="card__content">
                                    <h5 class="product__price">
                                        <c:out value="${post.getTitle()}"></c:out>
                                    </h5>
                                    <p class="product__description">
                                        Month of Visit: <c:out value="${post.getMonthOfVisit()}"></c:out>
                                    </p>
                                </div>
                                <div class="card__actions">
                                    <form action="${contextPath}/viewPostInDetail/${post.getId()}" method="GET">
                                            <button class="btn" style="margin-bottom: 7px;">View Details</button>
                                    </form>
                                         
  Likes <span class="badge badge-light">${post.getLikes().size()}</span>
      
                                </div>
                            </article>
                        </c:forEach>
                          
                    </div>
                </c:if>
                <c:if test="${postList.size()<=0}">
              
                        <h1>No Products Found!</h1>
                </c:if>
            </main>
             
             
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
