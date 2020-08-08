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
	<table class="table">
		<tr>
			<th>Title</th>
			<th>Created At</th>
			<th>Content</th>
			<th>Tags</th>
			<th>Actions</th>
		</tr>
	<c:forEach var="post" items="${posts}">
		<tr>
			<td>${post.title}</td>
			<td>${post.createdAt}</td>
			<td>${post.content}</td>
			<td>
				<c:forEach var="tag" items="${post.tags}" varStatus = "status">
			        <c:out value="${tag.tagName}"></c:out>
			        <c:if test="${!status.last}">,</c:if>
			    </c:forEach>				
			</td>
			<td>
			    <a href="edit?id=${post.id}">Edit</a> |
        		<a onclick="return confirm('Do you want to delete this Post?');" href="delete?id=${post.id}">Delete</a>
			</td>
		</tr>
    </c:forEach>
    </table>
    
    
</body>
</html>