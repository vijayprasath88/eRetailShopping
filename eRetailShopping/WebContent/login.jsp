<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Retail Online Shopping</title>
<!-- <link href="css\bootstrap.css" rel="stylesheet" />  -->
 <link rel="stylesheet" href="css/loginstyle.css">

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<body>
 <h3 class="heading" id="title">e-Retail Online Shopping</h3><br><br>
<div class="container">
	<section id="content">
		<form name="loginform" action="login" method="Post">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" required="" id="username" name="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" name="password"/>
			</div>

			<div>
				<input type="submit" value="Log in" />
				<a href="register.jsp">Register</a>
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->
<c:if test="${not empty message}">
    <h3 align="center" style="color: red">${message}</h3>
</c:if>
</body>
</body>
</html>