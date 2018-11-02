package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
  @Test
  public void loginChrome() throws MalformedURLException {
	  DesiredCapabilities chrome = DesiredCapabilities.chrome();
	  driver = new RemoteWebDriver(new URL("http://10.238.242.60:4444/wd/hub"), chrome);
	  
	  driver.get("http://the-internet.herokuapp.com/login");
	  WebElement username = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  username.sendKeys("tomsmith");
	  password.sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
	  
	  String text = driver.findElement(By.tagName("body")).getText();
	  Assert.assertTrue(text.contains("You logged into a secure area"), "Text not found!");
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
