package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private final static String URL = "jdbc:mysql://localhost:3306/dragons";
	private final static String USER = "root";
	private final static String PASSWORD = "P4ssw0rd";
	private static Connection connection;
	private static DBConnect instance;
	
	private DBConnect(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				instance = new DBConnect(connection);
				System.out.println("Connection Established");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnect.connection;
	}
}
