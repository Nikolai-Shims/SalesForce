package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseElement {

    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInputTextArea')]//textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }


}
