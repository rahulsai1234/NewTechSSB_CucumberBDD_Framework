package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Features",
		glue = "com.vtiger.Stepdefinitions",
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports.html"}
		//dryRun = true
				,tags= "@Lead_creation or @Potential"
				//,dryRun = false,
				//tags = "@Lead_creation"
				//,tags="@Potential"
		        //,tags="@GetAPI"
		        //,tags="New_Note"
		
		)
public class TestRunner {

}
