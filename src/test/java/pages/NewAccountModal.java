package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;

@Log4j2

public class NewAccountModal extends BasePage {

    public static final By SAVE = By.cssSelector("[title=Сохранить]");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Input information new account")
    public NewAccountModal createNewAccount(Account account) {
        log.info("Creation of account", account);
        new Input(driver, "Имя организации").inputAccountInfo(account.getAccountName());
        new DropDown(driver, "Тип").selectAccountInfo(account.getType());
        new Input(driver, "Веб-узел").inputAccountInfo(account.getWebsite());
        new Input(driver, "Тел.").inputAccountInfo(account.getNumber());
        new DropDown(driver, "Отрасль").selectAccountInfo(account.getIndustry());
        new Input(driver, "Город для счета").inputAccountInfo(account.getAccountCity());
        new Input(driver, "Почтовый индекс для счета").inputAccountInfo(account.getAccountIndex());
        new Input(driver, "Город для доставки").inputAccountInfo(account.getDeliveryCity());
        new Input(driver, "Почтовый индекс для доставки").inputAccountInfo(account.getDeliveryIndex());
        return this;
    }

    public void save() {
        driver.findElement(SAVE).click();
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-var-p-right_x-small")));
        return this;
    }
}
