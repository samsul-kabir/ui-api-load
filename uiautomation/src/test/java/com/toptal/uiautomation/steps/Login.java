package com.toptal.uiautomation.steps;

import java.io.IOException;

import org.junit.Assert;

import com.cucumber.listener.Reporter;
import com.toptal.uiautomation.setup.Setup;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Login extends Setup {

	@After
	public void takeScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			log.info("Screenshot taken: {}", screenshotName);
			util.captureScreenshot(driver, screenshotName);
			Reporter.addScreenCaptureFromPath("../Screenshots/"+ screenshotName + ".png");	
		}
	}
	
	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
		startNavigation();
	}

	@When("^User enter username \"([^\"]*)\"$")
	public void user_enter_username(String username) throws Throwable {
		loginPage.enterUsername(username);
	}

	@And("^User enter password \"([^\"]*)\"$")
	public void user_enter_password(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@And("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickOnLogin();
	}

	@Then("^User can access the application$")
	public void user_can_access_the_application() throws Throwable {
		util.waitForElement(homePage.getLocatorHomePageTitle());
		String text = homePage.getHomePageTitleText();
		Assert.assertEquals(text, "Selected Node");
	}

	@Then("^User will see error message$")
	public void user_will_see_error_message() throws Throwable {
		String text = loginPage.getErrorMessage();
		Assert.assertEquals(text, "Wrong Credentials");
	}

}
