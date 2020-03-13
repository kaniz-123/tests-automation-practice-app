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
    private By contactUsLink= By.cssSelector("[title='Contact Us']");
    private By successMessage = By.cssSelector("[class='alert alert-success']");
    private By myOrderLink = By.cssSelector("[title='My orders']");
    //private By myOrderLink = By.cssSelector("[title='Manage my customer account']");

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

    public ContactUsPage navigateToCustomerServicePage(){
        clickOnElement(contactUsLink);
        return new ContactUsPage(driver);
    }
    public String verifyContactUsSuccessMessage(){
        return getText(successMessage);
    }

    public AuthenticationPage navigateToMyOrderPage(){
        scrollDownToTheElement(myOrderLink);
        clickOnElement(myOrderLink);
        return new AuthenticationPage(driver);
    }
}

