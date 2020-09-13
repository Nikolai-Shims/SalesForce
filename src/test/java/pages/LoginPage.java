package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_FIELD = By.id("username");
    public static final By LOGIN_BUTTON = By.id("Login");
    public static final By PASSWORD_FIELD = By.id("password");


    public HomePage login(String username, String password) {
        driver.get("https://login.salesforce.com/");
        isPageOpen();
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
    }
}

