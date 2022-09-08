package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Retailer;

public class RetailerDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, name, age, salary from Employee";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("Name: %s", resultObj.getString("name")));
			System.out.println(String.format("Age: %d", resultObj.getInt("age")));
			System.out.println(String.format("Salary: %d", resultObj.getInt("salary")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Employee (id int, name varchar(30), age int, salary int)";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Retailer e) throws SQLException
	{
		String sql = "insert into Retailer (id, name, Email, Phone1,Phone2,Address1,Address2,PIN,city,State,SetTopBoxLimit,creditLimit,InventoryCost,ServicesCharge,personGoodsSale,Creation) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setString(3, e.getEmail());
		pstmt.setLong(4, e.getPhone1());
		pstmt.setLong(4, e.getPhone2());
		pstmt.setString(4, e.getAddress1());
		pstmt.setString(4, e.getAddress2());
		pstmt.setInt(4, e.getPIN());
		pstmt.setString(4, e.getCity());
		pstmt.setString(4, e.getState());
		pstmt.setInt(4, e.getSetTopBoxLimit());
		pstmt.setInt(4, e.getCreditLimit());
		pstmt.setInt(4, e.getInventoryCost());
		pstmt.setInt(4, e.getServicesCharge());
		pstmt.setInt(4, e.getPercentGoodsSale());
		pstmt.setDate(4, e.getCreation());
		
		
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,int age,int sal,int id) throws SQLException
	{
		String sql="update Employee set name=?,age=?,salary=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2,age);
		ps.setInt(3, sal);
		ps.setInt(4, id);
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
