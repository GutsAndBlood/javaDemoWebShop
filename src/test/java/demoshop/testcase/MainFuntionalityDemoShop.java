package demoshop.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainFuntionalityDemoShop {
	
	WebDriver driver;
	String driverPath=System.getProperty("user.dir");
	
	@BeforeTest
	public void StartUp() {
		
			  
		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();		  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		

	}
	
	@Test
	public void Testcase01() {
		driver.get("https://www.google.com/"); 
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
