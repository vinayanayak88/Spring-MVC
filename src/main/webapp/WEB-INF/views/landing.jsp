<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css">
	
    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/nifty.min.css" rel="stylesheet">


    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/demo/nifty-demo-icons.min.css" rel="stylesheet">
        
    <!--Demo [ DEMONSTRATION ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/demo/nifty-demo.min.css" rel="stylesheet">

    <!--Magic Checkbox [ OPTIONAL ]-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/plugins/magic-check/css/magic-check.min.css" rel="stylesheet">
    
     <link href="css/style.css" rel="stylesheet">
    
   
<title>Landing..</title>
</head>
<body>

	<div class="hide alert alert-uploader" id="upload-card-ribbon">
                <button type="button" class="close" id="closeRibbon">X</button>
                Successfully saved
		</div>
<div id="login-box">
	<div class="cls-content">
		    <div class="cls-content-sm panel">
		        <div class="panel-body">
		            <div class="mar-ver pad-btm">
		                <h3 class="h4 mar-no">Apply your leave here</h3>
		            </div>
		                <div class="container">
						        <div class='col-sm-3'>
						            <div class="form-group">
						                <div class='input-group date' id='datetimepicker1'>
						                    <input type='text' class="form-control" placeholder="Start Date" name="startdate"/>
						                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						            </div>
						        </div>
						</div>
						 <div class="container">
						        <div class='col-sm-3'>
						            <div class="form-group">
						                <div class='input-group date' id='datetimepicker2'>
						                    <input type='text' class="form-control" placeholder="End Date" name="enddate"/>
						                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						            </div>
						        </div>
						</div>
						<div class="dropdown dropdown-select">
						  <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" name="leavetype" style="margin-left: 30px">Leave Type
						  <span class="caret"></span></button>
						  <ul class="dropdown-menu">
						    <li><a href="#">Paid Leave</a></li>
						    <li><a href="#">Casual Leave</a></li>
						    <li><a href="#">Sick Leave</a></li>
						  </ul>
						</div>
						 </div>
		                <div class="form-group">
		                 	<textarea class="form-control"  placeholder="Reason" name="reason" value='' style="margin-left: 40px" autofocus required></textarea>
		                </div>
		                <button class="btn btn-primary btn-lg btn-block" id="submit"  type="submit"
						value="submit" style="margin-left: 30px">Submit</button>
		                	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
		        </div>
		   </div>
	</div>			
	
	 		<!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Modal Header</h4>
		        </div>
		        <div class="modal-body">
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>	
		  <div class="leftside-btns">
		  
		  			<ul>
		  				<li>
		  					<a href="./applyleave" role="button"  class="remove-bdr" >Apply leave</a>
		  				</li>
		  				<li>
		  					<a href="./leavebalance" role="button">Leave balance</a>
		  				</li>
		  				<li>
		  					<a href="./leaveStatus" role="button" >View Leave Status</a>
		  				</li>
		  				<li>
		  					<a href="./cancelleave" role="button">Cancel leave</a>
		  				</li>
		  				<li>
		  					<a href="" role="button">Logout</a>
		  				</li>
		  			</ul>
		</div>
						
    <!--JAVASCRIPT-->
    <!--=================================================-->

    <!--Pace - Page Load Progress Par [OPTIONAL]-->
    <link href="plugins/pace/pace.min.css" rel="stylesheet">
    <script src="plugins/pace/pace.min.js"></script>


    <!--jQuery [ REQUIRED ]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    
     <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>


    <!--BootstrapJS [ RECOMMENDED ]-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <!--NiftyJS [ RECOMMENDED ]-->
    <script src="js/nifty.min.js"></script>

    <!--=================================================-->
    
    <!--Background Image [ DEMONSTRATION ]-->
    <script src="js/demo/bg-images.js"></script>
		<script type="text/javascript">
		var target = null;
		 $(document).ready(function () {  
	            $('.dropdown-toggle').dropdown();  
	        });  
		$('#datetimepicker1').datepicker({
            format: "dd/mm/yyyy"
        }); 
		$('#datetimepicker2').datepicker({
            format: "dd/mm/yyyy"
        });
		$('.dropdown-select').on( 'click', '.dropdown-menu li a', function() { 
			    target = $(this).html();

			   //Adds active class to selected item
			   $(this).parents('.dropdown-menu').find('li').removeClass('active');
			   $(this).parent('li').addClass('active');

			   //Displays selected text on dropdown-toggle button
			   $(this).parents('.dropdown-select').find('.dropdown-toggle').html(target + ' <span class="caret"></span>');
			});
		$('#submit').click(function(){
			var startdate = $( "input[name='startdate']" ).val();
			var enddate = $( "input[name='enddate']" ).val();
			var reason = $( "textarea[name='reason']" ).val();
			var dataToSend = {
                    'startdate': startdate,
                    'enddate': enddate,
                    'leaveType': target,
                    'reason': reason,
                }
			var jqXHR = $
			.ajax({
				url : './applyleave',
				type : 'POST',
				data :  JSON.stringify(dataToSend),
				cache : false,
				contentType: 'application/json;charset=utf-8',
				processData : false,
				success : function(response) {
					$('#upload-card-ribbon').removeClass('hide');
					  $("#upload-card-ribbon").slideUp(5000);
					  $( "input[name='startdate']" ).val('');
					  $( "input[name='enddate']" ).val('');
					  $("textarea").val('');
				},
				error : function(xhr, textStatus, error) {
					console.log("Error")

				}
			});
		});
		
        </script>
</body>
</html>