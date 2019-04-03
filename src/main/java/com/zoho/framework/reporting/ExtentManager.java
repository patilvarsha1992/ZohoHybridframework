package com.zoho.framework.reporting;



//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports("D:\\Whizdom-Trainings\\Online Training Workspace\\report\\"+fileName, true, DisplayOrder.NEWEST_FIRST);
			//extent = new ExtentReports("D:\\Whizdom-Trainings\\Online Training Workspace\\report\\report.html");
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//src//test//resources//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "PROD");
		}
		return extent;
	}
}
