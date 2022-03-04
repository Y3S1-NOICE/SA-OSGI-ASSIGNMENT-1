package com.questionbank.consumer;

import com.questionbank.service.IQuestionBankService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("subcriber started!");
		serviceReference = context.getServiceReference(IQuestionBankService.class.getName());
		IQuestionBankService questionBankService = (IQuestionBankService)context.getService(serviceReference);
		
		Menu menu = new Menu(questionBankService);
		menu.startMenuTemplate();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("subscriber is stopped!");
		context.ungetService(serviceReference);
	}

}
