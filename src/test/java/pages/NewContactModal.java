package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;

@Log4j2

public class NewContactModal extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//" +
            "button[@name='SaveAndNew']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Input information new contact")
    public NewContactModal createNewContact(Contact contact) {
        log.info("Creation of contact", contact);
        new DropDown(driver, "Приветствие").selectContactInfo(contact.getGreeting());
        new Input(driver, "Личное_имя").inputContactInfo(contact.getFirstName());
        new Input(driver, "Фамилия").inputContactInfo(contact.getLastName());
        new Input(driver, "Имя организации").inputContactInfo(contact.getOrganization());
        new Input(driver, "Email").inputContactInfo(contact.getEmail());
        new Input(driver, "Мобильный_тел.").inputContactInfo(contact.getMobile());
        new Input(driver, "Город_в_почтовом_адресе").inputContactInfo(contact.getCity());
        return this;
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Override
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-var-p-right_x-small")));
        return this;
    }
}
