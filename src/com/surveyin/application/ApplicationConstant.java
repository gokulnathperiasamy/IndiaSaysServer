package com.surveyin.application;

public abstract class ApplicationConstant {
	
	public static final String DB_NAME = "SurveyINDB";					// Change in Hibernate CFG XML also.
	
	public static final String MySQL_SERVER_IP = "localhost";			// Change in Hibernate CFG XML also.
	public static final String MySQL_SERVER_PORT = "3306";
	public static final String MySQL_USER_NAME = "root";				// Change in Hibernate CFG XML also.
	public static final String MySQL_PASSWORD = "root";					// Change in Hibernate CFG XML also.
	
	public static final String QUESTIONS_JSON_PATH = "/webapps/SurveyINQuestions.json";
	public static final String CATALINA_HOME = "/webapps/SurveyINQuestions.json";
	
	private static final int INVALIDATE_CODE_TIMEOUT_IN_DAYS = 7;		// In Days
	
	// Invalidate question for each INVALIDATE_CODE_TIMEOUT_IN_DAYS in days - AWS - Production
	public static final int INVALIDATE_CODE_TIMEOUT_IN_MINUTES = INVALIDATE_CODE_TIMEOUT_IN_DAYS * 1440;	// In minutes (24 hours = 1440 minutes)

	// Invalidate question for each INVALIDATE_CODE_TIMEOUT_IN_DAYS in Minutes - Local - Testing
	//public static final int INVALIDATE_CODE_TIMEOUT_IN_MINUTES = INVALIDATE_CODE_TIMEOUT_IN_DAYS;
}
