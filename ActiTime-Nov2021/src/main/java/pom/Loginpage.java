package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
	
	
	@FindBy (xpath="//input[@name='username']") //@FindBY--->findElements(By.xpath("");
	private WebElement userName ;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password ;
	
	@FindBy (xpath="//input[@name='remember']")
	private WebElement keepMeLoggedInCheckbox ;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement login ;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,20);
	}
	
	public void sendUserName(String user)
	{
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void clickOnKeepMeLogInCheckbox()
	{
		if(!(keepMeLoggedInCheckbox.isSelected()))
		{
			keepMeLoggedInCheckbox.click();
		}
		else
		{
			System.out.println("Keep Me Login Checkbox is selected");
		}
	}
	
	public void clickOnLogin()
	{
	   login.click();
	}

}
