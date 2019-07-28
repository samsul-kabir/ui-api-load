package com.toptal.uiautomation.runner;

import org.junit.runner.RunWith;

import com.toptal.uiautomation.setup.Setup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = {"src/test/resource/features/dataForm.feature"},
		glue = {"com.toptal.uiautomation.steps"},
		plugin = {"pretty","html:target/cucumber",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"})


public class MainRunner extends Setup{

}
