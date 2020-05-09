package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;
import ui.pages.LayoutModalPage;
import ui.pages.SpecialOfferPage;
import ui.pages.WomenPage;

public class SpecialOfferTest extends TestHelper {

    @Test
    public void verifySpecialOffer(){

        new HomePage(driver).navigateToWomenPage();
        new WomenPage(driver).navigateToSpecialOfferPage();
        new SpecialOfferPage(driver).verifySpecialOfferPage();

        String actual = new SpecialOfferPage(driver).getProductName();
        verifyEquals("Failed","Printed Chiffon Dress",actual);

        String actualReference = new SpecialOfferPage(driver).getproductReference();
        verifyEquals("Failed","Model demo_7",actualReference);

        String actualQuantity = new SpecialOfferPage(driver).getQuantity();
        verifyEquals("Failed","Quantity",actualQuantity);

        String actualDataSheet = new SpecialOfferPage(driver).getCompositions();
        verifyEquals("Failed","Compositions",actualDataSheet);

        new SpecialOfferPage(driver).verifyAddToCartButton();
        String successMessage= new LayoutModalPage(driver).getSuccessMessage();
        verifyEquals("Failed","Product successfully added to your shopping cart",successMessage);

    }
}
