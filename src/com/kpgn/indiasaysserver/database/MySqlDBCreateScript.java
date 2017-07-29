package com.kpgn.indiasaysserver.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kpgn.indiasaysserver.server.QuestionOptionsMySqlDBServer;

public class MySqlDBCreateScript extends MySqlDBHelper {
	
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public MySqlDBCreateScript() {
		super();
	}
	
	public static void main(String[] args) {
		createDBAndTable();
		System.exit(0);
	}

	public static void createDBAndTable() {
		new MySqlDBCreateScript();
		if(getConnection() != null) {
			try {
				runDBCreateScript();
				System.out.println("MySqlDBCreateScript: DB Created/Updated Successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MySqlDBCreateScript: DB Create Script Failed!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
				if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		} else {
			System.out.println("MySqlDBCreateScript: DB Error!");
		}
	}
	
	private static void runDBCreateScript() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate(QuestionOptionsMySqlDBServer.TABLE_CREATE_SQL);
	}

}
