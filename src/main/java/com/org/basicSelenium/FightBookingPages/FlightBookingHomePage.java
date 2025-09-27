/**
 * 
 */
package com.org.basicSelenium.FightBookingPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityActionMethods.Action;

/**
 * Hari Govind Kumar I 20/09/25
 */
public class FlightBookingHomePage extends Action {

	private By FlightBookHomePageVerification = By.xpath("//li[@class='book_flight']//span[text()='Flights']");

	public void verifyHomePage(String ExpectedFlightText) {
		System.out.println(driver.getTitle());
		System.out.println("Welcome VerifyHomePage Method.");
		String ActualText = getText(FlightBookHomePageVerification);
		Assert.assertEquals(ActualText, ExpectedFlightText);

	}

//Country Selction
	private By CountrySearch = By.cssSelector("div[id='select-class-example'] input");
//Country's Autosugg
	private By CountryAutoSug = By.cssSelector("li[class='ui-menu-item'] a");

	public void countrySel(String countryName, String CountrySelect) {
		System.out.println("Country Sel Method");
		sendKeyAction(CountrySearch, countryName);
		elementToAppear(CountryAutoSug);
		List<WebElement> countrys = FindsElements(CountryAutoSug);
		for (int i = 0; i < countrys.size(); i++) {
			if (countrys.get(i).getText().equalsIgnoreCase(CountrySelect)) {
				countrys.get(i).click();
			}
		}

	}

	// Trip Selection
	private By TripSel = By.cssSelector("#travelOptions td:nth-child(2) input");

	public void tripSelection() {
		elementToAppear(TripSel);
		click(TripSel);
		isSelected(TripSel);
	}

	// From Journey Field
	private By FromJourneyFieldClick = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	// StateNames
	private By FromStateNames = By
			.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//div[@class='dropdownDiv']//ul//li/a");

	public void fromTripSel(String DomesticJourneyStateName) {
		click(FromJourneyFieldClick);
		List<WebElement> states = FindsElements(FromStateNames);
		for (int i = 0; i < states.size(); i++) {
			String fromState = states.get(i).getText();
			System.out.println(fromState);
			if (fromState.equalsIgnoreCase(DomesticJourneyStateName)) {
				System.out.println("Welcome:" + fromState);
				states.get(i).click();
				break;
			}
		}

	}

	// To Destination Sel
	private By ToStateNames = By
			.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//div[@class='dropdownDiv']//ul//li/a");

	public void toTripSel(String DomesticDestinationStateName) {
		System.out.println("Welcome to To Journey");
		elementToAppear(ToStateNames);
		List<WebElement> states = FindsElements(ToStateNames);
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).getText().equalsIgnoreCase(DomesticDestinationStateName)) {
				System.out.println("To Journey:" + states.get(i).getText());
				states.get(i).click();
				
			}
		}

	}

//From Calendar Handle
	private By clickReturnJourneyCalendar=By.id("ctl00_mainContent_view_date2");
	private By Month = By.xpath("//span[@class='ui-datepicker-month']");
	private By Year = By.xpath("//span[@class='ui-datepicker-year']");
	private By PreviousBtn = By.cssSelector(".ui-datepicker-prev span");
	private By NextBtn = By.cssSelector(".ui-datepicker-next span");
	public void fromCalendar(String month, String year,int date) {
		sleep(1000);
		By day=By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[text()='"+date+"']");
		String Mon = getText(Month);
		String Yrs = getText(Year);
		while (!(Mon.contains(month) && Yrs.contains(year))) 
		{
			Mon = getText(Month);
			Yrs = getText(Year);
			if (Mon.equalsIgnoreCase(month) && Yrs.equalsIgnoreCase(year))
			{
				String daySel=getText(day);
				System.out.println("Trip booked on:"+daySel+":"+Mon+":"+Yrs);
				click(day);
				break;
			} 
			else
			{
				click(NextBtn);
			}

		}

	}
	
//ToCalendar
	public PassengerDetailsPage toCalendar(String month, String year,int date) {
		sleep(1000);
		click(clickReturnJourneyCalendar);
		By day=By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[text()='"+date+"']");
		String Mon = getText(Month);
		String Yrs = getText(Year);
		while (!(Mon.contains(month) && Yrs.contains(year))) 
		{
			Mon = getText(Month);
			Yrs = getText(Year);
			if (Mon.equalsIgnoreCase(month) && Yrs.equalsIgnoreCase(year))
			{
				String daySel=getText(day);
				System.out.println("Trip booked on:"+daySel+":"+Mon+":"+Yrs);
				click(day);
				break;
			} 
			else
			{
				click(NextBtn);
			}

		}
		return new PassengerDetailsPage();

	}

}
