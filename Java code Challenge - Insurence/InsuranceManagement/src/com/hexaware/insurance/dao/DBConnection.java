package com.hexaware.insurance.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getDBConnection() {


		
		

			Connection conn = null;

			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance", "root", "root");

			} catch (SQLException e) {

			}

			return conn;

		}
	
	
//	Connection conn = null;
//
//	try {
//		FileReader reader = new FileReader("DBConfig.properties");
//		
//		Properties prop = new Properties();
//        prop.load(reader);
//
//        String driver = prop.getProperty("driver.classname");
//        String url = prop.getProperty("url");
//        String username = prop.getProperty("username");
//        String password = prop.getProperty("password");
//        
//        Class.forName(driver);
//        
//        conn = DriverManager.getConnection(url, username, password);
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return conn;
//		
//	
//}
	
}
	

