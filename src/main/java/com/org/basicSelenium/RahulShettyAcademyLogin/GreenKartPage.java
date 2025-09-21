/**
 * 
 */
package com.org.basicSelenium.RahulShettyAcademyLogin;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.basicSelenium.FightBookingPages.FlightBookingHomePage;

import UtilityActionMethods.Action;

/**
 * Author: Hari Govind Kumar I
 * Date: 19/09/25
 */


public class GreenKartPage extends Action
{
	private By GreenkartLogo=By.cssSelector(".container .greenLogo");
	private By FlightBookingPageLinkClick=By.partialLinkText("Flight");
	
	public FlightBookingHomePage verifyGreenKartPage()
	{
		System.out.println("Welcome greenkart");
		sleep(4000);
		String actualLogoText=getText(GreenkartLogo);
		String ExpectedLogoText="GREEN";
		Assert.assertTrue(actualLogoText.contains(ExpectedLogoText));
		click(FlightBookingPageLinkClick);
		windowHandle();
		return new FlightBookingHomePage();
		
	}
	
	public void windowHandle()
	{
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itrWin=windows.iterator();
		String child=itrWin.next();
		String Parent=itrWin.next();
		driver.switchTo().window(Parent);
	}
}
