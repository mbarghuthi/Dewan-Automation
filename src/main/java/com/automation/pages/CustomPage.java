package com.automation.pages;

import com.automation.configuration.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@PageObject
public class CustomPage extends AbstractPage<CustomPage> {
    @FindBy(xpath = "//input[@id='tbxUserName']")
    public WebElement adminUserName;
    @FindBy(xpath = "//input[@id='tbxPassword']")
    public WebElement adminPassword;
    @FindBy(css = "#btnLogin2")
    public WebElement loginAdminButton;



    @FindBy(css = "#ctl00_MainContent_rbOnSaveDraft")
    public WebElement SaveDraftOnRadioButton;



//    @FindBy(css = "#ctl00_MainContent_rdONMandatory")
    @FindBy(id = "ctl00_MainContent_rdONMandatory")
    public WebElement MandatoryCheckbox;

    @FindBy(css = "#ctl00_MainContent_GVViewData_ctl07_HyperLink3")
    public WebElement EditIncomingMailAttachment;


    @FindBy(xpath = "//span[contains(text(),'جميع المهام')]")
    public WebElement AllTaskHeaderButton;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl02_ImgMassAction\"]")
    public WebElement MassActionButton;
    /**
     * Method to enter text into text field
     *
     * @param elementName : String : element Name
     * @param text        : String : Text value to enter in field
     * @throws Exception
     */
    public CustomPage enterText(String elementName, String text) throws Exception {
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
    public CustomPage click(String elementName) throws Exception {
        // wait element
        WebElement element = getElementWithWait(this, elementName);
        element.click();
//		Actions actions = new Actions(webDriverProvider.get());
//		actions.moveToElement(element).click().perform();
        log.info("Clicked on '" + elementName + "'");
        return this;
    }

    public void checkRadioButton(String elementName, boolean shouldBeChecked) throws Exception {
        WebElement radioButton = getElementWithWait(this, elementName);

        // Check if the radio button needs to be clicked or left as is
        if (shouldBeChecked && !radioButton.isSelected()) {
            radioButton.click();
        }

        // Verify if the radio button's state matches the expected state
        Assert.assertEquals("Radio button state does not match the expected state", shouldBeChecked, radioButton.isSelected());
    }

    public void checkCheckboxButton(String elementName, boolean shouldNotBeChecked) throws Exception {
        WebElement checkbox = getElementWithWait(this, elementName);

        // Check if the checkbox needs to be clicked or left as is
        if (shouldNotBeChecked && checkbox.isSelected()) {
            checkbox.click();
        }

        // Verify if the checkbox's state matches the expected state
        Assert.assertEquals("Checkbox state does not match the expected state", !shouldNotBeChecked, checkbox.isSelected());
    }

    public CustomPage elementToHover(String elementName) throws Exception {
        WebDriver driver = webDriverProvider.get();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.rmRootGroup")));

        if ("User Name Header Button".equalsIgnoreCase(elementName)) {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("ul.rmRootGroup li.profile a.rmLink.rmRootLink")));

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});", element);

            new Actions(driver).moveToElement(element).pause(Duration.ofMillis(150)).perform();
            log.info("Hovered on 'User Name Header Button'");
            return this;
        }

        WebElement el = getElementWithWait(this, elementName);
        new Actions(driver).moveToElement(el).perform();
        log.info("Hovered on '" + elementName + "'");
        return this;
    }


    public int countRowsWithoutImage(int rowCount) throws Exception {
        int count = 0;

        for (int i = 0; i < rowCount; i++) {
            // XPath to find the image with the specified src in the specified cell
            String imgXpath = "//*[@id='ctl00_MainContent_RadGrid1_ctl00__" + i + "']/td[5]//img[@src='http://172.16.30.82:8888/Images/View.png']";

            // Check if the image exists in the specified cell
            List<WebElement> images = webDriverProvider.get().findElements(By.xpath(imgXpath));

            // Only count the row if the image is not present
            if (images.isEmpty()) {
                count++;
            }
        }

        // Print the count of rows without the image
        System.out.println("Count of rows without the specified image: " + count);
        return count;
    }



}