package com.johndeere.test;

import org.testng.annotations.Test;

import com.johndeere.base.AutomationWrapper;

import io.restassured.RestAssured;

public class FindPetByStatusTest extends AutomationWrapper {
	
	
	@Test
	public void findValidPetByStatusTest()
	{
		String resource="pet/findByStatus";
		
		RestAssured
		.given().queryParam("status", "sold")
		.when().get(baseUrl+resource)
		.then().statusCode(200);
	}
	
	@Test
	public void findValidPetByStatusResponseTest()
	{
		String resource="pet/findByStatus";
		
		String res=RestAssured
		.given().queryParam("status", "sold")
		.when().get(baseUrl+resource)
		.then().statusCode(200).extract().asString();
		
		System.out.println(res);
	}

}
