package demoshop.testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demoshop.pom.CheckoutDemoWebShop;
import demoshop.pom.ElectronicsDemoWebShop;
import demoshop.pom.LoginDemoWebShop;
import demoshop.pom.MainPageDemoWebShop;
import demoshop.pom.ShoppingCartDemoWebShop;
import demoshop.utilities.CredentialsAdminUser;

public class MainFuntionalityDemoShop {
	
	private WebDriver driver;
	private String driverPath=System.getProperty("user.dir");


	
	@BeforeTest
	public void StartUp() {
		
			  
		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver");
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
		ShoppingCartDemoWebShop controllerShoppingCart = new ShoppingCartDemoWebShop(driver);
		CheckoutDemoWebShop controllerCheckout = new CheckoutDemoWebShop(driver);
		
		Assert.assertEquals(controllerMainPage.NavbarUsername(), true);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 

		
		controllerMainPage.HeaderMenuElectronics();
		
		controllerElectronics.ButtonAddToCartSmartPhone();
		controllerElectronics.LoadingBlockWindow(wait);

		controllerElectronics.ButtonAddToCartPhoneCover();
		controllerElectronics.LoadingBlockWindow(wait);

		controllerElectronics.DropdownPhoneCoverManufacter();
		controllerElectronics.DropdownPhoneCoverColor();
		controllerElectronics.ButtonPhoneCoverAddToCart();
		controllerElectronics.LoadingBlockWindow(wait);

		controllerMainPage.NavbarShoppingCart();
		
		controllerShoppingCart.CheckboxTermsOfService();
		controllerShoppingCart.ButtonShoppingCartCheckout();
		

		controllerCheckout.ButtonBillingAddressContinue();
		controllerCheckout.LoadingBillingAddress(wait);

		controllerCheckout.ButtonShippingAddressContinue();
		controllerCheckout.LoadingShippingAddress(wait);

		controllerCheckout.ButtonShippingMethodContinue();
		controllerCheckout.LoadingShippingMethod(wait);

		controllerCheckout.ButtonPaymentMethodContinue();
		controllerCheckout.LoadingPaymentMethod(wait);

		controllerCheckout.ButtonPaymentInformationContinue();
		controllerCheckout.LoadingPaymentInfo(wait);

		controllerCheckout.ButtonConfirmOrder();
		controllerCheckout.LoadingConfirmOrder(wait);

		controllerCheckout.ButtonPurcharseSuccess();
		
		Assert.assertEquals(controllerMainPage.getTitleMainPage(), "Demo Web Shop");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
