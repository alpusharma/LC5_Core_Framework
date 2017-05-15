package com.ascend.core.ddf.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxDriver {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
        
        // if above property is not working or not opening the application in browser then try below property

     //  System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\Firefox driver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");

      WebDriver driver = new FirefoxDriver();

      driver.get("http://www.google.com");

      System.out.println("Application title is ============="+driver.getTitle());

   // Take screenshot and store as a file format
 /*  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   try {
    // now copy the  screenshot to desired location using copyFile //method
   FileUtils.copyFile(src, new File("C:/selenium/error.png"));
   }
    
   catch (IOException e)
    {
     System.out.println(e.getMessage());
    
    }
*/
	}
	

}
