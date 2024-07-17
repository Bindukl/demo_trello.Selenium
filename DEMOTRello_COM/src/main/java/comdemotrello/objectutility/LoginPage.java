package comdemotrello.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public  LoginPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement userNameTextFld;
	
	@FindBy(id = "Password")
	private WebElement passwordTextFld;
	
	@FindBy(xpath  = "//input[@value='Log in']")
	private WebElement loginBtn;

	public WebElement getUserNameTextFld() {
		return userNameTextFld;
	}

	public WebElement getPasswordTextFld() {
		return passwordTextFld;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
}
