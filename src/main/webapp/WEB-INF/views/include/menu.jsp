<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<head>
<style>
a    {color: black;}
</style>
</head>

<s:url var="url_logout" value="/logout"/>
<s:url var="url_register" value="/register"/>
<c:if test="${sessionScope.userId==null}">
<%-- Guest User no one is logged in --%>
<a  href="#">Home</a>|<a href="#"> Login </a> | <a href="${url_register}"> Register </a> | <a href="#"> About </a>|
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role ==1}">
<%-- Admin is logged in --%>
<a href="#">Home</a>|<a href="#"> About</a> | <a href="${url_logout}"> Logout </a>|
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role ==2}">
<%-- General User is logged in --%>
<a href="#">Home</a>|<a href="#"> About</a> | <a href="${url_logout}"> Logout </a>|
</c:if>

