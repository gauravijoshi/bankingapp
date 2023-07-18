<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<link rel="stylesheet" href="/bankapp/resource/css/style13.css">
</head>
<body>
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	<c:if test="${error!=null}">
				<p class="error">${error}</p>
				</c:if> 
	<c:url var="mini_statement_url" value="/get_statement"></c:url> 
    <div class="statement">    
    <f:form	action='${mini_statement_url}' modelAttribute="mini_statement">    
        <label><b>Enter Account Number:     
        </b>    
        </label>    
        <f:input path="fromAccount" />    
        <br><br>        
        <button>Generate Mini Statement</button>       
   </f:form> 
    </div> 
   <table >
	<tr>
	    <th>Account Id</th>
	    <th>Transaction Id</th>
	    <th>Depositor Account</th>
	    <th>Recipient Account</th>
	    <th>Amount</th>
	    <th>Date of Transaction</th>
  	</tr>
  	<c:forEach var="transaction" items="${transaction_list}"> 
  	<tr>
  		<td>${transaction.accountId}</td>
  		<td>${transaction.transactionId}</td>
  		<td>${transaction.fromAccount}</td>
  		<td>${transaction.toAccount}</td>
  		<td>${transaction.amount}</td>
  		<td>${transaction.dateOfTransaction}</td>
  	</tr>
  	</c:forEach> 
	</table>

	<br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>