package com.tester;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.*;
import com.dao.*;

public class MasterTester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testdb2;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		AdminDAO dao=new AdminDAO();
		dao.createTable(connection);
		Admin df = new Admin(101,"default","default101","12345");
		int a=dao.insertData(connection,df);
		if(a==1){
			System.out.println("Default admin added Successfully");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("please verify your identity\nusername: ");
		String user = sc.nextLine();
		System.out.println("password: ");
		String pass = sc.nextLine();
		ResultSet rs = dao.displayRecords(connection);
		boolean auth = false;
		while(rs.next()){
			if((user.equalsIgnoreCase(rs.getString("username"))) && (pass.equals(rs.getString("password")))){
				System.out.println("Acess granted!");
				auth= true;
				break;
			}
		}
		if(auth){
			//switch statements
			while(true){
				System.out.println("Choose the operation you want to perform");
				System.out.println("1. Edit Customer Data\n2. Edit Operator data\n3. Edit Retailer data\n4. Edit Admin data");
				int c = sc.nextInt();
				switch(c){
					case 1:
					System.out.println("Chose the action you want to perform on customers data:");
					System.out.println("1. Add\n2. Update\n3. Delete\n4. Display");
					break;
					case 2:
					System.out.println("Chose the action you want to perform on operator data:");
					System.out.println("1. Add\n2. Update\n3. Delete\n4. Display");
					break;
					case 3:
					System.out.println("Chose the action you want to perform on retailer data:");
					System.out.println("1. Add\n2. Update\n3. Delete\n4. Display");
					break;
					case 4:
					System.out.println("Chose the action you want to perform on admin data:");
					System.out.println("1. Add\n2. Update\n3. Delete\n4. Display");
					break;
					default:
					System.out.println("Invalid Entry");
					break;
			}
				System.out.println("Do you want to continue(Y/N)");
				String exit = sc.next();
				if(exit=="Y"){
					break;
				}	
		}
		}
		else{
			System.out.println("Access denied");
		}
		
		connection.close();
 }
}
