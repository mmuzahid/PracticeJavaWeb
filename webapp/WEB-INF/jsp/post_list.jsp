<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isELIgnored="false" pageEncoding="ISO-8859-1"%>

<jsp:directive.include file='includes/taglibs.jsp' />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<jsp:include page='includes/header.jsp'>
    <jsp:param name="title" value="Posts"/>
</jsp:include>

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