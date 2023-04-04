package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.bean.UserBean;
import com.google.util.DBConnection;

public class UserDao {
	public void insert(UserBean ubean) {
		String insertQuery = "INSERT INTO user(firstName, lastName, password, gender, city, hobby) VALUES(?, ? , ?, ?, ?, ?)";
		
		Connection conn = DBConnection.getconnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(1, ubean.getFirstName());
			pstmt.setString(2, ubean.getLastName());
			pstmt.setString(3, ubean.getPassword());
			pstmt.setString(4, ubean.getGender());
			pstmt.setString(5, ubean.getCity());
			pstmt.setString(6, ubean.getHobby());
			
			pstmt.executeUpdate();
			
			System.out.println("Record Inserted Successfully!");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
