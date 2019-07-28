package com.toptal.apiautomation.serenity.steps;

import org.json.JSONObject;

import com.toptal.apiautomation.facilities.Facilitator;

import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;

public class LoginSteps extends Facilitator{
	
	@Step
	public void loginRequest(String email, String pass) {
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", email);
		requestParam.put("password", pass);	
		request.body(requestParam.toString());
		response = request.post("/login");
	}
	
	@Step
	public JsonPath getResponseBodyAfterLogin() {
		return response.jsonPath();
	}

}
