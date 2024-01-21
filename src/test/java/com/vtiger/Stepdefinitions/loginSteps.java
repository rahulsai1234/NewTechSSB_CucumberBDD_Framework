package com.vtiger.Stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginSteps extends BaseTest {
	
	
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
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws InterruptedException {
		Thread.sleep(1000);
		//if(driver==null)
		launchApp();
	}
	@When("user enters valid credentials and click on login button")
	public void user_enters_valid_credentials_and_click_on_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(alldata.get(vTCName).get("Userid"), alldata.get(vTCName).get("Password"));
		
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		HomePage hp = new HomePage(driver, logger);
		hp.verifyHomePage();
	}

	@Then("user can see logout link on home page")
	public void user_can_see_logout_link_on_home_page() {
		HomePage hp = new HomePage(driver, logger);
		hp.verifyHomePage();
		hp.clicklogout();
	}
	
	@When("user enters invalid credentials and click on login button")
	public void user_enters_invalid_credentials_and_click_on_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(alldata.get(vTCName).get("Userid"), alldata.get(vTCName).get("Password"));

	}
	
	@Then("user can see the error message on login page")
	public void user_can_see_error_msg() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.verifyErrorMsg();
	}
	
	@Then("verify application title")
	public void validateTitle() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.verifyTitle(alldata.get(vTCName).get("ExpTitle"));
	}
	
	@When("user enters userid as {string} and password as {string} click on login button")
	public void user_enters_userid_as_and_password_as_click_on_login_button(String string, String string2) {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(string, string2);
	}

	@Then("user click on New Lead link")
	public void user_click_on_new_lead_link() {
		HomePage hp = new HomePage(driver, logger);
		hp.clickNewLead();
	}

	@Then("verify the FirstName Salutation count is {int}")
	public void verify_the_first_name_salutation_count_is(Integer int1) {

		HomePage hp = new HomePage(driver, logger);
		hp.click_salutation_type();
		int Expt_Size = 6;
		Select select = new Select(driver.findElement(By.name("salutationtype")));
		List<WebElement> lst = select.getOptions();
		for(WebElement options: lst)
			System.out.println(options.getText());
		    int Actual_Size =lst.size();
			System.out.println(Actual_Size);
		Assert.assertEquals(Expt_Size,Actual_Size);
		System.out.println("Expt_Size and Actual_Size is got matched.");
	}

	@Then("User can select single Salutation")
	public void user_can_select_single_salutation() {
		HomePage hp = new HomePage(driver, logger);
		hp.click_salutation_type();
		Select select = new Select(driver.findElement(By.name("salutationtype")));
		select.getOptions();
		select.selectByIndex(2);

	}


	@Then("verify that FirstName field is Enabled")
	public void verify_that_first_name_field_is_Enabled() {
		HomePage hp = new HomePage(driver, logger);
		hp.click_FirstName_TextField();
	}

	@Then("Verify that FirstName field maximum number of characters supported")
	public void verify_that_first_name_field_maximum_number_of_characters_supported()
	{
		HomePage hp = new HomePage(driver, logger);
		hp.FirstName_TextField_count();
	}

    @Then("verify that Last_Name field is Enabled")
    public void verify_that_last_name_field_is_enabled()
	{
	HomePage hp = new HomePage(driver, logger);
	hp.Last_name_Enabled();
    }
	@Then("Verify that Last_Name field maximum number of characters supported")
	public void verify_that_last_name_field_maximum_number_of_characters_supported()
	{
		HomePage hp = new HomePage(driver, logger);
		hp.Last_Name_TextField();
	}

	@Then("Verify that Last_Name field accept duplicate character,special symbols,Special sign_..etc")
	public void verify_that_last_name_field_accept_duplicate_character_special_symbols_special_sign_etc() {
		HomePage hp = new HomePage(driver, logger);
		hp.Last_Name_value_Acceptance_Criteria();
	}

	@Then("Verify that Company_Name is Enabled")
	public void verify_that_company_name_is_enabled() {
		HomePage hp = new HomePage(driver, logger);
		hp.Company_Field_is_Enabled();
	}
	@Then("Verify that Company_Name is Displayed")
	public void verify_that_company_name_is_displayed() {
		HomePage hp = new HomePage(driver, logger);
		hp.Company_Field_is_Displayed();
	}

	@Then("Verify that designation is Enabled")
	public void verify_that_designation_is_enabled() {
		HomePage hp = new HomePage(driver, logger);
		hp.designation_Field_is_Enabled();
	}

	@Then("Check whether leadsource dropdown is selected or not")
	public void check_whether_leadsource_dropdown_is_selected_or_not() {

		HomePage hp = new HomePage(driver, logger);
		hp.leadsource_field_is_dropdown_selected();
	}

	 @Then("Verify that leadsource dropdown count")
       public void verify_that_leadsource_dropdown_count() 
	 {
		 HomePage hp = new HomePage(driver, logger);
		 hp.leadsource_dropdown_count();
     }
	 
	 @Then("Verify that leadsource dropdown values are in sorted order or not")
	 public void verify_that_leadsource_dropdown_values_are_in_sorted_order_or_not() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.leadsource_dropdown_values_sorted();
		 
	 }
	 
	 @Then("Verify that leadsource dropdown single value can be selected")
	 public void verify_that_leadsource_dropdown_single_value_can_be_selected() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.leadsource_dropdown_single_Index_value();
	 }
	 
	 @Then("Check whether industry dropdown is displayed or not")
	 public void check_whether_industry_dropdown_is_displayed_or_not() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.industry_dropdown_is_displayed();
	 }
	 
	 @Then("Verify that industry dropdown count")
	 public void verify_that_industry_dropdown_count() {
			 HomePage hp = new HomePage(driver, logger);
			 hp.industry_dropdown_count();
	 }
	 
	 @Then("Verify that industry dropdown values are in sorted order or not")
	 public void verify_that_industry_dropdown_values_are_in_sorted_order_or_not() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.industry_dropdown_values_sorting();
	 }
	 
	 @Then("Verify that industry dropdown single value can be selected")
	 public void verify_that_industry_dropdown_single_value_can_be_selected() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.industry_dropdown_values_sorting();
	 }

	 @Then("Verify that user can enter Annual Revenue")
	 public void verify_that_user_can_enter_annual_revenue() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.enter_Annual_Revenue();
	 }
	 
	 @Then("verify that No Of Employees field is Enabled")
	 public void verify_that_no_of_employees_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Employees_field_Enabled();
	 }
	 
	 @Then("verify that Yahoo Id field is Enabled")
	 public void verify_that_yahoo_id_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Yahoo_Id_field_Enabled(); 
	 }
	 
	 @Then("Verify that Address information Street field is Enabled")
	 public void verify_that_address_information_street_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Street_field_Enabled();
	 }
	 
	 @Then("verify that Address information City field is Enabled")
	 public void verify_that_address_information_city_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.city_Field();
	 }
	
	 @Then("verify that Address information State field is Enabled")
	 public void verify_that_address_information_state_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Address_information_State_field();
	 }
	 
	 @Then("verify that Address information Postal Code field is Enabled")
	 public void verify_that_address_information_postal_code_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Address_information_Postal_Code_field();
	 }


	 @Then("verify that Address information Country: field is Enabled")
	 public void verify_that_address_information_country_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Address_information_Country();
	 }
	 @Then("verify that Description Information Description: field is Enabled")
	 public void verify_that_description_information_description_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Description_Information_Description();
	 }
	 @Then("verify that Lead Information Phone: field is Enabled")
	 public void verify_that_lead_information_phone_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Information_Phone();
	 }
	 @Then("verify that Lead Information Mobile: field is Enabled")
	 public void verify_that_lead_information_mobile_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Information_Mobile();
	 }
	 @Then("Verify that Lead Information Fax: is Enabled")
	 public void verify_that_lead_information_fax_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.LeadInformation_Fax();
	 }
	 @Then("verify that Lead Information Email: field is Enabled")
	 public void verify_that_lead_information_email_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Information_Email();
	 }
	 @Then("verify that Lead Information Website field is Enabled")
	 public void verify_that_lead_information_website_field_is_enabled() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Information_Website_field();
	 }
	 
	 @Then("Verify that Lead Status dropdown count")
	 public void verify_that_lead_status_dropdown_count() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Status_dropdown_count();
	 }
	 
	 @Then("Verify that Lead Status dropdown is sorted form or not")
	 public void verify_that_lead_status_dropdown_is_sorted_form_or_not() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Lead_Status_dropdown_sorted();
	 }
	 
	 @Then("click on userRedioButton")
	 public void click_on_user_redio_button() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.userRedioButton_click();
	 }
	 
	 @Then("click on TeamRedioButton")
	 public void click_on_team_redio_button() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Click_TeamRedioButton();
		 hp.click_salutation_type();
		 hp.click_FirstName_TextField();
		 hp.Last_Name_TextField();
		 hp.Company_Field_is_Enabled();
		 hp.Save_BTN();
		 
	 }
	
	 @Then("Verify that lead is created")
	 public void verify_that_lead_is_created() {
		 HomePage hp = new HomePage(driver, logger);
		 hp.Verify_lead_created();
	 }
	 
	 @Then("close browser")
	 public void close_browser() {
	     driver.close();
	     }

}
