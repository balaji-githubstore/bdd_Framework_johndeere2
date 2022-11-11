package com.johndeere.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationHooks {
	
	public WebDriver driver;
	
	
	@After
	public void endScenario()
	{
		driver.quit();
	}

}
