package pages;

import elements.Input;
import elements.Select;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModal extends BasePage {

    public static final By CANCEL_BUTTON = By.cssSelector("[title='Save']");
    public static final By SAVE_BUTTON = By.cssSelector("[title='Save']");
    public static final By EDIT_BUTTON = By.cssSelector("[title='Edit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal createAccount() {
        new Input(driver, "Account Name").write("Nikolay-11");
        new Input(driver, "Phone").write("+356787876786");
        new Input(driver, "Fax").write("none");
        new Input(driver, "Website").write("tut.by");
        new Input(driver, "Employees").write("9");
        new Input(driver, "Annual Revenue").write("24 000$");
        new Input(driver, "Billing City").write("Minsk");
        new Input(driver, "Shipping City").write("Grodno");
        new Input(driver, "Billing State/Province").write("Minsk");
        new Input(driver, "Shipping State/Province").write("Grodno");
        new Input(driver, "Billing Zip/Postal Code").write("525");
        new Input(driver, "Billing Country").write("Belarus");
        new Input(driver, "Shipping Zip/Postal Code").write("125");
        new Input(driver, "Shipping Country").write("Belarus");

        new TextArea(driver, "Billing Street").write("Timiriazeva");
        new TextArea(driver, "Shipping Street").write("Revolutcionnaia");
        new TextArea(driver, "Description").write("Should make a fast delivery");

        new Select(driver, "Type").select("Partner");
        new Select(driver, "Industry").select("Education");

        driver.findElement(SAVE_BUTTON).click();
    return this;
    }

    public void allValue(){
        new Select(driver,"Type").getAllValue();
    }
    public NewAccountModal isModalOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CANCEL_BUTTON));
        return this;
    }

}
