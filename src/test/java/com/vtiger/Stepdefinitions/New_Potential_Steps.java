package com.vtiger.Stepdefinitions;

import com.vtiger.pages.Potential_Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class New_Potential_Steps extends BaseTest{

	@Before
	public void getScenario(Scenario scenario)
	{
		initiation();
		vTCName = scenario.getName();
		logger=extent.createTest(vTCName);
	}
	@After
	public void savereport()
	{
		extent.flush();
	}
	
	@Then("user click on New_Potential link")
	public void user_click_on_new_potential_link() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.click_New_Potential();
	}
	
	@Then("verify that potentialname is enabled")
	public void verify_that_potentialname_is_enabled() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.potentialname();
	}
	@Then("verify that account name should not be enabled")
	public void verify_that_account_name_should_not_be_enabled() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.Account_Name_Enabled();
	}
	@Then("Verify that Account name search field is clickable")
	public void verify_that_account_name_search_field_is_clickable() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.Account_name_search_field();
	}

	@Then("verify that Account Search inside Account Name is enabled by entering name")
	public void verify_that_account_search_inside_account_name_is_enabled_by_entering_name() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.Account_Name();
	}
	
	
	@Then("verify thar Account search inside Cityfield is enabled by entring city name")
	public void verify_thar_account_search_inside_cityfield_is_enabled_by_entring_city_name() {
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.City_Field();
	}
	
	@Then("verify that search button is able to search")
	public void verify_that_search_button_is_able_to_search()
	{
		Potential_Page PTP= new Potential_Page(driver,logger);
		PTP.search_button_validition();
	}


	
}
