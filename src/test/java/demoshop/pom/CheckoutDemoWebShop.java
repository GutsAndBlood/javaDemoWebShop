package demoshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutDemoWebShop {
	
	WebDriver driver = null;
	
	By ButtonBillingAddressContinue = By.xpath("//input[@onclick='Billing.save()']");
	By ButtonShippingAddressContinue = By.xpath("//input[@onclick='Shipping.save()']");
	By ButtonShippingMethodContinue = By.xpath("//input[@onclick='ShippingMethod.save()']");
	By ButtonPaymentMethodContinue = By.xpath("//input[@onclick='PaymentMethod.save()']");
	By ButtonPaymentInformationContinue = By.xpath("//input[@onclick='PaymentInfo.save()']");
	By ButtonConfirmOrder = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	By ButtonPurcharseSuccess = By.xpath("//input[@class='button-2 order-completed-continue-button']");

	public CheckoutDemoWebShop(WebDriver driver) {
		super();
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
	
	public void ButtonPurcharseSuccess() {
		driver.findElement(ButtonPurcharseSuccess).click();
	}
}
