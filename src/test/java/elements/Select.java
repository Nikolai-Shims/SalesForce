package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select extends BaseElemnt {

    String industry = "//span[text()='%s']/ancestor::div[contains(@class,'uiInputSelect')]//a";
    String optionLocator = "//li//a[@title = '%s']";


    public Select(WebDriver driver, String label) {
        super(driver, label);
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(industry, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
