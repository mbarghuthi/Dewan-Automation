package com.automation.pages;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage<T> {

	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	WebDriverProvider webDriverProvider;

	private static WebDriverWait wait;

	private static final int TIMER = 30;

	protected WebElement getElementWithWait(T obj, String elementName) throws Exception {
		elementName = elementName.replaceAll(" ", "").trim();
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(elementName)) {

				waitForLoad(webDriverProvider.get());

				try {
					field.setAccessible(true);

					WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(30));
					WebElement rawElement = (WebElement) field.get(this);
					WebElement element = wait.until(ExpectedConditions.visibilityOf(rawElement));

					waitForLoad(webDriverProvider.get());

					return element;

				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new Exception("Failed to access element: " + elementName, e);
				}
			}
		}

		throw new Exception(elementName + " Element Not Found");
	}

	protected WebElement getElement(T obj, String elementName) throws Exception {
		elementName = elementName.replaceAll(" ", "").trim();

		waitForLoad(webDriverProvider.get());

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(elementName)) {
				waitForLoad(webDriverProvider.get());

				try {
					field.setAccessible(true);
					return (WebElement) field.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new Exception("Failed to access element: " + elementName, e);
				}
			}
		}

		throw new Exception(elementName + " Not Found");
	}

	@SuppressWarnings("unchecked")
	protected WebElement getVisibleElementFromList(T obj, String listElementName) throws Exception {
		waitForLoad(webDriverProvider.get());
		Thread.sleep(500);

		listElementName = listElementName.replaceAll(" ", "").trim();
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(listElementName)) {
				waitForLoad(webDriverProvider.get());

				try {
					field.setAccessible(true);
					List<WebElement> list = (List<WebElement>) field.get(this);

					for (WebElement element : list) {
						if (element.isDisplayed()) {
							return element;
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new Exception("Failed to access list element: " + listElementName, e);
				}
			}
		}

		throw new Exception(listElementName + " Not Found");
	}

	@SuppressWarnings("unchecked")
	protected boolean checkVisibleElementFromList(T obj, String listElementName) throws Exception {
		waitForLoad(webDriverProvider.get());
		Thread.sleep(500);

		listElementName = listElementName.replaceAll(" ", "").trim();
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(listElementName)) {
				waitForLoad(webDriverProvider.get());

				try {
					field.setAccessible(true);
					List<WebElement> list = (List<WebElement>) field.get(this);

					for (WebElement element : list) {
						if (element.isDisplayed()) {
							return true;
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new Exception("Failed to access list element: " + listElementName, e);
				}
			}
		}

		return false;
	}

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(pageLoadCondition);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"indeterminate\"]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id=\"nprogress\"]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"nprogress-busy\"]")));
	}

	private WebDriverWait wait(WebDriverProvider driverProvider) {
		if (wait == null) {
			wait = new WebDriverWait(driverProvider.get(), Duration.ofSeconds(TIMER));
		}
		return wait;
	}

	private void waitUntil(WebElement element) {
		wait(webDriverProvider).until(ExpectedConditions.visibilityOf(element));
	}

	public void selectByVisibleText(WebElement element, String text) {
		waitUntil(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public String getFirstSelectedValue(WebElement element) {
		waitUntil(element);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public List<String> getAllDropDownOptions(WebElement element) {
		waitUntil(element);
		Select select = new Select(element);
		List<String> stringList = new LinkedList<>();
		for (WebElement webElement : select.getOptions()) {
			stringList.add(webElement.getText().trim());
		}
		return stringList;
	}
}