<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Retail Category</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js\jquery-3.1.1.min.js"></script>

<script>
$(function(){
	
	$( ".checkcategory" ).click(function() {
		var j = $(".select-box").val();
		if(j==0){
			alert("Select a Category");
			return false;
		}
		$( "#CategoryForm" ).submit();
	});
	
});


</script>
<style type="text/css">
.first-box{
width: 40%;


}
#category{
width:88%;
background-color: #737373;
font-size: 32pt;
}
</style>
</head>
<body>
<form id="CategoryForm" name="CategoryForm"   action="product" method="post">
<div>
<h3 class="first-box">Category</h3>
</div>
<div class="first-box">
<select id="category" class="select-box" name="category" >
<option value="0">Select a Category</option>
    <c:forEach var="category" items="${requestScope.categoryList}">
        <option value="${category.categoryId}"><c:out value="${category.categoryName}"/></option>
    </c:forEach>
 </select>
</div>
<div>
<input class="checkcategory" type="submit" value="Show Products"/>
</div>
</form>
</body>
</html>