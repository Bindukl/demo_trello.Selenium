package addtoproduct;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comdemotrello.genricutility.BaseClass;
import comdemotrello.genricutility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class TC_DTS_004_Test extends BaseClass {
	
	@Test
	public void addToCart()
	{
		hp.getAddToCartBtn().get(1).click();
		boolean expectedResult = hp.getConfirmMessags().isDisplayed();
	    Assert.assertEquals(expectedResult, true,"product failed to add");
		eWait.until(ExpectedConditions.invisibilityOf(hp.getConfirmMessags()));
	}
	

}
