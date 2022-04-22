package tests;

import dto.Contact;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest {

    @Test(description = "Create new contact")
    public void createNewContact() {
        loginSteps.login(USER, PASSWORD);
        contactListPage.open();
        contactListPage.clickNewContact();
        newContactModal.createNewContact(new Contact("Mr.","Mikhail", "Halimovsky ", " TMS", " Halimovsky@gmail.com", "111111 ", " Borisov"));
        newContactModal.save();
    }
}

