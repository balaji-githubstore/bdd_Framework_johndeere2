package com.johndeere.base;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class AutomationWrapper {
	protected String baseUrl;

	@BeforeTest
	@Parameters({ "baseurl" })
	public void setUrl(@Optional("https://petstore.swagger.io/v2/") String url) {
		baseUrl = url;
	}

}
