package books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.HPSFException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comdemotrello.genricutility.BaseClass;
import comdemotrello.genricutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DTS_001_Test extends BaseClass {
	
	@Test
	public void clickBooks() throws EncryptedDocumentException, IOException
	{
		hp.getBooksLink().click();
		String expectedTitle = excelLib.getStringDataFromExcel("Books",1,0);
		Assert.assertEquals(driver.getTitle(), expectedTitle, "books is not displayed");
		test.log(Status.PASS, "books page is displayed");
	}

}
