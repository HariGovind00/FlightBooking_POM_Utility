/**
 * 
 */
package com.org.basicSelenium.FightBookingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import UtilityActionMethods.Action;

/**
 * 
 */
public class CurrencySelPage extends Action
{
	//click currently dropdown
	private By currencyDropdownClick=By.id("ctl00_mainContent_DropDownListCurrency");
	//Click Submit button
	private By clickBookFlightBtn=By.id("ctl00_mainContent_btn_FindFlights");
public void currecyDropdownSel(String selCurrency)
{
	click(currencyDropdownClick);
	
	Select selOpt=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	//selOpt.selectByIndex(2);
	selOpt.selectByVisibleText(selCurrency);
	click(clickBookFlightBtn);
	
	
}
}
