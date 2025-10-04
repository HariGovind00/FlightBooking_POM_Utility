package com.org.basicSelenium.BasicSeleniumConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.basicSelenium.FightBookingPages.CurrencySelPage;
import com.org.basicSelenium.FightBookingPages.FlightBookingHomePage;
import com.org.basicSelenium.FightBookingPages.PassengerDetailsPage;
import com.org.basicSelenium.ListenerPack.RetryFailureTest;
import com.org.basicSelenium.RahulShettyAcademyLogin.LoginPage;
import com.org.basicSelenium.RahulShettyAcademyLogin.RahulShettyHomePage;

import UtilityActionMethods.Action;
/*
 * Author: Hari Govind Kumar
 */
public class BaseTestRun extends Action
{
	RahulShettyHomePage home=new RahulShettyHomePage();
	LoginPage log=new LoginPage();
	FlightBookingHomePage FlightHomePage=new FlightBookingHomePage();
@BeforeMethod
public void BrowserInit() throws InterruptedException
{
	driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/practice-project");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);	
}

//@Test(dataProvider = "getData",retryAnalyzer=RetryFailureTest.class)
public void loginTest(String name,String email) throws InterruptedException
{
	
	log.usernameField(name);
	log.emailField(email);
	log.teamsClick();
	log.clickLogin();
	home.homePage("123456");
}

@Test
public void FlightHomePageTest() throws InterruptedException
{
	
	log.usernameField("hari");
	log.emailField("govindharik@gmail.com");
	log.teamsClick();
	log.clickLogin();
	home.homePage("123456");
	FlightHomePage.verifyHomePage("Flights");
	FlightHomePage.countrySel("Ind","Indonesia");
	FlightHomePage.tripSelection();
	FlightHomePage.fromTripSel("Bengaluru (BLR)");
	FlightHomePage.toTripSel("Chennai (MAA)");
	FlightHomePage.fromCalendar("November", "2025",23);
	FlightHomePage.toCalendar("December", "2025", 22);
	PassengerDetailsPage pd=new PassengerDetailsPage();
	pd.passengerTicketSelPage("infant",3); 
	CurrencySelPage cur=new CurrencySelPage();
	cur.currecyDropdownSel("USD");
	}



@DataProvider
public Object[][] getData()
{
	Object[][] obj=new Object[2][2];
	obj[0][0]="hari";
	obj[0][1]="govindharik@gmail.com";
	
	obj[1][0]="govind";
	obj[1][1]="xyz@gmail.com";
	
	
	return obj;
}

}
