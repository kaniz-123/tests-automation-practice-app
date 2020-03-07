package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ShoppingCartPage extends PageHelper {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
     private By womenTab = By.xpath("//*[@id='block_top_menu']//li//a");
      private By casualDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a");
      private By mouseOverprintedDress = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
      private By clickAddToCart = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
      private By proceedToCheckOut= By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
      private By itemImage = By.xpath("//*[@id=\"product_3_13_0_0\"]/td[1]/a/img");
      private By description = By.xpath("//*[@id=\"product_3_13_0_0\"]/td[2]/p/a");
      private By getTotal = By.xpath("//*[@id=\"total_price_container\"]");
      private By summary = By.id("cart_title");

      public ShoppingCartPage viewAddedItemDescription(){
          mouseOver(womenTab);
          clickOnElement(casualDresses);
         mouseOver(mouseOverprintedDress);
         clickOnElement(clickAddToCart);
          clickOnElement(proceedToCheckOut);
           getText(description);

        return this;
      }
      public ShoppingCartPage verifyTotalAmount(){
        getText(summary);
        getText(getTotal);
        return this;
      }
//     public String getMessage(){
//         String text = getText(summary);
//         return text;
//     }

}
