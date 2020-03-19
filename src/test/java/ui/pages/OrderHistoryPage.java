package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class OrderHistoryPage extends PageHelper {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    private By orderReferenceColumnHeadingField = By.xpath("//*[@id=\"order-list\"]/thead/tr/th[1]");
    private By dateField = By.cssSelector("#order-list > thead > tr > th:nth-child(2)");
    private By totalPriceField= By.cssSelector("[class='item footable-sortable'][data-hide='phone']");
    private By statusField = By.cssSelector("#order-list > thead > tr > th:nth-child(5)");


    public OrderHistoryPage verifyOrderHistoryTable(){
        getText(orderReferenceColumnHeadingField);
        getText(dateField);
        getText(totalPriceField);
        getText(statusField);
        return this;
    }

}
