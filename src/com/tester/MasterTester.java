package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Admin;
import com.dao.AdminDAO;

public class MasterTester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testdb2;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		AdminDAO dao=new AdminDAO();
		Scanner sc = new Scanner(System.in);
		
		//dao.createTable(connection);
		
		while(true)
		{
			System.out.println("Menu");
			System.out.println("1. Display\n2. Insert\n3. Delete\n4. Update");
			
			switch(Integer.parseInt(sc.nextLine()))
			{
				case 1: 
					dao.displayRecords(connection);
				break;
				
				case 2: 
					System.out.print("Enter your ID: ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Name: ");
					String name = sc.nextLine();
					System.out.print("\nEnter your Age: ");
					int age = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Salary: ");
					int salary = Integer.parseInt(sc.nextLine());
					Admin e1=new Admin(id,name,age,salary);
					System.out.println(dao.insertData(connection,e1));
				break;
				
				case 3:
					System.out.print("Enter your ID: ");
					id = Integer.parseInt(sc.nextLine());
					dao.deleteData(connection, id);
				break;	
				case 4:
					
					System.out.print("\nEnter your Name: ");
					String n= sc.nextLine();
					System.out.print("\nEnter your Age: ");
					int a = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Salary: ");
					int sal = Integer.parseInt(sc.nextLine());
					System.out.print("Enter your ID: ");
					int eid = Integer.parseInt(sc.nextLine());
					
					dao.updateData(connection,n,a,sal,eid);
					break;
					
				
					
			}
			
			System.out.println("Press e to exit!");
			if(sc.nextLine().equals("e"))
			{
				break;
			}
		}
		
		connection.close();

	}

}
