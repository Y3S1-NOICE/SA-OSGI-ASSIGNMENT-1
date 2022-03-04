package com.questionbank.service;

import java.util.HashMap;

public class QuestionBankServiceImpl implements IQuestionBankService{
	
	private QuestionBankStore store;
	
	public QuestionBankServiceImpl() {
		store = new QuestionBankStore();
	}
	
	@Override
	public HashMap<Integer, Question> getQuestionsFromType(String type) {
		return store.getQuestionsListByType(type);
	}

	@Override
	public Question getQuestionByTypeAndId(String type, int id) {
		HashMap<Integer, Question> questions = store.getQuestionsListByType(type); 
		return questions.get(id);
	}

	@Override
	public void addQuestions(String question, String answer, String type) {
		HashMap<Integer, Question> questions = store.getQuestionsListByType(type); 
		questions.put(questions.size() + 1, new Question(question, answer, type));
	}

	@Override
	public void deleteQuestionByTypeAndId(String type, int id) {
		HashMap<Integer, Question> questions = store.getQuestionsListByType(type); 
		questions.remove(id);
		for (int qid = id; questions.containsKey(qid + 1); qid++) {
			questions.put(qid,questions.get(qid + 1));
		}
		questions.remove(questions.size());

	}

	@Override
	public void test() {
		System.out.println("test service");
		
	}

}
