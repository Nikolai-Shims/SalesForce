package pages.modals;

import elements.Input;
import elements.Select;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountsPage;
import pages.BasePage;

public class ModalWindowNewAccount extends BasePage {

    String button = "button[title= '%s']";

    public static final By CLOSE_MODAL_WINDOW = By.cssSelector("button[title='Close this window']");

    public ModalWindowNewAccount(WebDriver driver) {
        super(driver);
    }

    @Step("Create new account")
    public ModalWindowNewAccount createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Employees").write(account.getEmployee());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new TextArea(driver, "Description").write(account.getDescription());
        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry").select(account.getIndustry());
        return this;
    }

    @Step("Choose \"Save\" or \"Cancel\"")
    public void clickModalWindowButton(String option) {
        try {
            driver.findElement(By.cssSelector(String.format(button, option))).click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
    }

    @Step("Check that modal window was opened")
    public ModalWindowNewAccount isModalWindowAccountOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CLOSE_MODAL_WINDOW));
        return this;
    }

    @Step("Close the modal window")
    public AccountsPage closeModalWindow() {
        driver.findElement(CLOSE_MODAL_WINDOW).click();
        return new AccountsPage(driver);
    }

}
