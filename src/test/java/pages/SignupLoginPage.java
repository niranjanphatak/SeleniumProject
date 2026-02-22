package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class SignupLoginPage {
    WebDriver driver;

    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
    }

    //locators
    By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    By enterAccountInfoText = By.xpath("//b[text()='Enter Account Information']");
    By titleMr = By.id("id_gender1");
    By password = By.id("password");
    By day = By.id("days");
    By month = By.id("months");
    By year = By.id("years");
    By newsletter = By.id("newsletter");
    By offers = By.id("optin");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address = By.id("address1");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public void verifyNewUserSignupVisible(){
        Assert.assertTrue(driver.findElement(newUserSignupText).isDisplayed());
    }
    public void clickSignup(){
        driver.findElement(signupBtn).click();
    }
    public void verifyEnterAccountInfoVisible(){
        Assert.assertTrue(driver.findElement(enterAccountInfoText).isDisplayed());
    }
    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }
    public void fillAccountInformation() {
        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys("Test1234");
        driver.findElement(day).sendKeys("10");
        driver.findElement(month).sendKeys("May");
        driver.findElement(year).sendKeys("1995");
        driver.findElement(newsletter).click();
        driver.findElement(offers).click();
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(company).sendKeys("TestCompany");
        driver.findElement(address).sendKeys("123 Street");
        driver.findElement(country).sendKeys("India");
        driver.findElement(state).sendKeys("Karnataka");
        driver.findElement(city).sendKeys("Bangalore");
        driver.findElement(zipcode).sendKeys("560001");
        driver.findElement(mobile).sendKeys("9999999999");
    }
    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }
}
