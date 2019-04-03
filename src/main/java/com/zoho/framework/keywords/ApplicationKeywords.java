package com.zoho.framework.keywords;

import java.io.FileInputStream;
import java.util.Properties;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ApplicationKeywords extends GenericKeywords{
	
	public ApplicationKeywords(ExtentTest t){
		
		test=t;
		
		// init the properties file
		prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyLogin(){
		test.log(LogStatus.INFO, "Verifying Login");
	}
}
