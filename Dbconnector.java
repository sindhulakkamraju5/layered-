package com.pace.library.helper;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;



/*
 * *Helper class to handle
 */

public class Dbconnector {
	private static Connection connection=null;
	
	//
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		String url,userId,passWord;
		url ="jdbc:mysql://@localhost:3306/db";
		userId="root";
		passWord="abcd1234$";
	    Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,userId,passWord);
		return connection;
		
	}
	//closing connection
	public static void closeConnection() throws SQLException{
		 connection.close();

	}
}
