package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.modals.ModalWindowDelete;
import pages.modals.ModalWindowEdit;
import pages.modals.ModalWindowNewAccount;
import utils.AllureUtils;

import java.util.List;

public class AccountsPage extends BasePage {

    String button = "[title='%s']";
    public static final By BUTTON_NEW = By.cssSelector("[title='New']");
    public static final By ACTIONS_DELETE_EDIT_CHANGEOWNER = By.cssSelector(".slds-button.slds-button--icon-x-small.slds-button--icon-border-filled");
    public static final By COUNT_ACCOUNT = By.xpath("//tbody//tr");


    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Account page")
    public AccountsPage openAccountPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        isAccountPageOpen();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Validate that Account page was opened")
    public AccountsPage isAccountPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BUTTON_NEW));
        return this;
    }

    @Step("Open modal window")
    public ModalWindowNewAccount createAccount() {
        driver.findElement(BUTTON_NEW).click();
        AllureUtils.takeScreenshot(driver);
        return new ModalWindowNewAccount(driver);
    }

    @Step("Choose Delete actions")
    public ModalWindowDelete accountActions(String option) {
        openAccountPage();
        driver.findElement(ACTIONS_DELETE_EDIT_CHANGEOWNER).click();
        driver.findElement(By.cssSelector(String.format(button, option))).click();
        return new ModalWindowDelete(driver);
    }

    @Step("Edit account")
    public ModalWindowEdit editAccount(int index, String option) {
        try {
            List<WebElement> count = driver.findElements(COUNT_ACCOUNT);
            if (count.size() > 0) {
                count.get(index).findElement(ACTIONS_DELETE_EDIT_CHANGEOWNER).click();
                driver.findElement(By.cssSelector(String.format(button, option))).click();
                Thread.sleep(5000);
            } else {
                System.out.println("Нет созданных аккаунтов");
            }
        } catch (InterruptedException e) {
        }
        return new ModalWindowEdit(driver);
    }

}
