package com.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.configuration.pageobjects.PageObject;

@PageObject
public class CannedPage extends AbstractPage<CannedPage> {

//	@Value("${browser.screen.breakpoints}")
//	private String breakpoints;

// logIn Dewan // Login Page elements

	@FindBy(css = "#tbxName")
	public WebElement userName;
	@FindBy(css = "#tbxPassword")
	public WebElement password;
	@FindBy(css = "#btnlogin")
	public WebElement loginButton;
	@FindBy(css = ".rmItem.rmLast.text-align-center")
	public WebElement logoutButton;
	@FindBy(css = "#ctl00_RadMenu1 > ul > li:nth-child(8) > a > span")
	public WebElement dewanHeader;

// logIn Dewan // Generalization Page elements

	@FindBy(xpath = "//span[contains(text(),'إدخال معاملة')]")
	public WebElement AddProcessButton;

	@FindBy(xpath = "//a[contains(text(),'تعميم')]")
	public WebElement GeneralizationButton;
// filling generalization mandatory fields

	@FindBy(css = "#tbxSubject")
	public WebElement GeneralizationSubjectField;

	@FindBy(css = "#ctl00_MainContent_cal_2543_dateInput")
	public WebElement GeneralizationDateField;

	@FindBy(css = "#ctl00_MainContent_btnSave")
	public WebElement GeneralizationSaveButton;

	@FindBy(css = "#tbxSubject")
	public WebElement GeneralizationGetSubject;

	@FindBy(css = "#MainContent_txtSerial_2583")
	public WebElement GeneralizationGetSerialNumber; //value

	@FindBy(css = "#ctl00_MainContent_btnApprove")
	public WebElement GeneralizeButton;

	@FindBy(css = "#MainContent_summary1")
	public WebElement GeneralizationDirectionButton;

	@FindBy(xpath = "//span[contains(text(),'التعاميم')]")
    public WebElement GeneralizationsHeaderButton;

	@FindBy(xpath = "//tbody/tr[@id='ctl00_MainContent_RadGrid1_ctl00__0']/td[1]")
	public WebElement GeneralizationFirstSerialNumber;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00__0\"]/td[2]")
	////*[@id="ctl00_MainContent_RadGrid1_ctl00__0"]/td[2]
	public WebElement GeneralizationFirstSubjectText;

	//
	@FindBy(css = "[test-attr=\"broker_destination_of_import_export\"]")
	public WebElement destinationCountryDropDown;


	@FindBy(css = "[test-attr=\"broker_party_sender\"]")
	public WebElement partySenderField;

	@FindBy(css = "[test-attr=\"broker_party_sent_to\"]")
	public WebElement partySentToField;

	@FindBy(css = "[test-attr=\"broker_cargo_value\"]")
	public WebElement cargoValueField;

	@FindBy(css = "[test-attr=\"broker_insurance_amount\"]")
	public WebElement insuranceAmountField;

	@FindBy(css = "[test-attr=\"broker_broker_authorization_code\"]")
	public WebElement brokerAuthorizationCodeField;

	@FindBy(xpath = "*//ul/li/button[contains(text(),\"Save and continue\")]")
	public WebElement saveAndContinueButton;

	@FindBy(css = "[id=\"autocomplete-results\"][style=\"\"] li:not([class=autocomplete-loading])")
	public WebElement AutoCompleteResult;

// Delivery Order Step

	@FindBy(css = "button[onclick*=\"deliveryOrder.search\"]")
	public WebElement deliveryOrderAddButton;

	@FindBy(css = "[test-attr=\"broker_delivery_order_number\"]")
	public WebElement deliveryOrderNumberField;

	@FindBy(css = "[test-attr=\"broker_type\"]")
	public WebElement deliveryOrderTypeDropDown;

	@FindBy(css = "[test-attr=\"broker_from\"]")
	public WebElement deliveryOrderFromField;

	@FindBy(css = "[test-attr=\"broker_to\"]")
	public WebElement deliveryOrderToField;

	@FindBy(css = "[data-i18n=\"broker:Search\"]")
	public WebElement deliveryOrderSearchButton;

	@FindBy(xpath = "*//button[contains(text(),\"Choose Delivery Order\")]")
	public WebElement chooseDeliveryOrderButton;

// Items & Invoice Payment Step

	@FindBy(css = "button[onclick*=\"item\"]")
	public WebElement itemsAddButton;

	@FindBy(css = "[test-attr=\"broker_country_of_origin\"]")
	public WebElement countryOfOriginField;

	@FindBy(css = "[test-attr=\"broker_tariff_code\"]")
	public WebElement tariffCodeField;

	@FindBy(css = "button[data-i18n=\"broker:Retrieve_Details\"]")
	public WebElement retrieveDetailsButton;

	@FindBy(css = "[test-attr=\"broker_origin_quantity\"]")
	public WebElement originQuantityField;

	@FindBy(css = "[test-attr=\"broker_item_quantity\"]")
	public WebElement itemQuantityField;

	@FindBy(css = "[test-attr=\"broker_gross_weight_kgm\"]")
	public WebElement grossWeightField;

	@FindBy(css = "[test-attr=\"broker_net_weight_kgm\"]")
	public WebElement netWeightField;

	@FindBy(css = "[test-attr=\"broker_original_value\"]")
	public WebElement originalValueField;

	@FindBy(css = "[test-attr=\"broker_original_duty\"]")
	public WebElement originalDutyField;

	@FindBy(css = "[test-attr=\"broker_currency_code\"]")
	public WebElement currencyCodeField;

	@FindBy(css = "[test-attr=\"broker_exemptions_invoice_measurement_unit\"]")
	public WebElement invoiceMeasurementUnitField;

	@FindBy(css = "[test-attr=\"broker_declaration_date\"] div:nth-child(1) select")
	public WebElement firstPortDeclarationDateDayDropDown;

	@FindBy(css = "[test-attr=\"broker_declaration_date\"] div:nth-child(2) select")
	public WebElement firstPortDeclarationDateMonthDropDown;

	@FindBy(css = "[test-attr=\"broker_declaration_date\"] div:nth-child(3) select")
	public WebElement firstPortDeclarationDateYearDropDown;

	@FindBy(css = "div:nth-child(27) > div.input-text.form-group.autocomplete.col-12.col-md-6.valid > i")
	public WebElement firstPortCustomsPortField;

	@FindBy(css = "[test-attr=\"broker_declaration_number\"]")
	public WebElement firstPortDeclarationNoField;

	@FindBy(css = "[test-attr=\"broker_item_number\"]")
	public WebElement firstPortItemNumberField;

	@FindBy(css = "[test-attr=\"broker_declaration_type_1\"]")
	public WebElement firstPortDeclarationTypeDropDown;

	@FindBy(css = "button[data-method=\"Save\"]")
	public WebElement itemsSaveButton;

// Additional Information	

	@FindBy(css = "button[onclick*=\"attachedDocuments\"]")
	public WebElement attachedDocumentsAddButton;

	@FindBy(css = "[test-attr=\"broker_number\"]")
	public WebElement attachedDocumentDetailsNoField;

	@FindBy(css = " [test-attr=\"broker_type_1\"]")
	public WebElement attachedDocumentDetailsTypeDropDown;

	@FindBy(css = "[test-attr=\"broker_date\"]")
	public WebElement attachedDocumentDetailsDateField;

	@FindBy(css = "button[data-method=\"Save\"]")
	public WebElement attachedDocumentDetailsSaveButton;

	@FindBy(id = "insurance-tab")
	public WebElement insuranceInformationTab;

	@FindBy(css = "[test-attr=\"broker_insurance_method\"]")
	public WebElement insuranceMethodDropDown;

	@FindBy(xpath = "*//button[text()=\"Save\"]")
	public WebElement insuranceInformationSaveButton;

	@FindBy(xpath = "*//button[text()=\"Submit\"]")
	public WebElement additionalInformationSubmitButton;

	@FindBy(css = "div[class*=\"alert-success\"]")
	public WebElement createStatisticalDeclarationSuccessMessage;

	@FindBy(css = "div[class*=\"alert-success\"]")
	public WebElement MohannadSalemName;

	/**
	 * Method to open link
	 * 
	 * @param url : String : URL for navigation
	 * @throws Exception
	 */
	public void navigateTo(String url) {

		webDriverProvider.get().manage().window().maximize();
//		Dimension dimension = new Dimension(1400, 2000);
//		webDriverProvider.get().manage().window().setSize(dimension);

		webDriverProvider.get().manage().deleteAllCookies();
		webDriverProvider.get().get(url);
		log.info("Navigating to the page: " + url);
	}

	/**
	 * Method to enter text into text field
	 * 
	 * @param elementName : String : element Name
	 * @param text        : String : Text value to enter in field
	 * @throws Exception
	 */
	public CannedPage enterText(String elementName, String text) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		// element.clear();
		element.sendKeys(text);
		log.info("Filled '" + elementName + "' with value: " + text);
		return this;

	}

	/**
	 * Method to click on an element
	 * 
	 * @param elementName : String : element Name
	 * @throws Exception
	 */
	public CannedPage click(String elementName) throws Exception {
		// wait element
		WebElement element = getElementWithWait(this, elementName);
		element.click();
//		Actions actions = new Actions(webDriverProvider.get());
//		actions.moveToElement(element).click().perform();
		log.info("Clicked on '" + elementName + "'");
		return this;
	}

	/**
	 * method to check element presence
	 * 
	 * @param elementName : String : element Name
	 * @param testCase    : Boolean : test case [true or false]
	 * @throws Exception
	 */
	public void checkElementPresence(String elementName, boolean testCase) throws Exception {
		if (testCase) {
			if (!isElementDisplayed(elementName))
				throw new Exception("Element Not Present");
		} else {
			try {
				if (isElementDisplayed(elementName))
					throw new Exception("Present"); // since it is negative test and we found element
			} catch (Exception e) {
				if (e.getMessage().equals("Present")) // only raise if it present
					throw new Exception("Element Present");
			}
		}
	}

	/**
	 * method to get element status - displayed?
	 * 
	 * @param elementName : String : element Name
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean isElementDisplayed(String elementName) throws Exception {

		return getElementWithWait(this, elementName).isDisplayed();
	}

	/**
	 * Method to check element text
	 * 
	 * @param elementName : String : element Name
	 * @param expected    : String : Expected element text
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			if (!elementText.equalsIgnoreCase(expected))
				Assert.assertEquals(expected, elementText);
		} else {
			if (elementText.equalsIgnoreCase(expected))
				throw new Exception("Text Matched");
		}
	}

	/**
	 * Method to check element partial text
	 * 
	 * @param elementName : String : element Name
	 * @param expected    : String : Expected element text
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementpartialText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			if (!elementText.toLowerCase().contains(expected.toLowerCase())) {
				Assert.assertEquals(expected, elementText);
			}
			System.out.println("==========================================================");
			System.out.println("Actual: " + elementText);
			System.out.println("==========================================================");
		} else {
			if (elementText.toLowerCase().contains(expected.toLowerCase()))
				Assert.assertNotEquals(expected, elementText);
		}
	}

	/**
	 * Method to get element text
	 * 
	 * @param elementName : String : element Name
	 * @return String
	 * @throws Exception
	 */
	public String   getElementWithWaitText(String elementName) throws Exception {
		return getElementWithWait(this, elementName).getText();

	}

	/**
	 * Method to wait element disappear
	 * 
	 * @param elementName : String : element Name
	 * @throws Exception
	 */

	public void wait_Element_Disappear(String elementName) throws Exception {
		List<WebElement> elements = new ArrayList<WebElement>();
		elements.add(getElement(this, elementName));
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	}

	public void navigate(String direction) {
		if (direction.equals("back")) {
			webDriverProvider.get().navigate().back();
			log.info("I navigate back");
		} else {
			webDriverProvider.get().navigate().forward();
			log.info("I navigate forward");
		}
	}

	public void refresh_page() {
		webDriverProvider.get().navigate().refresh();
		log.info("I refresh page");
	}

	/**
	 * Method to resize browser
	 * 
	 * @param width  : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	public void resizeBrowser(int width, int height) {
		webDriverProvider.get().manage().window().setSize(new Dimension(width, height));
		log.info("I resize browser window size to width '" + width + "' and height '" + height + "'");
	}

	/** Method to maximize browser */
	public void maximizeBrowser() {
		webDriverProvider.get().manage().window().maximize();
		log.info("I maximize browser window");
	}

	/**
	 * Method to scroll page to top or end
	 * 
	 * @throws Exception
	 */
	public void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) webDriverProvider.get();
		if (to.equals("end")) {
			executor.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
			log.info("I scroll to end of page");
		} else if (to.equals("top")) {
			executor.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
			log.info("I scroll to top of page");
		} else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}

	/**
	 * Method to scroll page to particular element
	 * 
	 * @param elementName : String : to get element
	 * @throws Exception
	 */
	public void scrollToElement(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		JavascriptExecutor executor = (JavascriptExecutor) webDriverProvider.get();
		executor.executeScript("arguments[0].scrollIntoView();", element);
		log.info("I scroll to '" + elementName + "'");
	}

	/**
	 * Method to hover on element
	 * 
	 * @param elementName : String : to get element
	 * @throws Exception
	 */
	public void hoverOverElement(String elementName) throws Exception {
		Actions action = new Actions(webDriverProvider.get());
		WebElement element = getElementWithWait(this, elementName);
		action.moveToElement(element).perform();
	}

	/**
	 * Method to verify page title
	 * 
	 * @param title    : String : expected title
	 * @param testCase : Boolean : test case [true or false]
	 * @throws Exception
	 */
	public void checkTitle(String title, boolean testCase) throws Exception {
		String pageTitle = webDriverProvider.get().getTitle();

		if (testCase) {
			Assert.assertEquals(title, pageTitle);
		} else {
			Assert.assertNotEquals(title, pageTitle);
		}
	}

	public void checkElementAttribute(String elementName, String attributeName, String attributeValue, boolean testCase)
			throws Exception {
		String attrVal = getElementAttribute(elementName, attributeName);
		if (testCase) {
			if (!attrVal.equals(attributeValue))
				Assert.assertEquals(attributeValue, attrVal);
		} else {
			if (attrVal.equals(attributeValue))
				Assert.assertNotEquals(attributeValue, attrVal);
		}
	}

	public String getElementAttribute(String elementName, String attributeName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.getAttribute(attributeName);
	}

	public void checkElementEnable(String elementName, boolean testCase) throws Exception {
		boolean result = isElementEnabled(elementName);
		if (testCase) {
			if (!result)
				Assert.assertFalse("Element Not Enabled", result);

		} else {
			if (result)
				Assert.assertTrue("Element Enabled", result);
		}
	}

	public boolean isElementEnabled(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.isEnabled();
	}

	public void isCheckboxChecked(String elementName, boolean shouldBeChecked) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if ((!checkbox.isSelected()) && shouldBeChecked)
			Assert.assertTrue("Checkbox is not checked", (!checkbox.isSelected()) && shouldBeChecked);
		else if (checkbox.isSelected() && !shouldBeChecked)
			Assert.assertTrue("Checkbox is checked", checkbox.isSelected() && !shouldBeChecked);
	}

	public void isRadioButtonSelected(String elementName, boolean shouldBeSelected) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if ((!checkbox.isSelected()) && shouldBeSelected)
			Assert.assertTrue("Radio Button is not Selected", (!checkbox.isSelected()) && shouldBeSelected);
		else if (checkbox.isSelected() && !shouldBeSelected)
			Assert.assertTrue("Radio Button is Selected", checkbox.isSelected() && !shouldBeSelected);
	}

	public void clearText(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.clear();
	}

	public void selectOptionFromDropdown(String optionValue, String dropDownListName) throws Exception {
		WebElement dropdown = getElementWithWait(this, dropDownListName);
		Select selectList = new Select(dropdown);

		selectList.selectByVisibleText(optionValue);
	}

	public void checkCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (!checkbox.isSelected())
			checkbox.click();
	}

	public void uncheckCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (checkbox.isSelected())
			checkbox.click();
	}

	public void selectRadioButton(String elementName) throws Exception {
		WebElement radioButton = getElementWithWait(this, elementName);
		if (!radioButton.isSelected())
			radioButton.click();
	}

	public CannedPage wait(String time) throws NumberFormatException, InterruptedException {
		// sleep method takes parameter in milliseconds
		Thread.sleep(Integer.parseInt(time) * 1000);
		return this;

	}

	public void handleAlert(String decision) {
		if (decision.equals("accept"))
			webDriverProvider.get().switchTo().alert().accept();
		else
			webDriverProvider.get().switchTo().alert().dismiss();
	}

}
