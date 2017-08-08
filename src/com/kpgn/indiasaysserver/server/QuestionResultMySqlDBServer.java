package com.kpgn.indiasaysserver.server;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kpgn.indiasaysserver.application.QuestionResultConstant;
import com.kpgn.indiasaysserver.entity.IQuestionResult;
import com.kpgn.indiasaysserver.entity.QuestionOptions;
import com.kpgn.indiasaysserver.entity.QuestionResult;
import com.kpgn.indiasaysserver.utility.TextUtil;
import com.kpgn.indiasaysserver.utility.TimeUtil;

public class QuestionResultMySqlDBServer extends BaseMySqlDBServer {
	
	public static final String TABLE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ IQuestionResult.QUESTION_RESULT + "(" 
			+ IQuestionResult.QUESTION_ID + " VARCHAR(250) , "
			+ IQuestionResult.QUESTION + " VARCHAR(250) , "
			+ IQuestionResult.GENDER + " VARCHAR(2) , "
			+ IQuestionResult.OPTIONS + " VARCHAR(250) , "
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
			
			long rowUpdated = TimeUtil.getCurrentTimeInLong();
			
			// Option A
			if (TextUtil.isNotEmpty(questionOptions.getOptionA())) {
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200)
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_MALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionA()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_MALE);
				questionResult.setOptions(questionOptions.getOptionA());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
				
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_FEMALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionA()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
				questionResult.setOptions(questionOptions.getOptionA());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
			}
			
			// Option B
			if (TextUtil.isNotEmpty(questionOptions.getOptionB())) {
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_MALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionB()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_MALE);
				questionResult.setOptions(questionOptions.getOptionB());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
				
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200)
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_FEMALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionB()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
				questionResult.setOptions(questionOptions.getOptionB());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
			}
			
			// Option C
			if (TextUtil.isNotEmpty(questionOptions.getOptionC())) {
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_MALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionC()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_MALE);
				questionResult.setOptions(questionOptions.getOptionC());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
				
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200)
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_FEMALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionC()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
				questionResult.setOptions(questionOptions.getOptionC());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
			}
			
			// Option D
			if (TextUtil.isNotEmpty(questionOptions.getOptionD())) {
				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_MALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionD()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_MALE);
				questionResult.setOptions(questionOptions.getOptionD());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);

				questionResult = new QuestionResult();
				questionResult.setQuestionID(TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptions.getQuestion(), 200) 
						+ TextUtil.STRING_DELIMITER 
						+ QuestionResultConstant.GENDER_FEMALE
						+ TextUtil.STRING_DELIMITER
						+ questionOptions.getOptionD()));
				questionResult.setQuestion(questionOptions.getQuestion());
				questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
				questionResult.setOptions(questionOptions.getOptionD());
				questionResult.setRowUpdated(rowUpdated);
				session.save(questionResult);
			}
			
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
	
	public synchronized ArrayList<QuestionResult> getAllQuestionResult() {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			ArrayList<QuestionResult> questionResultResponse = new ArrayList<>();
			List<?> questionResultList = session.createCriteria(QuestionResult.class).list();
			if (questionResultList != null) {
				ListIterator<?> questionResultListIterator = questionResultList.listIterator();
				while (questionResultListIterator != null && questionResultListIterator.hasNext()) {
					QuestionResult qResult = (QuestionResult) questionResultListIterator.next();
					questionResultResponse.add(qResult);
				}
			}
			transaction.commit();
			return questionResultResponse;
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
		return null;
	}
	
	public synchronized ArrayList<QuestionResult> getSingleQuestionResult(String question) {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			ArrayList<QuestionResult> questionResultResponse = new ArrayList<>();
			List<?> questionResultList = session.createCriteria(QuestionResult.class).add(Restrictions.eq("question", question)).list();
			if (questionResultList != null) {
				ListIterator<?> questionResultListIterator = questionResultList.listIterator();
				while (questionResultListIterator != null && questionResultListIterator.hasNext()) {
					QuestionResult qResult = (QuestionResult) questionResultListIterator.next();
					questionResultResponse.add(qResult);
				}
			}
			transaction.commit();
			return questionResultResponse;
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
		return null;
	}
	
	public synchronized boolean updateResult(QuestionResult questionResult) {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			List<?> questionResultList = session.createCriteria(QuestionResult.class)
					.add(Restrictions.eq("questionID", questionResult.getQuestionID()))
					.add(Restrictions.eq("options", questionResult.getOptions()))
					.list();
			if (questionResultList != null) {
				ListIterator<?> questionResultListIterator = questionResultList.listIterator();
				while (questionResultListIterator != null && questionResultListIterator.hasNext()) {
					QuestionResult qResult = (QuestionResult) questionResultListIterator.next();
					qResult.setAgeGroup_00_14(qResult.getAgeGroup_00_14() + questionResult.getAgeGroup_00_14());
					qResult.setAgeGroup_15_24(qResult.getAgeGroup_15_24() + questionResult.getAgeGroup_15_24());
					qResult.setAgeGroup_25_34(qResult.getAgeGroup_25_34() + questionResult.getAgeGroup_25_34());
					qResult.setAgeGroup_35_44(qResult.getAgeGroup_35_44() + questionResult.getAgeGroup_35_44());
					qResult.setAgeGroup_45_99(qResult.getAgeGroup_45_99() + questionResult.getAgeGroup_45_99());
					qResult.setRowUpdated(TimeUtil.getCurrentTimeInLong());
					session.update(qResult);
				}
			}
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
