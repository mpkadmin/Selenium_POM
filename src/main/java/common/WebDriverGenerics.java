package common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class WebDriverGenerics {

	public static SoftAssert sa ;

	public WebDriver launchBrowser(String browserName,String url) 
	{
		WebDriver driver=null;

		if(driver==null)
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();	
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("launchBrowser :: this  " + url + "has been opened in " + browserName +"browser successfully");
		return driver;
	}

	// to get the title of the web browser
	public String  getTitle(WebDriver driver) {

		String Title = driver.getTitle();
		PrintUtils.logMessage("GetTitle:: The ActualTitle is :: " + Title);
		return Title;
	} 

	// to close the browser
	public void close(WebDriver driver) {

		driver.close();
		PrintUtils.logMessage("close :: the browser is closed");
	}

	// to quit the whole session
	public void quit(WebDriver driver) {
		driver.quit();
		PrintUtils.logMessage("Quit: the session has been ended");
	}

	// to go the given url
	public void get(WebDriver driver, String url)
	{
		driver.get(url);
		PrintUtils.logMessage("get:: the specified url has been launched successfully");
	}

	// to get the url of the current web browser
	public String getCurrentUrl(WebDriver driver)
	{
		String url =  driver.getCurrentUrl();
		PrintUtils.logMessage("GetCurrenturl:: the current url is " + url);
		return url;
	}

	// navigate to the given url
	public void navigate(WebDriver driver, String url)
	{
		driver.navigate().to(url);
		PrintUtils.logMessage("navigate :: the browser has been navigated to the specified url");
	}

	//get the session id or the parentwindow
	public String getParentSessionId(WebDriver driver)
	{

		String parentwindowid = driver.getWindowHandle();
		PrintUtils.logMessage("getwindowhandle :: the current window Id is" + parentwindowid);
		return parentwindowid;
	}

	//to navigate the browser back
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
		PrintUtils.logMessage("navigateback :: the browser has navigated back");
	}

	//to navigate the browser forward
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
		PrintUtils.logMessage("navigateforward :: the page has been forwarded");
	}

	//to click the given web element
	public void click(WebElement element)
	{
		element.click();
		PrintUtils.logMessage("click:: the element clicked");
	}

	//to clear the text in the given webelement
	public  void clear(WebElement element) {
		element.clear();
		PrintUtils.logMessage("clear:: the text cleared");
	}


	//to give the value to the given webelement
	public void sendKeys(WebElement element, String value) {

		element.sendKeys(value);
		PrintUtils.logMessage("sendkeys :: Typed value as ::"+ value);
	}

	// for get the text of the given webelement
	public String getText(WebElement element)
	{
		String text = element.getText();
		PrintUtils.logMessage("getText:: the text of the given webelement is " + text);
		return text;
	}

	// to get the attribute value of the given webelement
	public String getAttribute(WebElement element, String attribute)
	{
		String att = element.getAttribute(attribute);
		PrintUtils.logMessage("The attribute value of given element is " + att);
		return att;

	}

	// ------------- Alerts -----------------

	// to accept the alert
	public void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
		PrintUtils.logMessage("acceptalert :: alert accepted");
	}

	// to dismiss the alert
	public void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		PrintUtils.logMessage("dismissalert:: alert dismissed");
	}

	//to get the text in alert box
	public String getTextAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		PrintUtils.logMessage("gettextalert :: the text in alert box is " + text);
		return text;
	}

	//to give the text value in alert box
	public void sendKeysAlert(WebDriver driver, String value)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(value);
		PrintUtils.logMessage("sendkeysalert :: the value has been given in alert box");
	}


	// --------------- dropdownlist -------------------

	// to select the value from dropdownlist using index
	public void selectIndex(WebElement element, int index)
	{
		Select obj = new Select(element);
		
		obj.selectByIndex(index);
		PrintUtils.logMessage("selectIndex :: the specified index value has selected");
	}

	// to select the value from dropdownlist using value
	public void selectValue(WebElement element, String value)
	{
		Select obj = new Select(element);
		obj.selectByValue(value);
		PrintUtils.logMessage("selectValue :: the specified value has selected");
	}

	//to select the value form dropdownlist using visibletext
	public void selectVisibleText(WebElement element, String text)
	{
		Select  obj = new Select(element);
		obj.selectByVisibleText(text);
		PrintUtils.logMessage("selectVisibleText :: the given text has selected");
	}

	//to get the size of dropdownlist
	public int dropdownSize(WebElement element)
	{
		Select obj = new Select(element);
		int count = obj.getOptions().size();
		PrintUtils.logMessage("dropdownsize:: the size of the dropdownlist is " + count);
		return count;
	}

	//to get the text of the select value in dropdownlist
	public String getFirstSelectedOption(WebElement element)
	{
		Select obj = new Select(element);
		String text = obj.getFirstSelectedOption().getText();
		PrintUtils.logMessage("getvaluefromdropdown :: the text of the selecteditem in dropdown list is " + text);
		return text;
	}

	//-----------------------Frames ---------------------

	// switch to the frame using index
	public void frameOfIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		PrintUtils.logMessage("frameofIndex :: driver switched to given frame");
	}

	//switch to the frame using id or name
	public void frameOfString(WebDriver driver, String Text)
	{
		driver.switchTo().frame(Text);
		PrintUtils.logMessage("frameofString :: driver switched to given frame");
	}

	//switch to the frame using webelement
	public void frameOfWebElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
		PrintUtils.logMessage("frameofWebElement :: driver switched to given frame");
	}

	// switch the driver control to default page
	public void defaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		PrintUtils.logMessage("defaultcontent :: switched to default content");
	}

	// -------------------- WebElementCommands ---------------

	//to check whether the given web element is selected
	public boolean isSelected(WebElement element) 
	{		
		boolean status =true;
		if(element.isSelected())
		{
			PrintUtils.logMessage("isSelected :: the element is selected");
		}
		else 
		{
			PrintUtils.logError("isSelected :: the element is not selected");
			status=false;
		}
		return status;
	}

	//to check whether the given element is enabled
	public void isEnabled(WebElement element) 
	{
		if(element.isEnabled()) 
		{
			PrintUtils.logMessage("isEnabled :: the element is enabled");
		}
		else 
		{
			PrintUtils.logError("isEnabled :: the element is disabled");
		}
	}

	//to check whether the given element is displayed
	public void isDisplayed(WebElement element) 
	{
		try 
		{		
			if(element.isDisplayed())
			{
				PrintUtils.logMessage("isDisplayed :: the element is displayed");
			}
		}
		catch(Exception e) 
		{
			PrintUtils.logError("Element not displayed, exception occurred" + e.getMessage());
		}
	}

	//  ------------------ action class ------------

	//to perform right click operation with given webelement
	public void contextClick(WebDriver driver, WebElement element)
	{
		Actions obj = new Actions(driver);
		obj.contextClick(element);
		PrintUtils.logMessage("contextclick :: the context click action performed");
	}

	// to perform drag and drop operation
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions obj = new Actions(driver);
		obj.dragAndDrop(source, target);
		PrintUtils.logMessage("draganddrop :: drag and drop action has performed");
	}

	//to perform double click operaiton in given webelement
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions obj = new Actions(driver);
		obj.doubleClick(element);
		PrintUtils.logMessage("doubleclick :: double click action has performed");
	}

	//to perform mouse hover operation with specified webelement
	public void hover(WebDriver driver, WebElement element)
	{
		Actions obj = new Actions(driver);
		obj.moveToElement(element);
		PrintUtils.logMessage("movetoelement :: mouse position moved to given element");
	}

	// for setting customized size to browser
	public void customizeBrowserSize(WebDriver driver, int x, int y)
	{
		Dimension dim = new Dimension(x, y);
		driver.manage().window().setSize(dim);
		PrintUtils.logMessage("customizebrowsersize :: the given dimension has set to browser");
	}

	// for highlight the specific webelement
	public void highlightElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", ele);
		PrintUtils.logMessage("highlightElement :: the given elemnet has been highlighted");
	}

	//  to scroll the page to view the given webelement
	public  void scrollElementIntoView(WebDriver driver, WebElement Element) 
	{
		// used to scroll the element into view 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
		PrintUtils.logMessage("scrollElementIntoView :: Scrolled the page to view the given element");;
	}

	// take screenshot
	public void takeScreenShot(WebDriver driver, String imgName)   
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		try {
			FileUtils.copyFile(src, new File("./ScreenShot/"+imgName+".png"));
			PrintUtils.logMessage("takeScreenShot :: image has been saved");
		}
		catch(IOException e)
		{
			PrintUtils.logError("takeScreenShot :: exception occurred");
		}
	} 

	/*Implicit wait means that we can tell Selenium that we would like it to wait 
		for a certain amount of time before throwing an exception that it cannot 
		find the element on the page. 
	 */
	//implicit wait (applicable for all web element in webdriver)
	public static void implicitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	/*	Explicit Wait
		It is more extendible in the means that you can set it up to wait for any
		condition you might like. Usually, you can use some of the prebuilt
		ExpectedConditions to wait for elements to become clickable, visible, 
		invisible, etc.*/

	public static void explicitWait(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*	Fluent Wait
		Each FluentWait instance defines the maximum amount of time to wait for a condition,
		as well as the frequency with which to check the condition. Furthermore, 
		the user may configure the wait to ignore specific types of exceptions 
		whilst waiting, such as NoSuchElementExceptions when searching for an element 
		on the page.*/

	@SuppressWarnings("unchecked")
	public static void fluentWait(WebDriver driver, int time, int pollingtime)
	{
		Wait wait = new FluentWait(driver).withTimeout(time, TimeUnit.SECONDS).pollingEvery(pollingtime, TimeUnit.SECONDS);
	}


	public void softAssert(boolean actual) 
	{
		if(actual)
		{
			sa.assertEquals(actual, true);
			PrintUtils.logMessage("SoftAssert Passed");
		}else 
		{
			sa.fail();
			PrintUtils.logError("SoftAssert Failed");
		}
	}

	public void assertAll() 
	{
		sa.assertAll();
	}






















}
