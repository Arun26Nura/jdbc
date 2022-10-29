package com.besant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnection {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int id=scan.nextInt();
		//selectQuery();
		insertQuery(id);

	}
	
	public static void insertQuery(int id) {
		String url="jdbc:mySql://localhost:3306/shopping";
		String user="root";
		String password= "Pass@123";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				Statement st= connection.createStatement();
				//String query= "insert into user values (2,'name2','chennai')";
				//String query="update user set city='Delhi' where id=2";
				String query="delete from user where id="+id;
				int result = st.executeUpdate(query);
				if(result ==1) {
					System.out.println("SUCCESS");
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void selectQuery() {
		String url="jdbc:mySql://localhost:3306/shopping";
		String user="root";
		String password= "Pass@123";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				String query="select * from user";
				Statement st=connection.createStatement();
				ResultSet rs= st.executeQuery(query);			
				while(rs.next()) {
				System.out.print("ID: "+ rs.getLong(1));
				System.out.print(" NAME: "+ rs.getString("name"));
				System.out.println(" CITY: "+ rs.getString(3));
				}
				connection.close();
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
