package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class LayoutProductModalPage extends PageHelper {

    private By proceedToCheckoutLink = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private By productSuccessfullyAddedMessage = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");

    public LayoutProductModalPage(WebDriver driver) {
        super(driver);
    }

    public String getproductSuccessfullyAddedToCartMessage() {
        return getText(productSuccessfullyAddedMessage);
    }

    public ShoppingCartSummeryPage proceedToCheckout() {
        clickOnElement(proceedToCheckoutLink);
        return new ShoppingCartSummeryPage(driver);
    }

}
