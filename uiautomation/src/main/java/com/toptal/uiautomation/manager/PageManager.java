package com.toptal.uiautomation.manager;

import org.openqa.selenium.WebDriver;

import com.toptal.uiautomation.pages.FormPage;
import com.toptal.uiautomation.pages.HomePage;
import com.toptal.uiautomation.pages.LoginPage;
import com.toptal.uiautomation.util.Utils;

public class PageManager {
	private WebDriver driver;
	private LoginPage ln;
	private HomePage hm;
	private FormPage fm;
	private Utils util;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (ln == null) {
			ln = new LoginPage(driver);
		}
		return ln;
	}

	public HomePage getHomePage() {
		if (hm == null) {
			hm = new HomePage(driver);
		}
		return hm;
	}
	
	public FormPage getFormPage() {
		if (fm == null) {
			fm = new FormPage(driver);
		}
		return fm;
	}
	
	public Utils getUtil() {
		if (util == null) {
			util = new Utils(driver);
		}
		return util;
	}
}
