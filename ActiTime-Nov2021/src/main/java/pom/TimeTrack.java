package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeTrack {
	
	@FindBy (xpath="//span[@onclick='openAddNewTasksPopup();']")
	private WebElement newTask;
	
	@FindBy (xpath="(//button[@type='button'])[1]")
	private WebElement selectCustomer;
	
	
	@FindBy (xpath="((//ul[@class='x-menu-list'])[2]//li)[2]")
	private WebElement newCustomer;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public TimeTrack(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	    wait= new WebDriverWait(driver,20);
		
	}
	
	
	public void clickOnNew() {
		wait.until(ExpectedConditions.visibilityOf(newTask));
		newTask.click();
	}
	
	public void clickOnselectCustomer() {
		wait.until(ExpectedConditions.visibilityOf(selectCustomer));
		selectCustomer.click();
	}
	
	public void clickOnnewCustomer() {
		wait.until(ExpectedConditions.visibilityOf(newCustomer));
		newCustomer.click();
	}
}
