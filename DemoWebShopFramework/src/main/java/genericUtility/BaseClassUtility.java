package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClassUtility {
	private static final String Sheet1 = null;
	public static ExtentReports eReport;
	public static WebDriver driver;
	public static ExtentTest test;
	
	public WebDriverUtility wutil = new WebDriverUtility();
	public FileUtility futil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public ExcelUtility eutil = new ExcelUtility();

	/**
	 * This Method is use for report configuration
	 */
@BeforeSuite
  public void reportConfiguration() {
	ExtentSparkReporter spark =new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jutil.getSystemTime()+".html");
    eReport = new ExtentReports();
	eReport.attachReporter(spark);
}

/**
 * This Method is use to open browser and enter url
 * @throws IOException
 */
@BeforeClass
public void openBrowser() throws IOException {
	driver = new EdgeDriver();
	wutil.maximize(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(futil.getDataFromProperty("url"));
	 
}

/**
 * This Method is used to login and send data to the text fields
 * @throws IOException
 */
@BeforeMethod
public void login() throws IOException {
	WelcomePage wp = new WelcomePage(driver);
	wp.getLoginLink().click();
	
	LoginPage lp = new LoginPage(driver);
	lp.getEmailtextfield().sendKeys(futil.getDataFromProperty("email"));
	lp.getPasswordtextfield().sendKeys(futil.getDataFromProperty("password"));
	lp.getLoginbutton().click();
	
}

/**
 * This Method is used to logout
 */
@AfterMethod
public void logout() {
	
	HomePage hp = new HomePage(driver);
	hp.getLogoutlink().click();
}


@AfterClass
public void closeBrowser() {
	driver.quit();
}


@AfterSuite
public void reportBackup() {
	eReport.flush();
}
}
