package demoshop.frontend;

import com.beust.jcommander.Parameter;
import demoshop.testbase.TestNG_TestBase;
import frontend.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import demoshop.testbase.CredentialsAdminUser;

public class TestNG_DemoShop extends TestNG_TestBase {

	private LoginDemoWebShop loginPage;
	private CredentialsAdminUser credentialsAdminUser;
	private ElectronicsDemoWebShop electronicsPage;
	private ShoppingCartDemoWebShop shoppingCartPage;
	private CheckoutDemoWebShop checkoutPage;

	@BeforeTest()
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		super.setUp(browser);
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

        Assert.assertTrue(electronicsPage.NavbarUsername());
		electronicsPage.HeaderMenuElectronics();

		electronicsPage.ButtonAddToCartSmartPhone();
		electronicsPage.LoadingBlockWindow();

		electronicsPage.ButtonAddToCartPhoneCover();
		electronicsPage.LoadingBlockWindow();

		electronicsPage.DropdownPhoneCoverManufacture();
		electronicsPage.DropdownPhoneCoverColor();
		electronicsPage.ButtonPhoneCoverAddToCart();
		electronicsPage.LoadingBlockWindow();

		electronicsPage.NavbarShoppingCart();

		Assert.assertEquals("Shopping cart", shoppingCartPage.ShoppingCartHeader());

		shoppingCartPage.CheckboxTermsOfService();
		shoppingCartPage.ButtonShoppingCartCheckout();
	}

	@Test(priority=3)
	public void TC03_purchaseShoppingCart() {
		checkoutPage.ButtonBillingAddressContinue();
		checkoutPage.LoadingBillingAddress();

		checkoutPage.ButtonShippingAddressContinue();
		checkoutPage.LoadingShippingAddress();

		checkoutPage.ButtonShippingMethodContinue();
		checkoutPage.LoadingShippingMethod();

		checkoutPage.ButtonPaymentMethodContinue();
		checkoutPage.LoadingPaymentMethod();

		checkoutPage.ButtonPaymentInformationContinue();
		checkoutPage.LoadingPaymentInfo();

		checkoutPage.ButtonConfirmOrder();
		checkoutPage.LoadingConfirmOrder();

		checkoutPage.ButtonPurchaseSuccess();
		Assert.assertEquals(checkoutPage.getTitleMainPage(), "Demo Web Shop");
	}

	@AfterTest(groups = "regression")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
