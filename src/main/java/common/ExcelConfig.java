package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reports.ExtentReport;

public class ExcelConfig {

	XSSFWorkbook wb;
	XSSFSheet sh ;
	public HashMap<String, String> hmap;
	public String TestCaseName;
	public String TestDescription;
	public String TestData;
	
	public ExcelConfig(String sheetName) {

		File file = new File(".\\ExcelDatas\\TestData.xlsx");
		FileInputStream fis=null;
		try 
		{
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e)
		{ 
			PrintUtils.logError("FileNotFoundException occures in Excelconfig class");
		}
		try
		{
			wb= new XSSFWorkbook(fis);
		} 
		catch (IOException e)
		{
			PrintUtils.logError("IOException occures in Excelconfig class");
		}
		sh =wb.getSheet(sheetName);
	}
	
	public void getTestData(String testName) 
	{
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
		TestCaseName =sh.getRow(i).getCell(0).getStringCellValue();
		
		if(TestCaseName.equals(testName))
		{
		TestDescription =sh.getRow(i).getCell(1).getStringCellValue();
		TestData =sh.getRow(i).getCell(2).getStringCellValue();
		splitData(TestData);
		
		ExtentReport.setTestCaseName(TestCaseName, TestDescription);
		
		PrintUtils.logMessage("TestName :: "+TestCaseName);
		PrintUtils.logMessage("Test Description ::" +TestDescription);
		PrintUtils.logMessage("TestData :: "+hmap.entrySet());
		break;
		}
		}	
	}

	public void splitData(String value) 
	{
		hmap =new HashMap<String, String>();
		for(int i =0; i<value.split("#").length;i++)
		{
			String KeyValue= value.split("#")[i];
			hmap.put(KeyValue.split("=")[0],KeyValue.split("=")[1]);
		}
	}




}
