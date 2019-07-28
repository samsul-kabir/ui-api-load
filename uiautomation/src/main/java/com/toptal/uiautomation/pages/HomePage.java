package com.toptal.uiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toptal.uiautomation.base.BasePage;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#displayfield-1028-labelEl > b")
	private WebElement homePageTitle;

	public String getHomePageTitleText() {
		return returnText(homePageTitle);
	}

	public By getLocatorHomePageTitle() {
		return By.cssSelector("#displayfield-1028-labelEl > b");
	}

}
