package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.Excelsheet;



public class Basepage {
	WebDriver driver;
	 String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	
	public Basepage(WebDriver driver){
		 this.driver=driver;
		
	     PageFactory.initElements(driver,this);
	}
	
	public void TitleVerification() throws IOException {
		int row=1;
		int col=0;
		String actualtitle="New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com";
		String title=driver.getTitle();
		if(actualtitle.equalsIgnoreCase(title)) {
			
			
			Excelsheet.setCellData(file,"sheet1", row, col, "Navigated to the correct page");
		}
		else {
			
			Excelsheet.setCellData(file,"sheet1", row, col, "Navigated to the wrong page");
		}
		col+=1;
	}
	
	
	
}
