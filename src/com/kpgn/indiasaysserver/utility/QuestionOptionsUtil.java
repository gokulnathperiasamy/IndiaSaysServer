package com.kpgn.indiasaysserver.utility;

import java.util.Date;

import com.kpgn.indiasaysserver.entity.QuestionOptions;

public final class QuestionOptionsUtil {
	
	public static QuestionOptions getQuestionOptions() {
		QuestionOptions questionOptions = new QuestionOptions();
		questionOptions.setQuestion("Q1" + TextUtil.getRandomDouble(1000000, 9999999));
		questionOptions.setOptionA("A1");
		questionOptions.setOptionB("B1");
		questionOptions.setIsValid(true);
		questionOptions.setIsAgeRestricted(false);
		questionOptions.setDateCreated(new Date().getTime());
		questionOptions.setRowUpdated(new Date().getTime());
		return questionOptions;
	}

}
