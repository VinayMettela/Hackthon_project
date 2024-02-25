package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					
					features= {".//Features/Hackthon.feature"},
					glue="com.StepDefinations",
					plugin= {"pretty", "html:reports/myreport.html",
									"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
					dryRun = false,
					monochrome = false,
					publish = false)
public class testRun {

}
