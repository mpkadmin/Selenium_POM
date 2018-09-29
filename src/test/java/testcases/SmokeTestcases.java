package testcases;

import org.testng.annotations.*;

import common.ExcelConfig;
import common.PrintUtils;

public class SmokeTestcases extends TestNG_BaseClass{

	ExcelConfig excel = new ExcelConfig("SmokeTest");

	@Test(enabled=true)
	public void loginWithValidTestData() 
	{
		excel.getTestData("loginWithValidTestData");
		try 
		{
			PrintUtils.logMessage("am loginWithValidTestData");
			_LoginPage.enterValidCredentials(excel.hmap.get("userName"),excel.hmap.get("Password"),excel.hmap.get("ExpectedTitle"));
		}catch (Exception e) 
		{
			PrintUtils.logError("TestCase Catch Block executed");
		}
		finally 
		{
			assertAll();
		}
	}

	@Test(enabled=true)
	public void verifyForgetPasswordLink() {

		excel.getTestData("verifyForgetPasswordLink");
		try {
		PrintUtils.logMessage("am verifyForgetPasswordLink");
		_LoginPage.clickForgetPasswordLink();
		_ForgetPasswordPage.verifyForgetPasswordTitle(excel.hmap.get("ExpectedTitle"));
		}catch (Exception e) 
		{
			PrintUtils.logError("TestCase Catch Block executed");
		}finally 
		{
			assertAll();
		}
	}



}
