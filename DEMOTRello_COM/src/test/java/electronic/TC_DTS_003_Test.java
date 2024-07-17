package electronic;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comdemotrello.genricutility.BaseClass;

public class TC_DTS_003_Test extends BaseClass {
	
	@Test
	public void clickElectronic() throws EncryptedDocumentException, IOException {
		
		hp.getElectronicsLink().click();
		String expectedTitle = excelLib.getStringDataFromExcel("Electronics",1,0);
		Assert.assertEquals(driver.getTitle(), expectedTitle, "computer is not displayed");
		test.log(Status.PASS, "electronic page is displayed");
	}

}
