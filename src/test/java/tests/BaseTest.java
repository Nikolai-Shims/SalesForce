package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountModal;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public final String USERNAME = "nikolai.shims-6cjb@force.com";
    public final String PASSWORD = "1234qwer";

    WebDriver driver;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    HomePage homePage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }

}

