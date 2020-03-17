package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ShoppingCartSummeryPage extends PageHelper {

    private By pageHeadingLocator = By.id("cart_title");
    private By productItemTableHeadingLocator = By.cssSelector("#cart_summary > thead > tr > th.cart_product.first_item");// By.name("cart_product first_item");
    private By descriptionTableHeadingLocator = By.xpath("//*[@id=\"cart_summary\"]/thead/tr/th[2]");
    private By unitPriceTableHeadingLocator = By.cssSelector("#cart_summary > thead > tr > th.cart_unit.item");
    private By quantityTableHeadingLocator = By.cssSelector("#cart_summary > thead > tr > th.cart_quantity.item");
    private By totalpriceLocator = By.cssSelector("#cart_summary > tfoot > tr:nth-child(7) > td.total_price_container.text-right > span");

    public ShoppingCartSummeryPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartSummeryPage verifyShoppingCart() {
        getText(pageHeadingLocator);
        getText(productItemTableHeadingLocator);
        getText(descriptionTableHeadingLocator);
        getText(unitPriceTableHeadingLocator);
        getText(quantityTableHeadingLocator);
        getText(totalpriceLocator);
        return this;
    }

}
