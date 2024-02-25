package com.StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.PageObjects.Basepage;
import com.PageObjects.BikesObjects;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BikesData {
		BikesObjects bo;
		public static WebDriver driver=Baseclass.getDriver();
		
		
		@Given("The user should be on the https:\\/\\/www.zigwheels.com website")
		public void the_user_should_be_on_the_https_www_zigwheels_com_website() throws IOException {
			bo=new BikesObjects(Baseclass.getDriver());
			Basepage basepage = new Basepage(driver);
			basepage.TitleVerification();
		}

		@When("user navigates to the New Bikes")
		public void user_navigates_to_the_new_bikes() {
			bo.NewBikesdropdownMethod();
		    
		}

		@Then("user clicks on the Upcomming Bikes")
		public void user_clicks_on_the_upcomming_bikes() {
			bo.UpcommingbikesMethod();
		    
		}

		@Then("user the manaufacture dropdown and select Honda")
		public void user_the_manaufacture_dropdown_and_select_honda() {
			
		    bo.ManufactureDropDownMethod();
		    bo.HondaMethod();
		}

		@Then("Extract the data of bikes less than four lacks")
		public void extract_the_data_of_bikes_less_than_four_lacks() throws IOException {
		    
			bo.ExtractData();
			bo.NavigateHomePage();
		}
}
