package com.ascend.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ascend.core.ddf.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestC extends BaseTest{
	@Test
	public void testC(){
		test=rep.startTest("DummyTestC");
		test.log(LogStatus.INFO, "Starting DummyTestC");
		test.log(LogStatus.INFO, "Failed DummyTestC");
		
		
	}
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
		
	}

}
