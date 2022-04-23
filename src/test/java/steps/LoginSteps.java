package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

@Log4j2

public class LoginSteps {

    LoginPage loginPage;
    MainPage mainPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Step("Login by '{user}' using password '{password}'")
    public void login(String user, String password) {
        log.info("Login by '{user}' using password '{password}'");
        loginPage
                .open()
                .isPageOpened()
                .login(user, password);
    }
}