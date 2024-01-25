package com.vtiger.reports;

import java.util.*;

import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;
import org.openqa.selenium.support.ui.Select;

public class Potential_Page extends CommonActions{

	private WebDriver driver;
	
	public Potential_Page(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Potential']")
	WebElement click_New_Potential;
	
	@FindBy(xpath="//input[@name='potentialname']")
	WebElement potentialname;
	
	@FindBy(xpath="//input[@name='account_name']")
	WebElement account_name;
	
	@FindBy(xpath="//input[@title='Change']")
	WebElement search_field;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement Account_Name;
	
	@FindBy(xpath="//input[@name='address_city']")
	WebElement address_city;
	
	@FindBy(xpath="//a[normalize-space()='EDFG Group Limited']")
	WebElement EDFG_Group_Limited_link;
	
	@FindBy(xpath= "//input[@title='Search [Alt+Q]']")
	WebElement Search;

	@FindBy(xpath = "//select[@name='opportunity_type']")
	WebElement type;

	@FindBy(xpath = "//select[@name='leadsource']")
	WebElement leadsource;

	@FindBy(xpath = "//img[@id='jscal_trigger_closingdate']")
	WebElement calender;

	@FindBy(xpath = "//body/div[9]/table[1]/thead[1]/tr[1]/td[2]")
	WebElement datepicker;

	@FindBy(xpath = "//td[@class='hilite nav button hilite']")
	WebElement Month_Back;


	
	public void click_New_Potential()
	{
		click_New_Potential.click();
	}
	
	public void potentialname()
	{
		potentialname.isEnabled();
		potentialname.clear();
		potentialname.sendKeys("xyz");
	}
	
	public void Account_Name_Enabled()
	{
		account_name.click();
		if(account_name.isEnabled())
		{
			System.out.println("As per requirement Account Name should not be enabled. ");
		}else {
			System.out.println("Requirement is not matched. ");
		}
	}
	
	
	public void Account_name_search_field()
	{
		search_field.click();
		
		//Window Handels Code
		
		Set<String > Windows_id= driver.getWindowHandles();
		Iterator <String> itr = Windows_id.iterator();
		
		String MainWindow_id= itr.next();
		String ChildWindow_id= itr.next();
		
		driver.switchTo().window(ChildWindow_id);
		driver.manage().window().maximize();
	}
	
	public void Account_Name()
	{
		Account_Name.isEnabled();
		Account_Name.sendKeys("E");
	}
	
	public void City_Field()
	{
		address_city.isEnabled();
		address_city.sendKeys("");
	}
	
	public void search_button_validition()
	{
		EDFG_Group_Limited_link.click();
	   
	    
	    Set<String > Windows_id= driver.getWindowHandles();
		Iterator <String> itr = Windows_id.iterator();
		
		String MainWindow_id= itr.next();
		//String ChildWindow_id= itr.next();
	    driver.switchTo().window(MainWindow_id);
	}

	public void count_type()
	{
		Select sel =new Select(type);
		List<WebElement> lst=sel.getOptions();

		for(WebElement options:lst)
		{
			System.out.println(options.getText());
		}

		int count= lst.size();
		System.out.println("Potential count_type count is:"+count);
	}
	public void type_Sorted()
	{
		Select sel =new Select(type);
		List<WebElement> lst=sel.getOptions();

		ArrayList original_list = new ArrayList();
		ArrayList tempList = new ArrayList();

		for(WebElement e :sel.getOptions())
		{
			original_list.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(original_list);
		Collections.sort(tempList);
		System.out.println(tempList);

		if(original_list == tempList)
		{
			System.out.println("DropDown list are in Sorted from");
		}
		else {

			System.out.println(" As per requirement Dropdown list are not in sorted from");
		}
	}

	public void LeadSourceCount()
	{
		Select Sel= new Select(leadsource);
		List<WebElement> lst=Sel.getOptions();

		for(WebElement options:lst )
		{
			System.out.println(options.getText());
		}
		int count= lst.size();
		System.out.println("Lead Source Count is: "+count);
	}

	public void date_selection()
	{
		calender.click();
		String Target_month_year= "December, 2026";

		Target_month_year.equals(datepicker);
		while (true)
		{
			String text=datepicker.getText();
			if (Target_month_year.equals(text))
			{
				break;
			}
			else
			{
				Month_Back.click();
			}
		}


	}
}
