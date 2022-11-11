package com.johndeere.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johndeere.base.AutomationWrapper;

import io.restassured.RestAssured;
//get request with path parameter 
public class FindPetTest extends AutomationWrapper{
	
	
	
	@Test
	public void findValidPetByIdTest()
	{
		String resource="pet/"+1006;
		
		RestAssured
		.given()
		.when().get(baseUrl+resource)
		.then().log().all().statusCode(200);
	}
	
	@Test
	public void findInvalidPetByIdTest()
	{
		String resource="pet/"+1005;
		
		RestAssured
		.given()
		.when().get(baseUrl+resource)
		.then().statusCode(404);
	}
	
	@Test
	public void validateResponseFromPetByIdTest()
	{
		String resource="pet/"+1006;
		
		String response=RestAssured
							.given()
							.when().get(baseUrl+resource)
							.then().statusCode(200).extract().asString();
		
		System.out.println(response);
		
		Assert.assertTrue(response.contains("10")); //expect true
		Assert.assertTrue(response.contains("doggie"));
	}
	
	@Test
	public void validateResponseFromPetNotFoundTest()
	{
		String resource="pet/"+1005;
		
		String res=RestAssured
		.given()
		.when().get(baseUrl+resource)
		.then().statusCode(404).extract().asString();
		
		Assert.assertTrue(res.contains("Pet not found"));
	}

}
