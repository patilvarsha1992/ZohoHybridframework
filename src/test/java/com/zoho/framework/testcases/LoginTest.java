package com.zoho.framework.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zoho.framework.driver.DriverScript;
import com.zoho.framework.reporting.ExtentManager;
import com.zoho.framework.util.Xls_Reader;

public class LoginTest {

	ExtentReports rep;
	ExtentTest test;
	
	@BeforeMethod
	public void before(){
		 rep = ExtentManager.getInstance();
		 test = rep.startTest("Login Test");
	}
	
	@AfterMethod
	public void after(){
		rep.endTest(test);
		rep.flush();
	}
	
	
	@Test
	public void doLogin(){
		
		test.log(LogStatus.INFO, "Starting Login Test");
		String location = "D:\\Whizdom-Trainings\\Frameworks\\Hybrid_Framework.xlsx";
		Xls_Reader xls = new Xls_Reader(location);
		String testToExecute="LoginTest";
		
		DriverScript app = new DriverScript(test);
		test.log(LogStatus.INFO, "Executing Keywords");
		app.executeTestCase(testToExecute, xls);
		test.log(LogStatus.PASS, "Test Passed");
		
		

		
	}
	
	
	
}
