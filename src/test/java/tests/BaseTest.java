package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    AccountListPage accountListPage;
    ContactListPage contactListPage;
    AccountSteps accountSteps;
    ContactSteps contactSteps;
    LoginSteps loginSteps;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;


    public static final String USER = "m.halimovsky-clu7@force.com";
    public static final String PASSWORD = "halimon21";

    @BeforeMethod(description = "Opening Browser")
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        context.setAttribute("driver", driver);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        accountListPage = new AccountListPage(driver);
        contactListPage = new ContactListPage(driver);
        accountSteps = new AccountSteps(driver);
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);

        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}