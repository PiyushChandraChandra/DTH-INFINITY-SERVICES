package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Admin;

public class AdminDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, name, username, password from Admin";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("Name: %s", resultObj.getString("name")));
			System.out.println(String.format("Username: %d", resultObj.getInt("username")));
			System.out.println(String.format("Password: %d", resultObj.getInt("password")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Employee (id int, name varchar(30), username varchar(30),password varchar(30))";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Admin e) throws SQLException
	{
		String sql = "insert into Employee (id, name, username, password) values (?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getUsername());
		pstmt.setInt(4, e.getPassword());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,String username,String password,int id) throws SQLException
	{
		String sql="update Employee set name=?,age=?,salary=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2,username);
		ps.setInt(3, password);
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from Employee where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}
