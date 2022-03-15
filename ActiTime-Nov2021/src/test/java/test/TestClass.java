package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pom.ApplicationHeaderPage;
import pom.Loginpage;
import pom.Task;
import pom.Users;

public class TestClass {
	
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","D:\\Software testing\\program\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://localhost/login.do");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Application launched on browser");
		
		Loginpage loginpage =new Loginpage(driver);
//		loginpage.sendUserName();
//		loginpage.sendPassword();
		loginpage.clickOnKeepMeLogInCheckbox();
		loginpage.clickOnLogin();
		
		Thread.sleep(3000);
		
		System.out.println("Login successfully on Actitime");
		
		ApplicationHeaderPage applicationHeaderPage= new ApplicationHeaderPage(driver);
		applicationHeaderPage.clickOnUsers();
	
		 String url=driver.getCurrentUrl();
		 String title=driver.getTitle();
		 
		 Assert.assertEquals(url, "http://localhost/administration/userlist.do");
		 
//		 System.out.println("Tile:"+ title);
//		 
//		 if(url.equals("http://localhost/administration/userlist.do"))
//		 {
//			 System.out.println("User page open");
//		 }
//		 else
//		 {
//			 System.out.println("User page not open");
//		 }
		
		 Thread.sleep(3000);
		 
		 Users users=new Users(driver);
		 
//		 users.clickOnUser();Thread.sleep(3000);
//		 users.sendFirstName();
//		 users.sendLastName();
//		 users.sendEmail();
//		 users.sendUserName();
//		 users.sendPassword();
//		 users.sendRetypePassword();Thread.sleep(3000);
		 users.clickOnCreateUser(); Thread.sleep(3000);
		 
		 System.out.println("User added sucessfully");
		 
		 applicationHeaderPage.clickOnTask();Thread.sleep(3000);
		 
		 System.out.println("Task page open");
		 
		 Task task =new Task(driver);
		 
		 task.clickOnCreateTask();
		 task.clickOnDropdown();
		 task.clickNewCustomer();
		 task.customerName();
		 task.projectName();
		 task.taskName();
		 
		 Thread.sleep(3000);
		 
		 task.taskCreated();
		 
		 System.out.println("Task created sucessfully");
		 
		 Thread.sleep(3000);
		 
		 task.selectTaskCheckBox();
		 task.completeSelectedTaskCheckBox();
		 
		 Thread.sleep(3000);
		 
		 task.clickOnCompletedTaskTab();
		 
		 System.out.println("Task Completed");
		 
		 applicationHeaderPage.clickOnLogout();

		 
		 
		 
	
	}

}
