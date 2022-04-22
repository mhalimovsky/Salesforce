package steps;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.NewAccountModal;

@Log4j2

public class AccountSteps {

    AccountListPage accountListPage;
    NewAccountModal newAccountModal;

    public AccountSteps(WebDriver driver) {
        accountListPage = new AccountListPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @Step("(Creation of account: '{account.accountName})")
    public void create(Account account) {
        log.info("(Creation of account: '{account.accountName})");
        accountListPage
                .open()
                .clickNewAccount()
                .createNewAccount(account)
                .save();
    }
}
