package demoshop.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;


public abstract class TestNG_TestBase {

    protected WebDriver driver;

    @Parameters("browser")
    public void setUp(String browser) {

        System.out.println("Setting browser: " + browser);
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterSuite(groups = "regression")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
