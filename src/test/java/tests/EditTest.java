package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import models.Account;
import models.Contact;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class EditTest extends BaseTest {

    @Test(priority = 1, description = "Create 'Account' and 'Contact'")
    @Description("'Account' and 'Contact' with correct data will be create")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void createAccount() {
        Account account = new Account("none", "+375291234567", "onliner.by", "10", "Berlin", "Nikolas", "minsk", "24000", "Germeny", "belarus", "525", "-", "125", "Minsk", "victory", "timiriaziva", "Should make fast delivery", "Partner", "Banking");
        Contact contact = new Contact("80172002233", "+3756679", "Mikola", "Mikoilian", "email@mail.com", "Contact", "Minsk", "Minsk", "Vitebsk", "Vitebsk", "113", "Belarus", "999", "Belarus", "none", "80176877877", "Banking", "911", "102", "Tanya", "first contact", "timiriazeva", "nezavisimosti", "Mr.", "Other");
        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openAccountPage()
                .createAccount()
                .isModalWindowAccountOpen()
                .createAccount(account)
                .clickModalWindowButton("Save");
        contactPage
                .openContactPage()
                .isContactPageOpened()
                .createContact()
                .createNewContact(contact)
                .chooseAccountName()
                .clickModalWindowButton("Save");
    }

    @Test(priority = 2, description = "Edit 'Account'")
    @Description("Edit some field in the Account")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void editAccount() {
        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        accountsPage
                .openAccountPage()
                .editAccount(0, "Edit")
                .editSelect("Industry", "Construction")
                .editInput("Account Name", "kakashka")
                .editSelect("Type", "Investor")
                .clickModalWindowButton("Save");

    }


    @Test(priority = 3, description = "Edit Contact")
    @Description("Edit some field in the 'Contact'")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void editContact() {
        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        contactPage
                .openContactPage()
                .isContactPageOpened()
                .editContact(0, "Edit")
                .editInput("Last Name", "Ktoto")
                .editInput("Phone", "+375290000000")
                .editInput("Mobile", "none")
                .editInput("Email", "google@mail.ru")
                .editInput("Title", "AQA Engineer")
                .editSelect("Salutation", "Prof.")
                .editSelect("Lead Source", "External Referral")
                .editTextArea("Other Street", "other street is absent, because new building is not build")
                .clickModalWindowButton("Save");
    }

    @Test(priority = 4, description = "Delete 'Accounts' and 'Contacts'")
    @Description("All 'Account' and 'Contact' will be delete")
    @Link("salesforce.com")
    @Issue("shim_nikolai")
    public void deleteAccountAndContact() {
        loginPage
                .openLoginPage()
                .login(USERNAME, PASSWORD)
                .isPageOpen();
        contactPage
                .openContactPage()
                .isContactPageOpened()
                .contactActions("Delete")
                .isModalWindowDeleteOpened()
                .clickCancelOrDeleteButton("Delete");
        accountsPage
                .openAccountPage()
                .accountActions("Delete")
                .isModalWindowDeleteOpened()
                .clickCancelOrDeleteButton("Delete");
    }
}
