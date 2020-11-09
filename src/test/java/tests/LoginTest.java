package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Log into the 'SalesForce'")
    @Description("Fill 'Username input' and 'Password input' correct data, validate that validation was correctly ")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void login() {
        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
    }
}
