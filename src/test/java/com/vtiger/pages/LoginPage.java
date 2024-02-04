package com.vtiger.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class LoginPage extends CommonActions {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement userid;
	
	@FindBy(name="user_password")
	WebElement pwd;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement errmsg;
	
	/*
	By username = By.name("user_name");
	By userpassword = By.name("user_password");
	By login = By.name("Login");
	*/
	//String userid = "//input[@name='user_name']";
	
	
	
	public void login(String uid, String pass)
	{
		System.out.println("Login started");

		SetInput(userid, uid,uid+" has been entered into username field");

		SetInput(pwd, pass,pass+" has been entered into password field");
		clickElement(login,"Login button clicked");

	}
	
	public void verifyErrorMsg()
	{
		ElementExist(errmsg, "Error message validated successfully");
	}

	
	
	

}
