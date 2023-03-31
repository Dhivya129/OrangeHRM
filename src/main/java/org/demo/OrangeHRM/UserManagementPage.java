package org.demo.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends BasePage {

	@FindBy(xpath="(//div/input[@class='oxd-input oxd-input--active'])[2]")
	WebElement userNameField;
	
	@FindBy(xpath="//label[text()='User Role']/parent::div/following-sibling::div//i")
	WebElement userRoleButton;
	
	@FindBy(xpath="//div[@role='option']/span[text()='Admin']")
	WebElement userRoleOption;
	

    @FindBy(xpath="//label[text()='Status']/parent::div/following-sibling::div//i")
	WebElement statusButton;
	
	@FindBy(xpath="//div[@role='option']/span[text()='Enabled']")
	WebElement statusOption;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButton;
	
	public UserManagementPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements( driver,this);
	}
	
	public void setUserNameField()
	{
		userNameField.sendKeys("Admin");
	}
	
	public void selectUserRole()
	{
		userRoleButton.click();
		System.out.println("user role:"+userRoleOption.getText());
		userRoleOption.click();
	}
   public void selectStatus()
	{
		statusButton.click();
		statusOption.click();
		System.out.println("Status: "+statusOption.getText());
	} 
	public void clickSearch()
	{
		searchButton.click();
	}

}
