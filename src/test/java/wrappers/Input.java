package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2


public class Input {
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputAccountInfo(String text) {
        log.info("Input account info");
        driver.findElement(By.xpath(
                String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)
        )).sendKeys(text);
    }

    public void inputContactInfo(String text) {
        log.info("Input contact info");
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::div[contains(@class, 'slds-form-element')]", label))).sendKeys(text);
    }
}
