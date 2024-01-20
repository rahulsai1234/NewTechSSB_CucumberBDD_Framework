package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class NewLeadPage extends CommonActions {
	
	private WebDriver driver;
	
	public NewLeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(name="firstname")
	WebElement fname;
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name="company")
	WebElement comp;
	
	@FindBy(name="button")
	WebElement save;
	
	
	public void createLead(String firstname, String lastname, String company)
	{
		SetInput(fname, firstname, firstname+" has been entered into first name fields");
		SetInput(lname, lastname, lastname+" has been entered into last name fields");
		SetInput(comp, company, company+" has been entered into company fields");
		clickElement(save, "Save button clicked");
	}
		
	
	

}
