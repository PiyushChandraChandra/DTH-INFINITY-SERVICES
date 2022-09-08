package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Retailer;

public class RetailerDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "id, name, Email, age, Phone1, Phone2, Addredd1, Address2, PIN, city, State, SetTopBoxLimit, creditLimit, InventoryCost, ServicesCharge, percenGoodsSale, Creation from Retailer";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("Name: %s", resultObj.getString("name")));
			System.out.println(String.format("Email: %s", resultObj.getString("email")));
			System.out.println(String.format("Phone1: %d", resultObj.getInt("phone1")));
			System.out.println(String.format("Phone2: %d", resultObj.getInt("phone2")));
			System.out.println(String.format("Address1: %d", resultObj.getInt("address1")));
			System.out.println(String.format("Address2: %d", resultObj.getInt("address2")));
			System.out.println(String.format("PIN: %d", resultObj.getInt("pin")));
			System.out.println(String.format("City: %d", resultObj.getInt("city")));
			System.out.println(String.format("State: %d", resultObj.getInt("state")));
			System.out.println(String.format("SetTopBoxLimit: %d", resultObj.getInt("settopboxlimit")));
			System.out.println(String.format("CreditLimit: %d", resultObj.getInt("creditlimit")));
			System.out.println(String.format("InventoryCost: %d", resultObj.getInt("inventorycost")));
			System.out.println(String.format("ServicesCharge: %d", resultObj.getInt("servicescharge")));
			System.out.println(String.format("PercentGoodsSale: %d", resultObj.getInt("percentgoodssale")));
			System.out.println(String.format("Creation: %d", resultObj.getInt("creation")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Retailer (id int, name varchar(30), age int, salary int)";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Retailer e) throws SQLException
	{
		String sql = "insert into Retailer (id, name, age, salary) values (?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getEmail());
		pstmt.setInt(4, e.getPhone1());
		pstmt.setInt(5, e.getPhone2());
		pstmt.setInt(6, e.getAddress1());
		pstmt.setInt(7, e.getAddress2());
		pstmt.setInt(8, e.getPIn());
		pstmt.setInt(9, e.getCity());
		pstmt.setInt(10, e.getState());
		pstmt.setInt(11, e.getSetTopBoxLimit());
		pstmt.setInt(12, e.getCreditLimit());
		pstmt.setInt(13, e.getInventoryCost());
		pstmt.setInt(14, e.getServicesCharge());
		pstmt.setInt(15, e.getPercentGoodsSale());
		pstmt.setInt(16, e.getCreation());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,int age,int sal,int id) throws SQLException
	{
		String sql="update Retailer set name=?,age=?,salary=? where id=?";
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
		String sql = "delete from retailer where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}
