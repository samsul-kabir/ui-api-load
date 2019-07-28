package com.toptal.uiautomation.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {
	//private static WebDriver driver;
	private static WebDriverWait wait;

	public Utils(WebDriver driver) {
		//Utils.driver = driver;
		Utils.wait = new WebDriverWait(driver, 40);
	}

	public void waitForElement(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated((By) by));
	}
	
	public void captureScreenshot(WebDriver driver, String screenshotname) {
		Path dest = Paths.get("./Screenshots", screenshotname + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			log.info("Screenshot taken");
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot" + e.getMessage());
		}
	}
}
