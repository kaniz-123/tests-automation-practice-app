package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class LayoutModalPage extends PageHelper {

    private By successMessage = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");

    public LayoutModalPage(WebDriver driver) {
        super(driver);
    }
    public String getSuccessMessage(){
        return getText(successMessage);
    }
}
