package com.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.Excelsheet;

public class BikesObjects extends Basepage{
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	public BikesObjects(WebDriver driver) {
		super(driver);
	}
	
	//Actions aobj = new Actions(driver);
   
	@FindBy(xpath="//a[contains(text(),'New Bikes')]")
	WebElement NewBikesdropdown ;
	
	@FindBy(xpath="//span[normalize-space()='Upcoming Bikes']")
	WebElement Upcommingbikes;
	
	@FindBy(xpath="//select[@id='makeId']")
	WebElement ManufactureDropDown;
	
	@FindBy(xpath="//option[contains(text(),'Honda')]")
	WebElement Honda;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> Data;
	
	@FindBy(xpath="(//div[@class='b fnt-15'])[\"+i+\"]")
	WebElement cost;
	
	@FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	WebElement Homepage;
	
	public void NewBikesdropdownMethod() 
	{
		Actions aobj = new Actions(driver);
		aobj.moveToElement(NewBikesdropdown).build().perform();
	}
	
	public void UpcommingbikesMethod() 
	{
		Upcommingbikes.click();
	}
	
	public void ManufactureDropDownMethod()
	{
		ManufactureDropDown.click();
	}
	
	public void HondaMethod()
	{
		Honda.click();
	}	
	
	public void NavigateHomePage()
	{
		Homepage.click();
	}
	
	public void ExtractData() throws IOException
	{
		int row=1;
		
		for(int i=1;i<=Data.size();i++){
			String cost=driver.findElement(By.xpath("(//div[@class='b fnt-15'])["+i+"]")).getText();
			String amount=cost.replaceAll("[^0-9.]|\\.(?=.*\\.)","");
		    double num=Double.parseDouble(amount);
		    
		    int Bikeprice = (int) (num*100000);
		    if(Bikeprice<=400000) {
		    	String Bikemanufacture=driver.findElement(By.xpath("(//strong[@class='lnk-hvr block of-hid h-height'])["+i+"]")).getText();
		    	String Release_date=driver.findElement(By.xpath("(//div[@class='clr-try fnt-14'])["+i+"]")).getText();
		        Excelsheet.setCellData(file, "BikesData" , row, 0, Bikemanufacture);
		       
		       Excelsheet.setCellData(file, "BikesData", row, 1, Bikeprice);
		        
		       Excelsheet.setCellData(file, "BikesData", row, 2, Release_date);
		       row=row+1;
		        
		    	try {
		    		driver.findElement(By.xpath("//span[@class=\"zw-cmn-loadMore\"]")).click();
		    	}catch(Exception e) {
		    		
		    	}
		    }
		    
		}
	}	
	
}
