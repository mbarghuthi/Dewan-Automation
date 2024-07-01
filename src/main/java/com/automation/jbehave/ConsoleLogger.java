package com.automation.jbehave;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;
import org.springframework.stereotype.Component;

import com.automation.jbehave.format.PropertyConverter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Component
public class ConsoleLogger implements StoryReporter {

	// Report Declarations
	private static ExtentReports extent = ReportManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ExtentTest extentTest;

	private static final Logger log = Logger.getLogger(ConsoleLogger.class);
	private ThreadLocal<Boolean> runningStoryStatus = new ThreadLocal<>();
	private ThreadLocal<Story> storyThreadLocal = new ThreadLocal<>();

	public ConsoleLogger() {
	}

	public void storyNotAllowed(Story story, String filter) {
		log.info(String.format("%s (NOT ALLOWED [filter: %s])", story, filter));
	}

	public void storyCancelled(Story story, StoryDuration storyDuration) {
		log.info(String.format("%s (CANCELLED [duration: %s])", story, storyDuration));
	}

	public void beforeStory(Story story, boolean givenStory) {
		this.storyThreadLocal.set(story);
		if (!story.getName().equals("BeforeStories") && !story.getName().equals("AfterStories")) {
			this.runningStoryStatus.set(true);
			this.reportBeforeStory(story);
		}
	}

	private void reportBeforeStory(Story story) {
		log.info("==========================================================");
		log.info("Begin Story: " + story.getName());
		log.info("==========================================================");
	}

	public void afterStory(boolean givenStory) {
		Story story = this.storyThreadLocal.get();
		if (story.getName() != null && !story.getName().equals("BeforeStories")
				&& !story.getName().equals("AfterStories")) {
			this.reportAfterStory(this.storyThreadLocal.get());
		}
	}

	private void reportAfterStory(Story story) {
		String status = this.runningStoryStatus.get() ? " PASSED " : " FAILED ";
		log.info("==========================================================");
		log.info("End Story:  " + story.getName());
		log.info("Status: " + status);
		log.info("==========================================================");
	}

	public void narrative(Narrative narrative) {
		log.info(narrative.toString());
	}

	public void lifecyle(Lifecycle lifecycle) {
		log.info(lifecycle.toString());
	}

	public void scenarioNotAllowed(Scenario scenario, String filter) {
		log.info(String.format("%s (NOT ALLOWED [filter: %s])", scenario, filter));
	}

	public void beforeScenario(String scenarioTitle) {

		String scenarioKey = scenarioTitle.substring(0, scenarioTitle.indexOf(" ")).trim();
		String scenarioName = scenarioTitle.substring(scenarioTitle.indexOf(" ")).trim();
		extentTest = extent.startTest(scenarioKey, scenarioName);
		test.set(extentTest);
		extent.flush();

		log.info("==========================================================");
		log.info("Scenario: " + scenarioTitle);
		log.info("==========================================================");
	}

	public void scenarioMeta(Meta meta) {
		log.info(meta.toString());
	}

	public void afterScenario() {
		extent.endTest(extentTest);
		extent.flush();
	}

	public void givenStories(GivenStories givenStories) {
	}

	public void givenStories(List<String> storyPaths) {
	}

	public void beforeExamples(List<String> steps, ExamplesTable table) {
	}

	public void example(Map<String, String> tableRow) {

	}

	public void afterExamples() {
	}

	public void beforeStep(String step) {
	}

	public void successful(String step) {
		test.get().log(LogStatus.PASS, PropertyConverter.convert(step));
	//	test.get().log(LogStatus.INFO, extentTest.addScreenCapture(""));
		extent.flush();

		log.info(String.format("%s (SUCCESSFUL)", step));
	}

	public void ignorable(String step) {
		log.info(String.format("%s (IGNORED)", step));
	}

	public void pending(String step) {
		test.get().log(LogStatus.ERROR, PropertyConverter.convert(step));

		log.info(String.format("%s (PENDING)", step));
	}

	public void notPerformed(String step) {
		test.get().log(LogStatus.SKIP, PropertyConverter.convert(step));

		log.info(String.format("%s (NOT PERFORMED)", step));
	}

	public void failed(String step, Throwable cause) {
		test.get().log(LogStatus.FAIL, PropertyConverter.convert(step));
		//test.get().log(LogStatus.INFO, extentTest.addScreenCapture(""));
		test.get().log(LogStatus.INFO, cause.getCause().getMessage());

		// Add screenshot code


		extent.flush();

		this.runningStoryStatus.set(false);
		log.info(String.format("%s (FAILED)", step));
		log.error(cause.getCause());
	}

	public void failedOutcomes(String step, OutcomesTable table) {
	}

	public void restarted(String step, Throwable cause) {
	}

	@Override
	public void restartedStory(Story story, Throwable throwable) {
	}

	public void dryRun() {
	}

	public void pendingMethods(List<String> methods) {
	}
}