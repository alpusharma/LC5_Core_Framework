package com.ascend.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ascend.core.ddf.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends BaseTest{
	
	
	
	@Test
	public void testB(){
		String testCaseName="TestB";
		
		
		openBrowser("Mozilla");
		navigate("appurl");
		
		
		
		//check if neep support text is present
		/*
		if(!verifyText("homepgneedsupporttext_xpath","Need Support? Call Client Services at 800.800.5655 "));
		*/
		
		softAssert.assertTrue(verifyText("homepgneedsupporttext_xpath","Need Support? Call Client Services at 800.800.5655 "),"Text did not match");
		softAssert.assertTrue(false, "Err 2");
		softAssert.assertTrue(true,  "Err 3");
		softAssert.assertTrue(false, "Err 4");
			
		//check if username field is present
				if(!isElementPresent("username_id"))
					reportFailure("Username field is not present");//critical failure
		
		type("username_xpath","***");
		type("pass_xpath","****");
		type("facility_xpath", "HED");
		click("loginbtn_xpath");
		
		verifyTitle();
		//reportFail("");
	
		
	}
	
	@BeforeMethod
	public void init(){
		softAssert = new SoftAssert();
	}
	
	
	@AfterMethod
	public void quit(){
		try{
			softAssert.assertAll();
		}catch(Error e){
			test.log(LogStatus.FAIL, e.getMessage());
		}
		
		rep.endTest(test);
		rep.flush();
	}
	
	



}
