package com.vtiger.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class HomePage extends CommonActions {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Lead")
	WebElement NewLead;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="Leads")
	WebElement leads;

	@FindBy(xpath = "//select[@name='salutationtype']")
	WebElement salutation_type;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement Last_Name;

	@FindBy(xpath = "//input[contains(@name,'company')]")
	WebElement Company;

	@FindBy(xpath = "/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/form[1]/table[6]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
	WebElement Save_BTN;

	@FindBy(xpath ="//td[normalize-space()='GRahul123~!@#$%^&*()_+']")
	WebElement Validate_Lead_create;

	@FindBy(xpath = "//input[@name='designation']")
	WebElement designation;

	@FindBy(xpath = "//select[@name='leadsource']")
	WebElement leadsource;
	
	@FindBy(xpath="//select[@name='industry']")
	WebElement industry;
	
	@FindBy(xpath="//input[@name='annualrevenue']")
	WebElement annualrevenue;
	
	@FindBy(xpath="//input[@name='noofemployees']")
	WebElement noofemployees;
	
	@FindBy(xpath="//input[@name='yahooid']")
	WebElement yahooid;
	
	@FindBy(xpath="//textarea[@name='lane']")
	WebElement street;
		
	@FindBy(xpath="//input[@name='city']")
	WebElement cityField;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement State_Field;
	
	@FindBy(xpath= "//input[@name='code']")
	WebElement Post_Code;
	
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@name='fax']")
	WebElement fax;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='website']" )
	WebElement website;
	
	@FindBy(xpath= "//select[@name='leadstatus']")
	WebElement leadstatus;
	
	@FindBy(xpath="//select[@name='rating']" )
	WebElement rating;
	
	@FindBy(xpath="//input[@value=\"U\"]")
	WebElement clickuserradio_BTN;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	WebElement TeamRedioButton;
	
	
	@FindBy(linkText="Rahul Gadhawe" )
	WebElement Lead_create_validate;
	
	
	
	
	/*
	@FindBy(xpath= )
	WebElement 
	
	*/
	
	public void clickNewLead()
	{	
		clickElement(NewLead,"Link New Lead clicked");
	}
	
	public void clicklogout()
	{	
		clickElement(logout,"Link Logout clicked");
		driver.close();
	}
	
	public void clickNew_Leads()
	{	
		clickElement(leads,"clickNew_Leads clicked");
	}
	
	public void verifyHomePage()
	{
		ElementExist(logout, "Logout is displaying on home page");
	}

	public void click_salutation_type()
	{
		clickElement(salutation_type,"click_salutation_type");
	}

	public void click_FirstName_TextField()
	{
		if(firstname.isEnabled())
		{
			System.out.println("firstname is Enabled ");
		}
		else
		{
			System.out.println("firstname is Disabled ");
		}
		firstname.clear();
		firstname.sendKeys("Rahul");
	}

	public void FirstName_TextField_count()
	{
		WebElement firstNameInputbox = driver.findElement(By.xpath("//input[@name='firstname']"));

		firstNameInputbox.clear();
		firstNameInputbox.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZgdfgdhhgsgsgsg@@@@@@@@@###########$$$$%%%%%%%^^^&&&&&&&&*");
		String typedValue = firstNameInputbox.getAttribute("value");
		int size = typedValue.length();
		System.out.println("Size of First_name is: "+size);

		if (size>=25)
		{
			System.out.println("Max character functionality is working fine.");
		}
		else
		{
			System.out.println("No limit is set.");
		}
		firstNameInputbox.clear();
		firstNameInputbox.sendKeys("Rahul");

	}

	public void Last_name_Enabled()
	{
		if (Last_Name.isEnabled())
		{
			System.out.println("Last_Name Field is Enabled. ");
		}
		else {
			System.out.println("Last_Name Field is Not_Enabled.");
		}
	}

	public void Last_Name_TextField()
	{
		WebElement Last_Name=driver.findElement(By.xpath("//input[@name='lastname']"));
		Last_Name.clear();

		Last_Name.sendKeys("sinflskmnlmvldmvowjfsc cl zlcm lzcmlczlcmaojffmsalcm309i0830630860ii508608044y%#%#%#^$&*^*&#@%@^$%&%^**^*&$^%#%^$&*^(^&$^$^#");
		String typedValue = Last_Name.getAttribute("Value");
		int size = typedValue.length();
		System.out.println("Size of Last_Name is: "+size);
		if (size>=25)
		{
			System.out.println("Max character functionality is working fine.");
		}
		else
		{
			System.out.println("No limit is set.");
		}
		Last_Name.clear();
		Last_Name.sendKeys("Gadhawe");
	}

	public void Last_Name_value_Acceptance_Criteria()
	{
		Company.clear();
		Company.sendKeys("COEP_Pune");
		Last_Name.sendKeys("Rahul123~!@#$%^&*()_+");
		
	}

	public void Company_Field_is_Enabled()
	{
		
		if(Company.isEnabled())
            System.out.println("Company_Field_is_Enabled");
		else System.out.println("Company_Field_is_Not_Enabled");
		Company.sendKeys("COEP");
		
	}

	public void Company_Field_is_Displayed()
	{
		NewLead.click();
		if(Company.isDisplayed())
            System.out.println("Company_Field_is_Displayed");
		else System.out.println("Company_Field_is_Not_Displayed");
	}
	public void designation_Field_is_Enabled()
	{
		NewLead.click();
		if(designation.isEnabled())
		{
			System.out.println("verify_that_designation_is_enabled");
		}else {
			System.out.println("verify_that_designation_is_not_enabled");
		}
	}
	public void leadsource_field_is_dropdown_selected()
	{
		NewLead.click();
		if(leadsource.isSelected())
		{
			System.out.println("verify_that_leadsource_is_selected");
		}
		else {
			System.out.println("verify_that_leadsource_is_not_selected");
		}

	}
	
	public void leadsource_dropdown_count()
	{
		Select sel = new Select(leadsource);
		List<WebElement> leadsource_lst= sel.getOptions();
		for (WebElement options:leadsource_lst)
		{
			System.out.println(options.getText());
		}
		int c =leadsource_lst.size();
		System.out.println("Verify_leadsource_dropdown_count is: "+c);
	}

	public void leadsource_dropdown_values_sorted()
	{
		Select sel =new Select(leadsource);
		List<WebElement> lst = sel.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		for(WebElement e :sel.getOptions())
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(originalList);
		Collections.sort(tempList);
		System.out.println(tempList);

		if(originalList == tempList)
		{
			System.out.println("DropDown list are in Sorted from");
		}
		else {

			System.out.println(" As per requirement Dropdown list are not in sorted from");
		}
	}
	
	public void leadsource_dropdown_single_Index_value()
	{
		Select Sel= new Select(leadsource);
		List<WebElement> lst= Sel.getOptions();
		
		System.out.println("LeadSource dropdown options are: ");
		for(WebElement options: lst)
		{
		System.out.println(options.getText());
		Sel.selectByIndex(5);
		
		}
		System.out.println("Select value is: "+ Sel.getFirstSelectedOption().getText());
	}
	
	public void industry_dropdown_is_displayed()
	{

		if(industry.isDisplayed())
		{
			System.out.println("Industry Dropdown tab is present ");
		}
		else
		{
			System.out.println("Industry dropdown tab is not present ");
		}
	}
	
	public void industry_dropdown_count()
	{
		Select sel= new Select(industry);
		List<WebElement> lst=sel.getOptions();
		System.out.println("Dropdown options are below: ");
		for(WebElement options:lst )
		{
			System.out.println(options.getText());
		}
		
		int c =lst.size();
		System.out.println("We hava verified dropdown count is: " +c);
	}
	
	public void industry_dropdown_values_sorting()
	{
		Select sel= new Select(industry);
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement e :sel.getOptions())
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(originalList);
		System.out.println(tempList);

		Collections.sort(originalList);
		Collections.sort(tempList);

		if(originalList == tempList)
		{
			System.out.println("DropDown list are in Sorted from");
		}
		else {

			System.out.println(" As per requirement Dropdown list are not in sorted from");
		}
		
	}
	
	public void industry_dropdown_single_value_Selection()
	{
		Select sel= new Select(industry);
		List<WebElement> lst=sel.getOptions();
		
		System.out.println("The dropdown options are:");
	        for(WebElement options: lst)
	        {
	        	System.out.println(options.getText());
	        	sel.selectByIndex(4);
	            System.out.println("Selected value is: " + sel.getFirstSelectedOption().getText());
	        }
	}

	public void enter_Annual_Revenue()
	{
		annualrevenue.isEnabled();
		annualrevenue.sendKeys("5324245750890756323");
	}


	public void Employees_field_Enabled()
	{
		noofemployees.isEnabled();
		noofemployees.sendKeys("46464534246");
	}
	
	public void Yahoo_Id_field_Enabled()
	{
		yahooid.isEnabled();
		yahooid.sendKeys("rahulgadhawe01@yahoo.com");
	}

	public void Street_field_Enabled()
	{
		street.clear();
		street.isEnabled();
		street.sendKeys("Pahse 1 Hinjewadi");
	}
	
	public void city_Field()
	{
		cityField.clear();
		cityField.sendKeys("Pune");
	}
	
	public void Address_information_State_field()
	{
		State_Field.clear();
		State_Field.sendKeys("Maharashtra");
	}
	
	public void Address_information_Postal_Code_field()
	{
		Post_Code.clear();
		Post_Code.sendKeys("412 105");
	}
	
	public void Address_information_Country () 
	{
		country.clear();
		country.sendKeys("India");
	}
	
	public void Description_Information_Description() 
	{
		description.clear();
		description.sendKeys("Hi hello i'm a automation tester. ");
	}
	
	public void Lead_Information_Phone() 
	{
		phone.clear();
		phone.sendKeys("646378679678563");
	}
	
	public void Lead_Information_Mobile() 
	{
		mobile.clear();
		mobile.sendKeys("75488536868");
	}
	
	public void LeadInformation_Fax() 
	{
		fax.clear();
		fax.sendKeys("vscasxcakcbjhkALS.MCSNCKSBHSANMCAMCLMAS");
	}
	
	public void Lead_Information_Email() 
	{
		email.clear();
		email.sendKeys("rahul@gmail.com");
	}
	
	public void Lead_Information_Website_field () 
	{
		website.clear();
		website.sendKeys(" www.coep.ac.org.in ");
	}
	
	public void Lead_Status_dropdown_count()
	{
		Select sel = new Select(leadstatus);
		List<WebElement> Lead_Status= sel.getOptions();
		for (WebElement options:Lead_Status)
		{
			System.out.println(options.getText());
		}
		int c =Lead_Status.size();
		System.out.println("Verify_Lead_Status_count is: "+c);
		
	}
	
	public void Lead_Status_dropdown_sorted()
	{
		Select Sel=new Select(leadstatus);
		List<WebElement> lst = Sel.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		for(WebElement e :Sel.getOptions())
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(originalList);
		Collections.sort(tempList);
		System.out.println(tempList);

		if(originalList == tempList)
		{
			System.out.println("DropDown list are in Sorted from");
		}
		else {

			System.out.println(" As per requirement Dropdown list are not in sorted from");
		}
	}
	
	public void userRedioButton_click()
	{
		clickuserradio_BTN.click();
	}
	
	public void Click_TeamRedioButton()
	{
		TeamRedioButton.click();
	}
	
	public void Save_BTN()
	{
		Save_BTN.click();
	}
	
	public void Verify_lead_created()
	{
		Lead_create_validate.isDisplayed();
	}
	
}
	