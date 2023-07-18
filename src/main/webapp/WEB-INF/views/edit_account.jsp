<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Update Customer</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style9.css">    
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<c:if test="${err!=null}">
				<p class="error">${err}</p>
				</c:if> 
				<c:if test="${param.act eq 'up'}">
				<p class="success">Updated Successfully</p>
				</c:if> 
				<c:url var="update_url" value="/update_account"></c:url> 
    <div class="update">    
    <f:form	action='${update_url}' modelAttribute="edit_account">  
    	<label><b> Enter the account number of account to be updated:     
        </b>    
        </label>    
        <f:input path="accountNumber" />    
        <br><br> 
    	<label><b>Account Balance:     
        </b>    
        </label>    
        <f:input path="accountBalance" />    
        <br><br> 
        <label><b>Minimum Balance:     
        </b>    
        </label>    
        <f:input path="minimumBalance" />    
        <br><br> 
        <label><b>Date of Opening:     
        </b>    
        </label>    
        <f:input type="date" path="dateOfOpening" />    
        <br><br> 
        <label><b>Description:     
        </b>    
        </label>    
        <f:input path="description" />    
        <br><br>
        <label><b>Account Type:     
        </b>   
        </label>   
        <f:radiobutton path="accountType" value="1"/>  Saving
        <f:radiobutton path="accountType" value="2"/>  Current
        <br><br>     
        <button>Update</button>       
   </f:form>  
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