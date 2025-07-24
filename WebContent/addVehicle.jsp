<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/form.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/forms.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">
<![endif]-->
</head>
<body onload="access()" style="margin-top:20px;background-image:url('images/apple.jpg');background-repeat:no-repeat;background-size:cover">
 <%
  String lat=request.getParameter("lat");
  String lng=request.getParameter("lng");
  
  System.out.println("lat "+lat);
  System.out.println("lng "+lng);
  %>
<div class="container_12">
    <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="menu_block">
    <div class="container_12">
      <div class="grid_12">
        <nav class="">
          <ul class="sf-menu">
           <!--  <li class="current"><a href="AddSupervisor.html"><button class="btn btn-warning"><b>Add Supervisor</b></button></a></li>
            <li class="current"><a href="View.jsp"><button class="btn btn-warning"><b>View Supervisor</b></button></a></li> -->
                        <li class="current"><a href="addLocation.jsp"><button class="btn btn-warning"><b>Add Vehicle</b></button></a></li>
            
             <li class="current"><a href="viewVehicleData.jsp"><button class="btn btn-warning"><b>View Vehicle Data</b></button></a></li>
            <li class="current"><a href="viewVehicleLogs.jsp"><button class="btn btn-warning"><b>View Vehicle Logs</b></button></a></li>
           
           </ul></nav>
           <div class="autor"> <a href="index.html"><button class="btn btn-warning">Logout</button></a></div>
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
    </div>
  </div>
 
     <div class="container">
  <h1 style="text-align:center">Add Vehicle</h1>


 <center>

    <form action="AddVehicle" method="post">
 <input type="text" class="ggg" name="vehicleno"pattern="[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}" placeholder="Please enter a valid vehicle number (e.g. AB12CD1234)" style="width:400px;height:35px"> 
 <br><br>
<input type="text" class="ggg" name="name" placeholder="Driver Name:" style="width:400px;height:35px">
 <br><br>
 <input type="text" class="ggg" name="Contact" placeholder="Enter Contact Number:"  style="width:400px;height:35px" pattern="[789][0-9]{9}">
 <br><br>
 <div class="styled-input">
					<label>Latitude</label>
						<span class="fa fa-map-marker" aria-hidden="true"></span>
						<input class="form-control" type="text" name="lat"  style="width:400px;height:35px" value="<%=lat %>" placeholder="lat"  required/> 
					</div> 
					<div class="styled-input">
					 <label>Longitude</label>
						<span class="fa fa-map-marker" aria-hidden="true"></span>
						<input class="form-control" type="text" name="lng"  style="width:400px;height:35px" value="<%=lng %>" placeholder="lng"  required/>
                                            
					</div>
 <div class="clearfix"></div>
 <button type="submit" class="btn btn-warning">Add</button>
 </form>
  </center>
   </div>
 </body>
</html>
	