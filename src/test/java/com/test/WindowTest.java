package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", 
				"src/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
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
