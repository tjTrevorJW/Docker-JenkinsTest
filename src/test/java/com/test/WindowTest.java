package com.test;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowTest {
  @Test
  public void f() throws MalformedURLException {
	  System.setProperty("webdriver.chrome.driver", 
				"src/chromedriver.exe");
	  DesiredCapabilities chrome = DesiredCapabilities.chrome();
	  WebDriver driver = new RemoteWebDriver(new URL("http://10.238.242.60:4444/wd/hub"), chrome);
	  //WebDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/windows");
	  
	  driver.findElement(By.xpath("//*[contains(text(), 'Click Here')]")).click();
	  System.out.println(driver.getWindowHandles());
	  for(String windowHandle : driver.getWindowHandles()) {
		  driver.switchTo().window(windowHandle);
		  if (driver.getTitle().equals("New Window")){
			  break;
		  }
	  }
	  String result = driver.findElement(By.xpath("/html/body/div/h3")).getText();
	  System.out.println(result);
	  driver.quit();
  }
}
