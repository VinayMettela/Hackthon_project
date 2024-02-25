package com.StepDefinations;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Factory.Baseclass;
import io.cucumber.java.BeforeAll;

public class Hooks {
	public static  WebDriver driver;
	  static Properties p;
  
 @BeforeAll
 public static void setup() throws IOException, AWTException 
 {
 	driver=Baseclass.getWebDriver();
 	p=Baseclass.getProperties();
 	    	
 	driver.get(p.getProperty("appURl"));
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 	driver.manage().window().maximize();

 }
}
