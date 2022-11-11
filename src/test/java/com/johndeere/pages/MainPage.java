package com.johndeere.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handles all menu
public class MainPage {
	
	private By pimLocator = By.xpath("//span[text()='PIM']");
	private By adminLocator=By.xpath("//span[text()='Admin']");

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPIM() {
		driver.findElement(pimLocator).click();
	}
	
	public void clickOnAdmin() {
		driver.findElement(adminLocator).click();
	}
	
	public String getMainPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void waitForPresenceOfPIMMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(pimLocator));
	}

}
