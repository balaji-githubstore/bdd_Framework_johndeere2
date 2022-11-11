package com.johndeere.steps;

import java.time.Duration;
import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.johndeere.base.AutomationHooks;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private AutomationHooks hooks;
	private LoginPage loginPage;
	private MainPage mainPage;

	public LoginSteps(AutomationHooks hooks) {
		this.hooks = hooks;
	}

	public void initPageObject() {
		loginPage = new LoginPage(hooks.driver);
		mainPage = new MainPage(hooks.driver);
	}

	@Given("I have browser with Orange HRM application")
	public void i_have_browser_with_orange_hrm_application() {
		hooks.driver = new ChromeDriver();
		hooks.driver.manage().window().maximize();
		hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hooks.driver.get("https://opensource-demo.orangehrmlive.com/");

		initPageObject();
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {

		loginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickOnLogin();
	}

	@Then("I should access the dashboard page with url {string}")
	public void i_should_access_the_dashboard_page_with_url(String expectedUrl) {
		String actualUrl = mainPage.getMainPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Then("I should not access to portal with error message as {string}")
	public void i_should_not_access_to_portal_with_error_message_as(String expectedError) {
		String actualError = loginPage.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}

}
