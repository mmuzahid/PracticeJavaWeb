<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Form</title>
</head>
<body>
	<form method="post" action="save">
		<label for="title">Title:</label><input name="title" type="text" value="${post.title}"/>
		<label for="content">Content:</label><textarea name="content">${post.content}</textarea>
		
		<input type="hidden" name="id" value="${post.id}" />
		<button type="submit">Save</button>
	</form>
</body>
</html>