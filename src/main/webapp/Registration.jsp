<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<style type="text/css">
	body {
	font-size: 30px;
	}
	button {
	font-size: 30px}
	
	span {
	color: red;
	}
</style>
</head>
<body>

	<% 
		String firstNameError= (String)request.getAttribute("firstNameError");
		String lastNameError= (String)request.getAttribute("lastNameError");
		String emailError= (String)request.getAttribute("emailError");
		String passwordError= (String)request.getAttribute("passwordError");
		String genderError= (String)request.getAttribute("genderError");
		String cityError= (String)request.getAttribute("cityError");
		String hobbyError= (String)request.getAttribute("hobbyError");
	%>
	<form action="RegistrationController" method="post">
		First name : <input type="text" name="firstName" value="${ firstNameValue == null ? '' : firstNameValue }">
					<span> <%= firstNameError == null? "" : firstNameError %></span> 
					<br><br>
		Last name : <input type="text" name="lastName" value="${ lastNameValue == null ? '' : lastNameValue }"> 
					<span><%= lastNameError == null ? "" : lastNameError %></span>
					<br><br>
		Email : <input type="email" name="email" value="${ emailValue == null ? '' : emailValue }">
				<span><%= emailError == null ? "" : emailError %></span>
				<br><br>
		Password : <input type="password" name="password">
					<span><%= passwordError == null ? "" : passwordError %></span>
					<br><br>
		
		Confirm Password : <input type="password" name="confirmPassword"><br><br>
		
		Gender: <input type="radio" value="male" name="gender"> male
				<input type="radio" value="female" name="gender">female
				<span><%= genderError == null ? "" : genderError %></span>
		<br><br>
		
		City: 	<select name="city">
					<option value=""></option>
					<option value="ahmedabad">Ahmedabad</option>
					<option value="delhi">Delhi</option>
					<option value="mumbai">mumbai</option>
				</select>
				<span><%= cityError == null ? "" : cityError %></span>
		<br><br>
		Hobby: <input type="checkbox" name="hobby" value="coding">coding
				<input type="checkbox" name="hobby" value="dancing">dancing
				<input type="checkbox" name="hobby" value="singing">singing
				
				<span><%= hobbyError == null ? "" : hobbyError %></span>
		<br><br>
		
		<button type="submit">Submit</button>
		
	</form>
	
</body>
</html>