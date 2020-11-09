package pages.modals;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountsPage;
import pages.BasePage;
import utils.AllureUtils;

public class ModalWindowDelete extends BasePage {

    public static final By CLOSE_MODAL_WINDOW = By.cssSelector("button[title='Close this window']");
    String button = "//span[text()='%s']/ancestor::button";

    public ModalWindowDelete(WebDriver driver) {
        super(driver);
    }

    @Step("Click button \"Cancel\" or \"Delete\"")
    public void clickCancelOrDeleteButton(String option) {
        try {
            driver.findElement(By.xpath(String.format(button, option))).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    @Step("Close modal window")
    public AccountsPage closeModalWindow() {
        driver.findElement(CLOSE_MODAL_WINDOW).click();
        return new AccountsPage(driver);
    }

    @Step("Check that modal window opened")
    public ModalWindowDelete isModalWindowDeleteOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CLOSE_MODAL_WINDOW));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
