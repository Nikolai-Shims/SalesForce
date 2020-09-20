package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElemnt {


    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        super(driver, label);

    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).clear();
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }
}
