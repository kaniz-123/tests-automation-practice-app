package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sanity.SanityTest;
import ui.helpers.PageHelper;

public class HomePage extends PageHelper {

    private By pageHeading = By.id("cart_title");
    private By womenTab = By.cssSelector("a[title='Women']");
    private By eveningDressTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a");
    private By casualDressesPageLink = By.cssSelector("a[title='Evening Dresses']");
    private By casualDressesText = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
    private By eveningDressesTitle = By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span");
    private By summeryText = By.xpath("//*[@id=\"order_step\"]/li[1]/span");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SanityTest openEveningDressPage() {
        mouseOver(womenTab);
        clickOnElement(eveningDressTab);
        return new SanityTest();
    }

    public String getEveningDressesTitle() {
        return getText(eveningDressesTitle);
    }

    public CasualDressesPage nevigateToCasualDressPage() {
        mouseOver(womenTab);
        clickOnElement(casualDressesPageLink);
        return new CasualDressesPage(driver);
    }

    public String getPageHeading() {
        return getText(pageHeading);
    }

    public CasualDressesPage navigateToWomenCasualDress() {
        mouseOver(womenTab);
        driver.findElement(casualDressesPageLink).click();
        getText(casualDressesText);
        return new CasualDressesPage(driver);
    }

    public String getSummeryText() {
        return getText(summeryText);
    }
}

