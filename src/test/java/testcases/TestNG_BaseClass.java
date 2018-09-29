package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import common.PropertFileReader;
import common.WebDriverGenerics;
import pages.ForgetPasswordPage;
import pages.LoginPage;
import reports.ExtentReport;

public class TestNG_BaseClass extends WebDriverGenerics {

	public WebDriver driver =null;
	public String URL =null;
	public String Browser =null;
	
	//page objects
	LoginPage _LoginPage =null;
	ForgetPasswordPage _ForgetPasswordPage=null;
	
	
	@BeforeSuite
	public void BeforeSuite() 
	{
		ExtentReport.startReport();
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("--------------------------------------------------------------");
		sa= new SoftAssert();
	}
	
	@AfterMethod
	public void aeforeMethod() 
	{
		navigate(driver, URL);
		System.out.println("--------------------------------------------------------------");
	}
	
	@BeforeClass
	public void startBrowser() 
	{
		ExtentReport.setTestCaseName("LaunchBrowser", "Browse launch logic");
		//Read prop value from config.properties file
		PropertFileReader obj = new PropertFileReader();
		Browser= obj.getPropValue("Browser");
		URL =obj.getPropValue("URL");
		// Launch browser
		this.driver=launchBrowser(Browser,URL);
		
		// Assign driver to page classes
		
		/* should not create obj as normal 
		 * _LoginPage= new LoginPage(driver);
		 * */
		
		//create obj using PageFactory concept
		_LoginPage =PageFactory.initElements(driver, LoginPage.class);
		_ForgetPasswordPage =PageFactory.initElements(driver, ForgetPasswordPage.class);
	}
	
	@AfterClass 
	public void killBrowser() 
	{
		quit(driver);
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		ExtentReport.endReport();
	}
}
