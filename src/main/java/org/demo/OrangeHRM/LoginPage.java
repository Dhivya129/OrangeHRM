package org.demo.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	

@FindBy(name="username")
WebElement usernameField;

@FindBy(name="password")
WebElement passwordField;

@FindBy(xpath="//button[@type='submit']")
WebElement loginButton;

@FindBy(xpath="//p[text()='Forgot your password? ']")
WebElement forgotPwd;


public LoginPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver,this);
		}
public void setUsername(String uname)
{
	usernameField.sendKeys(uname);
}

public void setPassword(String pwd)
{
	passwordField.sendKeys(pwd);
}
public void clickLoginButton()
{
   loginButton.click();	
}

}
