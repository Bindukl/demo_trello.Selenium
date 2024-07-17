package comdemotrello.objectutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		
			PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText = "Books")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement computersLink;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> addToCartBtn;
	
	@FindBy(xpath = "//p[contains(text(),'The product has been added')]")
	private WebElement confirmMessags;
	
	public WebElement getConfirmMessags() {
		return confirmMessags;
	}

	public List<WebElement> getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	@FindBy(partialLinkText = "Electronics")
	private WebElement electronicsLink;

}
