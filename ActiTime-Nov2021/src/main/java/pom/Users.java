package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users {
	
	@FindBy (xpath="//span[text()='User']")
	private WebElement user ;
	
	@FindBy (xpath="//input[@name='firstName']")
	private WebElement firstName ;
	
	@FindBy (xpath="//input[@name='email']")
	private WebElement email ;
	
	@FindBy (xpath="//input[@name='username']")
	private WebElement userName ;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password ;
	
	@FindBy (xpath="//input[@name='passwordCopy']")
	private WebElement passcopy ;
	
	@FindBy (xpath="//input[@name='lastName']")
	private WebElement lastName ;
	
	@FindBy (xpath="//div[@class='buttonIcon']")
	private WebElement createUser ;
	
	public Users(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyUserText() {
		String text=user.getText();
		return text;
	}
	
	public void clickOnUser() {
		user.click();
	}
	
	public void sendFirstName(String fname) {
		firstName.sendKeys(fname);;
	}
	
	public void sendLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void sendEmail(String emailid) {
		email.sendKeys(emailid);;
	}
	
	public void sendUserName(String uname) {
		userName.sendKeys(uname);;
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);;
	}
	
	public void sendRetypePassword(String copypass) {
		passcopy.sendKeys(copypass);;
	}
	
	public void clickOnCreateUser() {
		createUser.click();
	}
	
}