<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Update Customer</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style6.css">    
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
				<c:url var="update_url" value="/update"></c:url> 
    <div class="update">    
    <f:form	action='${update_url}' modelAttribute="user">  
    	<label><b> Enter the Id of customer to be updated:     
        </b>    
        </label>    
        <f:input type="id" path="userId" />    
        <br><br> 
    	<label><b>Full Name:     
        </b>    
        </label>    
        <f:input type="name" path="name" />    
        <br><br> 
        <label><b>Gender:     
        </b>   
        </label>   
        <f:radiobutton path="gender" value="Male"/>  Male
        <f:radiobutton path="gender" value="Female"/>  Female
        <br><br> 
        <label><b>Date of Birth:     
        </b>    
        </label>    
        <f:input type="date" path="dateOfBirth" />    
        <br><br> 
        <label><b>Phone:     
        </b>    
        </label>    
        <f:input path="phone" />    
        <br><br> 
        <label><b>Email:     
        </b>    
        </label>    
        <f:input type="email" path="email" />    
        <br><br> 
        <label><b>Address:     
        </b>    
        </label>    
        <f:input path="address" />    
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