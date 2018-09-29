package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.PrintUtils;
import common.WebDriverGenerics;

public class LoginPage extends WebDriverGenerics {

	WebDriver driver =null;
	
	public LoginPage(WebDriver instance) {
	
		this.driver=instance;
	}
	
	// Webelement
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LogIn;
	
	@FindBy(linkText="Forgotten account?")
	WebElement forgetPassword;
	
	
	public void enterValidCredentials(String email,String pass, String expectedTitle) 
	{
		sendKeys(userName,email);
		sendKeys(password, pass);
		click(LogIn);			 
		PrintUtils.logMessage("Successfully Logged in");
		
		String actualValue=getTitle(driver);
		if(actualValue.equals(expectedTitle))
		{
			PrintUtils.logMessage("enterValidCredentials:: Title mathed");
			softAssert(true);
		}else 
		{
			PrintUtils.logError("enterValidCredentials:: Title not matched");
			softAssert(false);
		}
	}
	
	public ForgetPasswordPage clickForgetPasswordLink() 
	{
		click(forgetPassword);
		PrintUtils.logMessage("Navigating to forgetPassword Page");
		return new ForgetPasswordPage(driver);
	}
	
	
	
	
}



















