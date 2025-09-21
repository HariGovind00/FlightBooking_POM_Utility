package com.org.basicSelenium.RahulShettyAcademyLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import UtilityActionMethods.Action;

public class LoginPage extends Action
{

	private By username=By.id("name");
	private By email=By.id("email");
	private By legalTerms=By.id("agreeTerms");
	private By loginBtn=By.id("form-submit");
	
	public void usernameField(String user)
	{
		sendKeyAction(username, user);
	}
	
	public void emailField(String emailpass)
	{
		sendKeyAction(email,emailpass);
	}
	
	public void teamsClick()
	{
		click(legalTerms);
	}
	
	public RahulShettyHomePage clickLogin() throws InterruptedException
	{
		
		click(loginBtn);
		Thread.sleep(1000);
		return new RahulShettyHomePage();
		
	}
}
