package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;
import ui.pages.TShirtPage;

public class ViewItemDetailsTest extends TestHelper {
    @Test
    public void viewItemDetailsTest() {
        new HomePage(driver).navigateToTShirtsPage();
        new TShirtPage(driver).viewItemBeforeAddToCart();
    }
}
