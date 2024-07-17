package computers;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comdemotrello.genricutility.BaseClass;

public class TC_DTS_002_Test  extends BaseClass{
	
	@Test
	public void clickComputer() throws EncryptedDocumentException, IOException
	{
		hp.getComputersLink().click();
		String expectedTitle = excelLib.getStringDataFromExcel("Computer",1,0);
		Assert.assertEquals(driver.getTitle(), expectedTitle, "computer is not displayed");
		test.log(Status.PASS, "computer page is displayed");
	}

}
