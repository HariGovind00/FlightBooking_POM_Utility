/**
 * 
 */
package com.org.basicSelenium.ListenerPack;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 */
public class RetryFailureTest implements IRetryAnalyzer
{
	int maxRetry=1;
	int count=0;

	@Override
	public boolean retry(ITestResult result)
	{
		if(count<maxRetry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
