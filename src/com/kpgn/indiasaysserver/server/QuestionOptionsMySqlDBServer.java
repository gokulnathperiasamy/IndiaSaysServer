package com.kpgn.indiasaysserver.server;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.kpgn.indiasaysserver.entity.IQuestionOptions;
import com.kpgn.indiasaysserver.entity.QuestionOptions;

public class QuestionOptionsMySqlDBServer extends BaseMySqlDBServer {
	
	public static final String TABLE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ IQuestionOptions.QUESTION_OPTIONS + "(" 
			+ IQuestionOptions.QUESTION + " VARCHAR(250) NOT NULL, "
			+ IQuestionOptions.OPTION_A + " VARCHAR(64) NULL, "
			+ IQuestionOptions.OPTION_B + " VARCHAR(64) NULL, "
			+ IQuestionOptions.OPTION_C + " VARCHAR(64) NULL, "
			+ IQuestionOptions.OPTION_D + " VARCHAR(64) NULL, "
			+ IQuestionOptions.IS_VALID + " BOOLEAN NULL, "
			+ IQuestionOptions.IS_AGE_RESTRICTED + " BOOLEAN NULL, "
			+ IQuestionOptions.DATE_CREATED + " BIGINT NULL, "
			+ IQuestionOptions.ROW_UPDATED + " BIGINT NULL, "
			+ " PRIMARY KEY (" + IQuestionOptions.QUESTION + "))"
			+ " ENGINE=InnoDB";
	
	private static Transaction transaction;
	
	private static QuestionOptionsMySqlDBServer authCodeMySqlDBServer;
	
	private QuestionOptionsMySqlDBServer() {
		// Make it a singleton class...
	}
	
	public static QuestionOptionsMySqlDBServer getInstance() {
		if (authCodeMySqlDBServer == null) {
			synchronized (QuestionOptionsMySqlDBServer.class) {
				if (authCodeMySqlDBServer == null) {
					authCodeMySqlDBServer = new QuestionOptionsMySqlDBServer();
				}
			}
		}
		return authCodeMySqlDBServer;
	}
	
	public synchronized boolean invalidateOldQuestions() {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			List<?> questionOptionsList = session.createCriteria(QuestionOptions.class).list();
			if (questionOptionsList != null) {
				ListIterator<?> questionOptionListIterator = questionOptionsList.listIterator();
				while (questionOptionListIterator != null && questionOptionListIterator.hasNext()) {
					QuestionOptions questionOptions = (QuestionOptions) questionOptionListIterator.next();
					questionOptions.setIsValid(false);
					session.update(questionOptions);
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
	
	
	public synchronized boolean createNewQuestionOptions(QuestionOptions questionOptions) {
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(questionOptions);
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
	
	public synchronized QuestionOptions getCurrentQuestionOptions() {
		QuestionOptions questionOptions;
		
		if (factory == null) createFactory();
		if (session == null) session = factory.openSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			questionOptions = (QuestionOptions) session.createCriteria(QuestionOptions.class)
					.add(Restrictions.eq("isValid", true))
				    .uniqueResult();
			if (questionOptions != null) {
				transaction.commit();
				return questionOptions;
			}
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
	
}
