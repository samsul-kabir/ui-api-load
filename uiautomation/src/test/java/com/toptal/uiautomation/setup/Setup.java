package com.toptal.uiautomation.setup;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.toptal.uiautomation.manager.PageManager;
import com.toptal.uiautomation.pages.FormPage;
import com.toptal.uiautomation.pages.HomePage;
import com.toptal.uiautomation.pages.LoginPage;
import com.toptal.uiautomation.util.ConvertToSlack;
import com.toptal.uiautomation.util.Utils;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Setup extends AbstractTestNGCucumberTests {
	protected static WebDriver driver;
	protected static PageManager pageManager;
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static FormPage formPage;
	protected static Utils util;

	public static String getBrowser() {
		return System.getProperty("browser");
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		return chromeOptions;
	}

	public static WebDriver createWebDriver() {
		switch (getBrowser()) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		case "headless":
			return new ChromeDriver(chromeOption());
		default:
			throw new RuntimeException("Unsupported webdriver: " + getBrowser());
		}
	}

	@BeforeSuite
	public void startDriver() {
		driver = createWebDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		if (!getBrowser().equals("headless")) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(),
					(int) toolkit.getScreenSize().getHeight());
			driver.manage().window().setSize(screenResolution);
		}

		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		homePage = pageManager.getHomePage();
		formPage = pageManager.getFormPage();
		util = pageManager.getUtil();
	}

	@AfterSuite
	public void stopDriver() throws IOException {
		driver.manage().deleteAllCookies();
		driver.quit();
		
		ConvertToSlack slackReport = new ConvertToSlack();
		slackReport.sendReportToSlack("./target/cucumber.json", "/services/TLEGPJRQR/BLLCYGCF6/hIRwB4mVzSlLY04aocvi5cvO", System.getenv("BUILD_URL") + "cucumber-html-reports/overview-features.html");
		
		log.info("Jenkins EXECUTOR_NUMBER: {}", System.getenv("EXECUTOR_NUMBER"));
		log.info("Jenkins JENKINS_URL: {}", System.getenv("JENKINS_URL"));
		log.info("Jenkins BUILD_ID: {}", System.getenv("BUILD_ID"));
		log.info("Jenkins BUILD_URL: {}", System.getenv("BUILD_URL"));
		log.info("Jenkins BUILD_NUMBER: {}", System.getenv("BUILD_NUMBER"));
		log.info("Jenkins JOB_NAME: {}", System.getenv("JOB_NAME"));
	}

	public void startNavigation() throws InterruptedException {
		driver.get("file://" + System.getProperty("user.dir") + "/TestApplication/index.html");
	}
}
