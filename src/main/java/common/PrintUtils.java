package common;

import org.testng.Reporter;

import reports.ExtentReport;

public class PrintUtils {


	public static void logMessage(String logMsg) 
	{
		System.out.println(logMsg);
		Reporter.log(logMsg);
		ExtentReport.logStepInfo(logMsg, "PASS");
	}

	public static void logError(String logMsg) 
	{
		System.err.println(logMsg);
		Reporter.log(logMsg);
		ExtentReport.logStepInfo(logMsg, "FAIL");
	}


}
