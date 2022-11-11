package com.johndeere.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.johndeere.base.AutomationWrapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPetTest extends AutomationWrapper {
	
	
	@Test
	public void addValidPetTest() {
		
		String resource="pet";
		
		RestAssured
		.given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"id\": 1006,\r\n"
				+ "    \"category\": {\r\n"
				+ "        \"id\": 0,\r\n"
				+ "        \"name\": \"string\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie-1006\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "        \"string\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 0,\r\n"
				+ "            \"name\": \"string\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"available\"\r\n"
				+ "}")
		.when().post(baseUrl+resource)
		.then().statusCode(200);
		
	}
	
	@Test
	public void addValidPetFromJsonTest() throws FileNotFoundException {
		
		FileInputStream file=new FileInputStream("test-data/pet.json");
		
		JsonPath json=new JsonPath(file);
		String body=json.prettify();
		
		String resource="pet";
		
		RestAssured
		.given().header("Content-Type","application/json").body(body)
		.when().post(baseUrl+resource)
		.then().statusCode(200);
		
	}
	
	
	@Test
	public void updateValidPetFromJsonTest() throws FileNotFoundException {
		
		FileInputStream file=new FileInputStream("test-data/pet2.json");
		
		JsonPath json=new JsonPath(file);
		String body=json.prettify();
		
		String resource="pet";
		
		RestAssured
		.given().header("Content-Type","application/json").body(body)
		.when().put(baseUrl+resource)
		.then().statusCode(200);
		
	}
	
	
	@Test
	public void deletePetByIdTest()
	{
		String resource="pet/"+2005;
		
		RestAssured
		.given()
		.when().delete(baseUrl+resource)
		.then().log().all().statusCode(200);
	}
	

}
