package com.automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.pages.CannedPage;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class CannedSteps extends AbstractSteps {

	@Autowired
	private CannedPage cannedPage;

	// Step to navigate to specified URL
	@Given("[Navigation] I navigate to '$link'")
	@When("[Navigation] I navigate to '$link'")
	@Then("[Navigation] I navigate to '$link'")
	public void navigate_to(String link) {
		cannedPage.navigateTo(link);
	}

	// Step to navigate forward
	@Given("[Navigation] I navigate forward")
	@When("[Navigation] I navigate forward")
	@Then("[Navigation] I navigate forward")
	public void navigate_forward() {
		cannedPage.navigate("forward");
	}

	// Step to navigate backward
	@Given("[Navigation] I navigate back")
	@When("[Navigation] I navigate back")
	@Then("[Navigation] I navigate back")
	public void navigate_back() {
		cannedPage.navigate("back");
	}

	// steps to refresh page
	@Given("[Navigation] I refresh page")
	@When("[Navigation] I refresh page")
	@Then("[Navigation] I refresh page")
	public void refresh_page() {
		cannedPage.refresh_page();

	}

	// step to resize browser
	@Given("[Navigation] I resize browser window size to width '$widthValue' and height '$heightValue'")
	@When("[Navigation] I resize browser window size to width '$widthValue' and height '$heightValue'")
	@Then("[Navigation] I resize browser window size to width '$widthValue' and height '$heightValue'")
	public void resize_browser(int widthValue, int heightValue)
	{
		cannedPage.resizeBrowser(widthValue, heightValue);
	}

	// step to maximize browser
	@Given("[Navigation] I maximize browser window")
	@When("[Navigation] I maximize browser window")
	@Then("[Navigation] I maximize browser window")
	public void maximize_browser()
	{
		cannedPage.maximizeBrowser();
	}



	// scroll webpage top
	@Given("[Navigation] I scroll to top of page")
	@When("[Navigation] I scroll to top of page")
	@Then("[Navigation] I scroll to top of page")
	public void scroll_page_top() throws Exception
	{
		cannedPage.scrollPage("top");
	}


	// scroll webpage end
	@Given("[Navigation] I scroll to end of page")
	@When("[Navigation] I scroll to end of page")
	@Then("[Navigation] I scroll to end of page")
	public void scroll_page_end() throws Exception
	{
		cannedPage.scrollPage("end");
	}


	// scroll webpage to specific element

	@Given("[Navigation] I scroll to '$elementName'")
	@When("[Navigation] I scroll to '$elementName'")
	@Then("[Navigation] I scroll to '$elementName'")
	public void scroll_to_element(String elementName) throws Exception
	{
		cannedPage.scrollToElement(elementName);
	}


	// hover over element
	// Note: Doesn't work on Windows firefox
	@Given("[Navigation] I hover over '$elementName'")
	@When("[Navigation] I hover over '$elementName'")
	@Then("[Navigation] I hover over '$elementName'")
	public void hover_over_element(String elementName) throws Exception
	{

		cannedPage.hoverOverElement(elementName);
	}





	//Assertion steps

	/** page title checking
	 * @param titleValue :
	 * @throws Exception
	 */
	@Given("[Assertion] Verify page title equals '$titleValue'")
	@When("[Assertion] Verify page title equals '$titleValue'")
	@Then("[Assertion] Verify page title equals '$titleValue'")
	public void check_title(String titleValue) throws Exception
	{
		cannedPage.checkTitle(titleValue,true);
	}


	//Assertion steps

	/** page title checking
	 * @param titleValue :
	 * @throws Exception
	 */
	@Given("[Assertion] Verify page title not equals '$titleValue'")
	@When("[Assertion] Verify page title not equals '$titleValue'")
	@Then("[Assertion] Verify page title not equals '$titleValue'")
	public void check_not_equals_title(String titleValue) throws Exception
	{
		cannedPage.checkTitle(titleValue,false);
	}

	// step to check element text
	@Given("[Assertion] Verify '$elementName' equals '$value' text")
	@When("[Assertion] Verify '$elementName' equals '$value' text")
	@Then("[Assertion] Verify '$elementName' equals '$value' text")
	public void check_element_text(String elementName, String value) throws Exception {
		cannedPage.checkElementText(elementName, value, true);
	}

	// step to check element text not equals
	@Given("[Assertion] Verify '$elementName' not equals '$value' text")
	@When("[Assertion] Verify '$elementName' not equals '$value' text")
	@Then("[Assertion] Verify '$elementName' not equals '$value' text")
	public void check_element_should_not_have_text(String elementName, String value) throws Exception {
		cannedPage.checkElementText(elementName, value, false);
	}

	// step to check element partial text
	@Given("[Assertion] Verify '$elementName' contains '$value' text")
	@When("[Assertion] Verify '$elementName' contains '$value' text")
	@Then("[Assertion] Verify '$elementName' contains '$value' text")
	public void check_element_partial_text(String elementName, String value) throws Exception {
		cannedPage.checkElementpartialText(elementName, value, true);
	}

	// step to check element not have partial text
	@Given("[Assertion] Verify '$elementName' not contains '$value' text")
	@When("[Assertion] Verify '$elementName' not contains '$value' text")
	@Then("[Assertion] Verify '$elementName' not contains '$value' text")
	public void check_element_should_not_have_partial_text(String elementName, String value) throws Exception {
		cannedPage.checkElementpartialText(elementName, value, false);
	}


	// step to check attribute value
	@Given("[Assertion] Verify '$elementName' have attribute '$attributeName' with '$attributeValue' value")
	@When("[Assertion] Verify '$elementName' have attribute '$attributeName' with '$attributeValue' value")
	@Then("[Assertion] Verify '$elementName' have attribute '$attributeName' with '$attributeValue' value")
	public void check_element_attribute(String elementName, String attributeName, String attributeValue) throws Exception
	{
		cannedPage.checkElementAttribute(elementName, attributeName, attributeValue, true);
	}

	// step to check attribute not have value
	@Given("[Assertion] Verify '$elementName' not have attribute '$attributeName' with '$attributeValue' value")
	@When("[Assertion] Verify '$elementName' not have attribute '$attributeName' with '$attributeValue' value")
	@Then("[Assertion] Verify '$elementName' not have attribute '$attributeName' with '$attributeValue' value")
	public void check_element_not_have_attribute(String elementName, String attributeName, String attributeValue) throws Exception
	{
		cannedPage.checkElementAttribute(elementName, attributeName, attributeValue, false);
	}


	// step to check element enabled
	@Given("[Assertion] Verify '$elementName' is enable")
	@When("[Assertion] Verify '$elementName' is enable")
	@Then("[Assertion] Verify '$elementName' is enable")
	public void check_element_enable(String elementName) throws Exception
	{
		cannedPage.checkElementEnable(elementName, true);
	}


	// step to check element disable
	@Given("[Assertion] Verify '$elementName' is disable")
	@When("[Assertion] Verify '$elementName' is disable")
	@Then("[Assertion] Verify '$elementName' is disable")
	public void check_element_disable(String elementName) throws Exception
	{
		cannedPage.checkElementEnable(elementName, false);
	}


	// step to check elementName present
	@Given("[Assertion] Verify '$elementName' is present")
	@When("[Assertion] Verify '$elementName' is present")
	@Then("[Assertion] Verify '$elementName' is present")
	public void check_element_presence(String elementName) throws Exception {
		cannedPage.checkElementPresence(elementName, true);
	}

	// step to check element not present
	@Given("[Assertion] Verify '$elementName' not present")
	@When("[Assertion] Verify '$elementName' not present")
	@Then("[Assertion] Verify '$elementName' not present")
	public void check_element_not_presence(String elementName) throws Exception {
		cannedPage.checkElementPresence(elementName, false);
	}




	//step to assert checkbox is checked
	@Given("[Assertion] Verify '$elementName' is checked")
	@When("[Assertion] Verify '$elementName' is checked")
	@Then("[Assertion] Verify '$elementName' is checked")
	public void is_checkbox_checked(String elementName) throws Exception
	{
		cannedPage.isCheckboxChecked(elementName, true);
	}


	//step to assert checkbox is unchecked
	@Given("[Assertion] Verify '$elementName' is unchecked")
	@When("[Assertion] Verify '$elementName' is unchecked")
	@Then("[Assertion] Verify '$elementName' is unchecked")
	public void is_checkbox_unchecked(String elementName) throws Exception
	{
		cannedPage.isCheckboxChecked(elementName, false);
	}




	//step to assert radio button is selected
	@Given("[Assertion] Verify '$elementName' is selected")
	@When("[Assertion] Verify '$elementName' is selected")
	@Then("[Assertion] Verify '$elementName' is selected")
	public void is_radioButton_selected(String elementName) throws Exception
	{
		cannedPage.isRadioButtonSelected(elementName, true);
	}


	//step to assert radio button is unselected
	@Given("[Assertion] Verify '$elementName' is unselected")
	@When("[Assertion] Verify '$elementName' is unselected")
	@Then("[Assertion] Verify '$elementName' is unselected")
	public void is_radioButton_unselected(String elementName) throws Exception
	{
		cannedPage.isRadioButtonSelected(elementName, false);
	}


	// enter text into input field steps
	@Given("[Input] Set '$elementName' value to '$value'")
	@When("[Input] Set '$elementName' value to '$value'")
	@Then("[Input] Set '$elementName' value to '$value'")
	public void enter_text(String elementName, String value) throws Exception {

		if (value.toLowerCase().contains("random")) {
			String key = value.toLowerCase().replace("random", "").trim();
			value = value.toLowerCase().replace("random", "Auto" + String.valueOf(System.nanoTime()));
			stateManager.put(key, value);
		}

		if (value.toLowerCase().contains("date")) {
			String key = value.toLowerCase().replace("date", "").trim();
			value = value.toLowerCase().replace("date", LocalDate.now().toString());
			stateManager.put(key, value);
		}

		if (value.toLowerCase().contains("statemanager")) {
			String key = value.toLowerCase().replace("statemanager", "").trim();
			value = (String) stateManager.get(key);
		}

		if (value.toLowerCase().contains("nanotime")) {
			String key = value.toLowerCase().replace("nanotime", "").trim();
			value = String.valueOf(System.nanoTime());
			stateManager.put(key, value);
		}

		cannedPage.enterText(elementName, value);

	}


	// clear input field steps
	@Given("[Input] Clear '$elementName' field")
	@When("[Input] Clear '$elementName' field")
	@Then("[Input] Clear '$elementName' field")
	public void clear_text(String elementName) throws Exception
	{
		cannedPage.clearText(elementName);
	}



	// select option by text from dropdown
	@Given("[Input] Select '$optionValue' value from '$dropDownListName'")
	@When("[Input] Select '$optionValue' value from '$dropDownListName'")
	@Then("[Input] Select '$optionValue' value from '$dropDownListName'")
	public void select_option_from_dropdown(String optionValue,String dropDownListName) throws Exception
	{
		cannedPage.selectOptionFromDropdown(optionValue, dropDownListName);
	}



	//check checkbox steps
	@Given("[Input] I check the '$elementName'")
	@When("[Input] I check the '$elementName'")
	@Then("[Input] I check the '$elementName'")
	public void check_checkbox(String elementName) throws Exception
	{
		cannedPage.checkCheckbox(elementName);
	}


	//uncheck checkbox steps
	@Given("[Input] I uncheck the '$elementName'")
	@When("[Input] I uncheck the '$elementName'")
	@Then("[Input] I uncheck the '$elementName'")
	public void uncheck_checkbox(String elementName) throws Exception
	{
		cannedPage.uncheckCheckbox(elementName);
	}


	// step to select radio button
	@Given("[Input] I select the '$elementName'")
	@When("[Input] I select the '$elementName'")
	@Then("[Input] I select the '$elementName'")
	public void select_radio_button(String elementName) throws Exception
	{
		cannedPage.selectRadioButton(elementName);
	}

	// click on web element
	@Given("[Input] I click on '$elementName'")
	@When("[Input] I click on '$elementName'")
	@Then("[Input] I click on '$elementName'")
	public void click(String elementName) throws Exception {
		cannedPage.click(elementName);

	}


	@Given("[Input] I login as '$userName' with password '$password'")
	@When("[Input] I login as '$userName' with password '$password'")
	@Then("[Input] I login as '$userName' with password '$password'")
	public void loginAs(@Named("userName") String userName, @Named("password") String password) throws Throwable {
		cannedPage.enterText("userName", userName).enterText("password", password).click("login Button");
	}




	// wait for specific period of time
	@Given("[Progress] I wait for '$value' sec")
	@When("[Progress] I wait for '$value' sec")
	@Then("[Progress] I wait for '$value' sec")
	public void wait(String value) throws NumberFormatException, InterruptedException
	{
		cannedPage.wait(value);
	}


	// wait element to be disappear
	@Given("[Progress] I wait '$elementName' To be disappear")
	@When("[Progress] I wait '$elementName' To be disappear")
	@Then("[Progress] I wait '$elementName' To be disappear")
	public void waitElementDisappear(String elementName) throws Exception {
		cannedPage.wait_Element_Disappear(elementName);
	}

	//Step to handle java script
	@Given("[Javascript] I accept alert")
	@When("[Javascript] I accept alert")
	@Then("[Javascript] I accept alert")
	public void handle_alert()
	{
		cannedPage.handleAlert("accept");
	}


	//Steps to dismiss java script
	@Given("[Javascript] I dismiss alert")
	@When("[Javascript] I dismiss alert")
	@Then("[Javascript] I dismiss alert")
	public void dismiss_alert()
	{
		cannedPage.handleAlert("dismiss");
	}


	@Given("[Input] I select '$value' from the '$elementName' combo box")
	@When("[Input] I select '$value' from the '$elementName' combo box")
	@Then("[Input] I select '$value' from the '$elementName' combo box")
	public void selectFromComboBox(String value, String elementName) throws Exception {
		cannedPage.selectFromComboBox(elementName, value);
	}

}
