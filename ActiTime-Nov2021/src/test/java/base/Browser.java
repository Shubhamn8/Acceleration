package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
		public static WebDriver launchChromeBrowser() {
		
		System.setProperty("webdriver.edge.driver","D:\\Software testing\\program\\msedgedriver.exe");
	    WebDriver driver =new EdgeDriver();
	    return driver;
	}
	
	public static WebDriver launchFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver","D:\\Software testing\\program\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
	    return driver;
	}
}
