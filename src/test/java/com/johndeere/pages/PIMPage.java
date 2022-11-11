package com.johndeere.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {

	private By addEmployeeLocator=By.linkText("Add Employee");
	
	private WebDriver driver;

	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnAddEmployee() {
		driver.findElement(addEmployeeLocator).click();
	}
	
}
