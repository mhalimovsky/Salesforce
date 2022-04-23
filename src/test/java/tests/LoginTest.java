package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Login with walid data")
    public void inputValidDataLogin() {
        loginPage
                .open()
                .login("m.halimovsky-clu7@force.com", "halimon21");

    }

    @Test(description = "Вход с некореетными данными поля 'user'")
    public void inputInvalidUserLogin() {
        loginPage
                .open()
                .invalidUserInput("TMS@mail.com", "halimon21");
        assertEquals(loginPage.getErrorMessage(), "Please check your username and password. " +
                "If you still can't log in, contact your Salesforce administrator.");

    }

    @Test(description = "Вход с некореетными данными поля 'password'")
    public void inputInvalidUserPassword() {
        loginPage
                .open()
                .invalidPasswordInput("TMS@mail.com", "halimon21");
        assertEquals(loginPage.getErrorMessage(), "Please check your username and password. " +
                "If you still can't log in, contact your Salesforce administrator.");
    }
}
