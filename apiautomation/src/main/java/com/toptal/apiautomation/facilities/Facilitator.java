package com.toptal.apiautomation.facilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class Facilitator {

	protected static Response response;
	protected static RequestSpecification request;

	public void setup() {
		RestAssured.baseURI = "https://reqres.in/api";
		request = SerenityRest.given();
		request.header("Content-Type", "application/json");
	}

	public int getStatusCode() {
		return response.statusCode();
	}

}
