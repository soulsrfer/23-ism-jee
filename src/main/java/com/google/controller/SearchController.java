package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String SearchValue = request.getParameter("searchValue");
		
		ArrayList<UserBean> users = new UserDao().search(SearchValue);
		
		if(users == null) {
			request.setAttribute("error", "Not Available");
		} else {
			request.setAttribute("users", users);
			
		}
		
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	}
}
