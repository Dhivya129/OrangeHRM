package org.demo.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

	@FindBy(xpath="//a[contains(@href,'viewAdminModule')]")
	WebElement adminModuleLink;
	
	@FindBy(xpath="//a[contains(@href,'viewLeaveModule')]")
	WebElement leaveModuleLink;
	
	@FindBy(xpath="//img[contains(@src,'orangehrm-logo.png')]")
	WebElement logoImage;
	
	
	
	public IndexPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickAdminModule()
	{
		adminModuleLink.click();
	}
	
	public void clickLeaveModule()
	{
		leaveModuleLink.click();
	}
	
	public boolean verifyLogoPresent()
	{
		System.out.println("Logo present: "+logoImage.isDisplayed());
		return logoImage.isDisplayed();

	}

	
}
