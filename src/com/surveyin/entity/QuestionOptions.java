package com.surveyin.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name=IQuestionOptions.QUESTION_OPTIONS)
@XmlType(propOrder={"question", "optionA", "optionB", "optionC", "optionD", "isValid", "isAgeRestricted", "dateCreated", "rowUpdated"})
public class QuestionOptions extends BaseEntity {
	
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private boolean isValid;
	private boolean isAgeRestricted;
	protected long dateCreated;
	
	public QuestionOptions() {
		
	}
	
	public QuestionOptions(String question, String optionA, String optionB, String optionC, String optionD, boolean isValid, boolean isAgeRestricted, long dateCreated, long rowUpdated) {
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.isValid = isValid;
		this.isAgeRestricted = isAgeRestricted;
		this.dateCreated = dateCreated;
		this.rowUpdated = rowUpdated;
	}
	
	
	@XmlElement(name=IQuestionOptions.QUESTION)
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@XmlElement(name=IQuestionOptions.OPTION_A)
	public String getOptionA() {
		return optionA;
	}
	
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	@XmlElement(name=IQuestionOptions.OPTION_B)
	public String getOptionB() {
		return optionB;
	}
	
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	@XmlElement(name=IQuestionOptions.OPTION_C)
	public String getOptionC() {
		return optionC;
	}
	
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	@XmlElement(name=IQuestionOptions.OPTION_D)
	public String getOptionD() {
		return optionD;
	}
	
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	@XmlElement(name=IQuestionOptions.IS_VALID)
	public boolean getIsValid() {
		return isValid;
	}
	
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	@XmlElement(name=IQuestionOptions.DATE_CREATED)
	public boolean getIsAgeRestricted() {
		return isAgeRestricted;
	}
	
	public void setIsAgeRestricted(boolean isAgeRestricted) {
		this.isAgeRestricted = isAgeRestricted;
	}
	
	@XmlElement(name=IQuestionOptions.DATE_CREATED)
	public long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(long dateCreated) {
		this.dateCreated = dateCreated;
	}

}
