package org.demo.OrangeHRM;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class HRMTest extends BaseTest{

	LoginPage lp=null;
	IndexPage ip=null;
	LeaveListPage leavePage;
	UserManagementPage up=null;
	
	private static final Logger log = LogManager.getLogger(HRMTest.class.getName());
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException
	{ 
		test=extent.createTest("Login Test");
		lp=new LoginPage(driver);
		leavePage=new LeaveListPage(driver);
		ip=new IndexPage(driver);
		lp.setUsername("Admin");
		test.log(Status.INFO,"Username was entered");
		lp.setPassword("admin123");
		test.log(Status.INFO,"Password was entered");
		lp.clickLoginButton();
		test.log(Status.INFO,"Login Button was clicked");
		if(ip.verifyLogoPresent())
		{
			test.log(Status.PASS,"Logged in successfully");
			Assert.assertTrue(ip.verifyLogoPresent());	
			log.info("login successful");
		}
		else {
			test.log(Status.FAIL,"Login failed");
			log.error("login failed");
		Assert.assertTrue(ip.verifyLogoPresent());
		}
	

		

	}
	@Test(priority=1)
	public void userManagementTest()
	{
		up=new UserManagementPage(driver);
		ip=new IndexPage(driver);

		try {
		ip.clickAdminModule();
		test.log(Status.INFO,"Admin Module is clicked");
		up.setUserNameField();
		test.log(Status.INFO,"Username was entered");
		up.selectUserRole();
		test.log(Status.INFO,"User Role was selected");
		up.selectStatus();
		test.log(Status.INFO,"Status was selected");
		up.clickSearch();
		test.log(Status.INFO,"Search Button was clicked");
		log.info("Searched for user");
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}
	@Test(priority=2)
	public void leaveListTest()
	{
		try {
			ip.clickLeaveModule();
			test.log(Status.INFO,"Leave Module is clicked");
			leavePage.setFromDate("2023-1-20");
			test.log(Status.INFO,"From Date is selected");
			leavePage.setToDate("2023-1-25");
			test.log(Status.INFO,"To Date is selected");
			leavePage.selectLeaveStatus("Taken");
			test.log(Status.INFO,"Leave Status is selected");
			leavePage.selectLeaveType("CAN - Personal");
			test.log(Status.INFO,"Leave Type is selected");
			leavePage.clickSearchButton();
			
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}
	
	
}
