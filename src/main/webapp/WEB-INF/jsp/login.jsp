<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Login</title>
<link href="<c:url value='/resources/css/header.css' />" rel="stylesheet">


	<link rel="icon" type="image/png" href="<c:url value='/resources/images/icons/favicon.ico'/>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/fonts/iconic/css/material-design-iconic-font.min.css' ></c:url>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/animate/animate.css'/>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/css-hamburgers/hamburgers.min.css' />" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/animsition/css/animsition.min.css'/>">

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/select2/select2.min.css'/>" >

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/daterangepicker/daterangepicker.css'/>" >

	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/util.css'/>" >
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" >
<script src="<c:url value='/reources/vendor/jquery/jquery-3.2.1.min.js'/>" ></script>

<script src="<c:url value='/reources/vendor/animsition/js/animsition.min.js'/>" ></script>	


<script src="<c:url value='/reources/vendor/bootstrap/js/popper.js'/>" ></script>	

<script src="<c:url value='/reources/vendor/bootstrap/js/bootstrap.min.js'/>" ></script>	


<script src="<c:url value='/reources/vendor/select2/select2.min.js'/>" ></script>	

<script src="<c:url value='/reources/vendor/daterangepicker/moment.min.js'/>" ></script>	

<script src="<c:url value='/reources/vendor/daterangepicker/daterangepicker.js'/>" ></script>

<script src="<c:url value='/resources/vendor/countdowntime/countdowntime.js'/>" ></script>


<script src="<c:url value='/resources/js/main.js'/>" ></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>



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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <div class="header">
  <a href="index.jsp" class="logo">HOLIDAY MAKER</a>
  <div class="header-right">
    <a class="active" href="index.jsp">Home</a>
    <a href="index.jsp#contact">Contact</a>
    <a href="index.jsp#about">About</a>
  </div>
</div>
   
	
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
                
                
                <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" modelAttribute="login" action="loginProcess" method="post" >
					<span class="login100-form-title p-b-26">
						LOGIN
					</span>
					

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.com">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="password">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Login
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Don?t have an account?
						</span>

						<a class="txt2" href="${contextPath}/register">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>


    <!-- Footer-->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Location</h4>
                        <p class="lead mb-0" style="color: white">1572 Tremont Street<br />Boston, MA 02120</p>
                    </div>
                    <!-- Footer Social Icons-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Around the Web</h4>
                        <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-facebook-f"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-twitter"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-linkedin-in"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-dribbble"></i></a>
                    </div>
                    <!-- Footer About Text-->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">About Holiday Maker</h4>
                        <p class="lead mb-0" style="color: white">A Travel Website Enhancing Travel Experiences of Users worldwide</a>.</p>
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