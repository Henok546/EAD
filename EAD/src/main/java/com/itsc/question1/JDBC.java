package com.itsc.question1;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {
public static void main(String[] args) {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	 String username = "your_username";
	 String password = "your_password";
	 String databaseName = "bookstore_db";
	 
	 try {
		 
		 Class.forName(driver);
		 
	 // Establish a connection to the MySQL server
	 Connection connection = DriverManager.getConnection
	 (url, username, password);
	 
	 // Create a statement
	 Statement statement = connection.createStatement();
	 
	 // Execute the SQL query to create the new database
	 String createDatabaseSQL = "CREATE DATABASE " + databaseName;
	 statement.executeUpdate(createDatabaseSQL);
	 System.out.println("Database '" + databaseName + " created successfully.");
	
	 // Creating Books table
	 String createTableSQL = "CREATE TABLE books (" +
			 "id int auto_increment primary key," +
			 "title varchar(100) not null," +
			 "author varchar(100) not null," +
			 "price varchar(100) not null";
	 
	 
			 statement.executeUpdate(createTableSQL);
			 System.out.println("Table ‘books’ is created successfully.");

					 
					 
	 // close resources
	 statement.close();
	 connection.close();
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 }
	}