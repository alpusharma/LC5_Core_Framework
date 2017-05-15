package com.ascend.core.ddf.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ascend.core.ddf.base.BaseTest;

public class BatchOrders extends BaseTest{
	
SoftAssert softAssert;
	
	
	@Test()
	public void batchOrders(){
		openBrowser("Mozilla");
		navigate("appurl");
		type("username_xpath","sharmaa");
		type("pass_xpath","Anshika217552");
		type("facility_xpath", "RED");
		click("loginbtn_xpath");
		hover("patienthead_xpath");
		click("batchorder_xpath");
		
		
		//total patients on Lab batch ordering page only-
		
		getWebText("batchtotpatientext_xpath");
		

		
			
		
		
	
		
		
		
	}


	

	
	

}

	


