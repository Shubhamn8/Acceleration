package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task {
	
	@FindBy (xpath="//a[text()='Open Tasks']")
	private WebElement openTaskTab;
	
	@FindBy (xpath="//a[text()='Completed Tasks']")
	private WebElement completedTaskTab;
	
	@FindBy (xpath="//a[text()='Projects & Customers']")
	private WebElement projectandcustomersTab;

	@FindBy (xpath="//a[text()='Archives']")
	private WebElement archivesTab;
	
	
	@FindBy (xpath="//span[text()='Create Tasks']")
	private WebElement createTask;
	
	@FindBy (xpath="(//button[@type='button'])[1]")
	private WebElement dropDown;
	
	@FindBy (xpath="(//ul[@class='x-menu-list']//li)[2]")
	private WebElement selectNewCustomer;
	
	@FindBy (xpath="//input[@id='createTasksPopup_newCustomer']")
	private WebElement enterCustomerName;
	
	@FindBy (xpath="//input[@id='createTasksPopup_newProject']")
	private WebElement enterProjectName;
	
	@FindBy (xpath="(//input[@class='inputFieldWithPlaceholder'])[1]")
	private WebElement enterTaskName1;
	
	@FindBy (xpath="//div[@id='createTasksPopup_commitBtn']")
	private WebElement taskCreated;
	
	@FindBy (xpath="//input[@type='checkbox']")
	private WebElement selectTaskCheckBox;
	
	@FindBy (xpath="//input[@value='Complete Selected Tasks']")
	private WebElement completeSelectedTaskCheckBox;
	
	
	public Task(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnOpenTaskTab() {
		openTaskTab.click();	
	}
	
	public void clickOnCreateTask() {
		createTask.click();	
	}
	
	public void clickOnDropdown() {
		dropDown.click();	
	}
	
	public void clickNewCustomer() {
		selectNewCustomer.click();	
	}
	
	public void customerName() {
		enterCustomerName.sendKeys("TATA");;	
	}
	
	public void projectName() {
		enterProjectName.sendKeys("Vehicle design");;	
	}

	public void taskName() {
		enterTaskName1.sendKeys("Design Blue Print");;	
	}
	
	public void taskCreated() {
		taskCreated.click();	
	}
	
	public void selectTaskCheckBox() {
		selectTaskCheckBox.click();	
	}
	
	public void completeSelectedTaskCheckBox(){
		completeSelectedTaskCheckBox.click();	
	}
	
	public void clickOnCompletedTaskTab(){
		completedTaskTab.click();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


