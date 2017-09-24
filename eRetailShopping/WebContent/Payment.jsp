<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css\payment.css" rel="stylesheet" />
<title>eRetail - Payment</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function loadisInsert(){
	document.getElementById('isInsert').value = 1;
}
</script>
</head>
<body>
<!-- heading starts here -->
<hgroup class="heading">
<h1 class="major">Checkout Form </h1>
</hgroup> 
<!-- end heading -->

<!-- main content --> 

<form class="checkout" name="PaymentForm" method="post" action="payment">
    <div class="checkout-header">
      <h1 class="checkout-title">
        Checkout
        <span class="checkout-price">$<c:out value="${requestScope.totalPayment}" default="$0"/>
        </span>
      </h1>
    </div>
    <input type="hidden" name="isInsert" id="isInsert"/>
    <input type="hidden" name="nextPage" id="nextPage" value="<%=request.getAttribute("nextPage")%>"/>
    <p>
      <input type="text" onmouseout="loadisInsert();" class="checkout-input checkout-name" placeholder="Your name" autofocus name="NameOnCard" value='<%=request.getAttribute("NameOnCard")%>'>
      <input type="text" onmouseout="loadisInsert();" class="checkout-input checkout-exp" placeholder="MM" name="Month" value='<%=request.getAttribute("Month")%>'>
      <input type="text" onmouseout="loadisInsert();" class="checkout-input checkout-exp" placeholder="YY" name="Year" value='<%=request.getAttribute("Year")%>'>
    </p>
    <p>
      <input type="text" onmouseout="loadisInsert();" class="checkout-input checkout-card" placeholder="1111 1111 1111 1111" name="AccountNo" id="AccountNo" value='<%=request.getAttribute("AccountNo")%>'>
      <input type="text" onmouseout="loadisInsert();" class="checkout-input checkout-cvc" placeholder="CVC" name="CVV" id="CVV" value='<%=request.getAttribute("CVV")%>'>
    </p>
    <p>
      <input type="submit" value="Purchase" class="checkout-btn">
    </p>
  </form>

<!-- end of main cotnent -->
</body>
</html>