package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.modals.ModalWindowDelete;
import pages.modals.ModalWindowEdit;
import pages.modals.ModalWindowNewContact;
import utils.AllureUtils;

import java.util.List;

public class ContactPage extends BasePage {

    String button = "[title='%s']";
    public static final By BUTTON_NEW = By.cssSelector("div[title='New']");
    public static final By ACTIONS_DELETE_EDIT_CHANGEOWNER = By.cssSelector(".slds-button.slds-button--icon-x-small.slds-button--icon-border-filled");
    public static final By COUNT_CONTACT = By.xpath("//tbody//tr");


    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Step("open Contact page")
    public ContactPage openContactPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        driver.navigate().refresh();
        isContactPageOpened();
        return this;
    }

    @Step("Check that Contact page was opened")
    public ContactPage isContactPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BUTTON_NEW));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Create new Contact")
    public ModalWindowNewContact createContact() {
        driver.findElement(BUTTON_NEW).click();
        return new ModalWindowNewContact(driver);
    }


    @Step("Choose Delete actions")
    public ModalWindowDelete contactActions(String option) {
        openContactPage();
        driver.findElement(ACTIONS_DELETE_EDIT_CHANGEOWNER).click();
        driver.findElement(By.cssSelector(String.format(button, option))).click();
        return new ModalWindowDelete(driver);
    }

    @Step("Edit Contact")
    public ModalWindowEdit editContact(int index, String option) {
        try {
            List<WebElement> count = driver.findElements(COUNT_CONTACT);
            System.out.println(count.size());
            if (count.size() > 0) {
                count.get(index).findElement(ACTIONS_DELETE_EDIT_CHANGEOWNER).click();
                driver.findElement(By.cssSelector(String.format(button, option))).click();
                Thread.sleep(5000);
            } else {
                System.out.println("Нет созданных аккаунтов");
            }
        } catch (InterruptedException ex) {

        }
        return new ModalWindowEdit(driver);
    }

}
