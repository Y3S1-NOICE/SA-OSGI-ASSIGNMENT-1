package com.questionbank.consumer;

import java.util.Scanner;

import com.questionbank.service.IQuestionBankService;

public class Menu{

	private Scanner sc;
	private IQuestionBankService questionBankService;
	
	public Menu(IQuestionBankService questionBankService) {
		this.sc = new Scanner(System.in);
		this.questionBankService = questionBankService;
	}
	
	public void startMenuTemplate() {
		switch (showMainMenu()) {
			case Utils.SERVICE_PRACTICETEST: 
				PracticeTest practiceTest = new PracticeTest(questionBankService, this);
				practiceTest.startTepmlate();
				break;
			case Utils.SERVICE_SHORTNOTES: 
				System.out.println("not implemented yet");
				startMenuTemplate();
				break;
			default:
				startMenuTemplate();
		}
	}
	
	public int showMainMenu() {
		System.out.println("\n*****WELCOME TO STUDY APPLICATION*****");
		System.out.println("");
		System.out.println("Choose which service tou want from the below");
		System.out.println("\t1. Shortnotes");
		System.out.println("\t2. Practice Test");
		
		return Helper.takeInput(2, sc);
	}
	
	public int showPracticeTestMenu() {
		System.out.println("\n*****PRACTICE TEST*****");
		System.out.println("");
		System.out.println("\t1. Add questions to the question bank");
		System.out.println("\t2. Delete a question from the question bank");
		System.out.println("\t3. Take a practice test");
		System.out.println("\t4. Back");
		
		return Helper.takeInput(4, sc);
	}
}
