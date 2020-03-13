package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.CasualDressesPage;
import ui.pages.HomePage;
import ui.pages.LayoutProductModalPage;
import ui.pages.ShoppingCartSummeryPage;

public class ShoppingCartSummaryTest extends TestHelper {


    //   public void verifyUsersShouldBeAbleToViewShoppingSummery() {
//
//        new HomePage(driver).nevigateToCasualDressPage();
//        new CasualDressesPage(driver).addItemToCart();
//        new LayoutProductModalPage(driver).getproductSuccessfullyAddedToCartMessage();
//        String actualMessage = new LayoutProductModalPage(driver).getproductSuccessfullyAddedToCartMessage();
//        verifyEquals("Failed","Product successfully added to your shopping cart",actualMessage);
//        new LayoutProductModalPage(driver).proceedToCheckout();
//        new ShoppingCartSummeryPage(driver).viewProductDescription();
//        String actualStatusMessage = new HomePage(driver).getPageHeading();
//
//        verifyEquals("Failed : the get message is not matched", "Summery", actualStatusMessage);
//    }

    @Test
    public void verifyShoppingCartSummery() {

        new HomePage(driver).navigateToWomenCasualDress();
        new CasualDressesPage(driver).addItemToCart();
        new LayoutProductModalPage(driver).proceedToCheckout();
        new ShoppingCartSummeryPage(driver).verifyProductDescription();
        String actualMessage = new HomePage(driver).getSummeryText();

        verifyEquals("failed", "Summery", actualMessage);
    }

}