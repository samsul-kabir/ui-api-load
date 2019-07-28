package com.toptal.uiautomation.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.toptal.uiautomation.setup.Setup;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataForm extends Setup {

	private String title, firstName, lastName, age, manufacture;

	@And("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		loginPage.enterUsername("test");
		loginPage.enterPassword("test");
		loginPage.clickOnLogin();
	}

	@When("^User visits the form$")
	public void user_visits_the_form() throws Throwable {
		util.waitForElement(homePage.getLocatorHomePageTitle());
		formPage.clickOnForm();
	}

	@Then("^User can see all mandatory field are marked with \\* and Bold$")
	public void user_can_see_all_mandatory_field_are_marked_with_and_Bold() throws Throwable {
		util.waitForElement(formPage.getLocatorFieldTitle());
		List<WebElement> element = formPage.getFieldTitle();
		log.info("Element size: {}", element.size());

		for (int i = 0; i < 5; i++) {
			Assert.assertTrue(element.get(i).findElements(By.tagName("b")).size() > 0,
					element.get(i).getText() + " is not Bold");
			Assert.assertTrue(element.get(i).getText().contains("*"),
					element.get(i).getText() + " does not have '*' in it");
		}
	}

	@Then("^User will find the save button disabled$")
	public void user_will_find_the_save_button_disabled() throws Throwable {
		util.waitForElement(formPage.getLocatorFieldTitle());
		Assert.assertTrue(formPage.isSaveButtonDisabled(), "Save Button is not Disabled");
	}

	@And("^User fill in all mandatory field except Manufacture$")
	public void user_fill_in_all_mandatory_field_except_Manufacture(DataTable data) throws Throwable {
		util.waitForElement(formPage.getLocatorFieldTitle());
		List<Map<String, String>> userData = data.asMaps(String.class, String.class);

		formPage.enterValueInoAllTextField(userData.get(0).get("Title"), userData.get(0).get("First_Name"),
				userData.get(0).get("Last_Name"), userData.get(0).get("Age"), userData.get(0).get("Manufacture"));
	}

	@And("^User fill in all mandatory field$")
	public void user_fill_in_all_mandatory_field(DataTable data) throws Throwable {
		util.waitForElement(formPage.getLocatorFieldTitle());
		List<Map<String, String>> userData = data.asMaps(String.class, String.class);

		title = userData.get(0).get("Title");
		firstName = userData.get(0).get("First_Name");
		lastName = userData.get(0).get("Last_Name");
		age = userData.get(0).get("Age");
		manufacture = userData.get(0).get("Manufacture");

		formPage.enterValueInoAllTextField(title, firstName, lastName, age, manufacture);

		util.waitForElement(formPage.getLocatorDropDowntoUpdate());
		formPage.selectFromDropDown();
	}

	@And("^User can click on save button$")
	public void user_can_click_on_save_button() throws Throwable {
		if (formPage.isSaveButtonDisabled()) {
			log.info("Button is disabled");
		} else {
			formPage.clickOnSaveButton();
		}
	}

	@Then("^Inserted info will appear in the table$")
	public void inserted_info_will_appear_in_the_table() throws Throwable {
		List<WebElement> elem = formPage.returnFirstRowData();
		Assert.assertEquals(elem.get(0).getText(), title);
		Assert.assertEquals(elem.get(1).getText(), firstName);
		Assert.assertEquals(elem.get(2).getText(), lastName);
		Assert.assertEquals(elem.get(3).getText(), age);
		Assert.assertEquals(elem.get(4).getText(), manufacture);
	}
}
