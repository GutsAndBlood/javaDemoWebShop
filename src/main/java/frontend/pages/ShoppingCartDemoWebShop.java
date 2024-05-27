package frontend.pages;

import frontend.abstracts.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartDemoWebShop extends MainFrame {

	By ButtonShoppingCartCheckout = By.xpath("//button[@id='checkout']");
	By CheckboxTermsOfService = By.xpath("//input[@id='termsofservice']");
	By shoppingCartHeader = By.xpath("//h1[contains(text(),'Shopping cart')]");
	
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

	public String ShoppingCartHeader() {
		return driver.findElement(shoppingCartHeader).getText();
	}

}
