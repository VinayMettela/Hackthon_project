package com.PageObjects;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Excelsheet;

public class EmailVerifactionObjects extends Basepage {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	
	public EmailVerifactionObjects(WebDriver driver) {
		super(driver);
	}
	
;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),'Google')]")
	WebElement googleSignIn;
	
	@FindBy(id="forum_login_wrap_lg")
	WebElement loginbutton;
	
	
	
	@FindBy(id="identifierId")
	WebElement emialsearchbox;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement sumbitbutton;
	
	@FindBy(xpath="//*[contains(text(),'Couldn’t find your Google Account')]")
	WebElement errormessage;
	
	
	
	public void loginbuttonMethod()
	{
		logo.click();
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void googletabMethod()
	{
		//driver.findElement(googleSignIn).click();
		//googletab.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		googleSignIn.click();
		//js.executeScript("arguments[0].click();", driver.findElement(googleSignIn));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void emialsearchboxMethod()
	{
		String email="viviv@google.com.";
		emialsearchbox.sendKeys(email,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//js.executeScript("arguments[0].click();",sumbitbutton);
		
	}
	
	public void sumbitbuttonMethod() throws InterruptedException
	{
//		Thread.sleep(3000);
//		js.executeScript("arguments[0].click();",sumbitbutton);
//		sumbitbutton.click();
		System.out.println("done");
	}
	
	
	public void errormessageMethod() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String errormsg=errormessage.getText();
		System.out.println("error message:"+errormessage.getText());
		Excelsheet.setCellData(file, "Email verification", 1, 0, errormsg);
	}
	
	
	
	
	
}
