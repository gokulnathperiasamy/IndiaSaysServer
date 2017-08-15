package com.surveyin.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.surveyin.application.QuestionResultConstant;
import com.surveyin.entity.IQuestionOptions;
import com.surveyin.entity.IQuestionResult;
import com.surveyin.entity.QuestionOptions;
import com.surveyin.entity.QuestionResult;
import com.surveyin.utility.TextUtil;
import com.surveyin.utility.TimeUtil;

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
	
	public synchronized boolean createQuestionResultBatch(List<QuestionOptions> questionOptionsList) {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		QuestionResult questionResult;
		try {
			transaction = session.beginTransaction();
			
			long rowUpdated = TimeUtil.getCurrentTimeInLong();
			
			for (int index = 0; index < questionOptionsList.size(); index++) {

				// Option A
				if (TextUtil.isNotEmpty(questionOptionsList.get(index).getOptionA())) {
					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_MALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionA()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_MALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionA());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);

					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_FEMALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionA()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionA());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);
				}

				// Option B
				if (TextUtil.isNotEmpty(questionOptionsList.get(index).getOptionB())) {
					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_MALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionB()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_MALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionB());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);

					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER + QuestionResultConstant.GENDER_FEMALE
									+ TextUtil.STRING_DELIMITER + questionOptionsList.get(index).getOptionB()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionB());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);
				}

				// Option C
				if (TextUtil.isNotEmpty(questionOptionsList.get(index).getOptionC())) {
					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_MALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionC()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_MALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionC());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);

					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_FEMALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionC()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionC());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);
				}

				// Option D
				if (TextUtil.isNotEmpty(questionOptionsList.get(index).getOptionD())) {
					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_MALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionD()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_MALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionD());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);

					questionResult = new QuestionResult();
					questionResult.setQuestionID(
							TextUtil.removeSpaces(TextUtil.trimStringLength(questionOptionsList.get(index).getQuestion(), 200)
									+ TextUtil.STRING_DELIMITER 
									+ QuestionResultConstant.GENDER_FEMALE
									+ TextUtil.STRING_DELIMITER 
									+ questionOptionsList.get(index).getOptionD()));
					questionResult.setQuestion(questionOptionsList.get(index).getQuestion());
					questionResult.setGender(QuestionResultConstant.GENDER_FEMALE);
					questionResult.setOptions(questionOptionsList.get(index).getOptionD());
					questionResult.setRowUpdated(rowUpdated);
					session.save(questionResult);
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
	
	public synchronized ArrayList<HashMap<String, Object>> getAllQuestionResult() {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			
			ArrayList<HashMap<String,Object>> QuestionResultList = new ArrayList<>();
			HashMap<String,Object> allQuestionResultObject;			
			List<?> questionOptionsList = session.createCriteria(QuestionOptions.class).list();
			List<?> questionResultList = session.createCriteria(QuestionResult.class).list();
			ArrayList<QuestionResult> questionResultResponse;
			if (questionOptionsList != null) {
				ListIterator<?> questionOptionsListIterator = questionOptionsList.listIterator();
				while (questionOptionsListIterator != null && questionOptionsListIterator.hasNext()) {
					allQuestionResultObject = new HashMap<String,Object>();	
					QuestionOptions questionOptionsResult = (QuestionOptions) questionOptionsListIterator.next();
					allQuestionResultObject.put(IQuestionOptions.QUESTION, questionOptionsResult.getQuestion().toString());
					allQuestionResultObject.put(IQuestionOptions.OPTION_A, questionOptionsResult.getOptionA());
					allQuestionResultObject.put(IQuestionOptions.OPTION_B, questionOptionsResult.getOptionB());
					allQuestionResultObject.put(IQuestionOptions.OPTION_C, questionOptionsResult.getOptionC());
					allQuestionResultObject.put(IQuestionOptions.OPTION_D, questionOptionsResult.getOptionD());
					questionResultResponse = new ArrayList<>();
					if (questionResultList != null) {
						ListIterator<?> questionResultListIterator = questionResultList.listIterator();
						while (questionResultListIterator != null && questionResultListIterator.hasNext()) {
							QuestionResult questionResultResult = (QuestionResult) questionResultListIterator.next();
							if(questionResultResult.getQuestion().equals(questionOptionsResult.getQuestion())) {
								questionResultResponse.add(questionResultResult);
							}
						}
						allQuestionResultObject.put("Result", (ArrayList<QuestionResult>) questionResultResponse);
					}
					QuestionResultList.add(allQuestionResultObject);	
				}
			}
			transaction.commit();
			return QuestionResultList;
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
