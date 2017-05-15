
package com.ascend.core.ddf.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hoverover {

	public void main(String[] args) {
		
		System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
	
		driver.get("https://qalabcheck.ascend.dev/ACESLabCheck/Account/Login");
		driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("sharmaa");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Aarav217552");
		driver.findElement(By.xpath("//*[@id='Facility']")).sendKeys("red");
		driver.findElement(By.xpath("//*[@id='loginForm']/form/fieldset/ol/li[5]/input")).click();
		driver.findElement(By.xpath("//*[@id='menu']/li[1]/span"));
		WebElement patient = driver.findElement(By.name("//*[@id='menu']/li[1]/span"));
		Actions act = new Actions(driver);
		act.moveToElement(patient).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,10);
	 
	 
	}

}
