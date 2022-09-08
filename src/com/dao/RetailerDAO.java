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
	
	public int updateData(Connection connection, String name, String Email, Long Phone1, Long Phone2, String Address1,
			String Address2, int PIN, String city, String State, int SetTopBoxLimit, int creditLimit, int InventoryCost,
			int ServicesCharge, int percentGoodsSale, LocalDate Creation, int id) throws SQLException {
		String sql = "update Retailer set name=?,Email=?,Phone1=?,Phone2=?,Address1=?,Address2=?,PIN=?,city=?,State=?,"
				+ "SetTopBoxLimit=?,creditLimit=?,InventoryCost=?,ServicesCharge=?,percentGoodsSale,Creation=? where id=?";
		java.sql.PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, Email);
		ps.setLong(3, Phone1);
		ps.setLong(4, Phone2);
		ps.setString(5, Address1);
		ps.setString(6, Address2);
		ps.setInt(7, PIN);
		ps.setString(8, city);
		ps.setString(9, State);
		ps.setInt(10, SetTopBoxLimit);
		ps.setInt(11, creditLimit);
		ps.setInt(12, InventoryCost);
		ps.setInt(13, ServicesCharge);
		ps.setInt(14, percentGoodsSale);
		ps.setDate(15, Creation);
		ps.setInt(16, id);
		
		int updated = ps.executeUpdate();
		return updated;

	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from Retailer where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}
