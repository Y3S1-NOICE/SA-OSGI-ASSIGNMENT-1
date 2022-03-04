package com.questionbank.consumer;

import java.util.HashMap;
import java.util.Scanner;

import com.questionbank.service.IQuestionBankService;
import com.questionbank.service.Question;

public class PracticeTest {
	
	private IQuestionBankService questionBankService;
	private Scanner sc;
	private Menu menu;
	
	public PracticeTest(IQuestionBankService questionBankService, Menu menu) {
		this.sc = new Scanner(System.in);
		this.menu = menu;
		this.questionBankService = questionBankService;
	}
	
	public void startTepmlate() {
		switch(menu.showPracticeTestMenu()) {
			case Utils.PRACTICETEST_ADD_QUESTION: 
				addQuestion();
				break;
			case Utils.PRACTICETEST_TAKE_TEST:
				takePracticeTest();
				break;
			case Utils.PRACTICETEST_DELETE_QUESTION:
				deleteQuestion();
				break;
			case Utils.PRACTICETEST_BACK:
				menu.startMenuTemplate();
				break;
			default:
				startTepmlate();
			}
	}
	
	public void addQuestion() {
		String type = chooseType();
		
		while(true) {
			System.out.println("\nEnter the question: ");
			String question = sc.next();
			
			System.out.println("Enter the answer for the question: ");
			String answer = sc.next();
			
			questionBankService.addQuestions(question, answer, type);
			
			System.out.println("\nQuestion added successfully!");
			System.out.println("Add another question(y/n)? :");
			
			if(sc.next().equalsIgnoreCase("n")) {
				break;
			} 
		}
		startTepmlate();
	}
	
	public void takePracticeTest() {
		
		HashMap<Integer, Question> questions = questionBankService.getQuestionsFromType(chooseType());
		Question questionObj;
		String givenAnswer;
		for(int i = 1; questions.size() >= i; i++) {
			questionObj = questions.get(i);
			
			System.out.println("1. " + questionObj.getQuestion() + "?");
			System.out.println("answer: ");
			givenAnswer = sc.next();
			
			if (questionObj.getAnswer().equalsIgnoreCase(givenAnswer)) {
				System.out.println("You are correct!");
			} else {
				System.out.println("Wrong! the correct answer is: " + questionObj.getAnswer());
			}
		}
		
		System.out.println("Practice test is finished!\n");
		startTepmlate();
	}
	
	public void deleteQuestion() {
		String type = chooseType();
		
		HashMap<Integer, Question> questions = questionBankService.getQuestionsFromType(type);
		Question questionObj;
		
		for(int i = 1; questions.size() >= i; i++) {
			questionObj = questions.get(i);
			System.out.println(i + ". " + questionObj.getQuestion() + "?");
			System.out.println(" answer -> " +  questionObj.getAnswer());			
		}
		
		while(true) {
			System.out.println("Enter the question number to delete :");
			int qid = sc.nextInt();
			questionBankService.deleteQuestionByTypeAndId(type, qid);
			
			System.out.println("\nQuestion " + qid + " deleted successfully!");
			
			for(int i = 1; questions.size() >= i; i++) {
				questionObj = questions.get(i);
				System.out.println(i + ". " + questionObj.getQuestion() + "?");
				System.out.println(" answer -> " +  questionObj.getAnswer());			
			}
			
			System.out.println("Delete another question(y/n)? :");
			
			if(sc.next().equalsIgnoreCase("n")) {
				break;
			} 
		}
		startTepmlate();
	}
	
	
	public String chooseType() {
		System.out.println("\nChoose a subject");
		System.out.println("\t1. History");
		System.out.println("\t2. ICT");
		System.out.println("\t3. English");
		int typeNo = Helper.takeInput(3, sc);
		String type;
		
		switch (typeNo) {
		case 1: 
			type = "History";
			break;
		case 2: 
			type = "ICT";
			break;
		case 3: 
			type = "English";
			break;
		default:
			type = "History";
		}
		return type;
	}
	
}
