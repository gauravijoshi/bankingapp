<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
<link rel="stylesheet" href="/bankapp/resource/css/style8.css">
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
	<c:url var="balance_check_url" value="/balance_check"></c:url> 
    <div class="balance">    
    <f:form	action='${balance_check_url}' modelAttribute="balance_check">    
        <label><b>Enter Account Number:     
        </b>    
        </label>    
        <f:input path="accountNumber" />    
        <br><br>        
        <button>Check Balance</button>       
   </f:form> 
    
   <h3>Current Balance: ${balance}</h3>
	</div> 

	<br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>