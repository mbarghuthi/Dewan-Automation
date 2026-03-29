package com.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.configuration.pageobjects.PageObject;

@PageObject
public class CannedPage extends AbstractPage<CannedPage> {

	// ********************************************************************************************************
	// **************************************** Login Page ****************************************************
	// ********************************************************************************************************

	@FindBy(css = "#tbxName")
	public WebElement userName;

	@FindBy(css = "#tbxPassword")
	public WebElement password;

	@FindBy(css = "#chUnifiedLogin")
	public WebElement UnifiedLogin;

	@FindBy(css = "#btnlogin")
	public WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'خروج')]")
	public WebElement logoutButton;

	@FindBy(css = "#ctl00_RadMenu1 > ul > li:nth-child(8) > a > span")
	public WebElement dewanHeader;

	// ********************************************************************************************************
	// ************************************** Generalization **************************************************
	// ********************************************************************************************************

	@FindBy(xpath = "//span[contains(text(),'إدخال معاملة')]")
	public WebElement AddProcessButton;

	@FindBy(xpath = "//a[contains(text(),'تعميم')]")
	public WebElement GeneralizationButton;

	@FindBy(css = "#tbxSubject")
	public WebElement SubjectField;

	@FindBy(css = "#ctl00_MainContent_cal_2543_dateInput")
	public WebElement GeneralizationDateField;

	@FindBy(css = "#ctl00_MainContent_btnSave")
	public WebElement SaveButton;

	@FindBy(css = "#ctl00_MainContent_btnSaveDraft")
	public WebElement SaveDraftButton;

	@FindBy(css = "#MainContent_txtSerial_2583")
	public WebElement GeneralizationGetSerialNumber;

	@FindBy(css = "#MainContent_txt_2584")
	public WebElement GeneralizationGetYear;

	@FindBy(css = "#ctl00_MainContent_btnApprove")
	public WebElement GeneralizeButton;

	@FindBy(css = "#MainContent_summary1")
	public WebElement DirectionTab;

	@FindBy(xpath = "//*[@id=\"ctl00_RadMenu1\"]/ul/li[5]/a")
	public WebElement GeneralizationsHeaderButton;

	@FindBy(xpath = "//tbody/tr[@id='ctl00_MainContent_RadGrid1_ctl00__0']/td[2]")
	public WebElement GeneralizationFirstSerialNumber;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00__0\"]/td[3]")
	public WebElement GeneralizationFirstSubjectText;

	@FindBy(css = "#ctl00_MainContent_RadGrid1_ctl00_ctl04_OpenLink")
	public WebElement GeneralizationsViewProcessButton;

	@FindBy(css = "#ctl00_MainContent_RadGrid1_ctl00_ctl04_OpenLink")
	public WebElement TaskListViewProcessButton;

	@FindBy(css = "#ctl00_MainContent_rgmyRequest_ctl00_ctl04_OpenLink")
	public WebElement MyProcessesListViewProcessButton;

	@FindBy(xpath = "//span[contains(text(),'جميع المهام')]")
	public WebElement AllTaskHeaderButton;

	@FindBy(xpath = "//a[contains(text(),'معاملاتي')]")
	public WebElement MyProcessesListHeaderButton;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_ChangePageSizeTextBox\"]")
	public WebElement GeneralizationSizePageInput;

	@FindBy(xpath = "//span[contains(text(),'تغيير')]")
	public WebElement ChangeGridSizeButton;

	@FindBy(xpath = "//tbody/tr[@id='ctl00_MainContent_rgmyRequest_ctl00__0']/td[5]")
	public WebElement ProcessStatus;

	@FindBy(xpath = "//a[contains(text(),'مهام للإجراء')]")
	public WebElement TaskListHeaderButton;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00__0\"]/td[5]")
	public WebElement TaskListFirstSubjectText;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00__0\"]/td[5]")
	public WebElement TasksToViewFirstSubjectText;

	@FindBy(css = "ul.rmRootGroup li.profile a.rmLink.rmRootLink")
	public WebElement UserNameHeaderButton;

	@FindBy(xpath = "//a[contains(text(),'الملف الشخصي')]")
	public WebElement ProfileHeaderButton;

	@FindBy(xpath = "//*[@id=\"ctl00_RadMenu1\"]/ul/li[1]/a/span")
	public WebElement UserProfileDDL;

	@FindBy(css = "#MainContent_tbxUserName")
	public WebElement UserNameValue;

	@FindBy(css = "#MainContent_summary1")
	public WebElement OutgoingUsersDirectedTo;

	@FindBy(css = "#ctl00_MainContent_btnApprove")
	public WebElement DirectionButton;

	@FindBy(xpath = "//a[contains(text(),'بريد صادر الى الخارج')]")
	public WebElement OutgoingButton;

	@FindBy(xpath = "//*[@id=\"ctl00_RadMenu1\"]/ul/li[4]/div/ul/li[3]/a")
	public WebElement TasksToView;

	@FindBy(xpath = "//a[contains(text(),'تاريخ المهمة')]")
	public WebElement TasksToViewDate;

	@FindBy(xpath = "//span[contains(text(),'مشاهدة')]")
	public WebElement ViewButton;

	@FindBy(xpath = "//a[contains(text(),'المهام المنجزة')]")
	public WebElement CompletedTasks;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_CompletedTasksGrid_ctl00__0\"]/td[4]")
	public WebElement CompletedTasksFirstSubjectText;

	@FindBy(css = "#MainContent_txt_2361")
	public WebElement OutgoingGetSerialNumber;

	@FindBy(xpath = "//a[contains(text(),'بريد وارد من الخارج')]")
	public WebElement IncomingButton;

	@FindBy(css = "#MainContent_txt_2494")
	public WebElement IncomingGetSerialNumber;

	// ********************************************************************************************************
	// ************************************** UOP / JPPMC Fields **********************************************
	// ********************************************************************************************************

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2371_Input")
	public WebElement DivisionExporterUOP;

	@FindBy(css = "#ctl00_MainContent_ddl_2375_Input")
	public WebElement SalutationHandUOP;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_GVUserOrg_ctl00__0\"]/td[4]")
	public WebElement OutgoingUserNameDirectedTo1UOP;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2371_Input")
	public WebElement CommissionersExportingOutgoingJPPMC;

	@FindBy(css = "#ctl00_MainContent_ddl_2375_Input")
	public WebElement AddresseeNameOutgoingJPPMC;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_GVUserOrg_ctl00__0\"]/td[4]")
	public WebElement OutgoingUserNameDirectedTo1JPPMC;

	@FindBy(css = "#MainContent_txt_2488")
	public WebElement NumBookFromTheSource;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2496_Input")
	public WebElement IncomingCommissionerDestination;

	@FindBy(css = "#ctl00_MainContent_ddl_2492_Input")
	public WebElement SourceBookByName;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2626_Input")
	public WebElement ReceiverName;

	@FindBy(css = "#ctl00_MainContent_ddl_2606_Input")
	public WebElement Delivery;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2496_Input")
	public WebElement CommissionersExportingIncomingJPPMC;

	@FindBy(css = "#ctl00_MainContent_ddl_2668_Input")
	public WebElement RecipientsIncomingJPPMC;

	@FindBy(css = "#ctl00_MainContent_ddl_2628_Input")
	public WebElement SubReceiverNameIncomingJPPMC;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00__0\"]/td[5]")
	public WebElement TasksToViewFirstSubjectTextJPPMC;

	@FindBy(css = "#ctl00_MainContent_btnCloseProcess")
	public WebElement CloseButton;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_GVUserOrg_ctl00__0\"]/td[2]")
	public WebElement DepartmentLiaisonOfficerName;

	@FindBy(css = "#MainContent_summary2")
	public WebElement IncomingUsersDirectedTo;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_GVUserAssign_ctl00__0\"]/td[2]")
	public WebElement IncomingUserNameDirectedTo1;

	@FindBy(css = "#MainContent_rdchkCopy")
	public WebElement ToViewRadioButton;

	@FindBy(css = "#ctl00_MainContent_btnAddHierarchy")
	public WebElement AddButton;

	@FindBy(css = "#ctl00_MainContent_GVUserOrg_ctl00_ctl02_ctl01_mainCB")
	public WebElement ClickOnAllCheckBox;

	@FindBy(css = "#ctl00_MainContent_GVUserOrg_ctl00_ctl02_ctl01_ImgDelete")
	public WebElement DeleteButton;

	@FindBy(css = "#ctl00_MainContent_notification_rnCloseIcon")
	public WebElement CloseNotificationButton;

	// ********************************************************************************************************
	// ************************************** Internal Correspondence ******************************************
	// ********************************************************************************************************

	@FindBy(xpath = "//a[contains(text(),'مراسلات داخلية')]")
	public WebElement InternalCorrespondenceButton;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2593_Input")
	public WebElement InternalCorrespondenceCommissionerDestination;

	@FindBy(css = "#ctl00_MainContent_ddlDivision_Input")
	public WebElement DivisionInput;

	@FindBy(css = "#ctl00_MainContent_ddlDepartment_Input")
	public WebElement DepartmentInput;

	@FindBy(css = "#MainContent_txtSerial_2591")
	public WebElement InternalCorrespondenceGetSerialNumber;

	@FindBy(xpath = "(//a[@class='rmLink'][contains(text(),'الكتب الداخلية')])[1]")
	public WebElement InternalCorrespondenceButtonJPPMC;

	@FindBy(css = "#ctl00_MainContent_ddlOrg_2593_Input")
	public WebElement CommissionerInternalCorrespondenceJPPMC;

	@FindBy(css = "#ctl00_MainContent_ddl_2648_Input")
	public WebElement MainClassificationInternalCorrespondenceJPPMC;

	@FindBy(css = "#MainContent_txt_2642")
	public WebElement FileSubjectInternalCorrespondenceJPPMC;

	@FindBy(css = "#MainContent_txtSerial_2591")
	public WebElement InternalCorrespondenceGetSerialNumberJPPMC;

	@FindBy(xpath = "//*[@id=\"ctl00_li12\"]/a")
	public WebElement ProcessModuleButton;

	@FindBy(css = "#ctl00_Process")
	public WebElement ProcessSubmoduleButton;

	@FindBy(css = "#ctl00_MainContent_GVViewData_ctl02_lnkOption")
	public WebElement InternalCorrespondenceOptions;

	@FindBy(css = "#ctl00_MainContent_txtSaveDraftAR")
	public WebElement SaveDraftArabicCaption;

	@FindBy(css = "#ctl00_MainContent_txtSaveDraftEN")
	public WebElement SaveDraftEnglishCaption;

	@FindBy(css = "#ctl00_MainContent_ImgUpdate")
	public WebElement UpdateButton;

	@FindBy(css = "#ctl00_MainContent_ImgBack")
	public WebElement BackButton;

	// ********************************************************************************************************
	// **************************************** Form Design / Search *******************************************
	// ********************************************************************************************************

	@FindBy(xpath = "//span[contains(text(),'FORM DESIGN')]")
	public WebElement FormDesignModuleButton;

	@FindBy(css = "#ctl00_FormControls")
	public WebElement ContentOfFormSubmoduleButton;

	@FindBy(css = "#ctl00_MainContent_DdlForm")
	public WebElement FormDropDownList;

	@FindBy(xpath = "//tbody/tr[2]/td[5]/a[1]/img[1]")
	public WebElement EditOutgoingMailAttachment;

	@FindBy(xpath = "//option[contains(text(),'Outgoing Mail')]")
	public WebElement OutgoingMailForm;

	@FindBy(css = "#ctl00_MainContent_tbxlblen")
	public WebElement ControlSearchEnglishField;

	@FindBy(css = "#ctl00_MainContent_ImgSearch")
	public WebElement ControlSearchButton;

	@FindBy(xpath = "//a[contains(text(),'بحث متقدم')]")
	public WebElement SearchHeader;

	@FindBy(css = "#ctl00_MainContent_btnsearch")
	public WebElement SearchButton;

	@FindBy(xpath = "//tbody/tr[@id='ctl00_MainContent_GridView1_ctl00__0']/td[1]/a[1]")
	public WebElement FirstView;

	// ********************************************************************************************************
	// **************************************** Home Page ******************************************************
	// ********************************************************************************************************

	@FindBy(xpath = "//a[contains(text(),'الرئيسية')]")
	public WebElement HomePage;

	@FindBy(xpath = "//span[@id='MainContent_lblMyRequestCount']")
	public WebElement MyTasksCount;

	@FindBy(xpath = "//span[@id='MainContent_lblTasksCount']")
	public WebElement TasksListCount;

	@FindBy(xpath = "//span[@id='MainContent_lblCopingTaskCount']")
	public WebElement TaskListToViewCount;

	@FindBy(xpath = "//span[@id='MainContent_lblAnnouncementCount']")
	public WebElement GeneralizationCount;

	@FindBy(xpath = "//*[@id=\"ctl00_RadMenu1\"]/ul/li[5]/a/span/span")
	public WebElement GeneralizationCountMainBar;

	@FindBy(xpath = "//span[@id='MainContent_lblNotificationCount']")
	public WebElement NotificationsCount;

	@FindBy(xpath = "//*[@id=\"ctl00_RadMenu1\"]/ul/li[6]/a/span/span")
	public WebElement NotificationsCountMainBar;

	@FindBy(xpath = "//*[@id=\"MainContent_lblFollowupCount\"]")
	public WebElement ManagerFollowCount;

	@FindBy(xpath = "//span[@id='MainContent_lblCompletedTaskCount']")
	public WebElement CompletedTasksCount;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_rgmyRequest_ctl00\"]/tfoot/tr/td/div/div[5]/strong[5]")
	public WebElement MyTasksGridCount;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_ChangePageSizeTextBox\"]")
	public WebElement TasksListGridSize;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_ChangePageSizeTextBox\"]")
	public WebElement TaskListToViewGridSize;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00\"]/tfoot/tr/td/div/div[4]/strong[5]")
	public WebElement GeneralizationGridCount;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00\"]/tfoot/tr/td/div/div[5]/strong[5]")
	public WebElement NotificationsGridCount;

	@FindBy(xpath = "//input[@id='ctl00_MainContent_TaskFollowup_ctl00_ctl03_ctl01_ChangePageSizeTextBox']")
	public WebElement ManagerFollowGridSize;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_CompletedTasksGrid_ctl00\"]/tfoot/tr/td/div/div[4]/strong[5]")
	public WebElement CompletedTasksGridCount;

	@FindBy(xpath = "//div[contains(text(),'لا يوجد بيانات لإظهارها')]")
	public WebElement NoDataToView;

	@FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl02_ImgMassAction\"]")
	public WebElement MassActionButton;

	// ********************************************************************************************************
	// **************************************** Basic Actions **************************************************
	// ********************************************************************************************************

	/**
	 * Open target URL after maximizing the browser and clearing cookies.
	 */
	public void navigateTo(String url) {
		webDriverProvider.get().manage().window().maximize();
		webDriverProvider.get().manage().deleteAllCookies();
		webDriverProvider.get().get(url);
		log.info("Navigating to the page: " + url);
	}

	/**
	 * Enter text into an input element.
	 */
	public CannedPage enterText(String elementName, String text) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.clear();
		element.sendKeys(text);
		log.info("Filled '" + elementName + "' with value: " + text);
		return this;
	}

	/**
	 * Click on a visible element.
	 */
	public CannedPage click(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.click();
		log.info("Clicked on '" + elementName + "'");
		return this;
	}

	/**
	 * Clear input field text.
	 */
	public void clearText(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.clear();
	}

	/**
	 * Navigate browser backward or forward.
	 */
	public void navigate(String direction) {
		if (direction.equals("back")) {
			webDriverProvider.get().navigate().back();
			log.info("I navigate back");
		} else {
			webDriverProvider.get().navigate().forward();
			log.info("I navigate forward");
		}
	}

	/**
	 * Refresh current page.
	 */
	public void refresh_page() {
		webDriverProvider.get().navigate().refresh();
		log.info("I refresh page");
	}

	/**
	 * Resize browser window to a specific dimension.
	 */
	public void resizeBrowser(int width, int height) {
		webDriverProvider.get().manage().window().setSize(new Dimension(width, height));
		log.info("I resize browser window size to width '" + width + "' and height '" + height + "'");
	}

	/**
	 * Maximize browser window.
	 */
	public void maximizeBrowser() {
		webDriverProvider.get().manage().window().maximize();
		log.info("I maximize browser window");
	}

	/**
	 * Wait for a fixed number of seconds.
	 */
	public CannedPage wait(String time) throws NumberFormatException, InterruptedException {
		Thread.sleep(Integer.parseInt(time) * 1000);
		return this;
	}

	// ********************************************************************************************************
	// **************************************** Assertions *****************************************************
	// ********************************************************************************************************

	/**
	 * Verify whether an element is present or not present.
	 * This method throws real exceptions so Maven/JUnit can fail properly.
	 */
	public void checkElementPresence(String elementName, boolean testCase) throws Exception {
		if (testCase) {
			if (!isElementDisplayed(elementName)) {
				throw new Exception("Element Not Present: " + elementName);
			}
		} else {
			try {
				if (isElementDisplayed(elementName)) {
					throw new Exception("Element Present: " + elementName);
				}
			} catch (Exception e) {
				if (e.getMessage() != null && e.getMessage().startsWith("Element Present")) {
					throw e;
				}
				// If element truly not found, negative check passes.
			}
		}
	}

	/**
	 * Check if an element is displayed.
	 */
	public boolean isElementDisplayed(String elementName) throws Exception {
		return getElementWithWait(this, elementName).isDisplayed();
	}

	/**
	 * Verify exact text match or mismatch.
	 */
	public void checkElementText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			Assert.assertEquals("Text mismatch for element: " + elementName, expected, elementText);
		} else {
			Assert.assertNotEquals("Unexpected matching text for element: " + elementName, expected, elementText);
		}
	}

	/**
	 * Verify partial text containment or non-containment.
	 */
	public void checkElementpartialText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			Assert.assertTrue(
					"Expected element '" + elementName + "' to contain '" + expected + "', but actual text was: " + elementText,
					elementText.toLowerCase().contains(expected.toLowerCase())
			);
			System.out.println("==========================================================");
			System.out.println("Actual: " + elementText);
			System.out.println("==========================================================");
		} else {
			Assert.assertFalse(
					"Expected element '" + elementName + "' not to contain '" + expected + "', but actual text was: " + elementText,
					elementText.toLowerCase().contains(expected.toLowerCase())
			);
		}
	}

	/**
	 * Get visible element text.
	 */
	public String getElementWithWaitText(String elementName) throws Exception {
		return getElementWithWait(this, elementName).getText();
	}

	/**
	 * Wait for an element to disappear.
	 */
	public void wait_Element_Disappear(String elementName) throws Exception {
		List<WebElement> elements = new ArrayList<>();
		elements.add(getElement(this, elementName));
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	/**
	 * Verify page title.
	 */
	public void checkTitle(String title, boolean testCase) throws Exception {
		String pageTitle = webDriverProvider.get().getTitle();

		if (testCase) {
			Assert.assertEquals("Page title mismatch", title, pageTitle);
		} else {
			Assert.assertNotEquals("Page title should not match", title, pageTitle);
		}
	}

	/**
	 * Verify attribute value.
	 */
	public void checkElementAttribute(String elementName, String attributeName, String attributeValue, boolean testCase)
			throws Exception {
		String attrVal = getElementAttribute(elementName, attributeName);

		if (testCase) {
			Assert.assertEquals(
					"Attribute mismatch for element: " + elementName + ", attribute: " + attributeName,
					attributeValue,
					attrVal
			);
		} else {
			Assert.assertNotEquals(
					"Attribute should not match for element: " + elementName + ", attribute: " + attributeName,
					attributeValue,
					attrVal
			);
		}
	}

	/**
	 * Get element attribute value.
	 */
	public String getElementAttribute(String elementName, String attributeName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.getAttribute(attributeName);
	}

	/**
	 * Check if xpath returns any elements.
	 */
	public boolean isElementPresent(String xpath) {
		try {
			return webDriverProvider.get().findElements(By.xpath(xpath)).size() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Verify enabled / disabled state correctly.
	 * This was one of the important fixes because the old logic could pass when it should fail.
	 */
	public void checkElementEnable(String elementName, boolean shouldBeEnabled) throws Exception {
		boolean actual = isElementEnabled(elementName);
		Assert.assertEquals("Wrong enabled/disabled state for element: " + elementName, shouldBeEnabled, actual);
	}

	/**
	 * Return enabled state of an element.
	 */
	public boolean isElementEnabled(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.isEnabled();
	}

	/**
	 * Verify checkbox checked / unchecked state correctly.
	 * This was one of the important fixes for Maven failure propagation.
	 */
	public void isCheckboxChecked(String elementName, boolean shouldBeChecked) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		Assert.assertEquals("Wrong checkbox state for element: " + elementName, shouldBeChecked, checkbox.isSelected());
	}

	/**
	 * Verify radio button selected / unselected state correctly.
	 * This was one of the important fixes for Maven failure propagation.
	 */
	public void isRadioButtonSelected(String elementName, boolean shouldBeSelected) throws Exception {
		WebElement radioButton = getElementWithWait(this, elementName);
		Assert.assertEquals("Wrong radio button state for element: " + elementName, shouldBeSelected, radioButton.isSelected());
	}

	// ********************************************************************************************************
	// **************************************** UI Interaction *************************************************
	// ********************************************************************************************************

	/**
	 * Scroll page to top or end.
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
		} else {
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
		}
	}

	/**
	 * Scroll until a specific element is visible.
	 */
	public void scrollToElement(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		JavascriptExecutor executor = (JavascriptExecutor) webDriverProvider.get();
		executor.executeScript("arguments[0].scrollIntoView();", element);
		log.info("I scroll to '" + elementName + "'");
	}

	/**
	 * Hover over a specific element.
	 */
	public void hoverOverElement(String elementName) throws Exception {
		Actions action = new Actions(webDriverProvider.get());
		WebElement element = getElementWithWait(this, elementName);
		action.moveToElement(element).perform();
	}

	/**
	 * Select option from dropdown.
	 * Supports both standard select and input-based dropdown patterns.
	 */
	public void selectOptionFromDropdown(String optionValue, String dropDownListName) throws Exception {
		WebElement dropdown = getElementWithWait(this, dropDownListName);
		dropdown.clear();

		try {
			Select selectList = new Select(dropdown);
			selectList.selectByVisibleText(optionValue);
		} catch (UnexpectedTagNameException e) {
			if (dropdown.getTagName().equalsIgnoreCase("input")) {
				dropdown.click();
				dropdown.clear();
				dropdown.sendKeys(optionValue);
				dropdown.sendKeys(Keys.DOWN);
				dropdown.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
			} else {
				throw new Exception("Element is neither a <select> nor an <input> tag.");
			}
		}
	}

	/**
	 * Select from standard HTML select dropdown.
	 */
	public void selectFromDropdown(String elementName, String valueToSelect) throws Exception {
		WebElement dropdownElement = getElementWithWait(this, elementName);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(valueToSelect);
	}

	/**
	 * Check checkbox if not already selected.
	 */
	public void checkCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Uncheck checkbox if currently selected.
	 */
	public void uncheckCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Select radio button if not already selected.
	 */
	public void selectRadioButton(String elementName) throws Exception {
		WebElement radioButton = getElementWithWait(this, elementName);
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	/**
	 * Accept or dismiss browser alert.
	 */
	public void handleAlert(String decision) {
		if (decision.equals("accept")) {
			webDriverProvider.get().switchTo().alert().accept();
		} else {
			webDriverProvider.get().switchTo().alert().dismiss();
		}
	}

	/**
	 * Fetch values from specific row xpaths and ensure there are no duplicates.
	 */
	public List<String> getValuesFromXpaths(int rowCount) throws Exception {
		List<String> values = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			String xpath = "//*[@id='ctl00_MainContent_RadGrid1_ctl00__" + i + "']/td[2]";
			WebElement element = webDriverProvider.get().findElement(By.xpath(xpath));
			String text = element.getText().trim();

			if (values.contains(text)) {
				throw new Exception("Duplicate value found: " + text);
			}

			values.add(text);
		}

		System.out.println("Fetched values from xpaths:");
		for (String value : values) {
			System.out.println(value);
		}

		return values;
	}

	/**
	 * Select a value from combo box by typing and confirming with keyboard.
	 */
	public void selectFromComboBox(String elementName, String value) throws Exception {
		WebElement comboBox = getElementWithWait(this, elementName);
		comboBox.click();
		comboBox.clear();
		comboBox.sendKeys(value);
		comboBox.sendKeys(Keys.DOWN);
		comboBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	// ********************************************************************************************************
	// **************************************** Tab Handling ***************************************************
	// ********************************************************************************************************

	/**
	 * Switch to the newly opened browser tab.
	 */
	public void switchToNewTab() {
		ArrayList<String> tabs = new ArrayList<>(webDriverProvider.get().getWindowHandles());
		webDriverProvider.get().switchTo().window(tabs.get(1));
	}

	/**
	 * Close the latest tab and return to the first available tab.
	 */
	public void closeLatestTabAndReturnToFirstTab() {
		WebDriver driver = webDriverProvider.get();

		Set<String> allTabs = driver.getWindowHandles();
		List<String> tabs = new ArrayList<>(allTabs);

		if (tabs.size() > 1) {
			try {
				String latestTab = tabs.get(tabs.size() - 1);

				if (driver.getWindowHandles().contains(latestTab)) {
					driver.switchTo().window(latestTab);
					driver.close();

					allTabs = driver.getWindowHandles();
					tabs = new ArrayList<>(allTabs);

					if (!tabs.isEmpty()) {
						driver.switchTo().window(tabs.get(0));
					}
				} else {
					System.err.println("Error: The latest tab handle is no longer valid.");
					if (!tabs.isEmpty()) {
						driver.switchTo().window(tabs.get(0));
					}
				}
			} catch (NoSuchWindowException e) {
				System.err.println("Error: The target window is already closed.");
				allTabs = driver.getWindowHandles();
				tabs = new ArrayList<>(allTabs);
				if (!tabs.isEmpty()) {
					driver.switchTo().window(tabs.get(0));
				}
			}
		} else {
			System.out.println("No additional tabs to close.");
		}
	}
}