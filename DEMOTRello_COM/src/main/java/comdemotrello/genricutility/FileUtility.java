package comdemotrello.genricutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
	}
	
	public String getDataFromregisterProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/register.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
	}

}
