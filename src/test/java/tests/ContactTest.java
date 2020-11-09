package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import models.Account;
import models.Contact;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ContactTest extends BaseTest {

    @Test(description = "Create new 'Contact'")
    @Description("New 'Contact' will be create and 'Delete'")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void createContact() {
        Contact contact = new Contact("80172002233", "+3756679", "Mikola", "Mikoilian", "email@mail.com", "Contact", "Minsk", "Minsk", "Vitebsk", "Vitebsk", "113", "Belarus", "999", "Belarus", "none", "80176877877", "Banking", "911", "102", "Tanya", "first contact", "timiriazeva", "nezavisimosti", "Mr.", "Other");
        Account account = new Account("none", "+375291234567", "onliner.by", "10", "Berlin", "wladA4", "minsk", "24000", "Germeny", "belarus", "525", "-", "125", "Minsk", "victory", "timiriaziva", "Should make fast delivery", "Partner", "Banking");

        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openAccountPage()
                .createAccount()
                .createAccount(account)
                .isModalWindowAccountOpen()
                .clickModalWindowButton("Save");
        contactPage
                .openContactPage()
                .isContactPageOpened()
                .createContact()
                .isNewModalContactOpened()
                .createNewContact(contact)
                .chooseAccountName()
                .clickModalWindowButton("Save");
        contactPage
                .openContactPage()
                .isContactPageOpened()
                .contactActions("Delete")
                .isModalWindowDeleteOpened()
                .clickCancelOrDeleteButton("Delete");

    }

}
