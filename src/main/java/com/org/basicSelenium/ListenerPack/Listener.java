/**
 * 
 */
package com.org.basicSelenium.ListenerPack;

import java.io.IOException;
import java.sql.Driver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import UtilityActionMethods.Action;

/**
 * 
 */
public class Listener extends Action implements ITestListener {
	ExtentReports extent = extentReportPage();
	ExtentTest Test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Welcome Listener");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String FilePath = null;
		extentTest.get().log(Status.FAIL, "Test Script Failed");
		extentTest.get().fail(result.getThrowable());
		try {
			FilePath = getScreenshot(result.getMethod().getMethodName());
			extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(Test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Script Passed.");
		sleep(2000);
	}

	@Override
	public void onFinish(ITestContext context) {
		sleep(1000);
		extent.flush();
		driver.quit();
	}

}
