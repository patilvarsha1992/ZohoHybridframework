package com.zoho.framework.keywords;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericKeywords {

	WebDriver driver;
	Properties prop;
	ExtentTest test;
	
	public void openBrowser(String bType){
		test.log(LogStatus.INFO, "Opening Browser "+bType);
		if(bType.equals("Mozilla")){
			driver = new FirefoxDriver();
		}else if(bType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "PATH EXE");
			driver = new ChromeDriver();
		}else if(bType.equals("IE")){
			System.setProperty("webdriver.ie.driver", "PATH EXE");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void navigate(String urlKey){
		test.log(LogStatus.INFO, "Navigating "+prop.getProperty(urlKey));
		driver.get(prop.getProperty(urlKey));
	}
	
	public void click(String locatorKey){
		test.log(LogStatus.INFO, "Clicking "+prop.getProperty(locatorKey));
		getObject(locatorKey).click();
	}
	
	public void input(String locatorKey,String data){
		test.log(LogStatus.INFO, "Typing "+prop.getProperty(locatorKey));
		getObject(locatorKey).sendKeys(data);
	}
	
	public void switchToFrame(String frameIndex){
		int s = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames - "+s);
		driver.switchTo().frame(Integer.parseInt(frameIndex));
	}
	
	public void exitFrame(){
		driver.switchTo().defaultContent();
	}
	
	public void verifyTitle(String expectedTitleKey){
		test.log(LogStatus.INFO, "Verifying Title "+prop.getProperty(expectedTitleKey));
		// report a failure with screenshot
	}
	
	public void verifyElementPresent(String locatorKey){
		test.log(LogStatus.INFO, "Verifying Element Presence "+prop.getProperty(locatorKey));
		// report a failure with screenshot
	}
	
	// extract Object
	public WebElement getObject(String locatorKey){
		WebElement e = null;
		
		try{
			e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		}catch(Exception ex){
			// exception
		    // report a failure with screenshot
			reportFailure("Exception while extracting object "+locatorKey +"- Message -> "+ ex.getMessage());
		}
		
		return e;
	}
	
	public void reportFailure(String errMsg){
		test.log(LogStatus.FAIL, errMsg);
		// screenshot and put in the reports
		Assert.fail(errMsg);
	}
	
	
}
