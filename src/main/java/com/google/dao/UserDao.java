package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.bean.UserBean;
import com.google.util.DBConnection;

public class UserDao {
	public void insert(UserBean ubean) {
		String insertQuery = "INSERT INTO user(firstName, lastName ,email , password, gender, city, hobby) VALUES(?, ? , ?, ?, ?, ?, ?)";
		
		Connection conn = DBConnection.getconnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(1, ubean.getFirstName());
			pstmt.setString(2, ubean.getLastName());
			pstmt.setString(3, ubean.getEmail());
			pstmt.setString(4, ubean.getPassword());
			pstmt.setString(5, ubean.getGender());
			pstmt.setString(6, ubean.getCity());
			pstmt.setString(7, ubean.getHobby());
			
			pstmt.executeUpdate();
			
			System.out.println("Record Inserted Successfully!");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public UserBean authenticate(String email, String password) {
		UserBean user = null;
		
		String fetchQuery = "SELECT * FROM user WHERE email = ? and password = ?";
		
		Connection conn = DBConnection.getconnection();
		
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(fetchQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setHobby(rs.getString("hobby"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<UserBean> getAll() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		String fetchAllQuery = "SELECT * FROM USER";
		
		Connection conn = DBConnection.getconnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(fetchAllQuery);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setHobby(rs.getString("hobby"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return users;
	}
	
	public ArrayList<UserBean> search(String searchValue) {
		
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		
		String SearchQuery = "SELECT * FROM user WHERE firstName OR lastName OR email LIKE ? ";
		
		Connection conn = DBConnection.getconnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SearchQuery);
			pstmt.setString(1, searchValue+"%");
			
ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setHobby(rs.getString("hobby"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
}
