package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.vtiger.Stepdefinitions.BaseTest.alldata;

public class New_Note_Page extends CommonActions {

    private WebDriver driver;

    public New_Note_Page(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);



    }
}
