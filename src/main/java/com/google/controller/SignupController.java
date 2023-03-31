package com.google.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("submitted!");
	}
}