package comdemotrello.genricutility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import comdemotrello.genricutility.ExcelUtility;
import comdemotrello.genricutility.FileUtility;
import comdemotrello.genricutility.JavaUtility;
import comdemotrello.objectutility.HomePage;
import comdemotrello.objectutility.LoginPage;

import comdemotrello.objectutility.WelcomePage;



public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports extReport;
	public ExtentTest test;
	public static ExtentTest listTest;
	
	public WebDriverWait eWait;
	
	public FileUtility fileLib;
	public ExcelUtility excelLib;
	public JavaUtility javaLib;
	public static String time;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	;
	
	@BeforeSuite(alwaysRun = true)
	public void configReport()
	{
		javaLib=new JavaUtility();
		time=javaLib.getSystemTime();
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Report/EcommerceRepport"+time+".html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
		
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional ("chrome") String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		eWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		fileLib=new FileUtility();
		driver.get(fileLib.getDataFromProperty("url"));
	}
	
@BeforeMethod(alwaysRun = true)
	
	public void login(Method method) throws IOException
	{
	test=extReport.createTest(method.getName());
	listTest=test;
	wp=new WelcomePage(driver);
	wp.getLoginLink().click();
	lp=new LoginPage(driver);
	String email = fileLib.getDataFromProperty("email");
	String password = fileLib.getDataFromProperty("password");
	lp.getUserNameTextFld().sendKeys(email);
	lp.getPasswordTextFld().sendKeys(password);
	lp.getLoginBtn().click();
	//eLib=new ExcelUtility();
	excelLib=new ExcelUtility();
	String expectedTitle = excelLib.getStringDataFromExcel("Login",1,0);
	Assert.assertEquals(driver.getTitle(), expectedTitle, "user failed to login");
	test.log(Status.PASS, "home page is displayed");
	
	hp=new HomePage(driver);
	
	}

@AfterMethod(alwaysRun = true)
public void logout()
{
	
	hp.getLogoutLink().click();
	test.log(Status.INFO, "user loged out");
}
	
@AfterClass(alwaysRun = true)
public void closeBrowser()
{
	driver.quit();
}
@AfterSuite(alwaysRun = true)

public void reportBackup()
{
	extReport.flush();
}
	

}
