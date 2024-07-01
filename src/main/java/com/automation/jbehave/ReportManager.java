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

	private static String reportName = "Automation-Report.html";
	private static String reportFolderName;
	private static String Path;
	private static String reportFilePath;

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH-mm-ss z yyyy");
		reportFolderName = dateFormat.format(new Date());
		Path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportFolderName + File.separator;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String reportFileLocation = getReportFileLocation(platform) + reportName;
		extent = new ExtentReports(reportFileLocation);
		extent.loadConfig(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "report-config.xml"));
		return extent;
	}

	// Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		reportFilePath = Path;
		switch (platform) {
			case MAC:
			case WINDOWS:
				createReportPath(reportFilePath);
				System.out.println("Report Path: " + reportFilePath + "\n");
				break;
			default:
				System.out.println("ExtentReport path has not been set! There is a problem!\n");
				break;
		}
		return reportFilePath;
	}

	// Create the report path if it does not exist
	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdirs()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	// Get current platform
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

		String destination = Path + "Screenshots" + File.separator + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
