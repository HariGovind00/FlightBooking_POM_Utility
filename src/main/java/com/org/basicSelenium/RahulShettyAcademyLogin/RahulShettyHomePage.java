package com.org.basicSelenium.RahulShettyAcademyLogin;

import org.openqa.selenium.By;
import org.testng.Assert;
import UtilityActionMethods.Action;

public class RahulShettyHomePage extends Action 

{
private By HomePageTextVerification=By.tagName("h5");
private By submitBtn=By.id("code-form-submit");
//div[@class='projects-item']//a[contains(text(),'1')]
//div[@class='projects-item']//a[text()='Automation Practise - 1']
private By greenKartPageLink=By.xpath("//div[@class='projects-item']//a[contains(text(),'1')]");
EmailVerificationCodePage emailcode=new EmailVerificationCodePage();
GreenKartPage greenLogo=new GreenKartPage();

public void homePage(String code) throws InterruptedException
{	
	System.out.println("Wecome to RahulshettyHomepage");
	
	String actual=getText(HomePageTextVerification);
	System.out.println(actual);
	if(actual.contains("PROJECTS"))
	{
		Assert.assertEquals(actual,"OUR PROJECTS");
		click(greenKartPageLink);
		greenLogo.verifyGreenKartPage();
	}
	else
	{
		sleep(2000);
		System.out.println("Else Condition");
		emailcode.verifyCode(code);
		click(submitBtn);
		sleep(2000);
		alertAccept();
		
	}
}
}
