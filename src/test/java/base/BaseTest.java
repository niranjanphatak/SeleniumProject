package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
