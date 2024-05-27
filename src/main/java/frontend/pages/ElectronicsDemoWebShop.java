package frontend.pages;

import frontend.abstracts.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElectronicsDemoWebShop extends MainFrame {
	
	By ButtonAddToCartSmartPhone = By.xpath("(//input[@value='Add to cart'])[1]");
	By ButtonAddToCartPhoneCover = By.xpath("(//input[@value='Add to cart'])[2]");
	
	By DropdownPhoneCoverManufacture = By.xpath("//select[@id='product_attribute_80_2_37']");
	By DropdownPhoneCoverColor = By.xpath("//select[@id='product_attribute_80_1_38']");
	By ButtonPhoneCoverAddToCartProductInfo = By.xpath("//input[@id='add-to-cart-button-80']");
	
	By LoadingBlockWindow = By.xpath("//div[@class='ajax-loading-block-window']");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


	public ElectronicsDemoWebShop(WebDriver driver) {
		super(driver);
	}

	public void ButtonAddToCartSmartPhone() {
		driver.findElement(ButtonAddToCartSmartPhone).click();
	}

	public void ButtonAddToCartPhoneCover() {
		driver.findElement(ButtonAddToCartPhoneCover).click();
	}
	
	public void DropdownPhoneCoverManufacture() {
		Select DropdownListManufacture = new Select (driver.findElement(DropdownPhoneCoverManufacture));
		DropdownListManufacture.selectByIndex(1);
	}
	
	public void DropdownPhoneCoverColor() {
		Select DropdownListColor = new Select (driver.findElement(DropdownPhoneCoverColor));
		DropdownListColor.selectByIndex(1);
	}
	
	public void ButtonPhoneCoverAddToCart() {
		driver.findElement(ButtonPhoneCoverAddToCartProductInfo).click();
	}

	public void LoadingBlockWindow(){
		wait.until( ExpectedConditions.invisibilityOfElementLocated(LoadingBlockWindow));
	}
	
}
