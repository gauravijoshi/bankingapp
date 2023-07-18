<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Dashboard</title>
<link rel="stylesheet" href="/bankapp/resource/css/style4.css">
</head>
<body>
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>

	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	<s:url var="url_all_customer" value="/all_customer"/>
	<a href="${url_all_customer}"> <button>All Customers</button> </a>
	
	<s:url var="url_edit_customer" value="/edit_customer"/>
	<a href="${url_edit_customer}"> <button>Edit Customers</button> </a>
	
	<s:url var="url_new_accoount" value="/new_account"/>
	<a href="${url_new_accoount}"> <button>New Account</button> </a>
	
	<s:url var="url_edit_accoount" value="/edit_account"/>
	<a href="${url_edit_accoount}"> <button>Edit Account</button> </a>
	
	<s:url var="url_delete_accoount" value="/delete_account"/>
	<a href="${url_delete_accoount}"> <button>Delete Account</button> </a>
	
	<s:url var="url_deposit_money" value="/deposit_money"/>
	<a href="${url_deposit_money}"> <button>Deposit</button> </a>
	
	<s:url var="url_withdraw_money" value="/withdraw_money"/>
	<a href="${url_withdraw_money}"> <button>Withdraw</button> </a>
	
	<s:url var="url_fund_transfer" value="/fund_transfer"/>
	<a href="${url_fund_transfer}"> <button>Fund Transfer</button> </a>
	
	<button>Change Password</button>
	
	<s:url var="url_check_balance" value="/check_balance"/>
	<a href="${url_check_balance}"> <button>Balance Enquiry</button> </a>
	
	<s:url var="url_mini_statement" value="/mini_statement"/>
	<a href="${url_mini_statement}"> <button>Mini Statement</button> </a>
	
	<br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>

</body>
</html>