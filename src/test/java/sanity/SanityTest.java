package sanity;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;

public class SanityTest extends TestHelper {
    @Test
    public void verifyEveningDressPageDisplay() {

        HomePage homePage = new HomePage(driver);
        homePage.openEveningDressPage();

        String actualMessage = homePage.getEveningDressesTitle();
        verifyEquals("Failed : Evening Dresses Title not matched","Evening Dresses",actualMessage);
    }
}
