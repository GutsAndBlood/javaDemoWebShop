package frontend.pages;

import frontend.abstracts.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartDemoWebShop extends MainFrame {

	WebDriver driver = null;
	By ButtonShoppingCartCheckout = By.xpath("//button[@id='checkout']");
	By CheckboxTermsOfService = By.xpath("//input[@id='termsofservice']");
	
	public ShoppingCartDemoWebShop(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void ButtonShoppingCartCheckout() {
		driver.findElement(ButtonShoppingCartCheckout).click();
	}
	
	public void CheckboxTermsOfService() {
		driver.findElement(CheckboxTermsOfService).click();;
	}
}
