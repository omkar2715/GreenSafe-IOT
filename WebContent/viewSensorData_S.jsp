<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="food.com.services.*" %>
    <%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><title>Fresh Food</title>
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/tms-0.4.1.js"></script>
<script src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
<script	src="js/jquery.touchSwipe.min.js"></script>
<script>
$(window).load(function () {
    $('.slider')._TMS({
        show: 0,
        pauseOnHover: false,
        prevBu: '.prev',
        nextBu: '.next',
        playBu: false,
        duration: 800,
        preset: 'fade',
        pagination: false, //'.pagination',true,'<ul></ul>'
        pagNums: false,
        slideshow: 8000,
        numStatus: false,
        banners: true,
        waitBannerAnimation: false,
        progressBar: false
    })
});
$(window).load(
    function () {
        $('.carousel1').carouFredSel({
            auto: false,
            prev: '.prev1',
            next: '.next1',
            width: 1030,
            items: {
                visible: {
                    min: 1,
                    max: 4
                },
                height: 'auto',
                width: 157,
            },
            responsive: true,
            scroll: 1,
            mousewheel: false,
            swipe: {
                onMouse: true,
                onTouch: true
            }
        });
    });
</script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">
<![endif]-->
</head>
<body style="margin-top:20px;background-image:url('images/apple.jpg');background-repeat:no-repeat;background-size:cover">    


  <div class="container_12">
    <div class="clear"></div>
  </div>
  <div class="menu_block">
    <div class="container_12">
      <div class="grid_12">
        <nav class="">
          <ul class="sf-menu">
           <!--  <li class="autor"><a href="AddSupervisor.html"><button class="btn btn-warning"><b>Add Supervisor</b></button></a></li>
           <li class="autor"><a href="View.jsp"><button class="btn btn-warning"><b>View Supervisor</b></button></a></li> -->
            <li class="current"><a href="viewSensorData_S.jsp"><button class="btn btn-warning"><b>View Sensor Data</b></button></a></li>
            <li class="autor"><a href="viewSensorLogs.jsp"><button class="btn btn-warning"><b>View Logs</b></button></a></li>
            </ul>
            <div class="autor"> <a href="index.html"><button class="btn btn-warning"><b>Logout</b></button></a></div>
           </nav>
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
    
<div class="content"></div>
    <div class="container_12">
      <div class="grid_8">
      
      <h1 style="margin-top:30px;margin-left:290px;text-align:center">View all Sensor Data</h1>
<table class="table table-bordered table-striped" style="text-align:center;margin-left:200px;background-color:lightgray">
<thead>
  <tr>
    <th scope="col">Id</th>
     <th scope="col">Name</th>
    
     <th scope="col">Temperature</th>
     <th scope="col">Humidity</th>
     <th scope="col">mq135</th>
     <th scope="col">mq136</th>
     <th scope="col">lat</th>
     <th scope="col">lon</th>
    
  </tr>
  </thead>
   <% 
        Statement statement = null;
        ResultSet rs = null;
        int id=UserInfo.getId();
   %>
 <%
  try{
	  Connection Con= ConnectionDB.getCon();
	  statement=Con.createStatement();
	  String sql ="select * from supervisor where Id='"+id+"'";
      rs = statement.executeQuery(sql);
	 while(rs.next())
	 {
%> 
<tr>
	  <td scope="row"> <%=rs.getInt("Id")%> </td>
	  	  <td scope="row"> <%=rs.getString("Name")%> </td>
	  
	  <td scope="row"> <%=rs.getString("Temperature") %> </td>
       <td scope="row"> <%=rs.getString("Humidity")%> </td>
	    <td scope="row"> <%=rs.getString("mq135")%> </td>
	    <td scope="row"> <%=rs.getString("mq136")%> </td>
	    <td scope="row"> <%=rs.getString("lat")%> </td>
	    <td scope="row"> <%=rs.getString("lon")%> </td>
	    
	    </tr>
	</thead>
  <%
	      }
       }
         catch(Exception e)
    {
	  e.printStackTrace();
  }
  
 %>
   
</table>
 </div>
 </div>
   
</body>

</html>
