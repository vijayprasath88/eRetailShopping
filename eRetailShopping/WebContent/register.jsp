<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Retail Register Page</title>
<link rel="stylesheet" href="css/loginstyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3 class="heading" id="title">e-Retail Online Shopping</h3><br><br>

</head>
<body>

  <c:if test="${not empty message}">
    <h3 align="center" style="color: red">${message}</h3>
</c:if>

<div class="container">
	<section id="content">
		<form name="registerform" action="register" method="Post">
			<h1>Register Form</h1>
			<div>
				Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 60%" type="text" placeholder="Username" required="" id="user" name="user"/>
			</div>
			<div>
				Password:&nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 60%" type="password" placeholder="password" required="" id="pass" name="pass"/>
			</div>

			<div>
				<input type="submit" value="Register" />
				<a href="login.jsp">Login</a>
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->

</body>

</html>