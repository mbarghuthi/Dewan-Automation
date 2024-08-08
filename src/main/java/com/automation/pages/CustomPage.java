package com.automation.pages;

import com.automation.configuration.pageobjects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class CustomPage extends AbstractPage<CustomPage> {
    @FindBy(css = "//input[@id='tbxUserName']")
    public WebElement adminUserName;
    @FindBy(css = "//input[@id='tbxPassword']")
    public WebElement adminPassword;
    @FindBy(css = "#btnLogin2")
    public WebElement loginAdminButton;

    @FindBy(xpath = "//*[@id=\"ctl00_li12\"]/a")
    public WebElement ProcessModuleButton;
    @FindBy(css = "#ctl00_Process")
    public WebElement ProcessSubmoduleButton;
    @FindBy(css = "#ctl00_MainContent_GVViewData_ctl02_lnkOption")
    public WebElement InternalCorrespondenceOptions;

    @FindBy(css = "#ctl00_MainContent_rbOnSaveDraft")
    public WebElement SaveDraftOnRadioButton;
    @FindBy(css = "#ctl00_MainContent_txtSaveDraftAR")
    public WebElement SaveDraftArabicCaption;
    @FindBy(css = "#ctl00_MainContent_txtSaveDraftEN")
    public WebElement SaveDraftEnglishCaption;

    @FindBy(css = "#ctl00_MainContent_ImgUpdate")
    public WebElement UpdateButton;
    @FindBy(css = "#ctl00_MainContent_ImgBack")
    public WebElement BackButton;

    @FindBy(xpath = "//span[contains(text(),'FORM DESIGN')]")
    public WebElement FormDesignModuleButton;
    @FindBy(css = "#ctl00_FormControls")
    public WebElement ContentOfFormSubmoduleButton;
    @FindBy(css = "#ctl00_MainContent_DdlForm")
    public WebElement FormDropDownList;

    @FindBy(css = "#ctl00_MainContent_GVViewData_ctl05_HyperLink3")
    public WebElement EditOutgoingMailAttachment;
    @FindBy(css = "#ctl00_MainContent_rdONMandatory")
    public WebElement MandatoryCheckbox;

    @FindBy(css = "#ctl00_MainContent_GVViewData_ctl07_HyperLink3")
    public WebElement EditIncomingMailAttachment;

	
}