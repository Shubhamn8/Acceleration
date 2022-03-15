package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.Loginpage;
import pom.Users;
import utils.Utility;

public class VerifyTab extends Browser {
	
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private Loginpage loginpage;
	private SoftAssert soft;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browsername ) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Launch Browser");
		
		if(browsername.equals("chrome"))
		{
		driver=launchChromeBrowser();
		}
		
		if(browsername.equals("firefox"))
		{
		driver=launchFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Application launched on browser");
		
	}
	
	
	@BeforeClass
	public void  createObjectOfPOMClass() {
		
		driver.get("http://localhost/login.do");
		loginpage =new Loginpage(driver);
		applicationHeaderPage= new ApplicationHeaderPage(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		
		String username=Utility.getDataFromExcelSheet("Login", 0, 1);
		String password=Utility.getDataFromExcelSheet("Login", 1, 1);
		
		loginpage.sendUserName(username);
		loginpage.sendPassword(password);
		loginpage.clickOnKeepMeLogInCheckbox();
		loginpage.clickOnLogin();
		System.out.println("Login successfully");	
		Thread.sleep(2000);
	}
	
	
	@Test(priority=1)
	public void timeTrack() throws InterruptedException {
		testID="TC01";
		String url=driver.getCurrentUrl();
		 String title=driver.getTitle();
		 
		 Assert.assertEquals(url, "http://localhost/user/submit_tt.do");
		 
//		 System.out.println("Tile:"+ title);
//		 
//		 if(url.equals("http://localhost/user/submit_tt.do"))
//		 {
//			 System.out.println("User page open");
//		 }
//		 else
//		 {
//			 System.out.println("User page not open");
//		 }
		 System.out.println("Title:"+ title);
		 System.out.println(testID+" passed");
		 Thread.sleep(3000);
		
	}
	
	@Test(priority=3)
	public void reports() throws InterruptedException {
		testID="TC03";
		applicationHeaderPage.clickOnReport();
		String url=driver.getCurrentUrl();
		 String title=driver.getTitle();
		 
		 System.out.println("Title:"+ title);
		 System.out.println(testID+" passed");
		
	}
	
	@Test(priority=2)
	public void users() throws InterruptedException {
		testID="TC02";
	    soft = new SoftAssert();
		applicationHeaderPage.clickOnUsers();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		Assert.assertEquals(url, "http://localhost/administration/userlist.do");
		//Assert.fail();
		Users users = new Users(driver);
		String user=users.verifyUserText();
		soft.assertEquals(user, "User","Text is wrong");
		soft.assertAll(); 	 
		System.out.println("Title:"+ title);
		System.out.println(testID+" passed");
	}
	
	@AfterMethod
	public void logOut(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			Utility.screenshot(driver, testID);
		}
		applicationHeaderPage.clickOnLogout();	
	}
	
	@AfterClass
	public void clearPOMObject() {
		loginpage =null;
		applicationHeaderPage= null;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Close browser");
		driver.quit();
		driver=null;
		System.gc();
	}

}
