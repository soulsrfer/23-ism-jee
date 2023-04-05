<%@page import="com.google.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body align="center">
	<% 
	
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users"); 
	
	%>
	<h1>User List</h1>
	<a href="Registration.jsp"> Registration</a> 
	<a href="Search.jsp"> Search</a> 
	
	<br> <br>
	
	<table align="center" border="1"  width="500px">
		<tr>
			<th>UserId</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
		
		<tr>
			<%
				for(UserBean user : users) {
			%>
			
			<td><%= user.getId() %></td>
			<td><%= user.getFirstName() + " " + user.getLastName() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getPassword() %></td>
			<td><a href="DeleteUserController?userId=<%= user.getId() %>">Delete</a></td>
			
		</tr>
		
		<%
				}
		%>
	</table>
	
</body>
</html>