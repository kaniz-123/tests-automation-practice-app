package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.ContactUsPage;
import ui.pages.HomePage;

public class ContactUsTest extends TestHelper {
    @Test
    public void verifyUserShouldBeAbleToSendMessage() {
        new HomePage(driver).navigateToCustomerServicePage();
        new ContactUsPage(driver).submitContactUsForm();
        String actualMessage = new HomePage(driver).verifyContactUsSuccessMessage();

        verifyEquals("Failed to submit the form.", "Your message has been successfully sent to our team.", actualMessage);
    }
}

