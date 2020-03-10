package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ShoppingCartSummeryPage extends PageHelper {

    private By orderDetailsField = By.xpath("//*[@class='cart_description item']");
    private By colorField = By.xpath("//*[@id=\"cart_summary\"]//tr//td//a");
    private By cartProductImage = By.xpath("//*[@id=\"product_3_13_0_0\"]//td");
    private By productName = By.xpath("//*[@id=\"product_3_13_0_0\"]//td//p");
    private By totalProductField = By.xpath("//*[@id=\"cart_summary\"]/tfoot/tr[1]/td[2]");
    private By totalShippingField = By.xpath("//*[@id=\"cart_summary\"]/tfoot/tr[3]/td[1]");
    private By taxField = By.xpath("//*[@id=\"cart_summary\"]/tfoot/tr[6]/td[1]");
    private By scrolldownProceedToCheckout = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");

    public ShoppingCartSummeryPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartSummeryPage viewProductDescription() {
        scrollDownToTheElement(scrolldownProceedToCheckout);
        getText(orderDetailsField);
        getText(colorField);
        getText(cartProductImage);
        getText(productName);

        return this;
    }

    public ShoppingCartSummeryPage verifyProductDescription() {
        getText(totalProductField);
        getText(totalShippingField);
        getText(taxField);
        return this;
    }

}
