package com.kpgn.indiasaysserver.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name=IQuestionResult.QUESTION_RESULT)
@XmlType(propOrder={"questionID", "question", "gender", "ageGroup_00_14", "ageGroup_15_24", "ageGroup_25_34", "ageGroup_35_44", "ageGroup_45_99"})
public class QuestionResult extends BaseEntity {
	
	private String questionID;
	private String question;
	private String gender;
	private long ageGroup_00_14;
	private long ageGroup_15_24;
	private long ageGroup_25_34;
	private long ageGroup_35_44;
	private long ageGroup_45_99;
	
	public QuestionResult() {
		
	}
	
	public QuestionResult(String questionID, String question, String gender, long ageGroup_00_14, long ageGroup_15_24, long ageGroup_25_34, long ageGroup_35_44, long ageGroup_45_99) {
		this.questionID = questionID;
		this.question = question;
		this.gender = gender;
		this.ageGroup_00_14 = ageGroup_00_14;
		this.ageGroup_15_24 = ageGroup_15_24;
		this.ageGroup_25_34 = ageGroup_25_34;
		this.ageGroup_35_44 = ageGroup_35_44;
		this.ageGroup_45_99 = ageGroup_45_99;
	}
	
	
	@XmlElement(name=IQuestionResult.QUESTION_ID)
	public String getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	
	@XmlElement(name=IQuestionResult.QUESTION)
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@XmlElement(name=IQuestionResult.GENDER)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@XmlElement(name=IQuestionResult.AGE_GROUP_00_14)
	public long getAgeGroup_00_14() {
		return ageGroup_00_14;
	}
	
	public void setAgeGroup_00_14(long ageGroup_00_14) {
		this.ageGroup_00_14 = ageGroup_00_14;
	}
	
	@XmlElement(name=IQuestionResult.AGE_GROUP_15_24)
	public long getAgeGroup_15_24() {
		return ageGroup_15_24;
	}
	
	public void setAgeGroup_15_24(long ageGroup_15_24) {
		this.ageGroup_15_24 = ageGroup_15_24;
	}
	
	@XmlElement(name=IQuestionResult.AGE_GROUP_25_34)
	public long getAgeGroup_25_34() {
		return ageGroup_25_34;
	}
	
	public void setAgeGroup_25_34(long ageGroup_25_34) {
		this.ageGroup_25_34 = ageGroup_25_34;
	}
	
	@XmlElement(name=IQuestionResult.AGE_GROUP_35_44)
	public long getAgeGroup_35_44() {
		return ageGroup_35_44;
	}
	
	public void setAgeGroup_35_44(long ageGroup_35_44) {
		this.ageGroup_35_44 = ageGroup_35_44;
	}
	
	@XmlElement(name=IQuestionResult.AGE_GROUP_45_99)
	public long getAgeGroup_45_99() {
		return ageGroup_45_99;
	}
	
	public void setAgeGroup_45_99(long ageGroup_45_99) {
		this.ageGroup_45_99 = ageGroup_45_99;
	}

}
