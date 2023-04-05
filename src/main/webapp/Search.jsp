<%@page import="com.google.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<style type="text/css">
	input {
	font-size: 25px;
	}
</style>
</head>
<body align = "center">

<% 
	
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	String error = (String)request.getAttribute("error");
	
	%>
	<h1>Search User</h1>
	<a href="Registration.jsp"> Registration</a> 
	<a href="UsersListController"> User List</a> 
	
	<br><br>
	
	<form action="SearchController" method="post">
		Search : <input type="text" name="searchValue">
		<button type="submit">Search</button>
	</form>
	
	<br><br>
	
	
	<% if(users != null) { %>
	<table align="center" border="1"  width="500px">
		<tr>
			<th>UserId</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			
		</tr>
		
		<tr>
			<%
				
				for(UserBean user : users) {
			%>
			
			<td><%= user.getId() %></td>
			<td><%= user.getFirstName() + " " + user.getLastName() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getPassword() %></td>
			
			
		</tr>
		
		<%
			
				}
		%>
	</table>
	
	<%
				}
	%>
	<br>
	
	<h2><%= error == null? "" : error %></h2>
</body>
</html>