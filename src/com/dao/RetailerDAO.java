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
		String sql = "create table Retailer (id number(8), name varchar(30), Email varchar(30), Phone1 number(12), Phone2 number(12), Address1 varchar(30), Address2 varchar(30), PIN number(8), city varchar(30), State varchar(30), SetTopBoxLimit number(5), creditLimit number(8), InventoryCost number(8), ServicesCharge number(8), percentGoodsSale number(8), Creation DATE";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Retailer e) throws SQLException
	{
		String sql = "insert into Employee (id, name, age, salary) values (?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getAge());
		pstmt.setInt(4, e.getSalary());
		
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
