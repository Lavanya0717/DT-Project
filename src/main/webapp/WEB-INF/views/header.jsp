<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<c:url var="e" value="/"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Header Page</title>
</head>

<body>

<!--Navbar-->

<nav class="navbar navbar-expand-lg navbar-dark navbar-full" style="background-color:#ff4062">

     <div class="container">
<ul class="nav navbar-nav">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-demo-navbar-collapse-1"/>


<span class="dark-pink-text"><i class="fa fa-bars fa-1x"></i></span></button>

<a class="navbar-brand" href="#">Bokay Florist</a>
</ul>
<div class="collapse navbar-collapse" id="bs-demo-navbar-collapse-1">
<ul class="nav navbar-nav">

                               <!--  <li class="active">
                                    <a href="#">
                                        <span class="glyphicon glyphicon-home">Home</span>
                                    </a>

                                 <li>
                                    <a href="#">
                                        <span class="glyphicon glyphicon-registration-mark">Register</span>
                                    </a>

                                                                  
                                 <li>
                                    <a href="#">
                                      <span class="glyphicon glyphicon-info-sign">Sign In</span>
                                      </a>
     
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-th-list"> </span>  Category  <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Jeans</a></li>
          <li><a href="#">Shirts</a></li>
          <li><a href="#">Shoes</a></li>
        </ul>
      </li>
      </ul> -->
      
    <ul class="nav navbar-nav navbar-right">
       <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>  
          <li><a href="adminAdding">Add Details</a></li>
		<li><a href="viewDetailsAdmin">View Details</a></li>
   <li><a href="<c:url value="/perform_logout"/>">
         <span class="glyphicon glyphicon-log-out"></span> Logout</a></li></c:if>
        <c:if test='<%=(Boolean)session.getAttribute("loggedIn")==null%>'>
 <li><a href="${e}register"><span class="fa fa-user"></span> Register</a></li>
      <li><a href="${e}login"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
    </c:if></ul>
  </div></div>
</nav>
</header>

 
</body>
</html>
            
   
 