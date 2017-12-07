<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <!--STYLESHEET-->
    <!--=================================================-->
    <!--Open Sans Font [ OPTIONAL ]-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
      <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--Nifty Stylesheet [ REQUIRED ]-->
     <link href="css/common.css" rel="stylesheet">


    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
     <link href="css/demo/nifty-demo-icons.min.css" rel="stylesheet">
        
    <!--Demo [ DEMONSTRATION ]-->
    <link href="css/demo/nifty-demo.min.css" rel="stylesheet">

    <!--Magic Checkbox [ OPTIONAL ]-->
    <link href="css/plugins/magic-check/css/magic-check.min.css" rel="stylesheet">
    
    <!--JAVASCRIPT-->
    <!--=================================================-->

    <!--Pace - Page Load Progress Par [OPTIONAL]-->
    <link href="plugins/pace/pace.min.css" rel="stylesheet">
     <link href="css/style.css" rel="stylesheet">
     
    <script src="plugins/pace/pace.min.js"></script>
    <!--jQuery [ REQUIRED ]-->
    <script src="js/jquery.min.js"></script>
    <!--BootstrapJS [ RECOMMENDED ]-->
    <script src="js/bootstrap.min.js"></script>
    <!--NiftyJS [ RECOMMENDED ]-->
    <script src="js/nifty.min.js"></script>
    <!--=================================================-->
    <!--Background Image [ DEMONSTRATION ]-->
    <script src="js/demo/bg-images.js"></script>
    
</head>
<body >

	<%
	Object error = (String)request.getAttribute("error");
	if(null != error){
	%>
	<div class="error">${error}</div>
	<%
	}
	%>
	<%
	Object message = (String)request.getAttribute("message");
	if(null != message){
	%>
	<div class="msg">${message}</div>
	<%
	}
	%>
		<!-- BACKGROUND IMAGE -->
		<!--===================================================-->
		<div id="bg-overlay"></div>
		
		<!-- LOGIN FORM -->
		<!--===================================================-->
		<div id="login-box">
		<div class="">
		    <div class="cls-content-sm panel">
		        <div class="panel-body">
		            <div class="mar-ver pad-btm">
		                <h3 class="h4 mar-no">Account Login</h3>
		                <p class="text-muted">Sign In to your account</p>
		            </div>
		            <form name='login' action="<c:url value='/login' />" method='POST'>
		                <div class="form-group">
		                    <input type="text" class="form-control" placeholder="Username"  name='username' value='' autofocus>
		                </div>
		                <div class="form-group">
		                    <input type="password" class="form-control" placeholder="Password" name='password'>
		                </div>
		                <button class="btn btn-primary btn-lg btn-block" type="submit"  type="submit"
					value="submit" >Sign In</button>
		                	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
		            </form>
		        </div>
		
		        <div class="pad-all">
		            <a href="pages-password-reminder.html" class="btn-link mar-rgt">Forgot password ?</a>
		            <a href="./signup" class="btn-link mar-lft">Create a new account</a>
		
		            <div class="media pad-top bord-top">
		                <div class="pull-right">
		                    <a href="#" class="pad-rgt"><i class="demo-psi-facebook icon-lg text-primary"></i></a>
		                    <a href="#" class="pad-rgt"><i class="demo-psi-twitter icon-lg text-info"></i></a>
		                    <a href="#" class="pad-rgt"><i class="demo-psi-google-plus icon-lg text-danger"></i></a>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
</body>
</html>