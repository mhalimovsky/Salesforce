package tests;

import dto.Account;
import org.testng.annotations.Test;

public class NewAccountTest extends BaseTest {

    @Test(description = "Create new Account")
    public void createNewAccount() {
        loginSteps.login(USER, PASSWORD);
        accountSteps.create(new Account("KAMAKO", "kamako.by", "Customer", "12345",
                "Apparel", "Borisov", "222550", "Borisov", "222560"));
        newAccountModal.save();

    }
}
