package com.toptal.apiautomation.stepDefinations;

import org.junit.Assert;

import com.toptal.apiautomation.serenity.steps.LoginSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;

@Slf4j
public class LoginTest {

	@Steps
	LoginSteps loginSteps;

	@Given("^I have baseUrl for rest service$")
	public void user_wants_to_execute_rest_service() {
		loginSteps.setup();
	}

	@When("^User submit login reguest with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_submit_login_reguest_with_an(String email, String pass) {
		loginSteps.loginRequest(email, pass);
	}

	@Then("^It returns correct (\\d+)$")
	public void it_returns_correct(int statusCode) {
		log.info("Stutus code: {}", loginSteps.getStatusCode());
		//Assert.assertEquals(statusCode, loginSteps.getStatusCode());
		Assert.assertEquals(statusCode, loginSteps.getStatusCode());
	}

	@And("^Response has token if succeed$")
	public void response_has_if_succeed() {
		if (loginSteps.getStatusCode() == 200) {
			String token = loginSteps.getResponseBodyAfterLogin().get("token").toString();
			log.info("Stutus code: {}", token);
			Assert.assertTrue("Token should be all one word", !token.contains("Missing "));
		} else {
			String error = loginSteps.getResponseBodyAfterLogin().get("error").toString();
			log.info("Stutus code: {}", error);
			Assert.assertTrue("Error message does not have Missing word in it", error.contains("Missing "));
		}
	}
}
