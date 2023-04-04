package com.google.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String hobby = request.getParameter("hobby");

		System.out.println("firstName => " + firstName);
		System.out.println("lastName => " + lastName);
		System.out.println("email => " + email);
		System.out.println("password => " + password);
		System.out.println("Confirm Password => " + confirmPassword);
		System.out.println("gender => " + gender);
		System.out.println("city => " + city);
		System.out.println("hobby => " + hobby);
		
		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		
		
		if(firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "<br>Please Enter FirstName");
		} else if(firstName.trim().length() <= 2) {
			isError = true;
			request.setAttribute("firstNameError", "<br>Please Enter atleast 3 chracters is FirstName");
		}else {
			String alpha = "[a-zA-Z]+";
			if (firstName.matches(alpha) == false) {
				isError = true;
				request.setAttribute("firstNameError", "<br>Please Enter Valid FirstName");
			} else {
				request.setAttribute("firstNameValue", firstName);
			}
		}
		
		
		if(lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "<br>Please Enter Last Name");
		} else if(lastName.trim().length() <= 2) {
			isError = true;
			request.setAttribute("lastNameError", "<br>Please Enter atleast 3 chracters is Last Name");
		}else {
			String alpha = "[a-zA-Z]+";
			if (lastName.matches(alpha) == false) {
				isError = true;
				request.setAttribute("lastNameError", "<br>Please Enter Valid Last Name");
			} else {
				request.setAttribute("lastNameValue", lastName);
			}
		}
		
		
		if(email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "<br>Please Enter Email");
		}else {
			String alpha = "[a-z]{2,10}.+[a-z]{2,10}[0-9]{0,4}@[gmail]{5}.[com]{3}";
					if(email.matches(alpha) == false) {
						isError = true;
						request.setAttribute("emailError","<br>Please Enter Valid Email");
					} else {
						request.setAttribute("emailValue", email);
					}
		}
		
		
		if(password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "<br>Please Enter Password");
		}else if(confirmPassword == null || confirmPassword.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "<br>Please Confirm Password");
		}else if(!confirmPassword.equals(password)){
			isError = true;
			request.setAttribute("passwordError", "<br>Password doesn't match");
		} 
		
		
		if(gender == null) {
			isError = true;
			request.setAttribute("genderError","<br>Please Select Your gender");
		}
		
		
		if(city.trim().length() == 0) {
			isError = true;
			request.setAttribute("cityError", "<br>Please Select Your City");
		}
		
		if(hobby == null || hobby.trim().length() == 0) {
			isError = true;
			request.setAttribute("hobbyError", "<br>Please Select Atleast One Hobby");
		}
		
		
		RequestDispatcher rd = null;
		if(isError) {
			
			rd = request.getRequestDispatcher("Registration.jsp");
		} else {
			
			UserBean user = new UserBean(0, firstName, lastName, email,  password, gender, city, hobby);
			
			UserDao userDao = new UserDao();
			userDao.insert(user);
			
			rd = request.getRequestDispatcher("Login.jsp");
		}
		
		rd.forward(request, response);
		
	}
}
