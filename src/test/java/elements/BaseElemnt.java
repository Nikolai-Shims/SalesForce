package elements;

import org.openqa.selenium.WebDriver;

public abstract class BaseElemnt {

    WebDriver driver;
    String label;

    public BaseElemnt(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
}
