package com.toptal.apiautomation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= "src/test/resource/feature/",
					glue = {"com.toptal.apiautomation.stepDefinations"})

public class MainRunner {

}
