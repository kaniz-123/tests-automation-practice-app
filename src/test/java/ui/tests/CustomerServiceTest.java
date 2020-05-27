package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.CustomerServicePage;
import ui.pages.HomePage;

public class CustomerServiceTest extends TestHelper {
    @Test
    public void customerService(){
        new HomePage(driver).navigateToCustomerServicePage();
        new CustomerServicePage(driver).submitForm();
        String actualMessage = new HomePage(driver).verifyCustomerServiceSuccessMessage();
        verifyEquals("Failed","Your message has been successfully sent to our team.",actualMessage);
    }
}
