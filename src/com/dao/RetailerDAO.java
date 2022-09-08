package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Retailer;

public class RetailerDAO {
	

	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, name, Email, age, Phone1, Phone2, Addredd1, Address2, PIN, city, State, SetTopBoxLimit, creditLimit, InventoryCost, ServicesCharge, percenGoodsSale, Creation from Retailer";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("Name: %s", resultObj.getString("name")));
			System.out.println(String.format("Email: %s", resultObj.getString("email")));
			System.out.println(String.format("Phone1: %d", resultObj.getInt("phone1")));
			System.out.println(String.format("Phone2: %d", resultObj.getInt("phone2")));
			System.out.println(String.format("Address1: %d", resultObj.getString("address1")));
			System.out.println(String.format("Address2: %d", resultObj.getString("address2")));
			System.out.println(String.format("PIN: %d", resultObj.getInt("pin")));
			System.out.println(String.format("City: %d", resultObj.getString("city")));
			System.out.println(String.format("State: %d", resultObj.getString("state")));
			System.out.println(String.format("SetTopBoxLimit: %d", resultObj.getInt("settopboxlimit")));
			System.out.println(String.format("CreditLimit: %d", resultObj.getInt("creditlimit")));
			System.out.println(String.format("InventoryCost: %d", resultObj.getInt("inventorycost")));
			System.out.println(String.format("ServicesCharge: %d", resultObj.getInt("servicescharge")));
			System.out.println(String.format("PercentGoodsSale: %d", resultObj.getInt("percentgoodssale")));
			System.out.println(String.format("Creation: %d", resultObj.getDate("creation")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Retailer (id number(8), name varchar(30), email varchar(30), phone1 number(12), phone2 number(12), address1 varchar(30), address2 varchar(30), pin number(8), city varchar(30), state varchar(30), settopBoxLimit number(5), creditlimit number(8), inventoryCost number(8), servicescharge number(8), percentgoodssale number(8), Creation DATE";

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
		pstmt.setLong(5, e.getPhone2());
		pstmt.setString(6, e.getAddress1());
		pstmt.setString(7, e.getAddress2());
		pstmt.setInt(8, e.getPIN());
		pstmt.setString(9, e.getCity());
		pstmt.setString(10, e.getState());
		pstmt.setInt(11, e.getSetTopBoxLimit());
		pstmt.setInt(12, e.getCreditLimit());
		pstmt.setInt(13, e.getInventoryCost());
		pstmt.setInt(14, e.getServicesCharge());
		pstmt.setInt(15, e.getPercentGoodsSale());
		pstmt.setDate(16, e.getCreation());
		
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
