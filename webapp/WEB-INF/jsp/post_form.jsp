<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="app_fn" uri="custom-tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page='includes/header.jsp'>
    <jsp:param name="title" value="Post Form"/>
</jsp:include>

<body>
	<a href="${pageContext.request.contextPath}">Go Home</a>	
	<security:authorize access="isAuthenticated()">
	    logged in as <security:authentication property="principal.username" />
	    <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</security:authorize>
	<form method="post" action="save">
		<label for="title">Title:</label><input name="title" type="text" value="${post.title}"/>
		<label for="content">Content:</label><textarea name="content">${post.content}</textarea>
		<label for="title">Tags:</label>
		<select name="tagStrings[]" multiple="multiple">
		 	<option value="Java" ${app_fn:contains(post.tagNames, "Java") ? 'selected' : '' }>Java</option>
		 	<option value="CSS" ${app_fn:contains(post.tagNames, "CSS") ? 'selected' : '' }>CSS</option>
		 	<option value="Python" ${app_fn:contains(post.tagNames, "Python") ? 'selected' : '' }>Python</option>
		 </select>
		
		<input type="hidden" name="id" value="${post.id}" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">Save</button>
	</form>
</body>
</html>