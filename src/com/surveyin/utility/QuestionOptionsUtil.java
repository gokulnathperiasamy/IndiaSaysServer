package com.surveyin.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.surveyin.application.ApplicationConstant;
import com.surveyin.entity.QuestionOptions;


public final class QuestionOptionsUtil {
	
	public static List<QuestionOptions> getQuestionOptions() {
		QuestionOptions questionOptions;
		List<QuestionOptions> questionOptionsList = new ArrayList<>();
		JSONParser parser = new JSONParser();
		try {	
			String catalinaBase = System.getProperty("catalina.home");	//CATALINA_HOME	
			Object obj = parser.parse(new FileReader(new File(catalinaBase,ApplicationConstant.SURVEYIN_QUESTIONSJSON_PATH)));
			JSONArray arrayQuestionOptions = (JSONArray) obj;
			JSONObject objQuestionOptions;

			for (int index = 0; index < arrayQuestionOptions.size(); index++) {
				questionOptions = new QuestionOptions();
				objQuestionOptions = (JSONObject) arrayQuestionOptions.get(index);
				questionOptions.setQuestion((String) objQuestionOptions.get("question"));
				questionOptions.setOptionA((String) objQuestionOptions.get("optionA"));
				questionOptions.setOptionB((String) objQuestionOptions.get("optionB"));
				questionOptions.setOptionC((String) objQuestionOptions.get("optionC"));
				questionOptions.setOptionD((String) objQuestionOptions.get("optionD"));
				questionOptions.setIsValid(true);
				questionOptions.setIsAgeRestricted((boolean) objQuestionOptions.get("isAgeRestricted"));
				questionOptions.setDateCreated(new Date().getTime());
				questionOptions.setRowUpdated(new Date().getTime());
				questionOptionsList.add(questionOptions);
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
