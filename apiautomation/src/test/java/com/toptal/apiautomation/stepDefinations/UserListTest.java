package com.toptal.apiautomation.stepDefinations;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.toptal.apiautomation.model.UserData;
import com.toptal.apiautomation.model.UserList;
import com.toptal.apiautomation.serenity.steps.UserListSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;

@Slf4j
public class UserListTest {

	UserList userList;

	@Steps
	UserListSteps userListSteps;

	@When("^I execute service for user list$")
	public void i_execute_service_for_user_list() {
		userListSteps.UserListRequest();
	}

	@Then("^I validate statuscode$")
	public void i_validate_statuscode() {
		log.info("Stutus code: {}", userListSteps.getStatusCode());
		Assert.assertEquals(userListSteps.getStatusCode(), 200);
	}

	@And("^I verify all id inside data is not NULL$")
	public void i_verify_all_id_inside_data_is_not_NULL() throws JsonParseException, JsonMappingException, IOException {
		userList = userListSteps.mapUserListToModel();
		for (UserData userData : userList.getData()) {
			log.info("id : {}", userData.getId());
			Assert.assertNotNull(userData.getId());
		}
	}

	@And("^I also validate all url in avatar has success statuscode$")
	public void i_also_validate_all_url_in_avatar_has_success_statuscode() {
		for (UserData userData : userList.getData()) {
			log.info("avatar : {}", userData.getAvatar());
			Assert.assertNotNull(userData.getAvatar());
			given().when().get(userData.getAvatar()).then().statusCode(200);
		}
	}
	
	@When("^I execute service for single user with (\\d+)$")
	public void i_execute_service_for_single_user_with(int id) {
		userListSteps.singleUserRequest(id);
	}


	@Then("^Single user response has correct (\\d+)$")
	public void single_user_response_has_correct(int statuscode) {
		log.info("Stutus code: {}", userListSteps.getStatusCode());
		Assert.assertEquals(userListSteps.getStatusCode(), statuscode);
	}
}
