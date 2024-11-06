package com.automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.pages.CustomPage;
import com.automation.pages.CannedPage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
@Component
public class CustomSteps extends AbstractSteps {

	@Autowired
	private CustomPage customPage;

	@Autowired
	private CannedPage cannedPage;

	// Step to get and save element text
	@Given("[Action] I get text from '$elementName' and save it as '$variableName'")
	@When("[Action] I get text from '$elementName' and save it as '$variableName'")
	@Then("[Action] I get text from '$elementName' and save it as '$variableName'")
	public void getElementTextAndSave(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String text = cannedPage.getElementWithWaitText(elementName);
		// Debug log
		System.out.println("Fetched text from " + elementName + ": " + text);
		stateManager.put(variableName, text);
		// Debug log
		System.out.println(variableName + " saved as: " + text);
	}

	// Step to get and save element value
	@Given("[Action] I get value from '$elementName' and save it as '$variableName'")
	@When("[Action] I get value from '$elementName' and save it as '$variableName'")
	@Then("[Action] I get value from '$elementName' and save it as '$variableName'")
	public void getElementValueAndSave(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String value = cannedPage.getElementAttribute(elementName, "value");
		// Debug log
		System.out.println("Fetched value from " + elementName + ": " + value);
		stateManager.put(variableName, value);
		// Debug log
		System.out.println(variableName + " saved as: " + value);
	}

	// Step to assert saved text value
	@Given("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	@When("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	public void assertElementTextEqualsSavedValue(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementWithWaitText(elementName);

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}
	@Given("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName'")
	@When("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName''")
	public void assertElementTextEqualsSavedValueOrZero(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementWithWaitText(elementName);

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		// Check if actual text is "0"
		if ("0".equals(expectedValue)) {
			// Locate the element with the text 'لا يوجد بيانات لإظهارها'
			boolean elementExists = cannedPage.isElementPresent("//div[contains(text(),'لا يوجد بيانات لإظهارها')]");

			if (elementExists) {
				System.out.println("Element indicating no data is present. Assertion passed.");
				return; // Exit the method as the assertion is true
			} else {
				throw new Exception("Assertion failed: expected '0', but no element indicating no data was found.");
			}
		}

		// Perform usual assertion if the text is not "0"
		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}




	@Given("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	@When("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	@Then("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	public void assertElementValueEqualsSavedValue(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementAttribute(elementName, "value");

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}

	@Given("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName'")
	@When("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName'")
	@Then("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName")
	public void assertElementValueEqualsSavedValueOrZero(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementAttribute(elementName, "value");

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		// Check if actual value is zero
		if ("0".equals(expectedValue)) {
			// Locate the element with the text 'لا يوجد بيانات لإظهارها'
			boolean elementExists = cannedPage.isElementPresent("//div[contains(text(),'لا يوجد بيانات لإظهارها')]");

			if (elementExists) {
				System.out.println("Element indicating no data is present. Assertion passed.");
				return; // Exit the method as the assertion is true
			} else {
				throw new Exception("Assertion failed: expected '0', but no element indicating no data was found.");
			}
		}

		// Perform usual assertion if the value is not zero
		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}

	// Step to verify uniqueness of values in column "رقم التعميم"
	@Given("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	@When("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	@Then("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	public void verifyUniqueValuesInColumn(@Named("variableName") String variableName) throws Exception {
		Object rowCountObj = stateManager.get(variableName); // Fetch as Object

		if (rowCountObj == null) {
			throw new Exception("Value for '" + variableName + "' not found in stateManager.");
		}

		String rowCountStr = String.valueOf(rowCountObj); // Convert Object to String

		int rowCount = Integer.parseInt(rowCountStr); // Convert to integer if needed

		// Fetch the values from the xpaths
		List<String> values = cannedPage.getValuesFromXpaths(rowCount);

		// Verify the values are unique
		Set<String> uniqueValues = new HashSet<>(values);
		if (uniqueValues.size() != values.size()) {
			throw new Exception("Assertion failed: Values in column 'رقم التعميم' are not unique.");
		}
	}

	// to check the unwatched generalizations



	// Step to assert that GeneralizationYearValue equals CurrentYear
	@Given("[Assertion] Verify '$yearValue' equals current year")
	@When("[Assertion] Verify '$yearValue' equals current year")
	@Then("[Assertion] Verify '$yearValue' equals current year")
	public void assertGeneralizationYearEqualsCurrentYear(@Named("yearValue") String yearValue) throws Exception {
		String generalizationYear = (String) stateManager.get(yearValue);
		// Get the current year as a string
		String currentYear = String.valueOf(LocalDate.now().getYear());

		// Compare the generalization year with the current year
		if (!generalizationYear.equals(currentYear)) {
			throw new Exception("Assertion failed: GeneralizationYearValue (" + generalizationYear +
					") is not equal to current year (" + currentYear + ")");
		}
		System.out.println("Assertion passed: GeneralizationYearValue equals current year");
	}


	@Given("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	@When("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	public void assertElementTextContainsSavedValue(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementWithWaitText(elementName);

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		// Extract the relevant part if needed
		String relevantPart = expectedValue.split("\\|")[1].trim();  // Extract after '|'

		if (!actualValue.contains(relevantPart)) {
			throw new Exception("Assertion failed: expected value to be contained in actual value. Expected part '" + relevantPart + "', but actual value was '" + actualValue + "'");
		}
	}


	@Given("[Input] I login admin as '$userName' with password '$password'")
	@When("[Input] I login admin as '$userName' with password '$password'")
	@Then("[Input] I login admin as '$userName' with password '$password'")
	public void loginAdminAs(@Named("adminUserName") String userName, @Named("adminPassword") String password) throws Throwable {
		customPage.enterText("adminUserName", userName).enterText("adminPassword", password).click("loginAdminButton");
	}

	//step to assert checkbox is unchecked
	@Given("[Assertion] Verify Radio  '$elementName' is clicked on")
	@When("[Assertion] Verify Radio  '$elementName' is clicked on")
	@Then("[Assertion] Verify Radio  '$elementName' is clicked on")
	public void is_radio_button_unchecked(String elementName) throws Exception
	{
		customPage.checkRadioButton(elementName, true);
	}


	@Autowired
	private WebDriverProvider webDriverProvider;

	@Given("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	@When("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	@Then("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	public void is_checkbox_checked(String elementName) throws Exception {
		customPage.checkCheckboxButton(elementName, true);

		// Access the WebDriver instance
//		WebDriver driver = webDriverProvider.get();
//		String originalWindow = driver.getWindowHandle();
//
//		// Wait for a new tab to open
//		Set<String> allWindows = driver.getWindowHandles();
//		if (allWindows.size() > 1) {
//			for (String windowHandle : allWindows) {
//				if (!windowHandle.equals(originalWindow)) {
//					driver.switchTo().window(windowHandle);
//					break;
//				}
//			}
//
//			// Continue with further actions on the new tab
//			WebElement newTabElement = driver.findElement(By.id("elementIdOnNewTab"));
//			newTabElement.click();
//
//			// Optionally, switch back to the original tab if needed
//			driver.switchTo().window(originalWindow);
//		}
	}

	@Given("[Input] I hover and click on '$elementName'")
	@When("[Input] I hover and click on '$elementName'")
	@Then("[Input] I hover and click on '$elementName'")
	public void elementToHover(String elementName) throws Exception {
		customPage.elementToHover(elementName);
	}

	@Given("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	@When("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	@Then("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	public void verifyRowsOfUnseenBooks(@Named("variableName") String variableName) throws Exception {
		// Fetch the row count from the state manager
		Object rowCountObj = stateManager.get(variableName); // Fetch as Object

		if (rowCountObj == null) {
			throw new Exception("Value for '" + variableName + "' not found in stateManager.");
		}

		// Convert the fetched row count to an integer
		int rowCount = Integer.parseInt(rowCountObj.toString().trim()); // Convert to integer

		// Fetch the count of rows without the specified image
		int countWithoutImage = customPage.countRowsWithoutImage(rowCount);

		// Fetch the expected value using the variable name provided in the steps
		Object expectedValueObj = stateManager.get(variableName); // Use the variable name dynamically

		if (expectedValueObj == null) {
			throw new Exception("Expected value not found in stateManager for variable: " + variableName);
		}

		// Convert the expected value to an integer
		int expectedValue = Integer.parseInt(expectedValueObj.toString().trim()); // Convert to integer

		// Assert that the actual count equals the expected value
		if (countWithoutImage != expectedValue) {
			throw new Exception("Assertion failed: Count of rows without the image (" + countWithoutImage + ") does not equal expected value (" + expectedValue + ").");
		} else {
			System.out.println("Assertion passed: Count of rows without the image matches the expected value: " + expectedValue);
		}
	}





}