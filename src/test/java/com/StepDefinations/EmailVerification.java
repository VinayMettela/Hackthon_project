package com.StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.PageObjects.Basepage;
import com.PageObjects.EmailVerifactionObjects;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailVerification {
	EmailVerifactionObjects obj;
	public static WebDriver driver=Baseclass.getDriver();
	@Given("The user should be on the zigwheels.com  Home page")
	public void the_user_should_be_on_the_zigwheels_com_home_page() throws IOException {
		obj=new EmailVerifactionObjects(Baseclass.getDriver());
		Basepage basepage = new Basepage(driver);
		basepage.TitleVerification();
	}

	@When("user click on the login tab")
	public void user_click_on_the_login_tab() {
	    obj.loginbuttonMethod();
	}

	@Then("user clicks on the google")
	public void user_clicks_on_the_google() {
	    obj.googletabMethod();
	}

	@Then("Enters the invalid details")
	public void enters_the_invalid_details() throws InterruptedException {
	    obj.emialsearchboxMethod();
	    obj.sumbitbuttonMethod();
	}

	@Then("Extract the error information")
	public void extract_the_error_information() throws IOException {
	    obj.errormessageMethod();
	}
}
