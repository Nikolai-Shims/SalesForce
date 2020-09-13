package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    public static final By NEW_BUTTON = By.cssSelector("[title='New']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        isPageOpen();
        return this;
    }

    public AccountsPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NEW_BUTTON));
        return this;
    }

    public NewAccountModal createNewModal() {
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }

}
