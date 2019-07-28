package com.toptal.apiautomation.serenity.steps;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toptal.apiautomation.facilities.Facilitator;
import com.toptal.apiautomation.model.UserList;

import net.thucydides.core.annotations.Step;

public class UserListSteps extends Facilitator {

	@Step
	public void UserListRequest() {
		response = request.get("/users");
	}

	@Step
	public UserList mapUserListToModel() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserList userList = mapper.readValue(response.body().asString(), UserList.class);
		return userList;
	}
	
	@Step
	public void singleUserRequest(int id) {
		response = request.get("/users/" + id);
	}
}
