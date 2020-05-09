package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class SpecialOfferPage extends PageHelper {
    private By productTitle =By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
    private By moreButton = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default");
    private By productName = By.cssSelector("[itemprop='name']");
    private By referenceNumber = By.id("product_reference");
    private By compositionType = By.cssSelector(".table-data-sheet tr td");
    private By quantityFieldHeading = By.cssSelector("#quantity_wanted_p > label");
    private By sizeFieldHeading = By.xpath("//*[@id=\"attributes\"]/fieldset[1]/label");
    private By addToCartButton = By.id("add_to_cart");

    public SpecialOfferPage(WebDriver driver) {
        super(driver);
    }

    public SpecialOfferPage verifySpecialOfferPage(){
        mouseOver(productTitle);
        clickOnElement(moreButton);
       // clickOnElement(addToCartButton);
        return this;
    }
    public String getProductName(){
        return  getText(productName);
    }
    public String getproductReference(){
        return getText(referenceNumber);
    }

    public String getQuantity(){
        return getText(quantityFieldHeading);
    }

//    public String getSize() {
//        return getText(sizeFieldHeading);
//    }


    public String getCompositions(){
        scrollDownToTheElement(compositionType);
        return getText(compositionType);
    }
    public LayoutModalPage verifyAddToCartButton(){
        clickOnElement(addToCartButton);
        return  new LayoutModalPage(driver);
    }

}
