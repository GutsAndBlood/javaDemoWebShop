package demoshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsDemoWebShop {
	
	WebDriver driver = null;
	By ButtonAddToCartSmartPhone = By.xpath("(//input[@value='Add to cart'])[1]");
	By ButtonAddToCartPhoneCover = By.xpath("(//input[@value='Add to cart'])[2]");
	
	
	public ElectronicsDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public void ButtonAddToCartSmartPhone() {
		driver.findElement(ButtonAddToCartSmartPhone).click();
	}

	public void ButtonAddToCartPhoneCover() {
		driver.findElement(ButtonAddToCartPhoneCover).click();
	}
	
}
