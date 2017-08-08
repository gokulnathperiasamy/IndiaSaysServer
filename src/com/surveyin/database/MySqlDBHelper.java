package com.surveyin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.surveyin.application.ApplicationConstant;

public class MySqlDBHelper extends DBHelper {
	
	protected static String mySQLServerIP = ApplicationConstant.MySQL_SERVER_IP;
	protected static String mySQLServerPort = ApplicationConstant.MySQL_SERVER_PORT;
	protected static String mySQLUserName = ApplicationConstant.MySQL_USER_NAME;
	protected static String mySQLPassword = ApplicationConstant.MySQL_PASSWORD;
	
	protected static String connectionURL = null;
	protected static String connectionURLDB = null;

	protected static final String DRIVER_NAMESPACE = "com.mysql.jdbc.Driver";
	
	public MySqlDBHelper() {
		super();
		initializeURLs();
	}

	private void initializeURLs() {
		connectionURL = "jdbc:mysql://" + mySQLServerIP + ":" + mySQLServerPort;
		connectionURLDB = connectionURL + "/" + DBHelper.DB_NAME;
	}
	
	protected static boolean isMySQLDriverLoaded() {
		try {
			Class.forName(DRIVER_NAMESPACE);
			System.out.println("MySQLDBHelper: MySQL JDBC Driver Registered.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected static boolean checkConnection(String url) {
		try {
			connection = DriverManager.getConnection(url, mySQLUserName, mySQLPassword);
			System.out.println("MySqlDBHelper: Connection Success.");
		} catch (SQLException e) {
			System.out.println("MySqlDBHelper: Connection Failed.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected static synchronized Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			if(isMySQLDriverLoaded() && checkConnection(connectionURL) && connection != null && isDBAvailable() && connection != null) {
				return connection;
			}
		}
		return null;
	}
	
	private static boolean isDBAvailable() {
		
		String SQL = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + DBHelper.DB_NAME + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQL);
			while (resultSet != null && resultSet.next()) {
				String databaseName = resultSet.getString(1);
				if (databaseName != null && databaseName.equalsIgnoreCase(DBHelper.DB_NAME)) {
					if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
					if (checkConnection(connectionURLDB)) {
						return true;
					}
				}
			}
			System.out.println("MySqlDBHelper: DB Not available. Creating DB.");
			String CREATE_SQL = "CREATE DATABASE " + DBHelper.DB_NAME;
			statement.executeUpdate(CREATE_SQL);
			System.out.println("MySqlDBHelper: Database created!");
			if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
			if (checkConnection(connectionURLDB)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("MySqlDBHelper: DB Not available. Unable to create DB.");
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
			if (statement != null) try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
			// Do not close the connection here!
		}
		return false;
	}

}
