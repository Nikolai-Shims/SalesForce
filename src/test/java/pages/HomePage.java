package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class HomePage extends BasePage {
    public static final By HEADER = By.id("trial-subscribe-now");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate that Home page was opened")
    public HomePage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HEADER));
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}

