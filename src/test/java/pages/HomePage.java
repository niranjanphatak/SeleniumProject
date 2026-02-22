package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class HomePage {
    WebDriver driver;

    By homeLogo = By.xpath("//img[@alt='Website for automation practice']");
    By signupLoginBtn = By.linkText("Signup / Login");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyHomePageVisible(){
        Assert.assertTrue(driver.findElement(homeLogo).isDisplayed());
    }

    public void clickSignupLogin(){
        driver.findElement(signupLoginBtn).click();
    }
}
