package com.toptal.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toptal.uiautomation.base.BasePage;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "user")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(id = "button-1015")
	private WebElement loginButton;

	@FindBy(id = "messagebox-1001-displayfield-inputEl")
	private WebElement errorMessage;

	public void enterUsername(String user) {
		enterIntoTextField(username, user);
	}

	public void enterPassword(String pass) {
		enterIntoTextField(password, pass);
	}

	public void clickOnLogin() {
		clickOnButton(loginButton);
	}

	public String getErrorMessage() {
		return returnText(errorMessage);
	}

}
