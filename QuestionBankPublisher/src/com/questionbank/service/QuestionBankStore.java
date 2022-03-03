package com.questionbank.service;

import java.util.HashMap;

public class QuestionBankStore {
	private HashMap<Integer, Question> historyQuestions;
	private HashMap<Integer, Question> ictQuestions;
	private HashMap<Integer, Question> englishQuestions;
	
	public QuestionBankStore() {
		historyQuestions = new HashMap<>();
		ictQuestions = new HashMap<>();
		englishQuestions = new HashMap<>();
	}
	
	public HashMap<Integer, Question> getQuestionsListByType(String type) {
		if (type.equalsIgnoreCase("english")) {
			return englishQuestions;
		} else if (type.equalsIgnoreCase("ict")){
			return ictQuestions;
		} else if (type.equalsIgnoreCase("history")) {
			return historyQuestions;
		}
		return null;
	}
}
