package reports;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void logStepInfo(String desc, String status) 
	{
		if (status.toUpperCase().equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, desc);
		}
		else if (status.toUpperCase().equalsIgnoreCase("FAIL"))
		{
			test.log(LogStatus.FAIL, desc );
		}
		else if (status.toUpperCase().equals("INFO"))
		{
			test.log(LogStatus.INFO, desc);
		}
	}

	public static void startReport()
	{
		extent = new ExtentReports("./ExtentReport/Automation_Report.html", true);
		extent.loadConfig(new File("./extent-config.xml"));
	}

	public static void setTestCaseName(String testCaseName, String testDescription ) 
	{
		test = extent.startTest(testCaseName, testDescription);
	}

	public static void endReport() 
	{
		extent.endTest(test);
		extent.flush();
	}
}
