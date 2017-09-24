<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Retail Products</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js\jquery-3.1.1.min.js"></script>
<style type="text/css">
.table1 {
    margin-bottom: 20px;
    width: 50%;
}
</style>
<script type="text/javascript">
var data = [];
function loadQuantity(){
	document.getElementById("totalQuantites").value = data;	
}
function checkboxchecked(){
	var x = document.getElementById("checkedProducts").checked;
	alert(x);
	var fld = document.getElementById('quantity');
	var values = [];
	for (var i = 0; i < fld.options.length; i++) {
	  if (fld.options[i].selected) {
	    alert(fld.options[i].value);
	  }
	}
	return false;
}

$(function(){
    
    $( ".Checkout" ).click(function() {
    	    var a = $("input[type='checkbox'].checkedProducts");
    	    var values = $.map($('select[name="quantity"]'), function (e) {
    	    	if($(e).val()!= 0){
    	    		data.push($(e).val());
    	    		return $(e).val();	
    	    	}
            });
    	    if(a.filter(":checked").length==0){
    	        alert('Please select the products');
    	        return false;
    	    }
    	    if(a.filter(":checked").length!=values.length){
    	        alert('Please select the quantity');
    	        return false;
    	    }
    	    loadQuantity();
    	  $( "#ProductForm" ).submit();
    	});

});
</script>
</head>
<body>
<h6 style="text-align: right; color: blue;font-size: 12pt"><b>logged in as ${sessionScope.userName}</b></h6>
<form id="ProductForm" name="ProductForm"  action="productInsert" method="post">
<!--<div class="table-responsive"> -->
<div>
<table  class="table1" border="2">
  <thead>
     <tr>
        <th></th>
        <th align="center"><b>ProductName</b></th>
        <th align="center"><b>Price($)</b></th>
        <th align="center"><b>Quantity</b></th>
     </tr>
  </thead>
  <c:forEach  var="product" items="${requestScope.productList}">
	  <tbody>
	      	<tr>
	      	   <td><input  class="checkedProducts" type="checkbox" id="checkedProducts" name="checkedProducts" value="${product.productId}"/></td>
	           <td>${product.productName} </td>
	           <td>${product.price}</td>
	           <td><select class="quantity" id="quantity" name="quantity">
	            <option value="0">Choose Quantity</option>
	      	   <option value="1">1</option>
	      	   <option value="2">2</option>
	      	   <option value="3">3</option>
	      	   <option value="4">4</option>
	      	   </select></td>
	       </tr>
	  </tbody>
  </c:forEach>
 
    </table>
    </div>
  <input type="hidden" id="totalQuantites" name="totalQuantites"/>
    <div>
    <input type="submit" value="Checkout" class="Checkout"/>
    </div>
  </form>
</body>
</html>
