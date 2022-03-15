package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.Loginpage;
import pom.Task;
import pom.Users;
import utils.Utility;



public class CreateUserAndTask extends Browser {
	
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private Loginpage loginpage;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browsername) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		if(browsername.equals("chrome")) {
			
			driver=launchChromeBrowser();
		}
		if(browsername.equals("firefox")) {
			
			driver=launchFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Application launched on browser");
		
	}
	@BeforeClass
	public void createPOMObject() {
		driver.get("http://localhost/login.do");
		loginpage =new Loginpage(driver);
		applicationHeaderPage= new ApplicationHeaderPage(driver);
	}

	@BeforeMethod
	public void launchToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		
		String username=Utility.getDataFromExcelSheet("Login", 0, 1);
		String password=Utility.getDataFromExcelSheet("Login", 1, 1);
		loginpage.sendUserName(username);
		loginpage.sendPassword(password);
		loginpage.clickOnKeepMeLogInCheckbox();
		loginpage.clickOnLogin();
		System.out.println("Login successfully");
		Thread.sleep(2000);
	}
	
	@Test
	public void createUser() throws EncryptedDocumentException, IOException {
		testID="TC04";
		
		System.out.println("create user");
		applicationHeaderPage.clickOnUsers();
	    Users users=new Users(driver);
		
	    String firstname=Utility.getDataFromExcelSheet("Users", 1, 0);
	    String lastname=Utility.getDataFromExcelSheet("Users", 1, 1);
	    String email=Utility.getDataFromExcelSheet("Users", 1, 2);
	    String username=Utility.getDataFromExcelSheet("Users", 1, 3);
	    String password=Utility.getDataFromExcelSheet("Users", 1, 4);
		users.clickOnUser();
		users.sendFirstName(firstname);
		users.sendLastName(lastname);
		users.sendEmail(email);
		users.sendUserName(username);
		users.sendPassword(password);
		users.sendRetypePassword(password);
	    users.clickOnCreateUser(); 
		System.out.println("User added sucessfully");
		System.out.println(testID+" passed");
	}
	
	@Test
	public void createTask() {
		testID="TC05";
		System.out.println("Create Task");
        applicationHeaderPage.clickOnTask();
	    System.out.println("Task page open");
		Task task =new Task(driver);
		 
		task.clickOnCreateTask();
		task.clickOnDropdown();
		task.clickNewCustomer();
		task.customerName();
		task.projectName();
		task.taskName();
	 
		task.taskCreated();
		 
		System.out.println("Task created sucessfully");
		System.out.println(testID+" passed");
	
	}
	
	@AfterMethod
	public void logOut(ITestResult result) throws InterruptedException, IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			Utility.screenshot(driver, testID);
		}
		System.out.println("logOut");
		Thread.sleep(2000);
		applicationHeaderPage.clickOnLogout();
	}
	
	@AfterClass
	public void clearPOMObject() {
		loginpage =null;
		applicationHeaderPage= null;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("closeBrowser");
		driver.close();
		driver=null;
		System.gc();
	}
	
}
