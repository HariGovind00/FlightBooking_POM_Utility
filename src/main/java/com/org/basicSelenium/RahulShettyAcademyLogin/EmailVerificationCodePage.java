package com.org.basicSelenium.RahulShettyAcademyLogin;

import org.openqa.selenium.By;

import UtilityActionMethods.Action;

public class EmailVerificationCodePage extends Action
{
private By verifcationCode=By.id("code");

public void verifyCode(String code)
{
	sendKeyAction(verifcationCode, code);
}
}
