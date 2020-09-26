package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import pages.modals.ModalWindowDelete;
import pages.modals.ModalWindowEdit;
import pages.modals.ModalWindowNewAccount;
import pages.modals.ModalWindowNewContact;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public final String USERNAME = "nikolai.shims-6cjb@force.com";
    public final String PASSWORD = "1234qwer";

    WebDriver driver;
    LoginPage loginPage;
    ModalWindowNewAccount modalWindowNewAccount;
    HomePage homePage;
    AccountsPage accountsPage;
    ModalWindowDelete modalWindowDelete;
    ContactPage contactPage;
    ModalWindowNewContact modalWindowNewContact;
    ModalWindowEdit modalWindowEdit;

    @BeforeMethod
    public void before(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        modalWindowEdit = new ModalWindowEdit(driver);
        modalWindowNewAccount = new ModalWindowNewAccount(driver);
        homePage = new HomePage(driver);
        modalWindowNewContact = new ModalWindowNewContact(driver);
        contactPage = new ContactPage(driver);
        accountsPage = new AccountsPage(driver);
        modalWindowDelete = new ModalWindowDelete(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    context.setAttribute("driver",driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }

}

