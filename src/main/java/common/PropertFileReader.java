package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertFileReader {

	Properties prop=new Properties();

	public PropertFileReader()
	{
		File file =null;
		FileInputStream fis=null;	
		try 
		{
			file= new File("./src/test/resources/config.properties");
			fis = new FileInputStream(file);
			prop.load(fis);
		}
		catch (Exception e)
		{
			PrintUtils.logError("Exception occured while reading config file :: " +e.getMessage());
		}
	}
	
	public String getPropValue(String key) 
	{
		String value =prop.getProperty(key);
		PrintUtils.logMessage(key +" = " +value);
		return value;
	}
}
