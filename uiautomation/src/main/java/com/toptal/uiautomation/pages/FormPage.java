package com.toptal.uiautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toptal.uiautomation.base.BasePage;


public class FormPage extends BasePage {

	public FormPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "treeview-1025-record-validationForm")
	private WebElement formLink;

	@FindBy(css = "#validationForm-1031-innerCt table label")
	private List<WebElement> fieldTitle;

	@FindBy(css = "#validationForm-1031-innerCt table input")
	private List<WebElement> inputField;

	@FindBy(css = "#toolbar-1055-targetEl a.x-item-disabled.x-disabled.x-btn-disabled.x-btn-default-toolbar-small-disabled")
	private List<WebElement> disabledSaveButton;

	@FindBy(id = "button-1058")
	private WebElement saveButton;

	@FindBy(css = ".x-boundlist-item")
	private WebElement itemDropDown;

	@FindBy(css = "#gridview-1048-body tr:nth-child(1) div.x-grid-cell-inner")
	private List<WebElement> tableUnderForm;

	public void clickOnForm() {
		clickOnButton(formLink);
	}

	public List<WebElement> getFieldTitle() {
		return fieldTitle;
	}

	public Boolean isSaveButtonDisabled() {
		return disabledSaveButton.size() > 0;
	}
	
	public void enterValueInoAllTextField(String title, String firstName, String lastName, String age, String manufacture) {
		enterIntoTextField(inputField.get(0), title);
		enterIntoTextField(inputField.get(1), firstName);
		enterIntoTextField(inputField.get(2), lastName);
		enterIntoTextField(inputField.get(3), age);
		enterIntoTextField(inputField.get(4), manufacture);
	}
	

	public void clickOnSaveButton() {
		clickOnButton(saveButton);
	}

	public void selectFromDropDown() {
		clickOnButton(itemDropDown);
	}

	public List<WebElement> returnFirstRowData() {
		return tableUnderForm;
	}

	public By getLocatorFieldTitle() {
		return By.cssSelector("#validationForm-1031-innerCt table label");
	}

	public By getLocatorDropDowntoUpdate() {
		return By.cssSelector(".x-boundlist-item");
	}

}
