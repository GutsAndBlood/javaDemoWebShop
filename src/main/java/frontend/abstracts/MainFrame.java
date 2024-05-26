package frontend.abstracts;

import frontend.pages.LoginDemoWebShop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MainFrame {

    By NavbarLogin = By.xpath("//a[@class='ico-login']");
    By NavbarUsername = By.xpath("//a[@class='account']");
    By NavbarHomePage = By.xpath("//div/a[@href='/']");
    By NavbarShoppingCart = By.xpath("//a[@class='ico-cart']");

    By HeaderMenuElectronics = By.xpath("//a[@href='/electronics']");
    By HeaderMenuElectronicsCellphone = By.xpath("//li/a[@href='/cell-phones']");

    public WebDriver driver;

    public MainFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginPage() {
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
