package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	public static Connection getDBConnection() {

		Connection conn = null;

		try ( FileReader reader = new FileReader(DBUtil.class.getClassLoader().getResource("DBConfig.properties").getFile());
){
//			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMBank", "root", "root");
//			Connection conn = null;

			
			
			Properties prop = new Properties();
            prop.load(reader);

            String driver = prop.getProperty("driver.classname");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            // Load the MySQL JDBC driver class
            Class.forName(driver);

            // Create connection to the database
            conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

		} //catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

}

