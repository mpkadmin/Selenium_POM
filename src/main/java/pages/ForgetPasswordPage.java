package pages;

import org.openqa.selenium.WebDriver;

import common.PrintUtils;
import common.WebDriverGenerics;

public class ForgetPasswordPage  extends WebDriverGenerics{



	WebDriver driver =null;

	public ForgetPasswordPage(WebDriver instance) {

		this.driver=instance;
	}
	
	public void verifyForgetPasswordTitle(String expTitle) 
	{
		if(getTitle(driver).equals(expTitle)) 
		{
			PrintUtils.logMessage("verifyForgetPasswordTitle :: Title matched");
			softAssert(true);
		}else
		{
			PrintUtils.logError("verifyForgetPasswordTitle :: Title not matched");
			softAssert(false);
		}
	}
}
