package com.automation.jbehave;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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

	/**
	 * Global failure flag for the whole JBehave run.
	 * If any step/story fails, this becomes true.
	 */
	private static final AtomicBoolean HAS_FAILURES = new AtomicBoolean(false);

	private ThreadLocal<Boolean> runningStoryStatus = new ThreadLocal<>();
	private ThreadLocal<Story> storyThreadLocal = new ThreadLocal<>();
	private WebDriver driver;
	private final WebDriverProvider webDriverProvider;

	public ConsoleLogger(WebDriverProvider webDriverProvider) {
		Locale.setDefault(Locale.ENGLISH);
		this.webDriverProvider = webDriverProvider;
	}

	/**
	 * Reset failure flag before starting a fresh test run.
	 */
	public static void resetFailures() {
		HAS_FAILURES.set(false);
	}

	/**
	 * Read failure flag after the run finishes.
	 */
	public static boolean hasFailures() {
		return HAS_FAILURES.get();
	}

	public void storyNotAllowed(Story story, String filter) {
		log.info(String.format("%s (NOT ALLOWED [filter: %s])", story, filter));
		// Treat "not allowed" as not a failure for build result.
	}

	public void storyCancelled(Story story, StoryDuration storyDuration) {
		log.info(String.format("%s (CANCELLED [duration: %s])", story, storyDuration));
		HAS_FAILURES.set(true);
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
		if (story != null && story.getName() != null
				&& !story.getName().equals("BeforeStories")
				&& !story.getName().equals("AfterStories")) {
			this.reportAfterStory(story);
		}
	}

	private void reportAfterStory(Story story) {
		boolean storyPassed = Boolean.TRUE.equals(this.runningStoryStatus.get());
		String status = storyPassed ? " PASSED " : " FAILED ";

		if (!storyPassed) {
			HAS_FAILURES.set(true);
		}

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
		extentTest = extent.startTest(scenarioName, scenarioKey);
		test.set(extentTest);
		extent.flush();

		log.info("==========================================================");
		log.info("Scenario: " + scenarioKey);
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
		extent.flush();

		log.info(String.format("%s (SUCCESSFUL)", step));
	}

	public void ignorable(String step) {
		log.info(String.format("%s (IGNORED)", step));
	}

	public void pending(String step) {
		test.get().log(LogStatus.ERROR, PropertyConverter.convert(step));
		extent.flush();

		HAS_FAILURES.set(true);
		this.runningStoryStatus.set(false);

		log.info(String.format("%s (PENDING)", step));
	}

	public void notPerformed(String step) {
		test.get().log(LogStatus.SKIP, PropertyConverter.convert(step));
		extent.flush();

		log.info(String.format("%s (NOT PERFORMED)", step));
	}

	public void failed(String step, Throwable cause) {
		test.get().log(LogStatus.FAIL, PropertyConverter.convert(step));

		// Log the cause message if available
		if (cause != null && cause.getCause() != null) {
			test.get().log(LogStatus.INFO, cause.getCause().getMessage());
			log.error(cause.getCause());
		} else if (cause != null) {
			test.get().log(LogStatus.INFO, cause.getMessage() != null ? cause.getMessage() : "Unknown error occurred");
			log.error(cause);
		} else {
			test.get().log(LogStatus.INFO, "Unknown error occurred");
			log.error("Unknown error occurred");
		}

		// Capture and log screenshot if possible
		String screenshotBase64 = captureScreenshot();
		if (screenshotBase64 != null && !screenshotBase64.isEmpty()) {
			test.get().log(LogStatus.INFO, "Screenshot of the failure",
					"<img src='data:image/png;base64," + screenshotBase64 + "' />");
		}

		extent.flush();

		HAS_FAILURES.set(true);
		this.runningStoryStatus.set(false);

		log.info(String.format("%s (FAILED)", step));
	}

	public void failedOutcomes(String step, OutcomesTable table) {
		HAS_FAILURES.set(true);
		this.runningStoryStatus.set(false);
	}

	public void restarted(String step, Throwable cause) {
	}

	@Override
	public void restartedStory(Story story, Throwable throwable) {
		HAS_FAILURES.set(true);
	}

	public void dryRun() {
	}

	public void pendingMethods(List<String> methods) {
		HAS_FAILURES.set(true);
	}

	public String captureScreenshot() {
		driver = webDriverProvider.get();
		if (driver == null) {
			log.error("WebDriver instance is null. Cannot capture screenshot.");
			return null;
		}

		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
			log.info("Screenshot saved successfully");
			return base64Code;
		} catch (WebDriverException e) {
			log.error("Failed to capture screenshot: " + e.getMessage());
			return null;
		}
	}
}