package demoshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsDemoWebShop {
	
	WebDriver driver = null;
	By ButtonAddToCartSmartPhone = By.xpath("(//input[@value='Add to cart'])[1]");
	By ButtonAddToCartPhoneCover = By.xpath("(//input[@value='Add to cart'])[2]");
	
	By DropdownPhoneCoverManufacter = By.xpath("//select[@id='product_attribute_80_2_37']");
	By DropdownPhoneCoverColor = By.xpath("//select[@id='product_attribute_80_1_38']");
	By ButtonPhoneCoverAddToCartProductInfo = By.xpath("//input[@id='add-to-cart-button-80']");
	
	By LoadingBlockWindow = By.xpath("//div[@class='ajax-loading-block-window']");
	
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
	
	public void DropdownPhoneCoverManufacter() {
		Select DropdownListManufacter = new Select (driver.findElement(DropdownPhoneCoverManufacter));
		DropdownListManufacter.selectByIndex(1);
		
	}
	
	public void DropdownPhoneCoverColor() {
		Select DropdownListColor = new Select (driver.findElement(DropdownPhoneCoverColor));
		DropdownListColor.selectByIndex(1);
		
	}
	
	public void ButtonPhoneCoverAddToCart() {
		driver.findElement(ButtonPhoneCoverAddToCartProductInfo).click();
	}

	public void LoadingBlockWindow(WebDriverWait wait){
		wait.until( ExpectedConditions.invisibilityOfElementLocated(LoadingBlockWindow));
	}
	
}
