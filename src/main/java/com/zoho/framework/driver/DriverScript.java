package com.zoho.framework.driver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zoho.framework.keywords.ApplicationKeywords;
import com.zoho.framework.util.Xls_Reader;

public class DriverScript {
	ExtentTest test;
	
	public DriverScript(ExtentTest t){
		test = t;
	}

	public void executeTestCase(String testToExecute, Xls_Reader xls) {
	
		
		int rows = xls.getRowCount("Keywords");

		ApplicationKeywords app = new ApplicationKeywords(test);// init the properties
		
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData("Keywords", "TCID", rNum);
			if(tcid.equals(testToExecute)){
				String keyword = xls.getCellData("Keywords", "Keyword", rNum);
				String objectKey = xls.getCellData("Keywords", "Object", rNum);
				String data = xls.getCellData("Keywords", "Data", rNum);
				test.log(LogStatus.INFO, tcid+" -- "+ keyword+" -- "+objectKey+" -- "+data);
				if(keyword.equals("openBrowser"))
					app.openBrowser(data);
				else if(keyword.equals("navigate"))
					app.navigate(objectKey);
				else if(keyword.equals("input"))
					app.input(objectKey,data);
				else if(keyword.equals("click"))
					app.click(objectKey);
				else if(keyword.equals("verifyTitle"))
					app.verifyTitle(objectKey);
				else if(keyword.equals("verifyElementPresent"))
					app.verifyElementPresent(objectKey);
				else if(keyword.equals("switchToFrame"))
					app.switchToFrame(objectKey);
				else if(keyword.equals("exitFrame"))
					app.exitFrame();
				else if(keyword.equals("verifyLogin"))
					app.verifyLogin();
				
				
			}
		}
		
		

	}

}
