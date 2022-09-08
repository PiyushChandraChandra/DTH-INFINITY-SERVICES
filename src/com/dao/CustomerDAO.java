package com.dao;

import java.sql.*;
import java.time.LocalDate;

import com.bean.Customer;

public class CustomerDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, firstName, lastName, email, phone, address1, address2, landMark, PIN, date, city, state, operatorName, retailerName from Cutomer";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("First Name: %s", resultObj.getString("firstName")));
			System.out.println(String.format("Last Name: %s", resultObj.getString("lastName")));
			System.out.println(String.format("Email: %s", resultObj.getString("email")));
			System.out.println(String.format("Phone Number: %s", resultObj.getLong("phone")));
			System.out.println(String.format("Address1: %s", resultObj.getString("address1")));
			System.out.println(String.format("Address2: %s", resultObj.getString("address2")));
			System.out.println(String.format("LandMark: %s", resultObj.getString("landMark")));
			System.out.println(String.format("PIN Code: %d", resultObj.getInt("PIN")));
			System.out.println(String.format("Date: %d", resultObj.getDate("Date")));
			System.out.println(String.format("City: %s", resultObj.getString("city")));
			System.out.println(String.format("State: %s", resultObj.getString("state")));
			System.out.println(String.format("Operator Name: %d", resultObj.getString("operatorName")));
			System.out.println(String.format("Retailer Name: %d", resultObj.getString("retailerName")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Customer (id int, firstName varchar(30), lastName varchar(30), email varchar(30), phone int, address1 varchar(30), address2 varchar(30), landMark varchar(30), PIN int, city varchar(30), state varchar(30), operatorName varchar(30), retailerName varchar(30))";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Customer e) throws SQLException
	{
		String sql = "insert into Customer (id, firstName, lastName, email, phone, address1, address2, landMark, PIN, city, state, operatorName, retailerName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getid());
		pstmt.setString(2, e.getFirstName());
		pstmt.setString(3, e.getLastName());
		pstmt.setString(4, e.getEmail());
		pstmt.setLong(5, e.getPhone());
		pstmt.setString(6, e.getAddress1());
		pstmt.setString(7, e.getAddress2());
		pstmt.setString(8, e.getLandMark());
		pstmt.setInt(9, e.getPIN());
		pstmt.setString(11, e.getCity());
		pstmt.setString(12, e.getState());
		pstmt.setString(13, e.getOperatorName());
		pstmt.setString(14, e.getRetailerName());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String firstname,String lastname, String email,long phone,String address1, String address2, String landMark, int pIN, LocalDate date, String city, String state, String operatorName, String retailerName, int id) throws SQLException
	{
		String sql="update Customer set firstName=?, lastName=?, email=?, phone=?, address1=?, address2=?, landMark=?, PIN=?, date=?, city=?, state=?, operatorName=?, retailerName=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,firstname);
		ps.setString(1,lastname);
		ps.setString(1,email);
		ps.setLong(1,phone);
		ps.setString(1,address1);
		ps.setString(1,address2);
		ps.setString(1,landMark);
		ps.setInt(1,pIN);
		ps.setString(1,city);
		ps.setString(1,state);
		ps.setString(1,operatorName);
		ps.setString(1,retailerName);
		ps.setInt(4, id);
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from Customer where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}
