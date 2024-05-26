package demoshop.testcase;

import java.time.Duration;

import frontend.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demoshop.utilities.CredentialsAdminUser;

public class TestNG_DemoShop {
	private WebDriver driver;
	private LoginDemoWebShop loginPage;
	private CredentialsAdminUser credentialsAdminUser;
	private ElectronicsDemoWebShop electronicsPage;
	private ShoppingCartDemoWebShop shoppingCartPage;
	private CheckoutDemoWebShop checkoutPage;

	
	@BeforeTest
	public void StartUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demowebshop.tricentis.com/");
		loginPage = new LoginDemoWebShop(driver);
		credentialsAdminUser = new CredentialsAdminUser();
		electronicsPage = new ElectronicsDemoWebShop(driver);
		shoppingCartPage = new ShoppingCartDemoWebShop(driver);
		checkoutPage = new CheckoutDemoWebShop(driver);
	}
	
	@Test(priority=1)
	public void TC01_LoginByAdminUser() {
		loginPage.clickOnLoginPage();
		loginPage.inputMail(credentialsAdminUser.getEmail());
		loginPage.inputPassword(credentialsAdminUser.getPassword());
		loginPage.buttonLogin();
		Assert.assertEquals(loginPage.getTitleMainPage(), "Demo Web Shop");
	}

	@Test(priority=2)
	public void TC02_AddingTwoProductsToShoppingCart() {
		Assert.assertEquals(electronicsPage.NavbarUsername(), true);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		electronicsPage.HeaderMenuElectronics();

		electronicsPage.ButtonAddToCartSmartPhone();
		electronicsPage.LoadingBlockWindow(wait);

		electronicsPage.ButtonAddToCartPhoneCover();
		electronicsPage.LoadingBlockWindow(wait);

		electronicsPage.DropdownPhoneCoverManufacture();
		electronicsPage.DropdownPhoneCoverColor();
		electronicsPage.ButtonPhoneCoverAddToCart();
		electronicsPage.LoadingBlockWindow(wait);

		electronicsPage.NavbarShoppingCart();

		shoppingCartPage.CheckboxTermsOfService();
		shoppingCartPage.ButtonShoppingCartCheckout();


		checkoutPage.ButtonBillingAddressContinue();
		checkoutPage.LoadingBillingAddress(wait);

		checkoutPage.ButtonShippingAddressContinue();
		checkoutPage.LoadingShippingAddress(wait);

		checkoutPage.ButtonShippingMethodContinue();
		checkoutPage.LoadingShippingMethod(wait);

		checkoutPage.ButtonPaymentMethodContinue();
		checkoutPage.LoadingPaymentMethod(wait);

		checkoutPage.ButtonPaymentInformationContinue();
		checkoutPage.LoadingPaymentInfo(wait);

		checkoutPage.ButtonConfirmOrder();
		checkoutPage.LoadingConfirmOrder(wait);

		checkoutPage.ButtonPurchaseSuccess();

		Assert.assertEquals(checkoutPage.getTitleMainPage(), "Demo Web Shop");
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
