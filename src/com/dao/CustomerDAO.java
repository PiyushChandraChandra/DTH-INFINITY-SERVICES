package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Customer;

public class CustomerDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, firstname, lastname, email, phone, starttime, noOfCustomers from Cutomer";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("First Name: %s", resultObj.getString("firstname")));
			System.out.println(String.format("Last Name: %s", resultObj.getString("lastname")));
			System.out.println(String.format("Email: %s", resultObj.getString("email")));
			System.out.println(String.format("Phone Number: %s", resultObj.getString("phone")));
			System.out.println(String.format("Start Time: %d", resultObj.getInt("starttime")));
			System.out.println(String.format("Number of customers: %d", resultObj.getInt("noOfCustomers")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Customer (id int, firstname varchar(30), lastname varchar(30), email varchar(30), phone varchar(30), starttime int, noOfCustomers int)";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Customer e) throws SQLException
	{
		String sql = "insert into Customer (id, firstname, lastname, email, phone, starttime, noOfCustomers) values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getFirstName());
		pstmt.setString(2, e.getLastName());
		pstmt.setString(2, e.getEmail());
		pstmt.setString(2, e.getPhone());
		pstmt.setLocalTime(3, e.getStarttime());
		pstmt.setInt(4, e.getNoOfCustomers());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String firstname,String lastname, String email,String phone,LocalTime starttime,int noOfCustomers,int id) throws SQLException
	{
		String sql="update Customer set firstname=?,lastname=?,email=?,phone=?,starttime=?,noOfCustomers=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,firstname);
		ps.setString(1,lastname);
		ps.setString(1,email);
		ps.setString(1,phone);
		ps.setLocalTime(2,starttime);
		ps.setInt(3, noOfCustomers);
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
