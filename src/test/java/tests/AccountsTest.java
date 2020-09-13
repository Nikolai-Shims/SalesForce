package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AccountsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, invocationCount = 5)
    public void logInToAccountsPage() throws InterruptedException {
        loginPage
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openPage()
                .createNewModal()
                .isModalOpen()
                .createAccount();

        Thread.sleep(4000);

    }

    @Test
    public void logInToAccountsPage2() throws InterruptedException {
        loginPage
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openPage()
                .createNewModal()
                .isModalOpen()
                .allValue();

        Thread.sleep(4000);


    }
}

