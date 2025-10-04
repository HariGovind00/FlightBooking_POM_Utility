package UtilityActionMethods;

import java.io.File;
import java.io.IOException;
import java.lang.module.FindException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Action
{
public static WebDriver driver;
ExtentReports extent=new ExtentReports();

//Capture Screenshot
public static String getScreenshot(String demo) throws IOException
{
TakesScreenshot sshot=(TakesScreenshot)driver;
File f1=sshot.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(f1, new File(System.getProperty("user.dir")+"/Screenshots/"+demo+".jpg"));
return System.getProperty("user.dir")+"/Screenshots/"+demo+".jpg";
}

//Extent Report

public ExtentReports extentReportPage()
{
	
	String reportFilePath=System.getProperty("user.dir")+"\\ExtentReportFIle\\ExtentFile.html";
	ExtentSparkReporter report=new ExtentSparkReporter(reportFilePath);
	report.config().setReportName("Hari Govind Kumar");
	report.config().setDocumentTitle("Extent Report");
	extent.attachReporter(report);
	extent.setSystemInfo("Test Automation Engineer", "Hari Govind");
	return extent;
}

//below code is to find locator
public WebElement find(By locator)
{
	return driver.findElement(locator);
	
}

//Find List of Elements
public List<WebElement> FindsElements(By Locator)
{
	return driver.findElements(Locator);
}

//sendKeys Actions.
public static void sendKeyAction(By locator, String val)
{
	driver.findElement(locator).clear();
	driver.findElement(locator).sendKeys(val);
}
//click action
protected static void click(By locator)
{
	driver.findElement(locator).click();
}

//Check element displayed
protected Boolean isDisplayed(By locator)
{
	try
	{
	return driver.findElement(locator).isDisplayed();
	}
	catch(NoSuchElementException exception)
	{
		return false;
	}
	
}

//Check element isSelected
protected Boolean isSelected(By locator)
{
	try
	{
	return driver.findElement(locator).isSelected();
	}
	catch(NoSuchElementException exception)
	{
		return false;
	}
	
}

//GetText and Verify
protected String getText(By locator)
{
	return driver.findElement(locator).getText();
	
}

//Accept Alert popup
protected void alertAccept()
{
	driver.switchTo().alert().accept();
}

//Dismiss Alert Popup
protected void alertDismiss() throws InterruptedException
{
	driver.switchTo().alert().dismiss();
}

//Thread sleep 
protected void sleep(int millSec)
{
	try 
	{
		Thread.sleep(millSec);
	} 
	catch (InterruptedException e)
	{
		e.printStackTrace();
	}
}

//Explicit Wait for Element to Display
protected void elementToAppear(By Locator)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
}


}
