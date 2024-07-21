package com.automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.pages.CustomPage;
import com.automation.pages.CannedPage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	

}