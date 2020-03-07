package sanity;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;

public class SanityTest extends TestHelper {
    @Test
    public void verifyEveningDressPageDisplay() {
        String expectedMessage = "EVENING DRESS";
        HomePage homePage = new HomePage(driver);
        homePage.mouseOverWomenTab();
        homePage.openEveningDressPage();
        homePage.getHomePageMessage();

        String actualStatusMessage = homePage.getHomePageMessage();
        verifyTrue("Failed : Evening Dresses Message not matched", actualStatusMessage.contains(expectedMessage));
    }
}
