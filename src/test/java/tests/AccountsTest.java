package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import models.Account;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AccountsTest extends BaseTest {

    @Test(description = "Create new 'Account'")
    @Description("New 'Account' will be create and delete")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void logInToAccountsPage() {
        Account account = new Account("none", "+375291234567", "onliner.by", "10", "Berlin", "Nikolas", "minsk", "24000", "Germeny", "belarus", "525", "-", "125", "Minsk", "victory", "timiriaziva", "Should make fast delivery", "Partner", "Banking");

        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openAccountPage()
                .createAccount()
                .isModalWindowAccountOpen()
                .createAccount(account)
                .clickModalWindowButton("Save");
        accountsPage
                .accountActions("Delete");
        modalWindowDelete
                .isModalWindowDeleteOpened()
                .clickCancelOrDeleteButton("Delete");

    }

}

