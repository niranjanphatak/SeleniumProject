package tests;

import base.BaseTest;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.AccountCreatedPage;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {

        HomePage home = new HomePage(driver);
        SignupLoginPage signup = new SignupLoginPage(driver);
        AccountCreatedPage account = new AccountCreatedPage(driver);

        String username = "John";
        String email = "test" + System.currentTimeMillis() + "@mail.com";

        home.verifyHomePageVisible();
        home.clickSignupLogin();

        signup.verifyNewUserSignupVisible();
        signup.enterNameAndEmail(username, email);
        signup.clickSignup();
        signup.verifyEnterAccountInfoVisible();
        signup.fillAccountInformation();
        signup.clickCreateAccount();

        account.verifyAccountCreated();
        account.clickContinue();
        account.verifyLoggedInAs(username);
        account.clickDeleteAccount();
        account.verifyAccountDeleted();
        account.clickContinue();
    }
}