<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#login-box {
	width: 400px;
	padding: 60px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
	
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
<!--STYLESHEET-->
    <!--=================================================-->
    <!--Open Sans Font [ OPTIONAL ]-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/nifty.min.css" rel="stylesheet">


    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/demo/nifty-demo-icons.min.css" rel="stylesheet">
        
    <!--Demo [ DEMONSTRATION ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/demo/nifty-demo.min.css" rel="stylesheet">

    <!--Magic Checkbox [ OPTIONAL ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/plugins/magic-check/css/magic-check.min.css" rel="stylesheet">
</head>
<body>
<script src="/WEB-INF/js/user.js"></script>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div id="login-box">
	<div class="cls-content">
		    <div class="cls-content-sm panel">
		        <div class="panel-body">
		            <div class="mar-ver pad-btm">
		                <h3 class="h4 mar-no">Sign Up</h3>
		            </div>
		            <form name='signupForm' action="./landing" method='POST'>
		                <div class="form-group">
		                    <input type="text" class="form-control" placeholder="Username"  name='username' value='' autofocus>
		                </div>
		               <div class="form-group">
		                    <input type="password" class="form-control" placeholder="Password" name='password'>
		                </div>
		               <div class="form-group">
		                    <input type="text" class="form-control" placeholder="First Name"  name='fname' value='' autofocus>
		                </div>
		                <div class="form-group">
		                    <input type="text" class="form-control" placeholder="Last Name"  name='lname' value='' autofocus>
		                </div>
		                <div class="form-group">
		                    <input type="text" class="form-control" placeholder="Email"  name='email' value='' autofocus>
		                </div>
		                <button class="btn btn-primary btn-lg btn-block" type="submit"  type="submit"
					value="submit" >Sign Up</button>
		                	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
		            </form>
		        </div>
		   </div>
	</div>
		</div>
</body>
</html>