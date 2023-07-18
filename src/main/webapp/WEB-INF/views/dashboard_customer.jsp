<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<link rel="stylesheet" href="/bankapp/resource/css/style4.css">
</head>
<body>
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>

	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	<s:url var="url_check_balance_customer" value="/check_balance_customer"/>
	<a href="${url_check_balance_customer}"> <button>Balance Enquiry</button> </a>
	
	<s:url var="url_fund_transfer_customer" value="/fund_transfer_customer"/>
	<a href="${url_fund_transfer_customer}"> <button>Fund Transfer</button> </a>
	
	<s:url var="url_mini_statement_customer" value="/mini_statement_customer"/>
	<a href="${url_mini_statement_customer}"> <button>Mini Statement</button> </a>
	
	<button>Change Password</button>
	
	
	<br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
   
	<br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>

</body>
</html>