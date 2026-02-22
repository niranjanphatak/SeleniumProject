package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class AccountCreatedPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    By continueBtn = By.linkText("Continue");
    By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountBtn = By.linkText("Delete Account");
    By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");

    // Step 14
    public void verifyAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText));
        Assert.assertTrue(driver.findElement(accountCreatedText).isDisplayed(),
                "Account Created text is not visible");
    }

    // Step 15
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    // Step 16
    public void verifyLoggedInAs(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAsText));
        String actualText = driver.findElement(loggedInAsText).getText();
        Assert.assertTrue(actualText.contains(username),
                "Logged in username not displayed correctly");
    }

    // Step 17
    public void clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountBtn)).click();
    }

    // Step 18
    public void verifyAccountDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedText));
        Assert.assertTrue(driver.findElement(accountDeletedText).isDisplayed(),
                "Account Deleted text not visible");
    }
}