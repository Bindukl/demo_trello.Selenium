package comdemotrello.genricutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;



public class ListenerUtility extends BaseClass implements ITestListener  {

	@Override
	public void onTestFailure(ITestResult result)
	
	{
		String methodName=result.getName();
		listTest.log(Status.FAIL, methodName+"is failed");
		TakesScreenshot ts=(TakesScreenshot) driver;
		listTest.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+methodName+time+".png");
		try 
		{
			FileHandler.copy(temp, dest);
			//FileUtils.copyFile(temp, dest);	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
