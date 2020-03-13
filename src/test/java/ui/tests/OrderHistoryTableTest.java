package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.AuthenticationPage;
import ui.pages.HomePage;
import ui.pages.MyAccountPage;

public class OrderHistoryTableTest extends TestHelper {
    @Test
    public void verifyUserShouldBeAbleToViewOrderHistory(){
        new HomePage(driver).navigateToMyOrderPage();
        new AuthenticationPage(driver).loginForm();
        new MyAccountPage(driver).orderHistoryDetails();
        //new MyOrderPage(driver).verifyOrderHistoryTable();
    }

}
