package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class AccountListPage extends BasePage {

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening account-list page")
    public AccountListPage open() {
        log.info("Opening account-list page");
        driver.get("https://kamako7.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        new WebDriverWait(driver, Duration.ofSeconds(20));
        return this;
    }

    @Step("Creation of a new account ")
    public NewAccountModal clickNewAccount() {
        log.info("Creation of a new account");
        driver.findElement(By.cssSelector("a[title='Создать']")).click();
        return new NewAccountModal(driver); // переход на страницу NewAccountModal
    }

    @Override
    public AccountListPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-var-p-right_x-small")));
        return this;
    }
}