package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class HomePage extends PageHelper {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By womenTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private By eveningDressTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a");
    private By verifyStatusMessage = By.cssSelector(".cat-name");

    public HomePage mouseOverWomenTab() {
        mouseOver(womenTab);
        return this;
    }

    public HomePage openEveningDressPage() {
        clickOnElement(eveningDressTab);
        return this;
    }

    public String getHomePageMessage() {
        return getString(verifyStatusMessage);
    }

}
