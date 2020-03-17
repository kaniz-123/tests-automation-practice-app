package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.CasualDressesPage;
import ui.pages.HomePage;
import ui.pages.ShoppingCartSummeryPage;

public class ShoppingCartSummaryTest extends TestHelper {

    @Test
    public void verifyShoppingCartSummery() {

        new HomePage(driver).navigateToWomenCasualDress();
        new CasualDressesPage(driver).addItemToCart();
        new ShoppingCartSummeryPage(driver).verifyShoppingCart();
    }
}