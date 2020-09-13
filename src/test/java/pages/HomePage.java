package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public static final By HEADER = By.id("trial-subscribe-now");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HEADER));
        return this;
    }
}

