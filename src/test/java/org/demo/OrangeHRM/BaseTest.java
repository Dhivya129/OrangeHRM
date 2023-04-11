package org.demo.OrangeHRM;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	WebDriver driver=null;
	ExtentReports extent;
	ExtentTest test;
	String baseUrl;
	
	@BeforeClass
	public void setUp()
	{
		extent=new ExtentReports();
	    extent.setSystemInfo("Project Name","OrangeHRM Automation");
	    extent.setSystemInfo("Orginastion Name", "OrangeHRM");
	    ExtentSparkReporter reporter=new ExtentSparkReporter("ExtentReports/ExtentReport.html");
	    extent.attachReporter(reporter);

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		baseUrl="https://opensource-demo.orangehrmlive.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		extent.flush();
		driver.quit();
	}
}
