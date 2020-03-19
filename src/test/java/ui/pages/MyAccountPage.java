package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.helpers.PageHelper;


public class MyAccountPage extends PageHelper {

   private By orderHistoryLinkLacator =  By.cssSelector("a[title='Orders'] span");
    private By pageHeadingField = By.name("page-heading");
//
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public OrderHistoryPage navigateToOrderHistoryPage(){

        clickOnElement(orderHistoryLinkLacator);
        return new OrderHistoryPage(driver);
    }
}
