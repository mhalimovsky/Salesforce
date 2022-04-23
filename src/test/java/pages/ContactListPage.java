package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage extends BasePage {

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening contact-list page")
    public ContactListPage open() {
        driver.get("https://kamako7.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        new WebDriverWait(driver, Duration.ofSeconds(20));
        return this;
    }

    @Step("Creation of a new contact")
    public NewContactModal clickNewContact() {
        driver.findElement(By.cssSelector("a[title='Создать']")).click();
        return new NewContactModal(driver); // переход на страницу NewContactModal
    }

    @Override
    public ContactListPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-var-p-right_x-small")));
        return this;
    }
}
