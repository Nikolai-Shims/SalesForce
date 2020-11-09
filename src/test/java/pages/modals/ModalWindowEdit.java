package pages.modals;

import elements.Input;
import elements.Select;
import elements.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ModalWindowEdit extends BasePage {

    public static final By CLOSE_MODAL_WINDOW = By.cssSelector("button[title='Close this window']");
    String button = "button[title='Save']";

    public ModalWindowEdit(WebDriver driver) {
        super(driver);
    }

    @Step("Edit 'Input field' data")
    public ModalWindowEdit editInput(String inputName, String text) {
        new Input(driver, inputName).write(text);
        return this;
    }

    @Step("Edit 'Tex Area' data")
    public ModalWindowEdit editTextArea(String textAreaName, String text) {
        new TextArea(driver, textAreaName).write(text);
        return this;
    }

    @Step("Edit 'Select' data")
    public ModalWindowEdit editSelect(String selectName, String option) {
        new Select(driver, selectName).select(option);
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


}
