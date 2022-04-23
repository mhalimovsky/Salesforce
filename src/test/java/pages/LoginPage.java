package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2

public class LoginPage extends BasePage {

    public static final By USER_INFO_INPUT = By.id("username");
    public static final By PASSWORD_INFO_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");
    public static final By LOGIN_ERROR_MESSAGE = By.id("error");

    public static final String USER = "m.halimovsky-clu7@force.com";

    public static final String PASSWORD = "halimon21";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public LoginPage open() {
        driver.get("https://login.salesforce.com");
        return this; //возвращает эту страницу
    }

    @Step("Логинимся '{user}' с паролем '{password}'")

    public void login(String user, String password) {
        log.info("Логинимся '{user}' с паролем '{password}'");
        driver.findElement(USER_INFO_INPUT).sendKeys(USER);
        driver.findElement(PASSWORD_INFO_INPUT).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-truncate")));
    }

    @Step("Проверям произошел ли вход на сайт")
    public void checkLoginStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Account")));
    }

    @Step("Проверка на возможность входа при неверном '{user}")
    public void invalidUserInput(String user, String password) {
        driver.findElement(USER_INFO_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INFO_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Проверка на возможность входа при неверном '{password}")
    public void invalidPasswordInput(String user, String password) {
        driver.findElement(USER_INFO_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INFO_INPUT).sendKeys("password123");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(LOGIN_ERROR_MESSAGE).getText();
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }
}