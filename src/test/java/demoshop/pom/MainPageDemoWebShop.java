package demoshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageDemoWebShop {
	
	WebDriver driver = null;
	
	By LoginButton = By.xpath("//a[@class='ico-login']");

	public MainPageDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void LoginButton() {
		driver.findElement(LoginButton).click(); 
	}
	
	public String getTitleMainPage() {
		return driver.getTitle();
	}
	
}
