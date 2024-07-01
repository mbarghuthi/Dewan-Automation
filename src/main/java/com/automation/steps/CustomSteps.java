package com.automation.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.pages.CustomPage;

@Component
public class CustomSteps extends AbstractSteps {

	@Autowired
	private CustomPage customPage;

	
	
	

}