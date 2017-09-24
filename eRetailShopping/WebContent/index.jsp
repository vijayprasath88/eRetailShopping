<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css\bootstrap.css" rel="stylesheet" />
<script src="1.js" type="text/javascript">


</script>
  <style type="text/css">
  
  body {

padding:50px;
}


#title{

height:125px;
background-color:lightgreen;
text-align: center;
font-size: 42pt;
}

#login {
	padding:20px;
	width:300px;
	height:550px;
	
}
#drop {
	width:150px;
}
#abc{
	width:550px;
	height:550px;
}

  
  </style>

<title>e-Retail Online Shopping</title>
<h1 class="jumbotron" id="title">e-Retail Online Shopping</h1><br><br>
</head>
<body class="container">

<c:if test="${not empty message}">
    <h3 align="center" style="color: red">${message}</h3>
</c:if>

<img align = "right"  id= "abc" src="xyz.jpg " > </img>

<div class="jumbotron" id="login"  >

<h4 align= "center"><b>LOGIN</b></h4><br>
<form name="loginform" action="login" method="Post" onsubmit="return validate();">
<b>Email</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  name="username" id="username"  required ><br><br>

<b>Password</b>&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password"  required ><br><br>
<input type="submit" class="btn btn-primary" value="Submit">

</form>
<form name="registerform" action="register" method="Post" onsubmit="return validate2();">
<br></br>
<br>
<h4 align= "center"><b>New User? SignUp</b></h4><br>

<b>Email</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  name="user" id="user"  required ><br><br>

<b>Password</b>&nbsp;&nbsp;&nbsp;<input type="password" name="pass"  required ><br><br>


<!-- 
<b>UserId</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userid" required ><br><br>

<b>Role</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="Role" required >
<br><br>
 -->
 <a href="registered.html">HTML Images</a>
<input type="submit" class="btn btn-primary" value="Register">
</form>




</div>
</body>
</html>