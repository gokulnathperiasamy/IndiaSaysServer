package com.kpgn.indiasaysserver.utility;

import java.util.Date;

import com.kpgn.indiasaysserver.entity.QuestionOptions;

public final class QuestionOptionsUtil {
	
	public static QuestionOptions getQuestionOptions() {
		QuestionOptions questionOptions = new QuestionOptions();
		questionOptions.setQuestion("Question " + TextUtil.getRandomInt(1000000, 9999999));
		questionOptions.setOptionA("A " + TextUtil.getRandomInt(100, 199));
		questionOptions.setOptionB("B " + TextUtil.getRandomInt(200, 299));
		questionOptions.setIsValid(true);
		questionOptions.setIsAgeRestricted(false);
		int rand = TextUtil.getRandomInt(1000, 9999);
		if (rand % 2 == 0) {
			questionOptions.setOptionC("C " + TextUtil.getRandomInt(300, 399));
			questionOptions.setOptionD("");
			questionOptions.setIsAgeRestricted(true);
		} else if (rand %3 == 0) {
			questionOptions.setOptionC("C " + TextUtil.getRandomInt(300, 399));
			questionOptions.setOptionD("D " + TextUtil.getRandomInt(400, 499));
		} else {
			questionOptions.setOptionC("");
			questionOptions.setOptionD("");
		}
		questionOptions.setDateCreated(new Date().getTime());
		questionOptions.setRowUpdated(new Date().getTime());
		return questionOptions;
	}

}
