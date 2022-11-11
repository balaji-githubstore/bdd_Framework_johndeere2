package com.johndeere.steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.johndeere.base.AutomationHooks;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {

	private static DataTable empDatatable;

	private AutomationHooks hooks;

	public EmployeeSteps(AutomationHooks hooks) {
		this.hooks = hooks;
	}

	@When("I click on PIM menu")
	public void i_click_on_pim_menu() {
		hooks.driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@When("I click on Add Employee")
	public void i_click_on_add_employee() {
		hooks.driver.findElement(By.linkText("Add Employee")).click();
	}

	@When("I fill the new employee details")
	public void i_fill_the_new_employee_details(DataTable dataTable) {
		empDatatable = dataTable;
		List<Map<String, String>> lists = dataTable.asMaps();

//		System.out.println(lists);
//		System.out.println(lists.get(0));
//		System.out.println(lists.get(0).get("firstname"));
//		System.out.println(lists.get(0).get("middlename"));
//		System.out.println(lists.get(0).get("lastname"));

		String fName = lists.get(0).get("firstname");
		String mName = lists.get(0).get("middlename");

		hooks.driver.findElement(By.name("firstName")).sendKeys(fName);
		hooks.driver.findElement(By.name("middleName")).sendKeys(mName);
		hooks.driver.findElement(By.name("lastName")).sendKeys(lists.get(0).get("lastname"));
	}

	@When("I click on save employee")
	public void i_click_on_save_employee() {
		hooks.driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("I should see the added name under personal details page")
	public void i_should_see_the_added_name_under_personal_details_page() throws InterruptedException {
		
		// accessing the datatable comes in previous when annotation
		List<Map<String, String>> lists = empDatatable.asMaps();
		
		WebDriverWait wait = new WebDriverWait(hooks.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Emergency Contacts']")));
		wait.until(ExpectedConditions.attributeContains(By.name("firstName"),"value",lists.get(0).get("firstname")));
		
		String actualFirstName = hooks.driver.findElement(By.name("firstName")).getAttribute("value");
		Assert.assertEquals(actualFirstName, lists.get(0).get("firstname"));
	}

}




