package com.automation.steps.lifecycle;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.configuration.pageobjects.PageObjectBeanPostProcessor;

@Component
public class ExecutionLifecycle {

	@Autowired
	private PageObjectBeanPostProcessor pageObjectPostProcessor;

	@Autowired
	private WebDriverProvider driverProvider;

	@BeforeStory
	public void beforeStory() throws Exception {

		driverProvider.initialize();

		for (Object page : pageObjectPostProcessor.getPageObjects()) {
			PageFactory.initElements(driverProvider.get(), page);
		}
	}

	@AfterScenario
	public void afterScenario() throws Exception {
		driverProvider.get().manage().deleteAllCookies();
	}

	@AfterStory
	public void afterStory() throws Exception {
		driverProvider.end();
	}

}