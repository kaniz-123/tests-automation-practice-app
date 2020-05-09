package ui.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

import java.util.List;

public class OrderHistoryTablePage extends PageHelper {
    public OrderHistoryTablePage(WebDriver driver) {
        super(driver);
    }
    private By orderHistoryTable = By.id("order-list");


      public List<String> getTheListOfOrderHistoryItem(){
        return getStringList(orderHistoryTable);
      }


}
