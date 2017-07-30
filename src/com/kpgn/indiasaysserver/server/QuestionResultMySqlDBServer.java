package com.kpgn.indiasaysserver.server;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.kpgn.indiasaysserver.application.QuestionResultConstant;
import com.kpgn.indiasaysserver.entity.IQuestionResult;
import com.kpgn.indiasaysserver.entity.QuestionOptions;
import com.kpgn.indiasaysserver.entity.QuestionResult;
import com.kpgn.indiasaysserver.utility.TextUtil;
import com.kpgn.indiasaysserver.utility.TimeUtil;

public class QuestionResultMySqlDBServer extends BaseMySqlDBServer {
	
	public static final String TABLE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ IQuestionResult.QUESTION_RESULT + "(" 
			+ IQuestionResult.QUESTION_ID + " VARCHAR(250) NOT NULL, "
			+ IQuestionResult.QUESTION + " VARCHAR(250) NULL, "
			+ IQuestionResult.GENDER + " VARCHAR(2) NULL, "
			+ IQuestionResult.AGE_GROUP_00_14 + " BIGINT NULL, "
			+ IQuestionResult.AGE_GROUP_15_24 + " BIGINT NULL, "
			+ IQuestionResult.AGE_GROUP_25_34 + " BIGINT NULL, "
			+ IQuestionResult.AGE_GROUP_35_44 + " BIGINT NULL, "
			+ IQuestionResult.AGE_GROUP_45_99 + " BIGINT NULL, "
			+ IQuestionResult.ROW_UPDATED + " BIGINT NULL, "
			+ " PRIMARY KEY (" + IQuestionResult.QUESTION_ID + "))"
			+ " ENGINE=InnoDB";
	
	private static Transaction transaction;
	
	private static QuestionResultMySqlDBServer questionResultMySqlDBServer;
	
	private QuestionResultMySqlDBServer() {
		// Make it a singleton class...
	}
	
	public static QuestionResultMySqlDBServer getInstance() {
		if (questionResultMySqlDBServer == null) {
			synchronized (QuestionResultMySqlDBServer.class) {
				if (questionResultMySqlDBServer == null) {
					questionResultMySqlDBServer = new QuestionResultMySqlDBServer();
				}
			}
		}
		return questionResultMySqlDBServer;
	}
	
	public synchronized boolean createQuestionResultBatch(QuestionOptions questionOptions) {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		QuestionResult questionResult;
		try {
			transaction = session.beginTransaction();
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_MALE 
					+ QuestionResultConstant.AGE_GROUP_00_14);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_MALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_MALE 
					+ QuestionResultConstant.AGE_GROUP_15_24);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_MALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_MALE 
					+ QuestionResultConstant.AGE_GROUP_25_34);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_MALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_MALE 
					+ QuestionResultConstant.AGE_GROUP_35_44);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_MALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_MALE 
					+ QuestionResultConstant.AGE_GROUP_45_99);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_MALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_FEMALE 
					+ QuestionResultConstant.AGE_GROUP_00_14);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_FEMALE 
					+ QuestionResultConstant.AGE_GROUP_15_24);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_FEMALE 
					+ QuestionResultConstant.AGE_GROUP_25_34);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_FEMALE 
					+ QuestionResultConstant.AGE_GROUP_35_44);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			questionResult = new QuestionResult();
			questionResult.setQuestionID(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
					+ TextUtil.STRING_DELIMITER 
					+ QuestionResultConstant.GENDER_FEMALE 
					+ QuestionResultConstant.AGE_GROUP_45_99);
			questionResult.setQuestion(questionOptions.getQuestion());
			questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
			questionResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
			session.save(questionResult);
			
			transaction.commit();
			return true;
		} catch (HibernateException he) {
			if (transaction != null) {
				transaction.rollback();
				transaction = null;
			} 
			he.printStackTrace();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				transaction = null;
			}
			e.printStackTrace();
		} finally {
			if (session != null) { session.close(); session = null; } 
		}
		return false;
	}
	
}
