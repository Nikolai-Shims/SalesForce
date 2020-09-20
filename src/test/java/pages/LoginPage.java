package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_FIELD = By.id("username");
    public static final By LOGIN_BUTTON = By.id("Login");
    public static final By PASSWORD_FIELD = By.id("password");

    @Step("Open Login Page")
    public LoginPage openLoginPage() {
        driver.get("https://login.salesforce.com/");
        AllureUtils.takeScreenshot(driver);
        isLoginPageOpen();
        return this;
    }

    @Step("Fill login field")
    public HomePage login(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    @Step("Validate that Login Page was opened")
    public LoginPage isLoginPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
        return this;
    }
}

