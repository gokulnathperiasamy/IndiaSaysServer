package com.kpgn.indiasaysserver.database;

import java.sql.Connection;

import com.kpgn.indiasaysserver.application.ApplicationConstant;

public abstract class DBHelper {
	
	protected static final String DB_NAME = ApplicationConstant.DB_NAME;
	protected static Connection connection = null;

}
