package com.google.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		int value1 = Integer.parseInt("value1");
		int value2 = Integer.parseInt("value2");
		String operation = request.getParameter("operation");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(operation);
		
		if(operation.equals("addition")) {
			System.out.println("value1 + value 2 = " + (value1 + value2));
			System.out.println("addition!");
		}else if(operation.equals("substraction")) {
			System.out.println("value1 - value2 = " + (value1-value2));
		}else if(operation.equals("multiply")) {
			System.out.println("value1 * value2 = " + (value1 * value2));
		}else if(operation.equals("division")) {
			System.out.println("value1 / value2 = " + (value1 / value2));
		}
	}
}
