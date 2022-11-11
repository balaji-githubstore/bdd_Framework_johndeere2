package com.johndeere.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.cssSelector("input[name='password']");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By errorLocator = By.xpath("//p[contains(@class,'oxd-alert-content')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}

	public void waitForPresenceOfUsername() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
	}

}
