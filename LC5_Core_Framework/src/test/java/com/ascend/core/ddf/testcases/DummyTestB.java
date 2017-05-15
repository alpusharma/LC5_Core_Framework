package com.ascend.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ascend.core.ddf.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class DummyTestB extends BaseTest{
	
	@Test
	public void testB1(){
		
		test=rep.startTest("DummyTestB");
		test.log(LogStatus.INFO, "Starting the test B");
		openBrowser("Mozilla");
		test.log(LogStatus.INFO, "Opened the browser");
		navigate("appurl1");
		
		//check if email field is present
		if(!isElementPresent("email_id"))
				reportFailure("Email field is not present");//as it is critical
		type("email_id","alpuseleniumtest@gmail.com");
		click("button_xpath");
		verifyTitle();
		reportFailure("title does not match");
		test.log(LogStatus.PASS, "Test B Passed");			
		
	}
	
	@AfterMethod	
	public void quit(){
		rep.endTest(test);
		rep.flush();
}

}
