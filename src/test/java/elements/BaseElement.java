package elements;

import org.openqa.selenium.WebDriver;

public class BaseElement {

    WebDriver driver;
    String label;

    public BaseElement(WebDriver driver, String label){
        this.driver = driver;
        this.label = label;
    }
}
