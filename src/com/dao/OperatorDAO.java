package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Operator;

public class OperatorDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, FirstName, LastName, Email, Phone, StartShift, EndShift, maxCustomersManage, ActiveCustomers, Creation from Operator";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("FirstName: %s", resultObj.getString("FirstName")));
			System.out.println(String.format("LastName: %s", resultObj.getString("LastName")));
			System.out.println(String.format("Email: %s", resultObj.getString("Email")));
			System.out.println(String.format("Phone: %Id", resultObj.getInt("Phone")));
			System.out.println(String.format("StartShift: %s", resultObj.getString("StartShift")));
			System.out.println(String.format("EndShift: %s", resultObj.getString("EndShift")));
			System.out.println(String.format("maxCustomersManage: %d", resultObj.getInt("maxCustomersManage")));
			System.out.println(String.format("ActiveCustomers: %d", resultObj.getInt("ActiveCustomers")));
			System.out.println(String.format("Creation: %d", resultObj.getDate("Creation")));
			
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Operator (id number(10), FirstName varchar(30), LastName varchar(30), Email varchar(30), Phone varchar2(10), StartShift varchar(30),EndShift varchar(30),maxCustomersManage number(10), ActiveCustomers number(10), Creation  )";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Operator e) throws SQLException
	{
		String sql = "insert into Operator (id, FirstName, LastName, Email, Phone, StartShift, EndShift, maxCustomersManage, ActiveCustomers, Creation ) values (?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getFirstName());
		pstmt.setString(3, e.getLastName());
		pstmt.setString(4, e.getEmail());
		pstmt.setLong(4, e.getPhone());
		pstmt.setString(4, e.getStartShift());
		pstmt.setString(4, e.getEndShift());
		pstmt.setInt(4, e.getmaxCustomersManage());
		pstmt.setInt(4, e.ActiveCustomers());
		pstmt.setDate(4, e.getCreation());
		
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String FirstName,String LastName,String Email, Long Phone, String StartShift, String EndShift, int maxCustomersManage, int ActiveCustomers, LocalDate Creation) throws SQLException
	{
		String sql="update Operator set FirstName=?,LastName=?,Email=?, Phone=?, StartShift=?, EndShift=?, maxCustomersManage=?, ActiveCustomers=?, Creation=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,FirstName);
		ps.setString(2,LastName);
		ps.setString(3, Email);
		ps.setLong(4, Phone);
		ps.setString(5, StartShift);
		ps.setString(6, EndShift);
		ps.setInt(7, maxCustomersManage);
		ps.setInt(8, ActiveCustomers);
		ps.setDate(9, Creation);
		
		
		
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from Operator where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}
