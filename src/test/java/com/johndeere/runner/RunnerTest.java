package com.johndeere.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//features = {"src/test/resources/feature/Login.feature","src/test/resources/feature/Employee.feature"}
		features = {"src/test/resources/feature"}
		,glue = {"com.johndeere.steps","com.johndeere.base"}
		,monochrome = true
		,publish = false
		,plugin = {"html:target/cucumber-report.html"}
		//,dryRun = true
		//,tags = "(not @login) and @smoke"
		,tags = "@employee"
		)


public class RunnerTest extends AbstractTestNGCucumberTests{

}

