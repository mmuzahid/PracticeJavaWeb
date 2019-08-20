<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>

	<h1>Simple Web Application Demo!</h1>
	<p>(As a demo application, need to improve section like UI, Backend Framework etc)</p>
	<a href="post/">Show Posts</a>
	<security:authorize access="isAuthenticated()">
	    logged in as <security:authentication property="principal.username" />
	    <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</security:authorize>

</body>
</html>