package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Select {

    WebDriver driver;
    String label;
    String industry = "//span[text()='%s']/ancestor::div[contains(@class,'uiInputSelect')]//a";
    String optionLocator = "//li//a[@title = '%s']";


    public Select(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(industry, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void getAllValue() {
        driver.findElement(By.xpath(String.format(industry, label))).click();
        List<WebElement> list = driver.findElements(By.cssSelector(".uiMenuItem.uiRadioMenuItem"));
        System.out.println(list.size());
    }
}
