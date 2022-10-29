package com.besant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPrepared {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id=scan.nextInt();
		System.out.println("Enter Name");
		String name=scan.next();
		System.out.println("Enter city");
		String city=scan.next();
		//selectQuery(1);
		insertQuery(id, name, city);
		scan.close();

	}
	
	public static void selectQuery(int id) {
		String url="jdbc:mySql://localhost:3306/shopping";
		String user="root";
		String password= "Pass@123";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				PreparedStatement ps= 
						connection.prepareStatement("select * from user where id=?");
				ps.setInt(1, 1);
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					System.out.print("ID: "+ rs.getLong(1));
					System.out.print(" NAME: "+ rs.getString("name"));
					System.out.println(" CITY: "+ rs.getString(3));
					}				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertQuery(int id,String name, String city) {
		String url="jdbc:mySql://localhost:3306/shopping";
		String user="root";
		String password= "Pass@123";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				
				String query= "insert into user values (?,?,?)";
				//String query="update user set city='Delhi' where id=2";
				//String query="delete from user where id="+id;
				PreparedStatement ps= connection.prepareStatement(query);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, city);
				
				int result = ps.executeUpdate();
				if(result ==1) {
					System.out.println("SUCCESS");			}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
