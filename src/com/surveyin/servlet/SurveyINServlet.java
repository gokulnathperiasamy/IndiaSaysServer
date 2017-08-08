package com.surveyin.servlet;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.surveyin.application.ApplicationConstant;
import com.surveyin.database.MySqlDBCreateScript;
import com.surveyin.entity.QuestionOptions;
import com.surveyin.server.QuestionOptionsMySqlDBServer;
import com.surveyin.server.QuestionResultMySqlDBServer;
import com.surveyin.utility.QuestionOptionsUtil;

public class SurveyINServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static long timeInterval = 0;
	
	public void init() throws ServletException {
		System.out.println("**********************************************************************");  
		System.out.println("SurveyIN - Tomcat started successfully.");
		System.out.println("SurveyIN - Checking for DB schema.");
		MySqlDBCreateScript.createDBAndTable();
		setupScheduler();
		System.out.println("**********************************************************************");
    }

	private void setupScheduler() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(invalidateAndCreateNewQuestion, 0, ApplicationConstant.INVALIDATE_CODE_TIMEOUT_IN_MINUTES, TimeUnit.MINUTES);
	}

	Runnable invalidateAndCreateNewQuestion = new Runnable() {
	    public void run() {
	    	timeInterval = System.currentTimeMillis() - (ApplicationConstant.INVALIDATE_CODE_TIMEOUT_IN_MINUTES * 60 * 1000);
	    	System.out.println("Invalidating questions prior to: " + new Date(timeInterval) + " - " + timeInterval);
	    	QuestionOptionsMySqlDBServer.getInstance().invalidateOldQuestions();
	    	QuestionOptions questionOptions = QuestionOptionsUtil.getQuestionOptions();
	    	QuestionOptionsMySqlDBServer.getInstance().createNewQuestionOptions(questionOptions);
	    	QuestionResultMySqlDBServer.getInstance().createQuestionResultBatch(questionOptions);
	    }
	};

}
