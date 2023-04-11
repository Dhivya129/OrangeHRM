package org.demo.OrangeHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveListPage extends BasePage{

	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[1]")
	WebElement fromDateField;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]")
	WebElement toDateField;
	
	@FindBy(xpath="//label[contains(text(),'Show Leave')]//parent::div//following-sibling::div//i[contains(@class,'caret-down-fill')]")
	WebElement leaveStatusBtn;
	
	@FindBy(xpath="//div[@role='listbox']/div[@role='option']")
	List<WebElement> leaveStatusOptions; 
	
	@FindBy(xpath="//div[@role='listbox']/div[@role='option']")
	List<WebElement> leaveTypeOptions;
	
	@FindBy(xpath="//label[contains(text(),'Leave Type')]//parent::div//following-sibling::div//i")
	WebElement leaveTypeBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;
	
	public LeaveListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public void setFromDate(String fromDate)
	{
		fromDateField.clear();
		fromDateField.sendKeys(fromDate);
	}
	
	public void setToDate(String toDate)
	{
		toDateField.clear();
		toDateField.sendKeys(toDate);
	}
	
	public void selectLeaveStatus(String status) {
		int size=leaveStatusOptions.size();
		leaveStatusBtn.click();
		for(int i=0;i<size;i++)
		{
			WebElement element=leaveStatusOptions.get(i);
			if(element.getText().equals(status))
			{
				element.click();
				break;
			}
		}
	}
	
	public void selectLeaveType(String leaveType)
	{
		leaveTypeBtn.click();
		int size=leaveTypeOptions.size();
		for(int i=0;i<size;i++)
		{
			WebElement element=leaveTypeOptions.get(i);
			if(element.getText().equals(leaveType))
			{
				element.click();
				break;
			}
		}
		
	}
	
	public void clickSearchButton() {
		searchBtn.click();
	}
}
