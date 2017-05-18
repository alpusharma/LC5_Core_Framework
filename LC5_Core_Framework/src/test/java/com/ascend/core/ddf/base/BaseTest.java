package com.ascend.core.ddf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.ascend.core.ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;


public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports rep=ExtentManager.getInstance();
	public ExtentTest test;
	public Action act;
	public SoftAssert softAssert= new SoftAssert();
	
	
	
	
	public void openBrowser(String bType ){
		//init the prop fild
		if (prop==null){
			prop=new Properties();
			try {
				FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//projectconfig.properties");
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
		}
		//System.out.println(prop.getProperty("appurl"));
		if(bType.equalsIgnoreCase("Mozilla")){
			System.setProperty("webdriver.firefox.marionette",prop.getProperty("mozilladriver_exe"));
			driver = new FirefoxDriver();
}
		else if(bType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver_exe"));
			driver = new ChromeDriver();
}
		else if(bType.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",prop.getProperty("iedriver_exe"));
			driver = new InternetExplorerDriver();
}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();


			
	}
	
	public void navigate(String urlKey){
		driver.get(prop.getProperty(urlKey));
		
	}
	
	public void click(String locatorKey){
		getElement(locatorKey).click();
		
	}
	
	public void type(String locatorKey, String data){
		getElement(locatorKey).sendKeys(data);
		
	}
	public WebElement hover(String locatorKey){
		WebElement Ele = getElement(locatorKey);
		Actions act = new Actions(driver);
		act.moveToElement(Ele).build().perform();
		return Ele;
		
	}
	
	//finding element and returing it
	public WebElement getElement(String locatorKey){
		WebElement e=null;
		try{
		if(locatorKey.endsWith("_xpath"))
			e=driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			e=driver.findElement(By.name(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_id"))
			e=driver.findElement(By.id(prop.getProperty(locatorKey)));
		else {
			reportFailure("Locator not correct -"+ locatorKey);
			Assert.fail("Locator not correct -"+ locatorKey);
		}
		}catch(Exception ex){
			//fail the test and report the error
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test-"+ex.getMessage());
		}
		return e;	
			
		}
	
	public WebElement getWebText(String locatorKey){
		String text=null;
		text= getElement(locatorKey).getText();
		//text= getElement(locatorKey).getText().trim().substring(20, 33);
		System.out.println("There are total " + text);
		return null;
		
	}

	
	
	/******************************Validations**********************************************************/
	
	public boolean verifyTitle(){
		return false;
		
	}
	public boolean isElementPresent(String locatorKey){
		List<WebElement>elementList=null;
		if(locatorKey.endsWith("_xpath"))
			elementList=driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_id"))
			elementList=driver.findElements(By.id(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			elementList=driver.findElements(By.name(prop.getProperty(locatorKey)));
		else{
			reportFailure("Loctor not correct -"+ locatorKey);
			Assert.fail("Loctor not correct -"+ locatorKey);
		}
		if(elementList.size()==0)
		return false;
		else
			return true;
		
		
	}
	public boolean verifyText(String locatorKey, String expectedTextKey){
		String actualText=getElement(locatorKey).getText().trim();
		String expectText=prop.getProperty(expectedTextKey);
		if(actualText.equals(expectText))
			return true;
		else
			return false;
		
	}
	
	/******************************Reporitng**********************************************************/

	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
		
	}
	public void reportFailure(String msg){
		test.log(LogStatus.FAIL, msg);
		//takeScreenShot();
		Assert.fail(msg);
	}
	
	
	public void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//put screenshot file in reports
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
}
