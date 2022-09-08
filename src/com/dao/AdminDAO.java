package com.dao;

import java.sql.*;


import com.bean.Admin;

public class AdminDAO {
	

	
	public ResultSet displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, name, username, password from Admin";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		return resultObj;
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
		pstmt.setString(3, e.getUsername());
		pstmt.setString(4, e.getPassword());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,String username,String password,int id) throws SQLException
	{
		String sql="update Employee set name=?,username=?,password=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,username);
		ps.setString(3, password);
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
