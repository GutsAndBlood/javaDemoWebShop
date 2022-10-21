package demoshop.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demoshop.pom.LoginDemoWebShop;
import demoshop.pom.MainPageDemoWebShop;
import demoshop.utilities.CredentialsAdminUser;

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
	public void TC01LoginByAdminUser() {
		driver.get("https://demowebshop.tricentis.com/");
		
		MainPageDemoWebShop controllerMainPage = new MainPageDemoWebShop(driver);
		LoginDemoWebShop controllerLogin = new LoginDemoWebShop(driver);
		CredentialsAdminUser credetialsAdminUser = new CredentialsAdminUser();
		
		controllerMainPage.LoginButton();
		controllerLogin.inputMail(credetialsAdminUser.getEmail());
		controllerLogin.inputPassword(credetialsAdminUser.getPassword());
		controllerLogin.buttonLogin();
		
		Assert.assertEquals(controllerMainPage.getTitleMainPage(), "Demo Web Shop");	
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
