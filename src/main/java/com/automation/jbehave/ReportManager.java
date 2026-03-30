package com.automation.jbehave;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {
	private static ExtentReports extent;
	private static Platform platform;

	private static final String reportName = "Dewan-Automation-Report.html";
	private static final String reportFolderName;
	private static final String path;
	private static String reportFilePath;

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH-mm-ss z yyyy");
		reportFolderName = dateFormat.format(new Date());
		path = resolveReportBaseDirectory() + File.separator + reportFolderName + File.separator;
	}

	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String reportFileLocation = getReportFileLocation(platform) + reportName;

		extent = new ExtentReports(reportFileLocation);
		extent.loadConfig(new File(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "resources"
						+ File.separator + "report-config.xml"
		));

		return extent;
	}

	private static String resolveReportBaseDirectory() {
		String reportDirectoryProperty = System.getProperty("reportDirectory");
		if (isNotBlank(reportDirectoryProperty)) {
			return reportDirectoryProperty;
		}

		String workspace = System.getenv("WORKSPACE");
		if (isNotBlank(workspace)) {
			return workspace + File.separator + "reports";
		}

		return System.getProperty("user.dir") + File.separator + "reports";
	}

	private static boolean isNotBlank(String value) {
		return value != null && !value.trim().isEmpty();
	}

	private static String getReportFileLocation(Platform platform) {
		reportFilePath = path;

		switch (platform) {
			case MAC:
			case WINDOWS:
			case LINUX:
				createReportPath(reportFilePath);
				System.out.println("Report Path: " + reportFilePath + "\n");
				break;
			default:
				System.out.println("ExtentReport path has not been set! There is a problem!\n");
				break;
		}

		return reportFilePath;
	}

	private static void createReportPath(String reportPath) {
		File testDirectory = new File(reportPath);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdirs()) {
				System.out.println("Directory: " + reportPath + " is created!");
			} else {
				System.out.println("Failed to create directory: " + reportPath);
			}
		} else {
			System.out.println("Directory already exists: " + reportPath);
		}
	}

	private static Platform getCurrentPlatform() {
		if (platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();

			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}

		return platform;
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String screenshotDirectory = path + "Screenshots" + File.separator;
		createReportPath(screenshotDirectory);

		String destination = screenshotDirectory + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}
}