package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.ShoppingCartPage;

public class ShoppingCartSummaryTest extends TestHelper {

    @Test
    public void verifyUsersShouldBeAbleToViewShoppingSummery() {
        String expectedMessage = "SHOPPING-CART SUMMARY";
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.viewAddedItemDescription();
        shoppingCartPage.verifyTotalAmount();
      //  shoppingCartPage.getMessage();

//        String actualStatusMessage = ShoppingCartPage.getMessage();
//        verifyTrue("Failed : the get message is not matched", actualStatusMessage.contains(expectedMessage));
//    }

    }
}