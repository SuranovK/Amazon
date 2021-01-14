package com.automation.tests.api;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssertApiRespondBody {
	@BeforeMethod
	public void setUp() {
		baseURI = "http://dummy.restapiexample.com/";
		basePath = "api/v1";
	}

	@Test(description = "nnnm")
	public void validateRespond() {
		given()
		.relaxedHTTPSValidation()
		.when()
				.log().all().get("/employee/1").then().statusCode(200).header("Content-Type", "application/json")
				.body("id", hasSize(1)).body("employee_name", hasItem("Tiger Nixon"))
				.body("employee_salary", hasItem(320800)).body("employee_age", hasItem(61))
		;
	}

	@Test
	public void deleteData() {
		RequestSpecification requestSpecification = given();
		requestSpecification.header("Content-Type", "application/json");

		Response response = requestSpecification.delete("/delete/" + 1);

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);

		String jsonString = response.asString();
		Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);

	}
}
