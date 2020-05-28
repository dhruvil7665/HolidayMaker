<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

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

<title>Registration</title>
</head>
<body>
    
    
         
          <div class="header">
  <a href="#default" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="index.jsp">Home</a>
    <a href="index.jsp#contact">Contact</a>
    <a href="index.jsp#about">About</a>
  </div>
</div>
    
    <h3 style="margin-top: 40px; margin-left: 50px;">Registration</h3>
    
	<form:form  style="width:50%; margin-left:120px; margin-top:50px; " id="regForm" modelAttribute="user" action="registrationProcess"
		method="post">
                <div class="form-group" ">
		
				<form:label path="username">Username</form:label>
                                <form:input class="form-control" required="required" path="username" pattern="[a-zA-Z0-9]+" minlength="4" maxlength="10" title="username should only contain letters and numbers" name="username" id="username"  />
			
                        
                </div>  
			
				<div class="form-group"><form:label path="password">Password</form:label>
				<form:password class="form-control" path="password" name="password"
						id="password" required="required" minlength="4" maxlength="10"  /></div>
			
				<div class="form-group"><form:label path="firstname" >FirstName</form:label>
				<form:input class="form-control" path="firstname" pattern="[a-zA-Z]+" name="firstname"
						id="firstname" placeholder="Eg: John" required="required" title="Firstname should only contain letters"/></div>
			
				<div class="form-group"><form:label path="lastname">LastName</form:label>
				<form:input class="form-control" path="lastname"  pattern="[a-zA-Z]+" name="lastname" id="lastname" title="lastname should only contain letters" placeholder="Eg: Snow" required="required"/></div>
			
				<div class="form-group"><form:label path="email">Email</form:label>
				<form:input class="form-control" path="email" name="email" id="email" pattern=".+@gmail\.com" placeholder="xyz@gmail.com" required="required" title="Only Gmail Account Valid"/></div>
			
				<div class="form-group"><form:label path="address">Address</form:label>
				<form:input class="form-control" path="address" name="address" id="address" placeholder="Eg:BOSTON" required="required"/></div>
			
				<div class="form-group"><form:label path="phone">Phone</form:label>
                                    <form:input class="form-control" path="phone" name="phone" id="phone"  pattern="[0-9]{3}[0-9]{3}[0-9]{4}"   placeholder="xxx-xxxx-xxxxx" required="required" title="Phone should be in format of xxx-xxxx-xxxx"/></div>
			
				<div><form:button id="register" name="register" class="btn btn-primary">Register</form:button></div>
			
				<div></div>
		
                
                
                
                
                
	</form:form>
                
                                <div style="height: 170px;"></div>                        
                                
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