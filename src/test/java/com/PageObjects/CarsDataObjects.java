package com.PageObjects;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.Excelsheet;

public class CarsDataObjects extends Basepage{
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	
	public CarsDataObjects(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Used Cars') and @class='c-p']")
	WebElement UsedCars;
	
	@FindBy(xpath="//span[contains(text(),'Chennai') and @onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement ClickChennai;
	
	@FindBy(xpath="//input[@class='carmmCheck']")
	List<WebElement> popularModellist;
	
	@FindBy(xpath="//input[@class='carmmCheck']")
	List<WebElement> popularmodelslst;
	
	@FindBy(xpath="//a[@data-track-label='Car-name']")
	List<WebElement> carslst;
	
	@FindBy(xpath="//span[@class='zw-cmn-price n pull-left mt-3']")
	List<WebElement> carsprice;
	
	@FindBy(xpath="//span[@class=\"zc-7 fnt-14 uLm block\"]")
	List<WebElement> carslocation;
	
	
	public void UsedCarsMethod() 
	{
		Actions a = new Actions(driver);
		a.moveToElement(UsedCars).build().perform();;
	}
	
	public void ClickChennaiMethod()
	{
		ClickChennai.click();
	}
	
	public void popularmodelslstMethod() throws InterruptedException, IOException {
		int j,row=1;
		for(int i=0;i<popularmodelslst.size();i++) {
			   
			
	    	JavascriptExecutor js =(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click()",popularmodelslst.get(i));

	    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    	Thread.sleep(10000);
		    
		    
 
		    for(j=0;j<carslst.size();j++)  { 
		    	Excelsheet.setCellData(file, "CarsData", row, 0, carslst.get(j).getText());
		    	
	    		//System.out.println(count1+" "+carslst.get(j).getText());
		    	
		    	Excelsheet.setCellData(file, "CarsData", row, 1, carsprice.get(j).getText());
		    	
		    	//System.out.println(carsprice.get(j).getText());
		        try {
		        	
		        	Excelsheet.setCellData(file, "CarsData", row, 2, carslocation.get(j).getText());
		        	//System.out.println(carslocation.get(j).getText());
		        }catch(Exception e){
		        	
		        	Excelsheet.setCellData(file, "CarsData", row, 2, "Not available");
		        	//System.out.println("not available");
		        }
		        row+=1;
	    		
	    }
		    row+=1;
		    js.executeScript("arguments[0].click()",popularmodelslst.get(i));
	    	Thread.sleep(10000);
	    }
	}
	
	
	
	
	
}