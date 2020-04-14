package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class TShirtPage extends PageHelper{

    private By productNameLocator = By.id("layer_cart_product_title");
    private By colorLacator = By.id("layer_cart_product_attributes");
    private By quantityLocator = By.id("layer_cart_product_quantity");
    private By totalPriceLocator = By.id("layer_cart_product_price");

    public TShirtPage(WebDriver driver) {
        super(driver);}

    public TShirtPage viewItemBeforeAddToCart(){
        getText(productNameLocator);
        getText(colorLacator);
        getText(quantityLocator);
        getText(totalPriceLocator);
        return this;
    }

}
