<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}">Go Home</a> | <a href="new">+ New Post</a>
	<security:authorize access="isAuthenticated()">
	    logged in as <security:authentication property="principal.username" />
	    <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</security:authorize>
	<c:forEach var="post" items="${posts}">
        <div>
        	${post.title} (created at ${post.createdAt})
        	<a href="edit?id=${post.id}">Edit</a> |
        	<a onclick="return confirm('Do you want to delete this Post?');" href="delete?id=${post.id}">Delete</a>
        </div>
        <div>
        	<pre>${post.content}</pre>
        </div>
    </c:forEach>
    
</body>
</html>