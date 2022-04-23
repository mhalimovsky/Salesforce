package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class DropDown {

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectAccountInfo(String option) {
        log.info("Selecting account info");
        driver.findElement(By.xpath(
                String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label))).click();
        driver.findElement(By.cssSelector(String.format("a[title=%s", option))).click();
    }

    public void selectContactInfo(String option) {
        log.info("Selecting contact info");
        driver.findElement(By.xpath(String.format("//span[text()='%s']" +
                "//ancestor::div[contains(@class, 'slds-form-element__control')]", label))).click();
        driver.findElement(By.cssSelector(String.format("a[title=%s", option))).click();
    }
}