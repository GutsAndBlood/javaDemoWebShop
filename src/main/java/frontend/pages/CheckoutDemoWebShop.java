package frontend.pages;

import frontend.abstracts.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutDemoWebShop extends MainFrame {
	
	WebDriver driver = null;
	
	By ButtonBillingAddressContinue = By.xpath("//input[@onclick='Billing.save()']");
	By ButtonShippingAddressContinue = By.xpath("//input[@onclick='Shipping.save()']");
	By ButtonShippingMethodContinue = By.xpath("//input[@onclick='ShippingMethod.save()']");
	By ButtonPaymentMethodContinue = By.xpath("//input[@onclick='PaymentMethod.save()']");
	By ButtonPaymentInformationContinue = By.xpath("//input[@onclick='PaymentInfo.save()']");
	By ButtonConfirmOrder = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	By ButtonPurchaseSuccess = By.xpath("//input[@class='button-2 order-completed-continue-button']");

	By LoadingBillingAddress = By.xpath("//span[@id='billing-please-wait']");
	By LoadingShippingAddress = By.xpath("//span[@id='shipping-please-wait']");
	By LoadingShippingMethod = By.xpath("//*[@id='shipping-method-please-wait']");
	By LoadingPaymentMethod = By.xpath("//span[@id='payment-method-please-wait']");
	By LoadingPaymentInfo = By.xpath("//span[@id='payment-info-please-wait']");
	By LoadingConfirmOrder = By.xpath("//span[@id='confirm-order-please-wait']");

	

	public CheckoutDemoWebShop(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void ButtonBillingAddressContinue() {
		driver.findElement(ButtonBillingAddressContinue).click();
	}
	
	public void ButtonShippingAddressContinue() {
		driver.findElement(ButtonShippingAddressContinue).click();;
	}
	
	public void ButtonShippingMethodContinue() {
		driver.findElement(ButtonShippingMethodContinue).click();
	}

	public void ButtonPaymentMethodContinue() {
		driver.findElement(ButtonPaymentMethodContinue).click();
	}
	
	public void ButtonPaymentInformationContinue() {
		driver.findElement(ButtonPaymentInformationContinue).click();
	}
	
	public void ButtonConfirmOrder() {
		driver.findElement(ButtonConfirmOrder).click();
	}
	
	public void ButtonPurchaseSuccess() {
		driver.findElement(ButtonPurchaseSuccess).click();
	}

	public void LoadingBillingAddress(WebDriverWait wait){
		
		wait.until( ExpectedConditions.invisibilityOfElementLocated(LoadingBillingAddress));
	}

	public void LoadingShippingAddress(WebDriverWait wait){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadingShippingAddress));
	}

	public void LoadingShippingMethod(WebDriverWait wait){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadingShippingMethod));
	}

	public void LoadingPaymentMethod(WebDriverWait wait){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadingPaymentMethod));
	}

	public void LoadingPaymentInfo(WebDriverWait wait){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadingPaymentInfo));
	}

	public void LoadingConfirmOrder(WebDriverWait wait){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadingConfirmOrder));
	}
}
