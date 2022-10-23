package demoshop.testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demoshop.pom.ElectronicsDemoWebShop;
import demoshop.pom.LoginDemoWebShop;
import demoshop.pom.MainPageDemoWebShop;
import demoshop.utilities.CredentialsAdminUser;

public class MainFuntionalityDemoShop {
	
	private WebDriver driver;
	private String driverPath=System.getProperty("user.dir");
	
	@BeforeTest
	public void StartUp() {
		
			  
		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();		  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=1)
	public void TC01LoginByAdminUser() {
		driver.get("https://demowebshop.tricentis.com/");
		
		MainPageDemoWebShop controllerMainPage = new MainPageDemoWebShop(driver);
		LoginDemoWebShop controllerLogin = new LoginDemoWebShop(driver);
		CredentialsAdminUser credetialsAdminUser = new CredentialsAdminUser();
		
		controllerMainPage.NavbarLogin();
		controllerLogin.inputMail(credetialsAdminUser.getEmail());
		controllerLogin.inputPassword(credetialsAdminUser.getPassword());
		controllerLogin.buttonLogin();
		
		Assert.assertEquals(controllerMainPage.getTitleMainPage(), "Demo Web Shop");	
	}
	
	@Test(priority=2)
	public void TC02AddingTwoProductsToShoppingCart() {
		
		MainPageDemoWebShop controllerMainPage = new MainPageDemoWebShop(driver);
		ElectronicsDemoWebShop controllerElectronics = new ElectronicsDemoWebShop(driver);
		
		Assert.assertEquals(controllerMainPage.NavbarUsername(), true);
		
		controllerMainPage.HeaderMenuElectronics();
		controllerElectronics.ButtonAddToCartSmartPhone();
		
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
