package com.johndeere.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.johndeere.base.AutomationHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private AutomationHooks hooks;
	
	public LoginSteps(AutomationHooks hooks)
	{
		this.hooks=hooks;
	}
	
	@Given("I have browser with Orange HRM application")
	public void i_have_browser_with_orange_hrm_application() 
	{
		hooks.driver=new ChromeDriver();
		hooks.driver.manage().window().maximize();
		hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hooks.driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) 
	{
		hooks.driver.findElement(By.name("username")).sendKeys(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) 
	{
		hooks.driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	}

	@When("I click on login")
	public void i_click_on_login() 
	{
		hooks.driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("I should access the dashboard page with url {string}")
	public void i_should_access_the_dashboard_page_with_url(String expectedUrl) 
	{
		String actualUrl = hooks.driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Then("I should not access to portal with error message as {string}")
	public void i_should_not_access_to_portal_with_error_message_as(String expectedError) 
	{
		String actualError = hooks.driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
	
}
