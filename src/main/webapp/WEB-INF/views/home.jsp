<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to Leave Management System</h3>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="./getUserForm" method='POST'>
	
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	<a id="submit" href="javascript:document.getElementById('logout').submit()">Click Here to add User</a>
	<table id="usertable" class="display" width="100%">
		<thead>
			<tr>
				<th>firstName</th>
				<th>lastName</th>
				<th>email</th>
			</tr>
		</thead>
	</table>
	<!--<a href="javascript:document.getElementById('logout').submit()">Logout</a>  -->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src = https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js></script>
	<script	src = https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js></script>
	<script type="text/javascript">
 	$(document).ready(function() {
 		getUsers();
	});
 	
 	function getUsers(){
 		$('#usertable').DataTable( {
			  "ajax": {
				  "url": './getUsers',
			         "dataSrc": "persons"
			  },
			  "sAjaxDataProp":"",
			  columns: [
	 	        	{ "data": "firstName" },
	 	            { "data": "lastName" },
	 	            { "data": "email" }
	 	        ]
	    } );
 	}
 	
	$("#submit").click(
			function() {
				jqXHR = $
						.ajax({
							url : './getUserForm',
							type : 'GET',
							data : "",
							cache : false,
							contentType : false,
							processData : false,
							timeout : 180000,
							success : function(response) {
								
							},
							error : function(xhr, textStatus, error) {

							}
						});
			}); 
</script>
</body>
</html>