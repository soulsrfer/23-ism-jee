<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
body {
	font-size: 25px;
	}
	
	button {
		font-size: 30px
	}
	
	span {
		color: red;
	}
</style>
</head>
<body align="center">

	<% String error = (String)request.getAttribute("error"); %>
	<h1>Login</h1>
	<form action=" LoginController" method="post">
	Username/email:
	<input type="email" name="email"><br><br>
	Password:
	<input type="password" name="password"><br><br>
	<button type="submit">Submit</button>
	</form>
	<br>
	<%= error == null ? "" : error %>
</body>
</html>