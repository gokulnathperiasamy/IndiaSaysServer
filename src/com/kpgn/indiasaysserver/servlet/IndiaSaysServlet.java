package com.kpgn.indiasaysserver.servlet;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.kpgn.indiasaysserver.application.ApplicationConstant;
import com.kpgn.indiasaysserver.database.MySqlDBCreateScript;
import com.kpgn.indiasaysserver.entity.QuestionOptions;
import com.kpgn.indiasaysserver.server.QuestionOptionsMySqlDBServer;
import com.kpgn.indiasaysserver.server.QuestionResultMySqlDBServer;
import com.kpgn.indiasaysserver.utility.QuestionOptionsUtil;

public class IndiaSaysServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static long timeInterval = 0;
	
	public void init() throws ServletException {
		System.out.println("**********************************************************************");  
		System.out.println("AuthCode - Tomcat started successfully.");
		System.out.println("AuthCode - Checking for DB schema.");
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
