package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeaderPage {
	
	
	@FindBy (xpath="//a[@class='content tt']")
	private WebElement timeTrack ;
	
	@FindBy (xpath="//a[@class='content tasks']")
	private WebElement task ;
	
	@FindBy (xpath="//a[@class='content reports']")
	private WebElement reports ;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement users ;
	
	@FindBy (xpath="//a[@class='content calendar']")
	private WebElement workSchedule ;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logOut ;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		 wait= new WebDriverWait(driver,20);
		
	}
	
	
	public void clickOnTimeTrack() {
		wait.until(ExpectedConditions.visibilityOf(timeTrack));
		timeTrack.click();
	}
	
	public void clickOnTask() {
		wait.until(ExpectedConditions.visibilityOf(task));
		task.click();
	}
	
	public void clickOnReport() {
		wait.until(ExpectedConditions.visibilityOf(reports));
		reports.click();
	}
	
	public void clickOnUsers() {
		wait.until(ExpectedConditions.visibilityOf(users));
		users.click();
	}
	
	public void clickOnCalender() {
		wait.until(ExpectedConditions.visibilityOf(workSchedule));
		workSchedule.click();
	}
	
	public void clickOnLogout() {
		wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
	}

}
