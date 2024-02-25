package com.StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.PageObjects.Basepage;
import com.PageObjects.CarsDataObjects;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarsData {

	CarsDataObjects co;
	public static WebDriver driver=Baseclass.getDriver();
	@Given("The user should be on the zigwheels.com website Home page")
	public void the_user_should_be_on_the_zigwheels_com_website_home_page() throws IOException {
		co=new CarsDataObjects(Baseclass.getDriver());
		Basepage basepage = new Basepage(driver);
		basepage.TitleVerification();
		
	}

	@When("user navigates to the Used cars dropdown")
	public void user_navigates_to_the_used_cars_dropdown() {
	    
		co.UsedCarsMethod();
	}

	@Then("user clicks on the Chennai")
	public void user_clicks_on_the_chennai() {
	    co.ClickChennaiMethod();
		
	}

	@Then("Extract the data under the popular models")
	public void extract_the_data_under_the_popular_models() throws InterruptedException, IOException {
		co.popularmodelslstMethod();
		
	}
}
