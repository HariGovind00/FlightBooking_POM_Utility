/**
 * 
 */
package com.org.basicSelenium.FightBookingPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import UtilityActionMethods.Action;

/**
 * 
 */
public class PassengerDetailsPage extends Action {
	private By passengerDropDownClick = By.id("divpaxinfo");
	// .ad-row-left .guestlbl
	private By passengerCategory = By.cssSelector(".ad-row .guestlbl");
	// Ticket qty inc
	private By QtyInc = By.cssSelector("span[id*='hrefInc']");
	//Click done btn
	private By doneBtnClick=By.id("btnclosepaxoption");

	public CurrencySelPage passengerTicketSelPage(String CatSel, int Qty) {
		click(passengerDropDownClick);
		// Select the passenger category:
		List<WebElement> pass = FindsElements(passengerCategory);
		for (int i = 0; i < pass.size(); i++) {
			System.out.println(pass.size());
			String pa = pass.get(i).getText();
			System.out.println(pa);
			elementToAppear(passengerCategory);
			if (pa.equalsIgnoreCase(CatSel)) {
				System.out.println("Welcome:" + pa);
				for (int j = 1; j <= Qty; j++) {
					FindsElements(QtyInc).get(i).click();
				}
			}
			
		}
		click(doneBtnClick);
		return new CurrencySelPage();
	}
	
}
