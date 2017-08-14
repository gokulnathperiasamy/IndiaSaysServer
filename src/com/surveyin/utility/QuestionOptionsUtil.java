package com.surveyin.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.surveyin.application.ApplicationConstant;
import com.surveyin.entity.IQuestionOptions;
import com.surveyin.entity.QuestionOptions;

public final class QuestionOptionsUtil {

	public static List<QuestionOptions> getQuestionOptions() {
		QuestionOptions questionOptions;
		List<QuestionOptions> questionOptionsList = new ArrayList<>();
		JSONParser parser = new JSONParser();
		long timeStamp = 0l;
		try {
			String catalinaBase = System.getProperty(ApplicationConstant.CATALINA_HOME);
			Object obj = parser.parse(new FileReader(new File(catalinaBase, ApplicationConstant.QUESTIONS_JSON_PATH)));

			if (obj != null && obj instanceof JSONArray) {
				JSONArray arrayQuestionOptions = (JSONArray) obj;
				JSONObject objQuestionOptions;

				for (int index = 0; index < arrayQuestionOptions.size(); index++) {
					timeStamp = TimeUtil.getCurrentTimeInLong();
					questionOptions = new QuestionOptions();
					objQuestionOptions = (JSONObject) arrayQuestionOptions.get(index);
					questionOptions.setQuestion((String) objQuestionOptions.get(IQuestionOptions.QUESTION));
					questionOptions.setOptionA((String) objQuestionOptions.get(IQuestionOptions.OPTION_A));
					questionOptions.setOptionB((String) objQuestionOptions.get(IQuestionOptions.OPTION_B));
					questionOptions.setOptionC((String) objQuestionOptions.get(IQuestionOptions.OPTION_C));
					questionOptions.setOptionD((String) objQuestionOptions.get(IQuestionOptions.OPTION_D));
					questionOptions.setIsValid(true);
					questionOptions.setIsAgeRestricted((boolean) objQuestionOptions.get(IQuestionOptions.IS_AGE_RESTRICTED));
					questionOptions.setDateCreated(timeStamp);
					questionOptions.setRowUpdated(timeStamp);
					questionOptionsList.add(questionOptions);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return questionOptionsList;
	}
}
