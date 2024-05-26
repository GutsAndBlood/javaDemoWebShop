package frontend.pages;

import frontend.abstracts.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginDemoWebShop extends MainFrame {
	

	By inputMail = By.xpath("//input[@id='Email']");
	By inputPassword = By.xpath("//input[@id='Password']");
	By buttonLogin = By.xpath("//input[@class='button-1 login-button']");

	public LoginDemoWebShop(WebDriver driver) {
		super(driver);
	}
	
	public void inputMail(String mail) {
		driver.findElement(inputMail).sendKeys(mail);
	}
	
	public void inputPassword(String password) {
		driver.findElement(inputPassword).sendKeys(password);
	}

	public void buttonLogin() {
		driver.findElement(buttonLogin).click();
	}
}
