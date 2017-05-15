package com.ascend.core.ddf.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ascend.core.ddf.base.BaseTest;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_COLOR_BURNPeer;

public class PatientsList extends BaseTest{
	SoftAssert softAssert;
	
	
	@Test()
	public void patientList(){
		openBrowser("Mozilla");
		navigate("appurl");
		type("username_xpath","sharmaa");
		type("pass_xpath","Anshika217552");
		type("facility_xpath", "RED");
		click("loginbtn_xpath");
		hover("patienthead_xpath");
		click("patientlist_xpath");
		
		//select 100 from drop down list-
		getElement("showentries_xpath").sendKeys("100");
		click("applybtn_xpath");
		
		//total patients on patient links page only-
		List<WebElement> patientNames=driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr/td[1]"));
		System.out.println("Total no. of patients are --"+patientNames.size());
		List<WebElement> modalityNames=driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total no. of modalities are --"+modalityNames.size());
		
		//to get the total number of patients in application from show entries text at bottom of screen-
		getWebText("patienttotaltext_xpath");
		
			
		
		/*
		for(int i = 0; i<patientNames.size();i++){
			System.out.println(patientNames.get(i).getText());
			driver.findElement(By.xpath("//*[@id='dataTable_next']")).click();
			driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr/td[1]"));
			driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr/td[4]"));
			//*[@id='dataTable']/tfoot/tr/th[1]
		
			
		}
		*/
		
	
		
		
		
	
	}


	

	
	

}
