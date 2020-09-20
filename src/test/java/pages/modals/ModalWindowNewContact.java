package pages.modals;

import elements.Input;
import elements.Select;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;


public class ModalWindowNewContact extends BasePage {

    public ModalWindowNewContact(WebDriver driver) {
        super(driver);
    }

    String button = "button[title='Save']";

    public static final By CLOSE_MODAL_WINDOW = By.cssSelector("button[title='Close this window']");
    public static final By CHOOSE_ACCOUNT = By.cssSelector(".primaryLabel.slds-truncate.slds-lookup__result-text");
    public static final By FIELD_ACCOUNT_NAME = By.xpath("//span[text()='Account Name']/ancestor::div[contains(@class,'uiInput')]//input");

    @Step("Create new Contact")
    public ModalWindowNewContact createNewContact(Contact contact) {
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing State/Province").write(contact.getMailingStateProvince());
        new Input(driver, "Other City").write(contact.getOtherCity());
        new Input(driver, "Other State/Province").write(contact.getOtherStateProvince());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipPostalCode());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        new Input(driver, "Other Zip/Postal Code").write(contact.getOtherZipPostalCode());
        new Input(driver, "Other Country").write(contact.getOtherCountry());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Home Phone").write(contact.getHomePHone());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Other Phone").write(contact.getOtherPhone());
        new Input(driver, "Asst. Phone").write(contact.getAsstPhone());
        new Input(driver, "Assistant").write(contact.getAssistant());
        new TextArea(driver, "Description").write(contact.getDescription());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        new TextArea(driver, "Other Street").write(contact.getOtherStreet());
        new Select(driver, "Salutation").select(contact.getSalutation());
        new Select(driver, "Lead Source").select(contact.getLeadSource());
        return this;
    }

    @Step("Choose \"Save\" or \"Cancel\"")
    public void clickModalWindowButton(String option) {
        try {
            driver.findElement(By.cssSelector(String.format(button, option))).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    @Step("check that modal window was opened")
    public ModalWindowNewContact isNewModalContactOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CLOSE_MODAL_WINDOW));
        return this;
    }

    @Step("Choose account from 'Account name' field")
    public ModalWindowNewContact chooseAccountName() {
        driver.findElement(FIELD_ACCOUNT_NAME).click();
        driver.findElement(CHOOSE_ACCOUNT).click();
        return this;
    }
}
