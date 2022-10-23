package demoshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPageDemoWebShop {
	
	WebDriver driver = null;
	
	By NavbarLogin = By.xpath("//a[@class='ico-login']");
	By NavbarUsername = By.xpath("//a[@class='account']");
	By NavbarHomePage = By.xpath("//div/a[@href='/']");
	By NavbarShoppingCart = By.xpath("//a[@class='ico-cart']");
	
	By HeaderMenuElectronics = By.xpath("//a[@href='/electronics']");
	By HeaderMenuElectronicsCellphone = By.xpath("//li/a[@href='/cell-phones']");
	

	public MainPageDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void NavbarLogin() {
		driver.findElement(NavbarLogin).click(); 
	}
	
	public String getTitleMainPage() {
		return driver.getTitle();
	}
	
	public boolean NavbarUsername() {
		return driver.findElement(NavbarUsername).isDisplayed();
	}
	
	public void NavbarHomePage() {
		driver.findElement(NavbarHomePage).click();
	}
	
	public void HeaderMenuElectronics() {
		Actions action = new Actions(driver);
		WebElement hoverElectronicCellphone = driver.findElement(HeaderMenuElectronics);
		action.moveToElement(hoverElectronicCellphone).moveToElement(driver.findElement(HeaderMenuElectronicsCellphone)).click().build().perform();
	}
	
	public void NavbarShoppingCart() {
		driver.findElement(NavbarShoppingCart).click();
	}
}
