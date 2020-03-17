package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class CasualDressesPage extends PageHelper {

    private By productSuccessfullyAddedMessage = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
    private By imageTab = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
    private By addToCartButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
    private By proceedToCheckOutButton = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private By totalProductTab = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[1]/strong");
    private By totalShippingTab = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[2]/strong");
    private By totalPriceTab = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]");

    public CasualDressesPage(WebDriver driver) {
        super(driver);
    }


    public ShoppingCartSummeryPage addItemToCart() {
        mouseOver(imageTab);
        clickOnElement(addToCartButton);
        getText(totalProductTab);
        getText(totalShippingTab);
        getText(totalPriceTab);
        clickOnElement(proceedToCheckOutButton);
        return new ShoppingCartSummeryPage(driver);
    }

//    public String verifySuccessMessage(){
//        return getText(productSuccessfullyAddedMessage);
//    }

}
