package com.questionbank.service;

import java.util.HashMap;

public interface IQuestionBankService {
	public void test();
	public void addQuestions(String question, String answer, String type);
	public void deleteQuestionByTypeAndId(String type, int id);
	public HashMap<Integer, Question> getQuestionsFromType(String type);
	public Question getQuestionByTypeAndId(String type, int id);
}
