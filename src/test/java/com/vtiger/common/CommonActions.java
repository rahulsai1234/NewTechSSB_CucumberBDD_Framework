package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	
	public void SetInput(WebElement elm, String data,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void SetInput(By elm, String data,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
		driver.findElement(elm).clear();
		driver.findElement(elm).sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void SetInput(String elm, String data,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).clear();
		driver.findElement(By.xpath(elm)).sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(By elm, String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		driver.findElement(elm).click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(String elm,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void ElementExist(WebElement  elm,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void verifyTitle(String exp)
	{
		try
		{
		if(exp.equals(driver.getTitle()))
		logger.pass("Title matched");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
